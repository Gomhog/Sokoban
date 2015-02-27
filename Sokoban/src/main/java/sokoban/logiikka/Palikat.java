
package sokoban.logiikka;


/**
 * Luokka sisältää tiedot palikoiden sijainneista sekä niiden työntämiseen
 * liittyvän logiikan.
 * 
 */
public class Palikat {
    private boolean[][] sijainnit;

    /**
     * Luo uuden palikkatiedon. Aluksi palikoita ei ole.
     * 
     * @param y Kentän korkeus.
     * @param x Kentän leveys.
     */
    public Palikat(int y, int x) {
        sijainnit = new boolean[y][x];
    }
    
    /**
     * Lisää palikan ruutuun.
     * 
     * @param y Palikan y-koordinaatti.
     * @param x Palikan x-koordinaatti.
     */
    public void lisaaPalikka(int y, int x) {
        sijainnit[y][x] = true;
    }
    
    /**
     * Kertoo, onko ruudussa palikkaa. Kentän ulkopuolella ei ole palikoita.
     * 
     * @param y Ruudun y-koordinaatti.
     * @param x Ruudun x-koordinaatti.
     * @return true, jos ruudussa on palikka, false, jos ei.
     */
    public boolean onkoPalikkaa(int y, int x) {
        try {
            return sijainnit[y][x];
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Yrittää siirtää palikkaa annettuun suuntaan. Parametrinä annetut
     * liikkuvuustiedot tulee antaa samasta kartasta.
     * 
     * @param y Halutun palikan y-koordinaatti.
     * @param x Halutun palikan x-koordinaatti.
     * @param suunta Haluttu siirtosuunta.
     * @param liikkuvuus Tieto liikkumisrajoituksista
     * @return true, jos siirto onnistuu, false, jos siirto ei onnistu.
     */
    public boolean siirraPalikkaa(int y, int x, Suunta suunta, 
            Liikkuvuus liikkuvuus) {
        if (!sijainnit[y][x]) {
            return false;
        }
        int kohdeY = y + suunta.getSuuntaY();
        int kohdeX = x + suunta.getSuuntaX();
        if (onkoPalikkaa(kohdeY, kohdeX) || 
                !liikkuvuus.getPaaseekoPalikka(kohdeY, kohdeX)) {
            return false;
        }
        sijainnit[y][x] = false;
        sijainnit[kohdeY][kohdeX] = true;
        return true;
    }
}
