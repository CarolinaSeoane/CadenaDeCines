package Services.OMDB;

import Services.OMDB.Response.MovieData;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

public class WebServiceClient {

    public MovieData ejecutar(String tituloPelicula) throws IOException {
        String jsonResponse = this.buscarPorTitulo(tituloPelicula);
        MovieData movieResponse = new Gson().fromJson(jsonResponse, MovieData.class);

        return movieResponse;
    }

    public String buscarPorTitulo(String tituloPelicula) throws IOException {
        tituloPelicula = URLEncoder.encode(tituloPelicula, "UTF-8"); // Para titulo con espacios

        String URL = this.getAPI_URL(tituloPelicula);

        return SendRequest(URL);
    }

    private String getAPI_URL(String tituloPelicula) throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("src/main/java/Services/OMDB/OMDB.prop");
        prop.load(input);

        String SEARCH_URL = prop.getProperty("SEARCH_URL");
        String API_KEY = prop.getProperty("API_KEY");

        return SEARCH_URL.replaceAll("TITLE", tituloPelicula).replaceAll("API_KEY", API_KEY);
    }

    public String SendRequest(String requestURL) {
        StringBuffer response = new StringBuffer();

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while((line = buffer.readLine()) != null) {
                response.append(line);
            }

            buffer.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

}
