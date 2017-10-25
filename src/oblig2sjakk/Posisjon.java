/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblig2sjakk;

/**
 *
 * @author patrick
 */
public class Posisjon {
  
  private int rad;
  private int kolonne;

  public Posisjon(String posisjon) {
    kolonne = (posisjon.charAt(0) - 97);
    rad = (posisjon.charAt(1) - 48) * -1 + 8;
  }

  public int getRad() {
    return rad;
  }
  
  public int getKolonne() {
    return kolonne;
  }
  
}
