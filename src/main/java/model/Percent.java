package model;

import javax.persistence.*;

@Entity
@Table(name = "percent")
public class Percent {

    @Id
    @GeneratedValue
    @Column(name = "percent_id")
    private Long percent_id;

    @Column(name = "reachable_LLP")
    int reachableLLP;

    @Column(name = "reached_LLP")
    int reachedLLP;

    @OneToOne
    @JoinColumn(name = "score_id")
    private Score score;

    public Long getPercent_id() {
        return percent_id;
    }

    public void setPercent_id(Long id) {
        this.percent_id = id;
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
