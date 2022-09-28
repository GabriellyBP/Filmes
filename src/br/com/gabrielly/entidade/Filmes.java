package br.com.gabrielly.entidade;

    /*
       Classe model do Usuario.
       Construtor do usuario, getters e setters
    */

public class Filmes {

    private int id;
    private String nome;
    private int pagina;
    private int qtdeAvaliacao;
    private double notaAvaliacao;

    public Filmes(String nome, int pagina, double notaAvaliacao, int qtdeAvaliacao) {
        this.nome = nome;
        this.pagina = pagina;
        this.notaAvaliacao = notaAvaliacao;
        this.qtdeAvaliacao = qtdeAvaliacao;
    }

    public Filmes(int id, String nome, int pagina, double notaAvaliacao, int qtdeAvaliacao) {
        this.id = id;
        this.nome = nome;
        this.pagina = pagina;
        this.notaAvaliacao = notaAvaliacao;
        this.qtdeAvaliacao = qtdeAvaliacao;;
    }

    public Filmes(int id, String nome, double notaAvaliacao, int qtdeAvaliacao) {
        this.id = id;
        this.nome = nome;
        this.notaAvaliacao = notaAvaliacao;
        this.qtdeAvaliacao = qtdeAvaliacao;;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getQtdeAvaliacao() {
        return qtdeAvaliacao;
    }

    public void setQtdeAvaliacao(int qtdeAvaliacao) {
        this.qtdeAvaliacao = qtdeAvaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

}
