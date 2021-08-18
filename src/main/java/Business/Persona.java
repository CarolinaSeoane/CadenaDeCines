package Business;

import Business.Enums.TipoDoc;
import Business.SusbcribersObserver.Suscriptor;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Persona implements Suscriptor {

    private String nombre;
    private String apellido;
    private Date fechaDeNacimiento;
    private TipoDoc tipoDoc;
    private int nroDoc;
    private String email;

    @Override
    public String update() {
        return this.email;
    }

}
