package br.com.gabrielly.dao;

import br.com.gabrielly.bd.OperacaoBD;
import br.com.gabrielly.entidade.Filmes;
import br.com.gabrielly.entidade.Usuario;
import br.com.gabrielly.util.Base;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    /*
       Classe para conter as query do sql e as funcoes para chamar
       cada tipo de funcao ao SQL Insert, Update, Delete, Select.
       da tabela Usuarios
    */

public class UsuarioDAO {

    private static final String INSERT_SQL = "Insert into usuario "
            + "(idFilme, nome, nota, avaliacao) "
            + "values ('%d', '%s', '%d', '%s')";
    private static final String UPDATE_SQL = "Update usuario "
            + "set nome = '%s', "
            + "nota = '%d', "
            + "avaliacao = '%s' "
            + "where id = %d";
    private static final String DELETE_SQL = "Delete from usuario "
            + "where id = %d";
    private static final String SELECT_TODOS = "Select * from usuario";
    private static final String SELECT_POR_FILME = "Select * "
            + "from usuario where idFilme = %d";

    public static void inserir(Usuario usuario) {
        String sql = String.format(INSERT_SQL,
                usuario.getFilme().getId(),
                usuario.getNome(),
                usuario.getNota(),
                usuario.getAvaliacao());
        OperacaoBD.execute(sql, true);
    }

    public static void alterar(Usuario usuario) {
        String sql = String.format(UPDATE_SQL,
                usuario.getNome(),
                usuario.getNota(),
                usuario.getAvaliacao(),
                usuario.getId());
        OperacaoBD.execute(sql, true);
    }

    public static void apagar(Usuario usuario) {
        String sql = String.format(DELETE_SQL, usuario.getId());
        OperacaoBD.execute(sql, true);
    }

    public static List<Usuario> selecionarTodos() {
        List<Usuario> lista = new ArrayList<>();
        Connection con = OperacaoBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(SELECT_TODOS);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idFilmes = rs.getInt("idFilmes");
                String nome = rs.getString("nome");
                int nota = rs.getInt("nota");
                String avaliacao = rs.getString("avaliacao");
                lista.add(new Usuario(id,
                        FilmesDAO.getFilmePorId(idFilmes),
                        nome, nota, avaliacao));
            }
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar\n" + SELECT_TODOS);
            System.exit(1);
        }
        return lista;
    }

    public static List<Usuario> selecionarPorFilme(Filmes filme) {
        List<Usuario> lista = new ArrayList<>();
        Connection con = OperacaoBD.conectar();
        try {
            String sql = String.format(SELECT_POR_FILME,
                    filme.getId());
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idFilmes = rs.getInt("idFilmes");
                String nome = rs.getString("nome");
                int nota = rs.getInt("nota");
                String avaliacao = rs.getString("avaliacao");
                lista.add(new Usuario(id,
                        FilmesDAO.getFilmePorId(idFilmes),
                        nome, nota, avaliacao));
            }
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_FILME);
            System.exit(1);
        }
        return lista;
    }

    public static List<Usuario> selecionarPorFilme(int filme) {
        List<Usuario> lista = new ArrayList<>();
        Connection con = OperacaoBD.conectar();
        try {
            String sql = String.format(SELECT_POR_FILME,
                    filme);
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idFilmes = rs.getInt("idFilme");
                String nome = rs.getString("nome");
                int nota = rs.getInt("nota");
                String avaliacao = rs.getString("avaliacao");
                lista.add(new Usuario(id,
                        FilmesDAO.getFilmePorId(idFilmes),
                        nome, nota, avaliacao));
            }
            OperacaoBD.desconectar(con);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar \n" + SELECT_POR_FILME);
            System.exit(1);
        }
        return lista;
    }

}
