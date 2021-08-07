package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static Business.Enums.Genero.*;

public class PeliculasTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarPeliculas();
    }

    @Test
    public void blackWidowEsDeAccion() {
        Assert.assertEquals(true, blackWidow.esDeGenero(ACCION));
    }

    @Test
    public void ratatouilleEsInfantil() {
        Assert.assertEquals(true, ratatouille.esDeGenero(INFANTIL));
    }

    @Test
    public void jokerNoEsATP() {
        Assert.assertFalse(joker.getATP());
    }

    @Test
    public void capeFearDura128Minutos() {
        Assert.assertEquals(128, capeFear.getDuracion());
    }

}

