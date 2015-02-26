package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

import com.lambda.plugin.YPlugin;

public class JavaFieldCollector {

    private final Map<String, Collected> cache = new HashMap<>();
    private final Map<String, String> parameterTypeCache = new HashMap<>();

    JavaFieldCollector() {
    }

    private String type(IMethod method, IType type) {
        String signature = method.getParameterTypes()[0];
        if (parameterTypeCache.containsKey(signature)) {
            return parameterTypeCache.get(signature);
        }

        final String packagename = Signature.getSignatureQualifier(signature);
        final String typename = Signature.getSignatureSimpleName(signature);
        if (!"".equals(packagename)) {
            String fullname = packagename + "." + typename;
            parameterTypeCache.put(signature, fullname);
            return fullname;
        } else if (isPrimitive(typename)) {
            parameterTypeCache.put(signature, typename);
            return typename;
        }

        try {
            String[][] resolved = type.resolveType(typename);
            if (resolved != null && resolved.length > 0) {
                String[] result = resolved[0];
                if (result.length == 2) {
                    String fullname = result[0] + "." + typename;
                    parameterTypeCache.put(signature, fullname);
                    return fullname;
                }
            }
        } catch (Exception e) {
            YPlugin.logError(e);
        }
        parameterTypeCache.put(signature, typename);
        return typename;
    }

    // TODO load AbstractItemModel & ItemModel to cache at startup and don't load all supertypes but just

    private static IType[] getSupertypes(final IType type) throws CoreException {
        ITypeHierarchy supertypeHierarchy = type.newSupertypeHierarchy(new NullProgressMonitor());
        return supertypeHierarchy.getAllSuperclasses(type);
    }

    public void addFieldsAndSupertypes(JavaTypeDescription desc, IType type) {
        try {
            String typename = type.getElementName();

            if (cache.containsKey(typename)) {
                desc.addElements(cache.get(typename));
                return;
            }
            Collected incremental = new Collected();
            IType[] supertypeOf = getSupertypes(type);
            int length = supertypeOf.length - 2; // skip Object
            for (int i = length; i >= 0; i--) {
                IType supertype = supertypeOf[i];
                Collected collected = addFieldsInternal(desc, supertype);
                incremental.include(collected);
                cache.put(supertype.getElementName(), new Collected(incremental));
            }

            incremental.include(addFieldsInternal(desc, type));
            cache.put(typename, incremental);
        } catch (CoreException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
    }

    private Collected addFieldsInternal(JavaTypeDescription desc, IType type) throws JavaModelException {
        String typename = type.getElementName();
        if (cache.containsKey(typename)) {
            Collected collected = cache.get(typename);
            desc.addElements(collected);
            return collected;
        }

        Collected collected = new Collected();
        desc.addParent(typename);
        collected.superClasses.add(typename);
        IMethod[] allMethods = type.getMethods();
        for (IMethod method : allMethods) {
            if (isPublic(method) && method.getElementName().startsWith("set") && method.getParameterTypes().length == 1) {
                String name = method.getElementName();
                // setXxx
                name = (Character.toLowerCase(name.charAt(3)) + name.substring(4)).intern();
                String returntypename = type(method, type);
                if (returntypename != null) {
                    desc.addField(name, returntypename);
                    collected.fields.put(name, returntypename);
                }
            }
        }
        return collected;
    }

    private static boolean isPublic(IMethod method) {
        try {
            return Flags.isPublic(method.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return false;
    }

    class Collected {
        Map<String, String> fields = new HashMap<>();
        Set<String> superClasses = new HashSet<>();

        public Collected() {
        }

        public Collected(Collected collected) {
            superClasses.addAll(collected.superClasses);
            fields.putAll(collected.fields);
        }

        void include(Collected collected) {
            fields.putAll(collected.fields);
            superClasses.addAll(collected.superClasses);
        }
    }

    private static boolean isCollection(String fullTypeName) {
        if (fullTypeName == null) {
            return false;
        }
        return fullTypeName.startsWith("java.util.Collection") || fullTypeName.startsWith("java.util.List")
                || fullTypeName.startsWith("java.util.Set");
    }

    private boolean isPrimitive(String typename) {
        return "int".equals(typename) | "long".equals(typename) | "byte".equals(typename) | "short".equals(typename)
                | "boolean".equals(typename) | "char".equals(typename) | "float".equals(typename)
                | "double".equals(typename);
    }

}
