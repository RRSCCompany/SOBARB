
////////////GUI////////////

package Apartamento;import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import java.util.logging.Level;import java.util.logging.Logger;import javax.swing.JDialog;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.Centraliza;
import tools.JanelaPesquisar;
public class IUG extends JFrame {

private Container cp;



private JLabel lbApartamento = new JLabel("Apartamento",SwingConstants.CENTER);
private JLabel lbAr = new JLabel("Ar",SwingConstants.CENTER);
private JLabel lbHospede = new JLabel("Hospede",SwingConstants.CENTER);


private JTextField tfApartamento = new JTextField(50);
private JTextField tfAr = new JTextField(50);
private JTextField tfHospede = new JTextField(50);

private JButton btAdicionar = new JButton("Adicionar");
private JButton btLocalizar = new JButton("Localizar");
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
private JDialog jdialog = new JDialog();
private String acao = "";
private String chavePrimaria = "";

private Controle controle = new Controle();
private Apartamento entidade = new Apartamento();


String[] colunas = new String[]{ "Apartamento","Hospede","Ar"};
String[][] dados = new String[0][3];
DefaultTableModel model = new DefaultTableModel(dados, colunas);
JTable tabela = new JTable(model);

private JPanel painel1 = new JPanel(new GridLayout(1, 1));
private JPanel painel2 = new JPanel(new GridLayout(1, 1));
private CardLayout cardLayout;

public IUG(JFrame pai) {
    
    jdialog = new JDialog(pai, "Apartamento", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Apartamento");
        jdialog.setSize(400, 235);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1,1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);

String caminhoENomeDoArquivo = "DadosApartamento.csv";

setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setSize(400, 300);
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

painelCentro.setLayout(new GridLayout(1, 1));


painelCentro.add(lbAr);
painelCentro.add(tfAr);
painelCentro.add(lbHospede);
painelCentro.add(tfHospede);

toolBar.add(lbApartamento);
toolBar.add(tfApartamento);
toolBar.add(btAdicionar);
toolBar.add(btBuscar);
toolBar.add(btLocalizar);
toolBar.add(btAlterar);
toolBar.add(btExcluir);
toolBar.add(btSalvar);
toolBar.add(btCancelar);

btAdicionar.setVisible(false);
btAlterar.setVisible(false);
btExcluir.setVisible(false);
btSalvar.setVisible(false);
btCancelar.setVisible(false);


tfAr.setEditable(false);
tfHospede.setEditable(false);
texto.setEditable(false);
 jdialog.add(cp);
 
btCarregarDados.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      ManipulaArquivo manipulaArquivo = new ManipulaArquivo(); //classe para facilitar o trabalho com arquivos
      if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) { //só dá para carregar dados se o arquivo existir
         String aux[];
         Apartamento t;
         List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);//traz os dados em formato string
         for (String linha : listaStringCsv) {//para cada linha da lista
            aux = linha.split(";");//divida os campos nos ;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            t = new Apartamento(aux[0], aux[1],aux[2]);//crie um objeto Entidade e preencha com dados.

            controle.adicionar(t); //adicione na lista
         }
         cardLayout.show(painelSul, "Listagem");
      }
   }
});

btGravar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      List<Apartamento> listaEntidade = controle.listar();//obtem a lista toda
      List<String> listaEntidadeEmFormatoStringCSV = new ArrayList<>();
      for (Apartamento t : listaEntidade) { //percorre toda a lista de trabalhadores
         listaEntidadeEmFormatoStringCSV.add(t.toString());//para cada entidade t, transforme em string.
      }
      new ManipulaArquivo().salvarArquivo(caminhoENomeDoArquivo, listaEntidadeEmFormatoStringCSV);
      System.out.println("gravou");
   }
});

btBuscar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btAdicionar.setVisible(false);

      cardLayout.show(painelSul, "Avisos");
      scrollTexto.setViewportView(texto);
      if (tfApartamento.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(cp, "Apartamento nâo pode ser vazio");
         tfApartamento.requestFocus();
         tfApartamento.selectAll();
      } else {
         chavePrimaria = tfApartamento.getText();//para uso no adicionar
         entidade = controle.buscar(tfApartamento.getText());
         if (entidade == null) {//nao encontrou
            btAdicionar.setVisible(true);
            btAlterar.setVisible(false);
            btExcluir.setVisible(false);
            tfAr.setText("");
            tfHospede.setText("");
            texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");//limpa o campo texto

         } else {//encontrou
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            tfAr.setText(entidade.getAr());
            tfHospede.setText(entidade.getHospede());

            btAlterar.setVisible(true);
            btExcluir.setVisible(true);
            btAdicionar.setVisible(false);
            btLocalizar.setVisible(false);
            btBuscar.setVisible(false);
            texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");//limpa o campo texto

            tfAr.setEditable(false);
            tfHospede.setEditable(false);
         }
      }
   }
});
btAdicionar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "adicionar";
      tfApartamento.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfApartamento.setEditable(false);
      tfAr.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btLocalizar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);

      btAdicionar.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfAr.setEditable(true);
      tfHospede.setEditable(true);
   }
});

btAlterar.addActionListener(new ActionListener() {   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "alterar";
      tfApartamento.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfApartamento.setEditable(false);
      tfAr.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btLocalizar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfAr.setEditable(true);
      tfHospede.setEditable(true);
   }
});

btCancelar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btLocalizar.setVisible(true);
      tfApartamento.setEditable(true);

      tfAr.setText("");
      tfHospede.setText("");

      tfApartamento.requestFocus();
      tfApartamento.selectAll();
      texto.setText("Cancelou\n\n\n\n\n");//limpa o campo texto

      tfAr.setEditable(false);
      tfHospede.setEditable(false);
   }
});

btSalvar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      if (acao.equals("alterar")) {
         Apartamento entidadeAntigo = entidade;
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");

         entidade.setAr(tfAr.getText());
         entidade.setHospede(tfHospede.getText());

         controle.alterar(entidade, entidadeAntigo);
          texto.setText("Registro alterado\n\n\n\n\n");//limpa o campo texto
          btGravar.doClick();
      } else {//adicionar
         entidade = new Apartamento();
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");

         entidade.setApartamento(tfApartamento.getText());
         entidade.setAr(tfAr.getText());
         entidade.setHospede(tfHospede.getText());

         controle.adicionar(entidade);
         texto.setText("Foi adicionado um novo registro\n\n\n\n\n");//limpa o campo texto
         btGravar.doClick();
      }
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btLocalizar.setVisible(true);
      tfApartamento.setEditable(true);

      tfAr.setText("");
      tfHospede.setText("");

      tfApartamento.requestFocus();
      tfApartamento.selectAll();

      tfAr.setEditable(false);
      tfHospede.setEditable(false);
   }
});

btExcluir.addActionListener(new ActionListener() {
   @Override   public void actionPerformed(ActionEvent e) {
      tfApartamento.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      if (JOptionPane.YES_OPTION
         == JOptionPane.showConfirmDialog(null,
            "Confirma a exclusão do registro <Ar = " + entidade.getAr() + ">?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
         controle.excluir(entidade);
        
      }
      btBuscar.setVisible(true);
      btLocalizar.setVisible(true);
      tfApartamento.setEditable(true);

      tfAr.setText("");
      tfHospede.setText("");

      tfApartamento.requestFocus();
      tfApartamento.selectAll();
      btExcluir.setVisible(false);
      btAlterar.setVisible(false);
      btGravar.doClick();
      texto.setText("Excluiu o registro de " + entidade.getApartamento() + " - " + entidade.getAr() + "\n\n\n\n\n");//limpa o campo texto
   }
});

btLocalizar.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = {"Apartamento","Hospede","Ar"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosApartamento.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = btLocalizar.getLocationOnScreen();
                    lc.x = lc.x + btLocalizar.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar,
                            lc.x,
                            lc.y,
                            nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfApartamento.setText(aux[0]);
                        btBuscar.doClick();
                    } else {
                        tfApartamento.requestFocus();
                        tfApartamento.selectAll();
                    }
                }
                if (listaAuxiliar.size() == 0) {
                   JOptionPane.showMessageDialog(jdialog, "Não há Apartamentos cadastados");
                }
            }
});
tfHospede.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = {"Apartamento","Hospede","Ar"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosHospedes.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = tfHospede.getLocationOnScreen();
                    lc.x = lc.x + tfHospede.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y, nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfHospede.setText(aux[0]);
                    } else {
                        tfHospede.requestFocus();
                        tfHospede.selectAll();
                    }
                }
            }
        });

addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
      //antes de sair, salvar a lista em disco
      btGravar.doClick();
      // Sai da classe
      dispose();
   }
});

jdialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                btGravar.doClick();
                jdialog.dispose();

            }
        });

btCarregarDados.doClick();//execute o listener do btCarregarDados
jdialog.setVisible(true);//execute o listener do btCarregarDados

}

}
