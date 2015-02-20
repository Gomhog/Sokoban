package sokoban.kayttoliittyma;


import java.awt.*;
import javax.swing.JPanel;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.Suunta;
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
        if (kartta.ratkaistu()) {
            winner(graphics);
        }
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
    
    public void lopeta() {
        this.kartta = null;
    }
    
    public boolean aktiivinen() {
        return kartta != null;
    }
    
    public void liiku(Suunta suunta) {
        if (!kartta.ratkaistu()) {
            kartta.liikutaPelaajaa(suunta);
        }
    }
    
    private void winner(Graphics g) {
        g.setColor(Color.PINK);
        g.drawString("A WINNER IS YOU", 30, 30);
    }
}