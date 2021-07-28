package Business;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
public class Funcion {

    private Map<Asiento,Boolean> disponibilidad;
    private Pelicula pelicula;
    private Date fecha;

}
