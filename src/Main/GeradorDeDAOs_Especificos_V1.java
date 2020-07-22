/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;
import java.util.ArrayList;
import tools.ManipulaArquivo;

/**
 *
 * @author presa
 */
public class GeradorDeDAOs_Especificos_V1 {


    
        
    public static String nomeDaEntidadeMaiuscula(String nomeDaEntidade) {
        return String.valueOf(nomeDaEntidade.charAt(0)).toUpperCase() + nomeDaEntidade.substring(1, nomeDaEntidade.length());
    }
    public static String nomeDaEntidadeMinusculo(String s) {
        return String.valueOf(s.charAt(0)).toLowerCase()+ s.substring(1, s.length());
    }
String nomeDaEntidade;

        List<String> atributo;
        List<String> atributo2;
        List<String> codigo;
        String Caminho;
    public GeradorDeDAOs_Especificos_V1(String nomeDaEntidade, List<String> atributo,List<String> atributo2, List<String> codigo,String Caminho) {
        this.nomeDaEntidade = nomeDaEntidade;
        this.atributo = atributo;
        this.atributo2 = atributo2;
        this.codigo = codigo;
        this.Caminho = Caminho;

        
        

        codigo.add("package DAOs; \n"
                 + "import Entidades." + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "; \n"
                 + "import DAOs.DAOGenerico; \n"
                 + "import static DAOs.DAOGenerico.em; \n"
                 + "import java.util.ArrayList; \n"
                 + "import java.util.List;\n"
                 + "\n"
                 + "public class DAO" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " extends DAOGenerico<" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "> { \n"
                 + "    public DAO" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "()  {\n"
                 + "        super(" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + ".class); \n"
                 + "    }" );
        
        codigo.add("    public int autoId" + nomeDaEntidadeMaiuscula(nomeDaEntidade) +"() {\n"
                + "        Integer a = (Integer) em.createQuery(\"SELECT MAX(e.id" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + ") FROM " + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " e " + " \").getSingleResult(); \n"
                + "        if (a != null) { \n"
                + "            return a + 1; \n"
                + "        } else { \n"
                + "            return 1; \n"
                + "        }\n" +
"    } \n");
        String auxatr1[] = atributo.get(0).split(";");
        String auxatr2[] = atributo2.get(0).split(";");
        
        codigo.add("    public List<" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "> listByNome(String " + auxatr2[1] + ") {");//<-como colocar a variavel
        codigo.add("return em.createQuery(" + "\"SELECT e FROM " + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "e." + auxatr2[1] + "LIKE : nome\"" + ").setParameter(\"nome\", \"%\" +" + auxatr2[1]+ "+ \"%\").getResultList();\n"
                + "    }");
        codigo.add("    public List<"+ nomeDaEntidadeMaiuscula(nomeDaEntidade) +"> listById(int id) {\n"
                + "return em.createQuery(\"SELECT e FROM "  + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " e WHERE e." + auxatr1[1] + " = : id \" ).setParameter(\"id\", id).getResultList(); \n"
                + "}"
                + "    public List<" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "> listInOrderNome() { \n"
                + "        return em.createQuery(\"SELECT e FROM " + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " e ORDER BY e." + auxatr2[1] + "\").getResultList();\n"
                + "    }");
        
        codigo.add("    public List<" + nomeDaEntidadeMaiuscula(nomeDaEntidade) +"> listInOrderId() {\n"
                + "        return em.createQuery(\"SELECT e FROM " + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " e ORDER BY e." + auxatr1[1] + "\").getResultList();\n"
                        + "    } \n");
        codigo.add("public List<String> listInOrderNomeStrings(String qualOrdem) { \n"
                + "        List<" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "> lf; \n"
                + "        if (qualOrdem.equals(\"id\")) { \n"
                + "            lf = listInOrderId(); \n"
                + "        } else { \n"
                + "            lf = listInOrderNome(); \n"
                + "        } \n");
        
        codigo.add("        List<String> ls = new ArrayList<>(); \n"
                + "        for (int i = 0; i < lf.size(); i++) { \n"
                + "            ls.add(lf.get(i).get" + auxatr1[1] + "() + \"-\" + lf.get(i).get" + auxatr2[1] +"());\n"
                + "        } \n"
                + "        return ls; \n"
                + "    } \n");
        codigo.add("    public static void main(String[] args) { \n"
                + "        DAO" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " dao" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " = new DAO" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "();\n"
                + "        List<" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + "> lista" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " = dao" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + ".list(); \n"
                + "        for (" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + " " + nomeDaEntidadeMinusculo(nomeDaEntidade) + " : lista" + nomeDaEntidadeMaiuscula(nomeDaEntidade) + ") { \n"
                + "            System.out.println(" + nomeDaEntidadeMinusculo(nomeDaEntidade) + ".get" + auxatr1[1] + "()+ \"-\" + " + nomeDaEntidadeMinusculo(nomeDaEntidade) + ".get" + auxatr2[1] + "()); \n"
                + "        } \n"
                + "    }\n");
        codigo.add("}\n");



ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
manipulaArquivo.salvarArquivo(Caminho + "DAO" +nomeDaEntidadeMaiuscula(nomeDaEntidade)+".java", codigo);
    


}}

//nome dos atributos