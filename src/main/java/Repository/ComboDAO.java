package Repository;

import Business.Composite.Combo;

import java.sql.SQLException;
import java.sql.Statement;

public class ComboDAO {

    public void INSERTCombo(Combo combo){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO Combo (id_cadena, id_comboPadre, nombre, precio) VALUES ("
                    + "'" + "1" + "'" + ", "
                    + null + ", "
                    + "'" + combo.getNombre() + "'"
                    + ", " + combo.getPrecio()
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
