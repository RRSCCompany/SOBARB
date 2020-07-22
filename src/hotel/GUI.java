
////////////GUI////////////

package Hotel;import java.awt.BorderLayout;
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
import java.util.logging.Level;import java.util.logging.Logger;import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.Centraliza;
import tools.CopiaImagem;
import tools.JanelaPesquisar;
import tools.ManipulaImagem;
public class GUI extends JFrame {

private Container cp;

public ImageIcon criarImageIcon(String caminho, String descricao) {
        java.net.URL imgURL = getClass().getResource(caminho);
        if (imgURL != null) {
            return new ImageIcon(imgURL, descricao);
        } else {
            System.err.println("Não foi possível carregar o arquivo de imagem: " + caminho);
            return null;
        }
    }

private JLabel lbCPF = new JLabel("CPF",SwingConstants.CENTER);
private JLabel lbNome = new JLabel("Nome",SwingConstants.CENTER);
private JLabel lbNumeroQuarto = new JLabel("Numero Quarto",SwingConstants.CENTER);
private JLabel lbDataEntrada = new JLabel("Data Entrada",SwingConstants.CENTER);
private JLabel lbDataSaida = new JLabel("Data Saída",SwingConstants.CENTER);
private JLabel lbEmail = new JLabel("Email",SwingConstants.CENTER);
private JLabel lbTelefone = new JLabel("Telefone",SwingConstants.CENTER);
private JLabel lbConsumo = new JLabel("Consumo",SwingConstants.CENTER);
private JLabel lbValor = new JLabel("Valor",SwingConstants.CENTER);
private JLabel lbImagemAnime = new JLabel();

private JTextField tfCPF = new JTextField(50);
private JTextField tfNome = new JTextField(50);
private JTextField tfNumeroQuarto = new JTextField(50);
DateTextField dtDataEntrada = new DateTextField();
DateTextField dtDataSaida = new DateTextField();
private JTextField tfEmail = new JTextField(50);
private JTextField tfTelefone = new JTextField(50);
private JTextField tfConsumo = new JTextField(50);
private JTextField tfValor = new JTextField(50);

private JButton btAdicionar = new JButton("Adicionar");
private JButton btListar = new JButton("Listar");
private JButton btBuscar = new JButton("Buscar");
private JButton btAlterar = new JButton("Alterar");
private JButton btExcluir = new JButton("Excluir");
private JButton btSalvar = new JButton("Salvar");
private JButton btCancelar = new JButton("Cancelar");
private JButton btCarregarDados = new JButton("Carregar");
private JButton btGravar = new JButton("Gravar");
private JButton btLocalizar = new JButton("Localizar");
private JToolBar toolBar = new JToolBar();
private JPanel painelNorte = new JPanel();
private JPanel painelCentro = new JPanel();
private JPanel painelSul = new JPanel();
private JPanel painelFoto = new JPanel();
private JTextArea texto = new JTextArea();
private JScrollPane scrollTexto = new JScrollPane();
private JScrollPane scrollTabela = new JScrollPane();
private JDialog jdialog;
private String acao = "";
private String chavePrimaria = "";

private Controle controle = new Controle();
private Hotel entidade = new Hotel();

CopiaImagem copia = new CopiaImagem();
private ManipulaImagem manipulaImagem = new ManipulaImagem();
String[] colunas = new String[]{ "CPF", "Nome", "NumeroQuarto","DataEntrada","DataSaida", "Email", "Telefone","Consumo","Valor"};
String[][] dados = new String[0][9];
DefaultTableModel model = new DefaultTableModel(dados, colunas);
JTable tabela = new JTable(model);

private JPanel painel1 = new JPanel(new GridLayout(1, 1));
private JPanel painel2 = new JPanel(new GridLayout(1, 1));
private CardLayout cardLayout;

public GUI(JFrame pai) {
    
        jdialog = new JDialog(pai, "Hotel", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Hotel");
        jdialog.setSize(600, 400);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1,1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);

String caminhoENomeDoArquivo = "DadosHospedes.csv";

setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setSize(1000, 400);
setTitle("Hotel");
setLocationRelativeTo(null);//centro do monitor

cp = getContentPane();
cp.setLayout(new BorderLayout());
cp.add(painelNorte, BorderLayout.NORTH);
cp.add(painelCentro, BorderLayout.CENTER);
cp.add(painelSul, BorderLayout.SOUTH);
cp.add(painelFoto, BorderLayout.WEST);
cardLayout = new CardLayout();
painelSul.setLayout(cardLayout);
painelFoto.setLayout(new GridLayout(1,1));
painelFoto.add(lbImagemAnime);
lbImagemAnime.setVisible(true);
ImageIcon icon = manipulaImagem.criaIcon("/icones/logohotel.jpg", 200, 200);
lbImagemAnime.setIcon(icon);

painel1.add(scrollTexto);
painel2.add(scrollTabela);

texto.setText("\n\n\n\n\n");//5 linhas de tamanho
scrollTexto.setViewportView(texto);

painelSul.add(painel1, "Avisos");
painelSul.add(painel2, "Listagem");
tabela.setEnabled(false);

painelNorte.setLayout(new GridLayout(1, 1));
painelNorte.add(toolBar);

painelCentro.setLayout(new GridLayout(4, 2));


painelCentro.add(lbNome);
painelCentro.add(tfNome);
painelCentro.add(lbNumeroQuarto);
painelCentro.add(tfNumeroQuarto);
painelCentro.add(lbDataEntrada);
painelCentro.add(dtDataEntrada);
painelCentro.add(lbDataSaida);
painelCentro.add(dtDataSaida);
painelCentro.add(lbEmail);
painelCentro.add(tfEmail);
painelCentro.add(lbTelefone);
painelCentro.add(tfTelefone);
painelCentro.add(lbConsumo);
painelCentro.add(tfConsumo);
painelCentro.add(lbValor);
painelCentro.add(tfValor);
toolBar.add(lbCPF);
toolBar.add(tfCPF);
toolBar.add(btAdicionar);
toolBar.add(btBuscar);
//toolBar.add(btListar);
toolBar.add(btAlterar);
toolBar.add(btExcluir);
toolBar.add(btSalvar);
toolBar.add(btCancelar);
toolBar.add(btLocalizar);

btAdicionar.setVisible(false);
btAlterar.setVisible(false);
btExcluir.setVisible(false);
btSalvar.setVisible(false);
btCancelar.setVisible(false);
btLocalizar.setVisible(true);

tfNome.setEditable(false);
tfNumeroQuarto.setEditable(false);
dtDataEntrada.setEditable(false);
dtDataSaida.setEditable(false);
tfEmail.setEditable(false);
tfTelefone.setEditable(false);
tfConsumo.setEditable(false);
tfValor.setEditable(false);
texto.setEditable(false);
 jdialog.add(cp);
      
btCarregarDados.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      ManipulaArquivo manipulaArquivo = new ManipulaArquivo(); //classe para facilitar o trabalho com arquivos
      if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) { //só dá para carregar dados se o arquivo existir
         String aux[];
         Hotel t;
         List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);//traz os dados em formato string
         for (String linha : listaStringCsv) {//para cada linha da lista
            aux = linha.split(";");//divida os campos nos ;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            t = new Hotel(aux[0],aux[1],aux[2], Date.valueOf(aux[3]), Date.valueOf(aux[4]),aux[5],aux[6], Integer.valueOf(aux[7]),Integer.valueOf(aux[8]));//crie um objeto Entidade e preencha com dados.

            controle.adicionar(t); //adicione na lista
         }
         cardLayout.show(painelSul, "Listagem");
      }
      else {
            manipulaArquivo.criarArquivoVazio(caminhoENomeDoArquivo);
           }
      
   }
});


      
btGravar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      List<Hotel> listaEntidade = controle.listar();//obtem a lista toda
      List<String> listaEntidadeEmFormatoStringCSV = new ArrayList<>();
      for (Hotel t : listaEntidade) { //percorre toda a lista de trabalhadores
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
      if (tfCPF.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(cp, "CPF nâo pode ser vazio");
         tfCPF.requestFocus();
         tfCPF.selectAll();
      } else {
         chavePrimaria = tfCPF.getText();//para uso no adicionar
         entidade = controle.buscar(tfCPF.getText());
         if (entidade == null) {//nao encontrou
            btAdicionar.setVisible(true);
            btLocalizar.setVisible(true);
            btAlterar.setVisible(false);
            btExcluir.setVisible(false);
            tfNome.setText("");
            tfNumeroQuarto.setText("");
            dtDataEntrada.setText("");
            dtDataSaida.setText("");
            tfEmail.setText("");
            tfTelefone.setText("");
            tfConsumo.setText("");
            tfValor.setText("");
            texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");//limpa o campo texto

         } else {//encontrou
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            tfNome.setText(entidade.getNome());
            tfNumeroQuarto.setText(entidade.getNumeroQuarto());
            dtDataEntrada.setText(formato.format(entidade.getDataEntrada()));
            dtDataSaida.setText(formato.format(entidade.getDataSaida()));
            tfEmail.setText(entidade.getEmail());
            tfTelefone.setText(entidade.getTelefone());
            tfConsumo.setText(Integer.toString(entidade.getConsumo()));
            tfValor.setText(Integer.toString(entidade.getValor()));
            

            btAlterar.setVisible(true);
            btLocalizar.setVisible(true);
            btExcluir.setVisible(true);
            texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");//limpa o campo texto

            tfNome.setEditable(false);
            tfNumeroQuarto.setEditable(false);
            dtDataEntrada.setEditable(false);
            dtDataSaida.setEditable(false);
            tfEmail.setEditable(false);
            tfTelefone.setEditable(false);
            tfConsumo.setEditable(false);
            tfValor.setEditable(false);
      
         }
      }
   }
});
btAdicionar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "adicionar";
      tfCPF.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfCPF.setEditable(false);
      tfNome.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btLocalizar.setVisible(true);
      btBuscar.setVisible(false);
//      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);

      btAdicionar.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfNome.setEditable(true);
      tfNumeroQuarto.setEditable(true);
      dtDataEntrada.setEditable(true);
      dtDataSaida.setEditable(true);
      tfEmail.setEditable(true);
      tfTelefone.setEditable(true);
      tfConsumo.setEditable(true);
      tfValor.setEditable(true);

   }
});

btAlterar.addActionListener(new ActionListener() {   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "alterar";
      tfCPF.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfCPF.setEditable(false);
      tfNome.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
//      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btLocalizar.setVisible(true);
      btExcluir.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfNome.setEditable(true);
      tfNumeroQuarto.setEditable(true);
      dtDataEntrada.setEditable(true);
      dtDataSaida.setEditable(true);
      tfEmail.setEditable(true);
      tfTelefone.setEditable(true);
      tfConsumo.setEditable(true);
      tfValor.setEditable(true);
      
   }
});

btCancelar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btLocalizar.setVisible(true);
//      btListar.setVisible(true);
      tfCPF.setEditable(true);

      tfNome.setText("");
      tfNumeroQuarto.setText("");
      dtDataEntrada.setText("");
      dtDataSaida.setText("");
      tfEmail.setText("");
      tfTelefone.setText("");
      tfConsumo.setText("");
      tfValor.setText("");

      tfCPF.requestFocus();
      tfCPF.selectAll();
      texto.setText("Cancelou\n\n\n\n\n");//limpa o campo texto

      tfNome.setEditable(false);
      tfNumeroQuarto.setEditable(false);
      dtDataEntrada.setEditable(false);
      dtDataSaida.setEditable(false);
      tfEmail.setEditable(false);
      tfTelefone.setEditable(false);
      tfConsumo.setEditable(false);
      tfValor.setEditable(false);

   }
});

btSalvar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      if (acao.equals("alterar")) {
         Hotel entidadeAntigo = entidade;
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");

         entidade.setNome(tfNome.getText());
         entidade.setNumeroQuarto(tfNumeroQuarto.getText());
          try {
              entidade.setDataEntrada(Date.valueOf(sdfEua.format(formato.parse(dtDataEntrada.getText()))));
          } catch (ParseException ex) {
              Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              entidade.setDataSaida(Date.valueOf(sdfEua.format(formato.parse(dtDataSaida.getText()))));
          } catch (ParseException ex) {
              Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
          }
         entidade.setEmail(tfEmail.getText());
         entidade.setTelefone(tfTelefone.getText());
         entidade.setConsumo(Integer.valueOf(tfConsumo.getText()));
         entidade.setValor(Integer.valueOf(tfValor.getText()));

         controle.alterar(entidade, entidadeAntigo);
          texto.setText("Registro alterado\n\n\n\n\n");//limpa o campo texto
          
       btGravar.doClick();
      } else {//adicionar
         entidade = new Hotel();
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
         
         entidade.setCPF(tfCPF.getText());
         entidade.setNome(tfNome.getText());
         entidade.setNumeroQuarto(tfNumeroQuarto.getText());
          try {
              entidade.setDataEntrada(Date.valueOf(sdfEua.format(formato.parse(dtDataEntrada.getText()))));
          } catch (ParseException ex) {
              Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              entidade.setDataSaida(Date.valueOf(sdfEua.format(formato.parse(dtDataSaida.getText()))));
          } catch (ParseException ex) {
              Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
          }
         entidade.setEmail(tfEmail.getText());
         entidade.setTelefone(tfTelefone.getText());
         entidade.setConsumo(Integer.valueOf(tfConsumo.getText()));
         entidade.setValor(Integer.valueOf(tfValor.getText()));

         controle.adicionar(entidade);
         texto.setText("Foi adicionado um novo registro\n\n\n\n\n");//limpa o campo texto

      }
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btLocalizar.setVisible(true);
//      btListar.setVisible(true);
      tfCPF.setEditable(true);

      tfNome.setText("");
      tfNumeroQuarto.setText("");
      dtDataEntrada.setText("");
      dtDataSaida.setText("");
      tfEmail.setText("");
      tfTelefone.setText("");
      tfConsumo.setText("");
      tfValor.setText("");
      tfCPF.requestFocus();
      tfCPF.selectAll();

      tfNome.setEditable(false);
      tfNumeroQuarto.setEditable(false);
      dtDataEntrada.setEditable(false);
      dtDataSaida.setEditable(false);
      tfEmail.setEditable(false);
      tfTelefone.setEditable(false);
      tfConsumo.setEditable(false);
      tfValor.setEditable(false);
       btGravar.doClick();
   }
});

btExcluir.addActionListener(new ActionListener() {
   @Override   public void actionPerformed(ActionEvent e) {
      tfCPF.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      if (JOptionPane.YES_OPTION
         == JOptionPane.showConfirmDialog(null,
            "Confirma a exclusão do registro <Nome = " + entidade.getNome() + ">?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
         controle.excluir(entidade);
      }
      btBuscar.setVisible(true);
//      btListar.setVisible(true);
      tfCPF.setEditable(true);

      tfNome.setText("");
      tfNumeroQuarto.setText("");
      dtDataEntrada.setText("");
      dtDataSaida.setText("");
      tfEmail.setText("");
      tfTelefone.setText("");
      tfConsumo.setText("");
      tfValor.setText("");

      tfCPF.requestFocus();
      tfCPF.selectAll();
      btExcluir.setVisible(false);
      btLocalizar.setVisible(true);
      btAlterar.setVisible(false);
      texto.setText("Excluiu o registro de " + entidade.getCPF() + " - " + entidade.getNome() + "\n\n\n\n\n");//limpa o campo texto

   }
});

tfNumeroQuarto.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = {"Apartamento","Hospede","Ar"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosApartamento.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = tfNumeroQuarto.getLocationOnScreen();
                    lc.x = lc.x + tfNumeroQuarto.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y, nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfNumeroQuarto.setText(aux[0]);
                    } else {
                        tfNumeroQuarto.requestFocus();
                        tfNumeroQuarto.selectAll();
                    }
                }
            }
        });

btLocalizar.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = {"CPF", "Nome", "NumeroQuarto","DataEntrada","DataSaida", "Email", "Telefone","Consumo","Valor"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosHospedes.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = btLocalizar.getLocationOnScreen();
                    lc.x = lc.x + btLocalizar.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar,
                            lc.x,
                            lc.y,
                            nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfCPF.setText(aux[0]);
                        btBuscar.doClick();
                    } else {
                        tfCPF.requestFocus();
                        tfCPF.selectAll();
                    }
                }
                if (listaAuxiliar.size() == 0) {
                   JOptionPane.showMessageDialog(jdialog, "Não há hospedes cadastados");
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
