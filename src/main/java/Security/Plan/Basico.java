package Security.Plan;

import Business.Pelicula;

public class Basico implements Plan {

    private int descuento = 0;

    @Override
    public void publicarComentario(String nombreusuario, String descripcion, int calificacion, Pelicula pelicula) {
        // System.out.print("Para publicar un comentario debe tener un plan Premium");
    }

    @Override
    public int getDescuento() {
        return descuento;
    }

}
