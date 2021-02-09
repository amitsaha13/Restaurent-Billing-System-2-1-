package restaurent.billing.system;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {

    String code;
    String name;
    double price;
    String qnt;
    String vat;
    double total;

    public InventoryManagement() {

    }
//this is a constructor for arraylist
    public InventoryManagement(String a, String b, double c, String d, String e, double f) {
        code = a;
        name = b;
        price = c;
        qnt = d;
        vat = e;
        total = f;
    }

    ArrayList<InventoryManagement> read(String date, ArrayList<InventoryManagement> al) {
        String address = "D://project//" + date + ".txt";
        Scanner sc = null;
        try{
            sc = new Scanner (new FileReader(address));
            while (sc.hasNext()){
                al.add(new InventoryManagement(sc.next(), sc.next(),Double.parseDouble(sc.next()),sc.next(),sc.next(),Double.parseDouble(sc.next())));
            }
        }
        catch(Exception ex){
            return al;
        }
        return al;
    }


    void write(String date, ArrayList<InventoryManagement> al) throws IOException {
        String address = "D://project//" + date + ".txt";
        FileWriter f = null;
        DataOutputStream ds = null;
        DataInputStream di = null;
        String str = "";

        try {
            di = new DataInputStream(new FileInputStream(address));
            String a;
            while ((a = di.readLine())!= null) {
                str += a;
                str += " ";
            }
        } catch (Exception x) {

        }

        try {
            //f = new FileWriter(address);
            ds = new DataOutputStream(new FileOutputStream(address));
            
            ds.writeBytes(str);
            for (int i = 0; i < al.size(); i++) {
                ds.writeBytes(al.get(i).code + " ");
                ds.writeBytes(al.get(i).name + " ");
                ds.writeBytes(al.get(i).price + " ");
                ds.writeBytes(al.get(i).qnt + " ");
                ds.writeBytes(al.get(i).vat + " ");
                ds.writeBytes(Double.toString(al.get(i).total));
                ds.writeBytes(" ");
            }

        } catch (Exception x) {
            System.out.println("Exception");
        }
        ds.close();
    }

    public static void main(String[] args) {

    }

}
