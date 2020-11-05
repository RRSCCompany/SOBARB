package DAOs;

import Entidades.Equipamento;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOEquipamento extends DAOGenerico<Equipamento> {

    public DAOEquipamento() {
        super(Equipamento.class);
    }

    public int autoIdEquipamento() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idEquipamento) FROM Equipamento e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Equipamento> listByNome(String nome_Equipamento) {

        return em.createQuery("SELECT e FROM Equipamento e WHERE e.nomeEquipamento) LIKE : nome").setParameter("nome", "%" + nome_Equipamento + "%").getResultList();
    }

    public List<Equipamento> listById(int id) {
        return em.createQuery("SELECT e FROM Equipamento e WHERE e.idEquipamento = : id ").setParameter("id", id).getResultList();
    }

    public List<Equipamento> listInOrderNome() {
        return em.createQuery("SELECT e FROM Equipamento e ORDER BY e.nomeEquipamento").getResultList();
    }

    public List<Equipamento> listInOrderId() {
        return em.createQuery("SELECT e FROM Equipamento e ORDER BY e.idEquipamento").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Equipamento> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdEquipamento()+ "-" + lf.get(i).getNomeEquipamento());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOEquipamento daoEquipamento = new DAOEquipamento();
        List<Equipamento> listaEquipamento = daoEquipamento.list();
        for (Equipamento equipamento : listaEquipamento) {
            System.out.println(equipamento.getIdEquipamento()+ "-" + equipamento.getNomeEquipamento());
        }
    }

}
