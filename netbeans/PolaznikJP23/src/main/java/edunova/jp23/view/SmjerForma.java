/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.jp23.view;

import edunova.jp23.controller.ObradaSmjer;
import edunova.jp23.model.Smjer;
import edunova.jp23.util.EdunovaException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author srdja
 */
public class SmjerForma extends javax.swing.JFrame {

    private ObradaSmjer obrada;
    private Smjer entitet;
    
    /**
     * Creates new form FormaSmjerovi
     */
    public SmjerForma() {
        initComponents();
        entitet = new Smjer();
        obrada = new ObradaSmjer(entitet);
        setTitle(Aplikacija.NASLOV_APP + " Smjerovi");
        ucitaj();
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstSmjerovi = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtTrajanje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        chbVerificiran = new javax.swing.JCheckBox();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstSmjerovi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSmjerovi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSmjeroviValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstSmjerovi);

        jLabel1.setText("Naziv");

        jLabel2.setText("Trajanje");

        jLabel3.setText("Cijena");

        chbVerificiran.setText("Verificiran");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(chbVerificiran, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(txtTrajanje)
                        .addComponent(txtCijena))
                    .addComponent(btnDodaj))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chbVerificiran)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstSmjeroviValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSmjeroviValueChanged
        if(evt.getValueIsAdjusting()){
            return;
        }
        entitet = lstSmjerovi.getSelectedValue();
        
        if(entitet == null){
            return;
        }
        //ovo se može zamijeniti tzv. Binding
        txtNaziv.setText(entitet.getNaziv());
        
        if(entitet.getTrajanje() != null){
        txtTrajanje.setText(entitet.getTrajanje().toString());
        }else{
            txtTrajanje.setText("");
        }
        
        try{
        txtCijena.setText(entitet.getCijena().toString());
        }catch(Exception e){
            txtCijena.setText("");
        }
        
        try{
        chbVerificiran.setSelected(entitet.getVerificiran());
        }catch(Exception e){
            chbVerificiran.setSelected(false);
        }
    }//GEN-LAST:event_lstSmjeroviValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        entitet.setNaziv(txtNaziv.getText());
        
        try {
            entitet.setTrajanje(Integer.parseInt(txtTrajanje.getText()));
        } catch (Exception e) {
            entitet.setTrajanje(null);
        }
        
        try {
            entitet.setCijena(new BigDecimal(txtCijena.getText()));
        } catch (Exception e) {
            entitet.setCijena(BigDecimal.ZERO);
        }
        
        entitet.setVerificiran(chbVerificiran.isSelected());
        
        try {
            obrada.create();
            entitet = new Smjer();
           
            txtNaziv.setText("");txtCijena.setText("");txtTrajanje.setText("");chbVerificiran.setSelected(false);
            
            ucitaj(); // nije optimizirano. Bolje bi bilo samo taj novi dodati u listu
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JCheckBox chbVerificiran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Smjer> lstSmjerovi;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTrajanje;
    // End of variables declaration//GEN-END:variables

    private void ucitaj() {
        
        DefaultListModel<Smjer> m = new DefaultListModel<>();
        
        m.addAll(obrada.getPodaci());
        
        lstSmjerovi.setModel(m);
    }
}
