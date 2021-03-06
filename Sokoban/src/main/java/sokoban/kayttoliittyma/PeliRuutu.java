package sokoban.kayttoliittyma;


import java.awt.*;
import javax.swing.JPanel;
import sokoban.logiikka.Kartta;
import sokoban.logiikka.Suunta;
import sokoban.tiedostoluku.TiedostoLukija;



/**
 * Tämä luokka on peliruutu, jossa peliä pelataan.
 * 
 * Peliruutu on aktiivinen, jos sillä on toimiva kartta.
 */
public class PeliRuutu extends JPanel {
    private String nimi;
    private Kartta kartta;
    private LiikkuvuusPiirto pohja;
    private MaaObjektitPiirto pysyvat;
    private PalikkaPiirto palikat;
    private PelaajaPiirto pelaaja;
    
    /**
     * Luo uuden peliruudun. Peliruudun tausta on musta. Aluksi ruutu ei ole 
     * aktiivinen.
     */
    public PeliRuutu() {
        super.setBackground(Color.BLACK);
        kartta = null;
        
    }
    
    //Piirtämiseen voisi olla oma luokka apuna
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

    /**
     * Lukee kartan tiedostosta. Jos lataus onnistuu, asetetaan piirtäjät uuden
     * kartan mukaan.
     * @param nimi Tiedostonimi, josta kartta luetaan.
     */
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
    
    /**
     * Aloittaa kartan alusta lukemalla uudelleen aiemmin syötetyn tiedoston.
     */
    public void aloitaAlusta() {
        this.kartta = TiedostoLukija.lueKartta(nimi);
        this.pohja = new LiikkuvuusPiirto(kartta);
        this.pysyvat = new MaaObjektitPiirto(kartta);
        this.palikat = new PalikkaPiirto(kartta);
        this.pelaaja = new PelaajaPiirto(kartta);
    }
    
    /**
     * Lopettaa pelin poistamalla nykyisen kartan.
     */
    public void lopeta() {
        this.kartta = null;
    }
    
    /**
     * Kertoo, onko peliruutu aktiivinen.
     * @return true, jos ruudulla on toimiva kartta; false, jos ei
     */
    public boolean aktiivinen() {
        return kartta != null;
    }
    
    /**
     * Yrittää liikuttaa kartan pelaajaa annettuun suuntaan.
     * @param suunta Suunta, johon pelaajaa yritetään liikuttaa.
     */
    public void liiku(Suunta suunta) {
        kartta.liikutaPelaajaa(suunta);
        
    }
    
    private void winner(Graphics g) {
        g.setColor(Color.PINK);
        g.drawString("A WINNER IS YOU", 30, 30);
    }
}