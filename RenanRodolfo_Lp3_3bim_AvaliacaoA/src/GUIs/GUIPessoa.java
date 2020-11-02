
////////////GUI////////////

package GUIs;import DAOs.DAOPessoa;
import Entidades.Pessoa;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import tools.ManipulaArquivo;

import tools.DateTextField;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;import java.util.logging.Logger;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.Centraliza;

public class GUIPessoa extends JDialog {

private Container cp;



private JLabel lbId = new JLabel("Id");
private JLabel lbNome = new JLabel("Nome");
private JLabel lbCpf = new JLabel("Cpf");

private JLabel lbdate = new JLabel("Dtnascimento");
DateTextField dtDtnascimento = new DateTextField();

private JTextField tfId = new JTextField(50);
private JTextField tfNome = new JTextField(50);
private JTextField tfCpf = new JTextField(50);

private JButton btAdicionar = new JButton("Adicionar");
private JButton btListar = new JButton("Listar");
private JButton btBuscar = new JButton("Buscar");
private JButton btAlterar = new JButton("Alterar");
private JButton btExcluir = new JButton("Excluir");
private JButton btSalvar = new JButton("Salvar");
private JButton btCancelar = new JButton("Cancelar");
private JButton btCarregarDados = new JButton("Carregar");
private JButton btGravar = new JButton("Gravar");
private JToolBar toolBar = new JToolBar();
private JPanel painelNorte = new JPanel();
private JPanel painelCentro = new JPanel();
private JPanel painelSul = new JPanel();
private JTextArea texto = new JTextArea();
private JScrollPane scrollTexto = new JScrollPane();
private JScrollPane scrollTabela = new JScrollPane();

private String acao = "";
private String chavePrimaria = "";

private DAOPessoa controle = new DAOPessoa();
private Pessoa entidade = new Pessoa();


String[] colunas = new String[]{ "Id", "Nome", "Cpf", "Dtnascimento"};
String[][] dados = new String[0][4];
DefaultTableModel model = new DefaultTableModel(dados, colunas);
JTable tabela = new JTable(model);

private JPanel painel1 = new JPanel(new GridLayout(1, 1));
private JPanel painel2 = new JPanel(new GridLayout(1, 1));
private CardLayout cardLayout;
private JDialog jdialog;

public GUIPessoa (JFrame pai) {
    
        jdialog = new JDialog(pai, "Pessoa", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Pessoa");
        jdialog.setSize(600, 400);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1, 1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);


setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setSize(600, 400);
setTitle("CRUD Canguru - V6a");
setLocationRelativeTo(null);//centro do monitor

cp = getContentPane()

;cp.setLayout(new BorderLayout());
cp.add(painelNorte, BorderLayout.NORTH);
cp.add(painelCentro, BorderLayout.CENTER);
cp.add(painelSul, BorderLayout.SOUTH);

cardLayout = new CardLayout();
painelSul.setLayout(cardLayout);

painel1.add(scrollTexto);
painel2.add(scrollTabela);

texto.setText("\n\n\n\n\n\n");//5 linhas de tamanho
scrollTexto.setViewportView(texto);

painelSul.add(painel1, "Avisos");
painelSul.add(painel2, "Listagem");
tabela.setEnabled(false);

painelNorte.setLayout(new GridLayout(1, 1));
painelNorte.add(toolBar);

painelCentro.setLayout(new GridLayout(3, 2));


painelCentro.add(lbNome);
painelCentro.add(tfNome);
painelCentro.add(lbCpf);
painelCentro.add(tfCpf);
painelCentro.add(lbdate);
painelCentro.add(dtDtnascimento);

toolBar.add(lbId);
toolBar.add(tfId);
toolBar.add(btAdicionar);
toolBar.add(btBuscar);
toolBar.add(btListar);
toolBar.add(btAlterar);
toolBar.add(btExcluir);
toolBar.add(btSalvar);
toolBar.add(btCancelar);

btAdicionar.setVisible(false);
btAlterar.setVisible(false);
btExcluir.setVisible(false);
btSalvar.setVisible(false);
btCancelar.setVisible(false);


tfNome.setEditable(false);
tfCpf.setEditable(false);
dtDtnascimento.setEnabled(false);
texto.setEditable(false);

jdialog.add(cp);

btBuscar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btAdicionar.setVisible(false);

      cardLayout.show(painelSul, "Avisos");
      scrollTexto.setViewportView(texto);
      if (tfId.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(cp, "Id nâo pode ser vazio");
         tfId.requestFocus();
         tfId.selectAll();
      } else {
         chavePrimaria = tfId.getText();//para uso no adicionar
         entidade = controle.obter(Integer.valueOf(tfId.getText()));
         if (entidade == null) {//nao encontrou
            btAdicionar.setVisible(true);
            btAlterar.setVisible(false);
            btExcluir.setVisible(false);
            tfNome.setText("");
            tfCpf.setText("");
dtDtnascimento.setText("");
            texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");//limpa o campo texto

         } else {//encontrou
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            tfNome.setText(entidade.getNomePessoa());
            tfCpf.setText(entidade.getCpfPessoa());
            dtDtnascimento.setText(formato.format(entidade.getDataNascimento()));

            btAlterar.setVisible(true);
            btExcluir.setVisible(true);
            texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");//limpa o campo texto

            tfNome.setEditable(false);
            tfCpf.setEditable(false);
            dtDtnascimento.setEnabled(false);
         }
      }
   }
});
btAdicionar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "adicionar";
      tfId.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfId.setEditable(false);
      tfNome.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);

      btAdicionar.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfNome.setEditable(true);
      tfCpf.setEditable(true);
      dtDtnascimento.setEnabled(true);
   }
});

btAlterar.addActionListener(new ActionListener() {   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "alterar";
      tfId.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfId.setEditable(false);
      tfNome.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfNome.setEditable(true);
      tfCpf.setEditable(true);
      dtDtnascimento.setEnabled(true);
   }
});

btCancelar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      tfId.setEditable(true);

      tfNome.setText("");
      tfCpf.setText("");
      dtDtnascimento.setText("");

      tfId.requestFocus();
      tfId.selectAll();
      texto.setText("Cancelou\n\n\n\n\n");//limpa o campo texto

      tfNome.setEditable(false);
      tfCpf.setEditable(false);
      dtDtnascimento.setEditable(false);
   }
});

btSalvar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
       boolean erro = false;
      if (acao.equals("alterar")) {
         Pessoa entidadeAntigo = entidade;
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
          
                    try {
                        entidade.setDataNascimento(Date.valueOf(sdfEua.format(formato.parse(dtDtnascimento.getText()))));            
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        dtDtnascimento.setForeground(Color.RED);
                        erro = true;
                    }

         controle.atualizar(entidade);
          texto.setText("Registro alterado\n\n\n\n\n");//limpa o campo texto
      } else {//adicionar
         entidade = new Pessoa();
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");

         entidade.setIdPessoa(Integer.valueOf(tfId.getText()));
         entidade.setNomePessoa(tfNome.getText());
         entidade.setCpfPessoa(tfCpf.getText());
                    try {
                        entidade.setDataNascimento(Date.valueOf(sdfEua.format(formato.parse(dtDtnascimento.getText()))));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        dtDtnascimento.setForeground(Color.RED);
                        erro = true;
                    }
//         try {
//            entidade.setDataNascimento(Date.valueOf(sdfEua.format(formato.parse(dtDtnascimento.getText()))));
//         } catch (ParseException ex){
//            Logger.getLogger(GUIPessoa.class.getName()).log(Level.SEVERE, null, ex);
//         }

         controle.inserir(entidade);
         texto.setText("Foi adicionado um novo registro\n\n\n\n\n");//limpa o campo texto
      }
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      tfId.setEditable(true);

      tfNome.setText("");
      tfCpf.setText("");
      dtDtnascimento.setText("");

      tfId.requestFocus();
      tfId.selectAll();

      tfNome.setEditable(false);
      tfCpf.setEditable(false);
      dtDtnascimento.setEditable(false);
   }
        });

btExcluir.addActionListener(new ActionListener() {
   @Override   public void actionPerformed(ActionEvent e) {
      tfId.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      if (JOptionPane.YES_OPTION
         == JOptionPane.showConfirmDialog(null,
            "Confirma a exclusão do registro <Nome = " + entidade.getNomePessoa()+ ">?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
         controle.remover(entidade);
      }
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      tfId.setEditable(true);

      tfNome.setText("");
      tfCpf.setText("");
      dtDtnascimento.setText("");

      tfId.requestFocus();
      tfId.selectAll();
      btExcluir.setVisible(false);
      btAlterar.setVisible(false);
      texto.setText("Excluiu o registro de " + entidade.getIdPessoa()+ " - " + entidade.getNomePessoa()+ "\n\n\n\n\n");//limpa o campo texto
   }
});
btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pessoa> lt = controle.listInOrderId();

                String[] colunas = {"Id", "Nome", "Cpf", "Dtnascimento"};
                Object[][] dados = new Object[lt.size()][colunas.length];
                String aux[];
                for (int i = 0; i < lt.size(); i++) {
                    aux = lt.get(i).toString().split(";");
                    for (int j = 0; j < colunas.length; j++) {
                        dados[i][j] = aux[j];
                    }
                }
                cardLayout.show(painelSul, "Listagem");
                scrollTabela.setPreferredSize(tabela.getPreferredSize());
                painel2.add(scrollTabela);
                scrollTabela.setViewportView(tabela);
                model.setDataVector(dados, colunas);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);
            }
        });

addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em disco
                // Sai da classe
                dispose();
            }
        });
jdialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                jdialog.dispose();

            }
        });


jdialog.setVisible(true);



}

}
