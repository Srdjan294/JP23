/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

/**
 *
 * @author srdja
 */
@Entity
public class Vlasnik extends Entitet {
    
    private String ime;
    private String prezime;
    private String oib;
    private String brojMobitela;
    @Email(message = "Email nije ispravan")
    private String email;
    private LocalDate datumRodenja;
    private String spol;
    
    @OneToMany(mappedBy="vlasnik")
    private List<Auto> auti = new ArrayList<>();

    public List<Auto> getAuti() {
        return auti;
    }

    public void setAuti(List<Auto> auti) {
        this.auti = auti;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela = brojMobitela;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(LocalDate datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }
    
    public String getImePrezime(){
        return getIme() + " " + getPrezime();
    }

    @Override
    public String toString() {
        if(getImePrezime() == null || getImePrezime().trim().isEmpty()){
            return "[Vlasnik nije definiran]";
        }
        return getImePrezime();
    }
    
    
    
}
