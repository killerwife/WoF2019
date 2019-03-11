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
public class Dvere implements IDvere {
    private Miestnost prva;
    private Miestnost druha;

    public Dvere(Miestnost prva, Miestnost druha) {
        this.prva = prva;
        this.druha = druha;
    }

    @Override
    public boolean isOtvorene() {
        return true;
    }

    @Override
    public boolean skusPrejst(Hrac hrac) {
        return isOtvorene();
    }    

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost prva) {
        return this.prva == prva ? this.druha : this.prva;
    }
}
