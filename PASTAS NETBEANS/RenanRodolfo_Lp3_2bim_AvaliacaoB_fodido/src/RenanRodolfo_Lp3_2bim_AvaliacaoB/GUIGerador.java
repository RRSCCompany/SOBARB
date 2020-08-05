package RenanRodolfo_Lp3_2bim_AvaliacaoB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import tools.ConverteCaminho;

public class GUIGerador extends JFrame {

    ManipulaArquivo file = new ManipulaArquivo();
    List<String> ultimaClasse = new ArrayList<String>();
    JLabel processamento = new JLabel("");
    JLabel labelArquivodeorigem = new JLabel("Arquivo de origem");
    JLabel labelCaminho = new JLabel("Caminho");
    JTextField textFieldArquivodeorigem = new JTextField(50);
    JTextField textCaminho = new JTextField(200);
//    JButton btPesquisar = new JButton("Pesquisar");
    JPanel aviso = new JPanel();
    Container cp;
    JPanel centro = new JPanel();
//    JButton btnGerarClassePrincipal = new JButton("Classe de Entidade");
//    JButton btnGerarClasseGUI = new JButton("Classe GUI");
//    JButton btnClasseDeControle = new JButton("Classe de controle");
//    JButton btnClasseGUIListagem = new JButton("Classe GUI Listagem");
    JButton btnClasseDaoEspecifico = new JButton("Classe DaoEspecifico");
    JPanel sul = new JPanel();
    public GUIGerador() {
        setTitle("Gerador");
        setSize(200, 200);//tamanho da janela
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        cp = getContentPane();//container principal, para adicionar nele os outros componentes

        centro.setLayout(new GridLayout(4, 1));

        centro.add(labelArquivodeorigem);
        centro.add(textFieldArquivodeorigem);
        centro.add(labelCaminho);
        centro.add(textCaminho);
//        centro.add(btPesquisar);
        aviso.setLayout(new FlowLayout());
        aviso.add(processamento);

        centro.add(aviso);

        sul.setLayout(new FlowLayout());
//        sul.add(btnGerarClassePrincipal);
//
//        sul.add(btnClasseDeControle);
//        sul.add(btnGerarClasseGUI);
//        sul.add(btnClasseGUIListagem);
        sul.add(btnClasseDaoEspecifico);
        cp.add(sul, BorderLayout.SOUTH);
        cp.add(centro, BorderLayout.CENTER);

        //carregar ultimaClasseGerada
        //busca em um arquivo texto, a última classe que foi gerada
        ultimaClasse = file.abrirArquivo("src\\RenanRodolfo_Lp3_2bim_AvaliacaoB\\ultimaClasseGerada");
        textFieldArquivodeorigem.setText(ultimaClasse.get(0));

        pack();
        // setLocationRelativeTo(this); // posiciona no centro da tela principal
        setVisible(true);//faz a janela ficar visível

        //listeners
//        btPesquisar.addActionListener(new ActionListener() {
//   @Override
//   public void actionPerformed(ActionEvent e) {
//       JFileChooser fc = new JFileChooser();
//       fc.showSaveDialog(btPesquisar);
//       File f = fc.getSelectedFile();
//       try {
//           FileWriter fw = new FileWriter(f);
//           String text = textCaminho.getText();
//           fw.write(text);
//           fw.close();
//       } catch (IOException i) {
//           System.out.println(i);
//       }
//       
//       };
//   
//   });
        textFieldArquivodeorigem.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                aviso.setBackground(Color.CYAN);
                processamento.setText(" Digite o nome da classe que será gerada... ");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                //
            }
        });

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ultimaClasse.clear();
                if (!textFieldArquivodeorigem.getText().equals("")) {
                    ultimaClasse.add(textFieldArquivodeorigem.getText());
                    file.salvarArquivo("src\\RenanRodolfo_Lp3_2bim_AvaliacaoB\\ultimaClasseGerada", ultimaClasse);
                }
                // Sai do sistema  
                System.exit(0);
            }
        });
        
                btnClasseDaoEspecifico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ConverteCaminho cc = new ConverteCaminho();
//                String a = cc.Converte(textCaminho.getText());
                Gerador g = new Gerador(textFieldArquivodeorigem.getText(),textCaminho.getText() );             
                g.gerarDaoEspecifico();
                aviso.setBackground(Color.GREEN);
                processamento.setText(" Processamento concluído ");
            }
        });
                
}
    }
