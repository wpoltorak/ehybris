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

    private static String type(IMethod method) {
        String signature = method.getParameterTypes()[0];
        return Signature.toString(signature);
    }

    // TODO load AbstractItemModel & ItemModel to cache at startup and don't load all supertypes but just

    private static IType[] getSupertypes(final IType type) throws CoreException {
        return type.newSupertypeHierarchy(new NullProgressMonitor()).getAllSuperclasses(type);
    }

    public void addFieldsAndSupertypes(JavaTypeDescription desc, IType type) {
        try {
            String typename = type.getElementName();
            desc.addParent(typename);
            if (cache.containsKey(typename)) {
                desc.addFields(cache.get(typename));
            }
            Map<String, String> cachemap = new HashMap<>();
            cachemap.putAll(addFieldsInternal(desc, type));
            IType[] supertypeOf = getSupertypes(type);
            for (IType supertype : supertypeOf) {
                if (skip(supertype)) {
                    continue;
                }
                cachemap.putAll(addFieldsInternal(desc, supertype));
            }
            cache.put(typename, cachemap);
        } catch (CoreException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
    }

    private boolean skip(IType supertype) {
        return "java.lang.Object".equals(supertype.getFullyQualifiedName());
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
                if (isPublic(method) && method.getElementName().startsWith("set")
                        && method.getParameterTypes().length == 1) {
                    String name = method.getElementName();
                    // setXxx
                    name = (Character.toLowerCase(name.charAt(3)) + name.substring(4)).intern();
                    String returntypename = type(method);
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
