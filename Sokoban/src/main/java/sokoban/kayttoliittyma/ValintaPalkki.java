
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
     * 
     * @param nk NappienKuuntelija, joka saa tiedon start-nappulasta ja
     * kuuntelee sitä
     * @return Muotoiltu valintapalkki
     */
    public JPanel karttojenValinta(NappienKuuntelija nk) {
        JPanel palkki = luoPalkki();
        
        JList lista = luoLista(nk);
        palkki.add(luoVierittaja(nk, lista));
        
        palkki.add(luoStart(nk));
        
        
        return palkki;
    }
    
    private JPanel luoPalkki() {
        JPanel palkki = new JPanel();
        GridLayout layout = new GridLayout(4, 1);
        palkki.setLayout(layout);
        palkki.setFocusable(false);
        
        return palkki;
    }
    
    private JList luoLista(NappienKuuntelija nk) {
        JList lista = new JList(kartat);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setVisibleRowCount(5);
        nk.setKarttalista(lista);
        
        return lista;
    }
    
    private JScrollPane luoVierittaja(NappienKuuntelija nk, 
            JList lista) {
        JScrollPane vierittaja = new JScrollPane(lista);
        vierittaja.setPreferredSize(new Dimension(100, 100));
        nk.setValinta(vierittaja);
        
        return vierittaja;
    }
    
    private JButton luoStart(NappienKuuntelija nk) {
        JButton start = new JButton("Start");
        start.addActionListener(nk);
        nk.setStart(start);
        
        return start;
    }
}
