/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "periodo_reserva")
@NamedQueries({
    @NamedQuery(name = "PeriodoReserva.findAll", query = "SELECT p FROM PeriodoReserva p")})
public class PeriodoReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeriodoReservaPK periodoReservaPK;
    @JoinColumn(name = "apartamento_id_apartamento", referencedColumnName = "id_acomodacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acomodacao acomodacao;
    @JoinColumn(name = "reserva_id_reserva", referencedColumnName = "id_reserva", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;

    public PeriodoReserva() {
    }

    public PeriodoReserva(PeriodoReservaPK periodoReservaPK) {
        this.periodoReservaPK = periodoReservaPK;
    }

    public PeriodoReserva(int dataReserva, int apartamentoIdApartamento, int reservaIdReserva) {
        this.periodoReservaPK = new PeriodoReservaPK(dataReserva, apartamentoIdApartamento, reservaIdReserva);
    }

    public PeriodoReservaPK getPeriodoReservaPK() {
        return periodoReservaPK;
    }

    public void setPeriodoReservaPK(PeriodoReservaPK periodoReservaPK) {
        this.periodoReservaPK = periodoReservaPK;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodoReservaPK != null ? periodoReservaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoReserva)) {
            return false;
        }
        PeriodoReserva other = (PeriodoReserva) object;
        if ((this.periodoReservaPK == null && other.periodoReservaPK != null) || (this.periodoReservaPK != null && !this.periodoReservaPK.equals(other.periodoReservaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PeriodoReserva[ periodoReservaPK=" + periodoReservaPK + " ]";
    }

}
