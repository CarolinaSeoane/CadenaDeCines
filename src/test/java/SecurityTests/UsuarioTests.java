package SecurityTests;

import Business.Comentario;
import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class UsuarioTests extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarPersonas();
        this.inicializarUsuarios();
        this.inicializarCadena();
    }

    @Test
    public void facuPublicaComentarioEnBlackWidow() {
        Comentario com = new Comentario(userFacu.getNombreUsuario(), "Buena", 4);
        userFacu.publicarComentario(com, blackWidow);
        Assert.assertTrue(blackWidow.getComentarios().contains(com));
    }

    @Test
    public void carolinaNoPublicaComentarioEnCapeFearPorqueNoEsPremium() {
        Comentario com = new Comentario(userCaro.getNombreUsuario(), "Muy buena", 4);
        userCaro.publicarComentario(com, capeFear);
        Assert.assertTrue(!capeFear.getComentarios().contains(com));
    }

}
