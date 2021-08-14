package Controllers;

import Business.Cadena;
import Business.Pelicula;
import Services.OMDB.Response.MovieData;
import Services.OMDB.WebServiceClient;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.ws.util.StringUtils;
import junit.extensions.TestDecorator;

import java.io.CharArrayReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.UNICODE_CHARACTER_CLASS;

public class PeliculasController {

    public void ejecutar(String tituloPelicula) throws IOException {
        WebServiceClient webServiceClient = new WebServiceClient();
        MovieData movieData = webServiceClient.ejecutar(tituloPelicula);
        Pelicula pelicula = this.convertMovieDataToPelicula(movieData);
        this.cargarPelicula(pelicula);
    }

    public Pelicula convertMovieDataToPelicula(MovieData movieData) {
        return new Pelicula(
                movieData.getTitle(),
                movieData.getActors(),
                movieData.getDirector(),
                Integer.parseInt(this.convertRuntime(movieData.getRuntime())),
                movieData.getGenre(),
                this.convertRate(movieData.getRated()),
                new ArrayList<>(),
                Double.parseDouble(movieData.getImdbRating())
        );
    }

    public boolean convertRate(String rate) {
        return (rate.equals("G") || rate.equals("PG"));
    }

    public String convertRuntime(String runtime) {
        String resultado = "";
        for (char s : runtime.toCharArray()) {
            if (Character.isDigit(s)) {
                resultado = resultado.concat(Character.toString(s));
            }
        }
        return resultado;
    }
    
    public void cargarPelicula(Pelicula unaPelicula) {
        Cadena.getInstance().agregarPelicula(unaPelicula);
    }



}
