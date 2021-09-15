package prozent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noten")
public class Prozent {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "erreichtLLP")
    int erreichtLLP;

    @Column(name = "vonLLP")
    int vonLLP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prozent(int erreichtLLP, int vonLLP) {
            this.erreichtLLP = erreichtLLP;
            this.vonLLP = vonLLP;
        }

        public Prozent() {
        }

        public int getErreichtLLP() {
            return this.erreichtLLP;
        }

        public void setErreichtLLP(int erreichtLLP) {
            this.erreichtLLP = erreichtLLP;
        }

        public int getVonLLP() {
            return this.vonLLP;
        }

        public void setVonLLP(int vonLLP) {
            this.vonLLP = vonLLP;
        }
}
