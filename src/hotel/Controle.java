
////////////CONTROLE////////////

package Hotel; 
import java.util.ArrayList;
import java.util.List;

public class Controle {

private List<Hotel> lista = new ArrayList<>();

public Controle() { 

} 


public void limparLista(){
   lista.clear(); 
}

public void adicionar(Hotel entidade) {
   lista.add(entidade);
}

public List<Hotel> listar() {
   return lista;
}


public Hotel buscar(String CPF) {
   for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getCPF().equals(CPF)) {
         return lista.get(i);
      }
   }
   return null;
}

public void alterar(Hotel entidade,Hotel entidadeAntigo) {
   lista.set(lista.indexOf(entidadeAntigo), entidade);
}

public void excluir(Hotel entidade) {
   lista.remove(entidade);
}
public List<String> listStrings(){
        List<String> ls = new ArrayList<>();
        for (Hotel l : lista) {
            ls.add(l.toString());
        }
        return ls;
    }

}
