package model;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @Column(name = "score_id")
    private Long id;

    @Column(name = "modulname")
    private String modulname;

    @Column(name = "mt")
    private String mt;

    @Column(name = "atl")
    private String atl;

    @Column(name = "presence")
    private String presence;

    @Column(name = "percent")
    private String percent;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Percent percentObj;

    public Score(Long id, String modulname, String mt, String atl, String presence, String percent) {
        this.id = id;
        this.modulname = modulname;
        this.mt = mt;
        this.atl = atl;
        this.presence = presence;
        this.percent = percent;
    }

    public Score() {
    }

    public Score(Long id, String modulname, String mt, String atl, String presence, String percent, Percent percentObj) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPresence() {
        return presence;
    }

    public void setPresence(String praesenz) {
        this.presence = praesenz;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String string) {
        this.percent = string;
    }

    public Percent getProzentObj() { return percentObj; }

    public void setProzentObj(Percent percentObj) {
        this.percentObj = percentObj;
    }

}