/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.math.BigDecimal;
import javax.persistence.Entity;

/**
 *
 * @author srdja
 */
@Entity
public class Gorivo extends Entitet {
    
    private String naziv;
    private BigDecimal cijena;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return getNaziv();
    }
    
    
    
}
