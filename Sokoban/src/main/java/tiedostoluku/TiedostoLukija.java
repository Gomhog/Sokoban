
package tiedostoluku;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logiikka.Kartta;


public class TiedostoLukija {
    
    public TiedostoLukija() {
    }
    
    public Kartta lueKartta(String tiedostonimi) {
        Kartta kartta = null;
        try (Scanner lukija = new Scanner(new FileReader("level/" + tiedostonimi))) {
            int n = lukija.nextInt();
            int m = lukija.nextInt();
            lukija.nextLine();
            kartta = new Kartta(n,m);
            for (int i = 0; i < n; i++) {
                String luettu = lukija.nextLine();
                if (luettu.length() != m) {
                    lukija.close();
                    return null;
                }
                for (int j = 0; j < m; j++) {
                    char valinta = luettu.charAt(j);
                    if(!rakennaKarttaa(kartta, valinta, i, j)) {
                        lukija.close();
                        return null;
                    }
                }
            }
            int pelaajaY = lukija.nextInt();
            int pelaajaX = lukija.nextInt();
            if (!kartta.getLiikkuvuus().getPaaseekoPelaaja(pelaajaY, pelaajaX)) {
                lukija.close();
                return null;
            }
            kartta.setPelaaja(pelaajaY, pelaajaX);
            int palikoita = lukija.nextInt();
            if (palikoita < kartta.getMaaObjektit().getKytkimienMaara()) {
                lukija.close();
                return null;
            }
            for (int k = 0; k < palikoita; k++) {
                int i = lukija.nextInt();
                int j = lukija.nextInt();
                if (!kartta.getLiikkuvuus().getPaaseekoPalikka(i, j)) {
                    lukija.close();
                    return null;
                }
                kartta.getPalikat().lisaaPalikka(i, j);
            }
            lukija.close();
        } catch (FileNotFoundException ex) {}
        return kartta;
    }
    
    private boolean rakennaKarttaa(Kartta kartta, char merkki, int i, int j) {
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
}
