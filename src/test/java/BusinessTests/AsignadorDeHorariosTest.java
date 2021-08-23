package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/*

El algoritmo mira las salas que tiene el cine y va iterando cada sala, es decir, toma una sala,
le asigna una pelicula y luego pasa a otra pelicula y otra sala. Así sucesivamente, si no hay
más salas o más peliculas, vuelve a la primera. Si una sala se pasa del horario limite que tiene el cine para
dar peliculas, saltea esa sala (no le asigna nada) y le asigna esa pelicula a la proxima.
Para los horarios, cada sala tiene un contador que va registrando hasta qué horario tiene planificado.
Cada funcion tiene la duracion de la pelicula más 30 minutos de limpieza de la sala.
Esta hecho de manera tal que ninguna pelicula puede empezar despues de las 23, automáticamente pasa al día siguiente.

Según la estrategia Estandar, la planificación sería:


 --------------------------------------| CINE A |--------------------------------------

          PELICULA          | DURACION  |     hh:mm
                            | (minutos) | (con Limpieza)
        ------------------------------------------------
        Back to the Future  |    116    |     02:26
        Joker               |    122    |     02:32
        Ratatouille         |    111    |     02:21
        -------------------------------------------------

 ---------------------------------------------------------------------------------------------------
 |            SALA A1             |            SALA A2             |           SALA A3             |
 |--------------------------------|--------------------------------|--------------------------------
 | 10:00 Back to the Future       | 10:00 Joker                    | 10:00 Ratatouille             |
 | 12:26 Back to the Future       | 12:32 Joker                    | 12:21 Ratatouille             |
 | 14:52 Back to the Future       | 15:04 Joker                    | 14:42 Ratatouille             |
 | 17:18 Back to the Future       | 17:36 Joker                    | 17:03 Ratatouille             |
 | 19:44 Back to the Future       | 20:08 Joker                    | 19:24 Ratatouille             |
 | 22:10 Back to the Future       | 22:40 Joker                    | 21:45 Ratatouille             |
 ---------------------------------------------------------------------------------------------------


 --------------------------------------| CINE B |--------------------------------------

          PELICULA          | DURACION  |     hh:mm
                            | (minutos) | (con Limpieza)
        ------------------------------------------------
        Back to the Future  |    116    |     02:26
        Joker               |    122    |     02:32
        Ratatouille         |    111    |     02:21
        -------------------------------------------------

 -------------------------------------------------------------------
 |            SALA B1             |            SALA B2             |
 |--------------------------------|--------------------------------|
 | 10:00 Back to the Future       | 10:00 Joker                    |
 | 12:26 Ratatouille              | 12:32 Back to the Future       |
 | 14:47 Joker                    | 14:58 Ratatouille              |
 | 17:19 Back to the Future       | 17:19 Joker                    |
 | 19:45 Ratatouille              | 19:51 Back to the Future       |
 | 22:06 Joker                    | 22:17 Ratatouille              |
 -------------------------------------------------------------------


--------------------------|  CINE C  |------------------------------------------------------------

          PELICULA          | DURACION  |     hh:mm
                            | (minutos) | (con Limpieza)
        ------------------------------------------------
        Back to the Future  |    113    |     02:26
        Joker               |    122    |     02:32
        Black Widow         |    134    |     02:44
        Snatch              |    102    |     02:12
        Cape Fear           |    128    |     02:38
        Catch Me If You Can |    141    |     02:51
        -------------------------------------------------

 ----------------------------------
 |            SALA C1             |
 |--------------------------------|
 | 10:00 Back to the Future       |
 | 12:26 Joker                    |
 | 14:58 Black Widow              |
 | 17:42 Snatch                   |
 | 19:54 Cape Fear                |
 | 22:32 Catch Me If You Can      |
 ----------------------------------

-----------------------------------------------------------------------------------------------
*/

public class AsignadorDeHorariosTest extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarPersonas();
        this.inicializarAdministradores();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarCadena();

        planificador.planificar();
        cineA.realizarPlanificacionSemanal();
        cineB.realizarPlanificacionSemanal();
        cineC.realizarPlanificacionSemanal();
    }

    // ------------------------ TESTS SOBRE EL CINE A -----------------------
    @Test
    public void elCineATiene18Funciones(){
        Assert.assertEquals(18, cineA.cantidadDeFunciones());
    }

    @Test
    public void laSala1DelCineATiene6Funciones(){
        Assert.assertEquals(6, cineA.cantidadDeFuncionesPorSala(salaA1));
    }

    @Test
    public void laSala2DelCineATiene6Funciones(){
        Assert.assertEquals(6, cineA.cantidadDeFuncionesPorSala(salaA2));
    }

    @Test
    public void laSala3DelCineATiene6Funciones(){
        Assert.assertEquals(6, cineA.cantidadDeFuncionesPorSala(salaA3));
    }

    @Test
    public void laSala2DelCineAPasaRatatouilleComoPrimeraPelicula(){
        Assert.assertEquals("Ratatouille", cineA.getFunciones().get(salaA2).stream().findFirst().get().getPelicula());
    }

    @Test
    public void laSala1DelCineAPasaBackToTheFutureComoPrimerPelicula(){
        Assert.assertEquals("Back to the Future", cineA.getFunciones().get(salaA1).get(0).getPelicula());
    }

    // ------------------------ TESTS SOBRE EL CINE B -----------------------
    @Test
    public void elCineBTiene12Funciones(){
        Assert.assertEquals(12, cineB.cantidadDeFunciones());
    }

    @Test
    public void laSala1DelCineBTiene6Funciones(){
        Assert.assertEquals(6, cineB.cantidadDeFuncionesPorSala(salaB1));
    }


    // ------------------------ TESTS SOBRE EL CINE C -----------------------
    @Test
    public void elCineCTiene6Funciones(){
        Assert.assertEquals(6, cineC.cantidadDeFunciones());
    }

    @Test
    public void laSala1DelCineCPasaBackToTheFutureComoPrimerPelicula(){
        Assert.assertEquals("Back to the Future", cineC.getFunciones().get(salaC1).get(0).getPelicula());
    }

}
