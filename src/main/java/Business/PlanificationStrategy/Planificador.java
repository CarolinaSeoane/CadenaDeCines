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


    /*  *****   *****   Singleton   *****   *****   */

    private static Planificador instance = null;

    private Planificador() {}

    public static Planificador getInstance() {
        if(instance == null) {
            instance = new Planificador();
            instance.estrategiaActual = new EstrategiaEstandar();
        }
        return instance;
    }

    /*  *****   *****   Fin Singleton   *****   *****   */


    public void planificar() {

        List<Pelicula> todasLasPelis = Cadena.getInstance().getPeliculas();

        List<Pelicula> ALTA = estrategiaActual.seleccionarPrioridadALTA(todasLasPelis);
        List<Pelicula> MEDIA = estrategiaActual.seleccionarPrioridadMEDIA(todasLasPelis);
        List<Pelicula> BAJA = estrategiaActual.seleccionarPrioridadBAJA(todasLasPelis);

        this.enviarPeliculasALosCines(ALTA, MEDIA, BAJA);
    }


    private void enviarPeliculasALosCines(List<Pelicula> ALTA, List<Pelicula> MEDIA, List<Pelicula> BAJA) {

        List<Cine> cines = Cadena.getInstance().getCines();
        int listSize = cines.size();

        // ALTA
        cines.forEach((cine)->cine.recibirPeliculas(ALTA));

        // MEDIA
        int mitadCines = (int) Math.ceil(listSize / 2);

        for (int i = 0; i <= mitadCines; i++)
            cines.get(i).recibirPeliculas(MEDIA);

        // BAJA
        int unTercioCines = (int) Math.floor(listSize / 3);

        for (int i = (listSize - 1); i >= (listSize - unTercioCines); i--)
            cines.get(i).recibirPeliculas(BAJA);

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
