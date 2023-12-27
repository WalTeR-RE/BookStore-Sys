/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.BookStore;

import org.BookStore.Services.CreateBookView;
import org.BookStore.Services.SearchBook;
import org.BookStore.users.*;

import javax.swing.*;

import org.BookStore.Books.*;

import java.awt.*;

/**
 *
 * @author CompuTouch
 */
public class MAIN_FORMM extends javax.swing.JFrame {


    /**
     * Creates new form main
     */
    public MAIN_FORMM() {
        
        initComponents();
        jPanel2.setLayout(new WrapLayout());
        CreateBookView.setMainFrame(this);
        for(Book book : Book.getListOfBooks()){
            jPanel2.add(new CreateBookView(book.getCoverimg(),book.getTitle(),book.getAvgrev()));
        }
        PointsNumber.setText(String.valueOf(currentuser.getInstance().getPoints()));
        jLabel1.setText(currentuser.getInstance().getName());
        Seacrch_Icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JScrollBar verticalScrollBar;
        verticalScrollBar = jScrollPane2.getVerticalScrollBar();
verticalScrollBar.setUnitIncrement(15);
verticalScrollBar.setBlockIncrement(100);

        if(!currentuser.getInstance().IsManager())
            ManageApplication.setVisible(false);
pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PointsNumber = new javax.swing.JLabel();
        OrderHistory = new javax.swing.JButton();
        MyVouchers = new javax.swing.JButton();
        Community = new javax.swing.JButton();
        Tickets = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        ManageApplication = new javax.swing.JButton();
        AboutUS = new javax.swing.JButton();
        SearchBar = new javax.swing.JTextField();
        Seacrch_Icon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel5.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERNAME");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("POINTS");

        PointsNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PointsNumber.setText("GET");

        OrderHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        OrderHistory.setText("Order History");
        OrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHistoryActionPerformed(evt);
            }
        });

        MyVouchers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MyVouchers.setText("My Vouchers");
        MyVouchers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyVouchersActionPerformed(evt);
            }
        });

        Community.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Community.setText("Community");
        Community.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommunityActionPerformed(evt);
            }
        });

        Tickets.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tickets.setText("Tickets");
        Tickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketsActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        ManageApplication.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ManageApplication.setText("Manage Application");
        ManageApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageApplicationActionPerformed(evt);
            }
        });

        AboutUS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AboutUS.setText("About US");
        AboutUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutUSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OrderHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MyVouchers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tickets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ManageApplication, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AboutUS, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Community, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PointsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PointsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(OrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(MyVouchers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Community, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Tickets, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ManageApplication, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(AboutUS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel1);
        jPanel1.setBounds(570, 0, 250, 660);

        SearchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBarMouseClicked(evt);
            }
        });
        jPanel5.add(SearchBar);
        SearchBar.setBounds(10, 10, 490, 30);

        Seacrch_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search(1).png"))); // NOI18N
        Seacrch_Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Seacrch_IconMouseClicked(evt);
            }
        });
        jPanel5.add(Seacrch_Icon);
        Seacrch_Icon.setBounds(510, 10, 20, 30);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(10, 50, 560, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        org.BookStore.Authentication.Login.OnlineStatus(currentuser.getInstance(),"0");
        currentuser.getInstance().logout();
        Login loginframe=new Login();
        ImageIcon image;
        image = new ImageIcon(loginframe.getClass().getResource("/Images/icons8-book-94.png"));
        loginframe.setIconImage(image.getImage());
        loginframe.setVisible(true);
        loginframe.pack();
        loginframe.setResizable(false);
        loginframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void CommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommunityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CommunityActionPerformed

    private void OrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderHistoryActionPerformed

    private void SearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarMouseClicked

    private void Seacrch_IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Seacrch_IconMouseClicked
        jPanel2.removeAll();
        if(SearchBar.getText().trim()=="") {
            for(Book book: Book.getListOfBooks())
            {
                jPanel2.add(new CreateBookView(book.getCoverimg(),book.getTitle(),book.getAvgrev()));
            }
            jPanel2.revalidate();
            jPanel2.repaint();
            return;
        }
        SearchBook.setFoundBooks(SearchBar.getText());
        for(Book book: SearchBook.getFoundBooks()){
            jPanel2.add(new CreateBookView(book.getCoverimg(),book.getTitle(),book.getAvgrev()));
        }
        jPanel2.revalidate();
        jPanel2.repaint();

    }//GEN-LAST:event_Seacrch_IconMouseClicked

    private void MyVouchersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyVouchersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyVouchersActionPerformed

    private void TicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TicketsActionPerformed

    private void ManageApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageApplicationActionPerformed
        AdminPanel_Form adminframe=new AdminPanel_Form();
        ImageIcon image;
        image = new ImageIcon(adminframe.getClass().getResource("/Images/icons8-book-94.png"));
        adminframe.setIconImage(image.getImage());
        adminframe.setVisible(true);
        adminframe.pack();
        adminframe.setResizable(false);
        adminframe.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_ManageApplicationActionPerformed

    private void AboutUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutUSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AboutUSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN_FORMM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN_FORMM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutUS;
    private javax.swing.JButton Community;
    private javax.swing.JButton Logout;
    private javax.swing.JButton ManageApplication;
    private javax.swing.JButton MyVouchers;
    private javax.swing.JButton OrderHistory;
    private javax.swing.JLabel PointsNumber;
    private javax.swing.JLabel Seacrch_Icon;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JButton Tickets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}