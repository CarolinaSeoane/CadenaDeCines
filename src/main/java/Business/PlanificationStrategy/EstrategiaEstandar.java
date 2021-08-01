package Business.PlanificationStrategy;

import Business.Cadena;
import Business.Cine;
import Business.Enums.Genero;
import Business.Pelicula;
import lombok.Data;
import static Business.Enums.Genero.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
............................. Criterio Estandar .....................................

El planificador se basa en dos parámetros   ---> ¿Pertenece a un género popular?
                                            ---> ¿Es ATP?

Géneros populares: ACCION, CIENCIAFICCION, COMEDIA, DRAMA, TERROR, INFANTIL.

Procedimiento: Le pide a la Cadena la lista de películas y, a medida que la recorre,
decide para cada una qué prioridad le pertenece. No tomamos en cuenta la cantidad
en cada lista. Puede haber muchas de alta prioridad y pocas de baja prioridad.

Tabla de Decisión (Primera Version) tomando las dos preguntas que son parámetro:

    -------------------------------------------------------------------------
    |                       |       1       |       2       |       3       |
    -------------------------------------------------------------------------
    | ¿ES GENERO POPULAR?   |       SI      |       NO      |       NO      |
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

    List<Genero> generosPopulares = Stream.of(ACCION, AVENTURAS, CIENCIAFICCION, FANTASIA, ROMANCE, TERROR, THRILLER).collect(Collectors.toList());

    @Override
    public void darPrioridadAPeliculas(List<Pelicula> todasLasPelis, List<Pelicula> prioridadAlta, List<Pelicula> prioridadMedia, List<Pelicula> prioridadBaja) {
        for(Pelicula pelicula : todasLasPelis) {
            if(this.esDeGeneroPopular(pelicula)){
                prioridadAlta.add(pelicula);
            }else if(pelicula.getATP()) {
                prioridadMedia.add(pelicula);
            }else{
                prioridadBaja.add(pelicula);
            }
        }
    }

    public boolean esDeGeneroPopular(Pelicula unaPelicula){
        return unaPelicula.getGeneros().stream().anyMatch(n -> generosPopulares.contains(n));
    }

}
