package oblig2sjakk;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Brikke extends Rectangle {

  private Posisjon posisjon;
  private boolean farge;
  protected Brett brett;
  final double lendge = 55;

  public Brikke(String posisjon, boolean farge, Brett brett) {
    this.posisjon = new Posisjon(posisjon);
    this.farge = farge;
    this.setHeight(lendge);
    this.setWidth(lendge);
    this.setFill(Color.TRANSPARENT);
    this.brett = brett;
  }

  public boolean isFarge() {
    return farge;
  }

  public abstract String brikkenavn();

  public boolean flyttTil(String rutenavn) {
    if (this.erLovligTrekk(rutenavn)) {
      posisjon = new Posisjon(rutenavn);
      return true;
    }
    return false;

  }

  public abstract boolean erLovligTrekk(String tilPosisjon);

}
