/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.controller;

import edunova.jp23.util.EdunovaException;
import edunova.jp23.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    
    public abstract List<T> getPodaci();
    protected abstract void kontrolaCreate() throws EdunovaException;
    protected abstract void kontrolaUpdate();
    protected abstract void kontrolaDelete();
    
    public Obrada(){
        this.session = HibernateUtil.getSession();
    }
    
    public Obrada(T entitet){
        this();
        this.entitet = entitet;
    }
    
    public T create() throws EdunovaException{
        kontrolaCreate();
        save();
        return this.entitet;
    }
    
    public T update(){
        kontrolaUpdate();
        save();
        return this.entitet;
    }
     
    public boolean delete(){
        kontrolaDelete();
        session.beginTransaction();
        session.delete(this.entitet);
        session.getTransaction().commit();
        return true;
    }
     
     private void save(){
         session.beginTransaction();
         session.save(this.entitet);
         session.getTransaction().commit();
     }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
}
