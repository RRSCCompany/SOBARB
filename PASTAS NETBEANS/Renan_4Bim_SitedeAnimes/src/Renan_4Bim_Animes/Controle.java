
////////////CONTROLE////////////

package Renan_4Bim_Animes; 
import java.util.ArrayList;
import java.util.List;

public class Controle {

private List<Animes> lista = new ArrayList<>();

public Controle() { 

} 


public void limparLista(){
   lista.clear(); 
}

public void adicionar(Animes entidade) {
   lista.add(entidade);
}

public List<Animes> listar() {
   return lista;
}


public Animes buscar(String Nome) {
   for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getNome().equals(Nome)) {
         return lista.get(i);
      }
   }
   return null;
}

public void alterar(Animes entidade,Animes entidadeAntigo) {
   lista.set(lista.indexOf(entidadeAntigo), entidade);
}

public void excluir(Animes entidade) {
   lista.remove(entidade);
}

public List<String> listStrings(){
        List<String> ls = new ArrayList<>();
        for (Animes l : lista) {
            ls.add(l.toString());
        }
        return ls;
    }

}
