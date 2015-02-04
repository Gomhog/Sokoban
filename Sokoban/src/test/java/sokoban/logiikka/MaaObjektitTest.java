
package sokoban.logiikka;

import sokoban.logiikka.MaaObjektit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MaaObjektitTest {
    
    public MaaObjektitTest() {
    }
    
    MaaObjektit maaObjektit;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        maaObjektit = new MaaObjektit();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kytkimiaAlussaNolla() {
        assertEquals(maaObjektit.getKytkimienMaara(),0);
    }
    
    @Test
    public void kytkimenLisaysKasvattaaMaaraa() {
        maaObjektit.asetaKytkin(1, 1);
        assertEquals(maaObjektit.getKytkimienMaara(),1);
    }
    
    @Test
    public void kytkimienLisaysLisaaKytkimenYKoordinaatin() {
        maaObjektit.asetaKytkin(1, 2);
        assertEquals(maaObjektit.getKytkin(0)[0],1);
    }
    
    @Test
    public void kytkimienLisaysLisaaKytkimenXKoordinaatin() {
        maaObjektit.asetaKytkin(1, 2);
        assertEquals(maaObjektit.getKytkin(0)[1],2);
    }
    
    @Test
    public void uloskaynninYKoordinaattiOikein() {
        maaObjektit.asetaUloskaynti(1, 2);
        assertEquals(maaObjektit.getUloskaynninSijainti()[0],1);
    }
    
    @Test
    public void uloskaynninXKoordinaattiOikein() {
        maaObjektit.asetaUloskaynti(1, 2);
        assertEquals(maaObjektit.getUloskaynninSijainti()[1],2);
    }
}
