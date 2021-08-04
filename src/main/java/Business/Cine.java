package Business;

import Security.Administrador;
import Security.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Cine {

    private String nombre;
    private String direccion;
    // private List<Administrador> administradores;
    private Map<Sala, List<Funcion>> funciones;
    private AsignadorDeHorarios asignadorDeHorarios;

/*
    public Reserva comprarEntradas(Usuario usr, Funcion funcion, List<Asiento> asientos, List<Producto> productos) {
        float precioAsientos = funcion.comprarAsientos(asientos);

        return reserva;
    }
*/

    public void recibirPeliculas(List<Pelicula> peliculas) {
        asignadorDeHorarios.recibirPeliculas(peliculas);
    }

    public void realizarPlanificacionSemanal() {
        this.funciones = asignadorDeHorarios.asignarHorarios(funciones);
    }

    // Metodos para Tests
    public int cantidadDeFunciones() {
        int total = 0;
        for (Map.Entry<Sala, List<Funcion>> entrada : this.funciones.entrySet()) {
            List<Funcion> funciones = entrada.getValue();
            total += funciones.size();
        }
        return total;
    }

    public int cantidadDeFuncionesPorSala(Sala sala){
        List<Funcion> funciones = this.funciones.get(sala);
        return funciones.size();
    }

    public String buscarPeliculaPorHora(Sala unaSala, int unHorario){
        List<Funcion> funciones = this.funciones.get(unaSala);
        String resultado = "No se encontró película en ese horario";
        for(Funcion funcion: funciones){
            if(funcion.getFecha().getHourOfDay() == unHorario){
                resultado = funcion.getPelicula().getTitulo();
            }
        }
        return resultado;
    }
}