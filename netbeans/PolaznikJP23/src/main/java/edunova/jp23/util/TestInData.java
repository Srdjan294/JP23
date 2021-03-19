/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import edunova.jp23.model.Predavac;
import java.text.SimpleDateFormat;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class TestInData {
    
    public static void main(String[] args) {
        
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        Predavac v1 = new Predavac();
        v1.setIme("John");
        v1.setEmail("john@gmail.com");
        
        v1.setOib("12121212121");
        
        s.save(v1);
        
        s.getTransaction().commit();
    }
}
