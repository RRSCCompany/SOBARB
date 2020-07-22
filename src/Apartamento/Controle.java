
////////////CONTROLE////////////

package Apartamento; 
import java.util.ArrayList;
import java.util.List;

public class Controle {

private List<Apartamento> lista = new ArrayList<>();

public Controle() { 

} 


public void limparLista(){
   lista.clear(); 
}

public void adicionar(Apartamento entidade) {
   lista.add(entidade);
}

public List<Apartamento> listar() {
   return lista;
}


public Apartamento buscar(String Apartamento) {
   for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getApartamento().equals(Apartamento)) {
         return lista.get(i);
      }
   }
   return null;
}

public void alterar(Apartamento entidade,Apartamento entidadeAntigo) {
   lista.set(lista.indexOf(entidadeAntigo), entidade);
}

public void excluir(Apartamento entidade) {
   lista.remove(entidade);
}

}
