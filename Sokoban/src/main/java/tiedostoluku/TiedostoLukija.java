
package tiedostoluku;

import java.io.FileReader;
import java.util.Scanner;
import logiikka.Kartta;


public class TiedostoLukija {
    
    public TiedostoLukija() {
    }
    
    public Kartta lueKartta(String tiedostonimi) {
        
        try {
            Kartta kartta;
            try (Scanner lukija = new Scanner(new FileReader("level/" + tiedostonimi))) {
                int n = lukija.nextInt();
                int m = lukija.nextInt();
                kartta = new Kartta(n,m);
                boolean exitSet = false;
                for (int i = 0; i < n; i++) {
                    String luettu = lukija.nextLine();
                    if (luettu.length() != m) {
                        lukija.close();
                        return null;
                    }
                    for (int j = 0; j < m; j++) {
                        if (luettu.charAt(j) == '#') {
                            kartta.getLiikkuvuus().lisaaSeina(i, j);
                            continue;
                        }
                        if (luettu.charAt(j) == 'S') {
                            kartta.getMaaObjektit().asetaKytkin(i, j);
                            continue;
                        }
                        if (luettu.charAt(j) == 'E') {
                            if (exitSet) {
                                lukija.close();
                                return null;
                            }
                            kartta.getMaaObjektit().asetaUloskaynti(i, j);
                            exitSet = true;
                            continue;
                        }
                        if (luettu.charAt(j) == '.') {
                            continue;
                        }
                        lukija.close();
                        return null;
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
            }
            return kartta;
        } catch (Exception e) {
            return null;
        }
    }
}
