package Business;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comentario {

    private String nombreUsuario;
    private String descripcion;
    private int calificacion;

}
