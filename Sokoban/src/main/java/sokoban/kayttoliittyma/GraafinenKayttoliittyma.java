package sokoban.kayttoliittyma;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Graafinen käyttöliittymä Sokobanin pelaamiseen
 * 
 */
public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;

    /**
     * Luo uuden graafisen käyttöliittymän.
     */
    public GraafinenKayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Sokoban");
        frame.setPreferredSize(new Dimension(1000, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        PeliRuutu peli = new PeliRuutu();
        NappienKuuntelija nk = new NappienKuuntelija(peli);
        container.add(luoSivupalkki(nk), BorderLayout.EAST);
        ValintaPalkki valinta = new ValintaPalkki();
        container.add(valinta.karttojenValinta(nk), BorderLayout.WEST);
        container.add(peli);
        peli.setFocusable(true);
        
        Liikuttaja liikuttaja = new Liikuttaja(peli);
        frame.addKeyListener(liikuttaja);
        peli.addKeyListener(liikuttaja);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel luoSivupalkki(NappienKuuntelija nk) {
        JPanel palkki = new JPanel(new GridLayout(3, 1));
        
        palkki.add(luoRestart(nk));
        palkki.add(luoHelp(nk));
        palkki.add(luoQuit(nk));
        
        palkki.setFocusable(false);
        return palkki;
    }
    
    private JButton luoRestart(NappienKuuntelija nk) {
        JButton restart = new JButton("Restart");
        restart.addActionListener(nk);
        nk.setRestart(restart);
        return restart;
    }
    
    private JButton luoHelp(NappienKuuntelija nk) {
        JButton help = new JButton("Help");
        help.addActionListener(nk);
        nk.setHelp(help);
        return help;
    }
    
    private JButton luoQuit(NappienKuuntelija nk) {
        JButton quit = new JButton("Quit");
        quit.addActionListener(nk);
        nk.setQuit(quit);
        return quit;
    }
}
