
package oblig2sjakk;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


public class Konge extends Brikke {
    
    private final String BOKSTAV = "k";

    public Konge(String posisjon, boolean farge, Brett brett) {
        super(posisjon, farge, brett);
                if (farge == false) {
           this.setFill(new ImagePattern(new Image("/svartkonge.png")));
        }
        else{
            this.setFill(new ImagePattern(new Image("/hvitkonge.png")));
        }
    }

    @Override
    public String brikkenavn() {
       return BOKSTAV;
    }

    @Override
    public boolean flyttTil(String rutenavn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean erLovligTrekk(String tilPosisjon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
