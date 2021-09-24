package application;

import noten.NoteModel;

public class ProzentCalculator {

    public ProzentCalculator() {
    }

    public static NoteModel calc(NoteModel noteModel) {

        int int_totalMT = Integer.parseInt(Parser.parse(noteModel.getMt()));
        int int_totalATL = Integer.parseInt(Parser.parse(noteModel.getAtl()));
        int int_totalPraesenz = Integer.parseInt(Parser.parse(noteModel.getPraesenz()));

        noteModel.getProzentObj().setErreichtLLP(int_totalMT + int_totalATL + int_totalPraesenz);

        int erreichtProzent = noteModel.getProzentObj().getErreichtLLP() * 100 / noteModel.getProzentObj().getVonLLP();
        System.out.println(erreichtProzent);

        noteModel.setProzent(noteModel.getProzentObj().getErreichtLLP() * 100 / noteModel.getProzentObj().getVonLLP() + "%");

        return noteModel;
    }
}
