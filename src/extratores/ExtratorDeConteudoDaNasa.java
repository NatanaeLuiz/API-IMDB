package extratores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import parser.JsonParser;
import model.Conteudo;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudo(String json){
        // Parse os dados
        var parser = new JsonParser();
        System.out.println(parser.parse(json));
        List<Map<String, String>> listAtributos = parser.parse(json);
        
        List<Conteudo> listConteudos = new ArrayList<>();

        for (Map<String, String> atributos : listAtributos) {
            
            String titulo = atributos.get("title");
            String urlImage = atributos.get("url");

            Conteudo conteudo = new Conteudo(titulo, urlImage);

            listConteudos.add(conteudo);
        }

        return listConteudos;
    }
}
