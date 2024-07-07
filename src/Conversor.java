import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public String convert(String from, String to, Double quantity) {

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/536b7ae7d8ec5ae2e0fef4d9/pair/"+from+"/"+to+"/"+quantity);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var resp = new Gson().fromJson(response.body(), ConversorResponse.class);

            return "El valor "+quantity+" ["+from+"] corresponde al valor final de ==> "+resp.conversion_result()+" ["+to+"]";
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
