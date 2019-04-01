package Hra;


import Dvere.IDvere;
import Dvere.ZamykatelneDvere;
import Hrac.Hrac;
import Itemy.Item;
import Itemy.Sekera;
import NPC.NPC;
import java.util.Collection;
import java.util.Random;

/**
 * Trieda Hra je hlavna trieda aplikacie "World of FRI".
 * "World of FRI" je velmi jednoducha textova hra - adventura. 
 * Hrac sa moze prechadzat po niektorych priestoroch - miestnostiach fakulty. 
 * To je v tejto verzii vsetko. Hru treba skutocne zancne rozsirit,
 * aby bola zaujimava.
 * 
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy Hra (hra) 
 * a poslite jej spravu hraj.
 * 
 * Hra vytvori a inicializuje vsetky potebne objekty:
 * vytvori vsetky miestnosti, vytvori parser a zacne hru. Hra tiez vyhodnocuje
 * a vykonava prikazy, ktore vrati parser.
 * 
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
*/
 
public class Hra  {
    private Parser parser;
    private Mapa mapa;
    private Hrac hrac;
    //private Miestnost aktualnaMiestnost;
    
    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        this.mapa = new Mapa();
        this.hrac = new Hrac(this, mapa.getMiestnost("terasa"));
        this.parser = new Parser(this.hrac);
    }

    /**
     * Vytvori mapu hry - miestnosti.
     */

    /**
     *  Hlavna metoda hry.
     *  Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {            
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.
                
        boolean jeKoniec;
        
        do {
            Prikaz prikaz = this.parser.nacitajPrikaz();
            jeKoniec = this.vykonajPrikaz(prikaz);
        } while (!jeKoniec);
        
        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        System.out.println("Teraz si v miestnosti " + this.hrac.getAktualnaMiestnost().getPopis());
        System.out.print("Vychody: ");
        this.hrac.getAktualnaMiestnost().vypisVychody();
        System.out.println();
    }

    /**
     * Prevezne prikaz a vykona ho.
     * 
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    private boolean vykonajPrikaz(Prikaz prikaz) {
        boolean jeKoniec = false;

        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();
        NPC aktualneNPC = this.hrac.getAktualneNPC();
        if (aktualneNPC != null) {
            aktualneNPC.pouziPrikazNPC(prikaz, hrac);
            return false;
        }
        
        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz);
                return false;
            case "ukonci":
                return this.ukonciHru(prikaz);
            case "teleport":
                this.teleport(prikaz);
                return false;
            case "pozri":
                this.pozri(prikaz);
                return false;
            case "zober":
                this.zober(prikaz);
                return false;
            case "vypisInventar":
                this.vypisInventar(prikaz);
                return false;
            case "rubDvere": this.rubDvere(prikaz); return false;
            default: break;
        }
        Miestnost miestnost = this.hrac.getAktualnaMiestnost();
        if (miestnost instanceof IPrikaz) {
            boolean success = ((IPrikaz) miestnost).pouzi(prikaz, this.hrac);
            if (success)
                return false;
        }
        Collection<IDvere> dvereMiestnosti = miestnost.getVsetkyDvere();
        for (IDvere dvere : dvereMiestnosti) {
            if (dvere instanceof IPrikaz) {
                boolean success = ((IPrikaz) dvere).pouzi(prikaz, this.hrac);
                if (success)
                    return false;
            }
        }
        Collection<NPC> npcMiestnosti = miestnost.getVsetkyNPC();
        for (NPC npc : npcMiestnosti) {
            if (npc instanceof IPrikaz) {
                boolean success = ((IPrikaz) npc).pouzi(prikaz, this.hrac);
                if (success)
                    return false;
            }
        }
        Collection<Item> itemyHraca = this.hrac.getInventar().getVsetkyItemy();
        for (Item item : itemyHraca) {
            if (item instanceof IPrikaz) {
                boolean success = ((IPrikaz) item).pouzi(prikaz, this.hrac);
                if (success)
                    return false;
            }
        }
        return false;
    }

    // implementacie prikazov:

    /**
     * Vypise text pomocnika do terminaloveho okna.
     * Text obsahuje zoznam moznych prikazov.
     */
    private void vypisNapovedu() {        
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        NazvyPrikazov.vypisPrikazy();
        Miestnost miestnost = this.hrac.getAktualnaMiestnost();
        if (miestnost instanceof IPrikaz) {
            ((IPrikaz) miestnost).vypisPrikazy();
        }
        Collection<IDvere> dvereMiestnosti = miestnost.getVsetkyDvere();
        for (IDvere dvere : dvereMiestnosti) {
            if (dvere instanceof IPrikaz) {
                ((IPrikaz) dvere).vypisPrikazy();
            }
        }
        Collection<NPC> npcMiestnosti = miestnost.getVsetkyNPC();
        for (NPC npc : npcMiestnosti) {
            if (npc instanceof IPrikaz) {
                ((IPrikaz) npc).vypisPrikazy();
            }
        }
        Collection<Item> itemyHraca = this.hrac.getInventar().getVsetkyItemy();
        for (Item item : itemyHraca) {
            if (item instanceof IPrikaz) {
                ((IPrikaz) item).vypisPrikazy();
            }
        }
    }

    /** 
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    private void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String nazovMiestnosti = prikaz.getParameter();

        IDvere dvere = this.hrac.getAktualnaMiestnost().getDvere(nazovMiestnosti);
        if (dvere == null) {
            System.out.println("Dvere sa nenasli.");
            return;
        }
        
        if (!dvere.skusPrejst(hrac)) {
            System.out.println("Nepodarilo sa prejst cez dvere.");
            return;
        }
        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Miestnost novaMiestnost = dvere.dajDruhuMiestnost(hrac.getAktualnaMiestnost());

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.hrac.chodDoMiestnosti(novaMiestnost);
        }
    }

    /** 
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * Prikaz ukoncenia nema parameter.
     * 
     * @return true, if this command quits the game, false otherwise.
     * @return true, ak prikaz konci hru, inak false.
     */
    private boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }
    
    private void teleport(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("TP kam?");
            return;
        }

        String nazovMiestnosti = prikaz.getParameter();
        this.hrac.teleportujDoMiestnosti(nazovMiestnosti);
    }

    public Mapa getMapa() {
        return mapa;
    }

    private void pozri(Prikaz prikaz) {
        this.hrac.getAktualnaMiestnost().vypisNPC();
        this.hrac.getAktualnaMiestnost().vypisItemy();
    }
    
    private void zober(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Nenapisal si nazov itemu.");
            return;
        }

        Item item = this.hrac.getAktualnaMiestnost().zoberItem(prikaz.getParameter());
        if (item == null) {
            System.out.println("Item sa nenasiel.");
            return;
        }
        
        this.hrac.getInventar().vlozItem(item);
    }

    private void vypisInventar(Prikaz prikaz) {
        this.hrac.getInventar().vypisItemy();
    }
    
    private void rubDvere(Prikaz prikaz) {
        // mam sekeru
        Item item = this.hrac.getInventar().getItem("sekera");
        if (item == null) {
            System.out.println("Hrac nema sekeru.");
            return;
        }
        if (item instanceof Sekera) {
            Sekera sekera = (Sekera)item;
            // existuju dvere
            String nazovDveri = prikaz.getParameter();
        
            IDvere dvere = this.hrac.getAktualnaMiestnost().getDvere(nazovDveri);
            if (dvere == null) {
                System.out.println("Dvere sa nenasli.");
                return;
            }
            // su rozbite dvere
            if (dvere.getSilaMaterialu() == 0) {
                System.out.println("Dvere su uz rozbite.");
                return;
            }
            // zniz silu dveri
            int zranenie = sekera.getZranenie();
            dvere.znizSiluMaterialu(zranenie);
            // pouzi sekeru
            if (sekera.pouzi()) {
                // je sekera znicena -> vymaz ju
                this.hrac.getInventar().vyberItem("sekera");
            }
        } else {
            System.out.println("Hrac ma item co sa vola sekera ale nie je sekerou. Nema sa nikdy stat.");
            return;
        }            
    }
}
