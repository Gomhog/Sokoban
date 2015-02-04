
package sokoban.logiikka;

import sokoban.logiikka.Liikkuvuus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LiikkuvuusTest {
    
    public LiikkuvuusTest() {
    }
    
    Liikkuvuus liikkuvuus;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        liikkuvuus = new Liikkuvuus(4,5);
        liikkuvuus.lisaaSeina(2, 2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alussaPelaajaPaaseeRuutuihin() {
        assertTrue(liikkuvuus.getPaaseekoPelaaja(0,0));
    }
    
    @Test
    public void alussaPalikkaPaaseeRuutuihin() {
        assertTrue(liikkuvuus.getPaaseekoPelaaja(0, 0));
    }
    
    @Test
    public void pelaajaEiPaaseYlosUlos() {
        assertFalse(liikkuvuus.getPaaseekoPelaaja(-1, 0));
    }
    
    @Test
    public void palikkaEiPaaseAlasUlos() {
        assertFalse(liikkuvuus.getPaaseekoPalikka(4, 0));
    }
    
    @Test
    public void pelaajaEiPaaseVasenUlos() {
        assertFalse(liikkuvuus.getPaaseekoPelaaja(0, -1));
    }
    
    @Test
    public void palikkaEiPaaseOikeaUlos() {
        assertFalse(liikkuvuus.getPaaseekoPalikka(0, 5));
    }
    
    @Test
    public void pelaajaEiPaaseSeinaan() {
        assertFalse(liikkuvuus.getPaaseekoPelaaja(2, 2));
    }
    
    @Test
    public void palikkaEiPaaseSeinaan() {
        assertFalse(liikkuvuus.getPaaseekoPalikka(2, 2));
    }
}
