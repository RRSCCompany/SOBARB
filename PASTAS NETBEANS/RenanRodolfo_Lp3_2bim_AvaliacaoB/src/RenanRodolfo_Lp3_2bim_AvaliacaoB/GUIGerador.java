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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import tools.ManipulaArquivo;

public class GUIGerador extends JFrame {

    ManipulaArquivo file = new ManipulaArquivo();
    List<String> ultimaClasse = new ArrayList<String>();
    JLabel processamento = new JLabel("");
    JLabel labelArquivodeorigem = new JLabel("Arquivo de origem");
    JLabel labelCaminho = new JLabel("Caminho");
    JTextField textFieldArquivodeorigem = new JTextField(50);
    JTextField textCaminho = new JTextField(50);
    JPanel aviso = new JPanel();
    Container cp;
    JPanel centro = new JPanel();
    JButton btnClasseDaoEspecifico = new JButton("Classe DaoEspecifico");
    JPanel sul = new JPanel();

    public GUIGerador() {
        setTitle("Gerador");
        setSize(200, 200);//tamanho da janela
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        cp = getContentPane();

        centro.setLayout(new GridLayout(3, 1));

        centro.add(labelArquivodeorigem);
        centro.add(textFieldArquivodeorigem);
        centro.add(labelCaminho);
        centro.add(textCaminho);
        aviso.setLayout(new FlowLayout());
        aviso.add(processamento);

        centro.add(aviso);

        sul.setLayout(new FlowLayout());
        sul.add(btnClasseDaoEspecifico);
        cp.add(sul, BorderLayout.SOUTH);
        cp.add(centro, BorderLayout.CENTER);

        ultimaClasse = file.abrirArquivo("src/RenanRodolfo_Lp3_2bim_AvaliacaoB/ultimaClasseGerada");
        textFieldArquivodeorigem.setText(ultimaClasse.get(0));

        pack();
        setLocationRelativeTo(this); 
        setVisible(true);

        
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
                    file.salvarArquivo("src/RenanRodolfo_Lp3_2bim_AvaliacaoB/ultimaClasseGerada", ultimaClasse);
                } 
                System.exit(0);
            }
        });

                btnClasseDaoEspecifico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Gerador g = new Gerador(textFieldArquivodeorigem.getText(), textCaminho.getText());
                System.out.println(textCaminho.getText());
                g.gerarDaoEspecifico();
                aviso.setBackground(Color.GREEN);
                processamento.setText(" Processamento concluído ");
            }
        });
                
}
    }
