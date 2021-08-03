package Business.PlanificationStrategy;

import Business.Cadena;
import Business.Cine;
import Business.Pelicula;

import java.util.*;

/*
* De acuerdo a la estrategia actual, el planificador se encarga de separar las peliculas en aquellas
* de prioridad Alta, Media y Baja.
*
*   -----------------------------------------------------------------------------------------
*   |                                       PRIORIDAD                                       |
*   -----------------------------------------------------------------------------------------
*   |            ALTA            |            MEDIA            |            BAJA            |
*   -----------------------------------------------------------------------------------------
*   | Estan disponibles en todos | Estan disponibles en la     | Estan disponibles en 1/3 de|
*   | todos los cines            | mitad de los cines. Si la   | los cines. Si la cantidad  |
*   |                            | cantidad de cines fuera     | de cines no fuera divisible|
*   |                            | impar, se redondea al mayor.| por 3, se redondea al menor|
*   -----------------------------------------------------------------------------------------
*
* */


public class Planificador {

    private PlanificationStrategy estrategiaActual;
    private List<Pelicula> pelisPrioridadAlta;
    private List<Pelicula> pelisPrioridadMedia;
    private List<Pelicula> pelisPrioridadBaja;


    /*  *****   *****   Singleton   *****   *****   */

    private static Planificador instance = null;

    private Planificador() {}

    public static Planificador getInstance() {
        if(instance == null){
            instance = new Planificador();
            instance.estrategiaActual = new EstrategiaEstandar();
        }
        return instance;
    }

    /*  *****   *****   Fin Singleton   *****   *****   */


    public void planificar() {

        Cadena cadena = Cadena.getInstance();
        List<Pelicula> todasLasPelis = cadena.getPeliculas();

        pelisPrioridadAlta = new ArrayList<>();
        pelisPrioridadMedia = new ArrayList<>();
        pelisPrioridadBaja = new ArrayList<>();

        estrategiaActual.darPrioridadAPeliculas(todasLasPelis, pelisPrioridadAlta, pelisPrioridadMedia, pelisPrioridadBaja);

        this.enviarPeliculasALosCines(pelisPrioridadAlta, pelisPrioridadMedia, pelisPrioridadBaja);
    }

    private void enviarPeliculasALosCines(List<Pelicula> pelisPrioridadAlta, List<Pelicula> pelisPrioridadMedia, List<Pelicula> pelisPrioridadBaja) {

        List<Cine> listaDeCines = Cadena.getInstance().getCines();
        int listSize = listaDeCines.size();

        // Las peliculas de prioridad alta van a todos los cines
        listaDeCines.forEach((cine)->cine.recibirPeliculas(pelisPrioridadAlta));

        // Las de prioridad media van a la mitad de los cines (agarro la primer mitad)
        int mitadCines = (int) Math.ceil(listSize / 2);

        for (int i = 0; i < mitadCines; i++)
            listaDeCines.get(i).recibirPeliculas(pelisPrioridadMedia);

        // Las de prioridad baja van a 1/3 de los cines (agarro desde el final de la lista)
        int unTercioCines = (int) Math.floor(listSize / 3);

        for (int i = listSize - 1; i >= (listSize - unTercioCines); i--)
            listaDeCines.get(i).recibirPeliculas(pelisPrioridadBaja);

    }

    public void cambiarPlanificacion(int nuevaPlanificacion) {
        switch (nuevaPlanificacion) {
            case 1:
                this.estrategiaActual = new EstrategiaInfantil();
                break;
            case 0:
            default:
                this.estrategiaActual = new EstrategiaEstandar();
        }
    }

}
