package Repository;

import java.sql.SQLException;
import java.sql.Statement;

public class PlanDAO {

    public void INSERTPlan(String nombrePlan, int descuento){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO Plan (nombre, descuento) VALUES ("
                    + "'" + nombrePlan + "'"
                    + ", " + descuento + ")";

            stmt.execute(insertQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
    }
}
