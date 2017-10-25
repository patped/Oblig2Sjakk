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
    
  }
}
