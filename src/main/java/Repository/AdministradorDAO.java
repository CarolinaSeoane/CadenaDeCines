package Repository;

import Business.Enums.TipoDoc;
import Business.Persona;
import Security.Administrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministradorDAO {

    public void INSERTAdmin(Administrador admin){
        DBConnection conn = new DBConnection();
        Statement stmt = null;

        try {
            stmt = conn.getConnection().createStatement();

            String insertQuery = "INSERT INTO Admin (id_cine, nombre, apellido, tipoDoc, nroDoc, email, nombreUsuario, contrasenia) VALUES ("
                    + "(SELECT id_cine from Cine WHERE nombre = '" + admin.getCine().getNombre() + "'), "
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

    // Decidi que la busqueda sea por nombreUsuario porque es el dato que uno pone para el log in pero podria ser otro
 /*   public Administrador SELECTAdmin(String nombreUsuario) {
        DBConnection conn = new DBConnection();
        Statement stmt = null;
        Administrador admin = null;
        try {
            stmt = conn.getConnection().createStatement();

            String selectQuery = "SELECT * FROM Admin WHERE nombreUsuario = '" + nombreUsuario + "'";

            ResultSet rs = stmt.executeQuery(selectQuery);
            if(rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                TipoDoc tipoDoc = TipoDoc.valueOf(rs.getString("tipoDoc"));
                int nroDoc = rs.getInt("nroDoc");
                String email = rs.getString("email");
                String contrasenia = rs.getString("contrasenia");
                String cine = rs.getString("cine");

                Persona adminPersona = new Persona(nombre, apellido, tipoDoc, nroDoc, email);
                admin = new Administrador(nombreUsuario, contrasenia, adminPersona, admin.getCine());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try { stmt.close(); } catch (Exception e) { }
            try { conn.desconectar(); } catch (Exception e) { }
        }
        return admin;
    }*/

}
