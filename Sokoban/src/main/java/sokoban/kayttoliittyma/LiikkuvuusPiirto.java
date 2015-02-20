package sokoban.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.Liikkuvuus;


public class LiikkuvuusPiirto {
    private Liikkuvuus pohja;
    private int y;
    private int x;
    
    public LiikkuvuusPiirto(Kartta kartta) {
        this.pohja = kartta.getLiikkuvuus();
        this.y = kartta.getKokoY();
        this.x = kartta.getKokoX();
    }
    
    public void piirra(Graphics g) {
        for (int i = 0; i< y;i++) {
            for (int j = 0; j < x; j++) {
                piirraRuutu(i,j,g);
            }
        }
    }
    
    private void piirraRuutu(int y, int x, Graphics g) {
        Color vari = Color.DARK_GRAY;
        if (!pohja.getPaaseekoPelaaja(y, x) &&
                !pohja.getPaaseekoPalikka(y, x)) {
            vari = Color.BLACK;
        }
        
        g.setColor(vari);
        g.fillRect(20*x, 20*y, 20, 20);
    }
}