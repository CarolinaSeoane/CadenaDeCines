package SecurityTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTests extends TestResources {

    @Before
    public void inicializar() {
        this.inicializarPersonas();
        this.inicializarPeliculas();
        this.inicializarUsuarios();
    }

    @Test
    public void facuPublicaComentarioEnBlackWidow() {
        userFacu.publicarComentario("Buena", 4, blackWidow);
        Assert.assertEquals(2, blackWidow.getComentarios().size());
    }

    @Test
    public void carolinaNoPublicaComentarioEnCapeFearPorqueNoEsPremium() {
        userCaro.publicarComentario("Muy buena", 5, capeFear);
        Assert.assertEquals(1, capeFear.getComentarios().size());
    }

}
