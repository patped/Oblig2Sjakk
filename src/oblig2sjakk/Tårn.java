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
    Posisjon nyPosisjon = new Posisjon(tilPosisjon);
    int x = posisjon.getKolonne();
    int y = posisjon.getRad();
    int x2 = nyPosisjon.getKolonne();
    int y2 = nyPosisjon.getRad();

    if (x2 < x) {
      int tmp = x;
      x = x2 + 1;
      x2 = tmp;
    } else {
      x2 -= 1;
    }

    if (y2 < y) {
      int tmp = y;
      y = y2 + 1;
      y2 = tmp;
    } else {
      y2 -= 1;
    }

    double a = (y2 - y) / (x2 - x);
    double b = y - a * x;

    for (int rad = 0; rad < brett.BRETTSTORRELSE; rad++) {
      for (int kolonne = 0; kolonne < brett.BRETTSTORRELSE; kolonne++) {
        if (brett.brikker[rad][kolonne] != null) {
          Posisjon p = brett.brikker[rad][kolonne].posisjon;
          if (p.getRad() == a * p.getKolonne() + b
              && p.getKolonne() + p.getRad() > x + y
              && p.getKolonne() + p.getRad() < x2 + y2) {
            System.out.println("heihei");
            return false;
          }
        }
      }
    }
    System.out.println(nyPosisjon.getRad());
    System.out.println(nyPosisjon.getKolonne());
    Brikke brikke = brett.brikker[nyPosisjon.getRad()][nyPosisjon.getKolonne()];
    return !(brikke != null && brikke.isFarge() == this.isFarge());
  }
}
