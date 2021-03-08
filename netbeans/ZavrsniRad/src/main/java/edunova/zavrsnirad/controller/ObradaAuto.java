/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.util.EdunovaException;
import java.util.List;

/**
 *
 * @author srdja
 */
public class ObradaAuto extends Obrada<Auto> {

    @Override
    public List<Auto> getPodaci() {
        return session.createQuery("from Auto").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaModel();
        kontrolaGodiste();
        kontrolaVolumenRezervoara();
        kontrolaRegistracija();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    //kontrola Model
    private void kontrolaModel() throws EdunovaException {
        kontrolaModelPostavljen();
        kontrolaModelDuzina();
    }

    private void kontrolaModelPostavljen() throws EdunovaException {
        if(entitet.getModel() == null || entitet.getModel().isEmpty()){
            throw new EdunovaException("Model mora biti postavljen");
        }
    }

    private void kontrolaModelDuzina() throws EdunovaException {
        if(entitet.getModel().length() > 50){
            throw new EdunovaException("Naziv modela predugačak");
        }
    }

    //kontrola Godiste
    private void kontrolaGodiste() throws EdunovaException {
         if(entitet.getGodiste() <= 0){
            throw new EdunovaException("Godiste ne smije biti negativno i mora biti veće od nule");
        }
    }

    //kontrola VolumenRezorvoara
    private void kontrolaVolumenRezervoara() throws EdunovaException {
        if(entitet.getVolumenRezervoara() <= 0){
            throw new EdunovaException("Volumen rezervoara ne smije biti negativan i mora biti veći od nule");
        }
    }

    //kontrola Registracija
    private void kontrolaRegistracija() throws EdunovaException {
        kontrolaRegistracijaPostavljena();
        kontrolaRegistracijaDuzina();
    }

    private void kontrolaRegistracijaPostavljena() throws EdunovaException {
        if(entitet.getRegistracija() == null || entitet.getRegistracija().isEmpty()){
            throw new EdunovaException("Registracija mora biti postavljena");
        }
    }

    private void kontrolaRegistracijaDuzina() throws EdunovaException {
        if(entitet.getRegistracija().length() > 50){
            throw new EdunovaException("Registracija predugačka");
        }
    }

    

}