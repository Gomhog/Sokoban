package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.Palikat;

/**
 * Luokka on vastuussa kartan palikoiden piirtämisestä.
 * 
 */
public class PalikkaPiirto {
    private Palikat palikat;
    private int y;
    private int x;
    
    /**
     * Luo karttaa vastaavan piirtäjän kartan Palikat-oliolle.
     * @param kartta piirrettävä kartta
     */
    public PalikkaPiirto(Kartta kartta) {
        this.palikat = kartta.getPalikat();
        this.y = kartta.getKokoY();
        this.x = kartta.getKokoX();
    }
    
    /**
     * Piirtää kartalla olevat palikat valkoisella. Palikat eivät peitä
     * koko ruutua, jotta näkyy, ovatko palikat kytkimien päällä.
     * 
     * Tätä tulee kutsua vasta sen jälkeen, kun Liikkuvuus ja MaaObjektit on
     * jo piirretty.
     * @param g Piirtävä grafiikkaolio
     */
    public void piirra(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (palikat.onkoPalikkaa(i, j)) {
                    g.fillRect(20 * j + 2, 20 * i + 2, 16, 16);
                }
            }
        }
    }
}