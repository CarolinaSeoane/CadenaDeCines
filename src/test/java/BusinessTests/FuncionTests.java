package BusinessTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

}
