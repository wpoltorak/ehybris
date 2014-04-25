package com.lambda.plugin.impex.editor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ColorManager implements ISharedTextColors {

    private static ColorManager colorManager;
    protected Map<RGB, Color> colorTable = new HashMap<RGB, Color>(10);

    private ColorManager() {
    }

    public static ColorManager getDefault() {
        if (colorManager == null) {
            colorManager = new ColorManager();
        }
        return colorManager;
    }

    @Override
    public void dispose() {
        final Iterator<Color> e = colorTable.values().iterator();
        while (e.hasNext()) {
            e.next().dispose();
        }
    }

    @Override
    public Color getColor(final RGB rgb) {
        Color color = colorTable.get(rgb);
        if (color == null) {
            color = new Color(Display.getCurrent(), rgb);
            colorTable.put(rgb, color);
        }
        return color;
    }
}
