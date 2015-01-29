
package logiikka;


public class Palikat {
    private boolean[][] sijainnit;

    public Palikat(int n, int m) {
        sijainnit = new boolean[n][m];
    }
    
    public void lisaaPalikka(int i, int j) {
        sijainnit[i][j] = true;
    }
    
    public boolean onkoPalikkaa(int i, int j) {
        try {
            return sijainnit[i][j];
        } catch (Exception e) {
            return false;
        }
    }
    
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
