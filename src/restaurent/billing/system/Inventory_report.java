package restaurent.billing.system;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Inventory_report extends javax.swing.JFrame {
DefaultTableModel model;
    void display() {
        ArrayList<InventoryManagement> a = new ArrayList<InventoryManagement>();
        InventoryManagement inv = new InventoryManagement();
        if (date.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Fill the text filled properly");
        } else {
            a = inv.read(date.getText(), a);
            if(a.isEmpty()){
                JOptionPane.showMessageDialog(rootPane,date.getText()+" 's daily report not found ");
            }
            else{
            model = (DefaultTableModel) reportShow.getModel();
            Object[] row = new Object[6];
            for (int i = 0; i < a.size(); i++) {
                row[0] = a.get(i).code;
                row[1] = a.get(i).name;
                row[2] = a.get(i).qnt;
                row[3] = a.get(i).vat;
                row[4] = a.get(i).price;
                row[5] = a.get(i).total;
                model.addRow(row);
            }
            }
        }

    }
void back()
        {
            new Management().setVisible(true);
            this.dispose();
        }
    public Inventory_report() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        Show = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportShow = new javax.swing.JTable();
        show = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 100));

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daily Reports");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255), 4));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 30, 200, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Date :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 70, 30);

        date.setBackground(new java.awt.Color(0, 0, 0));
        date.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateKeyPressed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(70, 98, 140, 30);

        Show.setBackground(new java.awt.Color(0, 102, 102));
        Show.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Show.setForeground(new java.awt.Color(255, 255, 255));
        Show.setText("Show");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });
        Show.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ShowKeyPressed(evt);
            }
        });
        jPanel1.add(Show);
        Show.setBounds(340, 90, 110, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ex:(dd.mm.year)");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 94, 90, 30);

        Clear.setBackground(new java.awt.Color(0, 102, 102));
        Clear.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        Clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ClearKeyPressed(evt);
            }
        });
        jPanel1.add(Clear);
        Clear.setBounds(460, 90, 110, 40);

        back.setBackground(new java.awt.Color(0, 102, 102));
        back.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backKeyPressed(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(583, 10, 100, 24);

        reportShow.setBackground(new java.awt.Color(204, 204, 204));
        reportShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Item Qty", "Vat", "Item Price", "Total(total with vat)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reportShow);
        if (reportShow.getColumnModel().getColumnCount() > 0) {
            reportShow.getColumnModel().getColumn(0).setResizable(false);
            reportShow.getColumnModel().getColumn(2).setResizable(false);
            reportShow.getColumnModel().getColumn(3).setResizable(false);
            reportShow.getColumnModel().getColumn(4).setResizable(false);
            reportShow.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 140, 700, 403);

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/15.jpg"))); // NOI18N
        jPanel1.add(show);
        show.setBounds(0, 0, 700, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        display();
    }//GEN-LAST:event_ShowActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_backActionPerformed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n')
        back();
    }//GEN-LAST:event_backKeyPressed

    private void ShowKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ShowKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyChar()=='\n')
         {
         display();
         }
    }//GEN-LAST:event_ShowKeyPressed

    private void dateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateKeyPressed
         // TODO add your handling code here:
         if(evt.getKeyChar()=='\n')
         {
         display();
         }
    }//GEN-LAST:event_dateKeyPressed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        try{
        date.setText(null);
        model.setRowCount(0);
        }
        catch(Exception e)
        {
            System.out.println("Exception for clear button");
        }
    }//GEN-LAST:event_ClearActionPerformed

    private void ClearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClearKeyPressed
      try{
      if(evt.getKeyChar()=='\n')
      {
      date.setText(null);
      model.setRowCount(0);
      }
      }
      catch(Exception e)
      {
          System.out.println("Exception for clear button");
      }
    }//GEN-LAST:event_ClearKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory_report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Show;
    private javax.swing.JButton back;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reportShow;
    private javax.swing.JLabel show;
    // End of variables declaration//GEN-END:variables
}
