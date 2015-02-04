
package sokoban.tiedostoluku;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sokoban.logiikka.Kartta;


/**
 *
 *
 */
public class TiedostoLukija {
    
    
    /**
     *
     * @param tiedostonimi
     * @return
     */
    public static Kartta lueKartta(String tiedostonimi) {
        Kartta kartta = null;
        try (Scanner lukija = new Scanner(new FileReader("level/" + tiedostonimi))) {
            kartta = luoPohjakartta(lukija);
            luoMaaobjektitJaLiikkuvuus(lukija,kartta);
            asetaPelaaja(kartta, lukija);
            luoPalikat(kartta, lukija);
            lukija.close();
        } catch (Exception ex) {
            return null;
        }
        return kartta;
    }
    
    private static Kartta luoPohjakartta(Scanner lukija) {
        int n = lukija.nextInt();
        int m = lukija.nextInt();
        lukija.nextLine();
        return new Kartta(n,m);
    }
    
    private static void luoMaaobjektitJaLiikkuvuus(Scanner lukija, Kartta kartta) throws Exception {
        for (int i = 0; i < kartta.getKokoY(); i++) {
            String luettu = lukija.nextLine();
            if (luettu.length() != kartta.getKokoX()) {
                failaaminen(lukija);
            }
            for (int j = 0; j < kartta.getKokoX(); j++) {
                char valinta = luettu.charAt(j);
                if(!rakennaKarttaa(kartta, valinta, i, j)) {
                    failaaminen(lukija);
                }
            }
        }
    }
    
    private static boolean rakennaKarttaa(Kartta kartta, char merkki, int i, int j) {
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
    
    private static void asetaPelaaja(Kartta kartta, 
            Scanner lukija) throws Exception {
        int y = lukija.nextInt();
        int x = lukija.nextInt();
        if (!kartta.getLiikkuvuus().getPaaseekoPelaaja(y, x)) {
            failaaminen(lukija);
        }
        kartta.setPelaaja(y, x);
    }
    
    private static void luoPalikat(Kartta kartta, Scanner lukija) 
            throws Exception {
        int palikoita = lukija.nextInt();
        if (palikoita < kartta.getMaaObjektit().getKytkimienMaara()) {
            failaaminen(lukija);
        }
        for (int k = 0; k < palikoita; k++) {
            lisaaPalikka(kartta, lukija);
        }
    }
    
    private static void lisaaPalikka(Kartta kartta, Scanner lukija) 
            throws Exception {
        int pelaajaY = kartta.getPelaajanSijainti()[0];
        int pelaajaX = kartta.getPelaajanSijainti()[1];
        int i = lukija.nextInt();
        int j = lukija.nextInt();
        if (i == pelaajaY && j == pelaajaX) {
            failaaminen(lukija);
        }
        if (!kartta.getLiikkuvuus().getPaaseekoPalikka(i, j)) {
            failaaminen(lukija);
        }
        kartta.getPalikat().lisaaPalikka(i, j);
    }
    
    private static void failaaminen(Scanner lukija) throws Exception {
        lukija.close();
        throw new Exception();
    }
    
    
}
