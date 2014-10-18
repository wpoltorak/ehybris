package com.lambda.plugin.impex.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.lambda.impex.ast.TypeDescription;

public class JavaTypeDescription implements TypeDescription {

    private boolean isAbstract;
    private boolean exists;
    private final List<String> children = new ArrayList<>();

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public boolean contains(String subtype) {
        return children.contains(subtype);
    }

    public static final TypeDescription fromTypes(Collection<IType> types) {
        JavaTypeDescription desc = new JavaTypeDescription();

        if (types.isEmpty()) {
            return desc;
        }
        desc.exists = true;

        Iterator<IType> iterator = types.iterator();
        try {
            desc.isAbstract = Flags.isAbstract(iterator.next().getFlags());
        } catch (JavaModelException e) {
            // ok, we don't care
        }

        while (iterator.hasNext()) {
            IType subtype = iterator.next();
            desc.children.add(subtype.getElementName());
        }
        return desc;
    }
}
