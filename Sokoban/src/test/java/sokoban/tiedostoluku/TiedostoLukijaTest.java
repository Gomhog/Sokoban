
package sokoban.tiedostoluku;


import sokoban.tiedostoluku.TiedostoLukija;
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
        } catch (IOException ex) {
            System.out.println("ÄÄÄK");
        } finally {
            try {
                toimivaTesti.close();
                vaaraMerkki.close();
                pelaajanHuonoSijainti.close();
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

        testi1.delete();
        testi2.delete();
        testi3.delete();

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
    public void vaaraMerkkiEiLuoKarttaa() {
        Kartta kartta = TiedostoLukija.lueKartta("Vaara_Merkki.lvl");
        assertNull(kartta);
    }
    
    @Test
    public void huonollaPelaajanLahdollaEiKarttaa() {
        Kartta kartta = TiedostoLukija.lueKartta("Huono_SijaintiP");
        assertNull(kartta);
    }
    
    @Test
    public void karttaSyntyy() {
        Kartta kartta = TiedostoLukija.lueKartta("Toimiva_Testi.lvl");
        assertNotNull(kartta);
    }
}
