/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.zavrsnirad.view;

import com.github.lgooddatepicker.components.DatePicker;
import edunova.zavrsnirad.controller.ObradaVlasnik;
import edunova.zavrsnirad.model.Auto;
import edunova.zavrsnirad.model.Evidencija;
import edunova.zavrsnirad.model.Oznaka;
import edunova.zavrsnirad.model.Vlasnik;
import edunova.zavrsnirad.util.EdunovaException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    DatePicker datePicker = new DatePicker();

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        initComponents();
        setTitle(Aplikacija.NASLOV_APP + " " + 
                Aplikacija.operater.getImePrezime());
        new Vrijeme().start();
        
        obradaVlasnik = new ObradaVlasnik();
        ucitajVlasnike();
    }

    private void ucitajVlasnike() {
        
        DefaultListModel<Vlasnik> m = new DefaultListModel<>();
        m.addAll(obradaVlasnik.getPodaci());
        lstVlasnici.setModel(m);
        
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
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        jpAuti = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAuti = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
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
        jpOznake = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOznake = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmDatoteka = new javax.swing.JMenu();
        jmiEvidencija = new javax.swing.JMenuItem();
        jmiAuti = new javax.swing.JMenuItem();
        jmiVlasnici = new javax.swing.JMenuItem();
        jmiOznake = new javax.swing.JMenuItem();
        jmiIzlaz = new javax.swing.JMenuItem();
        jmOnama = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        lblVrijeme.setText("vrijeme");
        jToolBar1.add(lblVrijeme);

        jScrollPane1.setViewportView(lstEvidencija);

        jLabel1.setText("Datum:");

        jLabel3.setText("Auto:");

        jLabel4.setText("Natočeno litara:");

        jLabel5.setText("Ukupna cijena goriva:");

        jLabel6.setText("Početno stanje brojila:");

        jLabel7.setText("Završno stanje brojila:");

        javax.swing.GroupLayout jpEvidencijaLayout = new javax.swing.GroupLayout(jpEvidencija);
        jpEvidencija.setLayout(jpEvidencijaLayout);
        jpEvidencijaLayout.setHorizontalGroup(
            jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Evidencija", jpEvidencija);

        jScrollPane2.setViewportView(lstAuti);

        jLabel2.setText("Model:");

        jLabel8.setText("Vlasnik:");

        jLabel9.setText("Godište:");

        jLabel10.setText("Registracija:");

        jLabel11.setText("Volumen rezervoara:");

        javax.swing.GroupLayout jpAutiLayout = new javax.swing.GroupLayout(jpAuti);
        jpAuti.setLayout(jpAutiLayout);
        jpAutiLayout.setHorizontalGroup(
            jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAutiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpAutiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addContainerGap(192, Short.MAX_VALUE))
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
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Auti", jpAuti);

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

        javax.swing.GroupLayout jpVlasniciLayout = new javax.swing.GroupLayout(jpVlasnici);
        jpVlasnici.setLayout(jpVlasniciLayout);
        jpVlasniciLayout.setHorizontalGroup(
            jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVlasniciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrezime)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOib)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrojMob)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSpol, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(txtIme)
                    .addComponent(dpDatumRodenja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnDodajVlasnika)
                .addGap(45, 45, 45))
        );
        jpVlasniciLayout.setVerticalGroup(
            jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVlasniciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpVlasniciLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpVlasniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpVlasniciLayout.createSequentialGroup()
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel13))
                            .addComponent(btnDodajVlasnika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
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
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vlasnici", jpVlasnici);

        jScrollPane4.setViewportView(lstOznake);

        jLabel19.setText("Naziv:");

        javax.swing.GroupLayout jpOznakeLayout = new javax.swing.GroupLayout(jpOznake);
        jpOznake.setLayout(jpOznakeLayout);
        jpOznakeLayout.setHorizontalGroup(
            jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOznakeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jpOznakeLayout.setVerticalGroup(
            jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOznakeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOznakeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOznakeLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Oznake", jpOznake);

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
        
        obradaVlasnik.setEntitet(lstVlasnici.getSelectedValue());
        
        if(obradaVlasnik.getEntitet() == null){
            return;
        }
        
        txtIme.setText(obradaVlasnik.getEntitet().getIme());
        txtPrezime.setText(obradaVlasnik.getEntitet().getPrezime());
        txtOib.setText(obradaVlasnik.getEntitet().getOib());
        dpDatumRodenja.setDate(obradaVlasnik.getEntitet().getDatumRodenja());
        txtBrojMob.setText(obradaVlasnik.getEntitet().getBrojMobitela());
        txtEmail.setText(obradaVlasnik.getEntitet().getEmail());
        txtSpol.setText(obradaVlasnik.getEntitet().getSpol());
        
    }//GEN-LAST:event_lstVlasniciValueChanged

    private void btnDodajVlasnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajVlasnikaActionPerformed
        
        if(obradaVlasnik.getEntitet() == null){
            obradaVlasnik.setEntitet(new Vlasnik());
        }
        
        if(lstVlasnici.getSelectedValue() != null){
            obradaVlasnik.setEntitet(new Vlasnik());
        }
        
        postaviVrijednostiNaEntitetVlasnik();
        
        try {
            obradaVlasnik.create();
            obradaVlasnik.setEntitet(new Vlasnik());
            pocisti();
            ucitajVlasnike();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajVlasnikaActionPerformed

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
    
     private void pocisti() {
        
         txtIme.setText("");
         txtPrezime.setText("");
         txtOib.setText("");
         dpDatumRodenja.setText("");
         txtBrojMob.setText("");
         txtEmail.setText("");
         txtSpol.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajVlasnika;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu jmDatoteka;
    private javax.swing.JMenu jmOnama;
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
    private javax.swing.JList<Oznaka> lstOznake;
    private javax.swing.JList<Vlasnik> lstVlasnici;
    private javax.swing.JTextField txtBrojMob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtSpol;
    // End of variables declaration//GEN-END:variables
}
