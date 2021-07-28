package Security;

import Business.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {

    private String nombreUsuario;
    private String contraseña;
    private Persona persona;
    private Rol rol;

}
