package Business.PlanificationStrategy;

import Business.Pelicula;
import java.util.List;

public interface PlanificationStrategy {

    List<Pelicula> seleccionarPrioridadALTA(List<Pelicula> peliculas);
    List<Pelicula> seleccionarPrioridadMEDIA(List<Pelicula> peliculas);
    List<Pelicula> seleccionarPrioridadBAJA(List<Pelicula> peliculas);

}
