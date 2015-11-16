package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.TreeMap;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import com.lambda.impex.ast.ImpexParser.MacroValueContext;
import com.lambda.impex.ast.ImpexProblem.Type;

public class DefaultImpexModel implements ImpexModel {

    private final Map<String, NavigableMap<Integer, String>> macros = new HashMap<>();

    private final List<ImpexProblem> problems = new ArrayList<>();

    private final Map<Integer, Object> offset2Type = new HashMap<>();

    private final Map<DocumentIDDescription, Map<Token, TypeDescription>> docIDRef2Type = new HashMap<>();
    private final Map<DocumentIDDescription, TypeDescription> docIDDef2Type = new HashMap<>();
    
    private Properties properties;

    public DefaultImpexModel() {
		properties = new Properties();
	}
    
    public DefaultImpexModel(Properties properties) {
		this.properties = properties;
	}
    
    @Override
    public void addProblem(final RecognitionException e) {
        final ImpexProblem error = new ImpexProblem(Type.GeneralSyntaxError);
        error.setText(e.getMessage());
        addProblem(error);
    }

    @Override
    public void syntaxProblem(final int line, final int startIndex, final String msg, final RecognitionException e) {
        if (!problems.isEmpty()) {
            final ImpexProblem last = problems.get(problems.size() - 1);
            if (last.getLineNumber() == line && last.getStopIndex() == startIndex && last.getType() == ImpexProblem.Type.SyntaxError) {
                last.setLength(last.getLength() + 1);
                last.setStopIndex(startIndex + 1);
                return;
            }
        }

        final ImpexProblem problem = new ImpexProblem(ImpexProblem.Type.SyntaxError);
        problem.setLineNumber(line);
        problem.setText(msg);
        problem.setStartIndex(startIndex);
        problem.setStopIndex(startIndex + 1);
        problem.setLength(1);
        addProblem(problem);
    }

    @Override
    public void syntaxProblem(final int line, final Token token, final String msg, final RecognitionException e) {
        final ImpexProblem problem = new ImpexProblem(ImpexProblem.Type.SyntaxError);
        problem.setLineNumber(line);
        problem.setText(msg);
        problem.setLength(token.getStopIndex() - token.getStartIndex() + 1);
        problem.setStartIndex(token.getStartIndex());
        problem.setStopIndex(token.getStopIndex());
        addProblem(problem);
    }

    @Override
    public void addProblem(final ImpexProblem problem) {
        problems.add(problem);
    }

    private void addProblem(final Token token, final Type type) {
        final ImpexProblem problem = new ImpexProblem(type);
        problem.setLineNumber(token.getLine());
        problem.setLength(token.getStopIndex() - token.getStartIndex() + 1);
        problem.setStartIndex(token.getStartIndex());
        problem.setStopIndex(token.getStopIndex());
        problem.setText(token.getText());
        addProblem(problem);
    }

    @Override
    public void addMacroValue(final String macrodefText, final Token macroDefiniton, final MacroValueContext macroValue) {
        addNavigableMapValue(macros, macrodefText, Integer.valueOf(macroDefiniton.getStartIndex()), macroValue.getText());
    }

    @Override
	public String getMacroValue(final String name, final int index) {
        final NavigableMap<Integer, String> map = macros.get(name);
        if (map == null) {
            return null;
        }
        return map.get(map.floorKey(index));
    }

    @Override
    public void addDocumentIDDefinitionQualifier(final DocumentIDDescription documentIDDescription, final TypeDescription type,
            final Token symbol) {
        final TypeDescription existing = docIDDef2Type.get(documentIDDescription);
        if (existing != null) {
            addProblem(symbol, Type.DuplicateDocumentID);
            return;
        }
        docIDDef2Type.put(documentIDDescription, type);
    }

    @Override
    public void addDocumentIDReferenceQualifier(final DocumentIDDescription documentIDDescription, final TypeDescription type,
            final Token symbol) {
        addMapValue(docIDRef2Type, documentIDDescription, symbol, type);
    }

    @Override
	public void checkDocumentIDs() {
        for (final Entry<DocumentIDDescription, Map<Token, TypeDescription>> entry : docIDRef2Type.entrySet()) {
            final DocumentIDDescription docid = entry.getKey();
            final TypeDescription type = docIDDef2Type.get(docid);

            for (final Entry<Token, TypeDescription> reftype : entry.getValue().entrySet()) {
                if (type == null) {
                    addProblem(reftype.getKey(), Type.InvalidDocumentID);
                } else if (!type.equals(reftype.getValue()) && !type.isChildOf(reftype.getValue().getName())) {
                    addProblem(reftype.getKey(), Type.InvalidDocumentIDTypeHierarchy);
                }
            }
        }
    }

    private <Key, ValueKey, Value> void addMapValue(final Map<Key, Map<ValueKey, Value>> map, final Key key, final ValueKey valueKey,
            final Value value) {
        Map<ValueKey, Value> values = map.get(key);
        if (values == null) {
            values = new HashMap<>();
            map.put(key, values);
        }
        values.put(valueKey, value);
    }

    private <Key, ValueKey, Value> void addNavigableMapValue(final Map<Key, NavigableMap<ValueKey, Value>> map, final Key key,
            final ValueKey valueKey, final Value value) {
        NavigableMap<ValueKey, Value> values = map.get(key);
        if (values == null) {
            values = new TreeMap<>();
            map.put(key, values);
        }
        values.put(valueKey, value);
    }

    @Override
    public void addType(int offset, Object type) {
        offset2Type.put(offset, type);
    }

    @Override
    public boolean hasProblems() {
        return !problems.isEmpty();
    }

    @Override
	public List<ImpexProblem> getProblems() {
        return problems;
    }

    @Override
	public Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros() {
        //        return macros;
        return null;
    }

    @Override
    public void reset() {
        macros.clear();
        problems.clear();
        offset2Type.clear();
        docIDRef2Type.clear();
        docIDDef2Type.clear();
    }

    @Override
    public Object getHyperlinkElement(final int tokenType, final int offset) {
        switch (tokenType) {
            case ImpexLexer.Type:
            case ImpexLexer.ClassAttributeModifier:
            case ImpexLexer.ClassHeaderModifier:
            	return offset2Type.get(offset);
            default:
                return null;
        }
    }
    
    @Override
    public boolean containsProperty(String text) {
    	return properties.containsKey(text);
    }
}
