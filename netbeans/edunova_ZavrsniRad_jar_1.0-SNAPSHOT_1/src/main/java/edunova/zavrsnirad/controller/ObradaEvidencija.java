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
        kontrolaDatum();
        kontrolaAuto();
        kontrolaCijenaGoriva();
        kontrolaNatocenoLitara();
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
            throw new EdunovaException("Natočeno litara mora biti postavljeno i veće od nule");
        }
    }

    //kontrola Početno stanje
    private void kontrolaPocetnoStanje() throws EdunovaException {
        if(entitet.getPocetnoStanje() < 0){
            throw new EdunovaException("Početno stanje ne može biti negativno");
        }
    }

    //kontrola Završno stanje
    private void kontrolaZavrsnoStanje() throws EdunovaException {
        if(entitet.getZavrsnoStanje() <= entitet.getPocetnoStanje()){
            throw new EdunovaException("Završno stanje mora biti postavljeno i veće od početnog stanja");
        }
    }

    //kontrola Cijena goriva po litri
    private void kontrolaCijenaGoriva() throws EdunovaException {
        if(entitet.getCijenaGorivaPoLitri() == null || entitet.getCijenaGorivaPoLitri().compareTo(BigDecimal.ZERO) <= 0){
            throw new EdunovaException("Cijena goriva mora biti postavljena i veća od nule");
        }
    }

    private void kontrolaDatum() throws EdunovaException {
       if(entitet.getDatum() == null){
           throw new EdunovaException("Datum mora biti postavljen");
       }
    }

    private void kontrolaAuto() throws EdunovaException {
        if(entitet.getAuto().getId() == -1L){
            throw new EdunovaException("Auto mora biti postavljen");
        }
    }
}
