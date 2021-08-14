package Business.PlanificationStrategy;

import Business.Enums.Genero;
import Business.Pelicula;
import lombok.Data;
import static Business.Enums.Genero.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
............................. Criterio Estandar .....................................

El planificador se basa en dos parámetros   ---> ¿Tiene Rating alto?
                                            ---> ¿Es ATP?

Procedimiento: Le pide a la Cadena la lista de películas y, a medida que la recorre,
decide para cada una qué prioridad le pertenece. No tomamos en cuenta la cantidad
en cada lista. Puede haber muchas de alta prioridad y pocas de baja prioridad.

Tabla de Decisión (Primera Version) tomando las dos preguntas que son parámetro:

    -------------------------------------------------------------------------
    |                       |       1       |       2       |       3       |
    -------------------------------------------------------------------------
    | ¿Tiene Rating alto?   |       SI      |       NO      |       NO      |
    -------------------------------------------------------------------------
    | ¿ES ATP?              |     SI/NO     |       SI      |       NO      |
    -------------------------------------------------------------------------
    -------------------------------------------------------------------------
    | ESTABLECER PRIORIDAD  |     ALTA      |     MEDIA     |      BAJA     |
    -------------------------------------------------------------------------

.....................................................................................
*/

@Data
public class EstrategiaEstandar implements PlanificationStrategy {

    //List<Genero> generosPopulares = Stream.of(ACCION, AVENTURAS, CIENCIAFICCION, FANTASIA, ROMANCE, TERROR, THRILLER).collect(Collectors.toList());
    private double puntajeRatingAlto = 7.8;

    @Override
    public List<Pelicula> seleccionarPrioridadALTA(List<Pelicula> todasLasPelis) {
        return todasLasPelis.stream().filter((pelicula)->(pelicula.tieneRatingMayorA(puntajeRatingAlto))).collect(Collectors.toList());
    }

    @Override
    public List<Pelicula> seleccionarPrioridadMEDIA(List<Pelicula> todasLasPelis) {
        return todasLasPelis.stream().filter((pelicula)->(!pelicula.tieneRatingMayorA(puntajeRatingAlto) && pelicula.getATP())).collect(Collectors.toList());
    }

    @Override
    public List<Pelicula> seleccionarPrioridadBAJA(List<Pelicula> todasLasPelis) {
        return todasLasPelis.stream().filter((pelicula)->(!pelicula.tieneRatingMayorA(puntajeRatingAlto) && !pelicula.getATP())).collect(Collectors.toList());
    }
}
