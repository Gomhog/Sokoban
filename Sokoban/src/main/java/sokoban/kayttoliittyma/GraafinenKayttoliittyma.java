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
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(layout);
        
        container.add(frame);
        container.add(luoSivupalkki());
    }

    public JFrame getFrame() {
        return frame;
    }
    
    private JPanel luoSivupalkki() {
        JPanel palkki = new JPanel(new GridLayout(3,1));
        palkki.add(new JButton("Restart"));
        palkki.add(new JButton("Quit"));
        palkki.add(new JButton("Help"));
        return palkki;
    }
}
