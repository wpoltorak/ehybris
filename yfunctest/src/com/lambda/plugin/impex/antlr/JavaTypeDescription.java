package com.lambda.plugin.impex.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

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
    private static final Pattern eCommercePattern = Pattern.compile("de\\.hybris\\.platform.*\\.jalo.*");

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

    void addField(String name, String type) {
        fields.put(name, type);
    }

    void addFields(Map<String, String> fields) {
        this.fields.putAll(fields);
    }

    /**
     * Creates type description based on the given type hierarchy This method assumes that base type is the first
     * element in the given collection
     * 
     * @param typehierarchy
     * @param fieldCollector
     * @param b
     * @return
     */
    public static final JavaTypeDescription fromTypeHierarchy(Collection<IType> typehierarchy, boolean isCollection,
            JavaFieldCollector fieldCollector) {
        if (typehierarchy.isEmpty()) {
            return fromType(null, isCollection, fieldCollector);
        }

        Iterator<IType> iterator = typehierarchy.iterator();
        JavaTypeDescription desc = fromType(iterator.next(), isCollection, fieldCollector);

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
    public static final JavaTypeDescription fromType(IType type, boolean isCollection, JavaFieldCollector fieldCollector) {
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
            fieldCollector.addFields(desc, type);
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

    private static boolean isAbstract(IType type) {
        try {
            return Flags.isAbstract(type.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
            YPlugin.logError(e);
        }
        return false;
    }

    public static boolean iseCommerceType(IType type) {
        return iseCommerceType(type.getFullyQualifiedName());
    }

    public static boolean iseCommerceType(String typename) {
        Matcher m = eCommercePattern.matcher(typename);
        return m.matches();
    }
}
