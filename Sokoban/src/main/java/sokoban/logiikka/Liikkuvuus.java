
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
     * @param n
     * @param m
     */
    public Liikkuvuus(int n, int m) {
        paaseekoPelaaja = new boolean[n][m];
        paaseekoPalikka = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(paaseekoPelaaja[i], true);
            Arrays.fill(paaseekoPalikka[i], true);
            
        }
    }
    
    /**
     *
     * @param i
     * @param j
     */
    public void lisaaSeina(int i, int j) {
        paaseekoPelaaja[i][j] = false;
        paaseekoPalikka[i][j] = false;
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public boolean getPaaseekoPelaaja(int i, int j) {
        try {
            return paaseekoPelaaja[i][j];
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public boolean getPaaseekoPalikka(int i, int j) {
        try {
            return paaseekoPalikka[i][j];
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
}