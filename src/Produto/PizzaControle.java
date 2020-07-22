package Produto;

import java.util.ArrayList;
import java.util.List;

public class PizzaControle {

    private List<Pizza> lista = new ArrayList<>();

    public PizzaControle() {
    }

    public void limparLista() {
        lista.clear();
    }

    public void adicionar(Pizza pizzaria) {
        lista.add(pizzaria);
    }

    public List<Pizza> listar() {
        return lista;
    }

    public Pizza buscar(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return lista.get(i);
            }
        }
        return null;

    }

    public void alterar(Pizza pizzaria, Pizza pizzariaAntigo) {
        lista.set(lista.indexOf(pizzariaAntigo), pizzaria);

    }

    public void excluir(Pizza pizzaria) {
        lista.remove(pizzaria);
    }

    public List<String> listStrings() {
        List<String> ls = new ArrayList<>();
        for (Pizza t : lista) {
            ls.add(t.toString());
        }
        return ls;
    }
}
