/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        
         Session s = HibernateUtil.getSession();
        
        
        System.out.println(s.getMetamodel().getEntities().size());
        
        s.beginTransaction();
        
        s.getTransaction().commit();
    }
    
}
