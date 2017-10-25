
package oblig2sjakk;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Brikke extends Rectangle{
    
    private String posisjon;
    private boolean farge; 
    protected Brett brett;
    final double lendge = 55;
    

    public Brikke(String posisjon, boolean farge, Brett brett) {
        this.posisjon = posisjon;
        this.farge = farge;
        this.setHeight(lendge);
        this.setWidth(lendge);
        this.setFill(Color.TRANSPARENT);
        this.brett = brett;
    }
   
    public String getPosisjon() {
        return posisjon;
    }

    public boolean isFarge() {
        return farge;
    }
    public abstract String brikkenavn();
            
    public boolean flyttTil(String rutenavn){
        if (this.erLovligTrekk(rutenavn)) {
            System.out.println("er erLovlig trekk true? ");
            this.posisjon = rutenavn;
            return true;
        }
        return false;
        
    }
    
    public abstract boolean erLovligTrekk(String tilPosisjon);
       
}
