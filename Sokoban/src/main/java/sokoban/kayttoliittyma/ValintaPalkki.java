
package sokoban.kayttoliittyma;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import sokoban.tiedostoluku.KarttaListaaja;


/**
 * Luokan tehtävänä on luoda palkki, josta pelaaja valitsee kartan ja käynnistää
 * sen.
 * 
 */
public class ValintaPalkki {
    private String[] kartat;
    
    /**
     * Valmistelee palkin luomisen keräämällä KarttaListaajan löytämät kartat
     * taulukkoon.
     */
    public ValintaPalkki() {
        kartat = KarttaListaaja.listaaKartat().toArray(new String[0]);
    }
    
    /**
     * Luo palkin taulukoitujen karttojen perusteella. Lisää kuuntelijan
     * aloitusnappulalle. Kuuntelija saa täältä myös listan, josta se
     * näkee ladattavan tiedoston nimen.
     * 
     * TODO: jaa pienempiin metodeihin
     * 
     * @param nk NappienKuuntelija, joka saa tiedon start-nappulasta ja
     * kuuntelee sitä
     * @return Muotoiltu valintapalkki
     */
    public JPanel karttojenValinta(NappienKuuntelija nk) {
        JPanel palkki = new JPanel();
        GridLayout layout = new GridLayout(4,1);
        palkki.setLayout(layout);
        palkki.setFocusable(false);
        
        JList lista = new JList(kartat);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setVisibleRowCount(5);
        nk.setKarttalista(lista);
        
        JScrollPane vierittaja = new JScrollPane(lista);
        vierittaja.setPreferredSize(new Dimension(100,100));
        palkki.add(vierittaja);
        
        
        JButton start = new JButton("Start");
        palkki.add(start);
        start.addActionListener(nk);
        nk.setStart(start);
        
        nk.setValinta(vierittaja);
        
        return palkki;
    }
}
