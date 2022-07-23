import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception{

        // conexão HTTP para exibir os top 250 filmes
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        // poderia deixar HttpResponse como var, porém deixei dessa forma para ficar claro o tipo da variável

        // extrair os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());
        System.out.println(listaDeFilmes.get(0));

        // exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}
