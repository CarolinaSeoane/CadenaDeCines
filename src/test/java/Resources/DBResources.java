package Resources;

import Business.Cadena;
import Repository.*;

import java.sql.SQLException;
import java.sql.Statement;

public class DBResources extends TestResources {

    protected DBConnection conn;

    //DAOs
    protected CineDAO cineDAO;
    protected PlanDAO planDAO;
    protected ProductoDAO productoDAO;
    protected ComboDAO comboDAO;
    protected SalaDAO salaDAO;
    protected ComboXProductoDAO comboXProductoDAO;
    protected AsientoDAO asientoDAO;
    protected AdministradorDAO adminDAO;
    protected SuperAdminDAO superAdminDAO;

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
                + " id_cadena enum('1'),"
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

        this.inicializarAdministradores();
        adminDAO = new AdministradorDAO();
        adminDAO.INSERTAdmin(adminCaro);
    }

    public void createSuperAdmin() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS SuperAdmin"
                + " (id_superAdmin int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cadena enum('1'),"
                + " nombre varchar(50),"
                + " apellido varchar(50),"
                + " tipoDoc varchar(50),"
                + " nroDoc int,"
                + " email varchar(50),"
                + " nombreUsuario varchar(50),"
                + " contrasenia varchar(50),"
                + " FOREIGN KEY (id_cadena) REFERENCES Cadena(id_cadena))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        this.inicializarSuperAdmins();
        superAdminDAO = new SuperAdminDAO();
        superAdminDAO.INSERTSuperAdmin(superAdminPedro);

    }

    public void createPlan() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Plan"
                + " (id_plan int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " nombre varchar(50),"
                + " descuento int)";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        planDAO = new PlanDAO();
        planDAO.INSERTPlan("BASICO", 0);
        planDAO.INSERTPlan("PREMIUM", 20);
    }

    public void createCliente() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Cliente"
                + " (id_cliente int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cadena enum('1'),"
                + " id_plan int,"
                + " nombre varchar(50),"
                + " apellido varchar(50),"
                + " tipoDoc varchar(50),"
                + " nroDoc int,"
                + " email varchar(50),"
                + " nombreUsuario varchar(50),"
                + " contrasenia varchar(50),"
                + " FOREIGN KEY (id_cadena) REFERENCES Cadena(id_cadena),"
                + " FOREIGN KEY (id_plan) REFERENCES Plan(id_plan))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

    }

    public void createProducto() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Producto"
                + " (id_producto int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cadena enum('1'),"
                + " precio int,"
                + " nombre varchar(50),"
                + " tamanio varchar(50),"
                + " FOREIGN KEY (id_cadena) REFERENCES Cadena(id_cadena))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        this.inicializarProductos();
        productoDAO = new ProductoDAO();
        productoDAO.INSERTProducto(pochocloChico);
        productoDAO.INSERTProducto(pochocloGrande);
        productoDAO.INSERTProducto(nachosMedianos);
        productoDAO.INSERTProducto(gaseosaGrande);

    }

    public void createCombo() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Combo"
                + " (id_combo int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cadena enum('1'),"
                + " id_comboPadre int,"
                + " nombre varchar(50),"
                + " precio int,"
                + " FOREIGN KEY (id_cadena) REFERENCES Cadena(id_cadena),"
                + " FOREIGN KEY (id_comboPadre) REFERENCES Combo(id_combo))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        comboDAO = new ComboDAO();
        comboDAO.INSERTCombo(combo1);
        comboDAO.INSERTCombo(combo2);
        comboDAO.INSERTCombo(combo3);

    }

    public void createProductoXCombo() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS ProductoXCombo"
                + " (id_prodCombo int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_combo int,"
                + " id_producto int,"
                + " FOREIGN KEY (id_combo) REFERENCES Combo(id_combo),"
                + " FOREIGN KEY (id_producto) REFERENCES Producto(id_producto))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        comboXProductoDAO = new ComboXProductoDAO();
        comboXProductoDAO.INSERTComboXProducto(combo1, pochocloGrande);
        comboXProductoDAO.INSERTComboXProducto(combo1, gaseosaGrande);
        comboXProductoDAO.INSERTComboXProducto(combo2, pochocloChico);
        comboXProductoDAO.INSERTComboXProducto(combo2, nachosMedianos);
        comboXProductoDAO.INSERTComboXProducto(combo2, gaseosaGrande);
        comboXProductoDAO.INSERTComboXProducto(combo3, pochocloGrande);
        comboXProductoDAO.INSERTComboXProducto(combo3, gaseosaGrande);
        comboXProductoDAO.INSERTComboXProducto(combo3, gaseosaGrande);

    }

    public void createSala() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Sala"
                + " (id_sala int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cine int,"
                + " nombre varchar(50),"
                + " FOREIGN KEY (id_cine) REFERENCES Cine(id_cine))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        this.inicializarSalas();
        salaDAO = new SalaDAO();
        salaDAO.INSERTSala(salaA1, cineA);
        salaDAO.INSERTSala(salaA2, cineA);
        salaDAO.INSERTSala(salaA3, cineA);
        salaDAO.INSERTSala(salaB1, cineB);
        salaDAO.INSERTSala(salaB2, cineB);
        salaDAO.INSERTSala(salaC1, cineC);

    }

    public void createAsiento() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Asiento"
                + " (id_asiento int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_sala int,"
                + " precio int,"
                + " nroAsiento varchar(50),"
                + " habilitado boolean,"
                + " FOREIGN KEY (id_sala) REFERENCES Sala(id_sala))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

        this.inicializarAsientos();
        asientoDAO = new AsientoDAO();
        asientoDAO.INSERTAsiento(A1_A1, salaA1);
        asientoDAO.INSERTAsiento(A1_A2, salaA1);
        asientoDAO.INSERTAsiento(A2_A1, salaA2);
        asientoDAO.INSERTAsiento(A3_A1, salaA3);
        asientoDAO.INSERTAsiento(A3_A2, salaA3);
        asientoDAO.INSERTAsiento(B1_A1, salaB1);
        asientoDAO.INSERTAsiento(B2_A1, salaB2);
        asientoDAO.INSERTAsiento(B2_A2, salaB2);
        asientoDAO.INSERTAsiento(C1_A1, salaC1);
        asientoDAO.INSERTAsiento(C1_A2, salaC1);

    }

    public void createFuncion() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Funcion"
                + " (id_funcion int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_sala int,"
                + " pelicula varchar(50),"
                + " fecha datetime,"
                + " FOREIGN KEY (id_sala) REFERENCES Sala(id_sala))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

    }

    public void createReserva() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Reserva"
                + " (id_reserva int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_cliente int,"
                + " productos varchar(100),"
                + " costoTotal int,"
                + " codigoDeReserva varchar(50),"
                + " FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente))";

        Statement stmt = conn.getConnection().createStatement();
        stmt.execute(sqlCreate);
        stmt.close();

    }

    public void createDisponibilidad() throws SQLException {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Disponibilidad"
                + " (cod_disp int NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                + " id_asiento int,"
                + " id_funcion int,"
                + " id_reserva int,"
                + " ocupado boolean,"
                + " FOREIGN KEY (id_asiento) REFERENCES Asiento(id_asiento),"
                + " FOREIGN KEY (id_funcion) REFERENCES Funcion(id_funcion),"
                + " FOREIGN KEY (id_reserva) REFERENCES Reserva(id_reserva))";

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
            createSuperAdmin();
            createPlan();
            createCliente();
            createProducto();
            createCombo();
            createProductoXCombo();
            createSala();
            createAsiento();
            createFuncion();
            createReserva();
            createDisponibilidad();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { conn.desconectar(); } catch (Exception e) { }
        }

    }

}
