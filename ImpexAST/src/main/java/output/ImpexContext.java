package output;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImpexContext {
    private final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros;
    private final Set<String> documentIDs;
    private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");

    public ImpexContext(final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros, final Set<String> documentIDs) {
        this.macros = macros;
        this.documentIDs = documentIDs;
    }

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros() {
        return macros;
    }

    Set<String> getDocumentIDs() {
        return documentIDs;
    }

    boolean hasDocumentID(final String documentID) {
        return documentIDs.contains(documentID);
    }

    String getMacroVal(final String macroDef, final int refLine) {
        final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
        if (list == null) {
            // TODO in case there is no such macro definition treat it as normal text and issue an error 
            return macroDef;
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            final SimpleImmutableEntry<Integer, String> entry = list.get(i);
            if (entry.getKey().intValue() < refLine) {
                String val = entry.getValue();
                final Matcher m = macroPattern.matcher(val);
                while (m.find()) {
                    final String nestedMacroDef = m.group();
                    final String nestedVal = getMacroVal(nestedMacroDef, entry.getKey());
                    val = m.replaceFirst(nestedVal);
                }
                return val;
            }
        }
        return macroDef;
    }
}
