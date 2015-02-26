
package sokoban.tiedostoluku;


import java.io.*;
import sokoban.logiikka.Kartta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostoLukijaTest {
    
    public TiedostoLukijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        File hakemisto = new File("level");
        hakemisto.mkdir();
        PrintWriter toimivaTesti = null;
        PrintWriter vaaraMerkki = null;
        PrintWriter pelaajanHuonoSijainti = null;
        PrintWriter liikaaUloskaynteja = null;
        PrintWriter palikoitaVahan = null;
        PrintWriter palikkaHuonossaPaikkaa = null;
        PrintWriter palikkaPelaajanPaalla = null;
        

        try {
            toimivaTesti = new PrintWriter("level/Toimiva_Testi.lvl", "UTF-8");
            toimivaTesti.println("4 5\n" + ".....\n" + ".....\n" + "....S\n" +
                ".#E#.\n" + "1 2\n" + "1\n" + "2 2");
            vaaraMerkki = new PrintWriter("level/Vaara_Merkki.lvl", "UTF-8");
            vaaraMerkki.write("4 5\n" + ".....\n" + ".....\n" + ".*..S\n" +
                ".#E#.\n" + "1 2\n" + "1\n" + "2 2");
            pelaajanHuonoSijainti = new PrintWriter("level/Huono_SijaintiP.lvl", "UTF-8");
            pelaajanHuonoSijainti.write("4 5\n" + ".....\n" + ".....\n" + "....S\n" +
                ".#E#.\n" + "4 2\n" + "1\n" + "2 2");
            liikaaUloskaynteja = new PrintWriter("level/Liikaa_Ulos.lvl", "UTF-8");
            liikaaUloskaynteja.write("4 5\n" + "...E.\n" + ".....\n" + "....S\n" +
                ".#E#.\n" + "1 2\n" + "1\n" + "2 2");
            palikoitaVahan = new PrintWriter("level/PalikoitaVahan.lvl", "UTF-8");
            palikoitaVahan.println("4 5\n" + ".....\n" + ".....\n" + "....S\n" +
                "S#E#.\n" + "1 2\n" + "1\n" + "2 2");
            palikkaHuonossaPaikkaa = new PrintWriter("level/HuonoPalikka.lvl", "UTF-8");
            palikkaHuonossaPaikkaa.println("4 5\n" + ".....\n" + ".....\n" + "....S\n" +
                ".#E#.\n" + "1 2\n" + "1\n" + "3 1");
            palikkaPelaajanPaalla = new PrintWriter("level/Paallekkain.lvl", "UTF-8");
            palikkaPelaajanPaalla.println("4 5\n" + ".....\n" + ".....\n" + "....S\n" +
                ".#E#.\n" + "1 2\n" + "1\n" + "1 2");
        } catch (IOException ex) {
            System.out.println("ÄÄÄK");
        } finally {
            try {
                toimivaTesti.close();
                vaaraMerkki.close();
                pelaajanHuonoSijainti.close();
                liikaaUloskaynteja.close();
                palikoitaVahan.close();
                palikkaHuonossaPaikkaa.close();
                palikkaPelaajanPaalla.close();
            } catch (Exception ex) {
                System.out.println("KÄÄK");
            }
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        File testi1 = new File("level/Toimiva_Testi.lvl");
        File testi2 = new File("level/Vaara_Merkki.lvl");
        File testi3 = new File("level/Huono_SijaintiP.lvl");
        File testi4 = new File("level/Liikaa_Ulos.lvl");
        File testi5 = new File("level/PalikoitaVahan.lvl");
        File testi6 = new File("level/HuonoPalikka.lvl");
        File testi7 = new File("level/Paallekkain.lvl");

        testi1.delete();
        testi2.delete();
        testi3.delete();
        testi4.delete();
        testi5.delete();
        testi6.delete();
        testi7.delete();

        File testiHakemisto = new File("level");
        testiHakemisto.delete();
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void vaaraNimiEiLuoKarttaa() {
        Kartta kartta = TiedostoLukija.lueKartta("EiOleOlemassa.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void vaaraMerkkiEiLuoKarttaa() {
        Kartta kartta = TiedostoLukija.lueKartta("Vaara_Merkki.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void huonollaPelaajanLahdollaEiKarttaa() {
        Kartta kartta = TiedostoLukija.lueKartta("Huono_SijaintiP.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void eiSaaOllaKahtaUlos() {
        Kartta kartta = TiedostoLukija.lueKartta("Liikaa_Ulos.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void pitaaOllaUloskaynti() {
        Kartta kartta = TiedostoLukija.lueKartta("PalikoitaVahan.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void palikoitaPitaaRiittaa() {
        Kartta kartta = TiedostoLukija.lueKartta("PalikoitaVahan.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void palikkaaEiSaaHuonoonRuutuun() {
        Kartta kartta = TiedostoLukija.lueKartta("HuonoPalikka.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void palikkaaJaPelaajaaEiPaallekkain() {
        Kartta kartta = TiedostoLukija.lueKartta("Paallekkain.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void karttaSyntyy() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertNotNull(kartta);
    }
    
    @Test
    public void kartanKorkeusOikein() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertEquals(kartta.getKokoY(),4);
    }
    
    @Test
    public void kartanLeveysOikein() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertEquals(kartta.getKokoX(),5);
    }
    
    @Test
    public void kartanSeinatOikein() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertFalse(kartta.getLiikkuvuus().getPaaseekoPelaaja(3, 1));
    }
    
    @Test
    public void kytkinRuudussa() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertEquals(kartta.getMaaObjektit().getKytkinX(0),4);
    }
    
    @Test
    public void uloskayntiOikeassaPaikassa() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertEquals(kartta.getMaaObjektit().getUloskayntiY(),3);
    }
    
    @Test
    public void pelaajaOikeassaPaikassa() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertEquals(kartta.getPelaajaY(),1);
    }
    
    @Test
    public void palikkaOikeassaPaikassa() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertTrue(kartta.getPalikat().onkoPalikkaa(2, 2));
    }
}
