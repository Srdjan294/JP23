/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.controller.ObradaAuto;
import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import edunova.zavrsnirad.view.Autorizacija;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        
        //new Autorizacija().setVisible(true);
        
//        Vlasnik v = new Vlasnik();
//        v.setIme("Srđan");
//        v.setPrezime("Filipović");
//        v.setSpol("muško");
//        v.setOib("75919144249");
//        
//        ObradaVlasnik ov = new ObradaVlasnik();
//        ov.setEntitet(v);
//        
//        try {
//    
//              ov.create();
//        } catch (EdunovaException ex) {
//            System.out.println(ex.getPoruka());
//        }

//          Auto a = new Auto();
//          a.setGodiste(2000);
//          a.setModel("Peugeot 307");
//          a.setRegistracija("OS-555-LM");
//          a.setVolumenRezervoara(45);
//          
//          
//          ObradaAuto oa = new ObradaAuto();
//          oa.setEntitet(a);
//          
//          try {
//            oa.create();
//        } catch (EdunovaException ex) {
//              System.out.println(ex.getPoruka());
//        }
//        
          
          
          
        Session s = HibernateUtil.getSession();
        System.out.println(s.getMetamodel().getEntities().size());
        s.beginTransaction();
        s.getTransaction().commit();
    }
    
}
