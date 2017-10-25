package oblig2sjakk;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bonde extends Brikke {

  private final String BOKSTAV = "b";

  public Bonde(String posisjon, boolean farge, Brett brett) {
    super(posisjon, farge, brett);
    if (farge == false) {
      this.setFill(new ImagePattern(new Image("/svartbonde.png")));
    } else {
      this.setFill(new ImagePattern(new Image("/hvitbonde.png")));
    }
  }

  public Bonde(int kolonne, int rad, boolean farge, Brett brett) {
    super(kolonne, rad, farge, brett);
    if (farge == false) {
      this.setFill(new ImagePattern(new Image("/svartbonde.png")));
    } else {
      this.setFill(new ImagePattern(new Image("/hvitbonde.png")));
    }
  }

  @Override
  public String brikkenavn() {
    return BOKSTAV;
  }

  @Override
  public boolean erLovligTrekk(String tilPosisjon) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
