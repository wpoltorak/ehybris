package com.lambda.plugin.impex.antlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.lambda.impex.ast.TypeDescription;
import com.lambda.plugin.YCore;
import com.lambda.plugin.impex.antlr.JavaFieldCollector.Collected;

public class JavaTypeDescription implements TypeDescription {

    private boolean isAbstract;
    private boolean isCollection;
    private boolean isEnum;
    private boolean isDataModel;
    private boolean exists;
    private String name;
    private IType target;

    private final List<String> parents = new ArrayList<>();

    private final Map<String, String> fields = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private static final Pattern eCommercePattern = Pattern.compile("de\\.hybris\\.platform.*\\.model.*");
    private static final Pattern eCommerceEnumPattern = Pattern.compile("de\\.hybris\\.platform.*\\.enums.*");

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
    public boolean isEnum() {
        return isEnum;
    }

    @Override
    public boolean isDataModel() {
        return isDataModel;
    }

    @Override
    public boolean isChildOf(String supertype) {
        return parents.contains(supertype);
    }

    @Override
    public Set<String> getFields() {
        return fields.keySet();
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
    public boolean sameAs(String name) {
        return name.equalsIgnoreCase(getName());
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

    void addParent(String typename) {
        parents.add(typename);
    }

    void addField(String name, String type) {
        fields.put(name, type);
    }

    void addElements(Collected collected) {
        parents.addAll(collected.superClasses);
        fields.putAll(collected.fields);
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

        System.err.println("entered fromType - map '" + type.getElementName() + "'");
        long millis = System.currentTimeMillis();
        try {
            desc.exists = true;
            desc.isAbstract = isAbstract(type);
            desc.isCollection = isCollection;
            desc.isDataModel = isDataModel(type);
            // desc.isJaloModel = isJaloModel(type);
            desc.isEnum = isEnum(type);
            desc.name = type.getElementName();
            desc.target = type;
            if (desc.isDataModel) {
                fieldCollector.addFieldsAndSupertypes(desc, type);
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
        desc.isDataModel = isDataModel(fullTypeName);
        desc.isEnum = isEnum(fullTypeName);
        desc.name = fullTypeName;
        return desc;
    }

    private static boolean isAbstract(IType type) {
        try {
            return Flags.isAbstract(type.getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
            YCore.logError(e);
        }
        return false;
    }

    public static boolean isDataModel(IType type) {
        return isDataModel(type.getFullyQualifiedName());
    }

    public static boolean isDataModel(String typename) {
        if (typename == null) {
            return false;
        }
        Matcher m = eCommercePattern.matcher(typename);
        return m.matches();
    }

    public static boolean isEnum(IType type) {
        return isEnum(type.getFullyQualifiedName());
    }

    public static boolean isEnum(String typename) {
        if (typename == null) {
            return false;
        }
        Matcher m = eCommerceEnumPattern.matcher(typename);
        return m.matches();
    }
}
