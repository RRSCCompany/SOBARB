package DAOs;

import Entidades.Reserva;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOReserva extends DAOGenerico<Reserva> {

    public DAOReserva() {
        super(Reserva.class);
    }

    public int autoIdReserva() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idReserva) FROM Reserva e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Reserva> listByNome(String nomeReserva) {
        return em.createQuery("SELECT e FROM Reserva e WHERE e.dataReserva) LIKE : nome").setParameter("nome", "%" + nomeReserva + "%").getResultList();
    }

    public List<Reserva> listById(int id) {
        return em.createQuery("SELECT e FROM Reserva e WHERE e.idReserva = : id ").setParameter("id", id).getResultList();
    }

    public List<Reserva> listInOrderNome() {
        return em.createQuery("SELECT e FROM Reserva e ORDER BY e.dataReserva").getResultList();
    }

    public List<Reserva> listInOrderId() {
        return em.createQuery("SELECT e FROM Reserva e ORDER BY e.idReserva").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Reserva> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdReserva() + "-" + lf.get(i).getDataReserva());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOReserva daoReserva = new DAOReserva();
        List<Reserva> listaReserva = daoReserva.list();
        for (Reserva setor : listaReserva) {
            System.out.println(setor.getIdReserva() + "-" + setor.getDataReserva());
        }
    }

}
