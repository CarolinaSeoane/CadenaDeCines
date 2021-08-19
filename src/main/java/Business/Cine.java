package Business;

import Business.SusbcribersObserver.Notificador;
import Security.Administrador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Cine {

    private String nombre;
    private String direccion;
    private List<Administrador> administradores;
    private Map<Sala, List<Funcion>> funciones;
    private AsignadorDeHorarios asignadorDeHorarios;
    private Notificador notificador;

    public void recibirPeliculas(List<Pelicula> peliculas) {
        asignadorDeHorarios.recibirPeliculas(peliculas);
    }

    @SneakyThrows
    public void realizarPlanificacionSemanal() {
        asignadorDeHorarios.asignarHorarios(funciones);
        notificador.notificar();
    }

    public void suscribir(String unEmail){
        notificador.agregarSuscriptor(unEmail);
    }

    public void desuscribir(String unEmail){
        notificador.eliminarSuscriptor(unEmail);
    }

    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public void eliminarAdministrador(Administrador administrador) {
        administradores.remove(administrador);
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
        String resultado = "No dan esa película en ese horario";
        for(Funcion funcion: funciones){
            if(funcion.getFecha().getHourOfDay() == unHorario){
                resultado = funcion.getPelicula().getTitulo();
            }
        }
        return resultado;
    }

}