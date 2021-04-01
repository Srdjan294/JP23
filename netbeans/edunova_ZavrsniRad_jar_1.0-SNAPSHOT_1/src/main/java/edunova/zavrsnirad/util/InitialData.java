/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Vlasnik;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class InitialData {
    
    public static void main(String[] args) throws ParseException {
        
        
        
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        Vlasnik v1 = new Vlasnik();
        v1.setIme("John");
        v1.setPrezime("Smith");
        v1.setBrojMobitela("0981231234");
        //v1.setDatumRodenja(df.parse("12-12-1990"));
        v1.setEmail("johnsmith@gmail.com");
        v1.setSpol("muško");
        v1.setOib("34778518124");
        
        Vlasnik v2 = new Vlasnik();
        v2.setIme("Ana");
        v2.setPrezime("Anić");
        v2.setBrojMobitela("0981235678");
        //v2.setDatumRodenja(df.parse("13-10-1999"));
        v2.setEmail("anaanic@gmail.com");
        v2.setSpol("žensko");
        v2.setOib("50913258259");
        
        Vlasnik v3 = new Vlasnik();
        v3.setIme("Pero");
        v3.setPrezime("Perić");
        v3.setBrojMobitela("0987657654");
        //v3.setDatumRodenja(df.parse("01-05-1995"));
        v3.setEmail("peroperic@gmail.com");
        v3.setSpol("muško");
        v3.setOib("38868120045");
        
        ObradaVlasnik ov1 = new ObradaVlasnik();
        ov1.setEntitet(v1);
        
        try {
            ov1.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());;
        }
        
        ObradaVlasnik ov2 = new ObradaVlasnik();
        ov2.setEntitet(v2);
        
        try {
            ov2.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());;
        }
        
        ObradaVlasnik ov3 = new ObradaVlasnik();
        ov3.setEntitet(v3);
        
        try {
            ov3.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());;
        }
    }
    
}
