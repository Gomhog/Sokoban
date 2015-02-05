
package sokoban.logiikka;

import java.util.Arrays;


/**
 * Tämä luokka sisältää pelikentän. Liikkumiseen tarvittavat tiedot ovat
 * tallessa Liikkuvuus-oliossa, palikat Palikat-oliossa ja uloskäynti
 * ja kytkimet MaaObjektit-oliossa. Tämän kautta liikutetaan pelaajaa
 * ja tarkistetaan, onko kenttä ratkaistu.
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
     * Luo uuden määrätyn kokoisen kartan. Uudella kartalla kaikki ruudut
     * ovat tavallista lattiaa, palikoita ja kytkimiä ei ole, ja
     * uloskäynnin sijaintia ei ole asetettu.
     * 
     * @param y Kentän haluttu korkeus
     * @param x Kentän haluttu leveys
     */
    public Kartta(int y, int x) {
        kokoY = y;
        kokoX = x;
        liikkuvuus = new Liikkuvuus(y,x);
        palikat = new Palikat(y,x);
        maaObjektit = new MaaObjektit();
    }

    
    /**
     * Kertoo, onko kenttä ratkaistu. Kenttä on ratkaistu, jos kaikilla
     * kytkimillä on palikka ja pelaaja seisoo uloskäynnillä.
     * 
     * @return true, jos kenttä on ratkaistu, false, jos ei.
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
     * Sijoittaa pelaajan ruutuun (y,x).
     * 
     * @param y Pelaajan toivottu y-koordinaatti.
     * @param x Pelaajan toivottu x-koordinaatti.
     */
    public void setPelaaja(int y, int x) {
        pelaajaY = y;
        pelaajaX = x;
    }
    
    /**
     * Yrittää liikuttaa pelaajaa annettuun suuntaan. Pelaaja liikkuu
     * suuntaan, jos mahdollista, ja työntää kohderuudussa olevaa
     * palikkaa.
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
