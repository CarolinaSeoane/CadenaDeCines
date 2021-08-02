package Business;

import Business.PlanificationStrategy.*;
import Security.SuperAdministrador;
import Security.Usuario;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cadena {

    private List<Cine> cines;
    private List<Pelicula> peliculas;
    //private List<Usuario> usuarios;
    //private List<SuperAdministrador> superAdministradores;
    //private List<Producto> productos;
    private int porcentajeGanancia;


    /*  *****   *****   Singleton   *****   *****   */

    private static Cadena instance = null;

    private Cadena() {}

    public static Cadena getInstance() {
        if (instance == null) {
            instance = new Cadena();
            instance.cines = new ArrayList<>();
            instance.peliculas = new ArrayList<>();
            //instance.usuarios = new ArrayList<>();
            //instance.superAdministradores = new ArrayList<>();
            //instance.productos = new ArrayList<>();
        }
        return instance;
    }

    /*  *****   *****   Fin Singleton   *****   *****   */

}
