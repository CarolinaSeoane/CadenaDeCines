package Security.Plan;

import Business.Comentario;
import Business.Pelicula;

public class Basico implements Plan {

    private int descuento = 0;

    @Override
    public void publicarComentario(Comentario comentario, Pelicula pelicula) {
        // System.out.print("Para publicar un comentario debe tener un plan Premium");
    }

    @Override
    public int getDescuento() {
        return descuento;
    }

}
