package Business.SusbcribersObserver;

import lombok.Data;

import java.util.List;

@Data
public class Notificador {

    private List<Suscriptor> suscriptores;

    public void notificar(){
        for(Suscriptor unSuscriptor : suscriptores){
            unSuscriptor.update();
        }
    }

}
