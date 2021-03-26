/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.controller.ObradaAuto;
import edunova.zavrsnirad.controller.ObradaOperater;
import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Operater;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import edunova.zavrsnirad.view.Autorizacija;
import edunova.zavrsnirad.view.SplashScreen;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        
        /*
        Operater o = new Operater();
        o.setIme("Srđan");
        o.setPrezime("Filipović");
        o.setEmail("srdjanfilipovic991@gmail.com");
        o.setLozinka(BCrypt.hashpw("edunova", BCrypt.gensalt()));
        
        ObradaOperater oo = new ObradaOperater();
        oo.setEntitet(o);
        
        try {
            oo.create();
        } catch (EdunovaException e) {
            System.out.println(e.getMessage());
        }
        */
        
        new SplashScreen().setVisible(true);
    }
    
}
