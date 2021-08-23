package Repository;

import Business.Cine;
import Business.Sala;

import java.sql.SQLException;
import java.sql.Statement;

public class SalaDAO {

    public void INSERTSala(Sala sala, Cine cine){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO Sala (id_cine, nombre) VALUES ("
                                + "(SELECT id_cine FROM Cine WHERE nombre = " + "'" + cine.getNombre() + "'),"
                                + "'" + sala.getNombre() + "')";

            stmt.execute(insertQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
    }
}
