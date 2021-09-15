package noten;

import prozent.Prozent;

import javax.persistence.*;

@Entity
@Table(name = "noten")
public class NoteModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "modulname")
    private String modulname;

    @Column(name = "mt")
    private String mt;

    @Column(name = "atl")
    private String atl;

    @Column(name = "praesenz")
    private String praesenz;

    @Column(name = "prozent")
    private String prozent;

    @OneToOne(cascade = CascadeType.ALL)
    private Prozent prozentObj;

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

    public Prozent getProzentObj() { return prozentObj; }

    public void setProzentObj(Prozent prozentObj) {
        this.prozentObj = prozentObj;
    }

}