package test;

import application.ProzentCalculator;
import noten.NoteModel;
import org.junit.jupiter.api.Test;
import prozent.Prozent;

import static org.junit.jupiter.api.Assertions.*;

class ProzentCalculatorTest {

    NoteModel noteModel = new NoteModel();


    @Test
    void testProzentCalculator() {
        noteModel.setId(1L);
        noteModel.setModulname("PF-A");
        noteModel.setMt("20");
        noteModel.setAtl("20");
        noteModel.setPraesenz("10");

        Prozent prozent = new Prozent();
        prozent.setVonLLP(100);

        noteModel.setProzentObj(prozent);

        ProzentCalculator.calc(noteModel);
        assertEquals("50%", noteModel.getProzent());
    }
}