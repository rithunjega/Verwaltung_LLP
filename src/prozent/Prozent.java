package prozent;

public class Prozent {

        int erreichtLLP;
        int vonLLP;

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
