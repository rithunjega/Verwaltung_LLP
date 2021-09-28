package logic;

import model.Score;

public class ProzentCalculator {

    public ProzentCalculator() {
    }

    public static Score calc(Score score) {

        int int_totalMT = Integer.parseInt(Parser.parse(score.getMt()));
        int int_totalATL = Integer.parseInt(Parser.parse(score.getAtl()));
        int int_totalPraesenz = Integer.parseInt(Parser.parse(score.getPresence()));

        score.getProzentObj().setReachedLLP(int_totalMT + int_totalATL + int_totalPraesenz);

        int erreichtProzent = score.getProzentObj().getReachedLLP() * 100 / score.getProzentObj().getReachableLLP();
        System.out.println(erreichtProzent);

        score.setPercent(score.getProzentObj().getReachedLLP() * 100 / score.getProzentObj().getReachableLLP() + "%");

        return score;
    }
}
