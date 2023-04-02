package extratores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Conteudo;
import parser.JsonParser;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudo(String json){
        // Parse os dados
        var parser = new JsonParser();
        List<Map<String, String>> listAtributos = parser.parse(json);
        
        List<Conteudo> listConteudos = new ArrayList<>();

        for (Map<String, String> atributos : listAtributos) {
            
            String titulo = atributos.get("title");
            String urlImage = atributos.get("image");
            Double classificacao = Double.parseDouble(atributos.get("imDbRating"));

            Conteudo conteudo = new Conteudo(titulo, urlImage, classificacao);

            listConteudos.add(conteudo);
        }

        return listConteudos;
    }
}
