package BusinessTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*

El algoritmo mira las salas que tiene el cine y va iterando cada sala, es decir, toma una sala,
le asigna una pelicula y luego pasa a otra pelicula y otra sala. Así sucesivamente, si no hay
más salas o más peliculas, vuelve a la primera. Si una sala se pasa del horario limite que tiene el cine para
dar peliculas, saltea esa sala (no le asigna nada) y le asigna esa pelicula a la proxima.
Para los horarios, cada sala tiene un contador que va registrando hasta qué horario tiene planificado.
Cada funcion tiene la duracion de la pelicula más 30 minutos de limpieza de la sala.
Esta hecho de manera tal que ninguna pelicula puede empezar despues de las 23, automáticamente pasa al día siguiente.

Según la estrategia Estandar, la planificación sería:

-------------------------| CINE A |--------------------------------------

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
    20:32 BLACK WIDOW   |       19:16 VOLVER AL FUTURO      |       20:38 RATATOUILLE
    23:16 --            |       21:40 JOKER                 |       23:06 --
                        |       00:12 --                    |
---------------------------------------------------------------------------------------------

-------------------------| CINE B |--------------------------------------

          PELICULA          | DURACION  |     hh:mm
                            | (minutos) | (con Limpieza)
        ------------------------------------------------
        Black Widow         |    134    |     02:44
        Volver Al Futuro    |    116    |     02:26
        Ratatouille         |    118    |     02:28
        Joker               |    122    |     02:32
        Snatch              |    104    |     02:14
        Catch Me If You Can |    141    |     02:51
        ------------------------------------------------

-------------------------------------------------------------
SALA B1:                |   SALA B2                         |
------------------------|-----------------------------------|
    10:00 BLACK WIDOW   |       10:00 VOLVER AL FUTURO      |
    12:44 RATATOUILLE   |       12:26 JOKER                 |
    15:12 SNATCH        |       14:58 CATCH ME IF YOU CAN   |
    17:26 BLACK WIDOW   |       17:49 VOLVER AL FUTURO      |
    20:10 RATATOUILLE   |       20:15 JOKER                 |
    22:38 SNATCH        |       22:47 CATCH ME IF YOU CAN   |
-------------------------------------------------------------


--------------------------|  CINE C  |------------------------------------------------------------

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

-----------------------------
SALA C1:                    |
----------------------------|
    10:00 BLACK WIDOW       |
    12:44 VOLVER AL FUTURO  |
    15:10 RATATOUILLE       |
    17:38 JOKER             |
    20:10 SNATCH            |
    22:24 CAPE FEAR         |
-----------------------------

-----------------------------------------------------------------------------------------------


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

    // ------------------------ TESTS SOBRE EL CINE A -----------------------
    @Test
    public void elCineATiene16Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        //cineA.mostrarFunciones();
        Assert.assertEquals(16, cineA.cantidadDeFunciones());
    }

    @Test
    public void laSala1DelCineATiene5Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals(5, cineA.cantidadDeFuncionesPorSala(salaA1));
    }

    @Test
    public void laSala2DelCineATiene6Funciones(){
        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        Assert.assertEquals(6, cineA.cantidadDeFuncionesPorSala(salaA2));
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

    // ------------------------ TESTS SOBRE EL CINE B -----------------------
    @Test
    public void elCineBTiene12Funciones(){
        planificador.planificar();
        cineB.realizarPlanificacionSemanal();
        //cineB.mostrarFunciones();
        Assert.assertEquals(12, cineB.cantidadDeFunciones());
    }

    @Test
    public void laSala1DelCineBTiene6Funciones(){
        planificador.planificar();
        cineB.realizarPlanificacionSemanal();
        Assert.assertEquals(6, cineB.cantidadDeFuncionesPorSala(salaB1));
    }


    // ------------------------ TESTS SOBRE EL CINE C -----------------------
    @Test
    public void elCineCTiene6Funciones(){
        planificador.planificar();
        cineC.realizarPlanificacionSemanal();
        //cineC.mostrarFunciones();
        Assert.assertEquals(6, cineC.cantidadDeFunciones());
    }

    @Test
    public void laSala3DelCineCPasaBlackWidowComoPrimerPelicula(){
        planificador.planificar();
        cineC.realizarPlanificacionSemanal();
        Assert.assertEquals("Black Widow", cineC.getFunciones().get(salaC1).get(0).getPelicula().getTitulo());
    }

    @Test
    public void laSala3DelCineCPasaJokerALas17(){
        planificador.planificar();
        cineC.realizarPlanificacionSemanal();
        Assert.assertEquals("Joker", cineC.buscarPeliculaPorHora(salaC1, 17));
    }



}
