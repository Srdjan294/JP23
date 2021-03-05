/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23ver2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author srdja
 */
@Entity
@Table(name = "predavac")
public class Predavac extends Entitet {
    
    @ManyToOne
    @JoinColumn(name = "osoba", nullable = false)
    private Osoba osoba;

    @Column(columnDefinition = "varchar(50)")
    private String iban;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    
}
