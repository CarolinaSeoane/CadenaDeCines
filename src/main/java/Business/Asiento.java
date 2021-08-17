package Business;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asiento {

    private int precio;
    private String nroAsiento;
    private Boolean habilitado;

}
