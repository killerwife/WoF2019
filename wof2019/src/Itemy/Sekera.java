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
public class Sekera extends Item {
    private int zranenie;
    private int pocetPouziti;

    public Sekera(String nazov, String popis, int cena, int zranenie, int pocetPouziti) {
        super(nazov, popis, cena);
        this.zranenie = zranenie;
        this.pocetPouziti = pocetPouziti;
    }

    public int getPocetPouziti() {
        return pocetPouziti;
    }

    public int getZranenie() {
        return zranenie;
    }
    
    public boolean pouzi() {
        return --pocetPouziti == 0;
    }
}
