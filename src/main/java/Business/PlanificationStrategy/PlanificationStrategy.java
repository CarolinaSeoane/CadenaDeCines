package Business.PlanificationStrategy;

import Business.Pelicula;

import java.util.List;


public interface PlanificationStrategy {

    void darPrioridadAPeliculas(List<Pelicula> todas, List<Pelicula> alta, List<Pelicula> media, List<Pelicula> baja);

}
