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
public class ISIC implements IItemy {
    private String nazov;
    private String popis;
    private int cena;
    private int kredit;

    public ISIC(String nazov, String popis, int cena, int kredit) {
        this.nazov = nazov;
        this.popis = popis;
        this.cena = cena;
        this.kredit = kredit;
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

    public int getKredit() {
        return kredit;
    }
    
    public boolean modifikujKredit(int suma) {
        if (kredit + suma < 0) {
            return false;
        }
        kredit += suma;
        return true;
    }
}
