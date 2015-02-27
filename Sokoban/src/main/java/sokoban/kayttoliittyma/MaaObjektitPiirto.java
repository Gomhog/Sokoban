package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.MaaObjektit;

/**
 * Luokka on vastuussa MaaObjektit-oliossa olevan tiedon piirtämisestä.
 * 
 */
public class MaaObjektitPiirto {
    private MaaObjektit objektit;

    /**
     * Luo karttaa vastaavan piirtäjän kartan MaaObjektit-oliolle.
     * @param kartta piirrettävä kartta
     */
    public MaaObjektitPiirto(Kartta kartta) {
        this.objektit = kartta.getMaaObjektit();
    }
    
    /**
     * Piirtää kartan uloskäynnin ja kytkimet. Kytkinruudut ovat vihreitä,
     * ja uloskäynti on keltainen.
     * 
     * Tätä tulee kutsua vasta sen jälkeen, kun Liikkuvuus on piirretty.
     * @param g Piirtävä grafiikkaolio
     */
    public void piirra(Graphics g) {
        piirraUloskaynti(g);
        piirraKytkimet(g);
    }
    
    private void piirraUloskaynti(Graphics g) {
        int y = objektit.getUloskayntiY();
        int x = objektit.getUloskayntiX();
        
        g.setColor(Color.YELLOW);
        g.fillRect(20 * x, 20 * y, 20, 20);
    }
    
    private void piirraKytkimet(Graphics g) {
        for (int i = 0; i < objektit.getKytkimienMaara(); i++) {
            int y = objektit.getKytkinY(i);
            int x = objektit.getKytkinX(i);
            
            g.setColor(Color.GREEN);
            g.fillRect(20 * x, 20 * y, 20, 20);
        }
    }
}