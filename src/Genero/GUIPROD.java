package Genero;

import java.awt.BorderLayout;
import java.sql.Date;
import tools.Tools;
import java.text.SimpleDateFormat;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JDialog;
import java.text.ParseException;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.Centraliza;
import tools.CopiaImagem;
import tools.ManipulaImagem;

public class GUIPROD extends JDialog {

    private Container cp;

    private JLabel lbidGenero = new JLabel("Sabor");
    private JLabel nomeGenero = new JLabel("nome do Tipo");
    private JTextField tfSabor = new JTextField(50);
    private JTextField tfNomeProduto = new JTextField(50);
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
    private TipoControle controle = new TipoControle();
    private Tipo entidade = new Tipo();
    Tools tools = new Tools();
    String[] colunas = new String[]{"Sabor", "NomeProduto"};
    String[][] dados = new String[0][2];

    private JDialog jdialog;
    
    private JPanel painelFoto = new JPanel();
    private JLabel lbImagem = new JLabel();
    CopiaImagem copia = new CopiaImagem();
    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);
    private JPanel painel1 = new JPanel(new GridLayout(1, 1));
    private JPanel painel2 = new JPanel(new GridLayout(1, 1));

    private CardLayout cardLayout;

    public GUIPROD(JFrame pai) {

        jdialog = new JDialog(pai, "Tipo", true);
        jdialog.getContentPane();
        jdialog.pack();
        jdialog.setTitle("Tipo");
        jdialog.setSize(600, 400);
        jdialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jdialog.setLayout(new GridLayout(1, 1));
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaFilho(pai, jdialog);

        String caminhoENomeDoArquivo = "DadosCrudTipo.csv";
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

        cp.setLayout(new BorderLayout());
        cp.add(painelNorte, BorderLayout.NORTH);
        cp.add(painelCentro, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);
        cp.add(painelFoto, BorderLayout.EAST );

        cardLayout = new CardLayout();
        painelSul.setLayout(cardLayout);
        painel1.add(scrollTexto);
        painel2.add(scrollTabela);

        texto.setText("\n\n\n\n\n\n");
        scrollTexto.setViewportView(texto);
        painelSul.add(painel1, "Avisos");
        painelSul.add(painel2, "Listagem");
        painelFoto.setLayout(new GridLayout(1,1));
        painelFoto.add(lbImagem);
        lbImagem.setVisible(true);
        

        icon = manipulaImagem.criaIcon("/Imagens/pizzaria3.png", 200, 200);
        lbImagem.setIcon(icon);
        tabela.setEnabled(false);
        painelNorte.add(toolBar);
        painelNorte.setLayout(new GridLayout(1, 1));
        painelCentro.setLayout(new GridLayout(1, 2));

        painelCentro.add(nomeGenero);
        painelCentro.add(tfNomeProduto);

        toolBar.add(lbidGenero);
        toolBar.add(tfSabor);
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

        tfNomeProduto.setEditable(false);

        texto.setEditable(false);

        jdialog.add(cp);
        btCarregarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManipulaArquivo manipulaArquivo = new ManipulaArquivo();

                if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) {
                    String aux[];
                    Tipo t;
                    List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);

                    for (String linha : listaStringCsv) {

                        aux = linha.split(";");
                        t = new Tipo(Integer.valueOf(aux[0]), String.valueOf(aux[1]));
                        controle.adicionar(t);
                    }

                    cardLayout.show(painelSul, "Listagem");
                }
            }
        });

        btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Tipo> listaProdutos = controle.listar();
                List<String> listaProdutosEmFormatoStringCSV = new ArrayList<>();
                for (Tipo t : listaProdutos) {
                    listaProdutosEmFormatoStringCSV.add(t.toString());
                }
                new ManipulaArquivo().salvarArquivo(caminhoENomeDoArquivo, listaProdutosEmFormatoStringCSV);
                System.out.println("gravou");
            }
        });

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btAdicionar.setVisible(false);
                cardLayout.show(painelSul, "Avisos");
                scrollTexto.setViewportView(texto);
                if (tfSabor.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(cp, "CPF nâo pode ser vazio");
                    tfSabor.requestFocus();
                    tfSabor.selectAll();
                } else {
                    try{
                        
                    
                        chavePrimaria = tfSabor.getText();

                        entidade = controle.buscar(Integer.valueOf(tfSabor.getText()));
                        if (entidade == null) {
                        btAdicionar.setVisible(true);
                        btAlterar.setVisible(false);
                        btExcluir.setVisible(false);

                        tfNomeProduto.setText("");

                        texto.setText("Não encontrou na lista - pode Adicionar\n\n\n");
                        } else {

                        tfNomeProduto.setText(entidade.getNomeProduto());

                        btAlterar.setVisible(true);
                        btExcluir.setVisible(true);
                        texto.setText("Encontrou na lista - pode Alterar ou Excluir\n\n\n");

                        tfNomeProduto.setEditable(false);           
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
                tfSabor.setText(chavePrimaria);
                tfSabor.setEditable(false);
                tfNomeProduto.requestFocus();
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);
                texto.setText("Preencha os atributos\n\n\n\n\n");
                tfNomeProduto.setEditable(true);

            }
        });
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = "alterar";
                tfSabor.setText(chavePrimaria);
                tfSabor.setEditable(false);
                tfNomeProduto.requestFocus();
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                texto.setText("Preencha os atributos\n\n\n\n\n");
                tfNomeProduto.setEditable(true);
            }
        });

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                tfSabor.setEditable(true);
                tfNomeProduto.setText("");

                tfSabor.requestFocus();
                tfSabor.selectAll();
                texto.setText("Cancelou\n\n\n\n\n");

                tfNomeProduto.setEditable(false);
            }
        });
        btSalvar.addActionListener(new ActionListener() {
            @Override
            
            

            public void actionPerformed(ActionEvent e) {
                boolean erro = false;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfEUA = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);
                java.util.Date data = new java.util.Date();
                
                
                
                
                if (acao.equals("alterar")) {
                    Tipo entidadeAntigo = entidade;
                    
                    try {
                        entidade.setNomeProduto(String.valueOf(tfNomeProduto.getText()));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNomeProduto.setForeground(Color.RED);
                        erro = true;
                    }

                    if (erro == false) {
                        controle.alterar(entidade, entidadeAntigo);
                        texto.setText("Registro alterado");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                        tfSabor.setEditable(true);

                        tfNomeProduto.setText("");
                        tfSabor.requestFocus();
                        tfSabor.selectAll();
                        tfNomeProduto.setEditable(false);
                    }
                    
                    
                } else {
                    entidade = new Tipo();
                    try {
                        entidade.setSabor(Integer.valueOf(tfSabor.getText()));   
                        tfSabor.setForeground(Color.BLACK);
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfSabor.setForeground(Color.RED);
                        erro = true;
                    }
                    
                    
                    try {
                        entidade.setNomeProduto(String.valueOf(tfNomeProduto.getText()));
                    } catch (Exception err) {
                        System.out.println("Erro: " + err);
                        tfNomeProduto.setForeground(Color.RED);
                        erro = true;
                    }

                    if (erro==false) {
                        controle.adicionar(entidade);
                        texto.setText("Foi adicionado um novo registro\n\n\n\n\n");
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                        tfSabor.setEditable(true);

                        tfNomeProduto.setText("");
                        tfSabor.requestFocus();
                        tfSabor.selectAll();
                        
                        
                        tfNomeProduto.setEditable(false);
                    }
                    
                }

                
            }
        });

        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfSabor.setText(chavePrimaria);
                if (JOptionPane.YES_OPTION
                        == JOptionPane.showConfirmDialog(null,
                                "Confirma a exclusão do registro <Nome = " + entidade.getNomeProduto() + ">?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.excluir(entidade);
                }
                btBuscar.setVisible(true);
                btListar.setVisible(true);

                tfSabor.setEditable(true);
                tfNomeProduto.setText("");
                tfSabor.requestFocus();
                tfSabor.selectAll();
                btExcluir.setVisible(false);
                btAlterar.setVisible(false);

                texto.setText("Excluiu o registro de " + entidade.getNomeProduto() + " - " + entidade.getSabor() + "\n\n\n\n\n");//limpa o campo texto
            }
        });
        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Tipo> lt = controle.listar();

                String[] colunas = {"Sabor", "NomeProduto"};
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
