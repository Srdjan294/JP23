/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edunova.jp23.controller.ObradaMjesto;
import edunova.jp23.model.Mjesto;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srdja
 */
public class UcitajMjesta {
    
    public static void main(String[] args) {
        
        /*
        try {
            Type listType = new TypeToken<ArrayList<Mjesto.MjestoJson>>(){}.getType();
            List<Mjesto.MjestoJson> lista = new Gson().fromJson(
                new String(Files.readAllBytes(Paths.get("popis_naselja_u_republici_hrvatskoj.json")), StandardCharsets.UTF_8)
                , listType);
            System.out.println(lista.size());
            
            Mjesto m;
            ObradaMjesto obrada = new ObradaMjesto();
            
            for(Mjesto.MjestoJson mjestoJson : lista){
                m = new Mjesto();
                m.setNaziv(mjestoJson.mjesto);
                obrada.setEntitet(m);
                try {
                    obrada.create();
                } catch (EdunovaException e) {
                    System.out.println(e.getPoruka());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     */   
    }
    
}
