package ControllersTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicketControllerTests extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarCadena();
        this.inicializarPeliculas();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarProductos();
        this.inicializarFunciones();
        this.inicializarTicketController();
        this.inicializarUsuarios();
    }

    @Test
    public void elPrecioDeCombo1yCombo2Es1573() {
        Assert.assertEquals(1573, ticketController.calcularPrecioProductos(Stream.of(combo1, combo2).collect(Collectors.toList())));
    }

    @Test
    public void elPrecioDeLosProductosEs1678() {
        Assert.assertEquals(1678, ticketController.calcularPrecioProductos(Stream.of(gaseosaGrande, combo3, nachosMedianos).collect(Collectors.toList())));
    }

    @Test
    public void facuCompraEntradaSinProductosYConDescuento() {
        ticketController.ejecutar(userFacu, funcionA_A1_blackWidow, Stream.of(A1_A1).collect(Collectors.toList()), new ArrayList<>());
        // Precio Asientos              = $300
        // Precio Productos             = $0
        // Precio Porcentaje ganacia    = 100%
        // Descuento por ser Premium    = 20%
        // PRECIO FINAL                 = 300 + (300 * 0.8) = 480
        Assert.assertEquals(540, userFacu.getReservas().stream().findFirst().get().getCostoTotal());
    }

    @Test
    public void facuCompra2EntradasConProductosYConDescuento() {
        ticketController.ejecutar(userFacu, funcionA_A1_blackWidow, Stream.of(A1_A1, A1_A2).collect(Collectors.toList()), Stream.of(combo1, combo2).collect(Collectors.toList()));
        // Precio Asientos              = $800
        // Precio Productos             = $1573
        // Precio Porcentaje ganacia    = 100%
        // Descuento por ser Premium    = 20%
        // PRECIO FINAL                 = 2373 + (2373 * 0.8) = 4271,4 = 4271
        Assert.assertEquals(4271, userFacu.getReservas().stream().findFirst().get().getCostoTotal());
    }

    @Test
    public void carolinaCompra2EntradasConProductosYSinDescuento() {
        ticketController.ejecutar(userCaro, funcionA_A1_blackWidow, Stream.of(A1_A1, A1_A2).collect(Collectors.toList()), Stream.of(gaseosaGrande).collect(Collectors.toList()));
        // Precio Asientos              = $800
        // Precio Productos             = $300
        // Precio Porcentaje ganacia    = 100%
        // Descuento por ser Premium    = 0%
        // PRECIO FINAL                 = 1100 + 1100 = 2200
        Assert.assertEquals(2200, userCaro.getReservas().stream().findFirst().get().getCostoTotal());
    }

}
