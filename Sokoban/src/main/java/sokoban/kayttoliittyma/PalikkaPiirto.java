package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.Palikat;

public class PalikkaPiirto {
    private Palikat palikat;
    private int y;
    private int x;
    
    public PalikkaPiirto(Kartta kartta) {
        this.palikat = kartta.getPalikat();
        this.y = kartta.getKokoY();
        this.x = kartta.getKokoX();
    }
    
    public void piirra(Graphics g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < y;i++) {
            for (int j = 0; j < x; j++) {
                if (palikat.onkoPalikkaa(i,j)) {
                    g.fillRect(20*j+2, 20*i+2, 16, 16);
                }
            }
        }
    }
}