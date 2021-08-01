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

Mecanismo interno (Primera Version) tomando las dos preguntas que son parámetro:

    ---------------------------------------------------------------------------------
    |                       |   PRIORIDAD ALTA   | PRIORIDAD MEDIA | PRIORIDAD BAJA |
    ---------------------------------------------------------------------------------
    | ¿ES GENERO POPULAR?   |          SI        |       NO        |      NO        |
    ---------------------------------------------------------------------------------
    | ¿ES ATP?              |        SI/NO       |       SI        |      NO        |
    ---------------------------------------------------------------------------------

.....................................................................................
*/

@Data
public class PlanificadorEstandar implements Planificador {

    List<Genero> listaDeGeneros = Stream.of(ACCION, THRILLER, CIENCIAFICCION, AVENTURAS, FANTASIA).collect(Collectors.toList());

    List<Pelicula> listaCompletaDePelis;
    List<Pelicula> listaPrioridadAlta;
    List<Pelicula> listaPrioridadMedia;
    List<Pelicula> listaPrioridadBaja;

    List<Cine> listaDeCines;


    @Override
    public void planificar() {
        Cadena cadena = Cadena.getInstance();
        listaCompletaDePelis = cadena.getPeliculas();

        for(Pelicula pelicula : listaCompletaDePelis) {
            if(this.esDeGeneroPopular(pelicula)){
                listaPrioridadAlta.add(pelicula);
            }else if(pelicula.getATP()) {
                listaPrioridadMedia.add(pelicula);
            }else{
                listaPrioridadBaja.add(pelicula);
            }
        }

        listaDeCines = cadena.getCines();

        for(Cine cine : listaDeCines){
            cine.recibirPeliculas(listaPrioridadAlta, listaPrioridadMedia, listaPrioridadBaja);
        }

        // TODO: No se si se vacían las listas al terminar el metodo o si deberiamos hacerlo
    }

    public boolean esDeGeneroPopular(Pelicula unaPelicula){
        return unaPelicula.getGeneros().stream().anyMatch(n -> listaDeGeneros.contains(n));
    }

}
