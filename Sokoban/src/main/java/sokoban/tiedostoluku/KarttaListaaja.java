package sokoban.tiedostoluku;

import java.io.File;
import java.util.*;

/**
 * Tämän luokan tehtävänä on tuottaa käyttöliittymälle tieto valittavissa
 * olevista kartoista.
 * 
 */
public class KarttaListaaja {
    /**
     * Metodi tuottaa listan merkkijonoista, jotka vastaavat level-polusta
     * löytyviä LVL-tiedostoja.
     * 
     * @return Lista kaikista level-polun LVL-tiedostoista.
     */
    public static List<String> listaaKartat() {
        List<String> karttaNimet = new ArrayList<>();
        File hakemisto = new File("level");
        if (hakemisto.list() == null) {
            return karttaNimet;
        }
        for (String tiedostonimi : hakemisto.list()) {
            if (tiedostonimi.endsWith(".lvl")) {
                karttaNimet.add(tiedostonimi);
            }
        }
        return karttaNimet;
    }
    
}
