package Hra;


import Dvere.Dvere;
import Itemy.IItemy;
import Itemy.Kluc;
import java.util.HashMap;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marek13
 */
public class Mapa {
    private HashMap<String, Miestnost> miestnosti;
    
    public Mapa() {
        this.miestnosti = new HashMap<>();
        this.vytvorMiestnosti();
    }
    
    private void vytvorMiestnosti() {
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa", "terasa - jeden z hlavnych vstupov na fakultu");
        this.miestnosti.put(terasa.getNazov(), terasa);
        Miestnost aula = new Miestnost("aula", "aula nwm na co sluzi");
        this.miestnosti.put(aula.getNazov(), aula);
        Miestnost bufet = new Miestnost("bufet", "ham ham");
        this.miestnosti.put(bufet.getNazov(), bufet);
        Miestnost labak = new Miestnost("labak", "pocitacove laboratorium");
        this.miestnosti.put(labak.getNazov(), labak);
        Miestnost kancelaria = new Miestnost("kancelaria", "kancelaria spravcu pocitacoveho laboratoria");
        this.miestnosti.put(kancelaria.getNazov(), kancelaria);
        
        Miestnost chodba = new Miestnost("chodba", "v rohu stoji nejaky divny typek");
        this.miestnosti.put(chodba.getNazov(), chodba);
        Miestnost wc = new Miestnost("wc", "to bolo len tak tak");
        this.miestnosti.put(wc.getNazov(), wc);
        Miestnost chill = new Miestnost("chill zone", "tu sa pekne rozloz");
        this.miestnosti.put(chill.getNazov(), chill);
        Miestnost atomKryt = new Miestnost("atomovy kryt", "tento kryt vydrzi aj najsilnejsiu slabu prehanku");
        this.miestnosti.put(atomKryt.getNazov(), atomKryt);
        Miestnost kumbal = new Miestnost("kumbal", "len nejake stare kramy");
        this.miestnosti.put(kumbal.getNazov(), kumbal);
        Miestnost vratnica = new Miestnost("vratnica", "vitaj / ahoj");
        this.miestnosti.put(vratnica.getNazov(), vratnica);
        Miestnost schody = new Miestnost("schody", "ziskany novy uspech: 12486 schodov");
        this.miestnosti.put(schody.getNazov(), schody);
        Miestnost vytah = new Miestnost("vytah", "po 34 minutach si konecne dorazil");
        this.miestnosti.put(vytah.getNazov(), vytah);
        Miestnost atrium = new Miestnost("atrium", "nemam co dodat");
        this.miestnosti.put(atrium.getNazov(), atrium);
        Miestnost tajKomnata = new Miestnost("tajomna_komnata", "co tu asi najdem?");
        this.miestnosti.put(tajKomnata.getNazov(), tajKomnata);
        
        // inicializacia miestnosti = nastavenie vychodov
        //vratnica
        Dvere vratnicaChodba = new Dvere(vratnica, chodba);
        vratnica.nastavVychod(vratnicaChodba);
        //chodba
        chodba.nastavVychod(kumbal);
        chodba.nastavVychod(vratnicaChodba);
        chodba.nastavVychod(chill);
        chodba.nastavVychod(vytah);
        chodba.nastavVychod(schody);
        chodba.nastavVychod(bufet);
        //kumbal
        kumbal.nastavVychod(chodba);
        //vytah
        vytah.nastavVychod(chodba);
        vytah.nastavVychod(atrium);
        //schody
        schody.nastavVychod(chodba);
        schody.nastavVychod(atrium);
        //atrium
        atrium.nastavVychod(schody);
        atrium.nastavVychod(vytah);
        atrium.nastavVychod(bufet);
        atrium.nastavVychod(atomKryt);
        //atom kryt
        atomKryt.nastavVychod(atrium);
        //vychod terasa
        terasa.nastavVychod(aula);
        terasa.nastavVychod(labak);
        terasa.nastavVychod(bufet);
        //vychod auly
        aula.nastavVychod(terasa);
        //vychod bufet
        bufet.nastavVychod(terasa);
        bufet.nastavVychod(atrium);
        bufet.nastavVychod(wc);
        bufet.nastavVychod(chodba);
        //wc
        wc.nastavVychod(bufet);
        //chill
        chill.nastavVychod(chodba);
        chill.nastavVychod(labak);
        //vychod labak
        labak.nastavVychod(terasa);
        labak.nastavVychod(kancelaria);
        labak.nastavVychod(chill);
        // vychod kancel
        kancelaria.nastavVychod(labak);
        // tajomna komnata
        
        // itemy
        HashMap<String, IItemy> itemyVratnice = new HashMap<>();
        IItemy kluc = new Kluc("kanca", "Kluc od kancelarie", 1);
        itemyVratnice.put(kluc.getNazov(), kluc);
        vratnica.pridajItemy(itemyVratnice);
    }
    
    public Miestnost getMiestnost(String nazov) {
        return this.miestnosti.get(nazov);
    }
}
