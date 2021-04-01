/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaOperater;
import edunova.zavrsnirad.model.Operater;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author srdja
 */
public class KreirajOperatera {
    
    public static void main(String[] args) {
        
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
        
    }
    
}
