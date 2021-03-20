/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.model;

import java.util.Date;
import javax.persistence.Entity;

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
    private String email;
    private Date datumRodenja;
    private String spol;

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

    public Date getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(Date datumRodenja) {
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
