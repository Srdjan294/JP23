/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Operater;
import edunova.zavrsnirad.util.EdunovaException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author srdja
 */
public class ObradaOperater extends Obrada<Operater> {
    
    public Operater autoriziraj(String email, char[] lozinka){
        
        Operater oper = (Operater)session
                        .createQuery("from Operater o where o.email=:email")
                        .setParameter("email", email)
                        .getSingleResult();
        if(oper == null){
            return null;
        }
        return BCrypt.checkpw(new String(lozinka),oper.getLozinka()) ? oper : null;
    }

    @Override
    public List<Operater> getPodaci() {
        return session.createQuery("from Operater").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaEmail();
        kontrolaLozinka();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    private void kontrolaIme() throws EdunovaException {
        kontrolaImePostavljen();
        kontrolaImeDuzina();
    }

    private void kontrolaImePostavljen() throws EdunovaException {
        if(entitet.getIme() == null || entitet.getIme().isEmpty()){
            throw new EdunovaException("Ime mora biti postavljeno");
        }
    }

    private void kontrolaImeDuzina() throws EdunovaException {
        if(entitet.getIme().length() > 25){
            throw new EdunovaException("Ime predugačko");
        }
    }

    private void kontrolaPrezime() throws EdunovaException {
        kontrolaPrezimePostavljen();
        kontrolaPrezimeDuzina();
    }

    private void kontrolaPrezimePostavljen() throws EdunovaException {
        if(entitet.getPrezime() == null || entitet.getPrezime().isEmpty()){
            throw new EdunovaException("Prezime mora biti postavljeno");
        } 
    }

    private void kontrolaPrezimeDuzina()  throws EdunovaException {
        if(entitet.getPrezime().length() > 25){
            throw new EdunovaException("Prezime predugačko");
        }
    }

    private void kontrolaEmail() throws EdunovaException {
        if(entitet.getEmail() == null || entitet.getEmail().isEmpty()){
            throw new EdunovaException("Email mora biti postavljen");
        }
    }

    private void kontrolaLozinka() throws EdunovaException {
        if(entitet.getLozinka() == null || entitet.getLozinka().isEmpty()){
            throw new EdunovaException("Lozinka mora biti postavljena");
        }
    }
    
}
