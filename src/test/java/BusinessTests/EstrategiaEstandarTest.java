package BusinessTests;

import Business.Cadena;
import Business.Pelicula;
import Business.PlanificationStrategy.EstrategiaEstandar;
import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

/*
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

*/

public class EstrategiaEstandarTest extends TestResources {

    private EstrategiaEstandar estrategiaEstandar;
    private List<Pelicula> peliculas;

    @Before
    public void inicializar() throws IOException {
        this.inicializarCadena();
        this.estrategiaEstandar = new EstrategiaEstandar();
        this.peliculas = Cadena.getInstance().getPeliculas();
    }

    @Test
    public void hayPeliculasDePrioridadALTA() {
        Assert.assertEquals(2, estrategiaEstandar.seleccionarPrioridadALTA(peliculas).size());
    }

    @Test
    public void hay1Pelicula1DePrioridadMEDIA() {
        Assert.assertEquals(1, estrategiaEstandar.seleccionarPrioridadMEDIA(peliculas).size());
    }

    @Test
    public void hay4PeliculaDePrioridadBAJA() {
        Assert.assertEquals(4, estrategiaEstandar.seleccionarPrioridadBAJA(peliculas).size());
    }

    @Test
    public void backToTheFutureEsDePrioridadAlta() {
        Assert.assertTrue(estrategiaEstandar.seleccionarPrioridadALTA(peliculas).contains(backToTheFuture));
    }

    @Test
    public void ratatouilleEsDePrioridadMedia() {
        Assert.assertTrue(estrategiaEstandar.seleccionarPrioridadMEDIA(peliculas).contains(ratatouille));
    }

    @Test
    public void blackWidowEsDePrioridadBaja() {
        Assert.assertTrue(estrategiaEstandar.seleccionarPrioridadBAJA(peliculas).contains(blackWidow));
    }

}
