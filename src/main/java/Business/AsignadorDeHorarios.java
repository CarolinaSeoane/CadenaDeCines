package Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;
import java.util.*;

@Data
@AllArgsConstructor
public class AsignadorDeHorarios {

    private List<Pelicula> peliculas;

    public void asignarHorarios(Map<Sala, List<Funcion>> funciones) {
       List<Sala> salas = new ArrayList<>(funciones.keySet());
       DateTime fechaFinal = this.crearFechaFinal();
       List<DateTime> contadores = new ArrayList<>();
       for(int i=0; i<salas.size(); i++){
           contadores.add(this.crearFechaDeInicio());
       }
       int contadorSala = 0;
       int contadorPelicula = 0;
       int contadorFecha    = 0; // Este me dice en cual de todas las fechas estoy
       while(!this.todosLosContadoresEstanCompletos(contadores, fechaFinal)) {
           if(!this.unContadorLlegoAlLimite(contadores.get(contadorFecha), fechaFinal)) {
               Funcion funcion = this.crearFuncion(peliculas.get(contadorPelicula), contadores.get(contadorFecha), salas.get(contadorSala));
               List<Funcion> funcionesDeUnaSala = funciones.get(salas.get(contadorSala));
               funcionesDeUnaSala.add(funcion);
               this.actualizarHorario(contadorPelicula, contadores, contadorFecha);
               contadorPelicula = this.actualizarContador(contadorPelicula, peliculas.size());
           }
           contadorSala = this.actualizarContador(contadorSala, salas.size());
           contadorFecha = this.actualizarContador(contadorFecha, contadores.size());
       }
    }

    private Boolean todosLosContadoresEstanCompletos(List<DateTime> contadores, DateTime fechaFinal) {
        return contadores.stream().allMatch(unContador -> unContadorLlegoAlLimite(unContador, fechaFinal));
    }

    private Boolean unContadorLlegoAlLimite(DateTime unContador, DateTime fechaFinal) {
        return (unContador.getDayOfWeek() == fechaFinal.getDayOfWeek()) && (unContador.getHourOfDay() == fechaFinal.getHourOfDay());
    }

    private DateTime crearFechaDeInicio() {
        DateTime fechaDeHoy = new DateTime();
        int diaDeLaSemana = fechaDeHoy.getDayOfWeek();
        int diasParaElProximoJueves = this.cuantoFaltaParaElProximoJueves(diaDeLaSemana);
        return new DateTime(fechaDeHoy.getYear(), fechaDeHoy.getMonthOfYear(), fechaDeHoy.getDayOfMonth() + diasParaElProximoJueves, 10, 0);
    }

    private int cuantoFaltaParaElProximoJueves(int diaDeLaSemana) {
        // 1 es Lunes. 7 es Domingo (Viene de la documentacion de Joda-Time)
        if(diaDeLaSemana <= 4) {
            return 4 - diaDeLaSemana;
        } else {
            return 11 - diaDeLaSemana;
        }
    }

    public DateTime crearFechaFinal() {
        //Sabemos que empieza el jueves 10 am y termina el otro jueves 10 am.
        //Son +7 días pero pongo 1 para hacer los Tests. Podria ser una variable del asignador
        return this.crearFechaDeInicio().plusDays(1);
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
        asientos.forEach(asiento -> disponibilidad.put(asiento, true));
        return disponibilidad;
    }

    private int actualizarContador(int contadorActual, int tamanioLista) {
        int nuevoContador;
        if(contadorActual == (tamanioLista - 1)) {
            nuevoContador = 0;
        } else {
            nuevoContador = contadorActual + 1;
        }
        return nuevoContador;
    }

    private void actualizarHorario(int contadorPelicula, List<DateTime> contadores, int contadorFecha) {
        int duracionLimpiezaDeSala = 30;
        int duracionDeLaPelicula = peliculas.get(contadorPelicula).getDuracion();
        DateTime nuevo = contadores.get(contadorFecha).plusMinutes(duracionDeLaPelicula + duracionLimpiezaDeSala);
        if(nuevo.getHourOfDay() >= 23 || nuevo.getHourOfDay() <= 5) {
            nuevo = this.llevarloAlSiguienteDia(contadores.get(contadorFecha)); // Lo mando al siguiente día

        }
        contadores.add(contadorFecha, nuevo);
        contadores.remove(contadorFecha + 1);
    }

    private DateTime llevarloAlSiguienteDia(DateTime fechaActual) {
        if(fechaActual.getHourOfDay() < 12) {
            return fechaActual.withHourOfDay(10).withMinuteOfHour(0).withSecondOfMinute(0);
        } else {
            return fechaActual.plusDays(1).withHourOfDay(10).withMinuteOfHour(0).withSecondOfMinute(0);
        }
    }

}
