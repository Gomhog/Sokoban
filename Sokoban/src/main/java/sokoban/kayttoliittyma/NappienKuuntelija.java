package sokoban.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Luokan tehtävänä on käsitellä käyttöliittymän nappuloiden painaminen.
 * Settereissä poistetaan komponenttien focusoituvuus, koska näppäimistön
 * kuuntelija ei toiminut ilman.
 * 
 * Nappulat laitetaan aluksi tilaan, joka vastaa epäaktiivista peliruutua.
 */
public class NappienKuuntelija implements ActionListener {
    private JList<String> karttalista;
    private PeliRuutu ruutu;
    private JButton start;
    private JButton restart;
    private JButton help;
    private JButton quit;
    private JScrollPane valinta;

    /**
     * Luo kuuntelijan, joka vaikuttaa peliruutuun.
     * @param ruutu PeliRuutu, johon nappien painamisen halutaan vaikuttavan.
     */
    public NappienKuuntelija(PeliRuutu ruutu) {
        this.ruutu = ruutu;
    }
    
    
    //TODO: pilko
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            ruutu.lataaKartta(karttalista.getSelectedValue());
            ruutu.repaint();
            if (ruutu.aktiivinen()) {
                napitPelitilaan();
            }
        } else if (ae.getSource() == restart) {
            ruutu.aloitaAlusta();
            ruutu.repaint();
//        } else if (ae.getSource() == help) {
//            
        } else if (ae.getSource() == quit) {
            ruutu.lopeta();
            ruutu.repaint();
            napitValintatilaan();
        }
    }

    public void setKarttalista(JList<String> karttalista) {
        this.karttalista = karttalista;
        karttalista.setFocusable(false);
    }

    public void setStart(JButton start) {
        this.start = start;
        start.setFocusable(false);
    }

    public void setRestart(JButton restart) {
        this.restart = restart;
        restart.setEnabled(false);
        restart.setFocusable(false);
    }

    public void setHelp(JButton help) {
        this.help = help;
        help.setEnabled(false);
        help.setFocusable(false);
    }

    public void setQuit(JButton quit) {
        this.quit = quit;
        quit.setEnabled(false);
        quit.setFocusable(false);
    }
    
    public void setValinta(JScrollPane valinta) {
        this.valinta = valinta;
        valinta.setFocusable(false);
    }
    
    private void napitValintatilaan() {
        start.setEnabled(true);
        restart.setEnabled(false);
        quit.setEnabled(false);
        valinta.setEnabled(true);
        karttalista.setEnabled(true);
    }
    
    private void napitPelitilaan() {
        start.setEnabled(false);
        restart.setEnabled(true);
        quit.setEnabled(true);
        valinta.setEnabled(false);
        karttalista.setEnabled(false);
    }
}