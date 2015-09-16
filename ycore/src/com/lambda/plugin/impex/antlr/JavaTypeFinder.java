package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;

import com.lambda.impex.ast.TypeDescription;
import com.lambda.impex.ast.TypeFinder;
import com.lambda.plugin.YCore;
import com.lambda.plugin.core.IPlatformInstallation;

//TODO add synchor
public class JavaTypeFinder implements TypeFinder {

    public static final int JALO_SEARCH = 1;
    public static final int MODEL_SEARCH = 2;
    public static final int ENUM_SEARCH = 4;

    private static final String JAVA_API_TYPE_PREFIX = "java.";
    private static final String MODEL_SUFFIX = "Model";
    private static final String JALO_SUFFIX = "Jalo";
    private static final String PLATFORM_PROJECT_NAME = "platform";
    private static final String PLATFORM_JALO_PACKAGE = "de.hybris.platform*.jalo*";
    private static final String PLATFORM_ENUM_PACKAGE = "*.enums*";
    private static final String PLATFORM_MODEL_PACKAGE = "*.model*";
    private static final Pattern GENERIC_CLASS = Pattern.compile(".*<(([a-zA-Z0-9\\.\\$]+))>$");
    private static final String[] PRIMITIVES = new String[] { "int", "long", "byte", "short", "boolean", "char",
            "float", "double", };
    private static final String[] COLLECTIONS = new String[] { "java.util.Collection", "java.util.List",
            "java.util.Set", };
    private final Map<String, IType> typeCache = new HashMap<>();
    private final JavaFieldCollector fieldCollector = new JavaFieldCollector();
    private IJavaSearchScope platformScope;
    private IJavaProject project;
    private final Map<String, String> jaloClasses = new HashMap<>();

    {
        jaloClasses.put("GenericItem", "de.hybris.platform.jalo");
    }

    public JavaTypeFinder() {
    }

    @Override
    public TypeDescription findBySimpleName(String typename) {
        IType type = findTypeBySimpleName(typename);
        return JavaTypeDescription.fromType(type, false, fieldCollector);
    }

    private IType findTypeBySimpleName(String typename) {
        if (jaloClasses.containsKey(typename)) {
            return getType(typename, jaloClasses.get(typename), JALO_SEARCH);
        }
        return getType(typename, MODEL_SEARCH | ENUM_SEARCH);
    }

    @Override
    public TypeDescription findType(final String name) {

        if (isCollection(name)) {
            String collectionTypeName = getCollectionTypeName(name);
            if (isEmptyOrJavaType(collectionTypeName)) {
                return JavaTypeDescription.fromTypeName(name, true);
            }
            IType type = getType(collectionTypeName, isModel(collectionTypeName) ? MODEL_SEARCH : ENUM_SEARCH);
            return JavaTypeDescription.fromType(type, true, fieldCollector);
        } else if (isEmptyOrJavaType(name)) {
            return JavaTypeDescription.fromTypeName(name, false);
        }

        IType type = getType(name, isModel(name) ? MODEL_SEARCH : ENUM_SEARCH);
        return JavaTypeDescription.fromType(type, false, fieldCollector);
    }

    private boolean isModel(String name) {
        return name.endsWith(MODEL_SUFFIX);
    }

    private String getCollectionTypeName(String typename) {
        Matcher matcher = GENERIC_CLASS.matcher(typename);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return typename;
    }

    private static String[] toNameAndPackage(String name) {
        int index = name.lastIndexOf('.');
        if (index < 0) {
            return new String[] { name };
        }

        return new String[] { name.substring(index + 1), name.substring(0, index) };
    }

    private IType getType(final String typename, int searchType) {
        // may be a full name including path
        String[] arr = toNameAndPackage(typename);
        String classname = arr[0];
        String packagename = arr.length > 1 ? arr[1] : null;
        return getType(classname, packagename, searchType);
    }

    private IType getType(final String typename, final String packagename, int searchType) {
        if (typeCache.containsKey(typename)) {
            return typeCache.get(typename);
        }
        final Set<IType> types = new LinkedHashSet<>();
        getType(typename, packagename, types, searchType);
        IType type = types.isEmpty() ? null : types.iterator().next();
        typeCache.put(typename, type);
        return type;
    }

    private void getType(final String typename, final String packagename, final Set<IType> result, int searchType) {
        TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
            @Override
            public void acceptTypeNameMatch(final TypeNameMatch match) {
                // TODO thread that feeds the list which is immediately returned
                System.out.println("found: " + match.getType().getElementName());
                result.add(match.getType());
            }
        };

        System.err.println("entered search" + decode(searchType) + "Type - find '" + typename + "'");
        long millis = System.currentTimeMillis();
        try {
            searchType(typename, packagename, SearchPattern.R_EXACT_MATCH, nameMatchRequestor, searchType);
        } finally {
            millis = System.currentTimeMillis() - millis;
            System.err.println(String.format("Took %d:%d:%d", TimeUnit.MILLISECONDS.toMinutes(millis),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                    TimeUnit.MILLISECONDS.toMillis(millis)
                            - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))));
        }

    }

    private String decode(int searchType) {
        String txt = "";
        if ((searchType & JALO_SEARCH) == JALO_SEARCH) {
            txt += " Jalo ";
        }
        if ((searchType & MODEL_SEARCH) == MODEL_SEARCH) {
            txt += " Model ";
        }
        if ((searchType & ENUM_SEARCH) == ENUM_SEARCH) {
            txt += " Enum ";
        }
        return txt;
    }

    public void searchType(final String typename, final String packagename, int nameSearchPattern,
            TypeNameMatchRequestor nameMatchRequestor, int searchType) {
        if (!getPlatformProject().exists()) {
            return;
        }

        try {
            SearchEngine engine = new SearchEngine();

            if ((searchType & JALO_SEARCH) == JALO_SEARCH) {
                char[] pkgName = packagename != null ? packagename.toCharArray() : PLATFORM_JALO_PACKAGE.toCharArray();
                int packageSearchPattern = packagename != null ? SearchPattern.R_EXACT_MATCH
                        : SearchPattern.R_PATTERN_MATCH;
                int searchFor = IJavaSearchConstants.CLASS;
                IJavaSearchScope scope = getPlatformScope();
                engine.searchAllTypeNames(pkgName, packageSearchPattern, typename.toCharArray(), nameSearchPattern,
                        searchFor, scope, nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                        new NullProgressMonitor());
            }

            if ((searchType & MODEL_SEARCH) == MODEL_SEARCH) {
                int searchFor = IJavaSearchConstants.CLASS;
                char[] pkgName = packagename != null ? packagename.toCharArray() : PLATFORM_MODEL_PACKAGE.toCharArray();
                int packageSearchPattern = packagename != null ? SearchPattern.R_EXACT_MATCH
                        : SearchPattern.R_PATTERN_MATCH;
                String name = nameSearchPattern == SearchPattern.R_EXACT_MATCH ? ensureSuffix(typename, MODEL_SUFFIX)
                        : typename;
                // String typename = packagename != null ? ensure
                IJavaSearchScope scope = getPlatformScope();
                engine.searchAllTypeNames(pkgName, packageSearchPattern, name.toCharArray(), nameSearchPattern,
                        searchFor, scope, nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                        new NullProgressMonitor());
            }
            if ((searchType & ENUM_SEARCH) == ENUM_SEARCH) {
                int searchFor = IJavaSearchConstants.CLASS;
                char[] pkgName = packagename != null ? packagename.toCharArray() : PLATFORM_ENUM_PACKAGE.toCharArray();
                int packageSearchPattern = packagename != null ? SearchPattern.R_EXACT_MATCH
                        : SearchPattern.R_PATTERN_MATCH;
                IJavaSearchScope scope = getPlatformScope();
                engine.searchAllTypeNames(pkgName, packageSearchPattern, typename.toCharArray(), nameSearchPattern,
                        searchFor, scope, nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                        new NullProgressMonitor());
            }

        } catch (JavaModelException e) {
            YCore.logError(e);
        }
    }

    private String ensureSuffix(String typename, String suffix) {
        return typename.endsWith(suffix) ? typename : typename + suffix;
    }

    private IJavaSearchScope getPlatformScope() {
        if (platformScope == null) {
            platformScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { getPlatformProject() }, false);
        }
        return platformScope;
    }

    private IJavaProject getPlatformProject() {
        if (project == null) {
            IPlatformInstallation platform = YCore.getDefault().getDefaultPlatform();
            String name = platform != null ? platform.getPlatformLocation().lastSegment().toString()
                    : PLATFORM_PROJECT_NAME;
            project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(name);
        }
        return project;
    }

    private boolean isEmptyOrJavaType(final String typename) {
        return typename == null || typename.startsWith(JAVA_API_TYPE_PREFIX) || isPrimitive(typename);
    }

    private static boolean isPrimitive(String typename) {
        for (String primitive : PRIMITIVES) {
            if (primitive.equals(typename)) {
                return true;
            }

        }
        return false;
    }

    private static boolean isCollection(String fullTypeName) {
        if (fullTypeName == null) {
            return false;
        }

        for (String collection : COLLECTIONS) {
            if (fullTypeName.startsWith(collection)) {
                return true;
            }
        }
        return false;
    }
}
