package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;

/**
 * Luokka on vastuussa pelaajan piirtämisestä.
 * 
 */
public class PelaajaPiirto {
    private Kartta kartta;
    
    /**
     * Luo karttaa vastaavan piirtäjän.
     * @param kartta piirrettävä kartta
     */
    public PelaajaPiirto(Kartta kartta) {
        this.kartta = kartta;
    }
    
    /**
     * Piirtää pelaajan kartalle. Pelaaja piirtyy punaisena ympyränä.
     * 
     * Liikkuvuus ja MaaObjektit pitää piirtää ennen tämän metodin kutsumista.
     * @param g Piirtävä grafiikkaolio
     */
    public void piirra(Graphics g) {
        int y = kartta.getPelaajaY();
        int x = kartta.getPelaajaX();
        
        g.setColor(Color.RED);
        g.fillOval(20*x+2, 20*y+2, 16, 16);
    }
}