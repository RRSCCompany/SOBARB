package DAOs;

import DAOs.DAOGenerico;
import DAOs.DAOGenero;
import Entidades.Filme;
import java.util.ArrayList;
import java.util.List;

public class DAOFilme extends DAOGenerico<Filme> {

    private List<Filme> lista = new ArrayList<>();

    public DAOFilme() {
        super(Filme.class);
    }

    public int autoIdFilme() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.id) FROM Filme e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Filme> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Filme e WHERE e.id) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Filme> listById(int id) {
        return em.createQuery("SELECT e FROM Filme + e WHERE e.id= :id").setParameter("id", id).getResultList();
    }

    public List<Filme> listInOrderNome() {
        return em.createQuery("SELECT e FROM Filme e ORDER BY e.nome").getResultList();
    }

    public List<Filme> listInOrderId() {
        return em.createQuery("SELECT e FROM Filme e ORDER BY e.id").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Filme> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ "-" + lf.get(i).getNome());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOFilme daoFilme = new DAOFilme();
        List<Filme> listaFilme = daoFilme.list();
        for (Filme filme : listaFilme) {
            System.out.println(filme.getId()+ "-" + filme.getNome());
        }
    }
}
