package Security.Plan;

import Business.Comentario;
import Business.Pelicula;

public class Premium implements Plan {

    private int descuento = 20;

    @Override
    public void publicarComentario(Comentario comentario, Pelicula pelicula) {
        pelicula.addComentario(comentario);
    }

    @Override
    public int getDescuento() {
        return descuento;
    }

}
