package Business;

import Business.SusbcribersObserver.Notificador;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class AsignadorDeHorarios {

    //private Notificador notificador;
    private List<Pelicula> peliculas;

   /* public void asignarHorarios(){
        //Despues de asignar, avisa que hay nuevas funciones
        notificador.notificar();
    }*/

    public void recibirPeliculas(List<Pelicula> pelis) {
        this.peliculas.addAll(pelis);
    }

    public Funcion crearFuncion(Pelicula p, Date f, Sala s) {
        List<Asiento> a = s.getAsientos();
        Map<Asiento,Boolean> disponibilidad = this.generarDisponibilidad(a);
        return new Funcion(disponibilidad, p, f, s);
    }

    private Map<Asiento,Boolean> generarDisponibilidad(List<Asiento> asientos) {
        Map<Asiento,Boolean> disponibilidad = new HashMap<>();
        asientos.forEach((asiento) -> {
            disponibilidad.put(asiento, true);
        });
        return disponibilidad;
    }

}
