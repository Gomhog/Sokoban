

package sokoban.logiikka;

import java.util.ArrayList;


/**
 *
 *
 */
public class MaaObjektit {
    private ArrayList<int[]> kytkimet;
    private boolean exitSet;
    private int uloskayntiY;
    private int uloskayntiX;

    /**
     *
     */
    public MaaObjektit() {
        kytkimet = new ArrayList<>();
        exitSet = false;
    }
    
    /**
     *
     * @param y
     * @param x
     */
    public void asetaUloskaynti(int y, int x) {
        uloskayntiY = y;
        uloskayntiX = x;
        exitSet = true;
    }
    
    /**
     *
     * @param y
     * @param x
     */
    public void asetaKytkin(int y, int x) {
        kytkimet.add(new int[]{y,x});
    }
    
    
    public int getKytkinY(int i) {
        return kytkimet.get(i)[0];
    }
    
    public int getKytkinX(int i) {
        return kytkimet.get(i)[1];
    }

    /**
     *
     * @return
     */
    public int getKytkimienMaara() {
        return kytkimet.size();
    }
    
    
    public boolean getExitSet() {
        return exitSet;
    }

    public int getUloskayntiY() {
        return uloskayntiY;
    }

    public int getUloskayntiX() {
        return uloskayntiX;
    }
    
    
}
