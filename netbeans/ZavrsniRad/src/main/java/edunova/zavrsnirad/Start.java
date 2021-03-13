/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad;

import edunova.zavrsnirad.controller.ObradaAuto;
import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import edunova.zavrsnirad.view.Autorizacija;
import edunova.zavrsnirad.view.SplashScreen;
import org.hibernate.Session;

/**
 *
 * @author srdja
 */
public class Start {
    
    public static void main(String[] args) {
        
        new SplashScreen().setVisible(true);
    }
    
}
