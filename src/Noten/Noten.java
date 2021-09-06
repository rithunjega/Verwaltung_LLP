package Noten;

import java.util.ArrayList;

public class Noten {
    private ArrayList<NoteModel> entries = new ArrayList();

    public Noten() {
    }

    public ArrayList<NoteModel> getEntries() {
        return this.entries;
    }

    public void addEntry(NoteModel notenEntry) {
        this.entries.add(notenEntry);
    }

    public void addEntries(ArrayList<NoteModel> entries) {
        this.entries = entries;
    }

    public void removeEntry(NoteModel notenEntry) {
        this.entries.remove(notenEntry);
    }

    public void removeEntries() {
        this.entries.removeAll(this.entries);
    }
}
