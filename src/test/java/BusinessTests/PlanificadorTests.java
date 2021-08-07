package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Usando planificacion Estandar

              PELICULA      | ¿GENERO  |  ¿ES   | PRIORIDAD
                            | POPULAR? |   ATP? |
        ----------------------------------------------------
        Black Widow         |    SI    |   SI   | ALTA
        Volver Al Futuro    |    SI    |   SI   | ALTA
        Ratatouille         |    SI    |   SI   | ALTA
        Joker               |    SI    |   NO   | ALTA
        Snatch              |    SI    |   NO   | ALTA
        Cape Fear           |    SI    |   NO   | BAJA
        Catch Me If You Can |    SI    |   SI   | MEDIA

        Cine A recibe 6 peliculas: ALTA, MEDIA
        Cine B recibe 6 peliculas: ALTA, MEDIA
        Cine C recibe 6 peliculas: ALTA, BAJA

*/

public class PlanificadorTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarPeliculas();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarCadena();
    }

    @Test
    public void enPlanificacionEstandarCineARecibe6Peliculas() {
        planificador.planificar();
        Assert.assertEquals(6, asignadorDeHorariosA.getPeliculas().size());

    }

    @Test
    public void enPlanificacionEstandarCineBRecibe6Peliculas() {
        planificador.planificar();
        Assert.assertEquals(6, asignadorDeHorariosB.getPeliculas().size());

    }

    @Test
    public void enPlanificacionEstandarCineCRecibe6Peliculas() {
        planificador.planificar();
        Assert.assertEquals(6, asignadorDeHorariosC.getPeliculas().size());

    }

    @Test
    public void enPlanificacionEstandarCineANoRecibeCapeFear() {
        planificador.planificar();
        Assert.assertFalse(asignadorDeHorariosA.getPeliculas().contains(capeFear));

    }

    @Test
    public void enPlanificacionEstandarCineBRecibeXPeliculas() {
        planificador.planificar();
        Assert.assertEquals(Stream.of(blackWidow, volverAlFuturo, ratatouille, joker, snatch, catchMeIfYouCan).collect(Collectors.toList()), asignadorDeHorariosB.getPeliculas());
    }
    
}
