

package sokoban.logiikka;

import java.util.ArrayList;


/**
 * Luokkaan tallennetaan tieto kartan pysyvistä erikoisruuduista - kytkimistä
 * ja uloskäynnistä. Kytkimet on tallennettu listalle, jonka indeksointi alkaa
 * 0:sta.
 *
 */
public class MaaObjektit {
    private ArrayList<int[]> kytkimet;
    private boolean exitSet;
    private int uloskayntiY;
    private int uloskayntiX;

    /**
     * Luo uuden erikoisruututiedon. Aluksi kytkimiä ei ole ja uloskäyntiä
     * ei ole asetettu.
     */
    public MaaObjektit() {
        kytkimet = new ArrayList<>();
        exitSet = false;
    }
    
    /**
     * Asettaa uloskäynnin ruutuun. Tämän jälkeen tallentuu myös tieto, että
     * uloskäynnin paikka on määrätty.
     * 
     * @param y Uloskäynnin y-koordinaatti.
     * @param x Uloskäynnin x-koordinaatti.
     */
    public void asetaUloskaynti(int y, int x) {
        uloskayntiY = y;
        uloskayntiX = x;
        exitSet = true;
    }
    
    /**
     * Asettaa kartalle uuden kytkimen.
     * Jos ruudussa on jo kytkin, lisätään uusi, redundantti kytkin.
     * 
     * @param y Kytkimen y-koordinaatti.
     * @param x Kytkimen x-koordinaatti.
     */
    public void asetaKytkin(int y, int x) {
        kytkimet.add(new int[]{y,x});
    }
    
    
    /**
     * Palauttaa listalla indeksissä i olevan kytkimen y-koordinaatin.
     * 
     * @param i Kysytyn kytkimen indeksi.
     * @return Kysytyn kytkimen y-koordinaatin.
     */
    public int getKytkinY(int i) {
        return kytkimet.get(i)[0];
    }
    
    /**
     * Palauttaa listalla indeksissä i olevan kytkimen x-koordinaatin.
     * 
     * @param i Kysytyn kytkimen indeksi.
     * @return Kysytyn kytkimen x-koordinaatin.
     */
    public int getKytkinX(int i) {
        return kytkimet.get(i)[1];
    }

    /**
     * Kertoo, kuinka monta kytkintä kartalla on.
     * 
     * @return Kytkimien lukumäärä.
     */
    public int getKytkimienMaara() {
        return kytkimet.size();
    }
    
    
    /**
     * Kertoo, onko uloskäynnin paikka määritelty.
     * 
     * @return true, jos uloskäynti on määritelty, false jos ei.
     */
    public boolean getExitSet() {
        return exitSet;
    }

    public int getUloskayntiY() {
        return uloskayntiY;
    }

    public int getUloskayntiX() {
        return uloskayntiX;
    }
    
    
}
