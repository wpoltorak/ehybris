package com.lambda.impex.ast;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.apache.commons.io.FileUtils;

public abstract class AbstractLexerTest {

    protected List<Token> init(final String name) throws Exception {
        final File file = new File(getClass().getResource(name).getFile());
        if (!file.exists()) {
            throw new IllegalArgumentException("Unknown file name: " + name);
        }
        final String impex = FileUtils.readFileToString(file);
        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(impex));
        lexer.addErrorListener(new ANTLRErrorListener() {

            @Override
            public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line,
                    final int charPositionInLine, final String msg, final RecognitionException e) {
                throw new IllegalStateException(msg, e);
            }

            @Override
            public void reportContextSensitivity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                    final int prediction, final ATNConfigSet configs) {
                throw new IllegalStateException("Context sensitivity error between " + startIndex + " and " + stopIndex + ". Prediction "
                        + prediction);
            }

            @Override
            public void reportAttemptingFullContext(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                    final BitSet conflictingAlts, final ATNConfigSet configs) {
                throw new IllegalStateException("Attempting full context error between " + startIndex + " and " + stopIndex);
            }

            @Override
            public void reportAmbiguity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                    final boolean exact, final BitSet ambigAlts, final ATNConfigSet configs) {
                throw new IllegalStateException("Ambiguity error between " + startIndex + " and " + stopIndex);
            }
        });
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final List<Token> tokens = tokenStream.get(0, tokenStream.getNumberOfOnChannelTokens());
        return tokens;
    }

    protected Header header(final int mode, final String modeName, final String type, final Attribute[] attribs, final Modifiers[] modifiers) {
        return new Header(mode, modeName, type, attribs, modifiers);
    }

    protected Header header(final int mode, final String type, final Attribute[] attribs, final Modifiers[] modifiers) {
        return new Header(mode, type, attribs, modifiers);
    }

    protected Header header(final int mode, final String modeName, final String type, final Attribute[] attribs) {
        return new Header(mode, modeName, type, attribs);
    }

    protected Header header(final int mode, final String type, final Attribute[] attribs) {
        return new Header(mode, type, attribs);
    }

    protected Modifiers modifiers(final Modifier... modifier) {
        return new Modifiers(modifier);
    }

    protected Modifier modifier(final String name, final String value) {
        return new Modifier(name, value);
    }

    protected Attribute attribute(final Expression expression, final Modifiers... modifiers) {
        return new Attribute(expression, modifiers);
    }

    protected Expression expression(final String name, final Expression... expression) {
        return new Expression(null, name, expression);
    }

    protected Expression expression(final String subtype, final String name, final Expression... expression) {
        return new Expression(subtype, name, expression);
    }

    protected static void assertMacro(final List<Token> tokens, final int index, final String macrodef, final String macroval) {
        assertThat(tokens.get(index).getText(), is(macrodef));
        assertThat("Invalid value for " + macrodef, tokens.get(index + 1).getText(), is(macroval));
    }

    protected static void assertMacros(final List<Token> tokens, final Stack<String> macroPairs) {
        for (final Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
            final Token token = iterator.next();
            if (token.getType() == ImpexLexer.Macrodef) {
                final String macrodef = macroPairs.pop();
                assertThat(token.getText(), is(macrodef));
                assertThat("Invalid value for " + macrodef, iterator.next().getText(), is(macroPairs.pop()));
            }
        }
    }

    protected class Expression {
        protected final String name;
        protected final Expression[] expression;
        protected final String subtype;

        protected Expression(final String subtype, final String name, final Expression... expression) {
            this.subtype = subtype;
            this.name = name;
            this.expression = expression;
        }

        protected int assertTokens(final List<Token> tokens, final int index) {
            int pos = index;
            if (subtype != null) {
                assertThat(tokens.get(pos).getText(), is(subtype));
                pos++;
                assertThat(tokens.get(pos).getType(), is(ImpexLexer.Dot));
                pos++;
            }
            assertThat(tokens.get(pos).getText(), is(name));
            if (expression.length > 0) {
                pos++;
                assertThat(tokens.get(pos).getType(), is(ImpexLexer.LParenthesis));
                for (int i = 0; i < expression.length; i++) {
                    if (i > 0) {
                        pos++;
                        assertThat(tokens.get(pos).getType(), is(ImpexLexer.Comma));
                    }
                    pos++;
                    pos = expression[i].assertTokens(tokens, pos);
                }
                assertThat(tokens.get(++pos).getType(), is(ImpexLexer.RParenthesis));
            }
            return pos;
        }

        @Override
        public String toString() {
            String str = name;
            if (expression.length > 0) {
                str += "(";
                for (int i = 0; i < expression.length; i++) {
                    if (i > 0) {
                        str += ", ";
                    }
                    str += expression[i].toString();
                }
                str += ")";
            }
            return str;
        }
    }

    protected class Modifier {
        protected final String name;
        protected final String value;

        protected Modifier(final String name, final String value) {
            this.name = name;
            this.value = value;
        }

        protected int assertTokens(final List<Token> tokens, final int index) {
            int pos = index;
            assertThat(tokens.get(pos).getText(), is(name));
            pos++;
            assertThat(tokens.get(pos).getText(), is(value));
            return pos;
        }

        @Override
        public String toString() {
            return name + "=" + value;
        }
    }

    protected class Modifiers {
        protected final Modifier[] modifiers;

        protected Modifiers(final Modifier... modifiers) {
            this.modifiers = modifiers;
        }

        protected int assertTokens(final List<Token> tokens, final int index) {
            int pos = index;
            for (int i = 0; i < modifiers.length; i++) {
                if (i > 0) {
                    pos++;
                }
                pos = modifiers[i].assertTokens(tokens, pos);

            }
            return pos;
        }

        @Override
        public String toString() {
            String str = "[";
            for (int i = 0; i < modifiers.length; i++) {
                if (i > 0) {
                    str += ", ";
                }
                str += modifiers[i].toString();
            }
            str += "]";
            return str;
        }
    }

    protected class Attribute {
        protected final Modifiers[] modifiers;
        protected final Expression expression;

        public Attribute(final Expression expression) {
            this.expression = expression;
            this.modifiers = new Modifiers[0];
        }

        public Attribute(final Expression expression, final Modifiers[] modifiers) {
            this.expression = expression;
            this.modifiers = modifiers;
        }

        protected int assertTokens(final List<Token> tokens, final int index) {
            int pos = index;
            pos = expression.assertTokens(tokens, pos);
            for (int i = 0; i < modifiers.length; ++i) {
                pos++;
                pos = modifiers[i].assertTokens(tokens, pos);
            }
            return pos;
        }

        @Override
        public String toString() {
            String str = "; " + expression.toString();
            if (modifiers.length > 0) {
                for (int i = 0; i < modifiers.length; i++) {
                    str += modifiers[i].toString();
                }
            }
            return str;
        }
    }

    protected class Header {
        protected final int mode;
        protected final String modeName;
        protected final String type;
        protected final Attribute[] attribs;
        protected final Modifiers[] modifiers;

        public Header(final int mode, final String modeName, final String type, final Attribute[] attribs, final Modifiers[] modifiers) {
            this.mode = mode;
            this.modeName = modeName;
            this.type = type;
            this.attribs = attribs;
            this.modifiers = modifiers;
        }

        public Header(final int mode, final String modeName, final String type, final Attribute[] attribs) {
            this.mode = mode;
            this.modeName = modeName;
            this.type = type;
            this.attribs = attribs;
            this.modifiers = new Modifiers[0];
        }

        public Header(final int mode, final String type, final Attribute[] attribs, final Modifiers[] modifiers) {
            this.mode = mode;
            this.modeName = null;
            this.type = type;
            this.attribs = attribs;
            this.modifiers = modifiers;
        }

        public Header(final int mode, final String type, final Attribute[] attribs) {
            this.mode = mode;
            this.modeName = null;
            this.type = type;
            this.attribs = attribs;
            this.modifiers = new Modifiers[0];
        }

        /**
         * Checks header tokens. Returns next index after last token in header line - linebreak
         * 
         * @param tokens
         * @param index
         * @return
         */
        protected int assertTokens(final List<Token> tokens, final int index) {
            int pos = index;
            assertThat(tokens.get(pos).getType(), is(mode));
            if (modeName != null) {
                assertThat(tokens.get(pos).getText(), is(modeName));
            }
            pos++;
            assertThat(tokens.get(pos).getText(), is(type));
            for (int i = 0; i < modifiers.length; ++i) {
                pos++;
                pos = modifiers[i].assertTokens(tokens, pos);
            }
            for (final Attribute attrib : attribs) {
                pos++;
                assertThat(tokens.get(pos).getType(), is(ImpexLexer.Semicolon));//FIXME hardcoded semicolon  - should be retrieved from ant property
                if (attrib != null) {
                    pos++;
                    pos = attrib.assertTokens(tokens, pos);
                }
            }
            pos++;
            //if new line exists
            if (tokens.size() > pos) {
                assertThat(tokens.get(pos).getType(), is(ImpexLexer.Lb));
                pos++;
            }
            return pos;
        }

        @Override
        public String toString() {
            String str = mode() + " " + type;
            if (attribs.length > 0) {
                for (final Attribute attrib : attribs) {
                    str += attrib.toString();
                }
            }
            return str;
        }

        protected String mode() {
            switch (mode) {
                case ImpexLexer.InsertUpdate:
                    return "InsertUpdate";
                case ImpexLexer.Insert:
                    return "Insert";
                case ImpexLexer.Update:
                    return "Update";
                case ImpexLexer.Remove:
                    return "Remove";
            }
            throw new IllegalStateException("Unknown mode");
        }
    }
}
