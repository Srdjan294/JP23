/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author srdja
 */
@Entity
public class Auto extends Entitet {
    
    private String model;
    private int godiste;
    private int volumenRezervoara;
    private String registracija;
    @ManyToOne
    private Vlasnik vlasnik;
    
    @OneToMany(mappedBy="auto")
    private List<Evidencija> evidencije = new ArrayList<>();

    public List<Evidencija> getEvidencije() {
        return evidencije;
    }

    public void setEvidencije(List<Evidencija> evidencije) {
        this.evidencije = evidencije;
    }
    
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public int getVolumenRezervoara() {
        return volumenRezervoara;
    }

    public void setVolumenRezervoara(int volumenRezervoara) {
        this.volumenRezervoara = volumenRezervoara;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String toString() {
        return getModel();
    }
    
    
}
