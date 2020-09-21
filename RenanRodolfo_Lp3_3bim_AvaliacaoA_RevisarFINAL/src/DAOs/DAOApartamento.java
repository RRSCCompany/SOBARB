package DAOs;

import Entidades.Acomodacao;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOApartamento extends DAOGenerico<Acomodacao> {

    public DAOApartamento() {
        super(Acomodacao.class);
    }

    public int autoIdApartamento() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idApartamento) FROM Apartamento e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Acomodacao> listByNome(String nome_apartamento) {

        return em.createQuery("SELECT e FROM Acomodacao e WHERE e.nomeAcomodacao) LIKE : nomeApartamento").setParameter("nome", "%" + nome_apartamento + "%").getResultList();
    }

    public List<Acomodacao> listById(int id) {
        return em.createQuery("SELECT e FROM Acomodacao e WHERE e.idAcomodacao = : id ").setParameter("id", id).getResultList();
    }

    public List<Acomodacao> listInOrderNome() {
        return em.createQuery("SELECT e FROM Acomodacao e ORDER BY e.nomeAcomodacao").getResultList();
    }

    public List<Acomodacao> listInOrderId() {
        return em.createQuery("SELECT e FROM Acomodacao e ORDER BY e.idAcomodacao").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Acomodacao> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdAcomodacao() + "-" + lf.get(i).getNomeAcomodacao());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOApartamento daoApartamento = new DAOApartamento();
        List<Acomodacao> listaApartamento = daoApartamento.list();
        for (Acomodacao apartamento : listaApartamento) {
            System.out.println(apartamento.getIdAcomodacao() + "-" + apartamento.getNomeAcomodacao());
        }
    }

}
