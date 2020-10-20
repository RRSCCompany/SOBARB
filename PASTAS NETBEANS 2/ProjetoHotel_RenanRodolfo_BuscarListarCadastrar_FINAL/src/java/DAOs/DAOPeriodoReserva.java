package DAOs;


import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import Entidades.PeriodoReserva;
import Entidades.Setor;
import java.util.ArrayList;
import java.util.List;

public class DAOPeriodoReserva extends DAOGenerico<PeriodoReserva> {

    public DAOPeriodoReserva() {
        super(PeriodoReserva.class);
    }

    public int autoIdPeriodoReserva() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.dataReserva) FROM PeriodoReserva e  ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<PeriodoReserva> listByNome(String contato) {

        return em.createQuery("SELECT e FROM PeriodoReserva e WHERE e.reservaIdReserva) LIKE : nome").setParameter("nome", "%" + contato + "%").getResultList();
    }

    public List<PeriodoReserva> listById(int id) {
        return em.createQuery("SELECT e FROM PeriodoReserva e WHERE e.dataReserva = : id").setParameter("id", id).getResultList();
    }

    public List<PeriodoReserva> listInOrderNome() {
        return em.createQuery("SELECT e FROM PeriodoReserva e ORDER BY e.reservaIdReserva").getResultList();
    }

    public List<PeriodoReserva> listInOrderId() {
        return em.createQuery("SELECT e FROM PeriodoReserva e ORDER BY e.dataReserva").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<PeriodoReserva> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getPeriodoReservaPK().getDataReserva()+ "-" + lf.get(i).getPeriodoReservaPK().getReservaIdReserva());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPeriodoReserva daoPeriodoReserva = new DAOPeriodoReserva();
        List<PeriodoReserva> listaPeriodoReserva = daoPeriodoReserva.list();
        for (PeriodoReserva pessoa : listaPeriodoReserva) {
            System.out.println(pessoa.getPeriodoReservaPK().getDataReserva() + "-" + pessoa.getPeriodoReservaPK().getReservaIdReserva());
        }
    }

    public void inserir(Setor s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
