
package logiikka;


public class MaaObjektit {
    private int kytkimienMaara;
    private int[][] kytkimet;
    private int[] uloskaynninSijainti;

    public MaaObjektit() {
        kytkimienMaara = 0;
        uloskaynninSijainti = new int[2];
    }
    
    public void asetaUloskaynti(int i, int j) {
        uloskaynninSijainti[0] = i;
        uloskaynninSijainti[1] = j;
    }
    
    public void asetaKytkimet(int[][] sijainnit) {
        kytkimet = sijainnit;
        kytkimienMaara = sijainnit.length;
    }
    
    public int[][] getKytkimet() {
        return kytkimet;
    }

    public int getKytkimienMaara() {
        return kytkimienMaara;
    }

    public int[] getUloskaynninSijainti() {
        return uloskaynninSijainti;
    }
    
    
}
