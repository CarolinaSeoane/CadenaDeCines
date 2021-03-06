package Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Funcion {

    private Map<Asiento,Boolean> disponibilidad;
    private String pelicula;
    private DateTime fecha;
    private Sala sala;

    public int comprarAsientos(List<Asiento> asientos) {
        this.ocuparAsientos(asientos);
        return sala.precioAsientos(asientos);
    }

    private void ocuparAsientos(List<Asiento> asientos) {
        asientos.forEach((asiento) -> {this.ocuparAsiento(asiento);});
    }

    private void ocuparAsiento(Asiento asiento) {
        if(disponibilidad.containsKey(asiento) && this.estaDisponible(asiento)) {
            disponibilidad.put(asiento, false);
        }
    }

    public Boolean estaDisponible(Asiento unAsiento) {
        return disponibilidad.get(unAsiento);
    }

}
