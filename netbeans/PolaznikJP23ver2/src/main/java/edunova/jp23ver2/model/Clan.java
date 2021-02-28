/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23ver2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author srdja
 */
@Entity
public class Clan extends Entitet {
    
    @Column(columnDefinition = "int(11)", name="grupa")
    private Grupa grupa;
    @Column(columnDefinition = "int(11)", name="polaznik")
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
