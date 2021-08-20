package Business.Composite;

import Business.Enums.Tamanio;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoSimple implements Producto {

    private String nombre;
    private Tamanio tamanio;
    private int precio;

}
