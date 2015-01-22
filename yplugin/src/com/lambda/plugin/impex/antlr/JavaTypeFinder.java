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
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.core.IPlatformInstallation;

public class JavaTypeFinder implements TypeFinder {

    private final Map<String, IType> typeCache = new HashMap<>();
    private final JavaFieldCollector fieldCollector = new JavaFieldCollector();

    public JavaTypeFinder() {
    }

    @Override
    public TypeDescription findBySimpleName(String typename) {
        IType type = getType(typename + "Model");
        return JavaTypeDescription.fromType(type, false, fieldCollector);
    }

    @Override
    public TypeDescription findType(final String name) {

        if (isEmptyOrJavaType(name)) {
            if (isCollection(name)) {
                String collectionTypeName = getCollectionTypeName(name);
                if (isEmptyOrJavaType(collectionTypeName)) {
                    return JavaTypeDescription.fromTypeName(name, true);
                }

                IType type = getType(name);
                return JavaTypeDescription.fromType(type, true, fieldCollector);

            }
            return JavaTypeDescription.fromTypeName(name, false);
        }

        IType type = getType(name);
        return JavaTypeDescription.fromType(type, false, fieldCollector);
    }

    private String getCollectionTypeName(String typename) {
        Pattern pattern = Pattern.compile(".*<(([a-zA-Z0-9\\.\\$]+))>$");
        Matcher matcher = pattern.matcher(typename);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return typename;
    }

    private boolean isEmptyOrJavaType(final String typename) {
        return typename == null || typename.startsWith("java.");
    }

    private static String simpleName(String name) {
        int index = name.lastIndexOf('.');
        if (index < 0) {
            return name;
        }
        String simpleTypeName = name.substring(index + 1);
        return simpleTypeName;
    }

    private IJavaProject getPlatformProject() {
        IPlatformInstallation platform = YPlugin.getDefault().getDefaultPlatform();
        String name = platform != null ? platform.getPlatformLocation().lastSegment().toString() : "platform";
        IJavaProject project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(name);
        return project;
    }

    private IType getType(final String typename) {
        // may be a full name including path
        String simplename = simpleName(typename);

        if (typeCache.containsKey(simplename)) {
            return typeCache.get(simplename);
        }
        IType type = searchType(simplename);
        typeCache.put(simplename, type);
        return type;
    }

    private IType searchType(final String typename) {
        SearchEngine engine = new SearchEngine();
        try {
            IJavaProject project = getPlatformProject();
            if (!project.exists()) {
                return null;
            }

            final Set<IType> types = new LinkedHashSet<>();
            IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project }, false);
            if (scope != null) {
                System.err.println("entered searchTypeHierarchy - find '" + typename + "'");
                long millis = System.currentTimeMillis();
                try {
                    TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                        @Override
                        public void acceptTypeNameMatch(final TypeNameMatch match) {
                            // TODO thread that feeds the list which is immediately returned
                            types.add(match.getType());
                        }
                    };
                    engine.searchAllTypeNames("de.hybris.platform*.model*".toCharArray(),
                            SearchPattern.R_PATTERN_MATCH, typename.toCharArray(), SearchPattern.R_EXACT_MATCH,
                            IJavaSearchConstants.CLASS, scope, nameMatchRequestor,
                            IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
                    if (!types.isEmpty()) {
                        return types.iterator().next();
                    }
                } finally {
                    millis = System.currentTimeMillis() - millis;
                    // int seconds = (int) (millis / 1000) % 60 ;
                    // int minutes = (int) ((millis / (1000*60)) % 60);
                    // millis = millis % 60;
                    // System.err.println("Took " + " millis (" + + ")");
                    System.err.println(String.format(
                            "Took %d:%d:%d",
                            TimeUnit.MILLISECONDS.toMinutes(millis),
                            TimeUnit.MILLISECONDS.toSeconds(millis)
                                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                            TimeUnit.MILLISECONDS.toMillis(millis)
                                    - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))));

                }
            }
        } catch (JavaModelException e) {
            YPlugin.logError(e);
        }
        return null;
    }

    private static boolean isCollection(String fullTypeName) {
        if (fullTypeName == null) {
            return false;
        }
        return fullTypeName.startsWith("java.util.Collection") || fullTypeName.startsWith("java.util.List")
                || fullTypeName.startsWith("java.util.Set");
    }
}
