package DAOs;

import Entidades.Setor;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOSetor extends DAOGenerico<Setor> {

    public DAOSetor() {
        super(Setor.class);
    }

    public int autoIdSetor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idSetor) FROM Setor e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Setor> listByNome(String nomeSetor) {
        return em.createQuery("SELECT e FROM Setor.nomeSetorLIKE : nome").setParameter("nome", "%" + nomeSetor + "%").getResultList();
    }

    public List<Setor> listById(int id) {
        return em.createQuery("SELECT e FROM Setor e WHERE e.idSetor = : id ").setParameter("id", id).getResultList();
    }

    public List<Setor> listInOrderNome() {
        return em.createQuery("SELECT e FROM Setor e ORDER BY e.nomeSetor").getResultList();
    }

    public List<Setor> listInOrderId() {
        return em.createQuery("SELECT e FROM Setor e ORDER BY e.idSetor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Setor> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdSetor() + "-" + lf.get(i).getNomeSetor());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOSetor daoSetor = new DAOSetor();
        List<Setor> listaSetor = daoSetor.list();
        for (Setor setor : listaSetor) {
            System.out.println(setor.getIdSetor() + "-" + setor.getNomeSetor());
        }
    }

}
