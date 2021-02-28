/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23ver2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author srdja
 */
@Entity
public class Grupa extends Entitet {
    
    @Column(columnDefinition = "varchar(20)", name="naziv")
    private String naziv;
    @ManyToOne
    @Column(columnDefinition = "int(11)", name="smjer")
    private Smjer smjer;
    @ManyToOne
    @Column(columnDefinition = "int(11)", name="predavac")
    private Predavac predavac;
    @Column(columnDefinition = "datetime", name="datumpocetka")
    private Date datumPocetka;
    @Column(columnDefinition = "int(11)", name="brojpolaznika")
    private Integer brojPolaznika;
    @ManyToMany
    private List<Polaznik> polaznici = new ArrayList<>();

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Smjer getSmjer() {
        return smjer;
    }

    public void setSmjer(Smjer smjer) {
        this.smjer = smjer;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Integer getBrojPolaznika() {
        return brojPolaznika;
    }

    public void setBrojPolaznika(Integer brojPolaznika) {
        this.brojPolaznika = brojPolaznika;
    }

    public List<Polaznik> getPolaznici() {
        return polaznici;
    }

    public void setPolaznici(List<Polaznik> polaznici) {
        this.polaznici = polaznici;
    }
    
    
    
    
}
