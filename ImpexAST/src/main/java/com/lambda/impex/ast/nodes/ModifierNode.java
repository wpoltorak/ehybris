package com.lambda.impex.ast.nodes;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexError;
import com.lambda.impex.ast.ImpexParser;

public class ModifierNode implements IImpexNode {

    private final int type;
    private final String value;

    public ModifierNode(final int type, final String value) {
        this.type = type;
        this.value = value;
    }

    public void evaluate(final ImpexContext context) {
        switch (type) {
            case ImpexParser.AllowNull:
            case ImpexParser.BatchMode:
            case ImpexParser.CacheUnique:
            case ImpexParser.ForceWrite:
            case ImpexParser.IgnoreKeyCase:
            case ImpexParser.IgnoreNull:
            case ImpexParser.Unique:
            case ImpexParser.Virtual:
                if (!Boolean.TRUE.toString().equalsIgnoreCase(value) && !Boolean.FALSE.toString().equalsIgnoreCase(value)) {
                    context.addError(ImpexError.InvalidBoolean);
                }
                break;

            case ImpexParser.CellDecorator:
            case ImpexParser.Translator:
            case ImpexParser.Processor:

                break;

            case ImpexParser.Alias:
                break;
            case ImpexParser.CollectionDelimiter:
                break;
            case ImpexParser.Dateformat:
                try {
                    new SimpleDateFormat(value);
                } catch (final NullPointerException e) {

                    context.addError(ImpexError.InvalidDateFormat);
                } catch (final IllegalArgumentException e) {
                    context.addError(ImpexError.InvalidDateFormat);
                }
                break;
            case ImpexParser.NumberFormat:
                try {
                    new DecimalFormat(value);
                } catch (final NullPointerException e) {
                    context.addError(ImpexError.InvalidNumberFormat);
                } catch (final IllegalArgumentException e) {
                    context.addError(ImpexError.InvalidNumberFormat);
                }
                break;
            case ImpexParser.Default:
                break;
            case ImpexParser.KeyToValueDelimiter:
                break;
            case ImpexParser.Lang:
                try {
                    Long.parseLong(value);
                } catch (final NumberFormatException e) {
                    //is not a PK number so verify locale name
                    try {
                        toLocale(value);
                    } catch (final IllegalArgumentException ex) {
                        context.addError(ImpexError.InvalidLang);
                    }
                }
            case ImpexParser.MapDelimiter:
                break;
            case ImpexParser.Mode:
                if (!"append".equalsIgnoreCase(value) && !"remove".equalsIgnoreCase(value)) {
                    context.addError(ImpexError.InvalidMode);
                }
                break;
            case ImpexParser.PathDelimiter:

                break;
            case ImpexParser.Pos:
                try {
                    final Integer pos = Integer.valueOf(value);
                    if (pos.intValue() < 0) {
                        context.addError(ImpexError.InvalidPosition);
                    }
                } catch (final NumberFormatException e) {
                    context.addError(ImpexError.InvalidPosition);
                }
                break;
        }
    }

    private Locale toLocale(final String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid locale format: " + String.valueOf(str));
        }
        final int len = str.length();
        if (len != 2 && len != 5 && len < 7) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        final char ch0 = str.charAt(0);
        final char ch1 = str.charAt(1);
        if (!Character.isLetter(ch0) || !Character.isLetter(ch1)) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        if (len == 2) {
            return new Locale(str, "");
        } else {
            if (str.charAt(2) != '_') {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            final char ch3 = str.charAt(3);
            if (ch3 == '_') {
                return new Locale(str.substring(0, 2), "", str.substring(4));
            }
            final char ch4 = str.charAt(4);
            if (!Character.isLetter(ch3) || !Character.isLetter(ch4)) {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            if (len == 5) {
                return new Locale(str.substring(0, 2), str.substring(3, 5));
            } else {
                if (str.charAt(5) != '_') {
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
                return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
            }
        }
    }
}
