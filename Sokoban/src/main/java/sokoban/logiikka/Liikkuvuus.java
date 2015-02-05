
package sokoban.logiikka;

import java.util.Arrays;


/**
 *
 *
 */
public class Liikkuvuus {
    private boolean[][] paaseekoPelaaja;
    private boolean[][] paaseekoPalikka;

    /**
     *
     * @param y
     * @param x
     */
    public Liikkuvuus(int y, int x) {
        paaseekoPelaaja = new boolean[y][x];
        paaseekoPalikka = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            Arrays.fill(paaseekoPelaaja[i], true);
            Arrays.fill(paaseekoPalikka[i], true);
            
        }
    }
    
    /**
     *
     * @param y
     * @param x
     */
    public void lisaaSeina(int y, int x) {
        paaseekoPelaaja[y][x] = false;
        paaseekoPalikka[y][x] = false;
    }

    /**
     *
     * @param y
     * @param x
     * @return
     */
    public boolean getPaaseekoPelaaja(int y, int x) {
        try {
            return paaseekoPelaaja[y][x];
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param y
     * @param x
     * @return
     */
    public boolean getPaaseekoPalikka(int y, int x) {
        try {
            return paaseekoPalikka[y][x];
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
}
