package Business;

import Business.Enums.Genero;
import Business.Enums.TipoDoc;
import Business.SusbcribersObserver.Suscriptor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Persona implements Suscriptor {

    private String nombre;
    private String apellido;
    private Date fechaDeNacimiento;
    private TipoDoc tipoDoc;
    private int nroDoc;
    private String email;
    private List<Reserva> reservas;
    private List<Genero> generosPreferidos;


    @Override
    public void update() {

    }
}
