package test;

import logic.ProzentCalculator;
import model.Score;
import org.junit.jupiter.api.Test;
import model.Percent;

import static org.junit.jupiter.api.Assertions.*;

class ProzentCalculatorTest {

    Score score = new Score();


    @Test
    void testProzentCalculator() {
        score.setId(1L);
        score.setModulname("PF-A");
        score.setMt("20");
        score.setAtl("20");
        score.setPresence("10");

        Percent percent = new Percent();
        percent.setReachableLLP(100);

        score.setProzentObj(percent);

        ProzentCalculator.calc(score);
        assertEquals("50%", score.getPercent());
    }
}