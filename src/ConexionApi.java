import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    String apiKey = "33f7f9a503193e2e629c925c";

    public Monedas obtenerDatos(int desde, int hacia, double valor) {

        String codigoDesde = new ObtenerCodigo().obtenerCodigo(desde);
        String codigoHacia = new ObtenerCodigo().obtenerCodigo(hacia);

        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/" +
                codigoDesde +
                "/" +
                codigoHacia +
                "/" +
                valor;


        URI direccion = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
