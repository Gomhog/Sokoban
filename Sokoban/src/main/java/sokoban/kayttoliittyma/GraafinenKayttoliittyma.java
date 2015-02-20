package sokoban.kayttoliittyma;

import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;

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
//        BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
//        container.setLayout(layout);
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
        JPanel palkki = new JPanel(new GridLayout(3,1));
        
        JButton restart = new JButton("Restart");
        JButton help = new JButton("Help");
        JButton quit = new JButton("Quit");
        
        palkki.add(restart);
        palkki.add(help);
        palkki.add(quit);
        
        restart.addActionListener(nk);
        help.addActionListener(nk);
        quit.addActionListener(nk);
        
        nk.setRestart(restart);
        nk.setHelp(help);
        nk.setQuit(quit);
        
        palkki.setFocusable(false);
        return palkki;
    }
}
