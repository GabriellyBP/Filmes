package br.com.gabrielly.dao;

import br.com.gabrielly.bd.OperacaoBD;
import br.com.gabrielly.entidade.Filmes;
import br.com.gabrielly.util.Base;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    /*
       Classe para conter as query do sql e as funcoes para chamar
       cada tipo de funcao ao SQL Insert, Update, Delete, Select.
       da tabela Filmes
    */

public class FilmesDAO {

    private static final String INSERT_SQL = "Insert into filme "
            + "(nome, pagina, notaAvaliacao, qtdeAvaliacao) "
            + " values ('%s', '%d', '%s', '%d')";
    private static final String AVALIA_SQL = "Update filme "
            + "set notaAvaliacao = '%s', "
            + "qtdeAvaliacao = '%d' "
            + "where id = %d";
    private static final String UPDATE_SQL = "Update filme "
            + "set nome = '%s' "
            + "where id = %d";
    private static final String DELETE_SQL = "Delete from filme "
            + "where id = %d";
    private static final String SELECIONAR_PAGINA_SQL = "Select * "
            + "from filme where pagina=%d";
    private static final String SELECT_TODOS = "SELECT * FROM filme";
    private static final String SELECIONAR_MAX_FILMES
            = "Select max(id) as id from filme";
    private static final String SELECT_POR_ID = "Select * from filme "
            + "where id = %d";
    private static final String SELECT_POR_NOME = "Select * from filme "
            + "where nome = '%s'";

    public static void inserir(Filmes filme) {
        String sql = String.format(INSERT_SQL,
                filme.getNome(),
                filme.getPagina(),
                filme.getNotaAvaliacao(),
                filme.getQtdeAvaliacao());
        OperacaoBD.execute(sql, true);

    }

    public static void alterar(Filmes filme) {
        String sql = String.format(UPDATE_SQL,
                filme.getNome(),
                filme.getId());
        OperacaoBD.execute(sql, true);
    }

    public static void avaliar(Filmes filme) {
        String sql = String.format(AVALIA_SQL,
                filme.getNotaAvaliacao(),
                filme.getQtdeAvaliacao(),
                filme.getId());
        OperacaoBD.execute(sql, true);
    }

    public static void apagar(Filmes filme) {
        String sql = String.format(DELETE_SQL, filme.getId());
        OperacaoBD.execute(sql, true);
    }

    public static List<Filmes> selecionarTodos() {
        List<Filmes> lista = new ArrayList<>();
        Connection con = OperacaoBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(SELECT_TODOS);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int pagina = rs.getInt("pagina");
                int qtdeAvaliacao = rs.getInt("qtdeAvaliacao");
                lista.add(new Filmes(id, nome, pagina, qtdeAvaliacao));
            }
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar \n" + SELECT_TODOS);
        }
        return lista;
    }

    public static Filmes getFilmePorId(int idPesquisa) {
        Filmes retorno = null;
        Connection con = OperacaoBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idPesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int pagina = rs.getInt("pagina");
            double nota = rs.getFloat("notaAvaliacao");
            int qtdeAvaliacao = rs.getInt("qtdeAvaliacao");
            retorno = new Filmes(id, nome, pagina, nota, qtdeAvaliacao);
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_ID);
        }
        return retorno;
    }

    public static Filmes getFilmePorNome(String nomePesquisa) {
        Filmes retorno = null;
        Connection con = OperacaoBD.conectar();
        try {
            String sql = String.format(SELECT_POR_NOME, nomePesquisa);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int pagina = rs.getInt("pagina");
            double nota = rs.getFloat("notaAvaliacao");
            int qtdeAvaliacao = rs.getInt("qtdeAvaliacao");
            retorno = new Filmes(id, nome, pagina, nota, qtdeAvaliacao);
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_NOME);
        }
        return retorno;
    }

    public static List<Filmes> selecionarPorPagina(int pagina) {
        return selecionarTodos(String.format(
                SELECIONAR_PAGINA_SQL, pagina));
    }

    private static List<Filmes> selecionarTodos(String sql) {
        List<Filmes> lista = new ArrayList<>();
        Connection con = OperacaoBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int pagina = rs.getInt("pagina");
                double nota = rs.getFloat("notaAvaliacao");
                String nome = rs.getString("nome");
                int qtdeAvaliacao = rs.getInt("qtdeAvaliacao");
                lista.add(new Filmes(id, nome, pagina, nota,
                        qtdeAvaliacao));
            }
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }

    public static int qtasPaginas() {
        int retorno = 0;
        Connection con = OperacaoBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(
                    SELECIONAR_MAX_FILMES);
            rs.next();
            retorno = rs.getInt("id");
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
}
