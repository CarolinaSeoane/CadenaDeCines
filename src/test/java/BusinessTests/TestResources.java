package BusinessTests;

import Business.*;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static Business.Enums.Genero.*;

/*
* Para los tests simulamos una cadena de cines con las siguientes caracteristicas:
*
*   1 Cadena: - cadena
*
*   7 Peliculas disponibles:    - Black Widow
*                               - Volver Al Futuro
*                               - Ratatouille
*                               - Joker
*                               - Snatch
*                               - Cape Fear
*                               - Catch Me If You Can
*
*  3 cines: - CineA
*           - CineB
*           - CineC
*
*  Informacion de cada cine:    - CineA:
*                                   [3 salas] : SalaA1 (2 asientos: A1_A1 y A1_A2)
*                                               SalaA2 (1 asiento:  A2_A1)
*                                               SalaA3 (2 asiento:  A3_A1 y A3_A2)
*
*                                   [Asignador] : asignadorDeHorariosA
*
*
*                               - CineB:
*                                   [2 salas] : SalaB1 (1 asiento: B1_A1)
*                                               SalaB2 (2 asientos: B2_A1 Y B2_A2)
*
*                                    [Asignador] : asignadorDeHorariosB
*
*                               - CineC:
*                                   [1 sala] : SalaC1 (2 asiento2: C1_A1 y C1_A2)
*
*                                   [Asignador] : asignadorDeHorariosC
*
* */

public class TestResources {

    // Peliculas
    protected Pelicula blackWidow;
    protected Pelicula volverAlFuturo;
    protected Pelicula ratatouille;
    protected Pelicula joker;
    protected Pelicula snatch;
    protected Pelicula capeFear;
    protected Pelicula catchMeIfYouCan;

    // Asientos
    protected Asiento A1_A1;
    protected Asiento A1_A2;
    protected Asiento A2_A1;
    protected Asiento A3_A1;
    protected Asiento A3_A2;
    protected Asiento B1_A1;
    protected Asiento B2_A1;
    protected Asiento B2_A2;
    protected Asiento C1_A1;
    protected Asiento C1_A2;

    // Salas
    protected Sala salaA1;
    protected Sala salaA2;
    protected Sala salaA3;
    protected Sala salaB1;
    protected Sala salaB2;
    protected Sala salaC1;

    // Funciones
    protected Funcion funcionA_A1_blackWidow;

    // Cines
    protected Cine cineA;
    protected Cine cineB;
    protected Cine cineC;

    // Asignador de Horarios
    protected AsignadorDeHorarios asignadorDeHorarios; //este despues lo borro. Lo use para que me cree una funcion
    protected AsignadorDeHorarios asignadorDeHorariosA;
    protected AsignadorDeHorarios asignadorDeHorariosB;
    protected AsignadorDeHorarios asignadorDeHorariosC;

    // Fechas
    //protected Date fecha1;

    protected Cadena cadena;

    public void inicializarPeliculas() {

        // Black Widow
        this. blackWidow = new Pelicula(
                "Black Widow",
                "Scarlett Johansson, Rachel Weisz, David Harbour, Robert Downey Jr.",
                "Cate Shortland",
                134,
                Stream.of(ACCION, THRILLER, CIENCIAFICCION, AVENTURAS, FANTASIA).collect(Collectors.toList()),
                true);

        // Volver Al Futuro
        this.volverAlFuturo = new Pelicula(
                "Volver Al Futuro",
                "Michael J. Fox, Christopher Lloyd, Lea Thompson",
                "Robert Zemeckis",
                116,
                Stream.of(CIENCIAFICCION, FANTASIA, COMEDIA, AVENTURAS, INFANTIL, ROMANCE).collect(Collectors.toList()),
                true);

        // Ratatouille
        this.ratatouille = new Pelicula(
                "Ratatouille",
                "Lou Romano, Janeane Garofalo, Will Arnett",
                "Brad Bird",
                118,
                Stream.of(INFANTIL, FANTASIA, AVENTURAS, COMEDIA).collect(Collectors.toList()),
                true);

        // Joker
        this.joker = new Pelicula(
                "Joker",
                "Joaquin Phoenix, Robert De Niro, Zazie Beetz, Frances Conroy",
                "Todd Phillips",
                122,
                Stream.of(SUSPENSO, DRAMA, THRILLER).collect(Collectors.toList()),
                false);

        // Snatch
        this.snatch = new Pelicula(
                "Snatch",
                "Brad Pitt, Jason Statham, Benicio del Toro, Vinnie Jones",
                "Guy Ritchie",
                104,
                Stream.of(ACCION, COMEDIA, THRILLER).collect(Collectors.toList()),
                false);

        // Cape Fear
        this.capeFear = new Pelicula(
                "Cape Fear",
                "Robert De Niro, Gregory Peck, Robert Mitchum, Juliette Lewis",
                "Martin Scorsese",
                128,
                Stream.of(THRILLER, SUSPENSO, DRAMA).collect(Collectors.toList()),
                false);

        // Catch Me If You Can
        this.catchMeIfYouCan = new Pelicula(
                "Catch Me If You Can",
                "Leonardo DiCaprio, Tom Hanks, Amy Adams, Christopher Walken",
                "Steven Spielberg",
                141,
                Stream.of(DRAMA, COMEDIA).collect(Collectors.toList()),
                false);
    }

    public void inicializarAsientos() {
        this.A1_A1 = new Asiento(300, "A1_A1", true);
        this.A1_A2 = new Asiento(500, "A1_A2", true);
        this.A2_A1 = new Asiento(400, "A2_A1", true);
        this.A3_A1 = new Asiento(600, "A3_A1", true);
        this.A3_A2 = new Asiento(400, "A3_A2", true);
        this.B1_A1 = new Asiento(500, "B1_A1", true);
        this.B2_A1 = new Asiento(400, "B2_A1", true);
        this.B2_A2 = new Asiento(600, "B2_A2", true);
        this.C1_A1 = new Asiento(600, "B2_A2", true);
        this.C1_A2 = new Asiento(600, "B2_A2", true);
    }

    public void inicializarSalas() {
        this.salaA1 = new Sala(Stream.of(A1_A1, A1_A2).collect(Collectors.toList()));
        this.salaA2 = new Sala(Stream.of(A2_A1).collect(Collectors.toList()));
        this.salaA3 = new Sala(Stream.of(A3_A1, A3_A2).collect(Collectors.toList()));
        this.salaB1 = new Sala(Stream.of(B1_A1).collect(Collectors.toList()));
        this.salaB2 = new Sala(Stream.of(B2_A1, B2_A2).collect(Collectors.toList()));
        this.salaC1 = new Sala(Stream.of(C1_A1, C1_A2).collect(Collectors.toList()));
    }

    public void inicializarFunciones() {
        this.asignadorDeHorarios = new AsignadorDeHorarios(new ArrayList<>());
        this.funcionA_A1_blackWidow = asignadorDeHorarios.crearFuncion(blackWidow, new Date(), salaA1);
    }

    public void inicializarAsignadoresDeHorarios() {
        this.asignadorDeHorariosA = new AsignadorDeHorarios(new ArrayList<>());
        this.asignadorDeHorariosB = new AsignadorDeHorarios(new ArrayList<>());
        this.asignadorDeHorariosC = new AsignadorDeHorarios(new ArrayList<>());
    }

    public void inicializarCines() {
        this.cineA = new Cine("CineA", "CineAPiso1", asignadorDeHorariosA);
        this.cineB = new Cine("CineB", "CineBPiso1", asignadorDeHorariosB);
        this.cineC = new Cine("CineC", "CineCPiso1", asignadorDeHorariosC);
    }

    public void inicializarCadena() {
        this.cadena = Cadena.getInstance();
        cadena.setCines(Stream.of(cineA, cineB, cineC).collect(Collectors.toList()));
        cadena.setPeliculas(Stream.of(blackWidow, volverAlFuturo, ratatouille, joker, snatch, capeFear, catchMeIfYouCan).collect(Collectors.toList()));
        cadena.setPorcentajeGanancia(100);
    }

}
