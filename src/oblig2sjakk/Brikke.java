package oblig2sjakk;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Brikke extends Rectangle {

  private int rad;
  private int kolonne;
  private boolean farge;
  protected Brett brett;
  final double lendge = 55;

  public Brikke(String posisjon, boolean farge, Brett brett) {
    rad = (posisjon.charAt(1) - 48) * -1 + 8;
    kolonne = (posisjon.charAt(1) - 97);
    this.farge = farge;
    this.setHeight(lendge);
    this.setWidth(lendge);
    this.setFill(Color.TRANSPARENT);
    this.brett = brett;
  }

  public int getRad() {
    return rad;
  }

  public int getKolonne() {
    return kolonne;
  }

  private void setPosisjon(String rutenavn) {
    rad = (rutenavn.charAt(1) - 48) * -1 + 8;
    kolonne = (rutenavn.charAt(1) - 97);    
  }

  public boolean isFarge() {
    return farge;
  }

  public abstract String brikkenavn();

  public boolean flyttTil(String rutenavn) {
    if (this.erLovligTrekk(rutenavn)) {
      System.out.println("er erLovlig trekk true? ");
      setPosisjon(rutenavn);
      return true;
    }
    return false;

  }

  public abstract boolean erLovligTrekk(String tilPosisjon);

}
