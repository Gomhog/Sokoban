
package sokoban.logiikka;



/**
 * Täältä löytyvät kaikki neljä liikkumissuuntaa: YLOS vastaa askelta ylös jne.
 * 
 */
public enum Suunta {
    YLOS (-1, 0),
    ALAS (1, 0),
    VASEN (0, -1),
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
