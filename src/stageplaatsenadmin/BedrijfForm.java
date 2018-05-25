/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stageplaatsenadmin;

import DAL.Bedrijf;
import DAL.DBFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author patrik
 */
public class BedrijfForm extends javax.swing.JFrame {

    private final DBFacade dbFacade;
    private List<Bedrijf> bedrijven;
    private Bedrijf geselecteerdBedrijf;
    private OverzichtForm parent;
    /**
     * Creates new form BedrijfForm
     */
    public BedrijfForm(OverzichtForm parent) {
        this(parent, new DBFacade());
    }

    public BedrijfForm(OverzichtForm parent, DBFacade dbf) 
    {
        initComponents();
        this.parent = parent;
        dbFacade = dbf;
        this.refreshDataCache();
        this.refreshListbox();
        enableButtons();
    }
    
    
    private void refreshDataCache(){
        this.bedrijven = dbFacade.getAllBedrijven();
    }
    
    private void refreshListbox(){
        int index = this.jListBedrijven.getSelectedIndex();
        
        this.jListBedrijven.setListData(this.bedrijven.toArray());
        
//        if (this.geselecteerdBedrijf != null){
//            this.jListBedrijven.setSelectedValue(this.geselecteerdBedrijf, true);
//        }
//        else
//        {
//            if (index > 0) { this.jListBedrijven.setSelectedIndex(index);
//            }
//        }
            
        
        
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
        jListBedrijven = new javax.swing.JList();
        jLabelGUIBedrijf = new javax.swing.JLabel();
        jTextFieldBedrijfsnaam = new javax.swing.JTextField();
        jLabelGUIContactpersoon = new javax.swing.JLabel();
        jTextFieldContactpersoon = new javax.swing.JTextField();
        jLabelGUIEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelGUIActiviteiten = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaActiviteiten = new javax.swing.JTextArea();
        jLabelGUIAanwervend = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaAanwervend = new javax.swing.JTextArea();
        jLabelGUIAdres = new javax.swing.JLabel();
        jLabelGUIStraat = new javax.swing.JLabel();
        jTextFieldStraat = new javax.swing.JTextField();
        jLabelGUINummer = new javax.swing.JLabel();
        jTextFieldNummer = new javax.swing.JTextField();
        jLabelGUIPostcode = new javax.swing.JLabel();
        jTextFieldPostcode = new javax.swing.JTextField();
        jLabelGUIStad = new javax.swing.JLabel();
        jTextFieldStad = new javax.swing.JTextField();
        jLabelGUILand = new javax.swing.JLabel();
        jTextFieldLand = new javax.swing.JTextField();
        jButtonDeleteBedrijf = new javax.swing.JButton();
        jButtonNewBedrijf = new javax.swing.JButton();
        jButtonSaveBedrijf = new javax.swing.JButton();
        jLabelGUIID = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelGUILaatsteWijziging = new javax.swing.JLabel();
        jLabellaatsteWijzing = new javax.swing.JLabel();
        jLabelGUIAanmaakdatum = new javax.swing.JLabel();
        jLabelAanmaakdatum = new javax.swing.JLabel();

        setAlwaysOnTop(true);

        jListBedrijven.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListBedrijven.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListBedrijvenValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListBedrijven);

        jLabelGUIBedrijf.setText("Bedrijf:");

        jLabelGUIContactpersoon.setText("Contactpersoon");

        jLabelGUIEmail.setText("Email");

        jLabelGUIActiviteiten.setText("Activiteiten");

        jTextAreaActiviteiten.setColumns(20);
        jTextAreaActiviteiten.setRows(5);
        jScrollPane6.setViewportView(jTextAreaActiviteiten);

        jLabelGUIAanwervend.setText("Aanwervend:");

        jTextAreaAanwervend.setColumns(20);
        jTextAreaAanwervend.setRows(5);
        jScrollPane7.setViewportView(jTextAreaAanwervend);

        jLabelGUIAdres.setText("Adres:");

        jLabelGUIStraat.setText("Straat");

        jLabelGUINummer.setText("Nummer");

        jLabelGUIPostcode.setText("Postcode");

        jLabelGUIStad.setText("Stad");

        jLabelGUILand.setText("Land");

        jButtonDeleteBedrijf.setText("Wissen");
        jButtonDeleteBedrijf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteBedrijfActionPerformed(evt);
            }
        });

        jButtonNewBedrijf.setText("Nieuw");
        jButtonNewBedrijf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewBedrijfActionPerformed(evt);
            }
        });

        jButtonSaveBedrijf.setText("Opslaan");
        jButtonSaveBedrijf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveBedrijfActionPerformed(evt);
            }
        });

        jLabelGUIID.setText("ID");

        jLabelID.setText("0000");

        jLabelGUILaatsteWijziging.setText("Laatste wijziging:");

        jLabellaatsteWijzing.setText("01/01/2018 - 19u59");

        jLabelGUIAanmaakdatum.setText("Aangemaakt op:");

        jLabelAanmaakdatum.setText("01/01/2018 - 19u59");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldStad, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelGUIPostcode)
                                        .addGap(102, 102, 102)
                                        .addComponent(jLabelGUIStad)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelGUILand)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldLand)
                                        .addGap(12, 12, 12))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldContactpersoon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jScrollPane6)
                                    .addComponent(jScrollPane7)
                                    .addComponent(jTextFieldBedrijfsnaam)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelGUILaatsteWijziging)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabellaatsteWijzing)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabelGUIAanmaakdatum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelAanmaakdatum)))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelGUIBedrijf)
                                    .addComponent(jLabelGUIContactpersoon)
                                    .addComponent(jLabelGUIEmail)
                                    .addComponent(jLabelGUIActiviteiten)
                                    .addComponent(jLabelGUIAanwervend)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelGUIStraat)
                                        .addGap(474, 474, 474)
                                        .addComponent(jLabelGUINummer))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldStraat, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNummer, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelGUIAdres)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelGUIID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jButtonDeleteBedrijf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNewBedrijf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSaveBedrijf)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelGUIBedrijf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBedrijfsnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGUIContactpersoon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldContactpersoon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGUIEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGUIActiviteiten)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGUIAanwervend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelGUIAdres)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGUIStraat)
                    .addComponent(jLabelGUINummer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStraat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGUIStad)
                    .addComponent(jLabelGUIPostcode)
                    .addComponent(jLabelGUILand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldLand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewBedrijf)
                    .addComponent(jButtonSaveBedrijf)
                    .addComponent(jButtonDeleteBedrijf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelGUIAanmaakdatum)
                        .addComponent(jLabelAanmaakdatum)
                        .addComponent(jLabelGUILaatsteWijziging)
                        .addComponent(jLabellaatsteWijzing))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelGUIID)
                        .addComponent(jLabelID)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteBedrijfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteBedrijfActionPerformed
// TODO add your handling code here:

        Bedrijf b = (Bedrijf)this.jListBedrijven.getSelectedValue();
        if (b != null){
            int index = this.jListBedrijven.getSelectedIndex();
            this.dbFacade.remove(b);
            refreshDataCache();
            refreshListbox();
            if (index > 0) index--;
            this.jListBedrijven.setSelectedIndex(index);
        }

        enableButtons();
        parent.reloadDatasources();
    }//GEN-LAST:event_jButtonDeleteBedrijfActionPerformed

    private void jButtonNewBedrijfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewBedrijfActionPerformed

        this.geselecteerdBedrijf = new Bedrijf();
        this.geselecteerdBedrijf.setNaam("Onbekend");
        this.geselecteerdBedrijf.setContactNaam("Onbekend");
        this.geselecteerdBedrijf.setContactEmail("Onbekend");
        this.geselecteerdBedrijf.setActiviteiten("Onbekend");
        this.geselecteerdBedrijf.setAanwervend("Onbekend");
        this.geselecteerdBedrijf.setStraat("Onbekend");
        this.geselecteerdBedrijf.setNummer("Onbekend");
        this.geselecteerdBedrijf.setPostcode("Onbekend");
        this.geselecteerdBedrijf.setStad("Onbekend");
        this.geselecteerdBedrijf.setLand("Onbekend");
        this.geselecteerdBedrijf.setAanmaakDatum(new Date());
        this.geselecteerdBedrijf.setLaatsteWijziging(new Date());
   
        refreshDataCache();
        ClearDisplayedBedrijf();
        refreshDisplayedBedrijf();
        enableButtons();
        parent.reloadDatasources();
    }//GEN-LAST:event_jButtonNewBedrijfActionPerformed

    private void jButtonSaveBedrijfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveBedrijfActionPerformed
        // TODO add your handling code here:

        storeDisplayedBedrijf();
        
        this.geselecteerdBedrijf = this.dbFacade.persist((this.geselecteerdBedrijf));
        int selectedID = this.geselecteerdBedrijf.getId();
        refreshDataCache();
        refreshListbox();
        parent.reloadDatasources();
        this.jListBedrijven.setSelectedValue(this.dbFacade.getBedrijfByID(selectedID), true);
    }//GEN-LAST:event_jButtonSaveBedrijfActionPerformed

    private void jListBedrijvenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListBedrijvenValueChanged
        // TODO add your handling code here:
        
        //Bedrijf b 
        this.geselecteerdBedrijf = (Bedrijf)this.jListBedrijven.getSelectedValue();
   /*     if (b != null){ this.geselecteerdBedrijf = b; }
        else 
        { 
            //if (this.jListBedrijven)
        }*/
        ClearDisplayedBedrijf();
        refreshDisplayedBedrijf();
        enableButtons();
    }//GEN-LAST:event_jListBedrijvenValueChanged

    
    
    private void enableButtons(){
        
        if (this.geselecteerdBedrijf != null){
            this.jButtonSaveBedrijf.setEnabled(true);
            this.jButtonDeleteBedrijf.setEnabled(true);

        }
        else{
            this.jButtonSaveBedrijf.setEnabled(false);
            this.jButtonDeleteBedrijf.setEnabled(false);
        }
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteBedrijf;
    private javax.swing.JButton jButtonNewBedrijf;
    private javax.swing.JButton jButtonSaveBedrijf;
    private javax.swing.JLabel jLabelAanmaakdatum;
    private javax.swing.JLabel jLabelGUIAanmaakdatum;
    private javax.swing.JLabel jLabelGUIAanwervend;
    private javax.swing.JLabel jLabelGUIActiviteiten;
    private javax.swing.JLabel jLabelGUIAdres;
    private javax.swing.JLabel jLabelGUIBedrijf;
    private javax.swing.JLabel jLabelGUIContactpersoon;
    private javax.swing.JLabel jLabelGUIEmail;
    private javax.swing.JLabel jLabelGUIID;
    private javax.swing.JLabel jLabelGUILaatsteWijziging;
    private javax.swing.JLabel jLabelGUILand;
    private javax.swing.JLabel jLabelGUINummer;
    private javax.swing.JLabel jLabelGUIPostcode;
    private javax.swing.JLabel jLabelGUIStad;
    private javax.swing.JLabel jLabelGUIStraat;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabellaatsteWijzing;
    private javax.swing.JList jListBedrijven;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextAreaAanwervend;
    private javax.swing.JTextArea jTextAreaActiviteiten;
    private javax.swing.JTextField jTextFieldBedrijfsnaam;
    private javax.swing.JTextField jTextFieldContactpersoon;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLand;
    private javax.swing.JTextField jTextFieldNummer;
    private javax.swing.JTextField jTextFieldPostcode;
    private javax.swing.JTextField jTextFieldStad;
    private javax.swing.JTextField jTextFieldStraat;
    // End of variables declaration//GEN-END:variables

    private void ClearDisplayedBedrijf() {
            // Bedrijf
            this.jTextFieldBedrijfsnaam.setText("");
            this.jTextFieldContactpersoon.setText("");
            this.jTextFieldEmail.setText("");
            this.jTextAreaActiviteiten.setText("");
            this.jTextAreaAanwervend.setText("");
            
            this.jTextFieldStraat.setText("");
            this.jTextFieldNummer.setText("");
            this.jTextFieldPostcode.setText("");
            this.jTextFieldStad.setText("");
            this.jTextFieldLand.setText("");
            
            this.jLabelAanmaakdatum.setText("");
            this.jLabellaatsteWijzing.setText("");
    }

    private void refreshDisplayedBedrijf() {
        if (this.geselecteerdBedrijf != null){
            if (this.geselecteerdBedrijf.getId() != null){
                this.jLabelID.setText(this.geselecteerdBedrijf.getId().toString());
            }
            
            
            // Bedrijf
            this.jTextFieldBedrijfsnaam.setText(this.geselecteerdBedrijf.getNaam());
            this.jTextFieldContactpersoon.setText(this.geselecteerdBedrijf.getContactNaam());
            this.jTextFieldEmail.setText(this.geselecteerdBedrijf.getContactEmail());
            this.jTextAreaActiviteiten.setText(this.geselecteerdBedrijf.getActiviteiten());
            this.jTextAreaAanwervend.setText(this.geselecteerdBedrijf.getAanwervend());
            
            this.jTextFieldStraat.setText(this.geselecteerdBedrijf.getStraat());
            this.jTextFieldNummer.setText(this.geselecteerdBedrijf.getNummer());
            this.jTextFieldPostcode.setText(this.geselecteerdBedrijf.getPostcode());
            this.jTextFieldStad.setText(this.geselecteerdBedrijf.getStad());
            this.jTextFieldLand.setText(this.geselecteerdBedrijf.getLand());
            
            
            
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy '-' HH:mm:ss");
            this.jLabelAanmaakdatum.setText(dateformat.format(this.geselecteerdBedrijf.getAanmaakDatum()));
            this.jLabellaatsteWijzing.setText(dateformat.format(this.geselecteerdBedrijf.getLaatsteWijziging()));
            
            
            
        }
    }
    
    
    private void storeDisplayedBedrijf(){
        if (this.geselecteerdBedrijf == null){
            this.geselecteerdBedrijf = new Bedrijf();
        }
        
            
        this.geselecteerdBedrijf.setNaam(this.jTextFieldBedrijfsnaam.getText());
        this.geselecteerdBedrijf.setContactNaam(this.jTextFieldContactpersoon.getText());
        this.geselecteerdBedrijf.setContactEmail(this.jTextFieldEmail.getText());
        this.geselecteerdBedrijf.setActiviteiten(this.jTextAreaActiviteiten.getText());
        this.geselecteerdBedrijf.setAanwervend(this.jTextAreaAanwervend.getText());
        this.geselecteerdBedrijf.setStraat(this.jTextFieldStraat.getText());
        this.geselecteerdBedrijf.setNummer(this.jTextFieldNummer.getText());
        this.geselecteerdBedrijf.setPostcode(this.jTextFieldPostcode.getText());
        this.geselecteerdBedrijf.setStad(this.jTextFieldStad.getText());
        this.geselecteerdBedrijf.setLand(this.jTextFieldLand.getText());
            
    }
    
    
}
