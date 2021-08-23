package Repository;

import Business.Composite.Combo;
import Business.Composite.ProductoSimple;
import Business.Sala;

import java.sql.SQLException;
import java.sql.Statement;

public class ComboXProductoDAO {

    public void INSERTComboXProducto(Combo combo, ProductoSimple producto){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO ProductoXCombo (id_combo, id_producto) VALUES ("
                                + "(SELECT id_combo FROM Combo WHERE nombre = " + "'" + combo.getNombre() + "'), "
                                + "(SELECT id_producto FROM Producto WHERE nombre = " + "'" + producto.getNombre() + "')"
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
