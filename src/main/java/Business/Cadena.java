package Business;

import Business.Composite.Producto;
import Security.SuperAdministrador;
import Security.Usuario;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cadena {

    private List<Cine> cines;
    private List<Pelicula> peliculas;
    private List<Usuario> usuarios;
    private List<SuperAdministrador> superAdmins;
    private List<Producto> productos;
    private int porcentajeGanancia;
    private int descuentoPorCombo;


    /*  *****   *****   Singleton   *****   *****   */

    private static Cadena instance = null;

    private Cadena() {}

    public static Cadena getInstance() {
        if (instance == null) {
            instance = new Cadena();
            instance.cines = new ArrayList<>();
            instance.peliculas = new ArrayList<>();
            instance.usuarios = new ArrayList<>();
            instance.superAdmins = new ArrayList<>();
            instance.productos = new ArrayList<>();
        }
        return instance;
    }

    /*  *****   *****   Fin Singleton   *****   *****   */

    public void agregarPelicula(Pelicula unaPelicula){
        if(!this.tienePeli(unaPelicula.getTitulo())){
            peliculas.add(unaPelicula);
        }
    }

    public Pelicula getPeli(String unTitulo) {
        return peliculas.stream().filter(unaPeli -> unTitulo.equals(unaPeli.getTitulo())).findAny().orElse(null);
    }

    public Boolean tienePeli(String unTitulo) {
        return peliculas.stream().anyMatch(unaPeli -> unTitulo.equals(unaPeli.getTitulo()));
    }

    public void agregarSuperAdmin(SuperAdministrador superAdministrador) {
        superAdmins.add(superAdministrador);
    }

    public void eliminarSuperAdmin(SuperAdministrador superAdministrador) {
        superAdmins.remove(superAdministrador);
    }

}
