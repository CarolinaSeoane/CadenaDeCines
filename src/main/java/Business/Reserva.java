package Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Reserva {

    private Funcion funcion;
    private List<Asiento> asientos;
    private String productos;
    private int costoTotal;
    private String codigoDeReserva;

}
