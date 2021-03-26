/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.model.Gorivo;
import edunova.zavrsnirad.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author srdja
 */
public class ObradaGorivo extends Obrada<Gorivo> {

    @Override
    public List<Gorivo> getPodaci() {
        return session.createQuery("from Gorivo").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaNaziv();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    private void kontrolaNaziv() throws EdunovaException {
        kontrolaNazivPostavljen();
        kontrolaNazivDuzina();
    }

    private void kontrolaNazivPostavljen() throws EdunovaException {
        if(entitet.getNaziv() == null || entitet.getNaziv().isEmpty()){
            throw new EdunovaException("Naziv goriva mora biti postavljen");
        }
    }

    private void kontrolaNazivDuzina() throws EdunovaException {
        if(entitet.getNaziv().length() > 50){
            throw new EdunovaException("Naziv goriva predugačak");
        }
    }

    private void kontrolaCijena() throws EdunovaException {
        if(entitet.getCijena() == null || entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0){
            throw new EdunovaException("Cijena goriva ne smije biti nula ili negativno");
        }
    }
    
}
