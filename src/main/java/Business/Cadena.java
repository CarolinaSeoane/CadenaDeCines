package Business;

import Security.Usuario;
import lombok.Data;
import java.util.List;

@Data
public class Cadena {

    private List<Cine> cines;
    private List<Pelicula> peliculas;
    private List<Usuario> usuarios;
    private List<Producto> productos;
    private Planificador planificacionActual;
    private int porcentajeGanancia;

}
