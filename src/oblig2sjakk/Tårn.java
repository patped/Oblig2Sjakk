package oblig2sjakk;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Tårn extends Brikke {

  private final String BOKSTAV = "t";

  public Tårn(String posisjon, boolean farge, Brett brett) {
    super(posisjon, farge, brett);
    if (farge == false) {
      this.setFill(new ImagePattern(new Image("/svarttårn.png")));
    } else {
      this.setFill(new ImagePattern(new Image("/hvittårn.png")));
    }
  }

  @Override
  public String brikkenavn() {
    return BOKSTAV;
  }

  @Override
  public boolean erLovligTrekk(String tilPosisjon) {
    System.out.println("Nå: Er lovlig trekk");
    boolean sjekker = true;
    int valgtBokstav = this.getPosisjon().charAt(0) - 97;
    System.out.println("valgtBokstav: " + valgtBokstav);
    int valgtTall = this.getPosisjon().charAt(1) - 49;
    System.out.println("valgtTall: " + valgtTall);
    int tilBokstav = tilPosisjon.charAt(0) - 97;
    System.out.println("tilBokstav: " + tilBokstav);
    int tilTall = (tilPosisjon.charAt(1) - 48) * -1 + 8;
    System.out.println("tilTall: " + tilTall);

    if (valgtBokstav == tilBokstav // Sjekker om den løper på samme bokstavrekke og at tallet er ulikt
        && valgtTall != tilTall) {
      if (valgtTall - tilTall < 0) {//Sjekker om tårnet kan løpe mellom de to plassene.
        for (int i = -1; i > valgtTall - tilTall; i--) {// Når den løper oppover på brettet.
          if (brett.brikker[valgtBokstav][valgtTall] != null) {
            sjekker = false;
          }
        }
      } else {
        for (int i = 1; i < valgtTall - tilTall; i++) {//Når den løper nedover på brettet.
          if (brett.brikker[valgtBokstav][valgtTall] != null) {
            sjekker = false;
          }
        }
      }
      if (sjekker == true && brett.brikker[tilBokstav][tilTall] == null) {
        return true;
      }
      System.out.println("Tester 1: " + (sjekker == true
          && brett.brikker[tilBokstav][tilTall].isFarge() != this.isFarge()));
      return (sjekker == true
          && brett.brikker[tilBokstav][tilTall].isFarge() != this.isFarge());

    }
    if (valgtBokstav != tilBokstav // Sjekker om den løper på samme tall og at bokstaven er ulikt
        && valgtTall == tilTall) {
      System.out.println("Går jeg inn i IF-testen Bokstav ulik bokstav + tall er lik tall");
      if (valgtBokstav - tilBokstav < 0) {//Sjekker om tårnet kan løpe mellom de to plassene.
        for (int i = -1; i > valgtBokstav - tilBokstav; i--) {// Når den løper mot høyre på brettet.
          if (brett.brikker[valgtBokstav - i][valgtTall] != null) {
            sjekker = false;
          }
        }
      } else {
        for (int i = 1; i < valgtBokstav - tilBokstav; i++) {// Når den løper oppover på brettet.
          if (brett.brikker[valgtBokstav - i][valgtTall] != null) {
            sjekker = false;
          }
        }
      }
      if (sjekker == true && brett.brikker[tilBokstav][tilTall] == null) {
        return true;
      }
      System.out.println("Nr 2: " + (sjekker == true
          && brett.brikker[tilBokstav][tilTall].isFarge() != this.isFarge()));
      return (sjekker == true
          && brett.brikker[tilBokstav][tilTall].isFarge() != this.isFarge());
    }
    System.out.println("Test 3: " + (valgtBokstav != tilBokstav // Sjekker om den løper på samme tall og at bokstaven er ulikt
        && valgtTall == tilTall));
    return false;
  }
}
