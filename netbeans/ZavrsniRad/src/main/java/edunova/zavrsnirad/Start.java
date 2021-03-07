/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        
        Vlasnik v = new Vlasnik();
        v.setIme("Srđan");
        v.setPrezime("Filipović");
        v.setSpol("muško");
        v.setOib("75919144249");
        
        ObradaVlasnik ov = new ObradaVlasnik();
        ov.setEntitet(v);
        
        try {
    
              ov.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
//        Session s = HibernateUtil.getSession();
//        System.out.println(s.getMetamodel().getEntities().size());
//        s.beginTransaction();
//        s.getTransaction().commit();
    }
    
}
