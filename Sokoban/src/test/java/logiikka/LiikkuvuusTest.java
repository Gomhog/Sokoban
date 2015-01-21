/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alussaPelaajaPaaseeRuutuihin() {
        assert liikkuvuus.getPaaseekoPelaaja(0,0);
    }
    
    @Test
    public void alussaPalikkaPaaseeRuutuihin() {
        assert liikkuvuus.getPaaseekoPelaaja(0, 0);
    }
}
