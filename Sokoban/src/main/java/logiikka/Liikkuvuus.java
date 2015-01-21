
package logiikka;


public class Liikkuvuus {
    private boolean[][] paaseekoPelaaja;
    private boolean[][] paaseekoPalikka;

    public Liikkuvuus(int n, int m) {
        paaseekoPelaaja = new boolean[n][m];
        paaseekoPalikka = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paaseekoPelaaja[i][j] = true;
                paaseekoPalikka[i][j] = true;
            }
        }
    }
    
    public void lisaaSeina(int i, int j) {
        paaseekoPelaaja[i][j] = false;
        paaseekoPalikka[i][j] = false;
    }

    public boolean getPaaseekoPelaaja(int i, int j) {
        return paaseekoPelaaja[i][j];
    }

    public boolean getPaaseekoPalikka(int i, int j) {
        return paaseekoPalikka[i][j];
    }
    
    
}
