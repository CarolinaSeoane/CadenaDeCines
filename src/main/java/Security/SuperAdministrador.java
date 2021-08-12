package Security;

import Business.Persona;

public class SuperAdministrador extends Usuario {

    public SuperAdministrador(String nombreUsuario, String contraseña, Persona persona) {
        super(nombreUsuario, contraseña, persona);
    }

}
