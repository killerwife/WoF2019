/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itemy;

import Hra.IPrikaz;
import Hra.Prikaz;
import Hrac.Hrac;

/**
 *
 * @author kajanek6
 */
public class Sekera extends Item implements IPrikaz {
    private int zranenie;
    private int pocetPouziti;

    public Sekera(String nazov, String popis, int cena, int zranenie, int pocetPouziti) {
        super(nazov, popis, cena, SlotyVybavy.ZBRAN);
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

    @Override
    public boolean pouzi(Prikaz prikaz, Hrac hrac) {
        return false;
    }

    @Override
    public boolean jePrikaz(String nazov) {
        return nazov.equals("rubDvere");
    }

    @Override
    public void vypisPrikazy() {
        System.out.println("rubDvere ");
    }
}
