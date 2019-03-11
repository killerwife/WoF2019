/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvere;

import Hra.Miestnost;
import Hrac.Hrac;

/**
 *
 * @author kajanek6
 */
public class ZamykatelneDvere implements IDvere {
    private Miestnost prva;
    private Miestnost druha;
    private String nazovKluca;
    private boolean isOtvorene;

    public ZamykatelneDvere(Miestnost prva, Miestnost druha, String nazovKluca) {
        this.prva = prva;
        this.druha = druha;
        this.nazovKluca = nazovKluca;
        this.isOtvorene = false;
    }
    
    @Override
    public boolean isOtvorene() {
        return this.isOtvorene;
    }

    @Override
    public boolean skusPrejst(Hrac hrac) {
       return isOtvorene();
    }

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost prva) {
        return this.prva == prva ? this.druha : this.prva;
    }
    
    public void pouziKluc(Hrac hrac) {
        if (hrac.getInventar().getItem(nazovKluca) != null) {
            if (this.isOtvorene) {
                System.out.println("Dvere sa zamkli.");
            } else {
                System.out.println("Dvere sa odomkli.");
            }            
            this.isOtvorene = !this.isOtvorene;
        }
        else {
            System.out.println("Nebol najdeny spravny kluc.");
        }            
    }
}