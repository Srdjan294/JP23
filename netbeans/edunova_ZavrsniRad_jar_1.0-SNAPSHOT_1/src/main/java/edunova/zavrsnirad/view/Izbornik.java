/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import edunova.zavrsnirad.controller.ObradaAuto;
import edunova.zavrsnirad.controller.ObradaEvidencija;
import edunova.zavrsnirad.controller.ObradaOznaka;
import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Evidencija;
import edunova.zavrsnirad.model.Oznaka;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author srdja
 */
public class Izbornik extends javax.swing.JFrame {
    
    private ObradaVlasnik obradaVlasnik;
    private ObradaAuto obradaAuto;
    private ObradaEvidencija obradaEvidencija;
    private ObradaOznaka obradaOznaka;
    
    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        obradaVlasnik = new ObradaVlasnik();
        obradaAuto = new ObradaAuto();
        obradaEvidencija = new ObradaEvidencija();
        obradaOznaka = new ObradaOznaka();
        setTitle(Aplikacija.NASLOV_APP + " " + 
                Aplikacija.operater.getImePrezime());
        new Vrijeme().start();
        prilagodiDpDatumRodenja();
        prilagodiDpDatum();
        ucitajVlasnike();
        ucitajAute();
        ucitajEvidenciju();
        ucitajOznake();
        ucitajVlasnikecmb();
        ucitajAutecmb();
    }

    private void ucitajVlasnike() {
        
        DefaultListModel<Vlasnik> m = new DefaultListModel<>();
        m.addAll(obradaVlasnik.getPodaci());
        lstVlasnici.setModel(m);
        
    }

    private void ucitajAute() {
        
        DefaultListModel<Auto> m = new DefaultListModel<>();
        m.addAll(obradaAuto.getPodaci());
        lstAuti.setModel(m);
    }

    private void ucitajVlasnikecmb() {
        DefaultComboBoxModel<Vlasnik> m = new DefaultComboBoxModel<>();
        
        Vlasnik v = new Vlasnik();
        v.setId(-1L);
        v.setIme("Odaberite vlasnika: ");
        v.setPrezime("");
        m.addElement(v);
        
        m.addAll(new ObradaVlasnik().getPodaci());
        
        cmbVlasnici.setModel(m);
        cmbVlasnici.setSelectedIndex(0);
    }

    private void prilagodiDpDatumRodenja() {
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr","HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dpDatumRodenja.setSettings(dps);
    }

    private void postaviVrijednostiNaEntitetAuto() {
        var entitet = obradaAuto.getEntitet();
        
        entitet.setModel(txtModel.getText());
        entitet.setVlasnik((Vlasnik) cmbVlasnici.getSelectedItem());
        try {
             entitet.setGodiste(Integer.parseInt(txtGodiste.getText()));
        } catch (Exception e) {
        }
        entitet.setRegistracija(txtRegistracija.getText());
        try {
            entitet.setVolumenRezervoara(Integer.parseInt(txtVolumen.getText()));
        } catch (Exception e) {
        }
    }

    private void pocistiUnoseAuta() {
        txtModel.setText("");
        cmbVlasnici.setSelectedIndex(0);
        txtGodiste.setText("");
        txtRegistracija.setText("");
        txtVolumen.setText("");
    }

    private void ucitajAutecmb() {
        DefaultComboBoxModel<Auto> m = new DefaultComboBoxModel<>();
        
        Auto a = new Auto();
        a.setId(-1L);
        a.setModel("Odaberite auto: ");
        m.addElement(a);
        
        m.addAll(new ObradaAuto().getPodaci());
        cmbAuti.setModel(m);
        
        cmbAuti.setSelectedIndex(0);
    }

    private void ucitajEvidenciju() {
        DefaultListModel<Evidencija> m = new DefaultListModel<>();
        m.addAll(obradaEvidencija.getPodaci());
        lstEvidencija.setModel(m);
    }

    private void prilagodiDpDatum() {
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr","HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dpDatum.setSettings(dps);
    }

    private void postaviVrijednostiNaEntitetEvidencija() {
        var entitet = obradaEvidencija.getEntitet();
        
        entitet.setDatum(dpDatum.getDate());
        entitet.setAuto((Auto) cmbAuti.getSelectedItem());
        try {
            entitet.setCijenaGorivaPoLitri(new BigDecimal(txtCijenaGoriva.getText()).setScale(2,RoundingMode.HALF_UP));
        } catch (Exception e) {
        }
        try {
            entitet.setNatocenoLitara(new BigDecimal(txtNatocenoLitara.getText()).setScale(2, RoundingMode.HALF_UP));
        } catch (Exception e) {
        }
        try {
            entitet.setPocetnoStanje(Integer.parseInt(txtPocetnoStanje.getText()));
        } catch (Exception e) {
        }
        try {
            entitet.setZavrsnoStanje(Integer.parseInt(txtZavrsnoStanje.getText()));
        } catch (Exception e) {
        }
        
        
        
        DefaultListModel<Oznaka> m;
        try {
           m = (DefaultListModel<Oznaka>) lstOznakaEvidencije.getModel();
           entitet.setOznaka(new ArrayList<>());
           for(int i = 0; i < m.getSize(); i++){
               entitet.getOznaka().add(m.get(i));
           }
        } catch (Exception e) {
            
        }
    }

    private void pocistiUnoseEvidencije() {
        dpDatum.setText("");
        cmbAuti.setSelectedIndex(0);
        txtCijenaGoriva.setText("");
        txtNatocenoLitara.setText("");
        txtPocetnoStanje.setText("");
        txtZavrsnoStanje.setText("");
        DefaultListModel listmodel=new DefaultListModel();
        lstOznakaEvidencije.setModel(listmodel);
    }

    private void postaviVrijednostiNaEntitetOznaka() {
        var entitet = obradaOznaka.getEntitet();
        
        entitet.setNaziv(txtNazivOznake.getText());
    }

    private void pocistiUnoseOznake() {
        txtNazivOznake.setText("");
    }

    private void ucitajOznake() {
        DefaultListModel<Oznaka> m = new DefaultListModel<>();
        m.addAll(obradaOznaka.getPodaci());
        lstOznake.setModel(m);
        lstOznakeUApp.setModel(m);
    }

    private class Vrijeme extends Thread{
        
        private SimpleDateFormat df = new SimpleDateFormat("dd. MM. YYYY. HH:mm:ss");

        @Override
        public void run() {
            while(true){
                lblVrijeme.setText(df.format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblVrijeme = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpEvidencija = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEvidencija = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNatocenoLitara = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPocetnoStanje = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtZavrsnoStanje = new javax.swing.JTextField();
        dpDatum = new com.github.lgooddatepicker.components.DatePicker();
        cmbAuti = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCijenaGoriva = new javax.swing.JTextField();
        btnDodajEvidenciju = new javax.swing.JButton();
        btnPromjeniEvidenciju = new javax.swing.JButton();
        btnObrisiEvidenciju = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstOznakaEvidencije = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstOznakeUApp = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        btnDodajUEvidenciju = new javax.swing.JButton();
        btnObrisiIzEvidencije = new javax.swing.JButton();
        btnRadSEvidencijom = new javax.swing.JButton();
        btnPocistiUnoseEvidencije = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btnRadSOznakama = new javax.swing.JButton();
        jpAuti = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAuti = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtGodiste = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRegistracija = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtVolumen = new javax.swing.JTextField();
        cmbVlasnici = new javax.swing.JComboBox<>();
        btnDodajAuto = new javax.swing.JButton();
        btnPromjeniAuto = new javax.swing.JButton();
        btnObrisiAuto = new javax.swing.JButton();
        btnPocistiUnoseAuta = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jpVlasnici = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstVlasnici = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtOib = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtBrojMob = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtSpol = new javax.swing.JTextField();
        dpDatumRodenja = new com.github.lgooddatepicker.components.DatePicker();
        btnDodajVlasnika = new javax.swing.JButton();
        btnPromjeniVlasnika = new javax.swing.JButton();
        btnObrisiVlasnika = new javax.swing.JButton();
        btnPocistiUnoseVlasnika = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jpOznake = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOznake = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        txtNazivOznake = new javax.swing.JTextField();
        btnDodajOznaku = new javax.swing.JButton();
        btnPromjeniOznaku = new javax.swing.JButton();
        btnObrisiOznaku = new javax.swing.JButton();
        btnPocistiUnoseOznake = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmDatoteka = new javax.swing.JMenu();
        jmiEvidencija = new javax.swing.JMenuItem();
        jmiAuti = new javax.swing.JMenuItem();
        jmiVlasnici = new javax.swing.JMenuItem();
        jmiOznake = new javax.swing.JMenuItem();
        jmiIzlaz = new javax.swing.JMenuItem();
        jmRadSEvidencijom = new javax.swing.JMenu();
        jmEra = new javax.swing.JMenu();
        jmOnama = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lblVrijeme.setText("vrijeme");
        jToolBar1.add(lblVrijeme);

        jpEvidencija.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpEvidencijaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lstEvidencija.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEvidencija.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEvidencijaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEvidencija);

        jLabel1.setText("Datum:");

        jLabel3.setText("Auto:");

        jLabel4.setText("Natočeno litara:");

        jLabel6.setText("Početno stanje brojila:");

        jLabel7.setText("Završno stanje brojila:");

        jLabel5.setText("Cijena goriva po litri:");

        btnDodajEvidenciju.setText("Dodaj evidenciju");
        btnDodajEvidenciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajEvidencijuActionPerformed(evt);
            }
        });

        btnPromjeniEvidenciju.setText("Promjeni evidenciju");
        btnPromjeniEvidenciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniEvidencijuActionPerformed(evt);
            }
        });

        btnObrisiEvidenciju.setText("Obriši evidenciju");
        btnObrisiEvidenciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiEvidencijuActionPerformed(evt);
            }
        });

        jLabel21.setText("Oznake evidencije:");

        jScrollPane5.setViewportView(lstOznakaEvidencije);

        jScrollPane6.setViewportView(lstOznakeUApp);

        jLabel20.setText("Oznake: ");

        btnDodajUEvidenciju.setText("<<");
        btnDodajUEvidenciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajUEvidencijuActionPerformed(evt);
            }
        });

        btnObrisiIzEvidencije.setText(">>");
        btnObrisiIzEvidencije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiIzEvidencijeActionPerformed(evt);
            }
        });

        btnRadSEvidencijom.setText("Rad s evidencijom");
        btnRadSEvidencijom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadSEvidencijomActionPerformed(evt);
            }
        });

        btnPocistiUnoseEvidencije.setText("Počisti unose");
        btnPocistiUnoseEvidencije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPocistiUnoseEvidencijeActionPerformed(evt);
            }
        });

        jLabel22.setText("Odaberite evidenciju:");

        btnRadSOznakama.setText("Rad s oznakama");
        btnRadSOznakama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadSOznakamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEvidencijaLayout = new javax.swing.GroupLayout(jpEvidencija);
        jpEvidencija.setLayout(jpEvidencijaLayout);
        jpEvidencijaLayout.setHorizontalGroup(
            jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEvidencijaLayout.createSequentialGroup()
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPocetnoStanje)
                            .addComponent(txtZavrsnoStanje, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(dpDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbAuti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNatocenoLitara, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txtCijenaGoriva)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPromjeniEvidenciju, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(btnDodajEvidenciju, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisiEvidenciju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRadSEvidencijom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPocistiUnoseEvidencije, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpEvidencijaLayout.createSequentialGroup()
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajUEvidenciju)
                                    .addComponent(btnObrisiIzEvidencije))
                                .addGap(18, 18, 18)
                                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRadSOznakama)))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpEvidencijaLayout.setVerticalGroup(
            jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEvidencijaLayout.createSequentialGroup()
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDodajEvidenciju))
                        .addGap(8, 8, 8)
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCijenaGoriva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                                .addComponent(btnPromjeniEvidenciju)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisiEvidenciju)
                                .addGap(32, 32, 32)
                                .addComponent(btnPocistiUnoseEvidencije, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNatocenoLitara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRadSEvidencijom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPocetnoStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtZavrsnoStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btnDodajUEvidenciju)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisiIzEvidencije)
                                .addContainerGap(106, Short.MAX_VALUE))
                            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRadSOznakama)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jpEvidencijaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Evidencija", new javax.swing.ImageIcon(getClass().getResource("/icons8-file-24.png")), jpEvidencija); // NOI18N

        jpAuti.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpAutiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lstAuti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAuti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAutiValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstAuti);

        jLabel2.setText("Model:");

        jLabel8.setText("Vlasnik:");

        jLabel9.setText("Godište:");

        jLabel10.setText("Registracija:");

        jLabel11.setText("Volumen rezervoara:");

        btnDodajAuto.setText("Dodaj auto");
        btnDodajAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajAutoActionPerformed(evt);
            }
        });

        btnPromjeniAuto.setText("Promjeni auto");
        btnPromjeniAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniAutoActionPerformed(evt);
            }
        });

        btnObrisiAuto.setText("Obriši auto");
        btnObrisiAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiAutoActionPerformed(evt);
            }
        });

        btnPocistiUnoseAuta.setText("Počisti unose");
        btnPocistiUnoseAuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPocistiUnoseAutaActionPerformed(evt);
            }
        });

        jLabel23.setText("Odaberite auto:");

        javax.swing.GroupLayout jpAutiLayout = new javax.swing.GroupLayout(jpAuti);
        jpAuti.setLayout(jpAutiLayout);
        jpAutiLayout.setHorizontalGroup(
            jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAutiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGodiste, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbVlasnici, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPromjeniAuto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(btnObrisiAuto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(btnDodajAuto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPocistiUnoseAuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpAutiLayout.setVerticalGroup(
            jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAutiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAutiLayout.createSequentialGroup()
                                .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addComponent(btnDodajAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAutiLayout.createSequentialGroup()
                                .addComponent(cmbVlasnici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGodiste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAutiLayout.createSequentialGroup()
                                .addComponent(btnPromjeniAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisiAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPocistiUnoseAuta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Auti", new javax.swing.ImageIcon(getClass().getResource("/icons8-car-24.png")), jpAuti); // NOI18N

        lstVlasnici.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstVlasnici.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVlasniciValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstVlasnici);

        jLabel12.setText("Ime:");

        jLabel13.setText("Prezime:");

        jLabel14.setText("OIB:");

        jLabel15.setText("Datum rođenja:");

        jLabel16.setText("Broj mobitela:");

        jLabel17.setText("Email:");

        jLabel18.setText("Spol:");

        btnDodajVlasnika.setText("Dodaj vlasnika");
        btnDodajVlasnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajVlasnikaActionPerformed(evt);
            }
        });

        btnPromjeniVlasnika.setText("Promjeni vlasnika");
        btnPromjeniVlasnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniVlasnikaActionPerformed(evt);
            }
        });

        btnObrisiVlasnika.setText("Obriši vlasnika");
        btnObrisiVlasnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiVlasnikaActionPerformed(evt);
            }
        });

        btnPocistiUnoseVlasnika.setText("Počisti unose");
        btnPocistiUnoseVlasnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPocistiUnoseVlasnikaActionPerformed(evt);
            }
        });

        jLabel24.setText("Odaberite vlasnika:");

        javax.swing.GroupLayout jpVlasniciLayout = new javax.swing.GroupLayout(jpVlasnici);
        jpVlasnici.setLayout(jpVlasniciLayout);
        jpVlasniciLayout.setHorizontalGroup(
            jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVlasniciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPromjeniVlasnika, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(btnDodajVlasnika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 502, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSpol, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrojMob, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPocistiUnoseVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpVlasniciLayout.setVerticalGroup(
            jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVlasniciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel24))
                .addGap(4, 4, 4)
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVlasniciLayout.createSequentialGroup()
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addComponent(btnDodajVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVlasniciLayout.createSequentialGroup()
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addComponent(btnPromjeniVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVlasniciLayout.createSequentialGroup()
                                .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15))
                            .addComponent(btnObrisiVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPocistiUnoseVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpVlasniciLayout.createSequentialGroup()
                                .addComponent(dpDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBrojMob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSpol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Vlasnici", new javax.swing.ImageIcon(getClass().getResource("/icons8-user-account-24.png")), jpVlasnici); // NOI18N

        jpOznake.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jpOznakeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lstOznake.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOznake.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOznakeValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstOznake);

        jLabel19.setText("Naziv oznake:");

        btnDodajOznaku.setText("Dodaj oznaku");
        btnDodajOznaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajOznakuActionPerformed(evt);
            }
        });

        btnPromjeniOznaku.setText("Promjeni oznaku");
        btnPromjeniOznaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniOznakuActionPerformed(evt);
            }
        });

        btnObrisiOznaku.setText("Obriši oznaku");
        btnObrisiOznaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiOznakuActionPerformed(evt);
            }
        });

        btnPocistiUnoseOznake.setText("Počisti unose");
        btnPocistiUnoseOznake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPocistiUnoseOznakeActionPerformed(evt);
            }
        });

        jLabel25.setText("Odaberite oznaku:");

        javax.swing.GroupLayout jpOznakeLayout = new javax.swing.GroupLayout(jpOznake);
        jpOznake.setLayout(jpOznakeLayout);
        jpOznakeLayout.setHorizontalGroup(
            jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOznakeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOznakeLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 519, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOznakeLayout.createSequentialGroup()
                        .addComponent(txtNazivOznake, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnObrisiOznaku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPromjeniOznaku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDodajOznaku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPocistiUnoseOznake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpOznakeLayout.setVerticalGroup(
            jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOznakeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOznakeLayout.createSequentialGroup()
                        .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodajOznaku, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNazivOznake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPromjeniOznaku, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisiOznaku, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPocistiUnoseOznake, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Oznake", new javax.swing.ImageIcon(getClass().getResource("/icons8-labels-24.png")), jpOznake); // NOI18N

        jmDatoteka.setText("Datoteka");

        jmiEvidencija.setText("Evidencije");
        jmiEvidencija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEvidencijaActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiEvidencija);

        jmiAuti.setText("Auti");
        jmiAuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAutiActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiAuti);

        jmiVlasnici.setText("Vlasnici");
        jmiVlasnici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVlasniciActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiVlasnici);

        jmiOznake.setText("Oznake");
        jmiOznake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOznakeActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiOznake);

        jmiIzlaz.setText("Izlaz");
        jmiIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIzlazActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiIzlaz);

        jMenuBar1.add(jmDatoteka);

        jmRadSEvidencijom.setText("Rad s evidencijom");
        jmRadSEvidencijom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmRadSEvidencijomMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmRadSEvidencijom);

        jmEra.setText("ERA");
        jmEra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmEraMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmEra);

        jmOnama.setText("O nama");
        jmOnama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmOnamaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmOnama);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmOnamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmOnamaMouseClicked
       Date d = new Date();
       SimpleDateFormat df = new SimpleDateFormat("YYYY");
       JOptionPane.showMessageDialog(rootPane, "© " + Aplikacija.NASLOV_APP + " 2020 - " + df.format(d));
    }//GEN-LAST:event_jmOnamaMouseClicked

    private void jmiEvidencijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEvidencijaActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jmiEvidencijaActionPerformed

    private void jmiAutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAutiActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jmiAutiActionPerformed

    private void jmiVlasniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVlasniciActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jmiVlasniciActionPerformed

    private void jmiOznakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOznakeActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jmiOznakeActionPerformed

    private void jmiIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIzlazActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiIzlazActionPerformed

    private void lstVlasniciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVlasniciValueChanged
        
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        if(lstVlasnici.getSelectedValue() == null){
            return;
        }
        
        obradaVlasnik.setEntitet(lstVlasnici.getSelectedValue());
        
        txtIme.setText(obradaVlasnik.getEntitet().getIme());
        txtPrezime.setText(obradaVlasnik.getEntitet().getPrezime());
        txtOib.setText(obradaVlasnik.getEntitet().getOib());
        dpDatumRodenja.setDate(obradaVlasnik.getEntitet().getDatumRodenja());
        txtBrojMob.setText(obradaVlasnik.getEntitet().getBrojMobitela());
        txtEmail.setText(obradaVlasnik.getEntitet().getEmail());
        txtSpol.setText(obradaVlasnik.getEntitet().getSpol());
        
    }//GEN-LAST:event_lstVlasniciValueChanged

    private void btnDodajVlasnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajVlasnikaActionPerformed
        
        obradaVlasnik.setEntitet(new Vlasnik());
        
        if(lstVlasnici.getSelectedValue() != null){
            obradaVlasnik.setEntitet(new Vlasnik());
        }
        
        postaviVrijednostiNaEntitetVlasnik();
        
        try {
            obradaVlasnik.create();
            pocistiUnoseVlasnika();
            ucitajVlasnike();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajVlasnikaActionPerformed

    private void btnPromjeniVlasnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniVlasnikaActionPerformed
        if(obradaVlasnik.getEntitet() == null || obradaVlasnik.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odabrite vlasnika");
            return;
        }
        
        postaviVrijednostiNaEntitetVlasnik();
        
        try {
            obradaVlasnik.update();
            pocistiUnoseVlasnika();
            ucitajVlasnike();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
            pocistiUnoseVlasnika();
            HibernateUtil.getSession().clear();
            ucitajVlasnike();
        }
    }//GEN-LAST:event_btnPromjeniVlasnikaActionPerformed

    private void btnObrisiVlasnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiVlasnikaActionPerformed
        if(obradaVlasnik.getEntitet() == null || obradaVlasnik.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite vlasnika");
            return;
        }
        
       postaviVrijednostiNaEntitetVlasnik();
       
        try {
            obradaVlasnik.delete();
            pocistiUnoseVlasnika();
            ucitajVlasnike();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiVlasnikaActionPerformed

    private void lstAutiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAutiValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        if(lstAuti.getSelectedValue() == null){
            return;
        }
        
        obradaAuto.setEntitet(lstAuti.getSelectedValue());
        
        var a = obradaAuto.getEntitet();
        
        txtModel.setText(a.getModel());
        cmbVlasnici.setSelectedItem(a.getVlasnik());
        /*DefaultComboBoxModel<Vlasnik> mv =
                (DefaultComboBoxModel<Vlasnik>) cmbVlasnici.getModel();
        for(int i=0; i<mv.getSize(); i++){
            if(mv.getElementAt(i).getId().equals(a.getId())){
                cmbVlasnici.setSelectedIndex(i);
                break;
            }
        }*/
        
        txtGodiste.setText(String.valueOf(a.getGodiste()));
        txtRegistracija.setText(a.getRegistracija());
        txtVolumen.setText(String.valueOf(a.getVolumenRezervoara()));
        
        
    }//GEN-LAST:event_lstAutiValueChanged

    private void btnDodajAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajAutoActionPerformed
        obradaAuto.setEntitet(new Auto());
        
        if(lstAuti.getSelectedValue() != null){
            obradaAuto.setEntitet(new Auto());
        }
        
        postaviVrijednostiNaEntitetAuto();
        
        try {
            obradaAuto.create();
            pocistiUnoseAuta();
            ucitajAute();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajAutoActionPerformed

    private void btnPromjeniAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniAutoActionPerformed
        if(obradaAuto.getEntitet() == null || obradaAuto.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite auto");
            return;
        }
        
        postaviVrijednostiNaEntitetAuto();
        
        try {
            obradaAuto.update();
            pocistiUnoseAuta();
            ucitajAute();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
            pocistiUnoseAuta();
            HibernateUtil.getSession().clear();
            ucitajAute();
        }
    }//GEN-LAST:event_btnPromjeniAutoActionPerformed

    private void jpAutiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpAutiAncestorAdded
        ucitajVlasnikecmb();
    }//GEN-LAST:event_jpAutiAncestorAdded

    private void btnObrisiAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiAutoActionPerformed
         if(obradaAuto.getEntitet() == null || obradaAuto.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite auto");
            return;
        }
        
       postaviVrijednostiNaEntitetAuto();
       
        try {
            obradaAuto.delete();
            pocistiUnoseAuta();
            ucitajAute();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiAutoActionPerformed

    private void lstEvidencijaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEvidencijaValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        if(lstEvidencija.getSelectedValue() == null){
            return;
        }
        
        obradaEvidencija.setEntitet(lstEvidencija.getSelectedValue());
        
        var e = obradaEvidencija.getEntitet();
        
        dpDatum.setDate(e.getDatum());
        cmbAuti.setSelectedItem(e.getAuto());
        /*DefaultComboBoxModel<Auto> av =
                (DefaultComboBoxModel<Auto>) cmbAuti.getModel();
        for(int i=0; i<av.getSize(); i++){
            if(av.getElementAt(i).getId().equals(e.getId())){
                cmbAuti.setSelectedIndex(i);
                break;
            }
        }*/
        txtCijenaGoriva.setText(e.getCijenaGorivaPoLitri().setScale(2, RoundingMode.HALF_UP).toString());       
        txtNatocenoLitara.setText(e.getNatocenoLitara().setScale(2,RoundingMode.HALF_UP).toString());
        txtPocetnoStanje.setText(String.valueOf(e.getPocetnoStanje()));
        txtZavrsnoStanje.setText(String.valueOf(e.getZavrsnoStanje()));
        
        DefaultListModel<Oznaka> m = new DefaultListModel<>();
        m.addAll(e.getOznaka());
        lstOznakaEvidencije.setModel(m);
    }//GEN-LAST:event_lstEvidencijaValueChanged

    private void jpEvidencijaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpEvidencijaAncestorAdded
        ucitajAutecmb();
    }//GEN-LAST:event_jpEvidencijaAncestorAdded

    private void btnDodajEvidencijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajEvidencijuActionPerformed
        obradaEvidencija.setEntitet(new Evidencija());
        
        if(lstEvidencija.getSelectedValue() != null){
            obradaEvidencija.setEntitet(new Evidencija());
        }
        
        postaviVrijednostiNaEntitetEvidencija();
        
        try {
            obradaEvidencija.create();
            pocistiUnoseEvidencije();
            ucitajEvidenciju();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajEvidencijuActionPerformed

    private void btnPromjeniEvidencijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniEvidencijuActionPerformed
        if(obradaEvidencija.getEntitet() == null || obradaEvidencija.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite evidenciju");
            return;
        }
        
        postaviVrijednostiNaEntitetEvidencija();
        
        try {
            obradaEvidencija.update();
            pocistiUnoseEvidencije();
            ucitajEvidenciju();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
            pocistiUnoseEvidencije();
            HibernateUtil.getSession().clear();
            ucitajEvidenciju();
        }
    }//GEN-LAST:event_btnPromjeniEvidencijuActionPerformed

    private void btnObrisiEvidencijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiEvidencijuActionPerformed
         if(obradaEvidencija.getEntitet() == null || obradaEvidencija.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite evidenciju");
            return;
        }
        
       postaviVrijednostiNaEntitetEvidencija();
       
        try {
            obradaEvidencija.delete();
            pocistiUnoseEvidencije();
            ucitajEvidenciju();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiEvidencijuActionPerformed

    private void btnDodajOznakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajOznakuActionPerformed
       obradaOznaka.setEntitet(new Oznaka());
        
        if(lstOznake.getSelectedValue() != null){
            obradaOznaka.setEntitet(new Oznaka());
        }
        
        postaviVrijednostiNaEntitetOznaka();
        
        try {
            obradaOznaka.create();
            pocistiUnoseOznake();
            ucitajOznake();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajOznakuActionPerformed

    private void lstOznakeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOznakeValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        if(lstOznake.getSelectedValue() == null){
            return;
        }
        
        obradaOznaka.setEntitet(lstOznake.getSelectedValue());
        
        var o = obradaOznaka.getEntitet();

        txtNazivOznake.setText(o.getNaziv());       
        
    }//GEN-LAST:event_lstOznakeValueChanged

    private void btnPromjeniOznakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniOznakuActionPerformed
        if(obradaOznaka.getEntitet() == null || obradaOznaka.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite oznaku");
            return;
        }
        
        postaviVrijednostiNaEntitetOznaka();
        
        try {
            obradaOznaka.update();
            pocistiUnoseOznake();
            ucitajOznake();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
            pocistiUnoseOznake();
            HibernateUtil.getSession().clear();
            ucitajOznake();
        }
    }//GEN-LAST:event_btnPromjeniOznakuActionPerformed

    private void btnObrisiOznakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiOznakuActionPerformed
        if(obradaOznaka.getEntitet() == null || obradaOznaka.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite oznaku");
            return;
        }
        
       postaviVrijednostiNaEntitetOznaka();
       
        try {
            obradaOznaka.delete();
            pocistiUnoseOznake();
            ucitajOznake();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiOznakuActionPerformed

    private void btnDodajUEvidencijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajUEvidencijuActionPerformed
        DefaultListModel<Oznaka> m;
        try {
           m = (DefaultListModel<Oznaka>) lstOznakaEvidencije.getModel();
           m.get(0).toString();
        } catch (Exception e) {
            m = new DefaultListModel<>();
            lstOznakaEvidencije.setModel(m);
        }
        
        boolean postoji;
        
        for(Oznaka o : lstOznakeUApp.getSelectedValuesList()){
            postoji = false;
            for(int i = 0; i < m.size(); i++){
                if(o.getId().equals(m.get(i).getId())){
                    postoji = true;
                    break;
                }
            }
            if(!postoji){
                m.addElement(o);
            }
            
        }
        
        lstOznakaEvidencije.repaint();
    }//GEN-LAST:event_btnDodajUEvidencijuActionPerformed

    private void btnObrisiIzEvidencijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiIzEvidencijeActionPerformed
        DefaultListModel<Oznaka> m;
        try {
           m = (DefaultListModel<Oznaka>) lstOznakaEvidencije.getModel();
           m.get(0).toString();
        } catch (Exception e) {
            return;
        }
        
        for(Oznaka o : lstOznakaEvidencije.getSelectedValuesList()){
            
            for(int i = 0; i < m.size(); i++){
                if(o.getId().equals(m.get(i).getId())){
                    m.removeElementAt(i);
                    break;
                }
            } 
        }
    }//GEN-LAST:event_btnObrisiIzEvidencijeActionPerformed

    private void jpOznakeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpOznakeAncestorAdded
        HibernateUtil.getSession().clear();
        ucitajEvidenciju();
        ucitajOznake();
    }//GEN-LAST:event_jpOznakeAncestorAdded

    private void btnRadSEvidencijomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadSEvidencijomActionPerformed
        new RadSEvidencijomForma().setVisible(true);
    }//GEN-LAST:event_btnRadSEvidencijomActionPerformed

    private void btnPocistiUnoseEvidencijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPocistiUnoseEvidencijeActionPerformed
        pocistiUnoseEvidencije();
    }//GEN-LAST:event_btnPocistiUnoseEvidencijeActionPerformed

    private void btnPocistiUnoseAutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPocistiUnoseAutaActionPerformed
        pocistiUnoseAuta();
    }//GEN-LAST:event_btnPocistiUnoseAutaActionPerformed

    private void btnPocistiUnoseVlasnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPocistiUnoseVlasnikaActionPerformed
        pocistiUnoseVlasnika();
    }//GEN-LAST:event_btnPocistiUnoseVlasnikaActionPerformed

    private void btnPocistiUnoseOznakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPocistiUnoseOznakeActionPerformed
        pocistiUnoseOznake();
    }//GEN-LAST:event_btnPocistiUnoseOznakeActionPerformed

    private void btnRadSOznakamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadSOznakamaActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnRadSOznakamaActionPerformed

    private void jmRadSEvidencijomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmRadSEvidencijomMouseClicked
        new RadSEvidencijomForma().setVisible(true);
    }//GEN-LAST:event_jmRadSEvidencijomMouseClicked

    private void jmEraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmEraMouseClicked
        new EraForma().setVisible(true);
    }//GEN-LAST:event_jmEraMouseClicked

    private void postaviVrijednostiNaEntitetVlasnik() {
        
        var entitet = obradaVlasnik.getEntitet();
        
        entitet.setIme(txtIme.getText());
        entitet.setPrezime(txtPrezime.getText());
        entitet.setOib(txtOib.getText());
        entitet.setDatumRodenja(dpDatumRodenja.getDate());
        entitet.setBrojMobitela(txtBrojMob.getText());
        entitet.setEmail(txtEmail.getText());
        entitet.setSpol(txtSpol.getText());
    }
    
     private void pocistiUnoseVlasnika() {
        
         txtIme.setText("");
         txtPrezime.setText("");
         txtOib.setText("");
         dpDatumRodenja.setText("");
         txtBrojMob.setText("");
         txtEmail.setText("");
         txtSpol.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajAuto;
    private javax.swing.JButton btnDodajEvidenciju;
    private javax.swing.JButton btnDodajOznaku;
    private javax.swing.JButton btnDodajUEvidenciju;
    private javax.swing.JButton btnDodajVlasnika;
    private javax.swing.JButton btnObrisiAuto;
    private javax.swing.JButton btnObrisiEvidenciju;
    private javax.swing.JButton btnObrisiIzEvidencije;
    private javax.swing.JButton btnObrisiOznaku;
    private javax.swing.JButton btnObrisiVlasnika;
    private javax.swing.JButton btnPocistiUnoseAuta;
    private javax.swing.JButton btnPocistiUnoseEvidencije;
    private javax.swing.JButton btnPocistiUnoseOznake;
    private javax.swing.JButton btnPocistiUnoseVlasnika;
    private javax.swing.JButton btnPromjeniAuto;
    private javax.swing.JButton btnPromjeniEvidenciju;
    private javax.swing.JButton btnPromjeniOznaku;
    private javax.swing.JButton btnPromjeniVlasnika;
    private javax.swing.JButton btnRadSEvidencijom;
    private javax.swing.JButton btnRadSOznakama;
    private javax.swing.JComboBox<Auto> cmbAuti;
    private javax.swing.JComboBox<Vlasnik> cmbVlasnici;
    private com.github.lgooddatepicker.components.DatePicker dpDatum;
    private com.github.lgooddatepicker.components.DatePicker dpDatumRodenja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmDatoteka;
    private javax.swing.JMenu jmEra;
    private javax.swing.JMenu jmOnama;
    private javax.swing.JMenu jmRadSEvidencijom;
    private javax.swing.JMenuItem jmiAuti;
    private javax.swing.JMenuItem jmiEvidencija;
    private javax.swing.JMenuItem jmiIzlaz;
    private javax.swing.JMenuItem jmiOznake;
    private javax.swing.JMenuItem jmiVlasnici;
    private javax.swing.JPanel jpAuti;
    private javax.swing.JPanel jpEvidencija;
    private javax.swing.JPanel jpOznake;
    private javax.swing.JPanel jpVlasnici;
    private javax.swing.JLabel lblVrijeme;
    private javax.swing.JList<Auto> lstAuti;
    private javax.swing.JList<Evidencija> lstEvidencija;
    private javax.swing.JList<Oznaka> lstOznakaEvidencije;
    private javax.swing.JList<Oznaka> lstOznake;
    private javax.swing.JList<Oznaka> lstOznakeUApp;
    private javax.swing.JList<Vlasnik> lstVlasnici;
    private javax.swing.JTextField txtBrojMob;
    private javax.swing.JTextField txtCijenaGoriva;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGodiste;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNatocenoLitara;
    private javax.swing.JTextField txtNazivOznake;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPocetnoStanje;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtRegistracija;
    private javax.swing.JTextField txtSpol;
    private javax.swing.JTextField txtVolumen;
    private javax.swing.JTextField txtZavrsnoStanje;
    // End of variables declaration//GEN-END:variables
}
