package br.com.gabrielly.bd;

import br.com.gabrielly.util.Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InicializaBD {

    /*
        Ao rodar o projeto pela 1 vez, 
        utilizamos esse metodo para criar as tabelas,
        e inserior uma lista de filmes e usuarios.
    
    */
    public static void inicializarBD() {
        String sql;
        Connection con = conectar();
        sql = "Create table if not exists filme "
                + "(id int not null auto_increment primary key, "
                + "nome varchar(50) not null, "
                + "pagina int not null, "
                + "notaAvaliacao double not null, "
                + "qtdeAvaliacao int)";
        execute(con, sql);
        sql = "Create table if not exists usuario "
                + "(id int not null auto_increment primary key, "
                + "idFilme int not null, "
                + "nome varchar(30) not null, "
                + "nota int not null, "
                + "avaliacao varchar(50) not null)";
        execute(con, sql);

        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Homem Aranha', '1', '5', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Mulher Maravilha', '1', '9', '2')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Homem de Preto', '1', '13',  '3')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Batman', '1', '8', '2')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Capitao America', '1', '4', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('The Witcher', '1', '3', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Venom: Tempo de Carnificina', '1', '5', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Matrix Resurrections', '1', '2', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('O Lobo de Wall Street', '1', '4', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Titanic', '1', '4', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Django Livre', '2', '2', '1')";
        execute(con, sql);
        sql = "Insert into filme (nome, pagina, notaAvaliacao, qtdeAvaliacao ) values ('Shang-Chi e a Lenda dos Dez Aneis', '2', '4', '1')";
        execute(con, sql);

        
        
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('1', 'Gabrielly', '5', 'Muito bom')";
        execute(con, sql);

        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('2', 'Gabrielly', '5', 'Muito bom')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('2', 'Gino', '4', 'dahora')";
        execute(con, sql);

        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('3', 'Gabrielly', '5', 'Muito bom')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('3', 'Gino', '4', 'dahora')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('3', 'Rose', '4', 'Legal')";
        execute(con, sql);

        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('4', 'Rose', '4', 'Legal')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('4', 'Gino', '4', 'dahora')";
        execute(con, sql);

        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('5', 'Henrique', '4', 'Foda de Mais')";
        execute(con, sql);

        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('6', 'Vinicius', '3', 'Joia')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('7', 'Henrique', '5', 'Foda de Mais')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('8', 'Rose', '2', 'Joia')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('9', 'Rose', '4', 'Joia')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('10', 'Rose', '4', 'Foda de Mais')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('11', 'Rose', '2', 'Joia')";
        execute(con, sql);
        sql = "Insert into usuario (idFilme, nome, nota, avaliacao) values ('12', 'Vinicius', '4', 'Joia')";
        execute(con, sql);
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

    private static void execute(Connection con, String sql) {
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            //System.out.println(ex.getLocalizedMessage());
            Base.mensagemDeErro("Não foi possível executar\n" + sql);
            //System.exit(1);
        }
    }
}
