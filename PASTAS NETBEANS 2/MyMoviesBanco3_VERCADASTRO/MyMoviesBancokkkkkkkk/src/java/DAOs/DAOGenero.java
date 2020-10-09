package DAOs;

import Entidades.Genero;
import java.util.ArrayList;
import java.util.List;

public class DAOGenero extends DAOGenerico<Genero> {

    private List<Genero> lista = new ArrayList<>();

    public DAOGenero() {
        super(Genero.class);
    }

    public int autoIdGenero() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.id) FROM Genero e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Genero> listByNome(String descricao) {
        return em.createQuery("SELECT e FROM Genero e WHERE e.id) LIKE :descricao").setParameter("descricao", "%" + descricao + "%").getResultList();
    }

    public List<Genero> listById(int id) {
        return em.createQuery("SELECT e FROM Genero + e WHERE e.id= :id").setParameter("id", id).getResultList();
    }

    public List<Genero> listInOrderNome() {
        return em.createQuery("SELECT e FROM Genero e ORDER BY e.descricao").getResultList();
    }

    public List<Genero> listInOrderId() {
        return em.createQuery("SELECT e FROM Genero e ORDER BY e.id").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Genero> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ "-" + lf.get(i).getDescricao());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOGenero daoGenero = new DAOGenero();
        List<Genero> listaGenero = daoGenero.list();
        for (Genero trabalhador : listaGenero) {
            System.out.println(trabalhador.getId()+ "-" + trabalhador.getDescricao());
        }
    }
}
