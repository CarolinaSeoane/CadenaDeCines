package Repository;

import java.sql.*;

public class DBConnection {

    Connection conn = null;

    public DBConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/CadenaDeCines?" + "user=root");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public void desconectar(){
        conn = null;
    }

}


