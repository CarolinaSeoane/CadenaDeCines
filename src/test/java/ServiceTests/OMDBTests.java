package ServiceTests;

import Services.OMDB.WebServiceClient;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/* Despues los borro, era para ver algo nomas
* */

public class OMDBTests {

    private WebServiceClient webServiceClient;

    @Before
    public void inicializar() {
        this.webServiceClient = new WebServiceClient();
    }

    @Test
    public void obtengoActoresDeBlackWidow() throws IOException {
        String actores = webServiceClient.ejecutar("black widow").getActors();
        System.out.print(actores);
    }

    @Test
    public void obtengoDescripcionDeTitanic() throws IOException {
        String descripcion = webServiceClient.ejecutar("titanic").getPlot();
        System.out.print(descripcion);
    }

}
