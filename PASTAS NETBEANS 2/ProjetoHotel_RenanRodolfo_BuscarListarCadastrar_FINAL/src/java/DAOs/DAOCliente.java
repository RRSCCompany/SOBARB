package DAOs;

import Entidades.Cliente;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends DAOGenerico<Cliente> {

    public DAOCliente() {
        super(Cliente.class);
    }

    public int autoIdCliente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.pessoaIdPessoa) FROM Cliente e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cliente> listByNome(String nome_pessoa) {

        return em.createQuery("SELECT e FROM Cliente e WHERE e.cidadeOrigem) LIKE : nome").setParameter("nome", "%" + nome_pessoa + "%").getResultList();
    }

    public List<Cliente> listById(int id) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.pessoaIdPessoa = : id").setParameter("id", id).getResultList();
    }

    public List<Cliente> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.cidadeOrigem").getResultList();
    }

    public List<Cliente> listInOrderId() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.pessoaIdPessoa").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getPessoaIdPessoa()+ "-" + lf.get(i).getCidadeOrigem());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOCliente daoCliente = new DAOCliente();
        List<Cliente> listaCliente = daoCliente.list();
        for (Cliente pessoa : listaCliente) {
            System.out.println(pessoa.getPessoaIdPessoa() + "-" + pessoa.getCidadeOrigem());
        }
    }

}
