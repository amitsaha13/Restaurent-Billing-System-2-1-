package restaurent.billing.system;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

public class BillGenerator extends javax.swing.JFrame {

    ArrayList<InventoryManagement> af = new ArrayList<InventoryManagement>();
    Calendar cp = Calendar.getInstance();

    String extra = "                                                  ZAS RESTAURENT\n"
            + "                                                         AUST\n"
            + "    Time:" + cp.get(Calendar.HOUR) + ":" + cp.get(Calendar.MINUTE) + "                                                   " + "Date:" + cp.get(Calendar.DATE) + "/" + cp.get(Calendar.MONTH) + "/" + cp.get(Calendar.YEAR) + "\n"
            + "    ----------------------------------------------------------------------------------------------\n"
            + "    ----------------------------------------------------------------------------------------------\n"
            + "       ITEM CODE  ITEM NAME   ITEM PRICE  ITEM QTY  VAT%  TOTAL\n"
            + "                                                                              \n"
            + "    ----------------------------------------------------------------------------------------------\n";
//add the extra string in jtext area
    void add() {

        ShowBill.setText(extra);

    }
    double total = 0.0, pri = 0.0, p = 0.0;
    String code_ = null, Name_ = null, Price = null, Qtyy = null, Va = null;
    double grandtotal = 0.0;
//add the values of food item and other thing in jtext area
    void add_textarea() {
        try {
            code_ = code.getText();
            Name_ = Name.getText();

            Price = price.getText();
            if (Qty.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please fill up the Qty field");

            } else {
                Qtyy = Qty.getText();
            }
            if (Vat.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please fill up the Vat field");
            } else {
                Va = Vat.getText();
            }
            int q = Integer.parseInt(Qtyy);
            double p = Integer.parseInt(Price);
            pri = p * q;
            System.out.println(Va);
            double v = Double.parseDouble(Va);
            p = pri * v / 100.0;
            total = pri + p;
            grandtotal += total;

            String st = "";
            for (int i = 0; i < Name_.length(); i++) {
                if (Name_.charAt(i) == ' ') {

                } else {
                    st += Name_.charAt(i);
                }
            }
            
            af.add(new InventoryManagement(code_, st, pri, Qtyy, Va, total));

            ShowBill.append("        " + code_ + "       " + Name_ + "               " + pri + "            " + q + "          " + v + "      " + total + "\n");
             
        } catch (Exception e) {
            System.out.println("Something went Wrong" + " " + e);
        }

    }
    //while the print button press then append the grandtotal
    void add_extra1()
    {
    String SS=Double.toString(grandtotal);
    
    
    ShowBill.append("\n\n---------------------------------------------------------------------------------------------------\n"+
                            "\t\tTotal:\t   " +SS+"\n----------------------------------------------------------------------------------------------------");
    
    
    }
//this method is for date and time 
    public void day() {
        Thread clock;

        clock = new Thread() {
            public void run() {
                
                for (;;) {
                    Calendar c = Calendar.getInstance();
                    int m=c.get(Calendar.MONTH)+1;
                    String ss = c.get(Calendar.DATE) + "." +m + "." + c.get(Calendar.YEAR);
                    d.setText(ss);
                    int hour = c.get(Calendar.HOUR);
                    int min = c.get(Calendar.MINUTE);
                    int sec = c.get(Calendar.SECOND);

                    String time = hour + ":" + min + ":" + sec;
                    t.setText(time + "AM");
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Exception for tme and date");
                    }
                }
            }
        };
        clock.start();
    }

    DefaultTableModel model;
//read from database and store into a array list
    public ArrayList<items> itemlist() {

        ArrayList<items> itemlist = new ArrayList<>();
        try {

            Connection con = ConnectDatabase.ConnectDB();

            String Query = "SELECT * FROM Snacks";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Query);
            items itms;

            while (rs.next()) {
                itms = new items(rs.getString("Item_Code"), rs.getString("Item_Name"), rs.getString("Item_Price"));
                itemlist.add(itms);
            }
        } catch (Exception e) {
            System.out.println("Throwing");
        }

        return itemlist;
    }
//display the arraylist in table
    public void display() {

        ArrayList<items> item = itemlist();
        model = (DefaultTableModel) itemTable.getModel();

        Object[] row = new Object[3];
        for (int i = 0; i < item.size(); i++) {
            row[0] = item.get(i).getID();
            row[1] = item.get(i).getItemName();
            row[2] = item.get(i).getItemPrice();
            model.addRow(row);
        }
    }
//read from database and store into a array list

    public ArrayList<items> itemlist1() {

        ArrayList<items> itemlist1 = new ArrayList<>();
        try {

            Connection con = ConnectDatabase.ConnectDB();

            String Query = "SELECT * FROM Drinks";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Query);
            items itms;

            while (rs.next()) {
                itms = new items(rs.getString("Item_Code"), rs.getString("Item_Name"), rs.getString("Item_Price"));
                itemlist1.add(itms);
            }
        } catch (Exception e) {
            System.out.println("Throwing");
        }

        return itemlist1;
    }
//display from arraylist
    public void display1() {

        ArrayList<items> item = itemlist1();
        model = (DefaultTableModel) itemTable.getModel();

        Object[] row = new Object[3];
        for (int i = 0; i < item.size(); i++) {
            row[0] = item.get(i).getID();
            row[1] = item.get(i).getItemName();
            row[2] = item.get(i).getItemPrice();
            model.addRow(row);
        }
        System.out.println(item.size());
    }
//read from database and store into a array list

    public ArrayList<items> itemlist2() {

        ArrayList<items> itemlist2 = new ArrayList<>();
        try {

            Connection con = ConnectDatabase.ConnectDB();

            String Query = "SELECT * FROM lunch";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Query);
            items itms;

            while (rs.next()) {
                itms = new items(rs.getString("Item_Code"), rs.getString("Item_Name"), rs.getString("Item_Price"));
                itemlist2.add(itms);
            }
        } catch (Exception e) {
            System.out.println("Throwing");
        }

        return itemlist2;
    }
//show from arraylist
    public void display2() {

        ArrayList<items> item = itemlist2();
        model = (DefaultTableModel) itemTable.getModel();

        Object[] row = new Object[3];
        for (int i = 0; i < item.size(); i++) {
            row[0] = item.get(i).getID();
            row[1] = item.get(i).getItemName();
            row[2] = item.get(i).getItemPrice();
            model.addRow(row);
        }
        System.out.println(item.size());
    }

    public BillGenerator() {
        initComponents();
        day();
        add();
    }
//this method is for printng and save the daily selling 
    void printing() {
        try {
            new InventoryManagement().write(d.getText(), af);
        } catch (IOException ex) {
            System.out.println("IO ERROR");
        }

        try {
            add_extra1();
            Boolean pri = ShowBill.print();
            if (pri) {
                JOptionPane.showMessageDialog(rootPane, "Done");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Printing Cancled");
            }
        } catch (PrinterException ex) {
            System.out.println("Error printer exception");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Snacks = new javax.swing.JButton();
        ZAS = new javax.swing.JLabel();
        Menus = new javax.swing.JLabel();
        Drinks = new javax.swing.JButton();
        Lunch = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        dtt = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        tt = new javax.swing.JLabel();
        ITEM_CODE = new javax.swing.JLabel();
        ITEM_PRICE = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        t = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        Clear = new javax.swing.JButton();
        ITEM_QTY = new javax.swing.JLabel();
        ITEM_NAME = new javax.swing.JLabel();
        Vat = new javax.swing.JTextField();
        VAT = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Qty = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ShowBill = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Billing Form");
        setLocation(new java.awt.Point(30, 0));
        setPreferredSize(new java.awt.Dimension(1200, 720));

        jPanel1.setLayout(null);

        Snacks.setBackground(new java.awt.Color(153, 0, 0));
        Snacks.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Snacks.setForeground(new java.awt.Color(0, 0, 0));
        Snacks.setText("Snacks");
        Snacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SnacksActionPerformed(evt);
            }
        });
        Snacks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SnacksKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SnacksKeyReleased(evt);
            }
        });
        jPanel1.add(Snacks);
        Snacks.setBounds(40, 160, 150, 40);

        ZAS.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ZAS.setForeground(new java.awt.Color(255, 255, 255));
        ZAS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ZAS.setText("ZAS RESTAURENT BILLING MENU");
        ZAS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel1.add(ZAS);
        ZAS.setBounds(370, 0, 510, 50);

        Menus.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Menus.setForeground(new java.awt.Color(255, 255, 255));
        Menus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menus.setText("Menus");
        Menus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel1.add(Menus);
        Menus.setBounds(170, 90, 220, 50);

        Drinks.setBackground(new java.awt.Color(0, 51, 51));
        Drinks.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Drinks.setForeground(new java.awt.Color(204, 255, 255));
        Drinks.setText("Drinks");
        Drinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrinksActionPerformed(evt);
            }
        });
        Drinks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DrinksKeyPressed(evt);
            }
        });
        jPanel1.add(Drinks);
        Drinks.setBounds(200, 160, 150, 40);

        Lunch.setBackground(new java.awt.Color(0, 0, 255));
        Lunch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Lunch.setForeground(new java.awt.Color(204, 255, 255));
        Lunch.setText("Lunch");
        Lunch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LunchActionPerformed(evt);
            }
        });
        Lunch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LunchKeyPressed(evt);
            }
        });
        jPanel1.add(Lunch);
        Lunch.setBounds(370, 160, 150, 40);

        Print.setBackground(new java.awt.Color(255, 0, 0));
        Print.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        Print.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrintKeyPressed(evt);
            }
        });
        jPanel1.add(Print);
        Print.setBounds(1035, 580, 80, 27);

        dtt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dtt.setForeground(new java.awt.Color(255, 255, 255));
        dtt.setText("Date:");
        jPanel1.add(dtt);
        dtt.setBounds(10, 40, 70, 20);

        code.setEditable(false);
        code.setBackground(new java.awt.Color(0, 0, 0));
        code.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        code.setForeground(new java.awt.Color(255, 255, 255));
        code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });
        jPanel1.add(code);
        code.setBounds(750, 120, 120, 30);

        Name.setEditable(false);
        Name.setBackground(new java.awt.Color(0, 0, 0));
        Name.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(Name);
        Name.setBounds(930, 120, 200, 30);

        tt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tt.setForeground(new java.awt.Color(255, 255, 255));
        tt.setText("Time:");
        jPanel1.add(tt);
        tt.setBounds(10, 7, 40, 30);

        ITEM_CODE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ITEM_CODE.setForeground(new java.awt.Color(255, 255, 255));
        ITEM_CODE.setText("Item Code:");
        jPanel1.add(ITEM_CODE);
        ITEM_CODE.setBounds(690, 120, 60, 30);

        ITEM_PRICE.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ITEM_PRICE.setForeground(new java.awt.Color(255, 255, 255));
        ITEM_PRICE.setText("Item Price:");
        jPanel1.add(ITEM_PRICE);
        ITEM_PRICE.setBounds(690, 160, 60, 30);

        price.setEditable(false);
        price.setBackground(new java.awt.Color(0, 0, 0));
        price.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        price.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(price);
        price.setBounds(750, 160, 120, 30);

        t.setEditable(false);
        t.setBackground(new java.awt.Color(0, 0, 0));
        t.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        t.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(t);
        t.setBounds(50, 10, 150, 20);

        d.setEditable(false);
        d.setBackground(new java.awt.Color(0, 0, 0));
        d.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        d.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(d);
        d.setBounds(50, 40, 150, 20);

        Clear.setBackground(new java.awt.Color(255, 0, 0));
        Clear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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
        Clear.setBounds(750, 580, 100, 27);

        ITEM_QTY.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ITEM_QTY.setForeground(new java.awt.Color(255, 255, 255));
        ITEM_QTY.setText("Item Qty:");
        jPanel1.add(ITEM_QTY);
        ITEM_QTY.setBounds(870, 170, 70, 14);

        ITEM_NAME.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ITEM_NAME.setForeground(new java.awt.Color(255, 255, 255));
        ITEM_NAME.setText("Item Name:");
        jPanel1.add(ITEM_NAME);
        ITEM_NAME.setBounds(870, 120, 70, 30);

        Vat.setBackground(new java.awt.Color(255, 255, 255));
        Vat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Vat.setForeground(new java.awt.Color(0, 0, 0));
        Vat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                VatFocusLost(evt);
            }
        });
        Vat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VatActionPerformed(evt);
            }
        });
        jPanel1.add(Vat);
        Vat.setBounds(1030, 160, 60, 30);

        VAT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        VAT.setForeground(new java.awt.Color(255, 255, 255));
        VAT.setText("Vat:");
        jPanel1.add(VAT);
        VAT.setBounds(1000, 170, 40, 20);

        LogOut.setBackground(new java.awt.Color(204, 51, 0));
        LogOut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        LogOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LogOutKeyPressed(evt);
            }
        });
        jPanel1.add(LogOut);
        LogOut.setBounds(990, 10, 120, 27);

        Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        Add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddKeyPressed(evt);
            }
        });
        jPanel1.add(Add);
        Add.setBounds(1110, 160, 64, 27);

        Qty.setBackground(new java.awt.Color(255, 255, 255));
        Qty.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Qty.setForeground(new java.awt.Color(0, 0, 0));
        Qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(Qty);
        Qty.setBounds(930, 160, 60, 30);

        ShowBill.setEditable(false);
        ShowBill.setColumns(20);
        ShowBill.setRows(5);
        jScrollPane2.setViewportView(ShowBill);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(740, 210, 400, 320);

        itemTable.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        itemTable.setForeground(new java.awt.Color(0, 0, 0));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Id", "Item Name", "Item Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemTable.setRowHeight(18);
        itemTable.setRowMargin(4);
        itemTable.setShowVerticalLines(false);
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);
        if (itemTable.getColumnModel().getColumnCount() > 0) {
            itemTable.getColumnModel().getColumn(0).setResizable(false);
            itemTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 220, 570, 480);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/6.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 800);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrinksActionPerformed
       try{
        try {
            model.setRowCount(0);
        } catch (Exception e) {
            
        }
        display1();}
       catch(Exception e)
       {
           System.out.println("Exception for Drinks Button");
       }
    }//GEN-LAST:event_DrinksActionPerformed

    private void SnacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SnacksActionPerformed
       try{
        try {
            model.setRowCount(0);
        } catch (Exception e) {
            
        }
        display();}
       catch(Exception e)
       {
           System.out.println("Exception for Snacks Button");
       }
    }//GEN-LAST:event_SnacksActionPerformed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        model = (DefaultTableModel) itemTable.getModel();
        int selectedRowIndex = itemTable.getSelectedRow();
        code.setText(model.getValueAt(selectedRowIndex, 0).toString());
        Name.setText(model.getValueAt(selectedRowIndex, 1).toString());
        price.setText(model.getValueAt(selectedRowIndex, 2).toString());

    }//GEN-LAST:event_itemTableMouseClicked

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed

    }//GEN-LAST:event_codeActionPerformed

    private void VatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VatActionPerformed

    }//GEN-LAST:event_VatActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
       try{
        add_textarea();}
       catch(Exception e)
       {
           System.out.println("Exception for Add button");
       }
    }//GEN-LAST:event_AddActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try{
        printing();}
        catch (Exception e)
        {
            System.out.println("Exception for print key");
        
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void VatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VatFocusLost

    }//GEN-LAST:event_VatFocusLost

    private void SnacksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SnacksKeyPressed
        try{
        try {
            model.setRowCount(0);
        } catch (Exception e) {
            
        }
        display();}
       catch(Exception e)
       {
           System.out.println("Exception for Snacks Button");
       }
    }//GEN-LAST:event_SnacksKeyPressed

    private void DrinksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DrinksKeyPressed

        try{
        try {
            model.setRowCount(0);
        } catch (Exception e) {
            
        }
        display1();}
       catch(Exception e)
       {
           System.out.println("Exception for Drinks Button");
       }
    }//GEN-LAST:event_DrinksKeyPressed

    private void AddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddKeyPressed
      try{
          if(evt.getKeyChar()=='\n')
        add_textarea();
      }
      catch(Exception e)
      {
          System.out.println("Exception for Add button");
      }
    }//GEN-LAST:event_AddKeyPressed

    private void PrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrintKeyPressed
        try{if(evt.getKeyChar()=='\n')
{
        printing();}}
        catch(Exception e)
        {
            System.out.println("Exception for print button");
        }
    }//GEN-LAST:event_PrintKeyPressed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    private void LogOutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LogOutKeyPressed
        try{
        if(evt.getKeyChar()=='\n'){
        new Management().setVisible(true);
        this.dispose();}}
        catch(Exception e)
        {
            System.out.println("Exception for log out");
        }
    }//GEN-LAST:event_LogOutKeyPressed

    private void LunchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LunchActionPerformed
        try{
        try {
            model.setRowCount(0);
        } catch (Exception e) {
            
        }
        display2();}
       catch(Exception e)
       {
           System.out.println("Exception for lunch Button");
       }
    }//GEN-LAST:event_LunchActionPerformed

    private void LunchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LunchKeyPressed
        try{
        try {
            model.setRowCount(0);
        } catch (Exception e) {
            
        }
        display2();}
       catch(Exception e)
       {
           System.out.println("Exception for lunch Button");
       }
    }//GEN-LAST:event_LunchKeyPressed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        ShowBill.setText(null);
        code.setText(null);
        Name.setText(null);
        price.setText(null);
        Qty.setText(null);
        Vat.setText(null);
        add();
    }//GEN-LAST:event_ClearActionPerformed

    private void ClearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClearKeyPressed
      try{
        if(evt.getKeyChar()=='\n')
       {
       ShowBill.setText(null);
        code.setText(null);
        Name.setText(null);
        price.setText(null);
        Qty.setText(null);
        Vat.setText(null);
        add();
       }}
      catch(Exception e)
      {
          System.out.println("Exception for clear button");
      }
    }//GEN-LAST:event_ClearKeyPressed

    private void SnacksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SnacksKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_SnacksKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Drinks;
    private javax.swing.JLabel ITEM_CODE;
    private javax.swing.JLabel ITEM_NAME;
    private javax.swing.JLabel ITEM_PRICE;
    private javax.swing.JLabel ITEM_QTY;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton Lunch;
    private javax.swing.JLabel Menus;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Print;
    private javax.swing.JTextField Qty;
    private javax.swing.JTextArea ShowBill;
    private javax.swing.JButton Snacks;
    private javax.swing.JLabel VAT;
    private javax.swing.JTextField Vat;
    private javax.swing.JLabel ZAS;
    private javax.swing.JTextField code;
    private javax.swing.JTextField d;
    private javax.swing.JLabel dtt;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField price;
    private javax.swing.JTextField t;
    private javax.swing.JLabel tt;
    // End of variables declaration//GEN-END:variables

}
