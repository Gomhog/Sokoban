
package sokoban.logiikka;

import java.util.Arrays;


/**
 *
 * 
 */
public class Kartta {
    private int kokoY;
    private int kokoX;
    private Liikkuvuus liikkuvuus;
    private Palikat palikat;
    private MaaObjektit maaObjektit;
    private int pelaajaY;
    private int pelaajaX;

    /**
     *
     * @param y
     * @param x
     */
    public Kartta(int y, int x) {
        kokoY = y;
        kokoX = x;
        liikkuvuus = new Liikkuvuus(y,x);
        palikat = new Palikat(y,x);
        maaObjektit = new MaaObjektit();
    }

    
    /**
     *
     * @return
     */
    public boolean ratkaistu() {
        int maara = maaObjektit.getKytkimienMaara();
        for (int i = 0; i<maara; i++) {
            if (palikat.onkoPalikkaa(maaObjektit.getKytkinY(i),
                    maaObjektit.getKytkinX(i))) {
                continue;
            }
            return false;
        }
        
        return (pelaajaX == maaObjektit.getUloskayntiX() 
                && pelaajaY == maaObjektit.getUloskayntiY());
    }
    
    /**
     *
     * @param y
     * @param x
     */
    public void setPelaaja(int y, int x) {
        pelaajaY = y;
        pelaajaX = x;
    }
    
    /**
     *
     * @param suunta
     */
    public void liikutaPelaajaa(Suunta suunta) {
        int y = pelaajaY + suunta.getSuuntaY();
        int x = pelaajaX + suunta.getSuuntaX();
        if (!liikkuvuus.getPaaseekoPelaaja(y, x)) {
            return;
        }
        if (palikat.onkoPalikkaa(y, x) && 
                !palikat.siirraPalikkaa(y, x, suunta, liikkuvuus)) {
            return;
        }
        pelaajaY = y;
        pelaajaX = x;
    }

    
    public Liikkuvuus getLiikkuvuus() {
        return liikkuvuus;
    }

    
    public Palikat getPalikat() {
        return palikat;
    }

    
    public MaaObjektit getMaaObjektit() {
        return maaObjektit;
    }
    
    public int getPelaajaY() {
        return pelaajaY;
    }
    
    public int getPelaajaX() {
        return pelaajaX;
    }
    
    public int getKokoY() {
        return kokoY;
    }

    
    public int getKokoX() {
        return kokoX;
    }
    
    
}
