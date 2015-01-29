
package logiikka;

import java.util.Arrays;


public class Kartta {
    private int kokoY;
    private int kokoX;
    private Liikkuvuus liikkuvuus;
    private Palikat palikat;
    private MaaObjektit maaObjektit;
    private int[] pelaajanSijainti;

    public Kartta(int n, int m) {
        kokoY = n;
        kokoX = m;
        liikkuvuus = new Liikkuvuus(n,m);
        palikat = new Palikat(n,m);
        maaObjektit = new MaaObjektit();
        pelaajanSijainti = new int[2];
    }

    
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
    
    public void setPelaaja(int i, int j) {
        pelaajanSijainti[0] = i;
        pelaajanSijainti[1] = j;
    }
    
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

    public Liikkuvuus getLiikkuvuus() {
        return liikkuvuus;
    }

    public Palikat getPalikat() {
        return palikat;
    }

    public MaaObjektit getMaaObjektit() {
        return maaObjektit;
    }

    public int[] getPelaajanSijainti() {
        return pelaajanSijainti;
    }
    
    
}
