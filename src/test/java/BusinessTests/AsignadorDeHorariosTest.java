package BusinessTests;

import Business.Cine;
import Business.Pelicula;
import Business.Sala;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* ESTRATEGIA ESTANDAR

El algoritmo mira las salas que tiene el cine y va iterando cada sala, es decir, toma una sala,
le asigna una pelicula y luego pasa a otra pelicula y otra sala. Asi sucesivamente, si no hay
mas salas o mas peliculas, vuelve a la primera.
Para los horarios, cada sala tiene un contador que va registrando hasta qué horario tiene planificado.
Cada funcion tiene la duracion de la pelicula mas 30 minutos de limpieza de la sala.
Esta hecho de manera tal que ninguna pelicula puede empezar despues de las 21, automaticamente pasa al dia siguiente.

Segun la estrategia, la planificación sería:

------------------------- CINE A --------------------------------------

          PELICULA          | DURACION  |     hh:mm
                            | (minutos) | (con Limpieza)
        ------------------------------------------------
        Black Widow         |    134    |     02:44
        Volver Al Futuro    |    116    |     02:26
        Ratatouille         |    118    |     02:28
        Joker               |    122    |     02:32
        Snatch              |    104    |     02:14
        Catch Me If You Can |    141    |     02:51
        -------------------------------------------------

---------------------------------------------------------------------------------------------
SALA A1:                |   SALA A2                         |   SALA A3
------------------------|-----------------------------------|--------------------------------
    10:00 BLACK WIDOW   |       10:00 VOLVER AL FUTURO      |       10:00 RATATOUILLE
    12:44 JOKER         |       12:24 SNATCH                |       12:28 CATCH ME IF YOU CAN
    15:16 BLACK WIDOW   |       14:38 VOLVER AL FUTURO      |       15:19 RATATOUILLE
    18:00 JOKER         |       17:02 SNATCH                |       17:47 CATCH ME IF YOU CAN
    20:44 BLACK WIDOW   |       19:16 VOLVER AL FUTURO      |       20:38 RATATOUILLE
    23:16               |       21:40                       |       22:52


-------------------------- CINE C ------------------------------------------------------------

          PELICULA          | DURACION  |     hh:mm
                            | (minutos) | (con Limpieza)
        ------------------------------------------------
        Black Widow         |    134    |     02:44
        Volver Al Futuro    |    116    |     02:26
        Ratatouille         |    118    |     02:28
        Joker               |    122    |     02:32
        Snatch              |    104    |     02:14
        Cape Fear           |    128    |     02:38
        -------------------------------------------------

SALA C1:

    10:00 BLACK WIDOW
    12:44 VOLVER AL FUTURO
    15:10 RATATOUILLE
    17:38 JOKER
    20:10 SNATCH
    22:24

TODO: el asignador rompe si las tres salas no cortan al mismo tiempo. (Por eso el corte a las 21)

*/

public class AsignadorDeHorariosTest extends TestResources {

    @Before
    public void inicializar(){
        this.inicializarPeliculas();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarCadena();
    }

    // -------------------- TEST SOBRE EL CINE A -------------------------------
    @Test
    public void elCineATiene15Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals(15, cineA.cantidadDeFunciones());
    }

    @Test
    public void laSala1DelCineATiene5Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals(5, cineA.cantidadDeFuncionesPorSala(salaA1));
    }

    @Test
    public void laSala2DelCineATiene5Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals(5, cineA.cantidadDeFuncionesPorSala(salaA2));
    }

    @Test
    public void laSala3DelCineATiene5Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals(5, cineA.cantidadDeFuncionesPorSala(salaA3));
    }

    @Test
    public void laSala3DelCineAPasaRatatouilleComoUltimaPelicula(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals("Ratatouille", cineA.getFunciones().get(salaA3).get(4).getPelicula().getTitulo());
    }

    @Test
    public void laSala1DelCineAPasaBlackWidowComoPrimerPelicula(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals("Black Widow", cineA.getFunciones().get(salaA1).get(0).getPelicula().getTitulo());
    }


    // ------------------------ TEST SOBRE EL CINE C -----------------------
    @Test
    public void elCineCTiene5Funciones(){
        planificador.planificar();
        cineC.realizarPlanificacionSemanal();
        Assert.assertEquals(5, cineC.cantidadDeFunciones());
    }

    @Test
    public void laSala3DelCineCPasaBlackWidowComoPrimerPelicula(){
        planificador.planificar();
        cineC.realizarPlanificacionSemanal();
        Assert.assertEquals("Black Widow", cineC.getFunciones().get(salaC1).get(0).getPelicula().getTitulo());
    }

    @Test
    public void laSala3DelCineCPasaJokerALas17(){ // Creo que hace un redondeo pero hay que investigarlo
        planificador.planificar();
        cineC.realizarPlanificacionSemanal();
        Assert.assertEquals("Joker", cineC.buscarPeliculaPorHora(salaC1, 17));
    }
}
