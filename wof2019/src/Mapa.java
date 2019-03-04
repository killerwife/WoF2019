
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
    private Miestnost aktualnaMiestnost;
    private HashMap<String, Miestnost> miestnosti;
    
    public Mapa() {
        this.miestnosti = new HashMap<>();
        this.vytvorMiestnosti();
    }

    public Miestnost getAktualnaMiestnost() {
        return aktualnaMiestnost;
    }

    public void chodDoMiestnosti(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        System.out.println("Teraz si v miestnosti " + this.aktualnaMiestnost.getNazov() + ": " + this.aktualnaMiestnost.getPopis());
        System.out.print("Vychody: ");
        this.aktualnaMiestnost.vypisVychody();
        System.out.println();
    }
    
    public boolean teleportujDoMiestnosti(String nazov) {
        Miestnost miestnost = miestnosti.get(nazov);
        if (miestnost == null) return false;
        this.aktualnaMiestnost = miestnost;
        System.out.println("Teraz si v miestnosti " + this.aktualnaMiestnost.getNazov() + ": " + this.aktualnaMiestnost.getPopis());
        System.out.print("Vychody: ");
        this.aktualnaMiestnost.vypisVychody();
        System.out.println();
        return true;
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
        vratnica.nastavVychod(chodba);
        //chodba
        chodba.nastavVychod(kumbal);
        chodba.nastavVychod(vratnica);
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
        for (int i = 0; i < 14; ++i) {
            Random rand = new Random();
            if (rand.nextInt(10) == 5) {
                switch (i) {
                    case 0:
                        tajKomnata.nastavVychod(terasa);
                        terasa.nastavVychod(tajKomnata);
                        break;
                    case 1:
                        tajKomnata.nastavVychod(aula);
                        aula.nastavVychod(tajKomnata);
                        break;
                    case 2:
                        tajKomnata.nastavVychod(labak);
                        labak.nastavVychod(tajKomnata);
                        break;
                    case 3:
                        tajKomnata.nastavVychod(kancelaria);
                        kancelaria.nastavVychod(tajKomnata);
                        break;
                    case 4:
                        tajKomnata.nastavVychod(chill);
                        chill.nastavVychod(tajKomnata);
                        break;
                    case 5:
                        tajKomnata.nastavVychod(chodba);
                        chodba.nastavVychod(tajKomnata);
                        break;
                    case 6:
                        tajKomnata.nastavVychod(vratnica);
                        vratnica.nastavVychod(tajKomnata);
                        break;
                    case 7:
                        tajKomnata.nastavVychod(bufet);
                        bufet.nastavVychod(tajKomnata);
                        break;
                    case 8:
                        tajKomnata.nastavVychod(wc);
                        wc.nastavVychod(tajKomnata);
                        break;
                    case 9:
                        tajKomnata.nastavVychod(atrium);
                        atrium.nastavVychod(tajKomnata);
                        break;
                    case 10:
                        tajKomnata.nastavVychod(atomKryt);
                        atomKryt.nastavVychod(tajKomnata);
                        break;
                    case 11:
                        tajKomnata.nastavVychod(kumbal);
                        kumbal.nastavVychod(tajKomnata);
                        break;
                    case 12:
                        tajKomnata.nastavVychod(schody);
                        schody.nastavVychod(tajKomnata);
                        break;
                    case 13:
                        tajKomnata.nastavVychod(vytah);
                        vytah.nastavVychod(tajKomnata);
                        break;
                }
            }
        }

        this.aktualnaMiestnost = vratnica;  // startovacia miestnost hry
    }
}
