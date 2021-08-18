package BusinessTests;

import Business.Cadena;
import Resources.TestResources;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class NotificadorTest extends TestResources {

    private Cadena cadena;

    @Before
    public void inicializar() throws IOException {
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarPersonas();
        this.inicializarUsuarios();
        this.cadena = inicializarCadena();
        planificador.planificar();
    }

    @Test
    public void losDosSeSuscribenAlCineA(){
        userCaro.suscribirseA(cineA);
        userFacu.suscribirseA(cineA);
        cineA.realizarPlanificacionSemanal();
    }

    @Test
    public void facuSeSuscribeAlCineB(){
        userFacu.suscribirseA(cineB);
        cineB.realizarPlanificacionSemanal();
    }

    @Test
    public void nadieSeSuscribeAlCineC(){
        cineC.realizarPlanificacionSemanal();
    }
}
