package Business.PlanificationStrategy;

import Business.Pelicula;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

/*
............................. Criterio Infantil .............................

Parámetros a utilizar

--> ¿Tiene Rating Alto?             20 puntos
--> ¿Tiene Rating Medio?            15 puntos
--> ¿Tiene Rating Bajo?             10 puntos
--> ¿Es ATP?                        10 puntos
--> ¿Dura menos de 115 minutos?     5  puntos

 */

@Data
public class EstrategiaInfantil implements PlanificationStrategy {

    int minutosParaQueSeaCortaDuracion = 115;

    // PUNTAJES
    int puntajeRatingAlto       = 20;
    int puntajeRatingMedio      = 15;
    int puntajeRatingBajo       = 10;
    int puntajeATP              = 10;
    int puntajeCortaDuracion    = 5;

    // PUNTAJES PARA CATEGORIA RATING
    double corteRatingAlto  = 8.4;
    double corteRatingMedio = 7.0;

    //PUNTAJES PARA PRIORIDAD
    int cortePrioridadAlta  = 25;
    int cortePrioridadMedia = 15;


    public int determinarPuntaje(Pelicula unaPelicula){
        int puntajeTotal = 0;
        if(unaPelicula.tieneRatingMayorOIgualA(corteRatingAlto)) {
            puntajeTotal += puntajeRatingAlto;
        }else if(unaPelicula.tieneRatingMayorOIgualA(corteRatingMedio)) {
            puntajeTotal += puntajeRatingMedio;
        }else {
            puntajeTotal += puntajeRatingBajo;
        }
        if(unaPelicula.getATP()) {
            puntajeTotal += puntajeATP;
        }
        if(unaPelicula.duraMenosDe(minutosParaQueSeaCortaDuracion)) {
            puntajeTotal += puntajeCortaDuracion;
        }
        return puntajeTotal;
    }

    @Override
    public List<Pelicula> seleccionarPrioridadALTA(List<Pelicula> todasLasPelis) {
        return todasLasPelis.stream().filter((pelicula)->(this.determinarPuntaje(pelicula) > cortePrioridadAlta)).collect(Collectors.toList());
    }

    @Override
    public List<Pelicula> seleccionarPrioridadMEDIA(List<Pelicula> todasLasPelis) {
        return todasLasPelis.stream().filter((pelicula)->((this.determinarPuntaje(pelicula) >= cortePrioridadMedia) && (this.determinarPuntaje(pelicula) <= cortePrioridadAlta))).collect(Collectors.toList());
    }

    @Override
    public List<Pelicula> seleccionarPrioridadBAJA(List<Pelicula> todasLasPelis) {
        return todasLasPelis.stream().filter((pelicula)->(this.determinarPuntaje(pelicula) < cortePrioridadMedia)).collect(Collectors.toList());
    }

}
