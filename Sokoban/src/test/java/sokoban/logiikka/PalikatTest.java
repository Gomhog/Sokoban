
package sokoban.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PalikatTest {
    
    public PalikatTest() {
    }
    
    Palikat palikat;
    Liikkuvuus liikkuvuus;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        palikat = new Palikat(4,5);
        liikkuvuus = new Liikkuvuus(4,5);
        palikat.lisaaPalikka(0, 1);
        palikat.lisaaPalikka(2, 3);
        palikat.lisaaPalikka(2, 2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alussaEiOlePalikkaa() {
        assertFalse(palikat.onkoPalikkaa(0, 0));
    }
    
    @Test
    public void palikoitaEiKartastaUlkona() {
        assertFalse(palikat.onkoPalikkaa(-1, -1));
    }
    
    @Test
    public void palikanLisaysToimii() {
        assertTrue(palikat.onkoPalikkaa(2, 2));
    }
    
    @Test
    public void palikkaLiikkuu() {
        assertTrue(palikat.siirraPalikkaa(0, 1, Suunta.OIKEA, liikkuvuus));
    }
    
    @Test
    public void palikkaaEiSaaUlos() {
        assertFalse(palikat.siirraPalikkaa(0, 1, Suunta.YLOS, liikkuvuus));
    }
    
    @Test
    public void palikatEiTormaa() {
        assertFalse(palikat.siirraPalikkaa(2, 2, Suunta.OIKEA, liikkuvuus));
    }
    
    @Test
    public void palikkaEiMeneSeinaan() {
        liikkuvuus.lisaaSeina(0, 0);
        assertFalse(palikat.siirraPalikkaa(0, 1, Suunta.VASEN, liikkuvuus));
    }
    
    @Test
    public void palikkaOnUudellaPaikalla() {
        palikat.siirraPalikkaa(0, 1, Suunta.OIKEA, liikkuvuus);
        assertTrue(palikat.onkoPalikkaa(0, 2));
    }
    
    @Test
    public void palikkaEiOleVanhallaPaikalla() {
        palikat.siirraPalikkaa(0, 1, Suunta.OIKEA, liikkuvuus);
        assertFalse(palikat.onkoPalikkaa(0, 1));
    }
    
    @Test
    public void tyhjastaPaikastaEiVoiSiirtaa() {
        assertFalse(palikat.siirraPalikkaa(0, 0, Suunta.ALAS, liikkuvuus));
    }
}
