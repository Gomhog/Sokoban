

package sokoban.logiikka;

import java.util.ArrayList;


/**
 *
 *
 */
public class MaaObjektit {
    private ArrayList<int[]> kytkimet;
    private int[] uloskaynninSijainti;
    private boolean exitSet;

    /**
     *
     */
    public MaaObjektit() {
        kytkimet = new ArrayList<>();
        uloskaynninSijainti = new int[2];
        exitSet = false;
    }
    
    /**
     *
     * @param i
     * @param j
     */
    public void asetaUloskaynti(int i, int j) {
        uloskaynninSijainti[0] = i;
        uloskaynninSijainti[1] = j;
        exitSet = true;
    }
    
    /**
     *
     * @param i
     * @param j
     */
    public void asetaKytkin(int i, int j) {
        kytkimet.add(new int[]{i,j});
    }
    
    /**
     *
     * @param i
     * @return
     */
    public int[] getKytkin(int i) {
        return kytkimet.get(i);
    }

    /**
     *
     * @return
     */
    public int getKytkimienMaara() {
        return kytkimet.size();
    }

    
    public int[] getUloskaynninSijainti() {
        return uloskaynninSijainti;
    }
    
    
    public boolean getExitSet() {
        return exitSet;
    }
}
