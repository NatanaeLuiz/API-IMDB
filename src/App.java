import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_z467t0uy"; IMDB
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Parse os dados
        var parser = new JsonParser();
        List<Map<String, String>> listFilmes = parser.parse(body);
        
        for (Map<String, String> filme : listFilmes) {
            
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            String nomeArquivo = titulo + ".png";
            InputStream inputStream = new URL(urlImagem).openStream();

            GeradorDeFiguras geradorDeFiguras = new GeradorDeFiguras();
            

            System.out.println("\u001b[1mTitulo:\u001b[m " + titulo);
            System.out.println("\u001b[1mImagem:\u001b[m " + urlImagem);
            System.out.println("\u001b[1mAno de lançamento:\u001b[m " + filme.get("year"));
            System.out.print("\u001b[97m\u001b[38;5;32mClassificação:\u001b[m ");
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            for (int star = 1; star <= classificacao; star++) {
                System.out.print("⭐");
            }

            geradorDeFiguras.cria(inputStream, (int) classificacao, nomeArquivo);
            System.out.printf("  " + filme.get("imDbRating"));
            System.out.println("\n");
        }
    }
}
