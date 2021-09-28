/**
 * Hier werden die einzelnen Score in einer ArrayListe eingetragen.
 * Diese Klasse wird nach dem Bugfix ORM nicht mehr verwendet.
 */

package model;

import java.util.ArrayList;

public class Scores {
    private ArrayList<Score> entries = new ArrayList();

    public Scores() {
    }

    public ArrayList<Score> getEntries() {
        return this.entries;
    }

    public void addEntry(Score scoresEntry) {
        this.entries.add(scoresEntry);
    }

    public void addEntries(ArrayList<Score> entries) {
        this.entries = entries;
    }

    public void removeEntry(Score notenEntry) {
        this.entries.remove(notenEntry);
    }

    public void removeEntries() {
        this.entries.removeAll(this.entries);
    }
}
