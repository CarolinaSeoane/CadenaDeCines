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
                + " (id_cadena int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
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

    public void createCine() throws SQLException {

        this.conn = new DBConnection();

        String sqlCreate = "CREATE TABLE IF NOT EXISTS Cine"
                + " (id_cine int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cadena int,"
                + " nombre varchar(50),"
                + " direccion varchar(50),"
                + " FOREIGN KEY (id_cadena) REFERENCES cadena(id_cadena))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);

    }

    public void createAdmin() throws SQLException {

        this.conn = new DBConnection();

        String sqlCreate = "CREATE TABLE IF NOT EXISTS Admin"
                + " (id_admin int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cine int,"
                + " nombre varchar(50),"
                + " apellido varchar(50),"
                + " tipoDoc varchar(50),"
                + " nroDoc int,"
                + " email varchar(50),"
                + " nombreUsuario varchar(50),"
                + " contrasenia varchar(50),"
                + " FOREIGN KEY (id_cine) REFERENCES cine(id_cine))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);

    }

}
