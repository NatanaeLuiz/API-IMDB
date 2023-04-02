package extratores;
import java.util.List;

import model.Conteudo;

public interface ExtratorDeConteudo {
    
    List<Conteudo> extraiConteudo(String json);
    
}
