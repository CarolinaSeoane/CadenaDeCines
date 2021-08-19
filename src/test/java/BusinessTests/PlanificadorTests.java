package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Usando planificacion Estandar

               PELICULA      | ¿RATING  |  ¿ES   | PRIORIDAD
                            |  ALTO?   |   ATP? |
        ----------------------------------------------------
        Black Widow         |    NO    |   NO   | BAJA
        Back to the Future  |    SI    |   SI   | ALTA
        Ratatouille         |    NO    |   SI   | MEDIA
        Joker               |    SI    |   NO   | ALTA
        Snatch              |    NO    |   NO   | BAJA
        Cape Fear           |    NO    |   NO   | BAJA
        Catch Me If You Can |    NO    |   NO   | BAJA

        Total:  ALTA:   2
                MEDIA:  1
                BAJA:   4

        Cine A recibe 3 peliculas: ALTA, MEDIA
        Cine B recibe 3 peliculas: ALTA, MEDIA
        Cine C recibe 6 peliculas: ALTA, BAJA

*/

public class PlanificadorTests extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarCadena();
        planificador.planificar();
    }

    @Test
    public void enPlanificacionEstandarCineARecibe3Peliculas() {
        Assert.assertEquals(3, asignadorDeHorariosA.getPeliculas().size());

    }

    @Test
    public void enPlanificacionEstandarCineBRecibe3Peliculas() {
        Assert.assertEquals(3, asignadorDeHorariosB.getPeliculas().size());

    }

    @Test
    public void enPlanificacionEstandarCineCRecibe6Peliculas() {
        Assert.assertEquals(6, asignadorDeHorariosC.getPeliculas().size());

    }

    @Test
    public void enPlanificacionEstandarCineANoRecibeCapeFear() {
        Assert.assertFalse(asignadorDeHorariosA.getPeliculas().contains(capeFear));

    }

    @Test
    public void enPlanificacionEstandarCineBRecibeExactamenteXPeliculas() {
        Assert.assertEquals(Stream.of(backToTheFuture, joker, ratatouille).collect(Collectors.toList()), asignadorDeHorariosB.getPeliculas());
    }

}
