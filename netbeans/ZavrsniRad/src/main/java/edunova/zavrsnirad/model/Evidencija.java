/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private LocalDate datum;
    private BigDecimal natocenoLitara;
    private int pocetnoStanje;
    private int zavrsnoStanje;
    @ManyToOne
    private Gorivo gorivo;
    @ManyToMany 
    private List<Oznaka> oznaka = new ArrayList<>();

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public BigDecimal getNatocenoLitara() {
        return natocenoLitara;
    }

    public void setNatocenoLitara(BigDecimal natocenoLitara) {
        this.natocenoLitara = natocenoLitara;
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

    public List<Oznaka> getOznaka() {
        return oznaka;
    }

    public void setOznaka(List<Oznaka> oznaka) {
        this.oznaka = oznaka;
    }

    public Gorivo getGorivo() {
        return gorivo;
    }

    public void setGorivo(Gorivo gorivo) {
        this.gorivo = gorivo;
    }

    @Override
    public String toString() {
        return getDatum().toString();
    }
   
}
