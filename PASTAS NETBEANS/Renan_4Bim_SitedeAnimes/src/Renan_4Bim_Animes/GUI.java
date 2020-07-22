
////////////GUI////////////

package Renan_4Bim_Animes;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import tools.Centraliza;
import tools.CopiaImagem;
import tools.JanelaPesquisar;
import tools.ManipulaImagem;

public class GUI extends JDialog {

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

private JLabel lbAddAnime = new JLabel("Adicionar à lista?",SwingConstants.CENTER);
private JLabel lbNome = new JLabel("Nome do Anime: ",SwingConstants.CENTER);
private JLabel lbDia = new JLabel("Dia de Lançamento:",SwingConstants.CENTER);
private JLabel lbNumeroep = new JLabel("Número de Episódios:",SwingConstants.CENTER);
private JLabel lbEstado = new JLabel("Estado:",SwingConstants.CENTER);
private JLabel lbSinopse = new JLabel("Sinopse:",SwingConstants.CENTER);
private JLabel lbTema = new JLabel("Tema:",SwingConstants.CENTER);

private JLabel lbdate = new JLabel("Data:",SwingConstants.CENTER);
DateTextField dtData = new DateTextField();

private JCheckBox cbAddAnime = new JCheckBox("", false);
private JTextField tfNome = new JTextField(50);
private JTextField tfDia = new JTextField(50);
private JTextField tfNumeroep = new JTextField(50);
private JTextField tfEstado = new JTextField(50);
private JTextField tfSinopse = new JTextField(50);
private JTextField tfTema = new JTextField(50);

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
private JPanel painelFoto = new JPanel();
private JLabel lbImagemAnime = new JLabel();


private JLabel lbUsuario = new JLabel("Usuario: ",SwingConstants.CENTER);    //Chave extrangeira
private JTextField tfUsuario = new JTextField(60);


private String acao = "";
private String chavePrimaria = "";

private Controle controle = new Controle();
private Animes entidade = new Animes();

private JDialog jdialog;

CopiaImagem copia = new CopiaImagem();
private ManipulaImagem manipulaImagem = new ManipulaImagem();
String[] colunas = new String[]{ "Nome", "Data", "Dia", "Numeroep", "Estado", "Sinopse", "Tema","AddAnime","Usuario"};
String[][] dados = new String[0][9];
DefaultTableModel model = new DefaultTableModel(dados, colunas);
JTable tabela = new JTable(model);

private JPanel painel1 = new JPanel(new GridLayout(1, 1));
private JPanel painel2 = new JPanel(new GridLayout(1, 1));
private CardLayout cardLayout;

 private String[] nomeColuna = {"Nome", "Data", "Dia", "Numeroep", "Estado", "Sinopse", "Tema","AddAnime","Usuario"};
 
public GUI(JFrame pai) {
    
        jdialog = new JDialog(pai, "Animes", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Animes");
        jdialog.setSize(600, 400);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1,1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);
        
       
        
        

String caminhoENomeDoArquivo = "DadosAnimes.csv";

setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setSize(600, 400);

  
setTitle("CRUD Canguru - V6a");
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
ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/logo.jpg", 200, 200);
lbImagemAnime.setIcon(icon);

texto.setBackground(new Color(210,105,30));
texto.setForeground(Color.WHITE);


painel1.add(scrollTexto);
painel2.add(scrollTabela);

texto.setText("\n\n\n\n\n\n");//5 linhas de tamanho
scrollTexto.setViewportView(texto);

painelSul.add(painel1, "Avisos");
painelSul.add(painel2, "Listagem");
tabela.setEnabled(false);

painelNorte.setLayout(new GridLayout(1, 1));
painelNorte.add(toolBar);

painelCentro.setLayout(new GridLayout(9, 2));



painelCentro.add(lbdate);
painelCentro.add(dtData);
painelCentro.add(lbDia);
painelCentro.add(tfDia);
painelCentro.add(lbNumeroep);
painelCentro.add(tfNumeroep);
painelCentro.add(lbEstado);
painelCentro.add(tfEstado);
painelCentro.add(lbSinopse);
painelCentro.add(tfSinopse);
painelCentro.add(lbTema);
painelCentro.add(tfTema);
painelCentro.add(lbAddAnime);
painelCentro.add(cbAddAnime);
painelCentro.add(lbUsuario);
painelCentro.add(tfUsuario);
toolBar.add(lbNome);
toolBar.add(tfNome);

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



dtData.setEditable(false);
tfDia.setEditable(false);
tfNumeroep.setEditable(false);
tfEstado.setEditable(false);
tfSinopse.setEditable(false);
tfTema.setEditable(false);
tfUsuario.setEditable(false);
cbAddAnime.setEnabled(false);
texto.setEditable(false);
dtData.setText("");
 jdialog.add(cp);
 
btCarregarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) {
                    String aux[];
                    Animes t;
                    List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);
                    for (String linha : listaStringCsv) {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");

                        aux = linha.split(";");
                        try {
                           
                            t = new Animes(String.valueOf(aux[0]),Date.valueOf(sdfEua.format(formato.parse(aux[1]))),String.valueOf(aux[2]),Integer.valueOf(aux[3]),String.valueOf(aux[4]),String.valueOf(aux[5]),String.valueOf(aux[6]),Boolean.valueOf(aux[7].equals("true")?true:false),String.valueOf(aux[8]));
                            controle.adicionar(t);
                        } catch (ParseException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                    }

                    cardLayout.show(painelSul, "Listagem");
                } else {
                    manipulaArquivo.criarArquivoVazio(caminhoENomeDoArquivo);
                }
            }
        });

btGravar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      List<Animes> listaEntidade = controle.listar();//obtem a lista toda
      List<String> listaEntidadeEmFormatoStringCSV = new ArrayList<>();
      for (Animes t : listaEntidade) { //percorre toda a lista de trabalhadores
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
      if (tfNome.getText().trim().isEmpty()) {
         JOptionPane.showMessageDialog(cp, "Nome nâo pode ser vazio");
         tfNome.requestFocus();
         tfNome.selectAll();
      } else {
           try {
                        
         chavePrimaria = tfNome.getText();//para uso no adicionar
         entidade = controle.buscar(tfNome.getText());
         if (entidade == null) {//nao encontrou
            btAdicionar.setVisible(true);
            btAlterar.setVisible(false);
            btExcluir.setVisible(false);
            dtData.setText("");
            tfDia.setText("");
            tfNumeroep.setText("");
            tfEstado.setText("");
            tfSinopse.setText("");
            tfTema.setText("");
            cbAddAnime.setSelected(false);
            tfUsuario.setText("");
            texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");//limpa o campo texto
            ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/onepunchusuario.jpg", 200, 200);
            lbImagemAnime.setIcon(icon);
            

         } else {//encontrou
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            dtData.setText(formato.format(entidade.getData()));
            tfDia.setText(entidade.getDia());
            tfNumeroep.setText(Integer.toString(entidade.getNumeroep()));
            tfEstado.setText(entidade.getEstado());
            tfSinopse.setText(entidade.getSinopse());
            tfTema.setText(entidade.getTema());
            tfUsuario.setText(entidade.getUsuario());
            cbAddAnime.setSelected(entidade.isAddAnime());
         
            btLocalizar.setVisible(true);
            btAlterar.setVisible(true);
            btExcluir.setVisible(true);
            texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");//limpa o campo texto
            
            dtData.setEditable(false);
            tfDia.setEditable(false);
            tfNumeroep.setEditable(false);
            tfEstado.setEditable(false);
            tfSinopse.setEditable(false);
            tfTema.setEditable(false);
            tfUsuario.setEditable(false);
            cbAddAnime.setEnabled(false);
            
            lbImagemAnime.setVisible(true);
            String aux = String.valueOf(entidade.getNome().trim());
            String origem = "src/imagenscrud/" + aux + ".png";
            File img = new File(origem);
            ImageIcon icone;
            if(img.exists()) {
                icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                } else {
                    origem = "src/imagenscrud/trigunusuario.jpg";
                    img = new File(origem);
                    icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                    }
                            
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(200, 200, Image.SCALE_FAST));
                            lbImagemAnime.setIcon(icone);
         }
         } catch (Exception Exception) {
                        JOptionPane.showMessageDialog(cp, "Atributo Nome inválido!");

                    }
      }
   }
});
btAdicionar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "adicionar";
      tfNome.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfNome.setEditable(false);
      dtData.requestFocus();
      btLocalizar.setVisible(false);
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);

      btAdicionar.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
       
      dtData.setEditable(true);
      tfDia.setEditable(true);
      tfNumeroep.setEditable(true);
      tfEstado.setEditable(true);
      tfSinopse.setEditable(true);
      tfTema.setEditable(true);
      tfUsuario.setEditable(true);
      cbAddAnime.setEnabled(true);
   
      ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/Base.png", 200, 200);
      lbImagemAnime.setIcon(icon);
   }
});

btAlterar.addActionListener(new ActionListener() {   @Override
   public void actionPerformed(ActionEvent e) {
      acao = "alterar";
      tfNome.setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)
      tfNome.setEditable(false);
      tfDia.requestFocus();
      btLocalizar.setVisible(false);
      btSalvar.setVisible(true);
      btCancelar.setVisible(true);
      btBuscar.setVisible(false);
      btListar.setVisible(false);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);
      texto.setText("Preencha os atributos\n\n\n\n\n");//limpa o campo texto
      dtData.setEditable(true);
      tfDia.setEditable(true);
      tfNumeroep.setEditable(true);
      tfEstado.setEditable(true);
      tfSinopse.setEditable(true);
      tfTema.setEditable(true);
      tfUsuario.setEditable(true);
      cbAddAnime.setEnabled(true);
      
      String aux = String.valueOf(entidade.getNome().trim());
            String origem = "src/imagenscrud/" + aux + ".png";
            File img = new File(origem);
            ImageIcon icone;
            if(img.exists()) {
                icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                } else {
                    origem = "src/imagenscrud/luffyusuario.jpg";
                    img = new File(origem);
                    icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                    }
                            
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(200, 200, Image.SCALE_FAST));
                            lbImagemAnime.setIcon(icone);
                                
            }
});

btCancelar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      btSalvar.setVisible(false);
      btCancelar.setVisible(false);
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      tfNome.setEditable(true);

      dtData.setText("");
      tfDia.setText("");
      tfNumeroep.setText("");
      tfEstado.setText("");
      tfSinopse.setText("");
      tfTema.setText("");
      tfUsuario.setText("");
      cbAddAnime.setSelected(false);


      tfNome.requestFocus();
      tfNome.selectAll();
      texto.setText("Cancelou\n\n\n\n\n");//limpa o campo texto

      dtData.setEditable(false);
      tfDia.setEditable(false);
      tfNumeroep.setEditable(false);
      tfEstado.setEditable(false);
      tfSinopse.setEditable(false);
      tfTema.setEditable(false);
      tfUsuario.setEditable(false);
      cbAddAnime.setEnabled(false);
      
      ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/onepunchusuario.jpg", 200, 200);
      lbImagemAnime.setIcon(icon);
   }
});
btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean erro = false;
                if (acao.equals("alterar")) {
                    Animes animeAntigo = entidade;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    
                    try {
                      
                       
                        entidade.setData(Date.valueOf(sdfEua.format(formato.parse(dtData.getText()))));
                        dtData.setForeground(Color.BLACK);
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        dtData.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        String t = tfDia.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfDia.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfDia.setBackground(Color.white);
                        entidade.setDia(String.valueOf(tfDia.getText()));
                        tfDia.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfDia.setForeground(Color.RED);
                       
                        erro = true;
                    }
                    
                    try {
                        String t = tfNumeroep.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfNumeroep.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfNumeroep.setBackground(Color.white);
                        entidade.setNumeroep(Integer.valueOf(tfNumeroep.getText()));
                        tfNumeroep.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNumeroep.setForeground(Color.RED);
                        tfNumeroep.setBackground(Color.red);
                        erro = true;
                    }
                    
                    try {
                        String t = tfEstado.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfEstado.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfEstado.setBackground(Color.white);
                        entidade.setEstado(String.valueOf(tfEstado.getText()));
                        tfEstado.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfEstado.setForeground(Color.RED);
                        tfEstado.setBackground(Color.red);
                        erro = true;
                    }

                    
                    try {
                        String t = tfSinopse.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfSinopse.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfSinopse.setBackground(Color.white);
                        entidade.setSinopse(String.valueOf(tfSinopse.getText()));
                        tfSinopse.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfSinopse.setForeground(Color.RED);
                        tfSinopse.setBackground(Color.red);
                        erro = true;
                    }
                    
                    try {
                        String t = tfTema.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfTema.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfTema.setBackground(Color.white);
                        entidade.setTema(String.valueOf(tfTema.getText()));
                        tfTema.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfTema.setForeground(Color.RED);
                        tfTema.setBackground(Color.red);
                        erro = true;
                    }
                    
                     
                  
                    
                    try {
                        String t = tfUsuario.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfUsuario.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfUsuario.setBackground(Color.white);
                        entidade.setUsuario(String.valueOf(tfUsuario.getText()));
                        tfUsuario.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfUsuario.setForeground(Color.RED);
                        tfUsuario.setBackground(Color.red);
                        erro = true;
                    }

                    entidade.setAddAnime(cbAddAnime.isSelected());
                    if(erro == false) {
                        controle.alterar(entidade, animeAntigo);
                        texto.setText("Registro alterado\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                        btLocalizar.setVisible(true);
                        tfNome.setEditable(true);
                        tfNome.requestFocus();
                        tfNome.selectAll();

                        dtData.setText("");
                        dtData.setEditable(false);
                        tfDia.setText("");
                        tfDia.setEditable(false);
                        tfNumeroep.setText("");
                        tfNumeroep.setEditable(false);
                        tfEstado.setText("");
                        tfEstado.setEditable(false);
                        tfSinopse.setText("");
                        tfSinopse.setEditable(false);
                        tfTema.setText("");
                        tfTema.setEditable(false);
                        tfUsuario.setText("");
                        tfUsuario.setEditable(false);
                        cbAddAnime.setText("");
                        cbAddAnime.setSelected(false);
                       
                        ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/trigunusuario.jpg", 200, 200);
                        lbImagemAnime.setIcon(icon);
                    }
                    
                } else {
                    entidade = new Animes();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    
                    try {
                        entidade.setNome(String.valueOf(tfNome.getText()));
                        tfNome.setForeground(Color.BLACK);
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNome.setForeground(Color.RED);
                        tfNome.setBackground(Color.red);
                        erro = true;
                    }
                    
                    try {
                        entidade.setData(Date.valueOf(sdfEua.format(formato.parse(dtData.getText()))));
                        dtData.setForeground(Color.BLACK);
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        dtData.setForeground(Color.RED);
                        dtData.setBackground(Color.red);
                        erro = true;
                    }
                    
                    try {
                        String t = tfDia.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfDia.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfDia.setBackground(Color.white);
                        entidade.setDia(String.valueOf(tfDia.getText()));
                        tfDia.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfDia.setForeground(Color.RED);
                       
                        erro = true;
                    }
                    
                    try {
                        String t = tfNumeroep.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfNumeroep.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfNumeroep.setBackground(Color.white);
                        entidade.setNumeroep(Integer.valueOf(tfNumeroep.getText()));
                        tfNumeroep.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNumeroep.setForeground(Color.RED);
                        tfNumeroep.setBackground(Color.red);
                        erro = true;
                    }
                    
                    try {
                        String t = tfEstado.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfEstado.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfEstado.setBackground(Color.white);
                        entidade.setEstado(String.valueOf(tfEstado.getText()));
                        tfEstado.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfEstado.setForeground(Color.RED);
                        tfEstado.setBackground(Color.red);
                        erro = true;
                    }

                    
                    try {
                        String t = tfSinopse.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfSinopse.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfSinopse.setBackground(Color.white);
                        entidade.setSinopse(String.valueOf(tfSinopse.getText()));
                        tfSinopse.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfSinopse.setForeground(Color.RED);
                        tfSinopse.setBackground(Color.red);
                        erro = true;
                    }
                    
                    try {
                        String t = tfTema.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfTema.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfTema.setBackground(Color.white);
                        entidade.setTema(String.valueOf(tfTema.getText()));
                        tfTema.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfTema.setForeground(Color.RED);
                        tfTema.setBackground(Color.red);
                        erro = true;
                    }
                    
                     
                  
                    
                    try {
                        String t = tfUsuario.getText();
                        if (t.equals("")) {
                            System.out.println("Campo Vazio!");
                            tfUsuario.setBackground(Color.red);
                            erro = true;
                        }else{
                        tfUsuario.setBackground(Color.white);
                        entidade.setUsuario(String.valueOf(tfUsuario.getText()));
                        tfUsuario.setForeground(Color.BLACK);
                        }
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfUsuario.setForeground(Color.RED);
                        tfUsuario.setBackground(Color.red);
                        erro = true;
                    }
                    
                    entidade.setAddAnime(cbAddAnime.isSelected());
                    
                    boolean verificaFk = true;
                    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                    List<String> listaAnime = manipulaArquivo.abrirArquivo("DadosUsuario.csv");
                    
                    if(listaAnime.size()==0){
                        verificaFk = false;
                    } else {
                        for (int i = 0; i < listaAnime.size(); i++) {
                            
                            if(String.valueOf(listaAnime.get(i)).split(";")[0].equals(tfUsuario.getText())){    
                                verificaFk = true;
                                break;
                            } else {
                                verificaFk = false;
                            }
                        }
                    }
                    if(verificaFk == true){
                        entidade.setUsuario(String.valueOf(tfUsuario.getText()));
                        tfUsuario.setForeground(Color.BLACK);
                    } else {
                        System.out.println("Erro: o usuario introduzido não existe");                 
                        tfUsuario.setForeground(Color.RED);
                        tfUsuario.setBackground(Color.red);
                        erro = true;
                    }
                    

                    
                    if(erro == false) {
                        controle.adicionar(entidade);
                        texto.setText("Foi adicionado um novo registro\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                        btLocalizar.setVisible(true);
                        tfNome.setEditable(true);
                        tfNome.requestFocus();
                        tfNome.selectAll();

                        dtData.setText("");
                        dtData.setEditable(false);
                        tfDia.setText("");
                        tfDia.setEditable(false);
                        tfNumeroep.setText("");
                        tfNumeroep.setEditable(false);
                        tfEstado.setText("");
                        tfEstado.setEditable(false);
                        tfSinopse.setText("");
                        tfSinopse.setEditable(false);
                        tfTema.setText("");
                        tfTema.setEditable(false);
                        tfUsuario.setText("");
                        tfUsuario.setEditable(false);
                        cbAddAnime.setText("");
                        cbAddAnime.setSelected(false);
                        ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/trigunusuario.jpg", 200, 200);
                        lbImagemAnime.setIcon(icon);
                    }
                }
            }
        });



btExcluir.addActionListener(new ActionListener() {
   @Override   public void actionPerformed(ActionEvent e) {
     tfNome.setText(chavePrimaria);
                if (JOptionPane.YES_OPTION
                        == JOptionPane.showConfirmDialog(null,
                                "Confirma a exclusão do registro <Nome = " + entidade.getNome() + ">?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.excluir(entidade);
                    
                    File f = new File("C:\\Users\\Renan\\Desktop\\COISAS DO RENAN\\Renan_4Bim_SitedeAnimes\\src\\imagenscrud\\"+String.valueOf(entidade.getNome())+".png");
                    if(f.exists()){
                        f.delete();
                    }
                }
      btBuscar.setVisible(true);
      btListar.setVisible(true);
      tfNome.setEditable(true);

      dtData.setText("");
      tfDia.setText("");
      tfNumeroep.setText("");
      tfEstado.setText("");
      tfSinopse.setText("");
      tfTema.setText("");
      tfUsuario.setText("");
      cbAddAnime.setSelected(false);

      tfNome.requestFocus();
      tfNome.selectAll();
      btExcluir.setVisible(false);
      btAlterar.setVisible(false);
      ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/pikachuusuario.png", 200, 200);
      lbImagemAnime.setIcon(icon);
      texto.setText("Excluiu o registro de " + entidade.getNome() + "\n\n\n\n\n");//limpa o campo texto
   }
});
btListar.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      List<Animes> lt = controle.listar();


      String[] colunas = {"Nome", "Data", "Dia", "Numeroep", "Estado", "Sinopse", "Tema","AddAnime","Usuario"};
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
      ImageIcon icon = manipulaImagem.criaIcon("/imagenscrud/drstoneusuario.jpg", 200, 200);
      lbImagemAnime.setIcon(icon);
      btAlterar.setVisible(false);
      btExcluir.setVisible(false);
      btAdicionar.setVisible(false);
   }
});

 btLocalizar.addActionListener(new ActionListener() {
            String[] nomeColuna = {"Nome", "Data", "Dia", "Numeroep", "Estado", "Sinopse", "Tema","AddAnime"};
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
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfNome.setText(aux[0]);
                        btBuscar.doClick();
                    } else {
                        tfNome.requestFocus();
                        tfNome.selectAll();
                    }
                }
            }
        });


lbImagemAnime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (acao.equals("alterar")||acao.equals("adicionar")) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                        File img = fc.getSelectedFile();
                        String origem = fc.getSelectedFile().getAbsolutePath();
                        try {
                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(200, 200, Image.SCALE_FAST));
                            lbImagemAnime.setIcon(icone);
                            
                            String destino = "C:\\Users\\Renan\\Desktop\\COISAS DO RENAN\\Renan_4Bim_SitedeAnimes\\src\\imagenscrud\\" +String.valueOf(tfNome.getText()) + ".png";
                           
                            copia.copiar(origem, destino);
                  
                        } catch (Exception ex){
                            System.out.println("Erro: " + ex.getMessage());
                        }
                    }
                }
            }
        });

 tfUsuario.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = {"Nick", "Nome", "Sobrenome", "Email", "Senha"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosUsuario.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = tfUsuario.getLocationOnScreen();
                    lc.x = lc.x + tfUsuario.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y, nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfUsuario.setText(aux[0]);
                    } else {
                        tfUsuario.requestFocus();
                        tfUsuario.selectAll();
                    }
                }
            }
        });
 
 tfNome.addMouseListener(new MouseAdapter() {
            String[] nomeColuna = {"Nome", "Data", "Dia", "Numeroep", "Estado", "Sinopse", "Tema","AddAnime","Usuario"};
            @Override
            public void mouseClicked(MouseEvent e){
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosAnimes.csv");
                if (listaAuxiliar.size() > 0) {
                    Point lc = tfNome.getLocationOnScreen();
                    lc.x = lc.x + tfNome.getWidth();
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y, nomeColuna).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split(";");
                        tfNome.setText(aux[0]);
                    } else {
                        tfNome.requestFocus();
                        tfNome.selectAll();
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
jdialog.setVisible(true);

//depois que a tela ficou visível, clic o botão automaticamente.

}

}
