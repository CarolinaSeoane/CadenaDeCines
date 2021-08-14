package BusinessTests;

import Business.Cadena;
import Business.Pelicula;
import Business.PlanificationStrategy.EstrategiaInfantil;
import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

/*
              PELICULA      | RATING | ¿ES   |  < 115  | PUNTAJE | PRIORIDAD
                            |        |  ATP? | MINUTOS | TOTAL   |
        ---------------------------------------------------------------------
        Black Widow         |   10   |  0    |    0    |    10   |   BAJA
        Back to the Future  |   20   |  10   |    0    |    30   |   ALTA
        Ratatouille         |   15   |  10   |    5    |    30   |   ALTA
        Joker               |   20   |  0    |    0    |    20   |   MEDIA
        Snatch              |   15   |  0    |    5    |    20   |   MEDIA
        Cape Fear           |   15   |  0    |    0    |    15   |   MEDIA
        Catch Me If You Can |   15   |  0    |    0    |    15   |   MEDIA

        ALTA:   (25;inf)
        MEDIA:  [15;25]
        BAJA:   [0;15)
*/

public class EstrategiaInfantilTest extends TestResources {

    private EstrategiaInfantil estrategiaInfantil;
    private List<Pelicula> peliculas;

    @Before
    public void inicializar() throws IOException {
        this.inicializarCadena();
        this.estrategiaInfantil = new EstrategiaInfantil();
        peliculas = Cadena.getInstance().getPeliculas();
    }

    @Test
    public void hay7Peliculas() {
        Assert.assertEquals(7, peliculas.size());
    }

    @Test
    public void hay2PeliculasDePrioridadALTA() {
        Assert.assertEquals(2, estrategiaInfantil.seleccionarPrioridadALTA(peliculas).size());
    }

    @Test
    public void hay4Peliculas1DePrioridadMEDIA() {
        Assert.assertEquals(4, estrategiaInfantil.seleccionarPrioridadMEDIA(peliculas).size());
    }

    @Test
    public void hay1PeliculaDePrioridadBAJA() {
        Assert.assertEquals(1, estrategiaInfantil.seleccionarPrioridadBAJA(peliculas).size());
    }

    @Test
    public void ratatouilleEsDePrioridadAlta() {
        Assert.assertTrue(estrategiaInfantil.seleccionarPrioridadALTA(peliculas).contains(ratatouille));
    }

    @Test
    public void snatchEsDePrioridadMedia() {
        Assert.assertTrue(estrategiaInfantil.seleccionarPrioridadMEDIA(peliculas).contains(snatch));
    }

    @Test
    public void blackWidowEsDePrioridadBaja() {
        Assert.assertTrue(estrategiaInfantil.seleccionarPrioridadBAJA(peliculas).contains(blackWidow));
    }

}
