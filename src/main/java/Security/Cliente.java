package Security;

import Business.*;
import Security.Plan.Plan;
import java.util.List;

public class Cliente extends Usuario {

    private Plan plan;
    private List<Reserva> reservas;
    private List<Cine> suscripciones;

    public int getDescuento() {
        return plan.getDescuento();
    }

    public List<Reserva> getReservas() {
        return this.reservas;
    }

    public void guardarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void publicarComentario(Comentario comentario, Pelicula pelicula) {
        plan.publicarComentario(comentario, pelicula);
    }

    public void suscribirseA(Cine unCine) {
        suscripciones.add(unCine);
        unCine.suscribir(this.persona.getEmail());
    }

    public void desuscribirseDe(Cine unCine) {
        suscripciones.remove(unCine);
        unCine.desuscribir(this.persona.getEmail());
    }

    public Cliente(String nombreUsuario, String contraseña, Persona persona, Plan plan, List<Reserva> reservas, List<Cine> suscripciones) {
        super(nombreUsuario, contraseña, persona);
        this.plan = plan;
        this.reservas = reservas;
        this.suscripciones = suscripciones;
    }

}
