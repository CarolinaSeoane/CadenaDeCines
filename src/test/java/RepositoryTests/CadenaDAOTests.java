package RepositoryTests;

import Resources.DBResources;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

public class CadenaDAOTests extends DBResources {

    @Before
    public void inicializar() throws SQLException {
        createTablas();
    }

    @Test
    public void actualizoPorcentajeGananciaA100() {

    }

}
