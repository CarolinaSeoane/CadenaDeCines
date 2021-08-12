package Security.Plan;

import Business.Comentario;
import Business.Pelicula;

public class Premium implements Plan {

    private int descuento = 20;

    @Override
    public void publicarComentario(String nombreusuario, String descripcion, int calificacion, Pelicula pelicula) {
        Comentario com = new Comentario(nombreusuario, descripcion, calificacion);
        pelicula.addComentario(com);
    }

    @Override
    public int getDescuento() {
        return descuento;
    }

}
