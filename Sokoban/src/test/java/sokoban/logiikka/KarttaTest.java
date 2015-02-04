
package sokoban.logiikka;

import sokoban.logiikka.Kartta;
import sokoban.logiikka.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KarttaTest {
    
    public KarttaTest() {
    }
    
    Kartta kartta;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kartta = new Kartta(4,5);
        kartta.setPelaaja(1, 2);
        kartta.getMaaObjektit().asetaUloskaynti(3, 2);
        kartta.getMaaObjektit().asetaKytkin(2, 4);
        kartta.getPalikat().lisaaPalikka(2, 2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kenttaEiOleHetiLapi() {
        assertFalse(kartta.ratkaistu());
    }
    
    @Test
    public void pelaajaLiikkuu() {
        kartta.liikutaPelaajaa(Suunta.YLOS);
        assertEquals(kartta.getPelaajanSijainti()[0],0);
    }
    
    @Test
    public void kentanSaaLapi() {
        kartta.liikutaPelaajaa(Suunta.VASEN);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        for (int i = 0; i<2;i++) {
            kartta.liikutaPelaajaa(Suunta.OIKEA);
        }
        kartta.liikutaPelaajaa(Suunta.VASEN);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        assertTrue(kartta.ratkaistu());
    }
}
