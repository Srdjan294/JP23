/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23ver2.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author srdja
 */
@Entity
@Table(name = "polaznik")
public class Polaznik extends Osoba {
    
    @Column(columnDefinition = "varchar(50)")
    private String brojUgovora;
    @ManyToOne
    @JoinColumn(name = "osoba", referencedColumnName = "sifra", nullable = false)
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

    
    

    
    
    
    
    

