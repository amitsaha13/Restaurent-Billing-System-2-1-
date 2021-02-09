package restaurent.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

//this clas is defined for the connection of database
public class ConnectDatabase {

    Connection con = null;

    public static Connection ConnectDB() {
        String url = "jdbc:mysql://localhost:3306/project?useSSL=false";
        String user_name = "root";
        String pass = "";
        try {
            //for driver loading
            Class.forName("com.mysql.jdbc.Driver");
            //register the database
            Connection con = DriverManager.getConnection(url, user_name, pass);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can't connect to the database");
            return null;
        }
    }
}