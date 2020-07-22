package Produto;

import java.awt.BorderLayout;
import java.sql.Date;
import tools.Tools;
import java.text.SimpleDateFormat;
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
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.JanelaPesquisar;
import tools.ManipulaImagem;
import tools.Centraliza;
import tools.CopiaImagem;

public class GUI extends JDialog {
    
    private Container cp;
    
    public GUI(Container cp) {
    }
    
    private JLabel lbId = new JLabel("Id Produto: ", SwingConstants.CENTER);
    private JLabel lbSabor = new JLabel("nome Produto:", SwingConstants.CENTER);
    private JLabel lbDataTipo = new JLabel("Data de lançamento:", SwingConstants.CENTER);


    
    public ImageIcon criarImageIcon(String caminho, String descricao) {
        java.net.URL imgURL = getClass().getResource(caminho);
        if (imgURL != null) {
            return new ImageIcon(imgURL, descricao);
        } else {
            System.err.println("Não foi possível carregar o arquivo de imagem: " + caminho);
            return null;
        }
    }

    CopiaImagem copia = new CopiaImagem();
    //private JLabel lbId = new JLabel("id");
    //private JLabel lbSabor = new JLabel("Sabor");
    private JButton lbBtnomeTipo = new JButton("Tipo");

    //private JLabel lbNomeTipo = new JLabel("Pizzaria");
    private JTextField tfId = new JTextField(50);
    private JTextField nomeProduto = new JTextField(50);
    private JTextField tffk = new JTextField(50);

    private DateTextField tfData = new DateTextField();
    //private JLabel lbDataTipo = new JLabel("Data");
    private JCheckBox cbAtivo = new JCheckBox("Ativo", false);
    private JLabel lbVazio = new JLabel();
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
    private JLabel lbImagem = new JLabel();
    
    private String acao = "";
    private String chavePrimaria = "";
    private PizzaControle controle = new PizzaControle();
    private Pizza entidade = new Pizza();
    Tools tools = new Tools();
    String[] colunas = new String[]{"Id", "Produto", "fk",  "Data",  "Ativo"};
    String[][] dados = new String[0][5];
    
    private JDialog jdialog;
    
    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);
    private JPanel painel1 = new JPanel(new GridLayout(1, 1));
    private JPanel painel2 = new JPanel(new GridLayout(1, 1));
    
    private CardLayout cardLayout;
    
    public GUI(JFrame pai) {
        
        jdialog = new JDialog(pai, "Produto", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Produto");
        jdialog.setSize(850, 400);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1, 1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);
        
        String caminhoENomeDoArquivo = "Sabor.csv";
        setLocationRelativeTo(null);
        
        cp = getContentPane();
        
        ManipulaImagem manipulaImagem = new ManipulaImagem();
        ImageIcon icon = manipulaImagem.criaIcon("/icones/retrieve.png", 30, 30);
        btBuscar = manipulaImagem.insereBotao(icon, "Buscar");
        icon = manipulaImagem.criaIcon("/icones/list.png", 30, 30);
        btListar = manipulaImagem.insereBotao(icon, "Listar");
        icon = manipulaImagem.criaIcon("/icones/retrieve_1.png", 30, 30);
//        btChaveEstrangeira = manipulaImagem.insereBotao(icon, "Localizar");
        icon = manipulaImagem.criaIcon("/icones/delete_1.png", 30, 30);
        btExcluir = manipulaImagem.insereBotao(icon, "Excluir");
        icon = manipulaImagem.criaIcon("/icones/update.png", 35, 30);
        btAlterar = manipulaImagem.insereBotao(icon, "Alterar");
        icon = manipulaImagem.criaIcon("/icones/save-as.png", 30, 30);
        btSalvar = manipulaImagem.insereBotao(icon, "Salvar");
        icon = manipulaImagem.criaIcon("/icones/newCancelar.png", 30, 30);
        btCancelar = manipulaImagem.insereBotao(icon, "Cancelar");
        icon = manipulaImagem.criaIcon("/icones/save.png", 30, 30);
        btGravar = manipulaImagem.insereBotao(icon, "Gravar");
        icon = manipulaImagem.criaIcon("/icones/create_1.png", 30, 30);
        btAdicionar = manipulaImagem.insereBotao(icon, "Adicionar");
        lbBtnomeTipo = manipulaImagem.insereBotao(manipulaImagem.criaIcon("../Imagens/calabresa.jpg", 40,40), "Localizar");
        toolBar.add(lbBtnomeTipo);
        
        cp.setLayout(new BorderLayout());
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelCentro, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);
        cp.add(painelFoto, BorderLayout.WEST);
        
        cardLayout = new CardLayout();
        painelSul.setLayout(cardLayout);
        
        painelFoto.setLayout(new GridLayout(1, 1));
        painelFoto.add(lbImagem);
        lbImagem.setVisible(true);
        icon = manipulaImagem.criaIcon("/Imagens/pizzaria.jpg", 200, 200);
        lbImagem.setIcon(icon);
        
        painel1.add(scrollTexto);
        painel2.add(scrollTabela);
        
        texto.setText("\n\n\n\n\n\n");
        scrollTexto.setViewportView(texto);
        painelSul.add(painel1, "Avisos");
        painelSul.add(painel2, "Listagem");
        tabela.setEnabled(false);
        painelNorte.add(toolBar);
        painelNorte.setLayout(new GridLayout(1, 1));
        painelCentro.setLayout(new GridLayout(6, 2));
        
        painelCentro.add(lbSabor);
        painelCentro.add(nomeProduto);
        
        painelCentro.add(lbBtnomeTipo);
        painelCentro.add(tffk);
        
        
        
        painelCentro.add(lbDataTipo);
        painelCentro.add(tfData);
       
        
        painelCentro.add(cbAtivo);
        painelCentro.add(lbVazio);
        
        toolBar.add(lbId);
        toolBar.add(tfId);
        toolBar.add(btAdicionar);
        toolBar.add(btBuscar);
        toolBar.add(btListar);
        toolBar.add(btAlterar);
        toolBar.add(btExcluir);
        toolBar.add(btSalvar);
        toolBar.add(btCancelar);
        
        texto.setBackground(new Color(210,105,30));
        texto.setForeground(Color.WHITE);
        
        btAdicionar.setVisible(false);
        btAlterar.setVisible(false);
        btExcluir.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);
        lbBtnomeTipo.setEnabled(false);
        
        nomeProduto.setEditable(false);
        
        tffk.setEditable(false);
        
        
        tfData.setEditable(false);

        
        cbAtivo.setEnabled(false);
        
        texto.setEditable(false);
        
        jdialog.add(cp);
        
        btCarregarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                
                if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) {
                    String aux[];
                    Pizza t;
                    List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);
                    
                    for (String linha : listaStringCsv) {
                        
                        aux = linha.split(";");
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            t = new Pizza(Integer.valueOf(aux[0]), String.valueOf(aux[1]), Integer.valueOf(aux[2]),Date.valueOf(sdfEua.format(formato.parse(aux[3]))),Boolean.valueOf(aux[4].equals("true") ? true : false));
                            controle.adicionar(t);
                        } catch (Exception err) {
                            System.out.println("Deu ruim " + err);
                        }
                        
                    }
                    
                    cardLayout.show(painelSul, "Listagem");
                }                 else {
                    manipulaArquivo.criarArquivoVazio(caminhoENomeDoArquivo);
                }
            }
        });
        
        btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pizza> listaPizzaria = controle.listar();
                List<String> listaPizzariaEmFormatoStringCSV = new ArrayList<>();
                for (Pizza t : listaPizzaria) {
                    listaPizzariaEmFormatoStringCSV.add(t.toString());
                }
                new ManipulaArquivo().salvarArquivo(caminhoENomeDoArquivo, listaPizzariaEmFormatoStringCSV);
                System.out.println("gravou");
            }
        });
        
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btAdicionar.setVisible(false);
                cardLayout.show(painelSul, "Avisos");
                scrollTexto.setViewportView(texto);
                if (tfId.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(cp, "CPF nâo pode ser vazio");
                    tfId.requestFocus();
                    tfId.selectAll();
                } else {
                    try{
                    chavePrimaria = tfId.getText();
                    entidade = controle.buscar(Integer.valueOf(tfId.getText()));
                    if (entidade == null) {
                        btAdicionar.setVisible(true);
                        btAlterar.setVisible(false);
                        btExcluir.setVisible(false);
                        lbBtnomeTipo.setEnabled(true);
                        nomeProduto.setText("");
                        tffk.setText("");
                        tfData.setText("");

                        cbAtivo.setSelected(false);
                        texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");
                        ImageIcon icon = manipulaImagem.criaIcon("/Imagens/pizzaria2.jpg", 200, 200);
                        lbImagem.setIcon(icon);//<-
                    } else {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        nomeProduto.setText(entidade.getSabor());
                        tffk.setText(String.valueOf(entidade.getBtnomeTipo()));

                        tfData.setText(formato.format(entidade.getData()));

                        cbAtivo.setSelected(entidade.isAtivo());
                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);
                        lbBtnomeTipo.setEnabled(true);
                        
                        texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");
                        
                        nomeProduto.setEditable(false);
                        
                        tffk.setEditable(false);
                        
                        
                        tfData.setEditable(false);
                        

                        
                        cbAtivo.setEnabled(false);
                        
                        lbImagem.setVisible(true);
//                        String aux = String.valueOf(entidade.getNomeTipo().trim());
//                        String origem = "src/Imagens/" + aux + ".jpg";
//                        File img = new File(origem);
//                        ImageIcon icone;
//                        if (img.exists()) {
//                            icone = new javax.swing.ImageIcon(img.getAbsolutePath());
//                        } else {
//                            origem = "src/Imagens/pizzaria3.png";
//                            System.out.println("CONSERTA AE MAN");
//                            img = new File(origem);
//                            icone = new javax.swing.ImageIcon(img.getAbsolutePath());
//                        }
                            String aux = String.valueOf(entidade.getSabor().trim());
                            String origem = "src/Imagens/" + aux + ".jpg";
                            File img = new File(origem);
                            ImageIcon icone;
                            if(img.exists()) {
                                icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            } else {
                                origem = "src/Imagens/pizzaria2.jpg";
                                img = new File(origem);
                                icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            }
                            
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(200, 200, Image.SCALE_FAST));
                            lbImagem.setIcon(icone);
                        }
                    } catch (Exception Exception) {
                        JOptionPane.showMessageDialog(cp, "Atributo inválido!");

                    }
  
                    }
                }
            
        });
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = "adicionar";
                tfId.setText(chavePrimaria);
                tfId.setEditable(false);
                nomeProduto.requestFocus();
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);
                lbBtnomeTipo.setEnabled(true);
                texto.setText("Preencha os atributos\n\n\n\n\n");
                nomeProduto.setEditable(true);
                
                tffk.setEditable(true);
                

                
                tfData.setEditable(true);
                

                ImageIcon icon = manipulaImagem.criaIcon("/Imagens/Base.png", 200, 200);
                lbImagem.setIcon(icon);
                cbAtivo.setEnabled(true);
                
            }
        });
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = "alterar";
                tfId.setText(chavePrimaria);
                tfId.setEditable(false);
                nomeProduto.requestFocus();
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                lbBtnomeTipo.setEnabled(false);
                texto.setText("Preencha os atributos\n\n\n\n\n");
                nomeProduto.setEditable(true);
                tffk.setEditable(true);

                tfData.setEditable(true);

                cbAtivo.setEnabled(true);
            
                File f = new File("C:\\Users\\presa\\Documents\\NetBeansProjects\\Pizzaria\\src\\Imagens\\pizzaria3.png");
                if(f.exists()){
                    ImageIcon icon = manipulaImagem.criaIcon("/Imagens/" + String.valueOf(entidade.getSabor()) +".jpg", 200, 200);
                    lbImagem.setIcon(icon);
                } else {
                    ImageIcon icon = manipulaImagem.criaIcon("/Imagens/Base.png", 200, 200);
                    lbImagem.setIcon(icon);
                }     
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                lbBtnomeTipo.setEnabled(false);
                tfId.setEditable(true);
                nomeProduto.setText("");
                
                tffk.setText("");
                

                
                tfData.setText("");
                

                
                cbAtivo.setSelected(false);
                
                tfId.requestFocus();
                tfId.selectAll();
                texto.setText("Cancelou\n\n\n\n\n");
                
                nomeProduto.setEditable(false);
                tffk.setEditable(false);

                tfData.setEditable(false);

                cbAtivo.setEnabled(false);
                ImageIcon icon = manipulaImagem.criaIcon("/Imagens/pizzaria2.jpg", 200, 200);
                lbImagem.setIcon(icon);
                
            }
        });
        
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean erro = false;
                if (acao.equals("alterar")) {
                    Pizza pizzariaAntiga = entidade;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    
                    
                    
                    try {
                        entidade.setSabor(String.valueOf(nomeProduto.getText()));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        nomeProduto.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        entidade.setData(Date.valueOf(sdfEua.format(formato.parse(tfData.getText()))));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfData.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        entidade.setAtivo((cbAtivo.isSelected()));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        cbAtivo.setForeground(Color.RED);
                        erro = true;
                    }
                    try {
                        entidade.setBtnomeTipo(Integer.valueOf(tffk.getText()));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tffk.setForeground(Color.RED);
                        erro = true;
                    }
                   boolean verificaFk = true;
                    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                    List<String> listaCliente = manipulaArquivo.abrirArquivo("DadosCrudTipo.csv");
                    
                    if(listaCliente.size()==0){
                        verificaFk = false;
                    } else {
                        for (int i = 0; i < listaCliente.size(); i++) {
                            if(String.valueOf(listaCliente.get(i)).split(";")[0].equals(tffk.getText())){
                                verificaFk = true;
                                break;
                            } else {
                                verificaFk = false;
                            }
                        }
                    }
                    if(verificaFk == true){
                        entidade.setBtnomeTipo(Integer.valueOf(tffk.getText()));
                        tffk.setForeground(Color.BLACK);
                    } else {
                        System.out.println("Erro: o cliente introduzido não existe");
                        tffk.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    if (erro == false) {
                        controle.alterar(entidade, pizzariaAntiga);
                        texto.setText("Registro alterado\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        lbBtnomeTipo.setVisible(true);
                        btListar.setVisible(true);
                        tfId.setEditable(true);
                        tfId.requestFocus();
                        tfId.selectAll();
                        
                        
                        nomeProduto.setText("");
                        nomeProduto.setEditable(false);
                        tfData.setText("");
                        tfData.setEditable(false);

                        tffk.setText("");
                        tffk.setEditable(false);
                        cbAtivo.setSelected(false);
                        cbAtivo.setEnabled(false);
                    }
                    
                } else  {
                    entidade = new Pizza();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
                    
                    try {
                        entidade.setId(Integer.valueOf(tfId.getText()));   
                        tfId.setForeground(Color.BLACK);
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfId.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    
                    
                    
                    try {
                        entidade.setSabor(String.valueOf(nomeProduto.getText()));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        nomeProduto.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    try {
                        entidade.setData(Date.valueOf(sdfEua.format(formato.parse(tfData.getText()))));
                        tfData.setForeground(Color.BLACK);
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfData.setForeground(Color.RED);
                        erro = true;
                    }

                    try {
                        entidade.setAtivo((cbAtivo.isSelected()));
                        
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        cbAtivo.setForeground(Color.RED);
                        erro = true;
                    }
                    boolean verificaFk = true;
                    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                    List<String> listaCliente = manipulaArquivo.abrirArquivo("DadosCrudTipo.csv");
                    
                    if(listaCliente.size()==0){
                        verificaFk = false;
                    } else {
                        for (int i = 0; i < listaCliente.size(); i++) {
                            if(String.valueOf(listaCliente.get(i)).split(";")[0].equals(tffk.getText())){
                                verificaFk = true;
                                break;
                            } else {
                                verificaFk = false;
                            }
                        }
                    }
                    if(verificaFk == true){
                        entidade.setBtnomeTipo(Integer.valueOf(tffk.getText()));
                        tffk.setForeground(Color.BLACK);
                    } else {
                        System.out.println("Erro: o cliente introduzido não existe");
                        tffk.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    if (erro == false) {
                        controle.adicionar(entidade);
                        texto.setText("Foi adicionado um novo registro\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        lbBtnomeTipo.setVisible(true);
                        btListar.setVisible(true);
                        tfId.setEditable(true);
                        tfId.requestFocus();
                        tfId.selectAll();
                        
  
                        nomeProduto.setText("");
                        nomeProduto.setEditable(false);
                        tfData.setText("");
                        tfData.setEditable(false);
 
                        tffk.setText("");
                        tffk.setEditable(false);
                        cbAtivo.setSelected(false);
                        cbAtivo.setEnabled(false);
                        ImageIcon icon = manipulaImagem.criaIcon("/Imagens/pizzaria2.jpg", 200, 200);
                        lbImagem.setIcon(icon);
                    }
                }
            }
        });

//        btSalvar.addActionListener(new ActionListener() {
//            @Override
//
//            public void actionPerformed(ActionEvent e) {
//                if (acao.equals("alterar")) {
//                    Pizzaria entidadeAntigo = entidade;
//
//                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                    SimpleDateFormat sdfEUA = new SimpleDateFormat("yyyy-MM-dd");
//
//                    try {
//                        entidade.setId(Integer.valueOf(tfId.getText()));
//                        entidade.setNomeTipo(tfNomeTipo.getText());
//                        entidade.setBtnomeTipo(tfBtnomeTipo.getText());
//                        entidade.setData(Date.valueOf(sdfEUA.format(formato.parse(tfData.getText()))));
//                        entidade.setVencida(cbVencida.isSelected());
//                        controle.alterar(entidade, entidadeAntigo);
//                        texto.setText("Registro alterado");
//                    } catch (ParseException ex) {
//                        System.out.println("data errada");
//
//                    }
//                } else {
//
//                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                    SimpleDateFormat sdfEua = new SimpleDateFormat("yyyy-MM-dd");
//                    entidade = new Pizzaria();
//
//                    try {
//                        entidade.setId(Integer.valueOf(tfId.getText()));
//                        entidade.setNomeTipo(tfNomeTipo.getText());
//                        entidade.setBtnomeTipo(tfBtnomeTipo.getText());
//                        entidade.setData(Date.valueOf(sdfEua.format(formato.parse(tfData.getText()))));
//                        entidade.setVencida(cbVencida.isSelected());
//                        controle.adicionar(entidade);
//                        texto.setText("Foi adicionado um novo registro\n\n\n\n\n");
//                        btAlterar.setVisible(true);
//                        btExcluir.setVisible(true);
//                    } catch (Exception ex) {
//                        System.out.println("Deu ruim " + ex);
//                    }
//                }
//                btSalvar.setVisible(false);
//                btCancelar.setVisible(false);
//                lbBtnomeTipo.setEnabled(true);
//                btBuscar.setVisible(true);
//                btListar.setVisible(true);
//                tfId.setEditable(true);
//
//                tfSabor.setText("");
//                tfBtnomeTipo.setText("");
//                tfNomeTipo.setText("");
//                tfData.setText("");
//                cbVencida.setSelected(false);
//
//                tfId.requestFocus();
//                tfId.selectAll();
//                tfSabor.setEditable(false);
//                tfBtnomeTipo.setEditable(false);
//                tfNomeTipo.setEditable(false);
//                tfData.setEditable(false);
//            }
//        }
//        );
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId.setText(chavePrimaria);
                if (JOptionPane.YES_OPTION
                        == JOptionPane.showConfirmDialog(null,
                                "Confirma a exclusão do registro <Nome = " + entidade.getSabor() + ">?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.excluir(entidade);
                    File f = new File("C:\\Users\\presa\\Documents\\NetBeansProjects\\Pizzaria\\src\\Imagens\\" + String.valueOf(entidade.getSabor()) +".jpg");
                    if(f.exists()){
                        f.delete();
                    }
                }
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                lbBtnomeTipo.setEnabled(false);
                
                tfId.setEditable(true);
                nomeProduto.setText("");
                tffk.setText("");
                tfData.setText("");

                cbAtivo.setSelected(false);
                tfId.requestFocus();
                tfId.selectAll();
                btExcluir.setVisible(false);
                btAlterar.setVisible(false);
                ImageIcon icon = manipulaImagem.criaIcon("/Imagens/pizzaria2.jpg", 200, 200);
                lbImagem.setIcon(icon);
                texto.setText("Excluiu o registro de " + entidade.getSabor() + " - " + entidade.getId() + "\n\n\n\n\n");//limpa o campo texto
            }
        }
        );
        lbBtnomeTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
                List<String> listaAuxiliar = manipulaArquivo.abrirArquivo("DadosCrudTipo.csv");
                if (listaAuxiliar.size() > 0) {//se a lista não estiver vazia abre a janela
                    Point lc = tffk.getLocationOnScreen();//precisa mexer aqui para centralizar a janela// o ponto onde a janela vai abrir
                    lc.x = lc.x + tffk.getWidth();//um pouco para frente do botão localizar
                    String selectedItem = new JanelaPesquisar(listaAuxiliar, lc.x,
                            lc.y).getValorRetornado();////matriz x coluna y é linha - posicionamento da janela
                    if (!selectedItem.equals("")) {//pega toda a linha 
                        String[] aux = selectedItem.split(";");//divide no ponto e virgula
                        tffk.setText(aux[0]);//pega so cpf e preenche no textfield cpf
                    } else {
                        tffk.requestFocus();
                        tffk.selectAll();
                    }
                }
            }
        }
        );
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pizza> lt = controle.listar();
                
                String[] colunas = {"Id", "Produto", "fk", "Data" ,  "Ativo"};
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
                lbBtnomeTipo.setEnabled(false);
            }});
        
                lbImagem.addMouseListener(new MouseAdapter() {
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
                            lbImagem.setIcon(icone);
                            String destino = "C:\\Users\\presa\\Documents\\NetBeansProjects\\Pizzaria\\src\\Imagens\\" + String.valueOf(entidade.getSabor()) +".jpg";
                            copia.copiar(origem, destino);
                        } catch (Exception ex){
                            System.out.println("Erro: " + ex.getMessage());
                        }
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
