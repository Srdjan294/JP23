/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author srdja
 */
@Entity(name = "wp_document")
public class Dokument extends Entitet {
    
    
    @Column(columnDefinition = "char(10)",name = "naslov")
    private String naziv;
    private Date datum;
    private Boolean placen;
    private BigDecimal iznos;
    
    @ManyToOne
    private Kupac kupac;

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }
    
    

   

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Boolean getPlacen() {
        return placen;
    }

    public void setPlacen(Boolean placen) {
        this.placen = placen;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }
    
    
    
}
