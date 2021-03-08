/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Oznaka;
import edunova.zavrsnirad.util.EdunovaException;
import java.util.List;

/**
 *
 * @author srdja
 */
public class ObradaOznaka extends Obrada<Oznaka> {

    @Override
    public List<Oznaka> getPodaci() {
        return session.createQuery("from Oznaka").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
         konrolaNaziv();   
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        kontrolaCreate();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    //kontrola Naziv
    private void konrolaNaziv() throws EdunovaException {
       kontrolaNazivPostavljen();
       kontrolaNazivDuzina();
    }

    private void kontrolaNazivPostavljen() throws EdunovaException {
        if(entitet.getNaziv() == null || entitet.getNaziv().isEmpty()){
            throw new EdunovaException("Naziv mora biti postavljen");
        }
    }

    private void kontrolaNazivDuzina() throws EdunovaException {
        if(entitet.getNaziv().length()>50){
            throw new EdunovaException("Naziv predugačak");
        }
    }
    
}
