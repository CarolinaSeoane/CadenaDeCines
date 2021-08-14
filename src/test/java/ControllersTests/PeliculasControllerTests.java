package ControllersTests;

import Business.Cadena;
import Controllers.PeliculasController;
import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class PeliculasControllerTests extends TestResources {

    private PeliculasController peliculasController;

    @Before
    public void inicializar() {
        inicializarCadena();
        peliculasController = new PeliculasController();
    }

    @Test
    public void TitanicDura194Minutos() throws IOException {
        peliculasController.ejecutar("Titanic");
        Assert.assertEquals(194, Cadena.getInstance().getPeli("Titanic").getDuracion());
    }

    @Test
    public void SeAgregaForrestGump() throws IOException {
        peliculasController.ejecutar("Forrest Gump");
        Assert.assertTrue(Cadena.getInstance().tienePeli("Forrest Gump"));
    }

    @Test
    public void RatatouilleEsATP() throws IOException {
        peliculasController.ejecutar("Ratatouille");
        Assert.assertTrue(Cadena.getInstance().getPeli("Ratatouille").getATP());
    }

    @Test
    public void ScarfaceNoEsATP() throws IOException {
        peliculasController.ejecutar("Scarface");
        Assert.assertFalse(Cadena.getInstance().getPeli("Scarface").getATP());
    }

}
