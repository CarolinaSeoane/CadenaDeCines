package Business;

import Business.Enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pelicula {

    private String titulo;
    private String descripcion;
    private String actores;
    private String director;
    private int duracion;
    private List<Genero> generos;
    private Boolean ATP;
    private List<Comentario> comentarios;

}
