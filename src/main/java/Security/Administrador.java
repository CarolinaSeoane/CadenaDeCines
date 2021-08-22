package Security;

import Business.Cine;
import Business.Persona;

public class Administrador extends Usuario {

    private Cine cine;

    public Administrador(String nombreUsuario, String contraseña, Persona persona, Cine cine) {
        super(nombreUsuario, contraseña, persona);
        this.cine = cine;
    }

    public Cine getCine() {
        return cine;
    }

}
