package BusinessTests;

import Resources.TestResources;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class PeliculasTests extends TestResources {

    @Before
    public void inicializar() throws IOException {
        this.inicializarComentarios();
        this.inicializarCadena();
    }

    @Test
    public void blackWidowTieneRatingMayorA6() {
        Assert.assertEquals(true, blackWidow.tieneRatingMayorOIgualA(6.0));
    }

    @Test
    public void jokerNoEsATP() {
        Assert.assertFalse(joker.getATP());
    }

    @Test
    public void capeFearDura128Minutos() {
        Assert.assertEquals(128, capeFear.getDuracion());
    }

    @Test
    public void agrego2ComentariosABlackWidowYTiene2() {
        blackWidow.addComentario(com_3);
        blackWidow.addComentario(com_4);
        Assert.assertEquals(2, blackWidow.getComentarios().size());
        Assert.assertEquals(2, cadena.getPeli("Black Widow").getComentarios().size());
    }

}

