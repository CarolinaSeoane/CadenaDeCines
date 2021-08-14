package ServiceTests;

import Services.OMDB.WebServiceClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class OMDBTests {

    private WebServiceClient webServiceClient;

    @Before
    public void inicializar() {
        this.webServiceClient = new WebServiceClient();
    }

    @Test
    public void obtengoActoresYDuracionDeBlackWidowComoStrings() throws IOException {
        String actores = "Scarlett Johansson, Florence Pugh, David Harbour";
        Assert.assertEquals(actores, webServiceClient.ejecutar("black widow").getActors());
        Assert.assertEquals("134 min", webServiceClient.ejecutar("black widow").getRuntime());
    }

    @Test
    public void obtengoRatingDeIMDBDeJumanji() throws IOException {
        Assert.assertEquals("7.0", webServiceClient.ejecutar("Jumanji").getImdbRating());
    }

}
