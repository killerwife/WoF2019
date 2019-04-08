/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itemy;

/**
 *
 * @author kajanek6
 */
public class Item {
    private String nazov;
    private String popis;
    private int cena;
    private SlotyVybavy slot;

    public Item(String nazov, String popis, int cena, SlotyVybavy slot) {
        this.nazov = nazov;
        this.popis = popis;
        this.cena = cena;
        this.slot = slot;
    }

    public String getNazov() {
        return nazov;
    }

    public String getPopis() {
        return popis;
    }

    public int getCena() {
        return cena;
    }

    public SlotyVybavy getSlot() {
        return slot;
    }
}
