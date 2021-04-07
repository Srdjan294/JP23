/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.model.Clan;
import edunova.jp23.model.Grupa;
import edunova.jp23.util.EdunovaException;
import edunova.jp23.view.Aplikacija;
import java.util.Date;
import java.util.List;
import org.hibernate.CacheMode;

/**
 *
 * @author srdja
 */
public class ObradaGrupa extends Obrada<Grupa> {

    @Override
    public List<Grupa> getPodaci() {
        List<Grupa> lista = session.createQuery("from Grupa").list();
        session.setCacheMode(CacheMode.IGNORE);
        return lista;
    }

    @Override
    public Grupa create() throws EdunovaException {
        session.beginTransaction();
        for(Clan c : entitet.getPolaznici()){
            c.setOperaterUnosa(Aplikacija.operater);
            c.setDatumUnosa(new Date());
            session.save(c);
        }
        kontrolaCreate();
        super.kontrola();
        entitet.setOperaterUnosa(Aplikacija.operater);
        entitet.setDatumUnosa(new Date());
        session.save(entitet);
        session.getTransaction().commit();
        return entitet;
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
