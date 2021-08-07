package BusinessTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FuncionTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarPeliculas();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarFunciones();
    }

    @Test
    public void funcionA_A1_blackWidowTieneAsientoA1_A1Disponible() {
        Assert.assertTrue(funcionA_A1_blackWidow.estaDisponible(A1_A1));
    }

    @Test
    public void ocupoAsientoA1_A1DeLaFuncionYSuPrecioEs300() {
        Assert.assertEquals(300, funcionA_A1_blackWidow.comprarAsientos(Stream.of(A1_A1).collect(Collectors.toList())));
        Assert.assertFalse(funcionA_A1_blackWidow.estaDisponible(A1_A1));
    }

    @Test
    public void ocupoAsientosFuncionYSuPrecioTotalEs800() {
        Assert.assertEquals(800, funcionA_A1_blackWidow.comprarAsientos(Stream.of(A1_A1, A1_A2).collect(Collectors.toList())));
        Assert.assertFalse(funcionA_A1_blackWidow.estaDisponible(A1_A1));
        Assert.assertFalse(funcionA_A1_blackWidow.estaDisponible(A1_A2));
    }

}
