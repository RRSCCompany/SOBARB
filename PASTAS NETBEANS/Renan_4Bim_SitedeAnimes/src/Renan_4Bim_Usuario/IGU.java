
////////////GUI////////////

package Renan_4Bim_Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
import java.util.logging.Level;import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import tools.Centraliza;
import tools.JanelaPesquisar;
import tools.ManipulaImagem;

public class IGU extends JFrame {

private Container cp;



private JLabel lbNick = new JLabel("Nick: ",SwingConstants.CENTER);
private JLabel lbNome = new JLabel("Nome:",SwingConstants.CENTER);
private JLabel lbSobrenome = new JLabel("Sobrenome:",SwingConstants.CENTER);
private JLabel lbEmail = new JLabel("Email:",SwingConstants.CENTER);
private JLabel lbSenha = new JLabel("Senha:",SwingConstants.CENTER);


private JTextField tfNick = new JTextField(50);
private JTextField tfNome = new JTextField(50);
private JTextField tfSobrenome = new JTextField(50);
private JTextField tfEmail = new JTextField(50);
private JPasswordField s = new JPasswordField(50);
private JButton btLocalizar = new JButton("Localizar");
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

private Controle controle = new Controle();
private UsuarioS entidade = new UsuarioS();
private JDialog jdialog;

String[] colunas = new String[]{ "Nick", "Nome", "Sobrenome", "Email", "Senha"};
private String[] nomeColuna = {"Nick", "Nome", "Sobrenome", "Email", "Senha"};
String[][] dados = new String[0][5];
DefaultTableModel model = new DefaultTableModel(dados, colunas);
JTable tabela = new JTable(model);

private JPanel painel1 = new JPanel(new GridLayout(1, 1));
private JPanel painel2 = new JPanel(new GridLayout(1, 1));
private CardLayout cardLayout;

private JPanel painelAnime1 = new JPanel();
private JLabel lbImagemAnime1 = new JLabel();

private JPanel painelAnime2 = new JPanel();
private JLabel lbImagemAnime2 = new JLabel();

private ManipulaImagem manipulaImagem = new ManipulaImagem();

public IGU(JFrame pai) {
    
        jdialog = new JDialog(pai, "Usuário", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Usuário");
        jdialog.setSize(900, 400);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1,1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);

String caminhoENomeDoArquivo = "DadosUsuario.csv";

setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setSize(600, 400);
setTitle("Usuário");
setLocationRelativeTo(null);//centro do monitor

cp = getContentPane();
cp.setLayout(new BorderLayout());
cp.add(painelNorte, BorderLayout.NORTH);
cp.add(painelCentro, BorderLayout.CENTER);
cp.add(painelSul, BorderLayout.SOUTH);
cp.add(painelAnime1, BorderLayout.WEST);
cp.add(painelAnime2, BorderLayout.EAST);


painelAnime1.setLayout(new GridLayout(1,1));
painelAnime1.add(lbImagemAnime1);
lbImagemAnime1.setVisible(true);
ImageIcon icon1 = manipulaImagem.criaIcon("/imagenscrud/narutousuario.jpg", 200, 200);
lbImagemAnime1.setIcon(icon1);

painelAnime2.setLayout(new GridLayout(1,1));
painelAnime2.add(lbImagemAnime2);
lbImagemAnime2.setVisible(true);
ImageIcon icon2 = manipulaImagem.criaIcon("/imagenscrud/luffyusuario.jpg", 200, 200);
lbImagemAnime2.setIcon(icon2);

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

painelCentro.setLayout(new GridLayout(4, 2));


painelCentro.add(lbNome);
painelCentro.add(tfNome);
painelCentro.add(lbSobrenome);
painelCentro.add(tfSobrenome);
painelCentro.add(lbEmail);
painelCentro.add(tfEmail);
painelCentro.add(lbSenha);
painelCentro.add(s);


toolBar.add(lbNick);
toolBar.add(tfNick);
btAdicionar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/narutoicon.png", 40,40), "Adicionar");
toolBar.add(btAdicionar);
btBuscar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/pokemonicon.png", 40,40), "Buscar");
toolBar.add(btBuscar);
btListar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/shingekiicon.png", 40,40), "Listar");
toolBar.add(btListar);
btLocalizar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/luffyicon.png", 40,40), "Localizar");
toolBar.add(btLocalizar);
btAlterar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/nanatsuicon.png", 40,40), "Alterar");
toolBar.add(btAlterar);
btExcluir = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/hunterhuntericon.png", 40,40), "Excluir");
toolBar.add(btExcluir);
btSalvar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/dragonballicon.png", 40,40), "Salvar");
toolBar.add(btSalvar);
btCancelar = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../imagenscrud/fairytailicon.jpg", 40,40), "Cancelar");
toolBar.add(btCancelar);

btAdicionar.setVisible(false);
btAlterar.setVisible(false);
btExcluir.setVisible(false);
btSalvar.setVisible(false);
btCancelar.setVisible(false);


tfNome.setEditable(false);
tfSobrenome.setEditable(false);
tfEmail.setEditable(false);
s.setEditable(false);
texto.setBackground(new Color(210,105,30));
texto.setForeground(Color.WHITE);
texto.setEditable(false);

 jdialog.add(cp);
 
btCarregarDados.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      ManipulaArquivo manipulaArquivo = new ManipulaArquivo(); //classe para facilitar o trabalho com arquivos
      if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) { //só dá para carregar dados se o arquivo existir
         String aux[];
         UsuarioS t;
         List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);//traz os dados em formato string
         for (String linha : listaStringCsv) {//para cada linha da lista
            aux = linha.split(";");//divida os campos nos ;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            t = new UsuarioS(aux[0], aux[1], aux[2], aux[3], aux[4]);//crie um objeto Entidade e preencha com dados.

            controle.adicionar(t); //adicione na lista
         }
         cardLayout.show(painelSul, "Listagem");
      }
   }
});

btGravar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      List<UsuarioS> listaEntidade = controle.listar();//obtem a lista toda
      List<String> listaEntidadeEmFormatoStringCSV = new ArrayList<>();
      for (UsuarioS t : listaEntidade) { //percorre toda a lista de trabalhadores
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
      if (tfNick.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(cp, "Nick nâo pode ser vazio");
         tfNick.requestFocus();
         tfNick.selectAll();
      } else {
         chavePrimaria = tfNick.getText();//para uso no adicionar
         entidade = controle.buscar(tfNick.getText());
         
         try {
             
         chavePrimaria = tfNick.getText();

                        entidade = controle.buscar(String.valueOf(tfNick.getText()));
         
         if (entidade == null) {//nao encontrou
            btAdicionar.setVisible(true);
            btAlterar.setVisible(false);
            btExcluir.setVisible(false);
            tfNome.setText("");
            tfSobrenome.setText("");
            tfEmail.setText("");
            s.setText("");
            texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");//limpa o campo texto
            
         } else {//encontrou
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            tfNome.setText(entidade.getNome());
            tfSobrenome.setText(entidade.getSobrenome());
            tfEmail.setText(entidade.getEmail());
            s.setText(entidade.getSenha());

            btAlterar.setVisible(true);
            btExcluir.setVisible(true);
            texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");//limpa o campo texto

            tfNome.setEditable(false);
            tfSobrenome.setEditable(false);
            tfEmail.setEditable(false);
            s.setEditable(false);
         }
         } catch (Exception Exception) {
                        JOptionPane.showMessageDialog(cp, "Atributo cpf inválido!");
      }
      }
   }
});
btAdicionar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "adicionar";
      tfNick.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfNick.setEditable(false);
      tfNome.requestFocus();
      btLocalizar.setVisible(false);
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);

      btAdicionar.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfNome.setEditable(true);
      tfSobrenome.setEditable(true);
      tfEmail.setEditable(true);
      s.setEditable(true);
   }
});

btAlterar.addActionListener(new ActionListener() {   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "alterar";
      tfNick.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfNick.setEditable(false);
      tfNome.requestFocus();
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btListar.setVisible(false);
      btLocalizar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      tfNome.setEditable(true);
      tfSobrenome.setEditable(true);
      tfEmail.setEditable(true);
      s.setEditable(true);
   }
});

btCancelar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btLocalizar.setVisible(true);
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      tfNick.setEditable(true);

      tfNome.setText("");
      tfSobrenome.setText("");
      tfEmail.setText("");
      s.setText("");

      tfNick.requestFocus();
      tfNick.selectAll();
      texto.setText("Cancelou\n\n\n\n\n");//limpa o campo texto

      tfNome.setEditable(false);
      tfSobrenome.setEditable(false);
      tfEmail.setEditable(false);
      s.setEditable(false);
   }
});

btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean erro = false;
                if (acao.equals("alterar")) {
                    UsuarioS usuarioAntigo = entidade;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    
                    try {
                        String t = tfNome.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfNome.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfNome.setBackground(Color.white);
                        entidade.setNome(String.valueOf(tfNome.getText()));
                        tfNome.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNome.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        String t = tfSobrenome.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfSobrenome.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfSobrenome.setBackground(Color.white);
                        entidade.setSobrenome(String.valueOf(tfSobrenome.getText()));
                        tfSobrenome.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfSobrenome.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        String t = tfEmail.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfEmail.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfEmail.setBackground(Color.white);
                        entidade.setEmail(String.valueOf(tfEmail.getText()));
                        tfEmail.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfEmail.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {String t = entidade.gettextpassword1(s);
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            s.setBackground(Color.red);
                            erro = true;
                        }else{
                        s.setBackground(Color.white);
                        entidade.setSenha(String.valueOf(entidade.gettextpassword1(s)));
                        s.setForeground(Color.BLACK);
                        }
                        
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        s.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    
                    if(erro == false) {
                        controle.alterar(entidade, usuarioAntigo);
                        texto.setText("Registro alterado\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btLocalizar.setVisible(true);
                        btListar.setVisible(true);
                        tfNick.setEditable(true);
                        tfNick.requestFocus();
                        tfNick.selectAll();

                        tfNome.setText("");
                        tfNome.setEditable(false);
                        tfSobrenome.setText("");
                        tfSobrenome.setEditable(false);
                        tfEmail.setText("");
                        tfEmail.setEditable(false);
                        s.setText("");
                        s.setEditable(false);
                    }
                    
                } else {
                    entidade = new UsuarioS();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    
                    try {
                        entidade.setNick(String.valueOf(tfNick.getText()));
                    } catch(Exception err) {
                        System.out.println("Erro: " + err);
                        tfNick.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        String t = tfNome.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfNome.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfNome.setBackground(Color.white);
                        entidade.setNome(String.valueOf(tfNome.getText()));
                        tfNome.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNome.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        String t = tfSobrenome.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfSobrenome.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfSobrenome.setBackground(Color.white);
                        entidade.setSobrenome(String.valueOf(tfSobrenome.getText()));
                        tfSobrenome.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfSobrenome.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        String t = tfEmail.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfEmail.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfEmail.setBackground(Color.white);
                        entidade.setEmail(String.valueOf(tfEmail.getText()));
                        tfEmail.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfEmail.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {String t = entidade.gettextpassword1(s);
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            s.setBackground(Color.red);
                            erro = true;
                        }else{
                        s.setBackground(Color.white);
                        entidade.setSenha(String.valueOf(entidade.gettextpassword1(s)));
                        s.setForeground(Color.BLACK);
                        }
                        
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        s.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    if(erro == false) {
                        controle.adicionar(entidade);
                        texto.setText("Foi adicionado um novo registro\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btLocalizar.setVisible(true);
                        btListar.setVisible(true);
                        tfNick.setEditable(true);
                        tfNick.requestFocus();
                        tfNick.selectAll();

                        tfNome.setText("");
                        tfNome.setEditable(false);
                        tfSobrenome.setText("");
                        tfSobrenome.setEditable(false);
                        tfEmail.setText("");
                        tfEmail.setEditable(false);
                        s.setText("");
                        s.setEditable(false);
                    }
                }
            }
        });



btExcluir.addActionListener(new ActionListener() {
   @Override   public void actionPerformed(ActionEvent e) {
      tfNick.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      if (JOptionPane.YES_OPTION
         == JOptionPane.showConfirmDialog(null,
            "Confirma a exclusão do registro <Nome = " + entidade.getNome() + ">?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
         controle.excluir(entidade);
      }
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      btLocalizar.setVisible(true);
      tfNick.setEditable(true);

      tfNome.setText("");
      tfSobrenome.setText("");
      tfEmail.setText("");
      s.setText("");

      tfNick.requestFocus();
      tfNick.selectAll();
      btExcluir.setVisible(false);
      btAlterar.setVisible(false);
      texto.setText("Excluiu o registro de " + entidade.getNick() + " - " + entidade.getNome() + "\n\n\n\n\n");//limpa o campo texto
   }
});
btListar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      List<UsuarioS> lt = controle.listar();


      String[] colunas = {"Nick", "Nome", "Sobrenome", "Email", "Senha"};
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

btLocalizar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<String> listaAuxiliar = controle.listStrings();
                if (listaAuxiliar.size() > 0) {
                    Point lc = btLocalizar.getLocationOnScreen();
                    lc.x = lc.x + btLocalizar.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar,
                            lc.x,
                            lc.y,
                            nomeColuna).getValorRetornado();
                    if(!selectedItem.equals("")){
                        String[] aux = selectedItem.split(";");
                        tfNick.setText(aux[0]);
                        btBuscar.doClick();
                    } else {
                        tfNick.requestFocus();
                        tfNick.selectAll();
                    }
                }
            }
        });
tfNick.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = { "Nick", "Nome", "Sobrenome", "Email", "Senha"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosUsuario.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = tfNick.getLocationOnScreen();
                    lc.x = lc.x + tfNick.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y, nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfNick.setText(aux[0]);
                    } else {
                        tfNick.requestFocus();
                        tfNick.selectAll();
                    }
                }
            }
        });
jdialog.addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
      
      btGravar.doClick();
     
      jdialog.dispose();
   }
});

btCarregarDados.doClick();
jdialog.setVisible(true);


}

}
