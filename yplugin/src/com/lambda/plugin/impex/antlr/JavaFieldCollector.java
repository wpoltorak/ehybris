package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

import com.lambda.plugin.YPlugin;

public class JavaFieldCollector {

    private final Map<String, Map<String, String>> cache = new HashMap<>();

    JavaFieldCollector() {
    }

    private static String returnType(IMethod method) {
        try {
            String signature = method.getReturnType();
            return Signature.getSignatureQualifier(signature) + "." + Signature.getSignatureSimpleName(signature);
        } catch (JavaModelException e) {
            // ok
        }
        return null;
    }

    private static IType[] getSupertypes(final IType type) throws CoreException {
        return type.newSupertypeHierarchy(new NullProgressMonitor()).getAllSuperclasses(type);
    }

    public void addFields(JavaTypeDescription desc, IType type) {
        try {
            String typename = type.getElementName();
            if (cache.containsKey(typename)) {
                desc.addFields(cache.get(typename));
            }

            IType[] supertypeOf = getSupertypes(type);
            Map<String, String> cachemap = new HashMap<>();
            for (IType supertype : supertypeOf) {
                if (supertype.getElementName().startsWith("Generated") || supertype.getElementName().equals("Item")) {
                    cachemap.putAll(addFieldsInternal(desc, supertype));
                }
            }
            cache.put(typename, cachemap);
        } catch (CoreException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
    }

    private Map<String, String> addFieldsInternal(JavaTypeDescription desc, IType type) throws JavaModelException {
        String typename = type.getElementName();
        if (cache.containsKey(typename)) {
            Map<String, String> fields = cache.get(typename);
            desc.addFields(fields);
            return fields;
        }

        Map<String, String> cachemap = new HashMap<>();
        try {
            IMethod[] allMethods = type.getMethods();
            for (IMethod method : allMethods) {
                if (method.getParameterTypes().length == 0 && isPublic(method)
                        && (method.getElementName().startsWith("get") || method.getElementName().startsWith("is"))) {
                    String name = method.getElementName();
                    // getXxx or isXxx
                    int prefix = name.startsWith("get") ? 3 : 2;
                    name = (Character.toLowerCase(name.charAt(prefix)) + name.substring(prefix + 1)).intern();
                    String returntypename = returnType(method);
                    if (returntypename != null) {
                        desc.addField(name, returntypename);
                        cachemap.put(name, returntypename);
                    }
                }
            }
        } finally {
            cache.put(typename, cachemap);
        }
        return cachemap;
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
}
