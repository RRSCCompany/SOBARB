package DAOs;

import Entidades.TipoAcomodacao;
import java.util.ArrayList;
import java.util.List;

public class DAOTipoAcomod extends DAOGenerico<TipoAcomodacao> {

    public DAOTipoAcomod() {
        super(TipoAcomodacao.class);
    }

    public int autoIdTipoAcomod() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTipo) FROM TipoAcomodacao e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<TipoAcomodacao> listByNome(String nome_pessoa) {

        return em.createQuery("SELECT e FROM TipoAcomodacao e WHERE e.nomeTipo) LIKE : nome").setParameter("nome", "%" + nome_pessoa + "%").getResultList();
    }

    public List<TipoAcomodacao> listById(int id) {
        return em.createQuery("SELECT e FROM TipoAcomodacao e WHERE e.idTipo = : id ").setParameter("id", id).getResultList();
    }

    public List<TipoAcomodacao> listInOrderNome() {
        return em.createQuery("SELECT e FROM TipoAcomodacao e ORDER BY e.nomeTipo").getResultList();
    }

    public List<TipoAcomodacao> listInOrderId() {
        return em.createQuery("SELECT e FROM TipoAcomodacao e ORDER BY e.idTipo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<TipoAcomodacao> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTipo()+ "-" + lf.get(i).getNomeTipo());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOTipoAcomod daoTipoAcomod = new DAOTipoAcomod();
        List<TipoAcomodacao> listaTipoAcomod = daoTipoAcomod.list();
        for (TipoAcomodacao ta : listaTipoAcomod) {
            System.out.println(ta.getIdTipo() + "-" + ta.getNomeTipo());
        }
    }

}
