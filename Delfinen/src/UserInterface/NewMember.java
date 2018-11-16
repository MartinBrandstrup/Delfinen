/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Logic.Controller;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Kasper Jeppesen test test
 */
public class NewMember extends javax.swing.JPanel
{
    

    /**
     * Creates new form NewMember
     */
    public NewMember()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        Name = new javax.swing.JLabel();
        EmailAddress = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        City = new javax.swing.JLabel();
        ZipCode = new javax.swing.JLabel();
        DateOfBirth = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        EmailAddressTF = new javax.swing.JTextField();
        AddressTF = new javax.swing.JTextField();
        CityTF = new javax.swing.JTextField();
        ZipCodeTF = new javax.swing.JTextField();
        DateOfBirthTF = new javax.swing.JTextField();
        PhoneNumberTF = new javax.swing.JTextField();
        ConfirmChanges = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        MainMenu = new javax.swing.JButton();

        Name.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Name.setText("Name");
        Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        EmailAddress.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        EmailAddress.setText("Email Address:");
        EmailAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        Address.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Address.setText("Address:");
        Address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        City.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        City.setText("City:");
        City.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        ZipCode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ZipCode.setText("Zip Code:");
        ZipCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        DateOfBirth.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        DateOfBirth.setText("Date of Birth:");
        DateOfBirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        PhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        PhoneNumber.setText("Phone Number:");
        PhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        NameTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        EmailAddressTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        AddressTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        CityTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ZipCodeTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        DateOfBirthTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        PhoneNumberTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ConfirmChanges.setText("Confirm Changes");
        ConfirmChanges.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ConfirmChangesActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ResetActionPerformed(evt);
            }
        });

        MainMenu.setText("Main menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(MainMenu)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(City)
                    .addComponent(ZipCode)
                    .addComponent(DateOfBirth)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Name)
                            .addGap(66, 66, 66)
                            .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(EmailAddress)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EmailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddressTF, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(CityTF)
                            .addComponent(ZipCodeTF))
                        .addComponent(DateOfBirthTF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Address)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PhoneNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PhoneNumberTF)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Reset)
                .addGap(54, 54, 54)
                .addComponent(ConfirmChanges)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name)
                    .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailAddress)
                    .addComponent(EmailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address)
                    .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(City)
                    .addComponent(CityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ZipCode)
                            .addComponent(ZipCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DateOfBirth)
                            .addComponent(DateOfBirthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(MainMenu)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PhoneNumber)
                    .addComponent(PhoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmChanges)
                    .addComponent(Reset))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmChangesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ConfirmChangesActionPerformed
    {//GEN-HEADEREND:event_ConfirmChangesActionPerformed
       
        Controller c = new Controller();
       
        int zipCode = Integer.parseInt(this.ZipCodeTF.getText());
        long phoneNumber = Long.parseLong(this.PhoneNumberTF.getText());
        String name = this.NameTF.getText();
        String address = this.AddressTF.getText();
        String city = this.CityTF.getText();
        String email = this.EmailAddressTF.getText();
        LocalDate dateOfBirth = LocalDate.parse(this.DateOfBirthTF.getText()); //works if string is formatted like localdate (ex 2016-08-16)
        
        //dateOfBirth should perheps be changed to a jdatechooser
        
        //Kommentar test
        validation();
        
        c.registerNewMember(zipCode, phoneNumber, name, address, city, email, dateOfBirth);
        
        reset();
    }//GEN-LAST:event_ConfirmChangesActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ResetActionPerformed
    {//GEN-HEADEREND:event_ResetActionPerformed
        reset();
    }//GEN-LAST:event_ResetActionPerformed
    
    
    public void validation()
    {
        if(this.ZipCodeTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field zip code can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        if(this.PhoneNumberTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field phone number can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        if(this.NameTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field name can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        if(this.AddressTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field address can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        if(this.CityTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field city can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        if(this.EmailAddressTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field email address can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        if(this.DateOfBirthTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "The field date of birth can not be empty", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void reset()
    {
        this.ZipCodeTF.setText("");
        this.PhoneNumberTF.setText("");
        this.NameTF.setText("");
        this.AddressTF.setText("");
        this.CityTF.setText("");
        this.EmailAddressTF.setText("");
        this.DateOfBirthTF.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JTextField AddressTF;
    private javax.swing.JLabel City;
    private javax.swing.JTextField CityTF;
    private javax.swing.JButton ConfirmChanges;
    private javax.swing.JLabel DateOfBirth;
    private javax.swing.JTextField DateOfBirthTF;
    private javax.swing.JLabel EmailAddress;
    private javax.swing.JTextField EmailAddressTF;
    private javax.swing.JButton MainMenu;
    private javax.swing.JLabel Name;
    private javax.swing.JTextField NameTF;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JTextField PhoneNumberTF;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel ZipCode;
    private javax.swing.JTextField ZipCodeTF;
    // End of variables declaration//GEN-END:variables
}
