package Services.OMDB;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceClient {

    public static final String SEARCH_URL = "http://www.omdbapi.com/?t=TITLE&apikey=f877a80d";

    public static String SendRequest(String requestURL) {
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

    public static String searchByTitle(String title) {
        String requestURL = SEARCH_URL.replaceAll("TITLE", title);
        return SendRequest(requestURL);
    }

    public static void main (String[] args) {
        String jsonResponse = WebServiceClient.searchByTitle("ratatouille");
        System.out.println(jsonResponse);
    }

}
