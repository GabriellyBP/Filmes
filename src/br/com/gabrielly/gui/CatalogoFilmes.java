package br.com.gabrielly.gui;

import br.com.gabrielly.bd.InicializaBD;
import br.com.gabrielly.bd.OperacaoBD;
import br.com.gabrielly.dao.FilmesDAO;
import br.com.gabrielly.dao.UsuarioDAO;
import br.com.gabrielly.entidade.Filmes;
import br.com.gabrielly.entidade.Usuario;
import br.com.gabrielly.util.Base;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
       Classe principal, onde tem o form e os metodos das telas.
 */
public class CatalogoFilmes extends javax.swing.JFrame {

    //variaveis globais para conter a pagina e a ultima pagina.
    private int pagina, ultimaPagina = 2;

    //metodo para inicializar os componentes e carregar a primeira tela.
    public CatalogoFilmes() {
        initComponents();
        //InicializaBD.inicializarBD();
        OperacaoBD.conectar();
        pagina = 1;
        mostraRegistros();
    }

    //metodo mostrar popular/mostrar os registro da tabela filmes
    private void mostraRegistros() {
        String[] camposFilmes = {"ID", "Nome", "Nota", "Quantidade Avaliação"};
        List<Filmes> filmes = FilmesDAO.selecionarPorPagina(pagina);
        String[][] dadosFilmes;
        dadosFilmes = new String[filmes.size()][4];
        int posicao = 0;
        for (Filmes f : filmes) {
            String[] umFilme = new String[4];
            umFilme[0] = String.valueOf(f.getId());
            umFilme[1] = f.getNome();
            umFilme[2] = calculo(f.getNotaAvaliacao(), f.getQtdeAvaliacao());
            umFilme[3] = String.valueOf(f.getQtdeAvaliacao());
            dadosFilmes[posicao++] = umFilme;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosFilmes, camposFilmes);
        jtFilmes.setModel(modelo);
    }

    //metodo para calcular a media de notas com relacao ao total da nota dividido pela quantidade de avaliacao
    private String calculo(double a, int b) {
        String resultado = "0";
        if (a != 0 && b != 0) {
            DecimalFormat df = new DecimalFormat("#.#");
            double valor = a / b;

            resultado = df.format(valor);
        }
        return resultado;
    }

    //metodo mostrar popular/mostrar os registro da tabela usuarios
    private void mostrarUsuario() {
        int selecionado = jtFilmes.getSelectedRow();
        if (selecionado >= 0) {
            String idString = (String) jtFilmes.getValueAt(
                    selecionado, 0);
            int id = Integer.parseInt(idString);
            String[] camposUsuarios = {"ID", "ID Filme", "Nome Filme", "Nome", "Nota", "Avaliacao"};
            List<Usuario> usuarios
                    = UsuarioDAO.selecionarPorFilme(id);
            String[][] dadosUsuarios = new String[usuarios.size()][6];
            int posicao = 0;
            for (Usuario cont : usuarios) {
                String[] umUsuario = new String[6];
                umUsuario[0] = Integer.toString(cont.getId());
                umUsuario[1] = Integer.toString(cont.getFilme().getId());
                umUsuario[2] = cont.getFilme().getNome();
                umUsuario[3] = cont.getNome();
                umUsuario[4] = String.valueOf(cont.getNota());
                umUsuario[5] = cont.getAvaliacao();
                dadosUsuarios[posicao++] = umUsuario;
            }
            DefaultTableModel modelo = new DefaultTableModel(
                    dadosUsuarios, camposUsuarios);
            jtUsuarios.setModel(modelo);
        } else {
            jtpAbasCartaz.setSelectedIndex(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jpCartaz = new javax.swing.JPanel();
        jtpAbasCartaz = new javax.swing.JTabbedPane();
        jpFilmes = new javax.swing.JPanel();
        jscpFilmes = new javax.swing.JScrollPane();
        jtFilmes = new javax.swing.JTable();
        jbCadastrarFilmes = new javax.swing.JButton();
        jbDeletarFilmes = new javax.swing.JButton();
        jbAvaliar = new javax.swing.JButton();
        jbEditFilme = new javax.swing.JButton();
        jbProximaPag = new javax.swing.JButton();
        jbPaginaAnterior = new javax.swing.JButton();
        jpUsuarios = new javax.swing.JPanel();
        jscpUsuarios = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jbDelUsuario = new javax.swing.JButton();
        jbEditUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jscpFilmes.setViewportView(jtFilmes);

        jbCadastrarFilmes.setText("Cadastrar");
        jbCadastrarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarFilmesActionPerformed(evt);
            }
        });

        jbDeletarFilmes.setText("Deletar");
        jbDeletarFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarFilmesActionPerformed(evt);
            }
        });

        jbAvaliar.setText("Avaliar");
        jbAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAvaliarActionPerformed(evt);
            }
        });

        jbEditFilme.setText("Edit Filme");
        jbEditFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditFilmeActionPerformed(evt);
            }
        });

        jbProximaPag.setText("Proxima Pagina");
        jbProximaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProximaPagActionPerformed(evt);
            }
        });

        jbPaginaAnterior.setText("Pagina Anterior");
        jbPaginaAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPaginaAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFilmesLayout = new javax.swing.GroupLayout(jpFilmes);
        jpFilmes.setLayout(jpFilmesLayout);
        jpFilmesLayout.setHorizontalGroup(
            jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilmesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscpFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFilmesLayout.createSequentialGroup()
                        .addComponent(jbCadastrarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbDeletarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jbAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbEditFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFilmesLayout.createSequentialGroup()
                        .addComponent(jbPaginaAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbProximaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpFilmesLayout.setVerticalGroup(
            jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFilmesLayout.createSequentialGroup()
                .addComponent(jscpFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDeletarFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbProximaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPaginaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        jtpAbasCartaz.addTab("Filmes", jpFilmes);

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jtUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtUsuariosFocusGained(evt);
            }
        });
        jscpUsuarios.setViewportView(jtUsuarios);

        jbDelUsuario.setText("Deletar");
        jbDelUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDelUsuarioActionPerformed(evt);
            }
        });

        jbEditUsuario.setText("Editar");
        jbEditUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUsuariosLayout = new javax.swing.GroupLayout(jpUsuarios);
        jpUsuarios.setLayout(jpUsuariosLayout);
        jpUsuariosLayout.setHorizontalGroup(
            jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuariosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jbDelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEditUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addComponent(jscpUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );
        jpUsuariosLayout.setVerticalGroup(
            jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuariosLayout.createSequentialGroup()
                .addComponent(jscpUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jtpAbasCartaz.addTab("Usuarios", jpUsuarios);

        javax.swing.GroupLayout jpCartazLayout = new javax.swing.GroupLayout(jpCartaz);
        jpCartaz.setLayout(jpCartazLayout);
        jpCartazLayout.setHorizontalGroup(
            jpCartazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpAbasCartaz)
        );
        jpCartazLayout.setVerticalGroup(
            jpCartazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpAbasCartaz)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCartaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCartaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodo para focar na aba 2 (Usuarios) e popular a tabela chamando o metodo mostrarUsuario
    private void jtUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtUsuariosFocusGained
        mostrarUsuario();
    }//GEN-LAST:event_jtUsuariosFocusGained

    //metodo para cadastrar o filme
    private void jbCadastrarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarFilmesActionPerformed
        String nomeFilme = JOptionPane.showInputDialog("Digite o nome do filme: ");
        if (nomeFilme == null || nomeFilme.isEmpty()) {
            Base.mensagem("O Nome do filme não pode ser vazio");
        } else {
            int adicionado = 0;
            List<Filmes> listaFilmes = FilmesDAO.selecionarTodos();
            for (Filmes f : listaFilmes) {
                if (nomeFilme.equals(f.getNome())) {
                    Base.mensagem("Nome do filme ja existe. \n" + nomeFilme);
                    adicionado = 1;
                    break;
                }
            }
            if (adicionado == 0) {
                int p = FilmesDAO.qtasPaginas();
                pagina = (int) Math.ceil(p / 10) + 1;
                double nota = 0.0;
                FilmesDAO.inserir(new Filmes(nomeFilme, pagina, nota, 0));
                ultimaPagina = pagina;
                mostraRegistros();
                Base.mensagem("Filme salvo com sucesso:\n" + nomeFilme);
            }
        }
    }//GEN-LAST:event_jbCadastrarFilmesActionPerformed

    //metodo para avancar uma pagina
    private void jbProximaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProximaPagActionPerformed
        if (pagina < ultimaPagina) {
            pagina++;
            mostraRegistros();
        } else {
            JOptionPane.showMessageDialog(null, "Última");
        }
    }//GEN-LAST:event_jbProximaPagActionPerformed

    //metodo para retroceder uma pagina
    private void jbPaginaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPaginaAnteriorActionPerformed
        if (pagina > 1) {
            pagina--;
            mostraRegistros();
        } else {
            JOptionPane.showMessageDialog(null, "Primeira");
        }
    }//GEN-LAST:event_jbPaginaAnteriorActionPerformed

    //metodo para deletar o filme e todos os usuarios/avaliacao que existe do filme selecionado.
    private void jbDeletarFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarFilmesActionPerformed
        int selecionado = jtFilmes.getSelectedRow();
        if (selecionado >= 0) {
            String idString = (String) jtFilmes.getValueAt(selecionado, 0);
            int id = Integer.parseInt(idString);
            List<Usuario> usuario = UsuarioDAO.selecionarPorFilme(id);
            String[][] dadosUsuario = new String[usuario.size()][2];
            int posicao = 0;
            for (Usuario u : usuario) {
                UsuarioDAO.apagar(u);
            }
            Filmes filme = FilmesDAO.getFilmePorId(id);
            FilmesDAO.apagar(filme);
            mostraRegistros();
            Base.mensagem("Filme deletado com sucesso:\n" + filme.getNome());
        } else {
            Base.mensagem("Selecionar algum filme\n");
        }
    }//GEN-LAST:event_jbDeletarFilmesActionPerformed

    //metodo para avaliar o filme, onde criamos o usuario, damos uma nota e um comentario
    private void jbAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAvaliarActionPerformed

        int selecionado = jtFilmes.getSelectedRow();
        if (selecionado >= 0) {
            String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do Usuario: ");
            String avaliacao = JOptionPane.showInputDialog("Digite uma avaliacao para o filme selecionado: ");
            String n;
            int nota = 0;
            do {
                n = JOptionPane.showInputDialog("Digita uma nota para o filme de 1 a 5");
                if (n.matches("[0-9]")) {
                    nota = Integer.parseInt(n);
                } else {
                    Base.mensagem("Digite uma nota com valor entre 1 e 5.\n");
                }
            } while (!n.matches("[0-9]"));

            int id = Integer.parseInt(jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 0).toString());

            if (nomeUsuario == null || nomeUsuario.isEmpty() || avaliacao == null || avaliacao.isEmpty() || nota > 5 || nota < 0) {
                nota = 0;
                Base.mensagem("Você esqueceu de digitar alguma informacao!");
            } else {
                int adicionado = 0;
                int option = 0;
                List<Usuario> listaU = UsuarioDAO.selecionarPorFilme(id);
                for (Usuario us : listaU) {
                    if (nomeUsuario.equals(us.getNome())) {
                        option = JOptionPane.showInternalConfirmDialog(null, "Usuario ja avaliou o filme, deseja editar a avaliacao?");
                        if (option == 0) {
                            Filmes filme = FilmesDAO.getFilmePorId(id);
                            double notaAFilme = filme.getNotaAvaliacao() - us.getNota();
                            notaAFilme += nota;
                            filme.setNotaAvaliacao(notaAFilme);
                            UsuarioDAO.alterar(new Usuario(us.getId(), filme, nomeUsuario, nota, avaliacao));
                            FilmesDAO.avaliar(filme);
                            mostrarUsuario();
                            mostraRegistros();
                            Base.mensagem("Usuario editado com sucesso: \n" + nomeUsuario);
                            adicionado = 1;
                            break;
                        } else {
                            Base.mensagem("Você desistiu de atualizar o contato.\n" + nomeUsuario);
                        }

                    }
                }
                if (adicionado == 0 && option == 0) {
                    Filmes filme = FilmesDAO.getFilmePorId(id);
                    UsuarioDAO.inserir(new Usuario(filme, nomeUsuario, nota, avaliacao));
                    int qtdeA = filme.getQtdeAvaliacao() + 1;
                    double nA = filme.getNotaAvaliacao() + nota;
                    filme.setNotaAvaliacao(nA);
                    filme.setQtdeAvaliacao(qtdeA);
                    FilmesDAO.avaliar(filme);
                    mostraRegistros();
                    Base.mensagem("Filme avaliado com sucesso: \n" + filme.getNome());
                }
            }

        } else {
            Base.mensagem("Selecionar algum filme\n");
        }
    }//GEN-LAST:event_jbAvaliarActionPerformed

    //metodo para editar o filme, somnete o nome do mesmo
    private void jbEditFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditFilmeActionPerformed

        int selecionado = jtFilmes.getSelectedRow();
        if (selecionado >= 0) {
            String nome = jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 1).toString();
            int id = Integer.parseInt(jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 0).toString());
            String nota = jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 2).toString().split("\\,")[1];
            double nA = Double.valueOf(nota);
            int qtdeAvaliacao = Integer.parseInt(jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 3).toString());

            String nomeFilme = JOptionPane.showInputDialog("Deseja alterar o nome do filme:\n", nome);

            if (nomeFilme == null || nomeFilme.isEmpty()) {
                Base.mensagem("O Nome do filme não pode ser vazio:");
            } else {
                FilmesDAO.alterar(new Filmes(id, nomeFilme, nA, qtdeAvaliacao));
                mostraRegistros();
                Base.mensagem("Filme editado com sucesso\n" + nomeFilme);
            }
        } else {
            Base.mensagem("Selecionar algum filme:\n");
        }
    }//GEN-LAST:event_jbEditFilmeActionPerformed

    //metodo para deletar o usuario e apagar a nota e qtde de avaliacao da tabela filme
    private void jbDelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDelUsuarioActionPerformed

        int selecionado = jtUsuarios.getSelectedRow();
        if (selecionado >= 0) {
            int idUsuario = Integer.parseInt(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 0).toString());
            String nomeFilme = jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 2).toString();
            String nomeUsuario = jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 3).toString();
            int nota = Integer.parseInt(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 4).toString());
            String avaliacao = jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 5).toString();
            Filmes filme = FilmesDAO.getFilmePorNome(nomeFilme);
            int qtdeA = filme.getQtdeAvaliacao() - 1;
            double nA = filme.getNotaAvaliacao() - nota;
            filme.setNotaAvaliacao(nA);
            filme.setQtdeAvaliacao(qtdeA);
            FilmesDAO.avaliar(filme);
            UsuarioDAO.apagar(new Usuario(idUsuario, filme, nomeFilme, nota, avaliacao));
            mostrarUsuario();
            mostraRegistros();
            Base.mensagem("Usuario deletado com sucesso: \n" + nomeUsuario);
        } else {
            Base.mensagem("Selecionar Usuario\n");
        }
    }//GEN-LAST:event_jbDelUsuarioActionPerformed

    //metodo para editar o usuario, onde podemos alterar o nome usuario, nota e a avaliacao
    private void jbEditUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditUsuarioActionPerformed

        int selecionado = jtUsuarios.getSelectedRow();
        if (selecionado >= 0) {
            int id = Integer.parseInt(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 0).toString());
            int idFilmes = Integer.parseInt(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 1).toString());
            String nome = jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 3).toString();
            int nota = Integer.parseInt(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 4).toString());
            String avaliacao = jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 5).toString();

            String nomeUsuario = JOptionPane.showInputDialog("Deseja alterar o nome do usuario:\n", nome);
            String novaAvaliacao = JOptionPane.showInputDialog("Deseja alterar a avaliacao:\n", avaliacao);

            String n;
            int notaAvaliacao = 0;
            do {
                n = JOptionPane.showInputDialog("Deseja alterar a avaliacao:\n", nota);
                if (n.matches("[0-9]")) {
                    notaAvaliacao = Integer.parseInt(n);
                } else {
                    Base.mensagem("Digite uma nota com valor entre 1 e 5.\n");
                }
            } while (!n.matches("[0-9]"));

            if (nomeUsuario == null || nomeUsuario.isEmpty() && novaAvaliacao == null || novaAvaliacao.isEmpty() || notaAvaliacao > 5 || notaAvaliacao < 0) {
                Base.mensagem("Você esqueceu de digitar alguma informacao!");
            } else {
                Filmes filme = FilmesDAO.getFilmePorId(idFilmes);
                double notaAFilme = filme.getNotaAvaliacao() - nota;
                notaAFilme += notaAvaliacao;
                filme.setNotaAvaliacao(notaAFilme);
                UsuarioDAO.alterar(new Usuario(id, filme, nomeUsuario, notaAvaliacao, novaAvaliacao));
                FilmesDAO.avaliar(filme);
                mostrarUsuario();
                mostraRegistros();
                Base.mensagem("Usuario editado com sucesso: \n" + nomeUsuario);
            }
        } else {
            Base.mensagem("Selecionar Usuario\n");
        }
    }//GEN-LAST:event_jbEditUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CatalogoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogoFilmes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton jbAvaliar;
    private javax.swing.JButton jbCadastrarFilmes;
    private javax.swing.JButton jbDelUsuario;
    private javax.swing.JButton jbDeletarFilmes;
    private javax.swing.JButton jbEditFilme;
    private javax.swing.JButton jbEditUsuario;
    private javax.swing.JButton jbPaginaAnterior;
    private javax.swing.JButton jbProximaPag;
    private javax.swing.JPanel jpCartaz;
    private javax.swing.JPanel jpFilmes;
    private javax.swing.JPanel jpUsuarios;
    private javax.swing.JScrollPane jscpFilmes;
    private javax.swing.JScrollPane jscpUsuarios;
    private javax.swing.JTable jtFilmes;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTabbedPane jtpAbasCartaz;
    // End of variables declaration//GEN-END:variables
}
