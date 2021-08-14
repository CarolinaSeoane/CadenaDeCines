package Business;

import Business.Enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Pelicula {

    private String titulo;
    private String actores;
    private String director;
    private int duracion;
    private String generos;
    private Boolean ATP;
    private List<Comentario> comentarios;
    private double imdbRating;


    public Boolean duraMenosDe(int unosMinutos){ return this.duracion < unosMinutos; }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public boolean tieneRatingMayorA(Double unRating) {
        return this.getImdbRating() >= unRating;
    };
}
