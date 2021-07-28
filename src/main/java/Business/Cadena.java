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
    private List<Usuario> usuarios;
    private List<SuperAdministrador> superAdministradores;
    private List<Producto> productos;
    private Planificador planificacionActual;
    private int porcentajeGanancia;

    //SINGLETON

    private static Cadena instance = null;

    private Cadena() {}

    public static Cadena getInstance() {
        if (instance == null) {
            instance = new Cadena();
            instance.cines = new ArrayList<>();
            instance.peliculas = new ArrayList<>();
            instance.usuarios = new ArrayList<>();
            instance.superAdministradores = new ArrayList<>();
            instance.productos = new ArrayList<>();
        }
        return instance;
    }

    public void elegirPlanificacion(int valor){ //Provisorio. Definir cómo queremos que se setee
        if(valor == 1){
            planificacionActual = new PlanificadorA();
        }else{
            planificacionActual = new PlanificadorB();
        }
    }

    public void planificarPeliculas(){
        planificacionActual.planificar();
    }
}
