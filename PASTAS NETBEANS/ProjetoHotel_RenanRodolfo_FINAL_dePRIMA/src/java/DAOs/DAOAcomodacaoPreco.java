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

    public List<AcomodacaoPreco> listByNome(double nome_pessoa) {

        return em.createQuery("SELECT e FROM AcomodacaoPreco e WHERE e.acomodacaoPrecoPK.tipoAcomodacaoIdTipo) LIKE : nome").setParameter("nome", "%" + nome_pessoa + "%").getResultList();
    }

    public List<AcomodacaoPreco> listById(int id) {
        return em.createQuery("SELECT e FROM AcomodacaoPreco e WHERE e.acomodacaoPrecoPK.data = : id ").setParameter("id", id).getResultList();
    }

    public List<AcomodacaoPreco> listInOrderNome() {
        return em.createQuery("SELECT e FROM AcomodacaoPreco e ORDER BY e.acomodacaoPrecoPK.tipoAcomodacaoIdTipo").getResultList();
    }

    public List<AcomodacaoPreco> listInOrderId() {
        return em.createQuery("SELECT e FROM AcomodacaoPreco e ORDER BY e.acomodacaoPrecoPK.data").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<AcomodacaoPreco> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getAcomodacaoPrecoPK().getData()+ "-" + lf.get(i).getPreco());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOAcomodacaoPreco daoTipoAcomod = new DAOAcomodacaoPreco();
        List<AcomodacaoPreco> listaTipoAcomod = daoTipoAcomod.list();
        for (AcomodacaoPreco ta : listaTipoAcomod) {
            System.out.println(ta.getAcomodacaoPrecoPK().getData() + "-" + ta.getPreco());
        }
    }

}
