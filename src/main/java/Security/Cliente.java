package Security;

import Business.Pelicula;
import Business.Persona;
import Business.Reserva;
import Security.Plan.Plan;
import java.util.List;

public class Cliente extends Usuario {

    private List<Reserva> reservas;
    private Plan plan;

    public int getDescuento() {
        return plan.getDescuento();
    }

    public List<Reserva> getReservas() {
        return this.reservas;
    }

    public void guardarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void publicarComentario(String descripcion, int calificacion, Pelicula pelicula) {
        plan.publicarComentario(this.nombreUsuario, descripcion, calificacion, pelicula);
    }

    public Cliente(String nombreUsuario, String contraseña, Persona persona, List<Reserva> reservas, Plan plan) {
        super(nombreUsuario, contraseña, persona);
        this.reservas = reservas;
        this.plan = plan;
    }

}
