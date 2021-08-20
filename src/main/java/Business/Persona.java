package Business;

import Business.Enums.TipoDoc;
import Business.SusbcribersObserver.Suscriptor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona implements Suscriptor {

    private String nombre;
    private String apellido;
    private TipoDoc tipoDoc;
    private int nroDoc;
    private String email;

    @Override
    public String update() {
        return this.email;
    }

}
