import java.sql.*;
import java.util.Scanner;

import javax.swing.plaf.nimbus.State;

public class App {
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "Admin123";
    String db = "Employee";
    Scanner read = new Scanner(System.in);

    App() {

    }

    public void create_dataBase(String db) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Enter Database Name : ");
            db = read.next();
            String query = "CREATE DATABASE " + db;
            Statement st = con.createStatement();
            st.executeQuery(query);
            System.out.println("Successfully created " + db);
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Unable to create new Databse " + db);
        }
    }

    public void insert_data() {
        try {
            Connection con = DriverManager.getConnection(url + db, username, password);
            String query = "INSERT INTO employee VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Enter ID : ");
            ps.setInt(1, read.nextInt());
            System.out.print("Enter Name : ");
            ps.setString(2, read.next());
            System.out.print("Enter Payment : ");
            ps.setInt(3, read.nextInt());

            if (!ps.execute()) {
                System.out.println("Succesfull");
            } else {
                System.out.println("failed");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Something went wrong while inserting !");
        }
    }

    public void read_data(){
        try {
            Connection con = DriverManager.getConnection(url+db, username, password);
            String query = "Select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                System.out.println("ID : "+ rs.getInt(1));
                System.out.println("Name : "+ rs.getString(2));
                System.out.println("Hourly payment : "+ rs.getInt(3));
            }

            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public static void main(String[] args) {
        App data = new App();

        // data.insert_data();
        data.read_data();
    }
}
