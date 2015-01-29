
package logiikka;



public enum Suunta {
    YLOS (-1,0),
    ALAS (1,0),
    VASEN (0,-1),
    OIKEA (0,1);
    
    private final int[] suunta;
    Suunta(int i, int j) {
        suunta = new int[]{i,j};
    }
    
    public int[] muutos() {
        return suunta;
    }
}
