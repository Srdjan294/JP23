/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Auto;
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
        kontrolaOIB();
        kontrolaNoviOibDupli();
        kontrolaDatumRodenja();
        kontrolaBrojMobitela();
        kontrolaEmail();
        kontrolaSpol();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOIB();
        kontrolaPromjenaOibDupli();
        kontrolaDatumRodenja();
        kontrolaBrojMobitela();
        kontrolaEmail();
        kontrolaSpol();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if(!entitet.getAuti().isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Vlasnika ne možete obrisati jer posjeduje auto: ");
            for(Auto a : entitet.getAuti()){
                sb.append(a.getModel());
                sb.append(", ");
            }
            throw new EdunovaException(sb.toString());
        }
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
        if(entitet.getPrezime() == null || entitet.getPrezime().isEmpty()){
            throw new EdunovaException("Prezime mora biti postavljeno");
        }
    }

    private void kontrolaPrezimeDuzina() throws EdunovaException {
        if(entitet.getPrezime().length() > 25){
            throw new EdunovaException("Prezime predugačko");
        }
    }
    
    //kontrola Spol
    private void kontrolaSpol() throws EdunovaException {
        if(!"muško".equals(entitet.getSpol()) && !"žensko".equals(entitet.getSpol())){
            throw new EdunovaException("Spol mora biti \"muško\" ili \"žensko\"");
        }
    }

    //kontrola OIB
    private void kontrolaOIB() throws EdunovaException {
        kontrolaOibPostavljen();
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
    
    private void kontrolaOibPostavljen() throws EdunovaException {
        if(entitet.getOib() == null || entitet.getOib().isEmpty()){
            throw new EdunovaException("OIB mora biti postavljen");
        }
    }

    private void kontrolaNoviOibDupli() throws EdunovaException {
        List <Vlasnik> l = session
                        .createQuery("from Vlasnik v where v.oib=:oib")
                        .setParameter("oib", entitet.getOib())
                        .list();
        if(l != null && l.size() > 0){
            throw new EdunovaException("Vlasnik s istim OIB-om postoji");
        }
    }
    
    private void kontrolaPromjenaOibDupli() throws EdunovaException {
        List <Vlasnik> l = session
                        .createQuery("from Vlasnik v where v.oib=:oib and v.id!=:id")
                        .setParameter("id", entitet.getId())
                        .setParameter("oib", entitet.getOib())
                        .list();
        if(l != null && l.size() > 0){
            throw new EdunovaException("Vlasnik s istim OIB-om postoji");
        }
    }

    private void kontrolaDatumRodenja() throws EdunovaException {
        if(entitet.getDatumRodenja() == null){
            throw new EdunovaException("Datum rođenja mora biti postavljen");
        }
    }

    private void kontrolaBrojMobitela() throws EdunovaException {
        if(entitet.getBrojMobitela() == null || entitet.getBrojMobitela().isEmpty()){
            throw new EdunovaException("Broj mobitela mora biti postavljen");
        }
    }

    private void kontrolaEmail() throws EdunovaException {
        if(entitet.getEmail() == null || entitet.getEmail().isEmpty()){
            throw new EdunovaException("Email mora biti postavljen");
        }
    }
    
}
