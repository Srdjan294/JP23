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

/**
 *
 * @author srdja
 */
@Entity
public class Clan extends Entitet {
    
    @ManyToOne
    @JoinColumn(name = "grupa", referencedColumnName = "sifra")
    private Grupa grupa;
    @ManyToOne
    @JoinColumn(name = "polaznik", referencedColumnName = "sifra")
    private Polaznik polaznik;

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }
    
    
}
