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
    private String privitanie;
    // TODO: prikaz pomoc

    public NPC(String nazov, String privitanie) {
        this.nazov = nazov;
        this.privitanie = privitanie;
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
            npc.vypisPrivitanie();
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
        switch (prikaz.getNazov()) {
            case "nehovor":
            {
                hrac.setAktualneNPC(null);
                return true;
            }
        }
        return false;
    }

    private void vypisPrivitanie() {
        System.out.println(privitanie);
    }
}
