package Hra;


import Dvere.Dvere;
import Dvere.ZamykatelneDvere;
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
        Dvere kumbalChodba = new Dvere(chodba, kumbal);
        chodba.nastavVychod(kumbalChodba);
        chodba.nastavVychod(vratnicaChodba);
        Dvere chodbaChill = new Dvere(chodba, chill);
        chodba.nastavVychod(chodbaChill);
        Dvere chodbaVytah = new Dvere(chodba, vytah);
        chodba.nastavVychod(chodbaVytah);
        Dvere chodbaSchody = new Dvere(chodba, vytah);
        chodba.nastavVychod(chodbaSchody);
        Dvere chodbaBufet = new Dvere(chodba, bufet);
        chodba.nastavVychod(chodbaBufet);
        //kumbal
        kumbal.nastavVychod(kumbalChodba);
        //vytah
        vytah.nastavVychod(chodbaVytah);
        Dvere vytahAtrium = new Dvere(vytah, atrium);
        vytah.nastavVychod(vytahAtrium);
        //schody
        schody.nastavVychod(chodbaSchody);
        Dvere schodyAtrium = new Dvere(schody, atrium);
        schody.nastavVychod(schodyAtrium);
        //atrium
        atrium.nastavVychod(schodyAtrium);
        atrium.nastavVychod(vytahAtrium);
        Dvere atriumBufet = new Dvere(atrium, bufet);
        atrium.nastavVychod(atriumBufet);
        Dvere atriumAtomKryt = new Dvere(atrium, bufet);
        atrium.nastavVychod(atriumAtomKryt);
        //atom kryt
        atomKryt.nastavVychod(atriumAtomKryt);
        //vychod terasa
        Dvere terasaAula = new Dvere(terasa, aula);
        terasa.nastavVychod(terasaAula);
        Dvere terasaLabak = new Dvere(terasa, labak);
        terasa.nastavVychod(terasaLabak);
        Dvere terasaBufet= new Dvere(terasa, bufet);
        terasa.nastavVychod(terasaBufet);
        //vychod auly
        aula.nastavVychod(terasaAula);
        //vychod bufet
        bufet.nastavVychod(terasaBufet);
        bufet.nastavVychod(atriumBufet);
        Dvere bufetWC= new Dvere(bufet, wc);
        bufet.nastavVychod(bufetWC);
        bufet.nastavVychod(chodbaBufet);
        //wc
        wc.nastavVychod(bufetWC);
        //chill
        chill.nastavVychod(chodbaChill);
        Dvere chillLabak= new Dvere(chill, labak);
        chill.nastavVychod(chillLabak);
        //vychod labak
        labak.nastavVychod(terasaLabak);
        ZamykatelneDvere labakKancelaria =
                new ZamykatelneDvere(labak, kancelaria, "kanca");
        labak.nastavVychod(labakKancelaria);
        labak.nastavVychod(chodbaChill);
        labak.nastavVychod(chillLabak);
        // vychod kancel
        kancelaria.nastavVychod(labakKancelaria);
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
