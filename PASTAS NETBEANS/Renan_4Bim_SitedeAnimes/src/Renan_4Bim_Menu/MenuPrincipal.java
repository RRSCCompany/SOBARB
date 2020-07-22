/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renan_4Bim_Menu;

import Renan_4Bim_Animes.GUI;

import Renan_4Bim_Usuario.IGU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tools.Centraliza;
import tools.ManipulaImagem;

class MenuPrincipal extends JFrame{
    
    private JFrame cp = new JFrame();
    
    private JToolBar toolbar = new JToolBar();
  
    private JButton animes;  
    private JButton usuario;  
      
     private JButton pa;
    private JPanel p;
    private JPanel p1;
    private JLabel img;
    private JLabel img2;
    
    private ManipulaImagem manipulaimagem = new ManipulaImagem();

    public MenuPrincipal() {
        
        cp.getContentPane();
        cp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        cp.setTitle("Menu Principal");
        cp.setSize(700, 700);
        cp.setLayout(new BorderLayout());
        setLocationRelativeTo(null);//centro do monitor
        
        Centraliza centraliza = new Centraliza();
        centraliza.centralizaComponente(cp);
        
        usuario = manipulaimagem.insereBotao(manipulaimagem.criaIcon("../imagenscrud/logousuariousar.png", 80, 80), "Usuário");
    
        animes = manipulaimagem.insereBotao(manipulaimagem.criaIcon("../imagenscrud/logoanimes.png", 80,80), "Animes");
   
        
        
        img = new JLabel(manipulaimagem.criaIcon("../imagenscrud/logo.jpg", 300, 300));
        img2 = new JLabel(manipulaimagem.criaIcon("../imagenscrud/skatoolbar.png", 80, 80));
        
        toolbar.add(img2);
       
        toolbar.add(usuario);
        toolbar.add(animes);
     
        
        toolbar.setBackground(Color.BLACK);
        
        p = new JPanel();
        p.setLayout(new GridLayout(1,1));
        p.add(img);
        p.setBackground(Color.WHITE);
        
        
        cp.add(toolbar, BorderLayout.NORTH);
        
        cp.add(p, BorderLayout.CENTER);
 

        animes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI guianimes = new GUI(cp);
            }
        });

        usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IGU guiusuario = new IGU(cp);
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
