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
public class Kluc implements IItemy {
    private String nazov;
    private String popis;
    private int cena;
    // TODO: dvere

    public Kluc(String nazov, String popis, int cena) {
        this.nazov = nazov;
        this.popis = popis;
        this.cena = cena;
    }

    @Override
    public String getNazov() {
        return nazov;
    }

    @Override
    public String getPopis() {
        return popis;
    }

    @Override
    public int getCena() {
        return cena;
    }
    
}
