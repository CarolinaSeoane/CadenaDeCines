package Repository;

import java.sql.*;

public class DBConnection {

    Connection conn = null;

    public DBConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/?" + "user=root");
            Statement s = conn.createStatement();
            int Result = s.executeUpdate("CREATE DATABASE IF NOT EXISTS Cadena_De_Cines");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Cadena_De_Cines?" + "user=root");
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


