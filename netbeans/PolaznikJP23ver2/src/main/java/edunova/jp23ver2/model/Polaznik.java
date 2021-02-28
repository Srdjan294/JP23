/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23ver2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author srdja
 */
@Entity
public class Polaznik extends Osoba {
    
    @Column(columnDefinition = "varchar(50)", name="brojugovora")
    private String brojUgovora;
    @Column(columnDefinition = "int(11)", name="osoba")
    private Osoba osoba;

    public String getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(String brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
    
    
    
    
}
