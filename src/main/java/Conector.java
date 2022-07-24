import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;


public class Conector {
    public static void main(String[] args) throws Exception{

        // conexão HTTP
        //String url = "https://api.nasa.gov/planetary/apod?api_key=mrQhmhVovyZsOflg0zGVESde3fA3Wh04otIIOwy3&start_date=2022-07-12&end_date=2022-07-23";
        String url = "https://alura-filmes.herokuapp.com/conteudos";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        //var extrator = new ConectorNasa();
        var extrator = new ConectorFilmes();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var gerador = new GeradorDeFigurinhas();

        for (int i = 0; i < 3; i++) {

           Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            gerador.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());

        }
    }
}
