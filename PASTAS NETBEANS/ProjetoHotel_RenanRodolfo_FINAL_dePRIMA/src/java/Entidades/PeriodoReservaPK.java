/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Renan
 */
@Embeddable
public class PeriodoReservaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_reserva")
    private int dataReserva;
    @Basic(optional = false)
    @Column(name = "apartamento_id_apartamento")
    private int apartamentoIdApartamento;
    @Basic(optional = false)
    @Column(name = "reserva_id_reserva")
    private int reservaIdReserva;

    public PeriodoReservaPK() {
    }

    public PeriodoReservaPK(int dataReserva, int apartamentoIdApartamento, int reservaIdReserva) {
        this.dataReserva = dataReserva;
        this.apartamentoIdApartamento = apartamentoIdApartamento;
        this.reservaIdReserva = reservaIdReserva;
    }

    public int getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(int dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getApartamentoIdApartamento() {
        return apartamentoIdApartamento;
    }

    public void setApartamentoIdApartamento(int apartamentoIdApartamento) {
        this.apartamentoIdApartamento = apartamentoIdApartamento;
    }

    public int getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(int reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dataReserva;
        hash += (int) apartamentoIdApartamento;
        hash += (int) reservaIdReserva;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoReservaPK)) {
            return false;
        }
        PeriodoReservaPK other = (PeriodoReservaPK) object;
        if (this.dataReserva != other.dataReserva) {
            return false;
        }
        if (this.apartamentoIdApartamento != other.apartamentoIdApartamento) {
            return false;
        }
        if (this.reservaIdReserva != other.reservaIdReserva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PeriodoReservaPK[ dataReserva=" + dataReserva + ", apartamentoIdApartamento=" + apartamentoIdApartamento + ", reservaIdReserva=" + reservaIdReserva + " ]";
    }
    
}
