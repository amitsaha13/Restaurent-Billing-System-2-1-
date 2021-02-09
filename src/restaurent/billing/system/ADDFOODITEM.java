package restaurent.billing.system;

import static restaurent.billing.system.Management.press;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ADDFOODITEM extends javax.swing.JFrame {

    String item_id = "", item_name = "", item_price = "";
//function for back button action

    void back() {
        new Management().setVisible(true);
        this.dispose();
        press = 0;
    }
//function for clear button action

    void clear() {
        ITEMID.setText(null);
        ITEMNAME.setText(null);
        ITEMPRICE.setText(null);
    }
    //Function for Add button action

    void add() {
        item_id = ITEMID.getText();
        item_name = ITEMNAME.getText();
        item_price = ITEMPRICE.getText();
        PreparedStatement pst = null;
        if (item_id.equals("") || item_name.equals("") || item_price.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "PLEASE FILLED UP EVERY FIELD");
        } else {
            try {

                Connection con = ConnectDatabase.ConnectDB();
                //if at the text field of item codes first char is S then insert item in Snacks database table
                if (item_id.charAt(0) == 'S') {
                    String Query = "INSERT INTO Snacks values (?,?,?)";
                    pst = con.prepareStatement(Query);
                    pst.setString(1, item_id);
                    pst.setString(2, item_name);
                    pst.setString(3, item_price);
                    int i = pst.executeUpdate();

                    if (i > 0) {
                        System.out.println("Success");
                        JOptionPane.showMessageDialog(rootPane, "ITEM ADD SUCCESSFUL");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ITEM ADD UNSUCCESSFUL");
                    }
                } //if at the text field of item codes first char is D then insert item in Drinks database table
                else if (item_id.charAt(0) == 'D') {
                    String Query = "INSERT INTO drinks values (?,?,?)";
                    pst = con.prepareStatement(Query);
                    pst.setString(1, item_id);
                    pst.setString(2, item_name);
                    pst.setString(3, item_price);
                    int i = pst.executeUpdate();

                    if (i > 0) {
                        System.out.println("Success");
                        JOptionPane.showMessageDialog(rootPane, "ITEM ADD SUCCESSFUL");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ITEM ADD UNSUCCESSFUL");
                    }
                } //if at the text field of item codes first char is L then insert item in lunch database table 
                else if (item_id.charAt(0) == 'L') {
                    String Query = "INSERT INTO Lunch values (?,?,?)";
                    pst = con.prepareStatement(Query);
                    pst.setString(1, item_id);
                    pst.setString(2, item_name);
                    pst.setString(3, item_price);
                    int i = pst.executeUpdate();

                    if (i > 0) {
                        System.out.println("Success");
                        JOptionPane.showMessageDialog(rootPane, "ITEM ADD SUCCESSFUL");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ITEM ADD UNSUCCESSFUL");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "PLEASE FILL THE ITEM ID CORRECTLY");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Please Change the Item_ID");
            }
        }
    }

    public ADDFOODITEM() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ITEMID = new javax.swing.JTextField();
        ITEMNAME = new javax.swing.JTextField();
        ITEMPRICE = new javax.swing.JTextField();
        ADD = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 50));

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADD FOOD ITEM");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 10, 470, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ITEM ID ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 130, 110, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ITEM NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(110, 190, 90, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ITEM PRICE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 240, 80, 17);

        ITEMID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(ITEMID);
        ITEMID.setBounds(230, 130, 250, 30);

        ITEMNAME.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(ITEMNAME);
        ITEMNAME.setBounds(230, 180, 250, 30);

        ITEMPRICE.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ITEMPRICE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ITEMPRICEKeyPressed(evt);
            }
        });
        jPanel1.add(ITEMPRICE);
        ITEMPRICE.setBounds(230, 230, 250, 30);

        ADD.setBackground(new java.awt.Color(0, 102, 102));
        ADD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 255, 255));
        ADD.setText("ADD");
        ADD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        ADD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ADDKeyPressed(evt);
            }
        });
        jPanel1.add(ADD);
        ADD.setBounds(90, 350, 150, 50);

        CLEAR.setBackground(new java.awt.Color(0, 102, 102));
        CLEAR.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CLEAR.setForeground(new java.awt.Color(255, 255, 255));
        CLEAR.setText("CLEAR");
        CLEAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });
        CLEAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLEARKeyPressed(evt);
            }
        });
        jPanel1.add(CLEAR);
        CLEAR.setBounds(260, 350, 150, 50);

        Back.setBackground(new java.awt.Color(0, 104, 104));
        Back.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back ");
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        Back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BackKeyPressed(evt);
            }
        });
        jPanel1.add(Back);
        Back.setBounds(430, 350, 160, 50);

        jLabel6.setText("©ZAS SOFTWARE");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(300, 550, 100, 15);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3 .jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        add();
    }//GEN-LAST:event_ADDActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        back();
    }//GEN-LAST:event_BackActionPerformed

    private void BackKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BackKeyPressed

        try {
            if (evt.getKeyChar() == '\n') {
                back();
            }
        } catch (Exception e) {
            System.out.println("ERROR FOR BACK KEY");
        }
    }//GEN-LAST:event_BackKeyPressed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        clear();
    }//GEN-LAST:event_CLEARActionPerformed

    private void CLEARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLEARKeyPressed
        try {
            if (evt.getKeyChar() == '\n') {
                clear();
            }
        } catch (Exception e) {
            System.out.println("ERROR FOR CLEAR KEY");
        }
    }//GEN-LAST:event_CLEARKeyPressed

    private void ADDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDKeyPressed
        try {
            if (evt.getKeyChar() == '\n') {
                add();
            }

        } catch (Exception e) {
            System.out.println("ERROR FOR ADD KEY");
        }
    }//GEN-LAST:event_ADDKeyPressed

    private void ITEMPRICEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ITEMPRICEKeyPressed
        try {
            if (evt.getKeyChar() == '\n') {
                if (!ITEMID.equals("") && !ITEMNAME.equals("") && !ITEMPRICE.equals("")) {
                   add();
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR FOR ITEM PRICE FIELD");
        }
    }//GEN-LAST:event_ITEMPRICEKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ADDFOODITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDFOODITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDFOODITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDFOODITEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADDFOODITEM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton Back;
    private javax.swing.JButton CLEAR;
    private javax.swing.JTextField ITEMID;
    private javax.swing.JTextField ITEMNAME;
    private javax.swing.JTextField ITEMPRICE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
