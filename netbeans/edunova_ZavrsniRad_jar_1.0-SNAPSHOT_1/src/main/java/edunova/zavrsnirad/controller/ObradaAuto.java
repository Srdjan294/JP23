/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Evidencija;
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
        kontrolaVlasnik();
        kontrolaGodiste();
        kontrolaRegistracija();
        kontrolaVolumenRezervoara();
        kontrolaNoviRegistracijaDupli();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaModel();
        kontrolaVlasnik();
        kontrolaGodiste();
        kontrolaRegistracija();
        kontrolaVolumenRezervoara();
        kontrolaPromjenaRegistracijaDupli();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
         if(!entitet.getEvidencije().isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Auto ne možete obrisati jer je u evidenciji: ");
            for(Evidencija e : entitet.getEvidencije()){
                sb.append(e.getDatum());
                sb.append(", ");
            }
            throw new EdunovaException(sb.toString());
        }
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
            throw new EdunovaException("Godište mora biti postavljeno");
        }
    }

    //kontrola VolumenRezorvoara
    private void kontrolaVolumenRezervoara() throws EdunovaException {
        if(entitet.getVolumenRezervoara() <= 0){
            throw new EdunovaException("Volumen rezervoara mora biti postavljen");
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

    private void kontrolaVlasnik() throws EdunovaException {
        if(entitet.getVlasnik().getId() == -1L){
            throw new EdunovaException("Vlasnik mora biti postavljen");
        }
    }

    private void kontrolaNoviRegistracijaDupli() throws EdunovaException {
        List<Auto> l = session
                       .createQuery("from Auto a where a.registracija=:registracija")
                       .setParameter("registracija", entitet.getRegistracija())
                       .list();
        
        if(l != null && l.size() > 0){
            throw new EdunovaException("Auto s istom registracijom već postoji");
        }
    }

    private void kontrolaPromjenaRegistracijaDupli() throws EdunovaException {
         List<Auto> l = session
                       .createQuery("from Auto a where a.registracija=:registracija and a.id!=:id")
                       .setParameter("id",  entitet.getId())
                       .setParameter("registracija", entitet.getRegistracija())
                       .list();
        
        if(l != null && l.size() > 0){
            throw new EdunovaException("Auto s istom registracijom već postoji");
        }
    }

    

}