package Business.Composite;

import Business.Cadena;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Combo implements Producto {

    private String nombre;
    private List<Producto> productos;

    @Override
    public int getPrecio() {
        Cadena cadena = Cadena.getInstance();
        return (int) Math.ceil(this.precioCombo() - (this.precioCombo() * cadena.getDescuentoPorCombo() / 100));
    }

    private int precioCombo() {
        return this.productos.stream().mapToInt(unProducto -> unProducto.getPrecio()).sum();
    }

}
