/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaEvidencija;
import edunova.zavrsnirad.model.Evidencija;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author srdja
 */
public class InitDataEvidencija {
    
    public static void main(String[] args) {
        
        Evidencija e = new Evidencija();
        e.setDatum(LocalDate.of(2021, Month.MARCH, 31));
        e.setPocetnoStanje(0);
        e.setZavrsnoStanje(100);
        e.setCijenaGorivaPoLitri(new BigDecimal(9.25));
        e.setNatocenoLitara(new BigDecimal(20.02));
        
        ObradaEvidencija oe = new ObradaEvidencija();
        oe.setEntitet(e);
        
        try {
            oe.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
    }
    
}
