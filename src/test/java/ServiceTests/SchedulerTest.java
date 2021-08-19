package ServiceTests;

import Resources.TestResources;
import Services.SchedulerService.QuartzScheduler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class SchedulerTest extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarAsignadoresDeHorarios();
        this.inicializarCines();
        this.inicializarPlanificador();
        this.inicializarPersonas();
        this.inicializarCadena();
    }

    @Test
    public void seEjecutaLaPlanificacionEnTalHorario() throws Exception {
        String fecha = "0 53 22 ? * 4"; // Cuando se pruebe, setearlo para 1 minuto despues de la hora actual.
        QuartzScheduler scheduler = new QuartzScheduler();
        scheduler.setCRON_EXPRESSION(fecha);
        scheduler.ejecutar();
        Thread.sleep(90000); // Esto hace que el hilo main se frene un poco mas de un minuto
        Assert.assertEquals(6, cineC.getAsignadorDeHorarios().getPeliculas().size());
    }

}
