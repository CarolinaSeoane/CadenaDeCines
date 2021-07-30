package BusinessTests;

import org.junit.Assert;
import org.junit.Test;
import static Business.Enums.Genero.*;

public class PeliculasTests extends TestResources {

    @Test
    public void blackWidowEsDeAccion() {
        Assert.assertEquals(true, blackWidow.esDeGenero(ACCION));
    }

    @Test
    public void elAsientoEs1a() {
        Assert.assertEquals("1A", asiento.getNroAsiento());
    }

}

