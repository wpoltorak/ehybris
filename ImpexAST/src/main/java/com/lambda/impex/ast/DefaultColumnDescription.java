package com.lambda.impex.ast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DefaultColumnDescription implements ColumnDescription {

    //    private final TypeDescription type;
    private final TypeDescription owner;
    private final ColumnDescription parent;
    private String documentID;
    private boolean documentIDReference;
    private boolean documentIDDefinition;
    private final Map<String, TypeDescription> names = new LinkedHashMap<>();

    private String refRegex;
    private final List<ColumnDescription> children = new ArrayList<>();
    private TypeDescription type;

    public DefaultColumnDescription(final TypeDescription owner) {
        this.owner = owner;
        this.parent = null;
    }

    public DefaultColumnDescription(final ColumnDescription parent) {
        this.parent = parent;
        this.owner = parent.getType();
        this.parent.addChild(this);
    }

    public void addChild(final ColumnDescription columnDescription) {
        children.add(columnDescription);
    }

    //DocumentID, Integer, String, Boolean, Text, PK, Long, Complex

    public List<ColumnDescription> getChildren() {
        return children;
    }

    @Override
    public TypeDescription getOwner() {
        return owner;
    }

    @Override
    public TypeDescription getType() {
        return type;
    }

    @Override
    public void setType(final TypeDescription type) {
        this.type = type;
    }

    public ColumnDescription getParent() {
        return parent;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean isDocumentIDReferrence() {
        return documentIDReference;
    }

    public void setDocumentIDReference(final boolean documentIDReference) {
        this.documentIDReference = documentIDReference;
    }

    public boolean isDocumentIDDefinition() {
        return documentIDDefinition;
    }

    public void setDocumentIDDefinition(final boolean documentIDDefinition) {
        this.documentIDDefinition = documentIDDefinition;
    }

    private Pattern getRegex() {
        return Pattern.compile(refRegex);
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(final String documentID) {
        this.documentID = documentID;
    }

    public void addAttribute(final String name, final TypeDescription type) {
        names.put(name, type);
    }

    public void addAttribute(final String name) {
        names.put(name, owner);
    }
}