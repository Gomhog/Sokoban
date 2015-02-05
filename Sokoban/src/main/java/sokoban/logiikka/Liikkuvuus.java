
package sokoban.logiikka;

import java.util.Arrays;


/**
 * Luokka sisältää liikkumiseen liittyvät tiedot. Oliosta voi tarkistaa,
 * pääseekö pelaaja tai palikka ruutuun, ja sitä käytetään liikkeiden
 * tarkistamiseen.
 *
 */
public class Liikkuvuus {
    private boolean[][] paaseekoPelaaja;
    private boolean[][] paaseekoPalikka;

    /**
     * Luo liikkuvuustiedot halutun kokoisina. Aluksi pelaaja ja palikka
     * pääsevät kaikkii ruutuihin, eli ne ovat tavallista lattiaa.
     * 
     * @param y Haluttu korkeus.
     * @param x Haluttu leveys.
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
     * Lisää seinän ruutuun. Pelaaja tai palikka ei pääse seinään.
     * 
     * @param y Ruudun y-koordinaatti.
     * @param x Ruudun x-koordinaatti.
     */
    public void lisaaSeina(int y, int x) {
        paaseekoPelaaja[y][x] = false;
        paaseekoPalikka[y][x] = false;
    }

    /**
     * Kertoo, pääseekö pelaaja ruutuun.
     * 
     * @param y Ruudun y-koordinaatti.
     * @param x Ruudun x-koordinaatti.
     * @return true, jos pelaaja pääsee ruutuun, false jos ei. Huomaa, että
     * pelaaja ei pääse pois kartalta.
     */
    public boolean getPaaseekoPelaaja(int y, int x) {
        try {
            return paaseekoPelaaja[y][x];
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Kertoo, pääseekö palikka ruutuun.
     * 
     * @param y Ruudun y-koordinaatti.
     * @param x Ruudun x-koordinaatti.
     * @return true, jos palikka pääsee ruutuun, false jos ei. Huomaa, että
     * palikka ei pääse pois kartalta.
     */
    public boolean getPaaseekoPalikka(int y, int x) {
        try {
            return paaseekoPalikka[y][x];
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
}
