/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class ObradaVlasnik extends Obrada<Vlasnik> {

    @Override
    public List<Vlasnik> getPodaci() {
        return session.createQuery("from Vlasnik").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaSpol();
        kontrolaOIB();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    //kontrola Ime
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
    
    //kontrola Prezime
    private void kontrolaPrezime() throws EdunovaException {
        kontrolaPrezimePostavljen();
        kontrolaPrezimeDuzina();
    }

    private void kontrolaPrezimePostavljen() throws EdunovaException {
        if(entitet.getIme() == null || entitet.getIme().isEmpty()){
            throw new EdunovaException("Ime mora biti postavljeno");
        }
    }

    private void kontrolaPrezimeDuzina() throws EdunovaException {
        if(entitet.getIme().length() > 25){
            throw new EdunovaException("Ime predugačko");
        }
    }
    
    //kontrola Spol
    private void kontrolaSpol() throws EdunovaException {
        if(entitet.getSpol() != "muško" && entitet.getSpol() != "žensko"){
            throw new EdunovaException("Spol mora biti muško ili žensko");
        }
    }

    //kontrola OIB
    private void kontrolaOIB() throws EdunovaException {
        if(!oibValjan(entitet.getOib())){
            throw new EdunovaException("OIB nije formalno ispravan");
        }
    }

    private boolean oibValjan(String oib){
        //https://regos.hr/app/uploads/2018/07/KONTROLA-OIB-a.pdf
        if (oib == null || oib.length() != 11) {
            return false;
        }

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i + 1));
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10) {
            kontrolni = 0;
        }
        return kontrolni == Integer.parseInt(oib.substring(10));

    }
}
