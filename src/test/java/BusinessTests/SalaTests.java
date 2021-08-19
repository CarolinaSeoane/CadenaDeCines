package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalaTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarAsientos();
        this.inicializarSalas();
    }

    @Test
    public void elPrecioDeLosAsientosA1_A1yA1_A2Es800() {
        Assert.assertEquals(800, salaA1.precioAsientos(salaA1.getAsientos()));
    }

    @Test
    public void elPrecioDelAsientoB2_A2Es600() {
        Assert.assertEquals(600, salaA1.precioAsientos(Stream.of(B2_A2).collect(Collectors.toList())));
    }

}
