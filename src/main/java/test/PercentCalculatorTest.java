package test;

import logic.PercentCalculator;
import model.Score;
import org.junit.jupiter.api.Test;
import model.Percent;

import static org.junit.jupiter.api.Assertions.*;

class PercentCalculatorTest {

    Score score = new Score();

    @Test
    void testProzentCalculator() {
        score.setScore_id(1L);
        score.setModulname("PF-A");
        score.setMt("20");
        score.setAtl("20");
        score.setPresence("10");

        Percent percent = new Percent();
        percent.setReachableLLP(100);

        score.setProzentObj(percent);

        PercentCalculator.calc(score);
        assertEquals("50%", score.getPercent());
    }
}