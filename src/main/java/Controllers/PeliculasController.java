package Controllers;

import Business.Pelicula;
import Services.OMDB.Response.MovieData;
import Services.OMDB.WebServiceClient;

import java.io.IOException;

public class PeliculasController {

    /*

    public void ejecutar(String tituloPelicula) throws IOException {
        WebServiceClient webServiceClient = new WebServiceClient();
        MovieData movieData = webServiceClient.ejecutar(tituloPelicula);

        Pelicula pelicula = this.convertMovieDataToPelicula(movieData);
    }

    public Pelicula convertMovieDataToPelicula(MovieData movieData) {
        Pelicula pelicula = new Pelicula(
                movieData.getTitle(),
                movieData.getActors(),
                movieData.getDirector(),
                Integer.parseInt(movieData.getRuntime()),
                movieData.getGenre(), //convertir a nuestros generos
                movieData.get // get ATP
                comentarios es new arraylist

        )
    }
*/
}
