package br.com.gabrielly.util;
import javax.swing.JOptionPane;


/*
    Classe usada para apresentar mensagem de aviso ou erro ao usuario.
*/
public class Base {

    public static void mensagemDeErro(String msg) {
        JOptionPane.showMessageDialog(null, msg,
                "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg, 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

}
