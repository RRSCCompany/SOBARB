package Genero;

import java.util.ArrayList;
import java.util.List;

public class TipoControle {

    private List<Tipo> lista = new ArrayList<>();

    public TipoControle() {
    }

    public void limparLista() {
        lista.clear();
    }

    public void adicionar(Tipo produtos) {
        lista.add(produtos);
    }

    public List<Tipo> listar() {
        return lista;
    }

    public Tipo buscar(int Sabor) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getSabor() == Sabor) {
                return lista.get(i);
            }
        }
        return null;

    }

    public void alterar(Tipo produtos, Tipo produtosAntigo) {
        lista.set(lista.indexOf(produtosAntigo), produtos);

    }

    public void excluir(Tipo produtos) {
        lista.remove(produtos);
    }
     public List<String> listStrings() {
        List<Tipo> lf = lista;
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getNomeProduto()+ "-" + lf.get(i).getSabor());
        }
        return ls;
    }
}

