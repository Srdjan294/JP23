/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Evidencija;
import edunova.zavrsnirad.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author srdja
 */
public class ObradaEvidencija extends Obrada<Evidencija> {

    @Override
    public List<Evidencija> getPodaci() {
        return session.createQuery("from Evidencija").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaNatocenoLitara();
        kontrolaUkupnaCijena();
        kontrolaPocetnoStanje();
        kontrolaZavrsnoStanje();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
       
    }

    //kontrola Natočeno litara
    private void kontrolaNatocenoLitara() throws EdunovaException {
        if(entitet.getNatocenoLitara() == null || entitet.getNatocenoLitara().compareTo(BigDecimal.ZERO) <= 0){
            throw new EdunovaException("Natočeno litara ne smije biti nula ili negativno");
        }
    }

    //kontrola Ukupna cijena
    private void kontrolaUkupnaCijena() throws EdunovaException {
        if(entitet.getUkupnaCijena() == null || entitet.getUkupnaCijena().compareTo(BigDecimal.ZERO) <= 0){
            throw new EdunovaException("Cijena mora biti postavljena i veća od nule");
        }
    }

    //kontrola Početno stanje
    private void kontrolaPocetnoStanje() throws EdunovaException {
        
    }

    //kontrola Završno stanje
    private void kontrolaZavrsnoStanje() throws EdunovaException {
        if(entitet.getZavrsnoStanje() == 0){
            throw new EdunovaException("Zavrsno stanje ne smije biti nula");
        }
    }
    
    
    
}
