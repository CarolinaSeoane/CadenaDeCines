package Security;

import Business.Persona;

public class Administrador extends Usuario {

    public Administrador(String nombreUsuario, String contraseña, Persona persona) {
        super(nombreUsuario, contraseña, persona);
    }

}
