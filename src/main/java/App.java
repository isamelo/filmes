import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class App {
    public static void main(String[] args) throws Exception{

        String url = "https://alura-filmes.herokuapp.com/conteudos";
        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();



    }
}
