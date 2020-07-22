
////////////CONTROLE////////////

package Renan_4Bim_Usuario; 
import java.util.ArrayList;
import java.util.List;

public class Controle {

private List<UsuarioS> lista = new ArrayList<>();

public Controle() { 

} 


public void limparLista(){
   lista.clear(); 
}

public void adicionar(UsuarioS entidade) {
   lista.add(entidade);
}

public List<UsuarioS> listar() {
   return lista;
}


public UsuarioS buscar(String Nick) {
   for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getNick().equals(Nick)) {
         return lista.get(i);
      }
   }
   return null;
}

public void alterar(UsuarioS entidade,UsuarioS entidadeAntigo) {
   lista.set(lista.indexOf(entidadeAntigo), entidade);
}

public void excluir(UsuarioS entidade) {
   lista.remove(entidade);
}
public List<String> listStrings(){
        List<String> ls = new ArrayList<>();
        for (UsuarioS c : lista) {
            ls.add(c.toString());
        }
        return ls;
    }

}
