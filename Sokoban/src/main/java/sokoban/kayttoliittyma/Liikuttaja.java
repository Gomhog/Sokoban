package sokoban.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sokoban.logiikka.Suunta;

public class Liikuttaja implements KeyListener {
    private PeliRuutu peli;

    public Liikuttaja(PeliRuutu peli) {
        this.peli = peli;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!peli.aktiivinen()) {
            return;
        }
        Suunta suunta = null;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            suunta = Suunta.VASEN;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            suunta = Suunta.OIKEA;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            suunta = Suunta.YLOS;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            suunta = Suunta.ALAS;
        }
        if (suunta != null) {
            peli.liiku(suunta);
            peli.repaint();
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}