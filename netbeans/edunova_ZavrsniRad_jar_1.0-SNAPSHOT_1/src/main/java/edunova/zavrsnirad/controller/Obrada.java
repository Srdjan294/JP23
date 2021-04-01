/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected Session session;
    protected Validator validator;
    
    public abstract List<T> getPodaci();
    protected abstract void kontrolaCreate() throws EdunovaException;
    protected abstract void kontrolaUpdate() throws EdunovaException;
    protected abstract void kontrolaDelete() throws EdunovaException;

    public Obrada() {
        this.session = HibernateUtil.getSession();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public Obrada(T entitet) {
        this();
        this.entitet = entitet;
    }
    
    public T create() throws EdunovaException{
        kontrola();
        kontrolaCreate();
        save();
        return this.entitet;
    }
    
    public T update() throws EdunovaException{
        kontrola();
        kontrolaUpdate();
        save();
        return this.entitet;
    }
    
    public boolean delete() throws EdunovaException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(this.entitet);
        session.getTransaction().commit();
        return true;
    }
    
    private void save() {
        session.beginTransaction();
        session.save(this.entitet);
        session.getTransaction().commit();
    }
    
    private void kontrola() throws EdunovaException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(this.entitet);
        
        if(constraintViolations.size() > 0){
            StringBuilder sb = new StringBuilder();
            for(ConstraintViolation<T> violation: constraintViolations){
                sb.append(violation.getMessage());
                sb.append(", ");
            }
            
            throw new EdunovaException(sb.toString());
        }
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

    

    
    
    
    
    
    
}
