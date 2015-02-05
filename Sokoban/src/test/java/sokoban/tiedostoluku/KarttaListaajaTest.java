
package sokoban.tiedostoluku;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KarttaListaajaTest {
    
    public KarttaListaajaTest() {
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
            vaaraMerkki = new PrintWriter("level/EiMukaan.md", "UTF-8");
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
        File testi2 = new File("level/EiMukaan.md");
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
    public void lvlTiedostoLoytyy() {
        assertTrue(KarttaListaaja.listaaKartat().contains("Toimiva_Testi.lvl"));
    }
    
    @Test
    public void vaaraPaateEiLoydy() {
        assertFalse(KarttaListaaja.listaaKartat().contains("EiMukaan.md"));
    }
}
