package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IType;
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

public class JavaTypeFinder implements TypeFinder {

    private final Map<String, Set<IType>> cache = new HashMap<>();
    private final JavaFieldCollector fieldCollector = new JavaFieldCollector();
    private final Set<String> abstracts = new HashSet<String>();
    {
        abstracts.add("Item");
        abstracts.add("GenericItem");
        abstracts.add("ExtensibleItem");
        abstracts.add("LocalizableItem");
    }

    public TypeDescription findFieldType(String fieldName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TypeDescription findType(final String typename) {

        if (isEmptyOrJavaType(typename)) {
            if (isCollection(typename)) {
                String collectionTypeName = getCollectionTypeName(typename);
                if (isEmptyOrJavaType(collectionTypeName)) {
                    return JavaTypeDescription.fromTypeName(typename, true);
                }
                Set<IType> types = getTypeHierarchy(typename);
                return JavaTypeDescription.fromTypeHierarchy(types, true, fieldCollector);

            }
            return JavaTypeDescription.fromTypeName(typename, false);
        }

        Set<IType> types = getTypeHierarchy(typename);
        return JavaTypeDescription.fromTypeHierarchy(types, false, fieldCollector);
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

    private Set<IType> getTypeHierarchy(final String typename) {
        // may be a full name including path
        String simplename = simpleName(typename);

        if (cache.containsKey(simplename)) {
            return cache.get(simplename);
        }
        Set<IType> types = searchHierarchy(simplename);
        cache.put(simplename, types);
        return types;
    }

    private Set<IType> searchHierarchy(String simplename) {
        if (abstracts.contains(simplename)) {
            return searchItemTypeHierarchy(simplename);
        }
        return searchTypeHierarchy(simplename);
    }

    private Set<IType> searchItemTypeHierarchy(final String typename) {
        SearchEngine engine = new SearchEngine();
        final Set<IType> types = new LinkedHashSet<>();

        try {
            IJavaSearchScope scope = YPlugin.getDefault().extensibleItemHierarchyScope();
            if (scope != null) {
                long millis = System.currentTimeMillis();
                try {
                    System.err.println("entered searchPlatformTypeHierarchy - '" + typename + "'");
                    TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                        @Override
                        public void acceptTypeNameMatch(final TypeNameMatch match) {
                            if (!match.getSimpleTypeName().startsWith("Generated")) {
                                types.add(match.getType());
                            }
                        }
                    };
                    engine.searchAllTypeNames("de.hybris.platform*.jalo*".toCharArray(), SearchPattern.R_PATTERN_MATCH,
                            null, SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.CLASS, scope, nameMatchRequestor,
                            IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
                } finally {
                    millis = System.currentTimeMillis() - millis;
                    System.out.println("found " + types.size());
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
        } finally {
            System.err.println();
        }
        return types;
    }

    private Set<IType> searchTypeHierarchy(final String typename) {
        SearchEngine engine = new SearchEngine();
        final Set<IType> types = new LinkedHashSet<>();
        try {
            IJavaSearchScope scope = YPlugin.getDefault().extensibleItemHierarchyScope();
            if (scope != null) {
                System.err.println("entered searchTypeHierarchy - find '" + typename + "'");
                long millis = System.currentTimeMillis();
                try {
                    TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                        @Override
                        public void acceptTypeNameMatch(final TypeNameMatch match) {
                            types.add(match.getType());
                        }
                    };
                    engine.searchAllTypeNames("de.hybris.platform*.jalo*".toCharArray(), SearchPattern.R_PATTERN_MATCH,
                            typename.toCharArray(), SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.CLASS, scope,
                            nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                            new NullProgressMonitor());
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
                if (!types.isEmpty()) {
                    try {
                        millis = System.currentTimeMillis();
                        System.err.println("entered searchTypeHierarchy - find '" + typename + "' hierarchy");
                        final IType type = types.iterator().next();
                        IJavaSearchScope typeScope = SearchEngine.createStrictHierarchyScope(null, type, true, false,
                                null);
                        TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                            @Override
                            public void acceptTypeNameMatch(final TypeNameMatch match) {
                                if (!match.getSimpleTypeName().startsWith("Generated")) {
                                    types.add(match.getType());
                                }
                            }
                        };
                        engine.searchAllTypeNames("de.hybris.platform*.jalo*".toCharArray(),
                                SearchPattern.R_PATTERN_MATCH, null, SearchPattern.R_PREFIX_MATCH,
                                IJavaSearchConstants.CLASS, typeScope, nameMatchRequestor,
                                IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
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
            }
        } catch (JavaModelException e) {
            YPlugin.logError(e);
        }
        return types;
    }

    private static boolean isCollection(String fullTypeName) {
        if (fullTypeName == null) {
            return false;
        }
        return fullTypeName.startsWith("java.util.Collection") || fullTypeName.startsWith("java.util.List")
                || fullTypeName.startsWith("java.util.Set");
    }
}
