
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
    private int[] pelaajanSijainti;

    /**
     *
     * @param n
     * @param m
     */
    public Kartta(int n, int m) {
        kokoY = n;
        kokoX = m;
        liikkuvuus = new Liikkuvuus(n,m);
        palikat = new Palikat(n,m);
        maaObjektit = new MaaObjektit();
        pelaajanSijainti = new int[2];
    }

    
    /**
     *
     * @return
     */
    public boolean ratkaistu() {
        int maara = maaObjektit.getKytkimienMaara();
        for (int i = 0; i<maara; i++) {
            if (palikat.onkoPalikkaa(maaObjektit.getKytkin(i)[0],
                    maaObjektit.getKytkin(i)[1])) {
                continue;
            }
            return false;
        }
        
        return Arrays.equals(pelaajanSijainti, maaObjektit.getUloskaynninSijainti());
    }
    
    /**
     *
     * @param i
     * @param j
     */
    public void setPelaaja(int i, int j) {
        pelaajanSijainti[0] = i;
        pelaajanSijainti[1] = j;
    }
    
    /**
     *
     * @param suunta
     */
    public void liikutaPelaajaa(Suunta suunta) {
        int y = pelaajanSijainti[0] + suunta.muutos()[0];
        int x = pelaajanSijainti[1] + suunta.muutos()[1];
        if (!liikkuvuus.getPaaseekoPelaaja(y, x)) {
            return;
        }
        if (palikat.onkoPalikkaa(y, x) && 
                !palikat.siirraPalikkaa(y, x, suunta, liikkuvuus)) {
            return;
        }
        pelaajanSijainti[0] = y;
        pelaajanSijainti[1] = x;
    }

    /**
     *
     * @return
     */
    public Liikkuvuus getLiikkuvuus() {
        return liikkuvuus;
    }

    /**
     *
     * @return
     */
    public Palikat getPalikat() {
        return palikat;
    }

    /**
     *
     * @return
     */
    public MaaObjektit getMaaObjektit() {
        return maaObjektit;
    }

    /**
     *
     * @return
     */
    public int[] getPelaajanSijainti() {
        return pelaajanSijainti;
    }

    /**
     *
     * @return
     */
    public int getKokoY() {
        return kokoY;
    }

    /**
     *
     * @return
     */
    public int getKokoX() {
        return kokoX;
    }
    
    
}
