import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiService {

    private static final String API_KEY = "794f9dccd04e1d2514b8cd5b";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public Map<String, Double> obtenerTasas() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                ResponseApi datos = gson.fromJson(response.body(), ResponseApi.class);
                return datos.conversion_rates;
            } else {
                throw new IOException("Error al obtener las tasas de cambio: Código " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }
}
