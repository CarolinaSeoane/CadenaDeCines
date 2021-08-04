package Business;

import Business.SusbcribersObserver.Notificador;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.*;

@Data
@AllArgsConstructor
public class AsignadorDeHorarios {

    //private Notificador notificador;
    private List<Pelicula> peliculas;

    public Map<Sala, List<Funcion>> asignarHorarios(Map<Sala, List<Funcion>> funciones) {
       int cantSalasDisponibles = funciones.size();
       DateTime fechaInicio = this.crearFechaDeInicio();
       DateTime fechaFinal = this.crearFechaFinal(fechaInicio);
       List<DateTime> contadores = new ArrayList<>();
       for(int i=0; i<cantSalasDisponibles; i++){
           DateTime aux = this.crearFechaDeInicio();
           contadores.add(aux);
       }
       List<Sala> salas = new ArrayList<>(funciones.keySet());
       int contadorSala = 0;
       int contadorPelicula = 0;
       int contadorFecha    = 0; // Este me dice en cual de todas las fechas estoy
       while(!this.todosLosContadoresEstanCompletos(contadores, fechaFinal)) {
           Funcion funcion = this.crearFuncion(peliculas.get(contadorPelicula), contadores.get(contadorFecha), salas.get(contadorSala));
           List<Funcion> funcionesDeUnaSala = funciones.get(salas.get(contadorSala));
           funcionesDeUnaSala.add(funcion);
           contadorSala = this.actualizarContadorSala(contadorSala, salas);
           contadorFecha = this.actualizarContadorFecha(contadorPelicula, peliculas, contadores, contadorFecha, fechaInicio);
           contadorPelicula = this.actualizarContadorPelicula(contadorPelicula, peliculas);
       }

       return funciones;
       //notificador.notificar();
    }

    public Boolean todosLosContadoresEstanCompletos(List<DateTime> contadores, DateTime fechaFinal){
        return contadores.stream().allMatch(unContador -> llegoAlLimite(unContador, fechaFinal));
    }

    private boolean llegoAlLimite(DateTime unContador, DateTime fechaFinal) {
        return (unContador.getDayOfWeek() == fechaFinal.getDayOfWeek()) && (unContador.getHourOfDay() == fechaFinal.getHourOfDay());
    }


    public DateTime crearFechaDeInicio(){
        DateTime fechaDeHoy = new DateTime();
        return fechaDeHoy.withHourOfDay(10); // Asumiendo que el scheduler activa la planificacion el jueves mismo
    }

    public DateTime crearFechaFinal(DateTime fechaDeInicio){
        //Sabemos que empieza el jueves 10 am y termina el otro jueves 10 am. Son +7 días pero pongo uno para q se pueda probar
        DateTime aux = fechaDeInicio.plusDays(1);
        return aux;
    }

    public void recibirPeliculas(List<Pelicula> pelis) {
        this.peliculas.addAll(pelis);
    }

    public Funcion crearFuncion(Pelicula p, DateTime f, Sala s) {
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

    //En estos tres metodos repito logica porque reciben listas de diferentes cosas. Se puede mejorar
    private int actualizarContadorSala(int contadorActual, List<Sala> salas) {
        int nuevoContador;
        if(contadorActual == salas.size() - 1){
            nuevoContador = 0;
        }else{
            nuevoContador = contadorActual + 1;
        }
        return nuevoContador;
    }

    public int actualizarContadorPelicula(int contadorActual, List<Pelicula> peliculas){
        int nuevoContador;
        if(contadorActual == peliculas.size() - 1){
            nuevoContador = 0;
        }else{
            nuevoContador = contadorActual + 1;
        }
        return nuevoContador;
    }

    public int actualizarContadorFecha(int contadorPelicula, List<Pelicula> peliculas, List<DateTime> contadores, int contadorFecha, DateTime fechaDeInicio){
        // TODO: Mejorar / Separar esto
        // Parte 1: Actualizo el horario de la sala que use
        int duracionLimpiezaDeSala = 30; // Minutos
        int duracionDeLaPelicula = peliculas.get(contadorPelicula).getDuracion();
        DateTime nuevo = contadores.get(contadorFecha).plusMinutes(duracionDeLaPelicula + duracionLimpiezaDeSala);
        contadores.add(contadorFecha, nuevo);
        contadores.remove(contadorFecha + 1);
        if(contadores.get(contadorFecha).getHourOfDay() >= 21 || contadores.get(contadorFecha).getHourOfDay()<=5){
            DateTime ultimo = this.crearFechaFinal(fechaDeInicio);; // Lo mando a la fecha que se que termino
            contadores.add(contadorFecha, ultimo);
            contadores.remove(contadorFecha + 1);
        }

        // Parte 2: Actualizo el indice para pasar a otra sala
        int nuevoContador;
        if(contadorFecha == contadores.size() - 1){
            nuevoContador = 0;
        }else{
            nuevoContador = contadorFecha + 1;
        }
        return nuevoContador;
    }

}
