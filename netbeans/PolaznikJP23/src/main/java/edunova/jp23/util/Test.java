/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import com.github.javafaker.Faker;
import edunova.jp23.controller.ObradaPolaznik;
import edunova.jp23.model.Polaznik;
import edunova.jp23.model.Smjer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author srdja
 */
public class Test {
    
    public static void main(String[] args) {
        
        /*
        Set<String> set = new HashSet<>();
        set.add("Osijek");
        set.add("Zagreb");
        set.add("Osijek");
        
        Iterator<String> i = set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        
        for(String s: set){
            System.out.println(s);
        }
        
        Map<String,Smjer> map = new Hashtable<>();
        
        Smjer smjer = new Smjer();
        smjer.setNaziv("Prvi");
        
        map.put("kljuc1", smjer);
        
        smjer = new Smjer();
        smjer.setNaziv("Drugi");
        
        map.put("kljuc2", smjer);
        
        System.out.println(map.get("kljuc2").getNaziv());
        
        for(String kljuc: map.keySet()){
            System.out.println(kljuc +": "+ map.get(kljuc).getNaziv());
        }
        
        
        Smjer s = new Smjer();
        s.setId(1L);
        s.setNaziv("Java");
        
        Smjer z = new Smjer();
        z.setId(1L);
        z.setNaziv("Java");
        
        System.out.println(s.hashCode());
        System.out.println(z.hashCode());
        */
        
        Faker faker = new Faker();
        ObradaPolaznik s = new ObradaPolaznik();
        Polaznik p;
        
        for(int i=0; i<1; i++){
            p=new Polaznik();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            p.setOib(EdunovaUtil.getOIB());
            p.setEmail(faker.internet().emailAddress());
            System.out.println(i + ": " + p.getOib());
            
            s.setEntitet(p);
            try {
                s.create();
            } catch (EdunovaException e) {
                System.out.println(e.getPoruka());
            }
            
        }
    }
}
