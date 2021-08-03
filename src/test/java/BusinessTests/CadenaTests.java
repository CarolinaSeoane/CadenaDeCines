package BusinessTests;

import org.junit.Before;

public class CadenaTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarPeliculas();
        this.inicializarAsientos();
        this.inicializarSalas();
        this.inicializarCines();
        this.inicializarCadena();
    }

}
