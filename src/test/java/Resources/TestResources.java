package Resources;

import Business.*;
import Business.Composite.Combo;
import Business.Composite.Producto;
import Business.Composite.ProductoSimple;
import Business.Enums.Tamanio;
import Business.Enums.TipoDoc;
import Business.PlanificationStrategy.Planificador;
import Business.SusbcribersObserver.Notificador;
import Controllers.TicketController;
import org.joda.time.DateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static Business.Enums.Genero.*;

public class TestResources {

    // Cadena
    protected Cadena cadena;

    // Planificador
    protected Planificador planificador;

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

    // Productos
    protected Producto pochocloChico;
    protected Producto pochocloGrande;
    protected Producto nachosMedianos;
    protected Producto gaseosaGrande;

    protected Combo combo1;
    protected Combo combo2;
    protected Combo combo3;

    // Ticket Controller
    protected TicketController ticketController;

    // Personas
    protected Persona caro;
    protected Persona facu;

    // Comentarios
    protected Comentario com_1;
    protected Comentario com_2;
    protected Comentario com_3;
    protected Comentario com_4;

    public void inicializarPeliculas() {

        // Black Widow
        this. blackWidow = new Pelicula(
                "Black Widow",
                "Scarlett Johansson, Rachel Weisz, David Harbour, Robert Downey Jr.",
                "Cate Shortland",
                134,
                Stream.of(ACCION, THRILLER, CIENCIAFICCION, AVENTURAS, FANTASIA).collect(Collectors.toList()),
                true,
                Stream.of(com_1).collect(Collectors.toList()));

        // Volver Al Futuro
        this.volverAlFuturo = new Pelicula(
                "Volver Al Futuro",
                "Michael J. Fox, Christopher Lloyd, Lea Thompson",
                "Robert Zemeckis",
                116,
                Stream.of(CIENCIAFICCION, FANTASIA, COMEDIA, AVENTURAS, INFANTIL, ROMANCE).collect(Collectors.toList()),
                true,
                Stream.of(com_2).collect(Collectors.toList()));

        // Ratatouille
        this.ratatouille = new Pelicula(
                "Ratatouille",
                "Lou Romano, Janeane Garofalo, Will Arnett",
                "Brad Bird",
                118,
                Stream.of(INFANTIL, FANTASIA, AVENTURAS, COMEDIA).collect(Collectors.toList()),
                true,
                Stream.of(com_3).collect(Collectors.toList()));

        // Joker
        this.joker = new Pelicula(
                "Joker",
                "Joaquin Phoenix, Robert De Niro, Zazie Beetz, Frances Conroy",
                "Todd Phillips",
                122,
                Stream.of(SUSPENSO, DRAMA, THRILLER).collect(Collectors.toList()),
                false,
                Stream.of(com_4).collect(Collectors.toList()));

        // Snatch
        this.snatch = new Pelicula(
                "Snatch",
                "Brad Pitt, Jason Statham, Benicio del Toro, Vinnie Jones",
                "Guy Ritchie",
                104,
                Stream.of(ACCION, COMEDIA, THRILLER).collect(Collectors.toList()),
                false,
                Stream.of(com_1).collect(Collectors.toList()));

        // Cape Fear
        this.capeFear = new Pelicula(
                "Cape Fear",
                "Robert De Niro, Gregory Peck, Robert Mitchum, Juliette Lewis",
                "Martin Scorsese",
                128,
                Stream.of(SUSPENSO, DRAMA).collect(Collectors.toList()),
                false,
                Stream.of(com_2).collect(Collectors.toList()));

        // Catch Me If You Can
        this.catchMeIfYouCan = new Pelicula(
                "Catch Me If You Can",
                "Leonardo DiCaprio, Tom Hanks, Amy Adams, Christopher Walken",
                "Steven Spielberg",
                141,
                Stream.of(DRAMA, COMEDIA).collect(Collectors.toList()),
                true,
                Stream.of(com_3).collect(Collectors.toList()));
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
        // Esta funcion la usamos para tests especificos, pero sino nosotros nunca creamos
        // funciones en el sistema, lo hace el algoritmo solo.
        this.asignadorDeHorarios = new AsignadorDeHorarios(new ArrayList<>());
        this.funcionA_A1_blackWidow = asignadorDeHorarios.crearFuncion(blackWidow, new DateTime(), salaA1);
    }

    public void inicializarAsignadoresDeHorarios() {
        this.asignadorDeHorariosA = new AsignadorDeHorarios(new ArrayList<>());
        this.asignadorDeHorariosB = new AsignadorDeHorarios(new ArrayList<>());
        this.asignadorDeHorariosC = new AsignadorDeHorarios(new ArrayList<>());
    }

    public void inicializarCines() {
        this.cineA = new Cine("CineA", "CineAPiso1", this.inicializarFuncionesDeA(), asignadorDeHorariosA, new Notificador(new ArrayList<>()));
        this.cineB = new Cine("CineB", "CineBPiso1", this.inicializarFuncionesDeB(), asignadorDeHorariosB, new Notificador(new ArrayList<>()));
        this.cineC = new Cine("CineC", "CineCPiso1", this.inicializarFuncionesDeC(), asignadorDeHorariosC, new Notificador(new ArrayList<>()));
    }

    public Map<Sala, List<Funcion>> inicializarFuncionesDeA() { // A tiene 3 salas: A1, A2, A3
        Map<Sala, List<Funcion>> funciones = new HashMap<>();
        funciones.put(salaA1, new ArrayList<>());
        funciones.put(salaA2, new ArrayList<>());
        funciones.put(salaA3, new ArrayList<>());
        return funciones;
    }

    public Map<Sala, List<Funcion>> inicializarFuncionesDeB() { // B tiene 2 salas: B1, B2
        Map<Sala, List<Funcion>> funciones = new HashMap<>();
        funciones.put(salaB1, new ArrayList<>());
        funciones.put(salaB2, new ArrayList<>());
        return funciones;
    }

    public Map<Sala, List<Funcion>> inicializarFuncionesDeC() { // C tiene 1 sala: C1
        Map<Sala, List<Funcion>> funciones = new HashMap<>();
        funciones.put(salaC1, new ArrayList<>());
        return funciones;
    }

    public void inicializarPersonas(){
        caro = new Persona("Carolina", "Seoane", new Date(2001, Calendar.FEBRUARY, 07), TipoDoc.DNI,
                        43050214, "carolina.b.seoane@gmail.com", new ArrayList<>(),
                Stream.of(ACCION, CIENCIAFICCION, SUSPENSO).collect(Collectors.toList()), new ArrayList<>());
        facu = new Persona("Facundo", "Verge", new Date(2000, Calendar.OCTOBER, 05), TipoDoc.DNI,
                42952776, "facu.verge@gmail.com", new ArrayList<>(),
                Stream.of(CIENCIAFICCION, COMEDIA, THRILLER).collect(Collectors.toList()), new ArrayList<>());
    }

    public void inicializarCadena() {
        this.cadena = Cadena.getInstance();
        cadena.setCines(Stream.of(cineA, cineB, cineC).collect(Collectors.toList()));
        cadena.setPeliculas(Stream.of(blackWidow, volverAlFuturo, ratatouille, joker, snatch, capeFear, catchMeIfYouCan).collect(Collectors.toList()));
        cadena.setProductos(Stream.of(pochocloChico, pochocloGrande, nachosMedianos, gaseosaGrande).collect(Collectors.toList()));
        cadena.setPorcentajeGanancia(100);
        cadena.setDescuentoPorCombo(15);
    }

    public void inicializarPlanificador() {
        this.planificador = Planificador.getInstance();
    }

    public void inicializarProductos() {
        this.pochocloChico = new ProductoSimple("Pochoclos", Tamanio.CHICO, 300);
        this.pochocloGrande = new ProductoSimple("Pochoclos", Tamanio.GRANDE, 550);
        this.nachosMedianos = new ProductoSimple("Nachos",Tamanio.MEDIANO, 400);
        this.gaseosaGrande = new ProductoSimple("Gaseosa", Tamanio.GRANDE, 300);

        this.combo1 = new Combo(Stream.of(pochocloGrande, gaseosaGrande).collect(Collectors.toList()));
        this.combo2 = new Combo(Stream.of(pochocloChico, nachosMedianos, gaseosaGrande).collect(Collectors.toList()));
        this.combo3 = new Combo(Stream.of(pochocloGrande, gaseosaGrande, gaseosaGrande).collect(Collectors.toList()));
    }

    public void inicializarTicketController() {
        this.ticketController = new TicketController();
    }

    public void inicializarComentarios() {
        this.com_1 = new Comentario(
                "dario",
                "Muy buena",
                4
        );

        this.com_2 = new Comentario(
                "Camiii",
                "Recomendable",
                5
        );

        this.com_3 = new Comentario(
                "mica",
                "No me gusto",
                2
        );

        this.com_4 = new Comentario(
                "pancho",
                "No era lo que esperaba pero valio la pena",
                4
        );

    }

}
