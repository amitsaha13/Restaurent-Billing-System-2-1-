package restaurent.billing.system;

import com.sun.glass.events.KeyEvent;

public class Management extends javax.swing.JFrame {
//this method is call from add button
    void add() {
        new AdminLogin().setVisible(true);
        press = 1;
        this.dispose();
    }
//this method is called from delete button
    void delete() {
        new AdminLogin().setVisible(true);
        press = 2;
        this.dispose();
    }
//this method is call from add or remove salesman
    void sales() {
        new AdminLogin().setVisible(true);
        press = 3;
        this.dispose();

    }
//this method is called from logout button
    void logout() {
        new LoginForm().setVisible(true);
        this.dispose();

    }
//this method is called from billing button
    void bill() {
        new BillGenerator().setVisible(true);
        this.dispose();
        press = 4;
    }
//this method is called from daily report button
    void report() {
        new Inventory_report().setVisible(true);
        this.dispose();
        press=5;
    }
    public static int press = 0;

    public Management() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ADD = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        BILLING = new javax.swing.JButton();
        Report = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JButton();
        SALESMAN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ForBAckground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management");
        setLocation(new java.awt.Point(260, 50));

        jPanel1.setLayout(null);

        ADD.setBackground(new java.awt.Color(0, 51, 51));
        ADD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 255, 255));
        ADD.setText("ADD FOOD ITEM");
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
        ADD.setBounds(290, 120, 240, 70);

        DELETE.setBackground(new java.awt.Color(0, 51, 51));
        DELETE.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DELETE.setForeground(new java.awt.Color(255, 255, 255));
        DELETE.setText("DELETE FOOD ITEM");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        DELETE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DELETEKeyPressed(evt);
            }
        });
        jPanel1.add(DELETE);
        DELETE.setBounds(290, 200, 240, 70);

        BILLING.setBackground(new java.awt.Color(0, 51, 51));
        BILLING.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BILLING.setForeground(new java.awt.Color(255, 255, 255));
        BILLING.setText("BILLING PAGE");
        BILLING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BILLINGActionPerformed(evt);
            }
        });
        BILLING.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BILLINGKeyPressed(evt);
            }
        });
        jPanel1.add(BILLING);
        BILLING.setBounds(290, 360, 240, 70);

        Report.setBackground(new java.awt.Color(0, 51, 51));
        Report.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setText("DAILY REPORT");
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });
        Report.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ReportKeyPressed(evt);
            }
        });
        jPanel1.add(Report);
        Report.setBounds(290, 440, 240, 70);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("              PLEASE SELECT AN OPTION");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 520, 90);

        LOGOUT.setBackground(new java.awt.Color(153, 0, 0));
        LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        LOGOUT.setText("Log Out");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });
        LOGOUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LOGOUTKeyPressed(evt);
            }
        });
        jPanel1.add(LOGOUT);
        LOGOUT.setBounds(663, 560, 90, 25);

        SALESMAN.setBackground(new java.awt.Color(0, 51, 51));
        SALESMAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SALESMAN.setForeground(new java.awt.Color(255, 255, 255));
        SALESMAN.setText("ADD OR REMOVE SALESMAN");
        SALESMAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALESMANActionPerformed(evt);
            }
        });
        SALESMAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SALESMANKeyPressed(evt);
            }
        });
        jPanel1.add(SALESMAN);
        SALESMAN.setBounds(290, 280, 240, 70);

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("©ZAS SOFTWARE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(370, 560, 100, 15);

        ForBAckground.setBackground(new java.awt.Color(222, 222, 222));
        ForBAckground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/2.jpg"))); // NOI18N
        jPanel1.add(ForBAckground);
        ForBAckground.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        delete();
    }//GEN-LAST:event_DELETEActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        try{logout();}
        catch(Exception e)
        {
            System.out.println("Exception for log out button");
        }
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void SALESMANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALESMANActionPerformed
        sales();
    }//GEN-LAST:event_SALESMANActionPerformed

    private void ADDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ADDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            add();
        }
    }//GEN-LAST:event_ADDKeyPressed

    private void DELETEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DELETEKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            delete();
        }
    }//GEN-LAST:event_DELETEKeyPressed

    private void SALESMANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SALESMANKeyPressed
        try{
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sales();
        }}
        catch(Exception e)
        {
            System.out.println("Exception for add or remove salesman button");
        }
    }//GEN-LAST:event_SALESMANKeyPressed

    private void LOGOUTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LOGOUTKeyPressed
        try{logout();}
        catch(Exception e)
        {
            System.out.println("Exception for log out button");
        }
    }//GEN-LAST:event_LOGOUTKeyPressed

    private void BILLINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BILLINGActionPerformed
        try{bill();}
        catch(Exception e)
        {
            System.out.println("Exception for billing page button");
        }
    }//GEN-LAST:event_BILLINGActionPerformed

    private void BILLINGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BILLINGKeyPressed
        try{bill();}
        catch(Exception e)
        {
            System.out.println("Exception for billing page button");
        }
    }//GEN-LAST:event_BILLINGKeyPressed

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        try{report();}
        catch(Exception e)
        {
            System.out.println("Error for Report button");
        }
    }//GEN-LAST:event_ReportActionPerformed

    private void ReportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ReportKeyPressed
      
        try{report();}
        catch(Exception e)
        {
            System.out.println("Error for Report button");
        }
    }//GEN-LAST:event_ReportKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton BILLING;
    private javax.swing.JButton DELETE;
    private javax.swing.JLabel ForBAckground;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JButton Report;
    private javax.swing.JButton SALESMAN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
