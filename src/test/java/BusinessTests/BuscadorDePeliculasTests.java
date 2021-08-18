package BusinessTests;

import Business.Cadena;
import Business.BuscadorDePeliculas;
import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class BuscadorDePeliculasTests extends TestResources {

    private BuscadorDePeliculas peliculasController;

    @Before
    public void inicializar() {
        Cadena cadena = inicializarCadena();
        peliculasController = new BuscadorDePeliculas();
    }

    @Test
    public void TitanicDura194Minutos() throws IOException {
        peliculasController.ejecutar("Titanic");
        Assert.assertEquals(194, cadena.getPeli("Titanic").getDuracion());
    }

    @Test
    public void SeAgregaForrestGump() throws IOException {
        peliculasController.ejecutar("Forrest Gump");
        Assert.assertTrue(cadena.tienePeli("Forrest Gump"));
    }

    @Test
    public void RatatouilleEsATP() throws IOException {
        peliculasController.ejecutar("Ratatouille");
        Assert.assertTrue(cadena.getPeli("Ratatouille").getATP());
    }

    @Test
    public void ScarfaceNoEsATP() throws IOException {
        peliculasController.ejecutar("Scarface");
        Assert.assertFalse(cadena.getPeli("Scarface").getATP());
    }

}
