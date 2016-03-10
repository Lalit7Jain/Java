/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLogic.Person;

/**
 *
 * @author Lalit
 */
public class viewProfilePanel extends javax.swing.JPanel {
private Person person;
    /**
     * Creates new form viewProfilePanel
     */
    public viewProfilePanel(Person p1) {
        initComponents();
        this.person = p1;
        displayPanel(p1);
        
    }

    
    private void displayPanel(Person p1){
    txtAddress.setText(p1.getAddress());
    txtAreaCode.setText(Integer.toString(p1.getAreacode()));
    txtDobYear.setText(p1.getYear());
    txtDobMm.setText(p1.getMonth());
    txtDobDd.setText(p1.getDay());
    txtZipcode.setText(Integer.toString(p1.getZipcode()));
    txtPhoneNumber.setText(Integer.toString(p1.getPhoneNumber()));
    txtEmail.setText(p1.getEmail());
    txtFirstName.setText(p1.getFirstName());
    txtMiddle.setText(p1.getMiddleName());
    txtLast.setText(p1.getLastName());
    txtOccupation.setText(p1.getOccupation());
    txtTown.setText(p1.getTown());
    
    txtAddress.setEditable(false);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMiddleName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblDob = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtAreaCode = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblTown = new javax.swing.JLabel();
        txtLast = new javax.swing.JTextField();
        txtMiddle = new javax.swing.JTextField();
        lblZip = new javax.swing.JLabel();
        lblOccupation = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        lblAreacode = new javax.swing.JLabel();
        txtZipcode = new javax.swing.JTextField();
        lblCreatePersonProfile = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        txtOccupation = new javax.swing.JTextField();
        txtDobMm = new javax.swing.JTextField();
        txtDobDd = new javax.swing.JTextField();
        txtDobYear = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(553, 468));

        lblMiddleName.setText("Middle Name");

        lblLastName.setText("Last Name");

        txtEmail.setEditable(false);

        lblDob.setText("DOB (yyyy/mm/dd)");

        lblFirstName.setText("First Name");

        txtAreaCode.setEditable(false);

        txtPhoneNumber.setEditable(false);

        lblAddress.setText("Street Address");

        txtFirstName.setEditable(false);
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblTown.setText("Town");

        txtLast.setEditable(false);
        txtLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastActionPerformed(evt);
            }
        });

        txtMiddle.setEditable(false);

        lblZip.setText("Zip Code");

        lblOccupation.setText("Occupation");

        txtAddress.setEditable(false);

        lblEmail.setText("Email Address");

        txtTown.setEditable(false);

        lblAreacode.setText("Area Code of Phone Number");

        txtZipcode.setEditable(false);

        lblCreatePersonProfile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCreatePersonProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreatePersonProfile.setText("        View Person Profile");

        lblPhoneNumber.setText("Phone Number");

        txtOccupation.setEditable(false);

        txtDobMm.setEditable(false);

        txtDobDd.setEditable(false);
        txtDobDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDobDdActionPerformed(evt);
            }
        });

        txtDobYear.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCreatePersonProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddress)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTown)
                                        .addGap(154, 154, 154)
                                        .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblZip)
                                        .addGap(138, 138, 138)
                                        .addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblOccupation)
                                    .addComponent(lblEmail)
                                    .addComponent(lblAreacode)
                                    .addComponent(lblPhoneNumber)
                                    .addComponent(lblLastName)
                                    .addComponent(lblFirstName)
                                    .addComponent(lblMiddleName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtLast)
                                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDob)
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDobYear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDobMm, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDobDd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAddress)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCreatePersonProfile)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMiddleName)
                    .addComponent(txtMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDob)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDobYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDobMm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDobDd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTown)
                    .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZip)
                    .addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOccupation)
                    .addComponent(txtOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAreacode)
                    .addComponent(txtAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastActionPerformed

    private void txtDobDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDobDdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDobDdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAreacode;
    private javax.swing.JLabel lblCreatePersonProfile;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblOccupation;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblTown;
    private javax.swing.JLabel lblZip;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAreaCode;
    private javax.swing.JTextField txtDobDd;
    private javax.swing.JTextField txtDobMm;
    private javax.swing.JTextField txtDobYear;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtMiddle;
    private javax.swing.JTextField txtOccupation;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtZipcode;
    // End of variables declaration//GEN-END:variables
}