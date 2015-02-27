
package sokoban.tiedostoluku;

import java.io.FileReader;
import java.util.Scanner;
import sokoban.logiikka.Kartta;


/**
 * Tämä luokka sisältää metodin, joka kokoaa pelikentän oikein muodostetusta
 * LVL-tiedostosta.
 *
 */
public class TiedostoLukija {
    private static Scanner lukija;
    private static Kartta kartta;
    
    
    /**
     * Metodi muodostaa kartan parametrina annetusta LVL-tiedostosta.
     * LVL-tiedoston tulee noudattaa oikeaa syntaksia, ja sen on oltava
     * hakemistossa level.
     * @param tiedostonimi on halutun LVL-tiedoston nimi.
     * @return Tiedostosta muodostetun kartan. Jos kartan luominen ei onnistu,
     * palauttaa null.
     */
    public static Kartta lueKartta(String tiedostonimi) {
        String polku = "level/";
        kartta = null;
        try (Scanner luku = new Scanner(new FileReader(polku + tiedostonimi))) {
            lukija = luku;
            kartta = luoPohjakartta();
            luoMaaobjektitJaLiikkuvuus();
            asetaPelaaja();
            luoPalikat();
            lukija.close();
            lukija = null;
        } catch (Exception ex) {
            return null;
        }
        return kartta;
    }
    
    private static Kartta luoPohjakartta() {
        int n = lukija.nextInt();
        int m = lukija.nextInt();
        lukija.nextLine();
        return new Kartta(n, m);
    }
    
    private static void luoMaaobjektitJaLiikkuvuus() throws Exception {
        for (int i = 0; i < kartta.getKokoY(); i++) {
            String luettu = lukija.nextLine();
            if (luettu.length() != kartta.getKokoX()) {
                failaaminen();
            }
            for (int j = 0; j < kartta.getKokoX(); j++) {
                char valinta = luettu.charAt(j);
                if (!rakennaKarttaa(valinta, i, j)) {
                    failaaminen();
                }
            }
        }
    }
    
    private static boolean rakennaKarttaa(char merkki, int i, int j) {
        if (merkki == '#') {
            kartta.getLiikkuvuus().lisaaSeina(i, j);
            return true;
        }
        if (merkki == 'S') {
            kartta.getMaaObjektit().asetaKytkin(i, j);
            return true;
        }
        if (merkki == 'E') {
            if (kartta.getMaaObjektit().getExitSet()) {
                return false;
            }
            kartta.getMaaObjektit().asetaUloskaynti(i, j);
            return true;
        }
        if (merkki == '.') {
            return true;
        }
        return false;
    }
    
    private static void asetaPelaaja() throws Exception {
        int y = lukija.nextInt();
        int x = lukija.nextInt();
        if (!kartta.getLiikkuvuus().getPaaseekoPelaaja(y, x)) {
            failaaminen();
        }
        kartta.setPelaaja(y, x);
    }
    
    private static void luoPalikat() throws Exception {
        int palikoita = lukija.nextInt();
        if (palikoita < kartta.getMaaObjektit().getKytkimienMaara()) {
            failaaminen();
        }
        for (int k = 0; k < palikoita; k++) {
            lisaaPalikka();
        }
    }
    
    private static void lisaaPalikka() throws Exception {
        int pelaajaY = kartta.getPelaajaY();
        int pelaajaX = kartta.getPelaajaX();
        int i = lukija.nextInt();
        int j = lukija.nextInt();
        if (i == pelaajaY && j == pelaajaX) {
            failaaminen();
        }
        if (!kartta.getLiikkuvuus().getPaaseekoPalikka(i, j)) {
            failaaminen();
        }
        kartta.getPalikat().lisaaPalikka(i, j);
    }
    
    private static void failaaminen() throws Exception {
        lukija.close();
        lukija = null;
        throw new Exception();
    }
    
    
}
