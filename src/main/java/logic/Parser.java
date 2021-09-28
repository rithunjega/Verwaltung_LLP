package logic;

public class Parser {
    public Parser() {
    }

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
