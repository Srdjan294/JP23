/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import com.github.javafaker.Faker;
import edunova.jp23.model.Clan;
import edunova.jp23.model.Grupa;
import edunova.jp23.model.Polaznik;
import edunova.jp23.model.Predavac;
import edunova.jp23.model.Smjer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class InitialFixtures {
    
    public static void main(String[] args){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        Smjer java = new Smjer();
        java.setNaziv("Java programiranje");
        java.setCijena(new BigDecimal(5900.09));
        java.setTrajanje(130);
        java.setVerificiran(Boolean.TRUE);
        
        s.save(java);
        
        Smjer php = new Smjer();
        php.setNaziv("PHP programiranje");
        php.setCijena(new BigDecimal(4900.09));
        php.setTrajanje(130);
        php.setVerificiran(Boolean.FALSE);
        
        s.save(php);
        
        Faker faker = new Faker();
        
        List<Polaznik> polaznici = new ArrayList<>();
        
        Polaznik p;
        
        for(int i=0; i<100; i++){
            p=new Polaznik();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            p.setEmail("pero@gmail.com");
            p.setOib(EdunovaUtil.getOIB());
            s.save(p);
            polaznici.add(p);
        }
        
        Predavac predavac = new Predavac();
        predavac.setIme(faker.name().firstName());
        predavac.setPrezime(faker.name().lastName());
        predavac.setEmail("pero@gmail.com");
        predavac.setOib(EdunovaUtil.getOIB());
        
        s.save(predavac);
        
        Grupa jp23 = new Grupa();
        jp23.setNaziv("XX1");
        jp23.setSmjer(java);
        jp23.setPredavac(predavac);
        
        Collections.shuffle(polaznici);
        Clan c;
        for(int i = 0; i < 19; i++){
            c = new Clan();
            c.setGrupa(jp23);
            c.setPolaznik(polaznici.get(i));
            c.setDatumUpisa(new Date());
            s.save(c);
            jp23.getPolaznici().add(c);
        }
        
        s.save(jp23);
        
        Grupa pp22 = new Grupa();
        pp22.setNaziv("YY1");
        pp22.setSmjer(php);
        pp22.setPredavac(predavac);
        
        Collections.shuffle(polaznici);
        for(int i = 0; i < 19; i++){
            c = new Clan();
            c.setGrupa(pp22);
            c.setPolaznik(polaznici.get(i));
            c.setDatumUpisa(new Date());
            s.save(c);
            pp22.getPolaznici().add(c);
        }
        
        s.save(pp22);
        
        s.getTransaction().commit();
    }
    
}
