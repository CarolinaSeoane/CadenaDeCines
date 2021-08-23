package RepositoryTests;

import Resources.DBResources;
import org.junit.Test;
import java.sql.SQLException;

public class PersistenciaTests extends DBResources {

    @Test
    public void seCreanLasTablasConDatosIniciales() throws SQLException {
        createTablas();
    }

}
