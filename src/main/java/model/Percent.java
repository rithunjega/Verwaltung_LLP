package model;

import javax.persistence.*;

@Entity
@Table(name = "prozent")
public class Percent {

    @Id
    @Column(name = "prozent_id")
    private Long id;

    @Column(name = "reachable_LLP")
    int reachableLLP;

    @Column(name = "reached_LLP")
    int reachedLLP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Percent(int reachedLLP, int reachableLLP) {
            this.reachedLLP = reachedLLP;
            this.reachableLLP = reachableLLP;
        }

        public Percent() {
        }

        public int getReachedLLP() {
            return this.reachedLLP;
        }

        public void setReachedLLP(int erreichtLLP) {
            this.reachedLLP = erreichtLLP;
        }

        public int getReachableLLP() {
            return this.reachableLLP;
        }

        public void setReachableLLP(int vonLLP) {
            this.reachableLLP = vonLLP;
        }
}
