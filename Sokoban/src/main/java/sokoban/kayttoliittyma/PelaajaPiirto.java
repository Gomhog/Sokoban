package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;

public class PelaajaPiirto {
    private Kartta kartta;
    
    public PelaajaPiirto(Kartta kartta) {
        this.kartta = kartta;
    }
    
    public void piirra(Graphics g) {
        int y = kartta.getPelaajaY();
        int x = kartta.getPelaajaX();
        
        g.setColor(Color.RED);
        g.fillOval(20*x+2, 20*y+2, 16, 16);
    }
}