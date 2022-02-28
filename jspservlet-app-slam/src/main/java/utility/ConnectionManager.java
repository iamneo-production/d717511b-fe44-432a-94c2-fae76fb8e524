package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost/dbname";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "examly";
    
    public static Connection getConnection() {
        
        Connection con = null;

        try {
            Class.forName(CLASS_NAME);
            con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD); 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        
        return con;
    }
}
