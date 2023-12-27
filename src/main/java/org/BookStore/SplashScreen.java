package org.BookStore;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import org.BookStore.updater.*;

public class SplashScreen extends javax.swing.JFrame {


    private JLabel jLabel1;
    private JPanel jPanel1;


    @SuppressWarnings("unchecked")
    public SplashScreen() {
        initComponents();
    }
    private void initComponents(){
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        jPanel1.setBackground(new Color(0, 0, 255, 0));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/Splash.png"))); // NOI18N
        jPanel1.add(jLabel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
    }


}
