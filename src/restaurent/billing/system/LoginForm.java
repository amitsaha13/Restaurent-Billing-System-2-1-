package restaurent.billing.system;
import com.sun.glass.events.KeyEvent;
import java.sql.*;
import javax.swing.*;

public class LoginForm extends javax.swing.JFrame {

//for reset data of the username and password field
    void reset() {
        userName.setText(null);
        passWord.setText(null);
    }
//for login into management page where the all option are setted user

    void login() {
        String name, pass;
        name = userName.getText();
        pass = passWord.getText();
        Statement st = null;
        ResultSet rs = null;
        if (name.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill the USERNAME & PASSWORD");
        } else {
            try {
                Connection con = ConnectDatabase.ConnectDB();
                st = con.createStatement();
                // String Query = "SELECT * FROM admin WHERE 1 and 2";
                String Query = "SELECT * FROM userlogin";
                rs = st.executeQuery(Query);

                int size = 0;
                boolean login = false;
                while (rs.next()) {
                    size++;
                    if (rs.getString(1).equals(name) && rs.getString(2).equals(pass)) {
                        login = true;
                    }
                }
                if (login) {
                    JOptionPane.showMessageDialog(rootPane, "Successfully Logged In");
                    new Management().setVisible(true);

                    this.dispose();
                    

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Incorrect Username or Password");
                }

            } catch (Exception e) {
                System.out.println("ERROR FOR LOGIN KEY");
            }

        }
    }

    public LoginForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passWord = new javax.swing.JPasswordField();
        LOGIN = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        copyright = new javax.swing.JLabel();
        ForPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Login");
        setLocation(new java.awt.Point(400, 150));
        setResizable(false);

        loginpanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginpanelKeyPressed(evt);
            }
        });
        loginpanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");
        jLabel2.setToolTipText("");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginpanel.add(jLabel2);
        jLabel2.setBounds(100, 120, 100, 30);

        userName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        userName.setForeground(new java.awt.Color(0, 0, 0));
        loginpanel.add(userName);
        userName.setBounds(200, 120, 170, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");
        loginpanel.add(jLabel3);
        jLabel3.setBounds(100, 170, 80, 17);

        passWord.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passWordKeyPressed(evt);
            }
        });
        loginpanel.add(passWord);
        passWord.setBounds(200, 160, 170, 30);

        LOGIN.setBackground(new java.awt.Color(0, 102, 204));
        LOGIN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
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
        loginpanel.add(LOGIN);
        LOGIN.setBounds(130, 280, 100, 40);

        RESET.setBackground(new java.awt.Color(0, 102, 204));
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
        loginpanel.add(RESET);
        RESET.setBounds(290, 280, 100, 40);

        copyright.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        copyright.setForeground(new java.awt.Color(0, 0, 0));
        copyright.setText("©ZAS SOFTWARE");
        loginpanel.add(copyright);
        copyright.setBounds(200, 340, 110, 20);

        ForPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/11.jpg"))); // NOI18N
        loginpanel.add(ForPicture);
        ForPicture.setBounds(0, 0, 500, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        reset();
    }//GEN-LAST:event_RESETActionPerformed

    private void RESETKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RESETKeyPressed
        try{
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            reset();
        }}
        catch(Exception e)
        {
            System.out.println("ERROR FOR RESET BUTTON");
        }
    }//GEN-LAST:event_RESETKeyPressed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
        try{
        login();}
        catch(Exception e)
        {
            System.out.println("Exception for login button");
        }
    }//GEN-LAST:event_LOGINActionPerformed

    private void LOGINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LOGINKeyPressed
        try{
        login();}
        catch(Exception e)
        {
            System.out.println("Exception for login button");
        }
    }//GEN-LAST:event_LOGINKeyPressed

    private void loginpanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginpanelKeyPressed

    }//GEN-LAST:event_loginpanelKeyPressed

    private void passWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passWordKeyPressed
        try{
        if (evt.getKeyChar() == '\n') {
            login();
        }}
        catch(Exception e)
        {
            System.out.println("Exception for login button");
        }
    }//GEN-LAST:event_passWordKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ForPicture;
    private javax.swing.JButton LOGIN;
    private javax.swing.JButton RESET;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel loginpanel;
    private javax.swing.JPasswordField passWord;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
