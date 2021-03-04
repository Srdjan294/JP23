/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Predavac;
import edunova.jp23.util.EdunovaException;
import java.util.List;

/**
 *
 * @author srdja
 */
public class ObradaPredavac extends ObradaOsoba<Predavac> {

    @Override
    public List<Predavac> getPodaci() {
        return session.createQuery("from Predavac").list(); 
    }
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        //onda moje kontrole
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        super.kontrolaUpdate();
        //onda moje kontrole
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
}
