import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CreateDB {
    
    public static Connection createConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/";
        String root = "root";
        String password = "Admin123";
        Connection con = DriverManager.getConnection(url, root, password);
        
        return con;
    }
 
    

    public static void main(String[] args) throws Exception {
        Connection con = CreateDB.createConnection();
        
    }
}
