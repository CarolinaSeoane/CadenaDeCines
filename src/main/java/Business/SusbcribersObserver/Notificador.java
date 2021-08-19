package Business.SusbcribersObserver;

import Services.EmailService.EmailCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import javax.mail.internet.InternetAddress;
import java.util.List;

@Data
@AllArgsConstructor
public class Notificador {

    private List<String> suscriptores;

    @SneakyThrows
    public void notificar() {
        if(suscriptores.isEmpty()){
        }else {
            EmailCreator emailCreator = new EmailCreator();
            InternetAddress[] destinatarios = new InternetAddress[suscriptores.size()];
            int i = 0;
            for (String email : suscriptores) {
                destinatarios[i] = new InternetAddress(email);
                i++;
            }
            emailCreator.mandarEmail(destinatarios);
        }
    }

    public void agregarSuscriptor(String unEmail) {
        suscriptores.add(unEmail);
    }

    public void eliminarSuscriptor(String unEmail) {
        suscriptores.remove(unEmail);
    }

}
