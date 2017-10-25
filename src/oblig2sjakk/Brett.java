package oblig2sjakk;

class Brett {

    public final int BRETTSTORRELSE = 8;
    private int spillNr;
    protected final Brikke[][] brikker;

    public Brett(int nyttSpillNr) {
        this.brikker = new Brikke[BRETTSTORRELSE][BRETTSTORRELSE];
        this.spillNr = nyttSpillNr;
        this.fyllBrett();
    }

    private void fyllBrett() {
        // Fyller tabellen med brikker
        char kolChar;
        for (int rad = 0; rad < BRETTSTORRELSE; rad++) {
            for (int kolonne = 0; kolonne < BRETTSTORRELSE; kolonne++) {
                kolChar = (char) (kolonne + 97);
                if (rad == 0 && (kolonne == 0 || kolonne == 7)) {//Legger til svart tårn
                    brikker[kolonne][rad] = new Tårn(kolChar + Integer.toString(rad + 1), false, this);
                } else if (rad == 0 && kolonne == 4) {//Legger til Svart konge
                    brikker[kolonne][rad] = new Konge(kolChar + Integer.toString(rad + 1), false, this);
                } else if (rad == 1) { // Legger til Svarte bønder
                    brikker[kolonne][rad] = new Bonde(kolChar + Integer.toString(rad + 1), false, this);
                } else if (rad == 6) { //Legger til  hvite bønder
                    brikker[kolonne][rad] = new Bonde(kolChar + Integer.toString(rad + 1), true, this);
                } else if (rad == 7 && (kolonne == 0 || kolonne == 7)) { //Legger til hvite tårn
                    brikker[kolonne][rad] = new Tårn(kolChar + Integer.toString(rad + 1), true, this);
                } else if (rad == 7 && kolonne == 4) {//Legger til Hvit konge
                    brikker[kolonne][rad] = new Konge(kolChar + Integer.toString(rad + 1), true, this);
                } else {
                    brikker[kolonne][rad] = null;
                }
            }
        }
    }

    public boolean erLovligRutenavn(String rutenavn) {
        if (rutenavn.length() != 2) {
            return false;
        }
        if (rutenavn.charAt(0) > 96 && rutenavn.charAt(0) < 105) {
            if (rutenavn.charAt(1) > 47 && rutenavn.charAt(1) < 57) {
                return true;
            }
        }
        return false;
    }

    public Brikke getBrikke(String rutenavn) {
        Brikke brikke;
        char bokstav = rutenavn.charAt(0);
        char tall = rutenavn.charAt(1);
        brikke = brikker[bokstav - 97][((tall - 48) * -1) + 8];

        return brikke;

    }

    public boolean flyttBrikke(String fraRute, String tilRute) {
        if (erLovligRutenavn(fraRute) && erLovligRutenavn(tilRute)) {
            if (getBrikke(fraRute) == null) {
                System.out.println("brikke ikke eksisterer eller null");
                return false;
                
            } else {
                Brikke fraBrikke = getBrikke(fraRute);
                if (fraBrikke.flyttTil(tilRute)) {
                    System.out.println("Vi prøver å flytte brikke");
                    brikker[tilRute.charAt(0) - 97][(tilRute.charAt(1) - 48) * -1 + 8] = fraBrikke;
                    brikker[tilRute.charAt(0) - 97][(tilRute.charAt(1) - 48) * -1 + 8] = null;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}


/*public boolean erLovligTrekk(String rutenavn, Brikke[][] bTabell){
        String brikkepos = this.getPosisjon(); // Lagrer posisjonen
         
    }*/
