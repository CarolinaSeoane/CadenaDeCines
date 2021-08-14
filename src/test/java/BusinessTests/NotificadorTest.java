package BusinessTests;

import Resources.TestResources;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class NotificadorTest extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarPersonas();
        this.inicializarCadena();
        planificador.planificar();
    }

    @Test
    public void losDosSeSuscribenAlCineA(){
        caro.suscribirseA(cineA);
        facu.suscribirseA(cineA);
        cineA.realizarPlanificacionSemanal();
    }

    @Test
    public void facuSeSuscribeAlCineB(){
        facu.suscribirseA(cineB);
        cineB.realizarPlanificacionSemanal();
    }

    @Test
    public void nadieSeSuscribeAlCineC(){
        cineC.realizarPlanificacionSemanal();
    }
}
