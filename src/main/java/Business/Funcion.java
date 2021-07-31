package Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.Float.sum;

@Data
@AllArgsConstructor
public class Funcion {

    private Map<Asiento,Boolean> disponibilidad;
    private Pelicula pelicula;
    private Date fecha;
    private Sala sala;

    public int comprarAsientos(List<Asiento> asientos) {
        this.ocuparAsientos(asientos);
        return sala.precioAsientos(asientos);
    }

    private void ocuparAsientos(List<Asiento> asientos) {
        // Buscar por Key asiento y poner False a la disponibilidad
    }


}
