/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23;

import edunova.jp23.model.Dokument;
import edunova.jp23.model.Eftitet;
import edunova.jp23.model.Kupac;
import edunova.jp23.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        Session s = HibernateUtil.getSession();
        
        Dokument d = new Dokument();
        d.setDatum(new Date());
        d.setNaziv("Račun");
        d.setPlacen(Boolean.TRUE);
        d.setIznos(new BigDecimal(23.99));
        
        s.beginTransaction();
        
//        Eftitet eftitet;
//        for(int i = 0; i < 12748; i++){
//            eftitet = new Eftitet();
//            eftitet.setDatum(new Date());
//            eftitet.setIznos(new BigDecimal (Math.random()*100));
//            eftitet.setPlacen(i%2 == 0);
//            s.save(eftitet);
//        }
        Kupac k = new Kupac();
        k.setNaziv("Edunova");
        
        s.save(k);
        
        d.setKupac(k);
        
        s.save(d);
        
        s.getTransaction().commit();
        
       
        
        
        //System.out.println(s.getMetamodel().getEntities().size());
        
    }
    
}
