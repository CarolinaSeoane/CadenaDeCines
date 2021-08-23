package Repository;

import Business.Cine;
import Security.Administrador;

import java.sql.SQLException;
import java.sql.Statement;

public class CineDAO {

    public void INSERTCine(Cine cine){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO Cine (id_cadena, nombre, direccion) VALUES ("
                    + "'" + "1" + "'"
                    + ", "
                    + "'" + cine.getNombre() + "'"
                    + ", "
                    + "'" + cine.getDireccion() + "'"
                    + ")";

            stmt.execute(insertQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
    }

}
