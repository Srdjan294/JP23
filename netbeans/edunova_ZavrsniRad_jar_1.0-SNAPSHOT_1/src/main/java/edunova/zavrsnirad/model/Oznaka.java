/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author srdja
 */
@Entity
public class Oznaka extends Entitet {
    
    private String naziv;
    @ManyToMany(mappedBy = "oznaka")
    private Set<Evidencija> evidencije = new HashSet<>();

    public Set<Evidencija> getEvidencije() {
        return evidencije;
    }

    public void setEvidencije(Set<Evidencija> evidencije) {
        this.evidencije = evidencije;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
}
