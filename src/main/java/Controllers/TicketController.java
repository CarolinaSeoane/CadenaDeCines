package Controllers;

/* Para evitar realizar la interaccion con el usuario (que aun no hemos visto en clase) decidimos que el metodo
 * ejecutar(...) reciba como parametro aquellos objetos que necesitara para realizar la compra de la entrada.
 * Esto tambien nos permitira realizar los tests correspondientes.
 */

import Business.*;
import Security.Usuario;

import java.util.List;
import java.util.UUID;

public class TicketController {

    public void ejecutar(Usuario usr, Funcion funcion, List<Asiento> asientos, List<Producto> productos) {
        int precioAsientos = funcion.comprarAsientos(asientos);
        int precioProductos = this.calcularPrecioProductos(productos);

        int porcentajeGanancia = Cadena.getInstance().getPorcentajeGanancia();
        String id = this.generarIdTicket();

        int precio = this.calcularPrecioFinal(precioAsientos + precioProductos, porcentajeGanancia);

        Reserva reserva = new Reserva(usr, funcion, asientos, productos, precio, id);

    }


    public int calcularPrecioProductos(List<Producto> productos) {
        return productos.stream().mapToInt(producto -> producto.getPrecio()).sum();
    }

    public String generarIdTicket() {
        return UUID.randomUUID().toString();
    }

    public int calcularPrecioFinal(int costo, int ganancia) {
        return costo + ((costo * ganancia) / 100);
    }

}
