package RepositoryTests;

import Repository.AdministradorDAO;
import Resources.DBResources;
import Security.Administrador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

public class AdministradorDAOTests extends DBResources {

    @Before
    public void inicializar() throws SQLException {
        createCadena();
        createCine();
        createAdmin();
        this.inicializarAdministradores();
    }

    @Test
    public void insertoAdminCaro() {
        AdministradorDAO adminDAO = new AdministradorDAO();
        adminDAO.INSERTAdmin(adminCaro);
        Administrador adminCaro2 = adminDAO.SELECTAdmin(adminCaro.getNombreUsuario());
        Assert.assertEquals(adminCaro2.getPersona().getApellido(), adminCaro.getPersona().getApellido());
    }

}
