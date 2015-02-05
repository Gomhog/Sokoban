
package sokoban.logiikka;


/**
 *
 * 
 */
public class Palikat {
    private boolean[][] sijainnit;

    /**
     *
     * @param y
     * @param x
     */
    public Palikat(int y, int x) {
        sijainnit = new boolean[y][x];
    }
    
    /**
     *
     * @param y
     * @param x
     */
    public void lisaaPalikka(int y, int x) {
        sijainnit[y][x] = true;
    }
    
    /**
     *
     * @param y
     * @param x
     * @return
     */
    public boolean onkoPalikkaa(int y, int x) {
        try {
            return sijainnit[y][x];
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     *
     * @param y
     * @param x
     * @param suunta
     * @param liikkuvuus
     * @return
     */
    public boolean siirraPalikkaa(int y, int x, Suunta suunta, 
            Liikkuvuus liikkuvuus) {
        if (!sijainnit[y][x]) {
            return false;
        }
        int kohdeY = y + suunta.getSuuntaY();
        int kohdeX = x + suunta.getSuuntaX();
        if (onkoPalikkaa(kohdeY,kohdeX) || 
                !liikkuvuus.getPaaseekoPalikka(kohdeY, kohdeX)) {
            return false;
        }
        sijainnit[y][x] = false;
        sijainnit[kohdeY][kohdeX] = true;
        return true;
    }
}
