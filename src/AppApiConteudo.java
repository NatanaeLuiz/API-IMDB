import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import client.ClienteHttp;
import extratores.ExtratorDeConteudo;
import extratores.ExtratorDeConteudoDaNasa;
import extratores.ExtratorDeConteudoDoIMDB;
import extratores.ExtratorDeLinguagens;
import model.Conteudo;
import stickers.GeradorDeFiguras;

public class AppApiConteudo {
    public static void main(String[] args) throws Exception {

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();;

        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione a API que deseja utilizar para gerar IMAGENS:");
        System.out.println("1 - 10 Top Filmes - IMDB");
        System.out.println("2 - NASA");
        System.out.println("3 - Linguagens Preferida");
        int opcao = scan.nextInt();

        String url = "";
        if (opcao == 1) {
            //url = "https://imdb-api.com/en/API/Top250Movies/k_z467t0uy";
            url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            extrator = new ExtratorDeConteudoDoIMDB();
        } else if(opcao == 2) {
            url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-02-01&end_date=2023-02-02";
            extrator = new ExtratorDeConteudoDaNasa();
        } else  {
            //url = "http://localhost:8080/languages";
            url = "https://apinatan-linguagens.fly.dev/linguagens";
            extrator = new ExtratorDeLinguagens();
        }        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> listConteudos = extrator.extraiConteudo(json);

        for (Conteudo conteudo : listConteudos) {

            
            // ::: CONSOLE :::
            System.out.println("\u001b[1mTitulo:\u001b[m " + conteudo.getTitulo());
            System.out.println("\u001b[1mImagem:\u001b[m " + conteudo.getUrlImagem());

            if (opcao == 1) {
                System.out.print("\u001b[97m\u001b[38;5;32mClassificação:\u001b[m ");
                System.out.printf("  " + conteudo.getClassificacao());
                for (int star = 1; star <= conteudo.getClassificacao(); star++) {
                    System.out.print("⭐");
                }
            }
            System.out.println("\n");


            // ::: GERAR FIGURINHA :::
            String nomeArquivo = conteudo.getTitulo() + ".png";
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            GeradorDeFiguras geradorDeFiguras = new GeradorDeFiguras();
            
            geradorDeFiguras.cria(inputStream, conteudo.getClassificacao(), nomeArquivo, opcao);
            
        }
    }
}
