package DAOs;

import static DAOs.DAOGenerico.em;
import Entidades.Acomodacao;
import java.util.ArrayList;
import java.util.List;

public class DAOAcomod extends DAOGenerico<Acomodacao> {

    public DAOAcomod() {
        super(Acomodacao.class);
    }

    public int autoIdAcomod() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAcomodacao) FROM Acomodacao e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Acomodacao> listByNome(String nome_pessoa) {

        return em.createQuery("SELECT e FROM Acomodacao e WHERE e.nomeAcomodacao) LIKE : nome").setParameter("nome", "%" + nome_pessoa + "%").getResultList();
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
            ls.add(lf.get(i).getIdAcomodacao()+ "-" + lf.get(i).getNomeAcomodacao());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOAcomod daoTipoAcomod = new DAOAcomod();
        List<Acomodacao> listaTipoAcomod = daoTipoAcomod.list();
        for (Acomodacao ta : listaTipoAcomod) {
            System.out.println(ta.getIdAcomodacao()+ "-" + ta.getNomeAcomodacao()); 
        }
    }

}
