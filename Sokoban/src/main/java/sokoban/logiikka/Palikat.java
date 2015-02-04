
package sokoban.logiikka;


/**
 *
 * 
 */
public class Palikat {
    private boolean[][] sijainnit;

    /**
     *
     * @param n
     * @param m
     */
    public Palikat(int n, int m) {
        sijainnit = new boolean[n][m];
    }
    
    /**
     *
     * @param i
     * @param j
     */
    public void lisaaPalikka(int i, int j) {
        sijainnit[i][j] = true;
    }
    
    /**
     *
     * @param i
     * @param j
     * @return
     */
    public boolean onkoPalikkaa(int i, int j) {
        try {
            return sijainnit[i][j];
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     *
     * @param i
     * @param j
     * @param suunta
     * @param liikkuvuus
     * @return
     */
    public boolean siirraPalikkaa(int i, int j, Suunta suunta, 
            Liikkuvuus liikkuvuus) {
        if (!sijainnit[i][j]) {
            return false;
        }
        int kohdeY = i + suunta.muutos()[0];
        int kohdeX = j + suunta.muutos()[1];
        if (onkoPalikkaa(kohdeY,kohdeX) || 
                !liikkuvuus.getPaaseekoPalikka(kohdeY, kohdeX)) {
            return false;
        }
        sijainnit[i][j] = false;
        sijainnit[kohdeY][kohdeX] = true;
        return true;
    }
}
