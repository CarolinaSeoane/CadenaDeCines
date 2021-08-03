package BusinessTests;

import Business.Pelicula;
import Business.PlanificationStrategy.EstrategiaEstandar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
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

*/

public class EstrategiaEstandarTest extends TestResources {

    private EstrategiaEstandar estrategiaEstandar;
    private List<Pelicula> peliculas;

    @Before
    public void inicializar() {
        this.inicializarPeliculas();
        this.estrategiaEstandar = new EstrategiaEstandar();
        this.peliculas = Stream.of(blackWidow, volverAlFuturo, ratatouille, joker, snatch, capeFear, catchMeIfYouCan).collect(Collectors.toList());
    }

    @Test
    public void hay5PeliculasDePrioridadALTA() {
        Assert.assertEquals(5, estrategiaEstandar.seleccionarPrioridadALTA(peliculas).size());
    }

    @Test
    public void hay1Pelicula1DePrioridadMEDIA() {
        Assert.assertEquals(1, estrategiaEstandar.seleccionarPrioridadMEDIA(peliculas).size());
    }

    @Test
    public void hay1PeliculaDePrioridadBAJA() {
        Assert.assertEquals(1, estrategiaEstandar.seleccionarPrioridadBAJA(peliculas).size());
    }

    @Test
    public void blackWidowEsDePrioridadAlta() {
        Assert.assertTrue(estrategiaEstandar.seleccionarPrioridadALTA(peliculas).contains(blackWidow));
    }

    @Test
    public void catchMeIfYouCanEsDePrioridadMedia() {
        Assert.assertTrue(estrategiaEstandar.seleccionarPrioridadMEDIA(peliculas).contains(catchMeIfYouCan));
    }

    @Test
    public void capeFearEsDePrioridadBaja() {
        Assert.assertTrue(estrategiaEstandar.seleccionarPrioridadBAJA(peliculas).contains(capeFear));
    }

}
