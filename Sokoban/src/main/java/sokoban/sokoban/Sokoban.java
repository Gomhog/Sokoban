package sokoban.sokoban;

import sokoban.kayttoliittyma.GraafinenKayttoliittyma;


/**
 * Tämä on pääluokka, joka käynnistää graafisen käyttöliittymän Sokobanin 
 * pelaamiseen.
 * 
 */
public class Sokoban {
    /**
     * Projektin main-metodi. 
     * @param args
     */
    public static void main(String[] args) {
        GraafinenKayttoliittyma ui = new GraafinenKayttoliittyma();
        ui.run();
    }
}
