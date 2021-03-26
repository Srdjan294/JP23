/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaGorivo;
import edunova.zavrsnirad.model.Gorivo;
import java.math.BigDecimal;

/**
 *
 * @author srdja
 */
public class InitDataGorivo {
    
    public static void main(String[] args) {
        
        Gorivo g1 = new Gorivo();
        g1.setNaziv("Eurosuper 95");
        g1.setCijena(new BigDecimal(10.25));
        
        ObradaGorivo og1 = new ObradaGorivo();
        og1.setEntitet(g1);
        
        Gorivo g2 = new Gorivo();
        g2.setNaziv("Eurodizel");
        g2.setCijena(new BigDecimal(9.69));
        
        ObradaGorivo og2 = new ObradaGorivo();
        og2.setEntitet(g2);
        
        Gorivo g3 = new Gorivo();
        g3.setNaziv("Autoplin");
        g3.setCijena(new BigDecimal(4.94));
        
        ObradaGorivo og3 = new ObradaGorivo();
        og3.setEntitet(g3);
        
        try {
            og1.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        try {
            og2.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        try {
            og3.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
    }
    
}
