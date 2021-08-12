package Security;

import Business.Pelicula;
import Business.Reserva;
import Security.Plan.Plan;
import java.util.List;

public class Cliente extends Usuario {

    private List<Reserva> reservas;
    private Plan plan;

    public void comprarEntrada() {

    }

    public void publicarComentario(String nombreusuario, String descripcion, int calificacion, Pelicula pelicula) {
        plan.publicarComentario(nombreusuario, descripcion, calificacion, pelicula);
    }

}
