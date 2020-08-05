package RenanRodolfo_Lp3_2bim_AvaliacaoB;

// @author Radames
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import tools.ConverteCaminho;


public class Gerador {
    
//C:\Users\Renan\Desktop\COISAS_DO_RENAN\COISAS_DA_UTF\PASTAS NETBEANS\RenanRodolfo_Lp3_1bim_AvaliacaoA
    
    private List<String> textoDescritivo = new ArrayList<String>();
    ManipulaArquivo file = new ManipulaArquivo();
    List<String> cg = new ArrayList<String>();
    //classeGerada é uma lista de strings que conterá o código fonte que será gerado
    String arq;
    //salvar o texto que foi gerado e está armazenado na lista cg

    String pastaDestino;
    

    public Gerador(String arq, String pastaDestino) {
        this.arq = arq;
        this.pastaDestino = pastaDestino;
           
    }
     
    public String primMaius(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    public String primMinus(String s) {
        return s.substring(0, 1).toLowerCase() + s.substring(1, s.length());
    }

    public List<String> getTextoDescritivo() {
        //lê o arquivo descritivo da classe que será gerada e transfere para uma lista de strings
        textoDescritivo = file.abrirArquivo("src/txts/" + arq + ".txt");
        return textoDescritivo;
    }
    public void gerarDaoEspecifico() {
        getTextoDescritivo();
        String s[] = textoDescritivo.get(0).split(";");
        String s1[] = textoDescritivo.get(1).split(";");
        cg.clear();
        cg.add("package DAOs; \n"
                 + "import Entidades." + arq + "; \n"
                 + "import DAOs.DAOGenerico; \n"
                 + "import static DAOs.DAOGenerico.em; \n"
                 + "import java.util.ArrayList; \n"
                 + "import java.util.List;\n"
                 + "\n"
                 + "public class DAO" + arq + " extends DAOGenerico<" + arq + "> { \n"
                 + "    public DAO" + arq + "()  {\n"
                 + "        super(" + arq + ".class); \n"
                 + "    }" );
        
        cg.add("    public int autoId" + arq +"() {\n"
                + "        Integer a = (Integer) em.createQuery(\"SELECT MAX(e.id" + arq + ") FROM " + arq + " e " + " \").getSingleResult(); \n"
                + "        if (a != null) { \n"
                + "            return a + 1; \n"
                + "        } else { \n"
                + "            return 1; \n"
                + "        }\n" +
"    } \n");
        String auxatr1[] = s;
        String auxatr2[] = s1;
        
        cg.add("    public List<" + arq + "> listByNome(String " + auxatr2[0] + ") {\n");//<-como colocar a variavel
        cg.add("        return em.createQuery(" + "\"SELECT e FROM " + arq + " e WHERE e." + auxatr2[0] + ") LIKE : nome"+arq+"\"" + ").setParameter(\"nome\", \"%\" +" + auxatr2[0]+ "+ \"%\").getResultList();\n"
                + "    }\n");
        cg.add("    public List<"+ arq +"> listById(int id) {\n"
                + "        return em.createQuery(\"SELECT e FROM "  + arq + " e WHERE e." + auxatr1[0] + " = : id \" ).setParameter(\"id\", id).getResultList(); \n"
                + "    }\n"
                + "    public List<" + arq + "> listInOrderNome() { \n"
                + "        return em.createQuery(\"SELECT e FROM " + arq + " e ORDER BY e." + auxatr2[0] + "\").getResultList();\n"
                + "    }\n");
        
        cg.add("    public List<" + arq +"> listInOrderId() {\n"
                + "        return em.createQuery(\"SELECT e FROM " + arq + " e ORDER BY e." + auxatr1[0] + "\").getResultList();\n"
                        + "    }\n\n");
        cg.add("public List<String> listInOrderNomeStrings(String qualOrdem) { \n"
                + "        List<" + arq + "> lf; \n"
                + "        if (qualOrdem.equals(\"id\")) { \n"
                + "            lf = listInOrderId(); \n"
                + "        } else { \n"
                + "            lf = listInOrderNome(); \n"
                + "        } \n");
        
        cg.add("        List<String> ls = new ArrayList<>(); \n"
                + "        for (int i = 0; i < lf.size(); i++) { \n"
                + "            ls.add(lf.get(i).get" + auxatr1[1] + "() + \"-\" + lf.get(i).get" + auxatr2[1] +"());\n"
                + "        } \n"
                + "        return ls; \n"
                + "    } \n");
        cg.add("    public static void main(String[] args) { \n"
                + "        DAO" + arq + " dao" + arq + " = new DAO" + arq + "();\n"
                + "        List<" + arq + "> lista" + arq + " = dao" + arq + ".list(); \n"
                + "        for (" + arq + " " + primMinus(arq) + " : lista" + arq + ") { \n"
                + "            System.out.println(" + primMinus(arq) + ".get" + primMaius(auxatr1[0]) + "()+ \"-\" + " + primMinus(arq) + ".get" + primMaius(auxatr2[0]) + "()); \n"
                + "        } \n"
                + "    }\n");
        cg.add("}\n");
        String arquivoDestino = pastaDestino + "/src/" +"DAOs/DAO" + arq + ".java";
        int salvarArquivo = file.salvarArquivo(arquivoDestino, cg);

     }
}
