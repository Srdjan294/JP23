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
public class Osoba extends Entitet {
    
    @Column(columnDefinition = "varchar(50)", name="ime")
    private String ime;
    @Column(columnDefinition = "varchar(50)", name="prezime")
    private String prezime;
    @Column(columnDefinition = "char(11)", name="oib")
    private String oib;
    @Column(columnDefinition = "varchar(50)", name="email")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
