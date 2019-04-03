/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NPC;

import Hra.Prikaz;
import Hrac.Hrac;
import Itemy.Inventar;
import Itemy.ISIC;
import Itemy.Item;

/**
 *
 * @author kajanek6
 */
public class Predavac extends NPC {

    private Inventar inventar;

    public Predavac(String nazov, String privitanie) {
        super(nazov, privitanie);
        this.inventar = new Inventar();
    }

    public void pridajItem(Item item) {
        this.inventar.vlozItem(item);
    }

    @Override
    public boolean pouziPrikazNPC(Prikaz prikaz, Hrac hrac) {
        switch (prikaz.getNazov()) {
            case "ponuka": {
                this.inventar.vypisItemy();
                return true;
            }
            case "kup": {
                String nazovItemu = prikaz.getParameter();
                Item nakupovany = this.inventar.getItem(nazovItemu);
                if (nakupovany == null) {
                    System.out.println("NPC nema item.");
                    return true;
                }
                
                Item temp = hrac.getInventar().getItem("ISIC");
                if (temp instanceof ISIC) {
                    ISIC isic = (ISIC)temp;
                    int kredit = isic.getKredit();
                    if (kredit < nakupovany.getCena()) {
                        System.out.println("Nemas dost penazi.");
                        return true;
                    }
                    isic.modifikujKredit(-nakupovany.getCena());
                    hrac.getInventar().vlozItem(this.inventar.vyberItem(nazovItemu));
                    return true;
                }
                System.out.println("ISIC nebol najdeny.");
                return true;
            }
            default:
                return super.pouziPrikazNPC(prikaz, hrac);
        }
    }

    @Override
    public boolean jePrikazNPC(String nazov) {
        switch (nazov) {
            case "ponuka":
                return true;
            case "kup":
                return true;
            default:
                return super.jePrikazNPC(nazov);
        }
    }

    @Override
    public void vypisPrikazyNPC() {
        System.out.print("ponuka kup ");
        super.vypisPrikazyNPC();
    }

}
