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
    
    if (x2<x) {
      int tmp = x;
      x = x2;
      x2 = tmp;
    }
    
    if (y2<y) {
      int tmp = y;
      y = y2;
      y2 = tmp;
    }
    
    double a = (y2 - y) / (x2 - x);
    double b = y - a * x;
    
    for ()
    return p.y == a * p.x + b
        && p.x + p.y > x + y
        && p.x + p.y < x2 + y2;
  }
}
