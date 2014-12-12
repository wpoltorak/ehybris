package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.Flags;
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

    public TypeDescription findFieldType(String fieldName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TypeDescription findType(final String typename) {

        if (isJavaType(typename)) {
            if (isCollection(typename)) {
                String collectionTypeName = getCollectionTypeName(typename);
                if (isJavaType(collectionTypeName)) {
                    return JavaTypeDescription.fromTypeName(typename, true);
                }
                Set<IType> types = getTypeHierarchy(typename);
                return JavaTypeDescription.fromTypeHierarchy(types, true);

            }
            return JavaTypeDescription.fromTypeName(typename, false);
        }

        Set<IType> types = getTypeHierarchy(typename);
        return JavaTypeDescription.fromTypeHierarchy(types, false);
    }

    private String getCollectionTypeName(String typename) {
        Pattern pattern = Pattern.compile(".*<(([a-zA-Z0-9\\.\\$]+))>$");
        Matcher matcher = pattern.matcher(typename);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return typename;
    }

    private boolean isJavaType(final String typename) {
        return typename == null || typename.startsWith("java.");
    }

    private Set<IType> getTypeHierarchy(final String typename) {
        if (cache.containsKey(typename)) {
            return cache.get(typename);
        }

        Set<IType> types = searchTypeHierarchy(typename);
        cache.put(typename, types);
        return types;
    }

    private Set<IType> searchTypeHierarchy(final String typename) {
        SearchEngine engine = new SearchEngine();
        final Set<IType> types = new LinkedHashSet<>();
        try {
            IJavaSearchScope scope = YPlugin.getDefault().extensibleItemHierarchyScope();
            if (scope != null) {
                TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                    @Override
                    public void acceptTypeNameMatch(final TypeNameMatch match) {
                        types.add(match.getType());
                    }
                };
                engine.searchAllTypeNames("de.hybris.platform*.jalo*".toCharArray(), SearchPattern.R_PATTERN_MATCH,
                        typename.toCharArray(), SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.CLASS, scope,
                        nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());

                if (!types.isEmpty()) {
                    final IType type = types.iterator().next();
                    IJavaSearchScope typeScope = SearchEngine.createStrictHierarchyScope(null, type, true, false, null);
                    nameMatchRequestor = new TypeNameMatchRequestor() {
                        @Override
                        public void acceptTypeNameMatch(final TypeNameMatch match) {
                            if (!match.getSimpleTypeName().startsWith("Generated") && !isAbstract(match.getType())) {
                                types.add(match.getType());
                            }
                        }
                    };
                    engine.searchAllTypeNames("de.hybris.platform*.jalo*".toCharArray(), SearchPattern.R_PATTERN_MATCH,
                            null, SearchPattern.R_PREFIX_MATCH, IJavaSearchConstants.CLASS, typeScope,
                            nameMatchRequestor, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH,
                            new NullProgressMonitor());
                }
            }
        } catch (JavaModelException e) {
            YPlugin.logError(e);
        }
        return types;
    }

    private static boolean isAbstract(IType type) {
        try {
            return Flags.isAbstract(type.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
        }
        return false;
    }

    private static boolean isCollection(String fullTypeName) {
        if (fullTypeName == null) {
            return false;
        }
        return fullTypeName.startsWith("java.util.Collection") || fullTypeName.startsWith("java.util.List")
                || fullTypeName.startsWith("java.util.Set");
    }
}
