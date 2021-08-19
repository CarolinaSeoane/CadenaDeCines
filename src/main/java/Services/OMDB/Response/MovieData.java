package Services.OMDB.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
public class MovieData {

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private ArrayList<Rating> Ratings;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String Type;
    private String DVD;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String Response;

    public MovieData() {
        Title = new String();
        Year = new String();
        Rated = new String();
        Released = new String();
        Runtime = new String();
        Genre = new String();
        Director = new String();
        Actors = new String();
        Plot = new String();
        Language = new String();
        Country = new String();
        Awards = new String();
        Poster = new String();
        Ratings = new ArrayList<>();
        Metascore = new String();
        this.imdbRating = new String();
        this.imdbVotes = new String();
        this.imdbID = new String();
        Type = new String();
        this.DVD = new String();
        BoxOffice = new String();
        Production = new String();
        Website = new String();
        Response = new String();
    }
}
