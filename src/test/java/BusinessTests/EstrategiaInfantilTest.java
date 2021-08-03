package BusinessTests;

import Business.Pelicula;
import Business.PlanificationStrategy.EstrategiaInfantil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
              PELICULA      | ES       |  ¿ES   | ¿GENERO   | < 130   | PUNTAJE | PRIORIDAD
                            | INFANTIL |   ATP? | FAMILIAR? | MINUTOS | TOTAL   |
        ------------------------------------------------------------------------------------
        Black Widow         |    0     |   20   |    10     |    0    |   30    |   MEDIA
        Volver Al Futuro    |    20    |   20   |    10     |    5    |   55    |   ALTA
        Ratatouille         |    20    |   20   |    10     |    5    |   55    |   ALTA
        Joker               |    0     |   0    |    0      |    5    |   5     |   BAJA
        Snatch              |    0     |   0    |    10     |    5    |   15    |   MEDIA
        Cape Fear           |    0     |   0    |    0      |    5    |   5     |   BAJA
        Catch Me If You Can |    0     |   20   |    10     |    0    |   30    |   MEDIA

        ALTA:   (30;inf)
        MEDIA:  [15;30]
        BAJA:   [0;15)
*/

public class EstrategiaInfantilTest extends TestResources {

    private EstrategiaInfantil estrategiaInfantil;
    private List<Pelicula> peliculas;

    @Before
    public void inicializar() {
        this.inicializarPeliculas();
        this.estrategiaInfantil = new EstrategiaInfantil();
        this.peliculas = Stream.of(blackWidow, volverAlFuturo, ratatouille, joker, snatch, capeFear, catchMeIfYouCan).collect(Collectors.toList());
    }

    @Test
    public void hay2PeliculasDePrioridadALTA() {
        Assert.assertEquals(2, estrategiaInfantil.seleccionarPrioridadALTA(peliculas).size());
    }

    @Test
    public void hay3Peliculas1DePrioridadMEDIA() {
        Assert.assertEquals(3, estrategiaInfantil.seleccionarPrioridadMEDIA(peliculas).size());
    }

    @Test
    public void hay2PeliculasDePrioridadBAJA() {
        Assert.assertEquals(2, estrategiaInfantil.seleccionarPrioridadBAJA(peliculas).size());
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
    public void capeFearEsDePrioridadBaja() {
        Assert.assertTrue(estrategiaInfantil.seleccionarPrioridadBAJA(peliculas).contains(capeFear));
    }

}
