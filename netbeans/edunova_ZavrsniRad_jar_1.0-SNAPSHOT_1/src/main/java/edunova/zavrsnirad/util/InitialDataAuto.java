/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.util;

import edunova.zavrsnirad.controller.ObradaAuto;
import edunova.zavrsnirad.model.Auto;

/**
 *
 * @author srdja
 */
public class InitialDataAuto {
    
    public static void main(String[] args) {
        
        Auto a1 = new Auto();
        a1.setModel("BMW");
        a1.setGodiste(2020);
        a1.setRegistracija("os-333-vd");
        a1.setVolumenRezervoara(40);
       
        
        ObradaAuto oa = new ObradaAuto();
        oa.setEntitet(a1);
        
        try {
            oa.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
    }
}
