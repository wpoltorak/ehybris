package com.lambda.plugin.impex.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.lambda.impex.ast.TypeDescription;
import com.lambda.plugin.YPlugin;

public class JavaTypeDescription implements TypeDescription {

    private boolean isAbstract;
    private boolean exists;
    private final List<String> children = new ArrayList<>();

    private final Map<String, TypeDescription> fields = new HashMap<>();

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public boolean isParentOf(String subtype) {
        return children.contains(subtype);
    }

    @Override
    public boolean containsField(String fieldName) {
        return fields.containsKey(fieldName);
    }

    @Override
    public TypeDescription getReturnType(String fieldName) {
        return fields.get(fieldName);
    }

    /**
     * This method assumes that base type is the first element in the given collection
     * 
     * @param types
     * @return
     */
    public static final JavaTypeDescription fromTypeHierarchy(Collection<IType> types) {
        if (types.isEmpty()) {
            return fromType(null);
        }

        Iterator<IType> iterator = types.iterator();
        JavaTypeDescription desc = fromType(iterator.next());

        while (iterator.hasNext()) {
            IType subtype = iterator.next();
            desc.children.add(subtype.getElementName());
        }
        return desc;
    }

    public static final JavaTypeDescription fromType(IType type) {
        JavaTypeDescription desc = new JavaTypeDescription();

        if (type == null) {
            return desc;
        }

        desc.exists = true;
        desc.isAbstract = isAbstract(type);

        IMethod[] methods = getMethods(type);
        for (IMethod method : methods) {
            String name = method.getElementName();
            if (name.startsWith("get") && isPublic(method)) {
                name = Character.toLowerCase(name.charAt(3)) + name.substring(3);
                IType methodType = method.getDeclaringType();
                String fullName = methodType.getFullyQualifiedName();
                System.out.println();
                // if (fullName is hybris model){
                // desc.fields.put(name, fromType(methodType));
                // } else {
                // desc.fields.put(name, fromType(methodType));
                // }
            }
        }

        return desc;
    }

    private static IMethod[] getMethods(IType basetype) {
        try {
            return basetype.getMethods();
        } catch (JavaModelException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return new IMethod[0];
    }

    private static boolean isPublic(IMethod method) {
        try {
            return Flags.isAbstract(method.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return false;
    }

    private static boolean isAbstract(IType type) {
        try {
            return Flags.isAbstract(type.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return false;
    }
}
