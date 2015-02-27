
package sokoban.logiikka;



/**
 * Täältä löytyvät kaikki neljä liikkumissuuntaa: YLOS vastaa askelta ylös jne.
 * 
 */
public enum Suunta {
    /**
     * Askel yhden ruudun verran ylös.
     */
    YLOS (-1, 0),
    /**
     * Askel yhden ruudun verran alas.
     */
    ALAS (1, 0),
    /**
     * Askel yhden ruudun verran vasemmalle.
     */
    VASEN (0, -1),
    /**
     * Askel yhden ruudun verran oikealle.
     */
    OIKEA (0, 1);
    
    private final int suuntaY;
    private final int suuntaX;
    
    
    Suunta(int y, int x) {
        suuntaY = y;
        suuntaX = x;
    }
    

    public int getSuuntaY() {
        return suuntaY;
    }

    public int getSuuntaX() {
        return suuntaX;
    }
    
    
}
