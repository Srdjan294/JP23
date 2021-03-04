/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23;

import edunova.jp23.controller.ObradaPolaznik;
import edunova.jp23.controller.ObradaSmjer;
import edunova.jp23.model.Polaznik;
import edunova.jp23.model.Smjer;
import edunova.jp23.util.EdunovaException;
import edunova.jp23.util.InitialFixtures;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        
        //InitialFixtures.start();
        
        /*Smjer s = new Smjer();
        s.setNaziv("");
        s.setCijena(BigDecimal.TEN);
        ObradaSmjer os = new ObradaSmjer();
        os.setEntitet(s);
        
        try {
            os.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }*/
       
//        for(Smjer s : os.getPodaci()){
//            System.out.println(s.getNaziv());
//        }
        
        Polaznik p = new Polaznik();
        p.setIme("Pero");
        p.setPrezime("Zaljubljeni");
        p.setEmail("pero.zaljubljeni@gmail.com");
        p.setOib("03201269716");
        
        ObradaPolaznik op = new ObradaPolaznik();
        op.setEntitet(p);
        
        try {
    
              op.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
              
    }
    
}
