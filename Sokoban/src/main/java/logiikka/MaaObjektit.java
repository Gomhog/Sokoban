

package logiikka;

import java.util.ArrayList;


public class MaaObjektit {
    private int kytkimienMaara;
    private ArrayList<int[]> kytkimet;
    private int[] uloskaynninSijainti;

    public MaaObjektit() {
        kytkimienMaara = 0;
        kytkimet = new ArrayList<>();
        uloskaynninSijainti = new int[2];
    }
    
    public void asetaUloskaynti(int i, int j) {
        uloskaynninSijainti[0] = i;
        uloskaynninSijainti[1] = j;
    }
    
    public void asetaKytkin(int i, int j) {
        kytkimet.add(new int[]{i,j});
        kytkimienMaara++;
    }
    
    public int[] getKytkin(int i) {
        return kytkimet.get(i);
    }

    public int getKytkimienMaara() {
        return kytkimienMaara;
    }

    public int[] getUloskaynninSijainti() {
        return uloskaynninSijainti;
    }
    
    
}
