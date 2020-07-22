package MainMenu;

import Produto.GUI;
import Genero.GUIPROD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.Centraliza;
import tools.ManipulaImagem;

public class MenuPrincipal extends JFrame {

    private JFrame cp = new JFrame();
    JPanel pnNorte = new JPanel();
//    JMenuBar menuBar = new JMenuBar();
//    JMenu menuOpcoes = new JMenu("Opções");
//    JMenuItem Produtoss = new JMenuItem("Produtos");
//    JMenuItem PIzzas = new JMenuItem("Pizzaria");
    
    private JToolBar toolbar = new JToolBar();
    private JButton Produto;  
    private JButton Genero;    
    private JButton bt;
    private JPanel pn;
    private JPanel pn2;
    private JLabel img;
    private JLabel img2;
    
    private ManipulaImagem manipulaimagem = new ManipulaImagem();

    

    public MenuPrincipal(Dimension dimensao) {
        cp.getContentPane();
        cp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        cp.setTitle("Menu Principal-Produto");
        cp.setSize(700, 700);
        cp.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaComponente(cp);
        
        
      
        cp.add(pnNorte, BorderLayout.NORTH);
        Produto = manipulaimagem.insereBotao(manipulaimagem.criaIcon("../Imagens/pizzaria.jpg", 80, 80), "Pizza");  
        Genero = manipulaimagem.insereBotao(manipulaimagem.criaIcon("../Imagens/portuguesa.jpg", 80,80), "Tipo");
       
        
        img = new JLabel(manipulaimagem.criaIcon("../Imagens/pizzaria2.jpg", 850, 580));
        img2 = new JLabel(manipulaimagem.criaIcon("../Imagens/pizzaria2.jpg", 80, 80));
        
        toolbar.add(img2);

        
        toolbar.add(Produto);
        toolbar.add(Genero);
        
        toolbar.setBackground(Color.BLACK);
        
        pn = new JPanel();
        pn.setLayout(new GridLayout(1,1));
        pn.add(img);
        pn.setBackground(Color.WHITE);
        
        
        cp.add(toolbar, BorderLayout.NORTH);
        
        cp.add(pn, BorderLayout.CENTER);
 
        
        Genero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIPROD guiprod = new GUIPROD(cp);
            }
        });
        Produto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GUI gui = new GUI(cp);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        cp.setVisible(true);
        
        
        
    
    }
    
}
        
    
    
    


