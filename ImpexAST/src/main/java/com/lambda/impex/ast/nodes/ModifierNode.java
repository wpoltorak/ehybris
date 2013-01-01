package com.lambda.impex.ast.nodes;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.LocaleUtils;

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
                        if (LocaleUtils.toLocale(ensureCorrectCase(value)) == null) {
                            context.addError(ImpexError.InvalidLang);
                        }
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

    private String ensureCorrectCase(final String value) {
        final String[] split = value.split("_");
        String val = null;
        if (split.length > 1) {
            val = split[0].toLowerCase() + "_" + split[1].toUpperCase();
        }
        if (split.length > 2) {
            for (int i = 2; i < split.length; i++) {
                val += "_" + split[i];
            }
        }
        return val;
    }
}
