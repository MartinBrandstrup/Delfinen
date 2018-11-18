/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Data.DataAccessorFile;
import Logic.Controller;
import Logic.Member;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**Chris giver moralsk opbakning
 *
 * @author Kasper Jeppesen
 */
public class ManageMembers extends javax.swing.JPanel
{
    
  GUI g = new GUI();
    DataAccessorFile data = new DataAccessorFile();
    Controller c = new Controller(data);

    /**
     * Creates new form ManageMembers
     */
    public ManageMembers() throws Exception
    {
        initComponents();
        addRowToTable();
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

        jButton4 = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        ViewMemberInfo = new javax.swing.JMenuItem();
        RegNewMember = new javax.swing.JMenuItem();
        CancelMembership = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MembersTable = new javax.swing.JTable();

        jButton4.setText("jButton4");

        ViewMemberInfo.setText("View / change selected member info");
        ViewMemberInfo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ViewMemberInfoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ViewMemberInfo);

        RegNewMember.setText("Register new member");
        jPopupMenu1.add(RegNewMember);

        CancelMembership.setText("Cancel membership");
        jPopupMenu1.add(CancelMembership);

        setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Manage Members");

        jButton7.setText("Main Menu");

        jButton8.setText("Confirm Changes");

        jButton9.setText("Register New Member");
        jButton9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Cancel Membership");

        MembersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Name", "MID", "Status"
            }
        ));
        MembersTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                MembersTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(MembersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10))
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jButton7))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton9ActionPerformed
    {//GEN-HEADEREND:event_jButton9ActionPerformed
      
        NewMember m =  new NewMember();
        this.g.ChangePanel();// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void MembersTableMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_MembersTableMouseReleased
    {//GEN-HEADEREND:event_MembersTableMouseReleased
        //Mouse Released is apperantly equal to mouse right click???? 
        if(evt.isPopupTrigger()) //If this event is triggrede (java.awt.event.Mouse event evt) - the parameter for this method
        {
            jPopupMenu1.show(this, evt.getX(), evt.getY()); //show the popup at memberstable at this event x,y cordinates
        }
    }//GEN-LAST:event_MembersTableMouseReleased

    private void ViewMemberInfoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ViewMemberInfoActionPerformed
    {//GEN-HEADEREND:event_ViewMemberInfoActionPerformed
        rowSelected();
        
        //this.dispose();
    }//GEN-LAST:event_ViewMemberInfoActionPerformed

    public void addRowToTable() throws Exception
    {
        c.updateMemberList();
        
        
        DefaultTableModel model = (DefaultTableModel) MembersTable.getModel();
        System.out.print("MemberList size is: " + c.getMemberList().size());
        ArrayList<Member> list = c.getMemberlist();
        Object rowData[] = new Object[3];
        for(int i = 0; i < list.size(); ++i)
        {
            rowData[0] = list.get(i).getName();
            rowData[1] = list.get(i).getMemberID();
            rowData[2] = list.get(i).getActivityStatusString();
            model.addRow(rowData);
        }  
    }
    public int rowSelected() //returns the index of the row selected
    {
        int index;
        
        if(MembersTable.getSelectionModel().isSelectionEmpty())
        {
            System.out.print("No rows selected");
        }
        
        index = MembersTable.getSelectedRow();
        return index;    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CancelMembership;
    private javax.swing.JTable MembersTable;
    private javax.swing.JMenuItem RegNewMember;
    private javax.swing.JMenuItem ViewMemberInfo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
