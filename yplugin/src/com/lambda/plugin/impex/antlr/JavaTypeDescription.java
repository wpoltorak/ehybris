package com.lambda.plugin.impex.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

import com.lambda.impex.ast.TypeDescription;
import com.lambda.plugin.YPlugin;

public class JavaTypeDescription implements TypeDescription {

    private boolean isAbstract;
    private boolean isCollection;
    private boolean eCommerce;
    private boolean exists;
    private String name;
    private Object target;

    private final List<String> children = new ArrayList<>();

    private final Map<String, String> fields = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public boolean isCollection() {
        return isCollection;
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
    public String getReturnType(String fieldName) {
        return fields.get(fieldName);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public boolean iseCommerce() {
        return eCommerce;
    }

    @Override
    public boolean sameAs(String name) {
        return name.equals(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JavaTypeDescription)) {
            return false;
        }
        return sameAs(((JavaTypeDescription) obj).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private void addField(String name, String type) {
        fields.put(name, type);
    }

    /**
     * Creates type description based on the given type hierarchy This method assumes that base type is the first
     * element in the given collection
     * 
     * @param typehierarchy
     * @param b
     * @return
     */
    public static final JavaTypeDescription fromTypeHierarchy(Collection<IType> typehierarchy, boolean isCollection) {
        if (typehierarchy.isEmpty()) {
            return fromType(null, isCollection);
        }

        Iterator<IType> iterator = typehierarchy.iterator();
        JavaTypeDescription desc = fromType(iterator.next(), isCollection);

        while (iterator.hasNext()) {
            IType subtype = iterator.next();
            desc.children.add(subtype.getElementName());
        }
        return desc;
    }

    /**
     * Creates type description based on the given type
     * 
     * @param type
     * @param isCollection2
     * @return
     */
    public static final JavaTypeDescription fromType(IType type, boolean isCollection) {
        JavaTypeDescription desc = new JavaTypeDescription();

        if (type == null) {
            return desc;
        }

        desc.exists = true;
        desc.isAbstract = isAbstract(type);
        desc.isCollection = isCollection;
        desc.eCommerce = iseCommerceType(type);
        desc.name = type.getElementName();
        desc.target = type;
        if (desc.eCommerce) {
            addFields(desc, type);
        }
        return desc;
    }

    /**
     * Creates type description based o the given full type name
     * 
     * @param fullTypeName
     * @return
     */
    public static final JavaTypeDescription fromTypeName(String fullTypeName, boolean isCollection) {
        JavaTypeDescription desc = new JavaTypeDescription();

        if (fullTypeName == null) {
            return desc;
        }

        desc.exists = true;
        desc.isAbstract = false;
        desc.isCollection = isCollection;
        desc.eCommerce = iseCommerceType(fullTypeName);
        desc.name = fullTypeName;
        return desc;
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

    private static Set<IMethod> addFields(JavaTypeDescription desc, IType type) {
        Set<IMethod> methods = new LinkedHashSet<>();
        try {
            IType[] supertypeOf = getSupertypes(type);
            for (IType supertype : supertypeOf) {
                if (supertype.getElementName().startsWith("Generated") || supertype.getElementName().equals("Item")) {
                    addFields(desc, methods, supertype.getMethods());
                }
            }

        } catch (CoreException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return methods;
    }

    private static void addFields(JavaTypeDescription desc, Set<IMethod> methods, IMethod[] allMethods) {
        for (IMethod method : allMethods) {
            if (method.getParameterTypes().length == 0 && isPublic(method)
                    && (method.getElementName().startsWith("get") || method.getElementName().startsWith("is"))) {
                methods.add(method);
                String name = method.getElementName();
                // getXxx or isXxx
                int prefix = name.startsWith("get") ? 3 : 2;
                name = (Character.toLowerCase(name.charAt(prefix)) + name.substring(prefix + 1)).intern();
                String typename = returnType(method);
                if (typename != null) {
                    desc.addField(name, typename);
                }
            }
        }
    }

    public static IType[] getSupertypes(final IType type) throws CoreException {
        return type.newSupertypeHierarchy(new NullProgressMonitor()).getAllSuperclasses(type);
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

    private static boolean isAbstract(IType type) {
        try {
            return Flags.isAbstract(type.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return false;
    }

    private static boolean iseCommerceType(IType type) {
        return iseCommerceType(type.getFullyQualifiedName());
    }

    private static boolean iseCommerceType(String typename) {
        return Pattern.matches("de\\.hybris\\.platform.*\\.jalo.*", typename);
    }

}
