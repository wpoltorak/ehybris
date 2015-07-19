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

    private static final Pattern GENERIC_CLASS = Pattern.compile(".*<(([a-zA-Z0-9\\.\\$]+))>$");
    private final Map<String, IType> typeCache = new HashMap<>();
    private final JavaFieldCollector fieldCollector = new JavaFieldCollector();
    private IJavaSearchScope platformScope;
    private IJavaSearchScope workspaceScope;
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
            return getType(typename, jaloClasses.get(typename), true);
        }
        return getType(typename + "Model");
    }

    @Override
    public TypeDescription findType(final String name) {

        if (isCollection(name)) {
            String collectionTypeName = getCollectionTypeName(name);
            if (isEmptyOrJavaType(collectionTypeName)) {
                return JavaTypeDescription.fromTypeName(name, true);
            }
            IType type = getType(collectionTypeName);
            return JavaTypeDescription.fromType(type, true, fieldCollector);
        } else if (isEmptyOrJavaType(name)) {
            return JavaTypeDescription.fromTypeName(name, false);
        }

        IType type = getType(name);
        return JavaTypeDescription.fromType(type, false, fieldCollector);
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

    private IType getType(final String typename) {
        // may be a full name including path
        String[] arr = toNameAndPackage(typename);
        String classname = arr[0];
        String packagename = arr.length > 1 ? arr[1] : null;
        return getType(classname, packagename, false);
    }

    private IType getType(final String typename, final String packagename, boolean isJalo) {
        if (typeCache.containsKey(typename)) {
            return typeCache.get(typename);
        }
        final Set<IType> types = new LinkedHashSet<>();
        getType(typename, packagename, isJalo, types);
        IType type = types.isEmpty() ? null : types.iterator().next();
        typeCache.put(typename, type);
        return type;
    }

    private void getType(final String typename, final String packagename, boolean isJalo, final Set<IType> result) {
        TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
            @Override
            public void acceptTypeNameMatch(final TypeNameMatch match) {
                // TODO thread that feeds the list which is immediately returned
                System.out.println("found: " + match.getType().getElementName());
                result.add(match.getType());
            }
        };

        System.err.println("entered search" + (isJalo ? "Jalo" : "Model") + "Type - find '" + typename + "'");
        long millis = System.currentTimeMillis();
        try {
            if (isJalo) {
                searchJaloType(typename, packagename, SearchPattern.R_EXACT_MATCH, nameMatchRequestor);
            } else {
                searchModelType(typename, packagename, SearchPattern.R_EXACT_MATCH, nameMatchRequestor);
            }
        } finally {
            millis = System.currentTimeMillis() - millis;
            System.err.println(String.format(
                    "Took %d:%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes(millis),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                    TimeUnit.MILLISECONDS.toMillis(millis)
                            - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))));
        }

    }

    public void searchModelType(final String typename, final String packagename, int nameSearchPattern,
            TypeNameMatchRequestor nameMatchRequestor) {
        if (!getPlatformProject().exists()) {
            return;
        }

        try {
            SearchEngine engine = new SearchEngine();
            char[] pkgName = packagename != null ? packagename.toCharArray() : "de.hybris.platform*.model*"
                    .toCharArray();
            int packageSearchPattern = packagename != null ? SearchPattern.R_EXACT_MATCH
                    : SearchPattern.R_PATTERN_MATCH;
            boolean isEnum = JavaTypeDescription.isEnum(packagename);
            int searchFor = isEnum ? IJavaSearchConstants.CLASS_AND_ENUM : IJavaSearchConstants.CLASS;
            IJavaSearchScope scope = getPlatformScope();
            engine.searchAllTypeNames(pkgName, packageSearchPattern, typename.toCharArray(), nameSearchPattern,
                    searchFor, scope, nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                    new NullProgressMonitor());

        } catch (JavaModelException e) {
            YCore.logError(e);
        }
    }

    private void searchJaloType(final String typename, final String packagename, int nameSearchPattern,
            TypeNameMatchRequestor nameMatchRequestor) {
        if (!getPlatformProject().exists()) {
            return;
        }

        try {
            SearchEngine engine = new SearchEngine();
            char[] pkgName = packagename != null ? packagename.toCharArray() : "de.hybris.platform*.jalo*"
                    .toCharArray();
            int packageSearchPattern = packagename != null ? SearchPattern.R_EXACT_MATCH
                    : SearchPattern.R_PATTERN_MATCH;
            int searchFor = IJavaSearchConstants.CLASS;
            IJavaSearchScope scope = getPlatformScope();
            engine.searchAllTypeNames(pkgName, packageSearchPattern, typename.toCharArray(), nameSearchPattern,
                    searchFor, scope, nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                    new NullProgressMonitor());
        } catch (JavaModelException e) {
            YCore.logError(e);
        }
    }

    private IJavaSearchScope getWorkspaceScope() {
        if (workspaceScope == null) {
            workspaceScope = SearchEngine.createWorkspaceScope();
        }
        return workspaceScope;
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
            String name = platform != null ? platform.getPlatformLocation().lastSegment().toString() : "platform";
            project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(name);
        }
        return project;
    }

    private boolean isEmptyOrJavaType(final String typename) {
        return typename == null || typename.startsWith("java.") || isPrimitive(typename);
    }

    private boolean isPrimitive(String typename) {
        return "int".equals(typename) | "long".equals(typename) | "byte".equals(typename) | "short".equals(typename)
                | "boolean".equals(typename) | "char".equals(typename) | "float".equals(typename)
                | "double".equals(typename);
    }

    private static boolean isCollection(String fullTypeName) {
        if (fullTypeName == null) {
            return false;
        }
        return fullTypeName.startsWith("java.util.Collection") || fullTypeName.startsWith("java.util.List")
                || fullTypeName.startsWith("java.util.Set");
    }
}
