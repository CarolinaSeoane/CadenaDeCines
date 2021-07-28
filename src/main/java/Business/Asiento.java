package Business;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asiento {

    private float precio;
    private String nroAsiento;
    private Boolean habilitado;


}
