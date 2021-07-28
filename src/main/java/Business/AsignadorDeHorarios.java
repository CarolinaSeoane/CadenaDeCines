package Business;

import Business.SusbcribersObserver.Notificador;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsignadorDeHorarios {

    private Notificador notificador;

    public void asignarHorarios(){



        //Despues de asignar, avisa que hay nuevas funciones
        notificador.notificar();
    }

}
