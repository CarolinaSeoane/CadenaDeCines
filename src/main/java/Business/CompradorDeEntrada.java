package Business;

import Business.Composite.Producto;
import Security.Cliente;
import java.util.List;
import java.util.UUID;

/* Para evitar realizar la interaccion con el usuario (que aun no hemos visto en clase) decidimos que el metodo
 * ejecutar(...) reciba como parametro aquellos objetos que necesitara para realizar la compra de la entrada.
 * Esto tambien nos permitira realizar los tests correspondientes.
 */

public class CompradorDeEntrada {

    public void ejecutar(Cliente cliente, Funcion funcion, List<Asiento> asientos, List<Producto> productos) {
        int precioAsientos = funcion.comprarAsientos(asientos);
        int precioProductos = this.calcularPrecioProductos(productos);
        int porcentajeGanancia = Cadena.getInstance().getPorcentajeGanancia();
        String cod_reserva = this.generarCodigoReserva();
        String productosTotales = this.generarNombreProductos(productos);
        int descuento = cliente.getDescuento();
        int precioFinal = this.calcularPrecioFinal(precioAsientos + precioProductos, porcentajeGanancia - descuento);

        Reserva reserva = new Reserva(funcion, asientos, productosTotales, precioFinal, cod_reserva);
        cliente.guardarReserva(reserva);
    }

    public int calcularPrecioProductos(List<Producto> productos) {
        return productos.stream().mapToInt(producto -> producto.getPrecio()).sum();
    }

    private String generarCodigoReserva() {
        return UUID.randomUUID().toString();
    }

    private int calcularPrecioFinal(int costo, int porcentajeGanancia) {
        return costo + ((costo * porcentajeGanancia) / 100);
    }

    public String generarNombreProductos(List<Producto> productos) {
        String nombre = new String();
        if (!productos.isEmpty()) {
            for(int i = 0; i < productos.size(); i++) {
                nombre = nombre + productos.get(i).getNombre() + " - ";
            }
        }
        return sacarCaracterDeSobra(nombre);
    }

    private String sacarCaracterDeSobra(String cadena) {
        if(cadena.endsWith(" - ")) {
            return cadena.substring(0, cadena.length() - 3);
        } else {
            return cadena;
        }
    }

}
