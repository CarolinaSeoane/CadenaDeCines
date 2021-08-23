package Security;

import Business.Persona;

public abstract class Usuario {

    protected String nombreUsuario;
    protected String contraseña;
    protected Persona persona;

    public Usuario(String nombreUsuario, String contraseña, Persona persona) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.persona = persona;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public String getContraseña() {return  this.contraseña;}

}
