package Security.Plan;

import Business.Comentario;
import Business.Pelicula;

public interface Plan {

    void publicarComentario(Comentario comentario, Pelicula pelicula);

    int getDescuento();

}
