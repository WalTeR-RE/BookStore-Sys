package org.BookStore;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.BookStore.Authentication.ForgetPassword;
import org.BookStore.Controllers.*;

public class Forget_password extends javax.swing.JFrame {

    
    public Forget_password() {
        initComponents();
         answer.setVisible(false);
        Question.setVisible(false);
        Text.setVisible(false);
        OTP.setVisible(false);
                
                    
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Question = new javax.swing.JComboBox<>();
        answer = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ConfirmPassword = new javax.swing.JPasswordField();
        Password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Text = new javax.swing.JTextField();
        OTP = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORGET PASSWORD");
        setPreferredSize(new java.awt.Dimension(800, 550));
        ConfirmPassword.setVisible(false);
        Password.setVisible(false);
        jLabel3.setVisible(false);
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 550));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 550));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rafuf.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Rafuf");

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Copyright © Rafuf 2023. All Rights Reserved.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel12)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(54, 54, 54))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("To Reset Your Password");

        Question.setModel(new javax.swing.DefaultComboBoxModel<>(org.BookStore.Authentication.Register.getSecQuestions()));

        Submit.setText("Request");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jButton2.setText("Reset Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Back.setText("←");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OTPActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Your Way ", "Reset by E-mail", "Reset by Phone number" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("New password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(Text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(answer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(Question, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(OTP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(Password, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(ConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                                        .addGap(31, 31, 31)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                                                                .addComponent(Submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Text, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Question, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OTP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ;
    validators serializer = new validators();
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String m=(String)jComboBox1.getSelectedItem();
        if("Reset by E-mail".equals(m))
        {
            Question.setVisible(false);
            jLabel2.setText("E-mail");
            Text.setVisible(true);
        }
        else if("Reset by Phone number".equals(m))
        {

            Question.setVisible(false);
              jLabel2.setText("Phone Number");
              Text.setVisible(true);
            Text.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if(!(Character.isDigit(c))||Text.getText().length()==11)
                        e.consume();
                }
                @Override
                public void keyPressed(KeyEvent e) {

                }
                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        Login loginframe=new Login();
        loginframe.setVisible(true);
        ImageIcon image;
        image = new ImageIcon(getClass().getResource("/images/icons8-book-94.png"));
        loginframe.setIconImage(image.getImage());
        loginframe.pack();
        loginframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        String m=(String)jComboBox1.getSelectedItem();
        ForgetPassword forgetPassword = new ForgetPassword();
        if("Reset by E-mail".equals(m))
        {
            if(!serializer.isValidEmail(Text.getText())) {
                JOptionPane.showMessageDialog(null, "Enter A Valid Email Please");
                return;
            }
            if(Submit.getText().equals("Request"))
            {
                ForgetPassword.ForgetPasswordRequestStatus status = forgetPassword.ResetPasswordRequest(Text.getText(),"");
                switch (status){
                    case NOTFOUND -> {JOptionPane.showMessageDialog(null,"There Is No User With This Email"); return;}
                    case DBERROR -> {JOptionPane.showMessageDialog(null,"UnKnown Error\nPlease Contact Admin"); return;}
                    case FAIL -> {JOptionPane.showMessageDialog(null,"No Email Provided"); return;}
                    case WEALREADYSENTYOUOTP -> {JOptionPane.showMessageDialog(null,"We Already Have Sent You An OTP");}
                    case OK -> JOptionPane.showMessageDialog(null,"We have sent you an OTP!\nPlease Check Your Email");
                }
            }
            if(Submit.getText().equals("Submit")){
                ForgetPassword.ForgetPasswordResponseStatus stat = forgetPassword.SendResetRequestByOTP(Text.getText(),OTP.getText(),Password.getText(),ConfirmPassword.getText());
                switch (stat){
                    case WRONGOTP -> {JOptionPane.showMessageDialog(null,"Wrong OTP!"); return;}
                    case DBERROR -> {JOptionPane.showMessageDialog(null,"UnKnown Error\nPlease Contact Admin"); return;}
                    case FAIL -> {JOptionPane.showMessageDialog(null,"These Inputs Aren't Valid"); return;}
                    case SESSIONEXPIRED -> {JOptionPane.showMessageDialog(null,"Session Expired Please Reset The Form"); return;}
                    case ACCOUNTLOCKED -> { JOptionPane.showMessageDialog(null,"Due To Our Security Policies Your Account Has Been Locked!\nPlease Contact Admin"); return;}
                    case OK -> {JOptionPane.showMessageDialog(null,"Password Changed Successfully!");
                        Login loginframe=new Login();
                        loginframe.setVisible(true);
                        ImageIcon image;
                        image = new ImageIcon(getClass().getResource("/images/icons8-book-94.png"));
                        loginframe.setIconImage(image.getImage());
                        loginframe.pack();
                        loginframe.setLocationRelativeTo(null);
                        this.dispose();}
                }
            }
            Submit.setText("Submit");
            answer.setVisible(true);
            answer.setText("OTP");
            OTP.setVisible(true);
            jLabel3.setVisible(true);
            Password.setVisible(true);
            ConfirmPassword.setVisible(true);
            OTP.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if(!(Character.isDigit(c))||OTP.getText().length()==6)
                        e.consume();
                }
                @Override
                public void keyPressed(KeyEvent e) {

                }
                @Override
                public void keyReleased(KeyEvent e) {

                }
            });

        }
        else if("Reset by Phone number".equals(m))
        {

            if(!serializer.isValidPhoneNumber(Text.getText())) {
                JOptionPane.showMessageDialog(null, "Enter A Valid Phonenumber Please");
                return;
            }
            if(Submit.getText().equals("Request"))
            {
                ForgetPassword.ForgetPasswordRequestStatus status = forgetPassword.ResetPasswordRequest("",Text.getText());
                switch (status){
                    case NOTFOUND -> {JOptionPane.showMessageDialog(null,"There Is No User With This Phone number"); return;}
                    case DBERROR -> {JOptionPane.showMessageDialog(null,"UnKnown Error\nPlease Contact Admin");  return;}
                    case FAIL -> {JOptionPane.showMessageDialog(null,"No Phone number Provided");  return;}
                    case OK -> JOptionPane.showMessageDialog(null,"Please Complete This Challenge");
                }
            }
            if(Submit.getText().equals("Submit")){
                ForgetPassword.ForgetPasswordResponseStatus stat = forgetPassword.SendResetRequestByPhoneNumber(Text.getText(),(String)Question.getSelectedItem(),OTP.getText(),Password.getText(),ConfirmPassword.getText());
                switch (stat){
                    case WRONGOTP -> {JOptionPane.showMessageDialog(null,"Wrong Answer!"); return;}
                    case DBERROR -> {JOptionPane.showMessageDialog(null,"UnKnown Error\nPlease Contact Admin"); return;}
                    case FAIL -> {JOptionPane.showMessageDialog(null,"These Inputs Aren't Valid"); return;}
                    case SESSIONEXPIRED -> {JOptionPane.showMessageDialog(null,"Session Expired Please Reset The Form"); return;}
                    case ACCOUNTLOCKED -> { JOptionPane.showMessageDialog(null,"Due To Our Security Policies Your Account Has Been Locked!\nPlease Contact Admin"); return;}
                    case OK -> {JOptionPane.showMessageDialog(null,"Password Changed Successfully!");
                        Login loginframe=new Login();
                        loginframe.setVisible(true);
                        ImageIcon image;
                        image = new ImageIcon(getClass().getResource("/images/icons8-book-94.png"));
                        loginframe.setIconImage(image.getImage());
                        loginframe.pack();
                        loginframe.setLocationRelativeTo(null);
                        this.dispose();}
                }
            }
            Submit.setText("Submit");
            Question.setVisible(true);
            answer.setVisible(true);
            answer.setText("Security Question");
            OTP.setVisible(true);
            jLabel3.setVisible(true);
            Password.setVisible(true);
            ConfirmPassword.setVisible(true);


        }

        Text.disable();
        jComboBox1.disable();
    }//GEN-LAST:event_SubmitActionPerformed

    private void OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OTPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Forget_password forget=new Forget_password();
        forget.setVisible(true);
         ImageIcon image;
      image = new ImageIcon(getClass().getResource("/images/icons8-book-94.png"));
      forget.setIconImage(image.getImage());
      forget.pack();
      forget.setResizable(false);
      forget.setLocationRelativeTo(null);
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField OTP;
    private javax.swing.JComboBox<String> Question;
    private javax.swing.JPasswordField Password;
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField Text;
    private javax.swing.JLabel answer;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
