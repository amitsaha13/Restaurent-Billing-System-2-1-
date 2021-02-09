package restaurent.billing.system;

import java.sql.*;
import javax.swing.*;
import static restaurent.billing.system.Management.press;

public class AdminLogin extends javax.swing.JFrame {

    private boolean salesman;
//reset function for reset button action

    void reset() {
        AdminUSERNAME.setText(null);
        AdminPASSWORD.setText(null);
    }

    //this function for login the main admin
    void adminlogin() {
        String name, pass;
        name = AdminUSERNAME.getText();
        pass = AdminPASSWORD.getText();
        Statement st = null;
        ResultSet rs = null;
        try {
            Connection con = ConnectDatabase.ConnectDB();
            st = con.createStatement();
            String Query = "SELECT * FROM mainadmin WHERE 1 and 2";
            rs = st.executeQuery(Query);
            int size = 0;
            while (rs.next()) {
                size++;
                if (name.equals("") && pass.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please Fill the USERNAME & PASSWORD");
                    break;
                } else if (rs.getString(1).equals(name) && rs.getString(2).equals(pass)) {
                    if (press == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Successfully Logged in");
                        new ADDFOODITEM().setVisible(true);
                        this.dispose();
                    } else if (press == 3) {
                        JOptionPane.showMessageDialog(rootPane, "Successfully Logged in");
                        new AddRemoveSalesMan().setVisible(true);
                        this.dispose();

                    } else if (press == 2) {
                        JOptionPane.showMessageDialog(rootPane, "Successfully Logged in");

                        new DELETEFOODITEM().setVisible(true);
                        this.dispose();
                    }

                    break;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect Username or password");
                    break;
                }

            }

        } catch (SQLException e) {
            System.out.println("ERROR");
        }

    }

    public AdminLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LOGIN = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        AdminPASSWORD = new javax.swing.JPasswordField();
        AdminUSERNAME = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN LOGIN");
        setLocation(new java.awt.Point(400, 200));
        setPreferredSize(new java.awt.Dimension(500, 410));

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMIN LOGIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 35, 300, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 140, 90, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 180, 80, 17);

        LOGIN.setBackground(new java.awt.Color(0, 102, 102));
        LOGIN.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("LOGIN");
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        LOGIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LOGINKeyPressed(evt);
            }
        });
        jPanel1.add(LOGIN);
        LOGIN.setBounds(150, 250, 110, 50);

        RESET.setBackground(new java.awt.Color(0, 102, 102));
        RESET.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        RESET.setForeground(new java.awt.Color(255, 255, 255));
        RESET.setText("RESET");
        RESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESETActionPerformed(evt);
            }
        });
        RESET.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RESETKeyPressed(evt);
            }
        });
        jPanel1.add(RESET);
        RESET.setBounds(310, 250, 110, 50);

        AdminPASSWORD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        AdminPASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPASSWORDActionPerformed(evt);
            }
        });
        AdminPASSWORD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdminPASSWORDKeyPressed(evt);
            }
        });
        jPanel1.add(AdminPASSWORD);
        AdminPASSWORD.setBounds(210, 170, 190, 30);

        AdminUSERNAME.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(AdminUSERNAME);
        AdminUSERNAME.setBounds(210, 130, 190, 30);

        jLabel5.setText("©ZAS SOFTWARE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(220, 350, 100, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/4.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdminPASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPASSWORDActionPerformed
    }//GEN-LAST:event_AdminPASSWORDActionPerformed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
        adminlogin();
    }//GEN-LAST:event_LOGINActionPerformed

    private void LOGINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LOGINKeyPressed
       if(evt.getKeyChar()=='\n')
        adminlogin();
       
    }//GEN-LAST:event_LOGINKeyPressed

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        reset();
    }//GEN-LAST:event_RESETActionPerformed

    private void RESETKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RESETKeyPressed
        if(evt.getKeyChar()=='\n')
        reset();
    }//GEN-LAST:event_RESETKeyPressed

    private void AdminPASSWORDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminPASSWORDKeyPressed
        if (!AdminUSERNAME.equals("") && !AdminPASSWORD.equals("")) {
            if (evt.getKeyChar() == '\n') {
                adminlogin();

            }
        }
    }//GEN-LAST:event_AdminPASSWORDKeyPressed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AdminPASSWORD;
    private javax.swing.JTextField AdminUSERNAME;
    private javax.swing.JButton LOGIN;
    private javax.swing.JButton RESET;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
