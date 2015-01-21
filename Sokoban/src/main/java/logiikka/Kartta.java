
package logiikka;


public class Kartta {
    private int kokoY;
    private int kokoX;
    private Liikkuvuus liikkuvuus;
    private Palikat palikat;
    private MaaObjektit maaObjektit;
    private int[] pelaajanSijainti;
    private int[] uloskaynninSijainti;

    public Kartta(int n, int m) {
        kokoY = n;
        kokoX = m;
        liikkuvuus = new Liikkuvuus(n,m);
        palikat = new Palikat(n,m);
        pelaajanSijainti = new int[2];
        uloskaynninSijainti = new int[2];
    }

    
    
    
}
