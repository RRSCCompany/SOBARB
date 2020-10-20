package DAOs;

import static DAOs.DAOGenerico.em;
import Entidades.AcomodacaoPreco;
import Entidades.AcomodacaoPrecoPK;
import java.util.ArrayList;
import java.util.List;

public class DAOAcomodacaoPreco extends DAOGenerico<AcomodacaoPreco>  {

    public DAOAcomodacaoPreco() {
        super(AcomodacaoPreco.class);
    }

    public int autoIdTipoAcomod() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.preco) FROM AcomodacaoPreco e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<AcomodacaoPrecoPK> listByNome(double nome_pessoa) {

        return em.createQuery("SELECT e FROM AcomodacaoPrecoPK e WHERE e.data) LIKE : nome").setParameter("nome", "%" + nome_pessoa + "%").getResultList();
    }

    public List<AcomodacaoPrecoPK> listById(int id) {
        return em.createQuery("SELECT e FROM AcomodacaoPrecoPK e WHERE e.tipoAcomodacaoIdTipo = : id ").setParameter("id", id).getResultList();
    }

    public List<AcomodacaoPrecoPK> listInOrderNome() {
        return em.createQuery("SELECT e FROM AcomodacaoPrecoPK e ORDER BY e.data").getResultList();
    }

    public List<AcomodacaoPrecoPK> listInOrderId() {
        return em.createQuery("SELECT e FROM AcomodacaoPrecoPK e ORDER BY e.tipoAcomodacaoIdTipo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<AcomodacaoPrecoPK> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getTipoAcomodacaoIdTipo()+ "-" + lf.get(i).getData());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOAcomodacaoPreco daoTipoAcomod = new DAOAcomodacaoPreco();
        List<AcomodacaoPreco> listaTipoAcomod = daoTipoAcomod.list();
        for (AcomodacaoPreco ta : listaTipoAcomod) {
            System.out.println(ta.getPreco() + "-" + ta.getPreco());
        }
    }

}
