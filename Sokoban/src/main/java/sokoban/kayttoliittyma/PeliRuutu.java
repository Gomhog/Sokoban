package sokoban.kayttoliittyma;


import java.awt.*;
import javax.swing.JPanel;
import sokoban.logiikka.Kartta;
import sokoban.tiedostoluku.TiedostoLukija;



public class PeliRuutu extends JPanel {
    private String nimi;
    private Kartta kartta;
    private LiikkuvuusPiirto pohja;
    private MaaObjektitPiirto pysyvat;
    private PalikkaPiirto palikat;
    private PelaajaPiirto pelaaja;
    
    public PeliRuutu() {
        super.setBackground(Color.BLACK);
        kartta = null;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        if (kartta == null) {
            return;
        }
        
        pohja.piirra(graphics);
        pysyvat.piirra(graphics);
        palikat.piirra(graphics);
        pelaaja.piirra(graphics);
    }

    public void lataaKartta(String nimi) {
        this.kartta = TiedostoLukija.lueKartta(nimi);
        this.nimi = nimi;
        if (kartta == null) {
            return;
        }
        this.pohja = new LiikkuvuusPiirto(kartta);
        this.pysyvat = new MaaObjektitPiirto(kartta);
        this.palikat = new PalikkaPiirto(kartta);
        this.pelaaja = new PelaajaPiirto(kartta);
    }
    
    public void aloitaAlusta() {
        this.kartta = TiedostoLukija.lueKartta(nimi);
        this.pohja = new LiikkuvuusPiirto(kartta);
        this.pysyvat = new MaaObjektitPiirto(kartta);
        this.palikat = new PalikkaPiirto(kartta);
        this.pelaaja = new PelaajaPiirto(kartta);
    }
    
    
}