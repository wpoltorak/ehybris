import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;

public class Main {
    public static final String S = System.getProperty("line.separator");

    public static void main(final String[] args) throws Exception {
        // the input source  
        final String source1 = "#comment" + S + "# Import final Sample Customers" + S + "$regulargroup=regulargroup" + S
                + "$customergroup=customergroup" + S + "# final Create Customer Group" + S
                + "INSERT_UPDATE Usergroup;uid[unique=true];groups(uid)[mode=append]" + S + ";$regulargroup;customergroup";

        final String source = "$customergroup=customergroup";// + S + S + "INSERT_UPDATE Usergroup;uid[unique=true];groups(uid)[mode=append]"
        //                + S + ";$regulargroup;customergroup";

        // create an instance of the lexer  
        final impexLexer lexer = new impexLexer(new ANTLRStringStream(source));

        // wrap a token-stream around the lexer  
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        // traverse the tokens and print them to see if the correct tokens are created
        System.out.println("Tokens:");
        int n = 1;
        for (final Object o : tokens.getTokens()) {
            final CommonToken token = (CommonToken) o;
            System.out.println("token(" + n + ") = " + token.getText().replace("\n", "\\n"));
            n++;
        }
        // create the parser  
        //        final ImpexParser parser = new ImpexParser(tokens);
        //
        //        // invoke the entry point of our grammar  
        //        final ImpexParser.impex_return data = parser.impex();
        //
        //        // display the contents of the CSV source  
        //        for (int r = 0; r < data.size(); r++) {
        //            final List<String> row = data.get(r);
        //            for (int c = 0; c < row.size(); c++) {
        //                System.out.println("(row=" + (r + 1) + ",col=" + (c + 1) + ") = " + row.get(c));
        //            }
        //        }
    }
}
