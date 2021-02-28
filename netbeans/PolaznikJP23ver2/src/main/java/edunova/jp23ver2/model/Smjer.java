/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23ver2.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author srdja
 */
@Entity
public class Smjer extends Entitet {
    
    @Column(columnDefinition = "varchar(50)", name="naziv")
    private String naziv;
    @Column(columnDefinition = "varchar(50)", name="ime")
    private BigDecimal cijena;
    @Column(columnDefinition = "int(11)", name="trajanje")
    private Integer trajanje;
    @Column(columnDefinition = "tinyint(1)", name="verificiran")
    private Boolean verificiran;

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

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public Boolean getVerificiran() {
        return verificiran;
    }

    public void setVerificiran(Boolean verificiran) {
        this.verificiran = verificiran;
    }
    
    
}
