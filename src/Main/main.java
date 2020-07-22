/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author presa
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomeDaEntidade = "Produto";
        
        String Caminho = "C:/Users/presa/Documents/Documents/Exemplo_Mudar_Persistencia_00_3/src/DAOs/";
        List<String> codigo = new ArrayList<>();
        List<String> atributo = new ArrayList<>();
        
        List<String> atributo2 = new ArrayList<>();
        atributo.add("int;IdProduto");
        atributo2.add("String;NomeProduto");

        
        GeradorDeDAOs_Especificos_V1 Gerador_DAOs = new  GeradorDeDAOs_Especificos_V1(nomeDaEntidade,atributo,atributo2, codigo, Caminho);
    
        
    }
    
}
