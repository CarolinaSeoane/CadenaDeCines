package Resources;

import Business.Cadena;
import Repository.DBConnection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBResources extends TestResources {

    protected DBConnection conn;

    public void createCadena() throws SQLException {

        this.conn = new DBConnection();

        String sqlCreate = "CREATE TABLE IF NOT EXISTS Cadena"
                + " (id_cadena int NOT NULL PRIMARY KEY,"
                + " porcentajeGanancia int,"
                + " descuentoPorCombo int)";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);


        Cadena cadena = inicializarCadena();
        String insert = "INSERT INTO Cadena (porcentajeGanancia, descuentoPorCombo) VALUES ("
                + cadena.getPorcentajeGanancia()
                + ", "
                + cadena.getDescuentoPorCombo()
                + ")";
        stmt.execute(insert);
    }

}
