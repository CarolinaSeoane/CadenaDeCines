package ControllersTests;

import Controllers.TicketController;
import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicketControllerTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarCadena();
        this.inicializarPeliculas();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarProductos();
        this.inicializarFunciones();
        this.inicializarTicketController();
    }

    @Test
    public void elPrecioDeCombo1yCombo2Es1573() {
        Assert.assertEquals(1573, ticketController.calcularPrecioProductos(Stream.of(combo1, combo2).collect(Collectors.toList())));
    }

    @Test
    public void elPrecioDeLosProductosEs1678() {
        Assert.assertEquals(1678, ticketController.calcularPrecioProductos(Stream.of(gaseosaGrande, combo3, nachosMedianos).collect(Collectors.toList())));
    }

}
