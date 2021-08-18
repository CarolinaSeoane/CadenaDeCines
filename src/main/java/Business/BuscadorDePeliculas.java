package Business;

import Services.OMDB.Response.MovieData;
import Services.OMDB.WebServiceClient;
import java.io.IOException;
import java.util.ArrayList;

public class BuscadorDePeliculas {

    public void ejecutar(String tituloPelicula) throws IOException {
        WebServiceClient webServiceClient = new WebServiceClient();
        MovieData movieData = webServiceClient.ejecutar(tituloPelicula);
        Pelicula pelicula = convertMovieDataToPelicula(movieData);
        cargarPelicula(pelicula);
    }

    public Pelicula convertMovieDataToPelicula(MovieData movieData) {
        return new Pelicula(
                movieData.getTitle(),
                movieData.getActors(),
                movieData.getDirector(),
                convertRuntime(movieData.getRuntime()),
                movieData.getGenre(),
                convertRate(movieData.getRated()),
                new ArrayList<>(),
                Double.parseDouble(movieData.getImdbRating())
        );
    }

    public Boolean convertRate(String rate) {
        return (rate.equals("G") || rate.equals("PG"));
    }

    public int convertRuntime(String runtime) {
        int rdoEnInt = 0;
        String[] part = runtime.split(" min");
        String resultado = part[0];
        rdoEnInt = Integer.parseInt(resultado);
        return rdoEnInt;
    }
    
    public void cargarPelicula(Pelicula unaPelicula) {
        Cadena.getInstance().agregarPelicula(unaPelicula);
    }

}
