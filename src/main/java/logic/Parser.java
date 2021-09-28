package logic;

public class Parser {
    public Parser() {
    }

    /**
     * Der Parser erhält die eingegebenen Werte für MT, ATL und Prasenz mitgeteilt.
     * Die Werte können Kommas enthalten und sind deshalb als String definiert.
     * In dieser Methode werden die Werte vom String zusammengezählt und zurückgegeben.
     */
    public static String parse(String needToSplit) {
        String[] Array = needToSplit.split(",");
        int sum = 0;

        for(int i = 0; i < Array.length; ++i) {
            int x = Integer.parseInt(Array[i]);
            sum += x;
        }

        return String.valueOf(sum);
    }
}
