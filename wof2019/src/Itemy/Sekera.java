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

    @Override
    public boolean pouzi(Prikaz prikaz, Hrac hrac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean jePrikaz(String nazov) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vypisPrikazy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
