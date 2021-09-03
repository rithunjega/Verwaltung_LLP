package Noten;

public class NoteModel {
    private String modulname;
    private String mt;
    private String atl;
    private String praesenz;
    private String prozent;

    public NoteModel(String modulname, String mt, String atl, String praesenz, String prozent) {
        this.modulname = modulname;
        this.mt = mt;
        this.atl = atl;
        this.praesenz = praesenz;
        this.prozent = prozent;
    }

    public NoteModel() {
    }

    public String getModulname() {
        return modulname;
    }

    public void setModulname(String modulname) {
        this.modulname = modulname;
    }

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getAtl() {
        return atl;
    }

    public void setAtl(String atl) {
        this.atl = atl;
    }

    public String getPraesenz() {
        return praesenz;
    }

    public void setPraesenz(String praesenz) {
        this.praesenz = praesenz;
    }

    public String getProzent() {
        return prozent;
    }

    public void setProzent(String string) {
        this.prozent = string;
    }

}