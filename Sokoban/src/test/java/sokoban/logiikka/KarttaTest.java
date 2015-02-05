
package sokoban.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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
        kartta.getLiikkuvuus().lisaaSeina(3, 1);
        kartta.getLiikkuvuus().lisaaSeina(3, 3);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kentanKorkeusOikein() {
        assertEquals(kartta.getKokoY(),4);
    }
    
    @Test
    public void kentanLeveysOikein() {
        assertEquals(kartta.getKokoX(),5);
    }
    
    @Test
    public void kenttaEiOleHetiLapi() {
        assertFalse(kartta.ratkaistu());
    }
    
    @Test
    public void pelaajaLiikkuu() {
        kartta.liikutaPelaajaa(Suunta.YLOS);
        assertEquals(kartta.getPelaajaY(),0);
    }
    
    @Test
    public void kenttaEiLapiElleiPelaajaUloskaynnilla() {
        kartta.liikutaPelaajaa(Suunta.VASEN);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        for (int i = 0; i<2;i++) {
            kartta.liikutaPelaajaa(Suunta.OIKEA);
        }
        assertFalse(kartta.ratkaistu());
    }
    
    @Test
    public void eiRiitaEttaUloskaynnilla() {
        kartta.liikutaPelaajaa(Suunta.VASEN);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        kartta.liikutaPelaajaa(Suunta.OIKEA);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        assertFalse(kartta.ratkaistu());
    }
    
    @Test
    public void pelaajaTyontaaPalikkaaJaOnOikeassaPaikassa() {
        kartta.liikutaPelaajaa(Suunta.ALAS);
        assertEquals(kartta.getPelaajaY(),2);
    }
    
    @Test
    public void pelaajanTyontamaPalikkaOnOikeassaPaikassa() {
        kartta.liikutaPelaajaa(Suunta.ALAS);
        assertTrue(kartta.getPalikat().onkoPalikkaa(3, 2));
    }
    
    @Test
    public void pelaajaEiLiikuPalikkaan() {
        kartta.liikutaPelaajaa(Suunta.VASEN);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        for (int i = 0; i<3;i++) {
            kartta.liikutaPelaajaa(Suunta.OIKEA);
        }
        assertEquals(kartta.getPelaajaX(),3);
    }
    
    @Test
    public void pelaajaEiKaveleSeinaan() {
        kartta.liikutaPelaajaa(Suunta.VASEN);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        kartta.liikutaPelaajaa(Suunta.ALAS);
        assertEquals(kartta.getPelaajaY(),2);
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
