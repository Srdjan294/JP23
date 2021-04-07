/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Mjesto;
import edunova.jp23.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.CacheMode;

/**
 *
 * @author srdja
 */
public class ObradaMjesto extends Obrada<Mjesto> {
    

    @Override
    public List<Mjesto> getPodaci() {
        List<Mjesto> lista = session.createQuery("from Mjesto").list();
        return lista;
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
       
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
       
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    
    
    
}
