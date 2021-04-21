/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Evidencija;
import edunova.zavrsnirad.model.Oznaka;
import edunova.zavrsnirad.model.Vlasnik;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class InitialData {
    
    public static void main(String[] args) throws ParseException {
        
       Session s = HibernateUtil.getSession();
       s.beginTransaction();
       
       //VLASNICI
       Vlasnik milos = new Vlasnik();
       milos.setIme("Miloš");
       milos.setPrezime("Filipović");
       milos.setOib("28507744778");
       milos.setDatumRodenja(LocalDate.of(1956, Month.OCTOBER, 6));
       milos.setEmail("milos.filipovic@gmail.com");
       milos.setBrojMobitela("0989874943");
       milos.setSpol("muško");
       
       s.save(milos);
       
       Vlasnik eva = new Vlasnik();
       eva.setIme("Eva");
       eva.setPrezime("Filipović");
       eva.setOib("34845713902");
       eva.setDatumRodenja(LocalDate.of(1956, Month.NOVEMBER, 11));
       eva.setEmail("eva.filipovic@gmail.com");
       eva.setBrojMobitela("0984353456");
       eva.setSpol("žensko");
       
       s.save(eva);
       
       Vlasnik srdan = new Vlasnik();
       srdan.setIme("Srđan");
       srdan.setPrezime("Filipović");
       srdan.setOib("05748048739");
       srdan.setDatumRodenja(LocalDate.of(1990, Month.OCTOBER, 13));
       srdan.setEmail("srdjan.filipovic@gmail.com");
       srdan.setBrojMobitela("0981907457");
       srdan.setSpol("muško");
       
       s.save(srdan);
       
       //AUTI
       
       Auto golf = new Auto();
       golf.setModel("Golf 7");
       golf.setVlasnik(milos);
       golf.setGodiste(2017);
       golf.setRegistracija("OS-455-LS");
       golf.setVolumenRezervoara(50);
       
       s.save(golf);
       
       Auto peugeot = new Auto();
       peugeot.setModel("Peugeot 308");
       peugeot.setVlasnik(eva);
       peugeot.setGodiste(2011);
       peugeot.setRegistracija("OS-388-JM");
       peugeot.setVolumenRezervoara(50);
       
       s.save(peugeot);
       
       //EVIDENCIJE
       
       Evidencija golf1 = new Evidencija();
       golf1.setDatum(LocalDate.of(2017, Month.JULY, 17));
       golf1.setAuto(golf);
       golf1.setCijenaGorivaPoLitri(new BigDecimal(9.25));
       golf1.setNatocenoLitara(new BigDecimal(49.04));
       golf1.setPocetnoStanje(7);
       golf1.setZavrsnoStanje(770);
       
       s.save(golf1);
       
       Evidencija golf2 = new Evidencija();
       golf2.setDatum(LocalDate.of(2017, Month.SEPTEMBER, 11));
       golf2.setAuto(golf);
       golf2.setCijenaGorivaPoLitri(new BigDecimal(9.26));
       golf2.setNatocenoLitara(new BigDecimal(41.88));
       golf2.setPocetnoStanje(770);
       golf2.setZavrsnoStanje(1568);
       
       s.save(golf2);
       
       Evidencija golf3 = new Evidencija();
       golf3.setDatum(LocalDate.of(2017, Month.NOVEMBER, 7));
       golf3.setAuto(golf);
       golf3.setCijenaGorivaPoLitri(new BigDecimal(9.28));
       golf3.setNatocenoLitara(new BigDecimal(44.36));
       golf3.setPocetnoStanje(1568);
       golf3.setZavrsnoStanje(2158);
       
       s.save(golf3);
       
       Evidencija golf4 = new Evidencija();
       golf4.setDatum(LocalDate.of(2018, Month.JANUARY, 16));
       golf4.setAuto(golf);
       golf4.setCijenaGorivaPoLitri(new BigDecimal(9.40));
       golf4.setNatocenoLitara(new BigDecimal(40.00));
       golf4.setPocetnoStanje(2158);
       golf4.setZavrsnoStanje(2833);
       
       s.save(golf4);
       
       Evidencija golf5 = new Evidencija();
       golf5.setDatum(LocalDate.of(2018, Month.MARCH, 5));
       golf5.setAuto(golf);
       golf5.setCijenaGorivaPoLitri(new BigDecimal(9.39));
       golf5.setNatocenoLitara(new BigDecimal(42.58));
       golf5.setPocetnoStanje(2833);
       golf5.setZavrsnoStanje(3392);
       
       s.save(golf5);
       
       // OZNAKE
       
       Oznaka ljeto = new Oznaka();
       ljeto.setNaziv("Ljetovanje");
        
       s.save(ljeto);
        
       Oznaka zima = new Oznaka();
       zima.setNaziv("Zimovanje");
        
       s.save(zima);
        
       s.getTransaction().commit();
    }
    
}
