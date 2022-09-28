package br.com.gabrielly.entidade;

    /*
       Classe model do Usuario.
       Construtor do usuario, getters e setters
    */

public class Usuario {

    private int id;
    private Filmes filme;
    private String nome;
    private String avaliacao;
    private int nota;

    public Usuario(int id, Filmes filme, String nome, int nota, String avaliacao) {
        this.id = id;
        this.filme = filme;
        this.nome = nome;
        this.nota = nota;
        this.avaliacao = avaliacao;
    }

    public Usuario(Filmes filme, String nome, int nota, String avaliacao) {
        this.filme = filme;
        this.nome = nome;
        this.nota = nota;
        this.avaliacao = avaliacao;
    }

    public Usuario(int id, String nomeFilme, String novaAvaliacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
