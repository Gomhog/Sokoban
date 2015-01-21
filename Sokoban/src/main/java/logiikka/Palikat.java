
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
        return sijainnit[i][j];
    }
}
