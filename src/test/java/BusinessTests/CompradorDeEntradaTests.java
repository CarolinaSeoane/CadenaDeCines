package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompradorDeEntradaTests extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarCadena();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarProductos();
        this.inicializarFunciones();
        this.inicializarTicketController();
        this.inicializarUsuarios();
    }

    @Test
    public void elPrecioDeCombo1yCombo2Es1573() {
        Assert.assertEquals(1573, compradorDeEntrada.calcularPrecioProductos(Stream.of(combo1, combo2).collect(Collectors.toList())));
    }

    @Test
    public void elPrecioDeLosProductosEs1678() {
        Assert.assertEquals(1678, compradorDeEntrada.calcularPrecioProductos(Stream.of(gaseosaGrande, combo3, nachosMedianos).collect(Collectors.toList())));
    }

    @Test
    public void facuCompraEntradaSinProductosYConDescuento() {
        compradorDeEntrada.ejecutar(userFacu, funcionA_A1_blackWidow, Stream.of(A1_A1).collect(Collectors.toList()), new ArrayList<>());
        // Precio Asientos              = $300
        // Precio Productos             = $0
        // Precio Porcentaje ganacia    = 100%
        // Descuento por ser Premium    = 20%
        // PRECIO FINAL                 = 300 + (300 * 0.8) = 480
        Assert.assertEquals(540, userFacu.getReservas().stream().findFirst().get().getCostoTotal());
    }

    @Test
    public void facuCompra2EntradasConProductosYConDescuento() {
        compradorDeEntrada.ejecutar(userFacu, funcionA_A1_blackWidow, Stream.of(A1_A1, A1_A2).collect(Collectors.toList()), Stream.of(combo1, combo2).collect(Collectors.toList()));
        // Precio Asientos              = $800
        // Precio Productos             = $1573
        // Precio Porcentaje ganacia    = 100%
        // Descuento por ser Premium    = 20%
        // PRECIO FINAL                 = 2373 + (2373 * 0.8) = 4271,4 = 4271
        Assert.assertEquals(4271, userFacu.getReservas().stream().findFirst().get().getCostoTotal());
    }

    @Test
    public void carolinaCompra2EntradasConProductosYSinDescuento() {
        compradorDeEntrada.ejecutar(userCaro, funcionA_A1_blackWidow, Stream.of(A1_A1, A1_A2).collect(Collectors.toList()), Stream.of(gaseosaGrande).collect(Collectors.toList()));
        // Precio Asientos              = $800
        // Precio Productos             = $300
        // Precio Porcentaje ganacia    = 100%
        // Descuento por ser Premium    = 0%
        // PRECIO FINAL                 = 1100 + 1100 = 2200
        Assert.assertEquals(2200, userCaro.getReservas().stream().findFirst().get().getCostoTotal());
    }

    @Test
    public void generoNombrePochoclosYNachos() {
        Assert.assertEquals("Pochoclos Chicos - Nachos Medianos", compradorDeEntrada.generarNombreProductos(Stream.of(pochocloChico, nachosMedianos).collect(Collectors.toList())));
    }

    @Test
    public void generoNombreCuandoNoHayProductos() {
        Assert.assertEquals("", compradorDeEntrada.generarNombreProductos(new ArrayList<>()));
    }

    @Test
    public void generoNombreCombo1() {
        Assert.assertEquals("Combo 1", compradorDeEntrada.generarNombreProductos(Stream.of(combo1).collect(Collectors.toList())));
    }

    @Test
    public void generoNombreCombo1Combo2YGaseosaGrande() {
        Assert.assertEquals("Combo 1 - Combo 2 - Gaseosa Grande", compradorDeEntrada.generarNombreProductos(Stream.of(combo1, combo2, gaseosaGrande).collect(Collectors.toList())));
    }

}
