package Resources;

import Business.Cadena;
import Repository.CineDAO;
import Repository.DBConnection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBResources extends TestResources {

    protected DBConnection conn;

    //DAOs
    protected CineDAO cineDAO;

    public void createCadena() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Cadena"
                + " (id_cadena enum('1') NOT NULL PRIMARY KEY, "
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
        stmt.close();
    }

    public void createCine() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Cine"
                + " (id_cine int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cadena int,"
                + " nombre varchar(50),"
                + " direccion varchar(50),"
                + " FOREIGN KEY (id_cadena) REFERENCES Cadena(id_cadena))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        cineDAO = new CineDAO();
        this.inicializarCines();
        cineDAO.INSERTCine(cineA);
        cineDAO.INSERTCine(cineB);
        cineDAO.INSERTCine(cineC);


    }

    public void createAdmin() throws SQLException {
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
                + " FOREIGN KEY (id_cine) REFERENCES Cine(id_cine))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();
    }

    public void createTablas() throws SQLException {
        try {
            this.conn = new DBConnection();
            createCadena();
            createCine();
            createAdmin();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { conn.desconectar(); } catch (Exception e) { }
        }

    }

}
