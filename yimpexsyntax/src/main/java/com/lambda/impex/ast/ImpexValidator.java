package com.lambda.impex.ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lambda.impex.ast.ImpexParser.ImpexContext;

public class ImpexValidator {

    private ImpexContext impex;
    private final ImpexModel model;

    public ImpexValidator(final ImpexModel model) {
        this.model = model;
    }

    public void compile(final char[] source) {
        try {
            internalCompile(source);
        } catch (final RecognitionException e) {
            model.addProblem(e);
        }
    }

    protected void internalCompile(final char[] source) throws RecognitionException {
        final ImpexParserDefaultListener impexListener = new ImpexParserDefaultListener(model);
        final ImpexParserDefaultErrorListener errorListener = new ImpexParserDefaultErrorListener(model);

        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(source, source.length));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        impex = parser.impex();

        if (!model.hasProblems()) {
            final ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(impexListener, impex);
        }
    }

    protected ParseTree getNthChildWithType(final ParseTree tree, final int n, final int type) {
        int index = 0;
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                if (index == n) {
                    return child;
                }
                index++;
            }
        }
        throw new IllegalStateException("No nth child found of type: " + type + ", n: " + n);
    }

    protected List<ParseTree> getChildrenWithType(final ParseTree tree, final int type) {
        final List<ParseTree> list = new ArrayList<ParseTree>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                list.add(child);
            }
        }
        return list;
    }

    protected ParseTree getFirstChildWithType(final ParseTree tree, final int type) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                return child;
            }
        }
        return null;
    }

    protected boolean matchesType(final ParseTree child, final int type) {
        if (child instanceof RuleNode) {
            final RuleNode rule = (RuleNode) child;
            return rule.getRuleContext().getRuleIndex() == type;
        } else if (child instanceof TerminalNode) {
            final TerminalNode terminal = (TerminalNode) child;
            return terminal.getSymbol().getType() == type;
        }
        return false;
    }

    public List<ParseTree> blocks() {
        return getChildrenWithType(impex, ImpexParser.RULE_block);
    }

    public ImpexModel getModel() {
        return model;
    }

    public ParseTree getParseTree() {
        return impex;
    }
}
