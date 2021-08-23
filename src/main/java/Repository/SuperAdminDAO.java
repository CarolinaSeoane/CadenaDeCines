package Repository;

import Security.Administrador;
import Security.SuperAdministrador;

import java.sql.SQLException;
import java.sql.Statement;

public class SuperAdminDAO {

    public void INSERTSuperAdmin(SuperAdministrador admin){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();

            String insertQuery = "INSERT INTO SuperAdmin (id_cadena, nombre, apellido, tipoDoc, nroDoc, email, nombreUsuario, contrasenia) VALUES ("
                    + "'" + "1" + "',"
                    + "'" + admin.getPersona().getNombre() + "'"
                    + ", "
                    + "'" + admin.getPersona().getApellido() + "'"
                    + ", "
                    + "'" + admin.getPersona().getTipoDoc().toString() + "'"
                    + ", "
                    + admin.getPersona().getNroDoc()
                    + ", "
                    + "'" + admin.getPersona().getEmail() + "'"
                    + ", "
                    + "'" + admin.getNombreUsuario() + "'"
                    + ", "
                    + "'" + admin.getContraseña() + "'"
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
