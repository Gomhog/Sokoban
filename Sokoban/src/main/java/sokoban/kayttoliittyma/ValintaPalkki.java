
package sokoban.kayttoliittyma;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import sokoban.tiedostoluku.KarttaListaaja;


public class ValintaPalkki {
    private String[] kartat;
    
    public ValintaPalkki() {
        kartat = KarttaListaaja.listaaKartat().toArray(new String[0]);
    }
    
    public JPanel karttojenValinta() {
        JPanel palkki = new JPanel();
        GridLayout layout = new GridLayout(4,1);
        palkki.setLayout(layout);
        
        JList lista = new JList(kartat);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setVisibleRowCount(5);
        
        JScrollPane vierittaja = new JScrollPane(lista);
        vierittaja.setPreferredSize(new Dimension(100,100));
        
        palkki.add(vierittaja);
        palkki.add(new JButton("Start"));
        return palkki;
    }
}
