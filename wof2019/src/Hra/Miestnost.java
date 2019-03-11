package Hra;


import Dvere.IDvere;
import Itemy.IItemy;
import java.util.HashMap;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private String nazovMiestnosti;
    private String popisMiestnosti;
    private HashMap<String, IDvere> vychody;
    private HashMap<String, IItemy> itemy;
    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String nazov, String popis) {
        this.nazovMiestnosti = nazov;
        this.popisMiestnosti = popis;
        this.vychody = new HashMap<>();
        this.itemy = null;
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param sever miestnost smerom na sever.
     * @param vychod miestnost smerom na vychod.
     * @param juh miestnost smerom na juh.
     * @param zapad miestnost smerom na zapad.
     */
    public void nastavVychod(IDvere dvere) {
        this.vychody.put(dvere.dajDruhuMiestnost(this).nazovMiestnosti, dvere);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public String getNazov() {
        return this.nazovMiestnosti;
    }
    
    public void vypisVychody() {
        for (String key: vychody.keySet()) {
            System.out.print(key + " ");
        }      
    }
    
    public IDvere getDvere(String nazovDveri) {
        return this.vychody.get(nazovDveri);
    }

    public Miestnost getMiestnost(String nazovMiestnosti) {
        return this.vychody.get(nazovMiestnosti).dajDruhuMiestnost(this);
    }
    
    public void pridajItemy(HashMap<String, IItemy> itemy) {
        this.itemy = itemy;
    }
    
    public void vypisItemy() {
        if (this.itemy == null)
            return;
        for (IItemy item : this.itemy.values()) {
            System.out.print(item.getNazov() + " ");
        }
        System.out.println("");
    }
    
    public IItemy zoberItem(String nazov) {
        return this.itemy != null ? this.itemy.remove(nazov) : null;
    }
}
