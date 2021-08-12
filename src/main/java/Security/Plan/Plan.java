package Security.Plan;

import Business.Pelicula;

public interface Plan {

    void publicarComentario(String nombreusuario, String descripcion, int calificacion, Pelicula pelicula);

    int getDescuento();

}
