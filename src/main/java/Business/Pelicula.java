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
    private List<Genero> generos;
    private Boolean ATP;
    private List<Comentario> comentarios;

    public Boolean esDeGenero(Genero unGenero) {
        return this.generos.contains(unGenero);
    }

    public Boolean duraMenosDe(int unosMinutos){ return this.duracion < unosMinutos; }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

}
