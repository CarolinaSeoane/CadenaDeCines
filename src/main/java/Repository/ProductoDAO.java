package Repository;

import Business.Composite.ProductoSimple;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAO {

    public void INSERTProducto(ProductoSimple producto){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();
            String insertQuery = "INSERT INTO Producto (id_cadena, precio, nombre, tamanio) VALUES ("
                    + "'" + "1" + "'" + ", "
                    + producto.getPrecio() + ", "
                    + "'" + producto.getNombre() + "'"
                    + ", " + "'" + producto.getTamanio().toString() + "'" + ")";

            stmt.execute(insertQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
    }
}
