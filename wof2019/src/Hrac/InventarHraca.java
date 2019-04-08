/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hrac;

import Itemy.Inventar;
import Itemy.Item;
import Itemy.SlotyVybavy;

/**
 *
 * @author kajanek6
 */
public class InventarHraca extends Inventar {
    private Item [] sloty;

    public InventarHraca() {
        this.sloty = new Item[SlotyVybavy.SLOT_MAX.ordinal()];
    }
    
    public void oblecItem(Item item) {
        if (item == null) {
            System.out.println("Item:OblectItem:Preco toto robis.");
            return;
        }
        vyberItem(item.getNazov());
        int slot = item.getSlot().ordinal();
        if (sloty[slot] != null) {
            Item oblecenie = sloty[slot];
            this.vlozItem(oblecenie);
        }
        sloty[slot] = item;
    }
    
    @Override
    public void vypisItemy() {
        for (int i = SlotyVybavy.NIC.ordinal() + 1;
                i < SlotyVybavy.SLOT_MAX.ordinal(); i++) {
            Item item = sloty[i];
            if (item != null)
                System.out.println(item.getSlot().getNazovSlotu() + ": "
                + item.getNazov());
        }
        super.vypisItemy();
    }
}
