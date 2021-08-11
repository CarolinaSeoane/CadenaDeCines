package Business;

import Business.Composite.Producto;
import Security.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Reserva {

    private Usuario usuario;
    private Funcion funcion;
    private List<Asiento> asientos;
    private List<Producto> productos;
    private float costoTotal;
    private String codigoDeReserva;

}
