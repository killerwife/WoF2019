/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NPC;

import Hra.IPrikaz;
import Hra.Prikaz;
import Hrac.Hrac;

/**
 *
 * @author kajanek6
 */
public class NPC implements IPrikaz {
    private String nazov;
    // TODO: prikaz pomoc

    public NPC(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return nazov;
    }    
    
    @Override
    public boolean pouzi(Prikaz prikaz, Hrac hrac) {
        if (prikaz.getNazov().equals("hovor")) {
            String nazovNpc = prikaz.getParameter();
            NPC npc = hrac.getAktualnaMiestnost().getNPC(nazovNpc);
            if (npc == null) {
                System.out.println("Takeho nikoho tu nevidim.");
                return true;
            }
            hrac.setAktualneNPC(npc);
            npc.vypisPrikazyNPC();
            return true;
        }
        return false;
    }  
    
    @Override
    public boolean jePrikaz(String nazov) {
        return nazov.equals("hovor");
    }

    @Override
    public void vypisPrikazy() {
        System.out.println("hovor ");
    }
    
    public void vypisPrikazyNPC() {
        System.out.println("nehovor ");
    }
    
    public boolean jePrikazNPC(String nazov) {
        return nazov.equals("nehovor");
    }
    
    public boolean pouziPrikazNPC(Prikaz prikaz, Hrac hrac) {
        return false;
    }
}
