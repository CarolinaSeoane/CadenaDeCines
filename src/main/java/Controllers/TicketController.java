package Controllers;

import Business.*;
import Business.Composite.Producto;
import Security.Cliente;
import java.util.List;
import java.util.UUID;

/* Para evitar realizar la interaccion con el usuario (que aun no hemos visto en clase) decidimos que el metodo
 * ejecutar(...) reciba como parametro aquellos objetos que necesitara para realizar la compra de la entrada.
 * Esto tambien nos permitira realizar los tests correspondientes.
 */

public class TicketController {

    public void ejecutar(Cliente cliente, Funcion funcion, List<Asiento> asientos, List<Producto> productos) {
        int precioAsientos = funcion.comprarAsientos(asientos);
        int precioProductos = this.calcularPrecioProductos(productos);
        int porcentajeGanancia = Cadena.getInstance().getPorcentajeGanancia();
        String cod_reserva = this.generarCodigoReserva();
        int descuento = cliente.getDescuento();

        int precioFinal = this.calcularPrecioFinal(precioAsientos + precioProductos, porcentajeGanancia - descuento);
        Reserva reserva = new Reserva(funcion, asientos, productos, precioFinal, cod_reserva);
        cliente.guardarReserva(reserva);
    }

    public int calcularPrecioProductos(List<Producto> productos) {
        return productos.stream().mapToInt(producto -> producto.getPrecio()).sum();
    }

    public String generarCodigoReserva() {
        return UUID.randomUUID().toString();
    }

    public int calcularPrecioFinal(int costo, int porcentajeGanancia) {
        return costo + ((costo * porcentajeGanancia) / 100);
    }

}
