/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hra;

import Hrac.Hrac;

/**
 *
 * @author kajanek6
 */
public interface IPrikaz {
    boolean pouzi(Prikaz prikaz, Hrac hrac);
    boolean jePrikaz(String nazov);
    void vypisPrikazy();
}
