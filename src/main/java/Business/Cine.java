package Business;

import Business.SusbcribersObserver.Notificador;
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
    // private List<Administrador> administradores;
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

    // Este método es solo para mostrar algo lindo por pantalla en los Test. Despues se puede borrar
    public void mostrarFunciones() {
        /*
        --------------------- FUNCIONES -------------------------
        SALA

        HORA : MINUTOS  PELICULA
        */
        int contadorSala = 1;
        System.out.println("------------ FUNCIONES ------------");
        for (Map.Entry<Sala, List<Funcion>> entrada : this.funciones.entrySet()) {
            System.out.println("SALA " + contadorSala + "\n");
            List<Funcion> funciones = entrada.getValue();
            for(Funcion unaFuncion : funciones){
                // El primer numero es el dia en números del mes, para probar que esta yendo al jueves siempre
                System.out.print(unaFuncion.getFecha().getDayOfMonth() + " " + unaFuncion.getFecha().getHourOfDay() + ":" + unaFuncion.getFecha().getMinuteOfHour() + "  " + unaFuncion.getPelicula().getTitulo() + "\n");
            }
            System.out.print("\n");
        }

    }
}