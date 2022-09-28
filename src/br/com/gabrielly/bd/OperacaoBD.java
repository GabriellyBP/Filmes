package br.com.gabrielly.bd;

import br.com.gabrielly.util.Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    /*
       Classe para conectar/desconectar ao banco de dados.
       Tambem tem o metodo para executar as query no bando.
    */

public class OperacaoBD {

    public static void execute(String sql, boolean continuaNoErro) {
        // Fazer versão para conexões seguidas não desconectar
        Connection con = conectar();
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            Base.mensagemDeErro("Não foi possível executar \n" + e);
            if (!continuaNoErro) {
                System.exit(1);
            }
        }
        desconectar(con);
    }

    public static Connection conectar() {
        Connection con = null;
        final String USUARIO = "root";
        final String SENHA = "091005";
        final String URL = "jdbc:mysql://localhost:3306/filmes";
        try {
            con = DriverManager.getConnection(URL,
                    USUARIO, SENHA);
        } catch (SQLException ex) {
            Base.mensagemDeErro("Não foi possível conectar ao banco de dados. "
                    + "Verifique e tente posteriormente");
            System.exit(1);
        }
        return con;
    }

    public static void desconectar(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
        }
    }
}
