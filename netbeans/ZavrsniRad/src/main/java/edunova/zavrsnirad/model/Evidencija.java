/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author srdja
 */
@Entity
public class Evidencija extends Entitet {
    
    @ManyToOne
    private Auto auto;
    private Date datum;
    private int natocenoLitara;
    private int ukupnaCijena;
    private int pocetnoStanje;
    private int zavrsnoStanje;
    @OneToOne
    @JoinTable(name = "evidencija_oznaka",
            joinColumns = { @JoinColumn(name = "evidencija") },
            inverseJoinColumns = { @JoinColumn(name = "oznaka") } )
    private Oznaka oznaka;

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getNatocenoLitara() {
        return natocenoLitara;
    }

    public void setNatocenoLitara(int natocenoLitara) {
        this.natocenoLitara = natocenoLitara;
    }

    public int getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setUkupnaCijena(int ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }

    public int getPocetnoStanje() {
        return pocetnoStanje;
    }

    public void setPocetnoStanje(int pocetnoStanje) {
        this.pocetnoStanje = pocetnoStanje;
    }

    public int getZavrsnoStanje() {
        return zavrsnoStanje;
    }

    public void setZavrsnoStanje(int zavrsnoStanje) {
        this.zavrsnoStanje = zavrsnoStanje;
    }

    public Oznaka getOznaka() {
        return oznaka;
    }

    public void setOznaka(Oznaka oznaka) {
        this.oznaka = oznaka;
    }
    
    

   
}
