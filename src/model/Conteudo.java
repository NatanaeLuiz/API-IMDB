package model;
public class Conteudo {
    
    String titulo;
    String urlImagem;
    Double classificacao;

    public Conteudo(String titulo, String urlImagem, Double classificacao) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.classificacao = classificacao;
    }

    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public Double getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(Double classificacao) {
        this.classificacao = classificacao;
    }
    
}
