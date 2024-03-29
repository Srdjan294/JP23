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
import edunova.zavrsnirad.controller.ObradaGorivo;
import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Evidencija;
import edunova.zavrsnirad.model.Gorivo;
import edunova.zavrsnirad.model.Oznaka;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import edunova.zavrsnirad.util.HibernateUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
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
    private ObradaGorivo obradaGorivo;

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        obradaVlasnik = new ObradaVlasnik();
        obradaAuto = new ObradaAuto();
        obradaEvidencija = new ObradaEvidencija();
        obradaGorivo = new ObradaGorivo();
        setTitle(Aplikacija.NASLOV_APP + " " + 
                Aplikacija.operater.getImePrezime());
        new Vrijeme().start();
        prilagodiDpDatumRodenja();
        prilagodiDpDatum();
        ucitajVlasnike();
        ucitajAute();
        ucitajGorivo();
        ucitajEvidenciju();
        ucitajVlasnikecmb();
        ucitajAutecmb();
        ucitajGorivocmb();
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
        entitet.setGodiste(Integer.parseInt(txtGodiste.getText()));
        entitet.setRegistracija(txtRegistracija.getText());
        entitet.setVolumenRezervoara(Integer.parseInt(txtVolumen.getText()));
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

    private void ucitajGorivo() {
        DefaultListModel<Gorivo> m = new DefaultListModel<>();
        m.addAll(obradaGorivo.getPodaci());
        lstGorivo.setModel(m);
    }

    private void ucitajGorivocmb() {
        DefaultComboBoxModel<Gorivo> m = new DefaultComboBoxModel<>();
        
        Gorivo g = new Gorivo();
        g.setId(-1L);
        g.setNaziv("Odaberite gorivo: ");
        m.addElement(g);
        
        m.addAll(new ObradaGorivo().getPodaci());
        cmbGorivo.setModel(m);
        
        cmbGorivo.setSelectedIndex(0); 
    }

    private void postaviVrijednostiNaEntitetGorivo() {
        var entitet = obradaGorivo.getEntitet();
        
        entitet.setNaziv(txtNazivGoriva.getText());
        entitet.setCijena(new BigDecimal(txtCijena.getText()).setScale(2,RoundingMode.DOWN));
        
    }

    private void pocistiUnoseGoriva() {
        txtNazivGoriva.setText("");
        txtCijena.setText("");
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
        cmbGorivo = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtCijenaGoriva = new javax.swing.JTextField();
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
        jpOznake = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOznake = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        txtNazivOznake = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstGorivo = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        txtNazivGoriva = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        btnDodajGorivo = new javax.swing.JButton();
        btnPromjeniGorivo = new javax.swing.JButton();
        btnObrisiGorivo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmDatoteka = new javax.swing.JMenu();
        jmiEvidencija = new javax.swing.JMenuItem();
        jmiAuti = new javax.swing.JMenuItem();
        jmiVlasnici = new javax.swing.JMenuItem();
        jmiOznake = new javax.swing.JMenuItem();
        jmiGorivo = new javax.swing.JMenuItem();
        jmiIzlaz = new javax.swing.JMenuItem();
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

        jLabel5.setText("Gorivo:");

        jLabel22.setText("Cijena goriva:");

        javax.swing.GroupLayout jpEvidencijaLayout = new javax.swing.GroupLayout(jpEvidencija);
        jpEvidencija.setLayout(jpEvidencijaLayout);
        jpEvidencijaLayout.setHorizontalGroup(
            jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPocetnoStanje)
                        .addComponent(txtZavrsnoStanje, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(dpDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbAuti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbGorivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCijenaGoriva)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNatocenoLitara, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jpEvidencijaLayout.setVerticalGroup(
            jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEvidencijaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGorivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCijenaGoriva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNatocenoLitara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPocetnoStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtZavrsnoStanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jpAutiLayout = new javax.swing.GroupLayout(jpAuti);
        jpAuti.setLayout(jpAutiLayout);
        jpAutiLayout.setHorizontalGroup(
            jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAutiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAutiLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(cmbVlasnici, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodajAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromjeniAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jpAutiLayout.setVerticalGroup(
            jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAutiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpAutiLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                .addComponent(btnObrisiAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jpVlasniciLayout = new javax.swing.GroupLayout(jpVlasnici);
        jpVlasnici.setLayout(jpVlasniciLayout);
        jpVlasniciLayout.setHorizontalGroup(
            jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVlasniciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSpol, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPromjeniVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDodajVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrojMob, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiVlasnika, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpVlasniciLayout.setVerticalGroup(
            jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVlasniciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(4, 4, 4)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addComponent(txtSpol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Vlasnici", new javax.swing.ImageIcon(getClass().getResource("/icons8-user-account-24.png")), jpVlasnici); // NOI18N

        lstOznake.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(lstOznake);

        jLabel19.setText("Naziv oznake:");

        javax.swing.GroupLayout jpOznakeLayout = new javax.swing.GroupLayout(jpOznake);
        jpOznake.setLayout(jpOznakeLayout);
        jpOznakeLayout.setHorizontalGroup(
            jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOznakeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNazivOznake, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jpOznakeLayout.setVerticalGroup(
            jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOznakeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpOznakeLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNazivOznake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Oznake", new javax.swing.ImageIcon(getClass().getResource("/icons8-labels-24.png")), jpOznake); // NOI18N

        lstGorivo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstGorivo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGorivoValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lstGorivo);

        jLabel20.setText("Naziv goriva:");

        jLabel21.setText("Cijena goriva (kn): ");

        btnDodajGorivo.setText("Dodaj gorivo");
        btnDodajGorivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajGorivoActionPerformed(evt);
            }
        });

        btnPromjeniGorivo.setText("Promjeni gorivo");
        btnPromjeniGorivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniGorivoActionPerformed(evt);
            }
        });

        btnObrisiGorivo.setText("Obriši gorivo");
        btnObrisiGorivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiGorivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNazivGoriva)
                    .addComponent(txtCijena, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPromjeniGorivo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiGorivo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajGorivo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNazivGoriva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))
                            .addComponent(btnDodajGorivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnPromjeniGorivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiGorivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gorivo", new javax.swing.ImageIcon(getClass().getResource("/icons8-gas-station-24.png")), jPanel1); // NOI18N

        jmDatoteka.setText("Datoteka");

        jmiEvidencija.setText("Evidencija");
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

        jmiGorivo.setText("Gorivo");
        jmiGorivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGorivoActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiGorivo);

        jmiIzlaz.setText("Izlaz");
        jmiIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIzlazActionPerformed(evt);
            }
        });
        jmDatoteka.add(jmiIzlaz);

        jMenuBar1.add(jmDatoteka);

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

    private void jmiGorivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGorivoActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jmiGorivoActionPerformed

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

    private void lstGorivoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGorivoValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        if(lstGorivo.getSelectedValue() == null){
            return;
        }
        
        obradaGorivo.setEntitet(lstGorivo.getSelectedValue());
        
        var g = obradaGorivo.getEntitet();
        
        txtNazivGoriva.setText(g.getNaziv());
        txtCijena.setText(g.getCijena().setScale(2, RoundingMode.HALF_UP).toString());
        
        
    }//GEN-LAST:event_lstGorivoValueChanged

    private void btnDodajGorivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajGorivoActionPerformed
        obradaGorivo.setEntitet(new Gorivo());
        
        if(lstGorivo.getSelectedValue() != null){
            obradaGorivo.setEntitet(new Gorivo());
        }
        
        postaviVrijednostiNaEntitetGorivo();
        
        try {
            obradaGorivo.create();
            pocistiUnoseGoriva();
            ucitajGorivo();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajGorivoActionPerformed

    private void btnPromjeniGorivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniGorivoActionPerformed
        if(obradaGorivo.getEntitet() == null || obradaGorivo.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite gorivo");
            return;
        }
        
        postaviVrijednostiNaEntitetGorivo();
        
        try {
            obradaGorivo.update();
            pocistiUnoseGoriva();
            ucitajGorivo();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniGorivoActionPerformed

    private void btnObrisiGorivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiGorivoActionPerformed
         if(obradaGorivo.getEntitet() == null || obradaGorivo.getEntitet().getId() == null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite gorivo");
            return;
        }
        
       postaviVrijednostiNaEntitetGorivo();
       
        try {
            obradaGorivo.delete();
            pocistiUnoseGoriva();
            ucitajGorivo();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(rootPane, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiGorivoActionPerformed

    private void lstEvidencijaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEvidencijaValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        
        if(lstEvidencija.getSelectedValue() == null){
            return;
        }
        
        obradaEvidencija.setEntitet(lstEvidencija.getSelectedValue());
        
        var e = obradaEvidencija.getEntitet();
        var g = obradaGorivo.getEntitet();
        
        dpDatum.setDate(e.getDatum());
        cmbAuti.setSelectedItem(e.getAuto());
        cmbGorivo.setSelectedItem(e.getGorivo());
        
        //txtCijenaGoriva.setText((String)cmbGorivo.getSelectedItem());
        
        txtNatocenoLitara.setText(String.valueOf(e.getNatocenoLitara()));
        txtPocetnoStanje.setText(String.valueOf(e.getPocetnoStanje()));
        txtZavrsnoStanje.setText(String.valueOf(e.getZavrsnoStanje()));
    }//GEN-LAST:event_lstEvidencijaValueChanged

    private void jpEvidencijaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jpEvidencijaAncestorAdded
        ucitajAutecmb();
        ucitajGorivocmb();
    }//GEN-LAST:event_jpEvidencijaAncestorAdded

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
    private javax.swing.JButton btnDodajGorivo;
    private javax.swing.JButton btnDodajVlasnika;
    private javax.swing.JButton btnObrisiAuto;
    private javax.swing.JButton btnObrisiGorivo;
    private javax.swing.JButton btnObrisiVlasnika;
    private javax.swing.JButton btnPromjeniAuto;
    private javax.swing.JButton btnPromjeniGorivo;
    private javax.swing.JButton btnPromjeniVlasnika;
    private javax.swing.JComboBox<Auto> cmbAuti;
    private javax.swing.JComboBox<Gorivo> cmbGorivo;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmDatoteka;
    private javax.swing.JMenu jmOnama;
    private javax.swing.JMenuItem jmiAuti;
    private javax.swing.JMenuItem jmiEvidencija;
    private javax.swing.JMenuItem jmiGorivo;
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
    private javax.swing.JList<Gorivo> lstGorivo;
    private javax.swing.JList<Oznaka> lstOznake;
    private javax.swing.JList<Vlasnik> lstVlasnici;
    private javax.swing.JTextField txtBrojMob;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtCijenaGoriva;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGodiste;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNatocenoLitara;
    private javax.swing.JTextField txtNazivGoriva;
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
