package BusinessTests;

import Business.Asiento;
import Business.Pelicula;
import org.junit.Before;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static Business.Enums.Genero.*;

/*
* Para los tests simulamos una cadena de cines con las siguientes caracteristicas:
*
*
*       * * * * * *
*       * Cadena  * ---> 7 Peliculas disponibles:   - Black Widow
*       * * * * * *                                 - Volver Al Futuro
*                                                   - Ratatouille
*                                                   - Joker
*                                                   - Snatch
*                                                   - Cape Fear
*                                                   - Catch Me If You Can
*
*                   ---> 2 Cines:                   - CineA [3 salas]
*                                                   - CineB [2 salas]
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
    protected Asiento asiento;


    @Before
    public void inicializarPeliculas() {

        // Black Widow
        this. blackWidow = new Pelicula(
                "Black Widow",
                "Scarlett Johansson, Rachel Weisz, David Harbour, Robert Downey Jr.",
                "Cate Shortland",
                134,
                Stream.of(ACCION).collect(Collectors.toList()),
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

    @Before
    public void inicializarAsientos() {
        this.asiento = new Asiento(500, "1A", true);
    }

}
