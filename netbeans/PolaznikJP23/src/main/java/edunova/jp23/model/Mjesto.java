/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import javax.persistence.Entity;

/**
 *
 * @author srdja
 */
@Entity
public class Mjesto extends Entitet {
    
    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    /*
    public class MjestoJson{
    public String mjesto;
    public String postanskiBroj;
    public String opcina;
    public String zupanija;
    }
*/

    @Override
    public String toString() {
        return this.naziv;
    }
    
}
