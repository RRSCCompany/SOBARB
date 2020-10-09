package DAOs;

import DAOs.DAOGenerico;
import DAOs.DAOGenero;
import Entidades.Ator;
import java.util.ArrayList;
import java.util.List;

public class DAOAtor extends DAOGenerico<Ator> {

    private List<Ator> lista = new ArrayList<>();

    public DAOAtor() {
        super(Ator.class);
    }

    public int autoIdAtor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.id) FROM Ator e").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Ator> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Ator e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Ator> listById(int id) {
        return em.createQuery("SELECT e FROM Ator + e WHERE e.id= :id").setParameter("id", id).getResultList();
    }

    public List<Ator> listInOrderNome() {
        return em.createQuery("SELECT e FROM Ator e ORDER BY e.nome").getResultList();
    }

    public List<Ator> listInOrderId() {
        return em.createQuery("SELECT e FROM Ator e ORDER BY e.id").getResultList();
    }
    
    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Ator> lf;
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
        DAOAtor daoAtor = new DAOAtor();
        List<Ator> listaAtor = daoAtor.list();
        for (Ator ator : listaAtor) {
            System.out.println(ator.getId()+ "-" + ator.getNome());
        }
      
    }
}
