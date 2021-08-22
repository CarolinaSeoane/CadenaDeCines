package Repository;

import Business.Cadena;
import java.sql.SQLException;
import java.sql.Statement;

public class CadenaDAO {

    public void UPDATEPorcentajeGanancia(Cadena cadena) {
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String query = "update Cadena set porcentajeGanancia=" + cadena.getPorcentajeGanancia() + " where id_cadena=1"; // agregamos id a cadena?
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
    }

}
