package Business.PlanificationStrategy;

import Business.Enums.Genero;
import Business.Pelicula;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static Business.Enums.Genero.*;

/*
............................. Criterio Infantil .............................................................

Parámetros a utilizar

--> ¿Tiene Rating Alto?             20 puntos
--> ¿Tiene Rating Medio?            15 puntos
--> ¿Tiene Rating Bajo?             10 puntos
--> ¿Es ATP?                        10 puntos
--> ¿Dura menos de 130 minutos?     5  puntos


 */

@Data
public class EstrategiaInfantil implements PlanificationStrategy {

    //List<Genero> generosFamiliares = Stream.of(ACCION, AVENTURAS, CIENCIAFICCION, COMEDIA, FANTASIA).collect(Collectors.toList());

    int minutosParaQueSeaCortaDuracion = 130;

    // PUNTAJES
    int puntajeRatingAlto       = 20;
    int puntajeRatingMedio      = 10;
    int puntajeRatingBajo       = 5;
    int puntajeATP              = 20;
    int puntajeCortaDuracion    = 5;

    // PUNTAJES PARA CATEGORIA RATING
    double corteRatingAlto  = 7.8;
    double corteRatingMedio = 5.3;

    //PUNTAJES PARA PRIORIDAD
    int cortePrioridadAlta  = 35;
    int cortePrioridadMedia = 25;


    public int determinarPuntaje(Pelicula unaPelicula){
        int puntajeTotal = 0;
        if(unaPelicula.tieneRatingMayorA(corteRatingAlto)) {
            puntajeTotal += puntajeRatingAlto;
        }else if(unaPelicula.tieneRatingMayorA(corteRatingMedio)) {
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
