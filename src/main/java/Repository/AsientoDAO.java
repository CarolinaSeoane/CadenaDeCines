package Repository;

import Business.Asiento;
import Business.Sala;

import java.sql.SQLException;
import java.sql.Statement;

public class AsientoDAO {

    public void INSERTAsiento(Asiento asiento, Sala sala){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO Asiento (id_sala, precio, nroAsiento, habilitado) VALUES ("
                    + "(SELECT id_sala FROM Sala WHERE nombre = " + "'" + sala.getNombre() + "'),"
                    + asiento.getPrecio() + ", "
                    + "'" + asiento.getNroAsiento() + "', "
                    + asiento.getHabilitado() + ")";

            stmt.execute(insertQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
    }
}
