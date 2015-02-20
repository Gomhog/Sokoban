package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.MaaObjektit;

public class MaaObjektitPiirto {
    private MaaObjektit objektit;

    public MaaObjektitPiirto(Kartta kartta) {
        this.objektit = kartta.getMaaObjektit();
    }
    
    public void piirra(Graphics g) {
        piirraUloskaynti(g);
        piirraKytkimet(g);
    }
    
    private void piirraUloskaynti(Graphics g) {
        int y = objektit.getUloskayntiY();
        int x = objektit.getUloskayntiX();
        
        g.setColor(Color.YELLOW);
        g.fillRect(20*x, 20*y, 20, 20);
    }
    
    private void piirraKytkimet(Graphics g) {
        for (int i = 0; i < objektit.getKytkimienMaara(); i++) {
            int y = objektit.getKytkinY(i);
            int x = objektit.getKytkinY(i);
            
            g.setColor(Color.GREEN);
            g.fillRect(20*x, 20*y, 20, 20);
        }
    }
}