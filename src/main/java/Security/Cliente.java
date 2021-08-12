package Security;

import Business.Reserva;
import Security.Plan.Plan;

import java.util.List;

public class Cliente extends Usuario {

    private List<Reserva> reservas;
    private Plan plan;

}
