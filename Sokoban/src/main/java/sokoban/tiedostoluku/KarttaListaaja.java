package sokoban.tiedostoluku;

import java.io.File;
import java.util.*;

public class KarttaListaaja {
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
