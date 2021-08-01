package Business.PlanificationStrategy;

import Business.Enums.Genero;
import Business.Pelicula;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Business.Enums.Genero.*;

/*
............................. Criterio Infantil .............................................................

Parámetros a utilizar

--> ¿Es INFANTIL?                   20 puntos
--> ¿Es ATP?                        10 puntos
--> ¿Es un Genero Familiar?         10 puntos
--> ¿Dura menos de 130 minutos?     5  puntos

Géneros Familiares = ACCION, CIENCIAFICCION, COMEDIA, FANTASIA, AVENTURAS

 */

@Data
public class EstrategiaInfantil implements PlanificationStrategy {

    List<Genero> generosFamiliares = Stream.of(ACCION, AVENTURAS, CIENCIAFICCION, COMEDIA, DRAMA, FANTASIA).collect(Collectors.toList());

    int minutosParaQueSeaCortaDuracion = 130;

    // PUNTAJES
    int puntajeInfantil      = 20;
    int puntajeATP           = 20;
    int puntajeFamiliar      = 10;
    int puntajeCortaDuracion = 5;

    // PUNTAJES DE CORTE
    int cortePrioridadAlta  = 30;
    int cortePrioridadMedia = 15;

    @Override
    public void darPrioridadAPeliculas(List<Pelicula> todasLasPelis, List<Pelicula> prioridadAlta, List<Pelicula> prioridadMedia, List<Pelicula> prioridadBaja) {
        for(Pelicula pelicula : todasLasPelis) {

            int puntajePelicula = determinarPuntaje(pelicula);

            if(puntajePelicula > cortePrioridadAlta){
                prioridadAlta.add(pelicula);
            }else if(puntajePelicula >= cortePrioridadMedia ) {
                prioridadMedia.add(pelicula);
            }else{
                prioridadBaja.add(pelicula);
            }
        }
    }

    public int determinarPuntaje(Pelicula unaPelicula){
        int puntajeTotal = 0;
        if(unaPelicula.esDeGenero(INFANTIL)){
            puntajeTotal += puntajeInfantil;
        }
        if(unaPelicula.getATP()){
            puntajeTotal += puntajeATP;
        }
        if(this.esDeGeneroFamiliar(unaPelicula)){
            puntajeTotal += puntajeFamiliar;
        }
        if(unaPelicula.duraMenosDe(minutosParaQueSeaCortaDuracion)){
            puntajeTotal += puntajeCortaDuracion;
        }
        return puntajeTotal;
    }

    public boolean esDeGeneroFamiliar(Pelicula unaPelicula){
        return unaPelicula.getGeneros().stream().anyMatch(n -> generosFamiliares.contains(n));
    }

}
