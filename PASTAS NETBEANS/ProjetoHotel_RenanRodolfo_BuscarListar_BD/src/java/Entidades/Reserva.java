/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "reserva")
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Basic(optional = false)
    @Column(name = "data_reserva")
    @Temporal(TemporalType.DATE)
    private Date dataReserva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private List<PeriodoReserva> periodoReservaList;
    @JoinColumn(name = "cliente_pessoa_id_pessoa", referencedColumnName = "pessoa_id_pessoa")
    @ManyToOne(optional = false)
    private Cliente clientePessoaIdPessoa;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Integer idReserva, Date dataReserva) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public List<PeriodoReserva> getPeriodoReservaList() {
        return periodoReservaList;
    }

    public void setPeriodoReservaList(List<PeriodoReserva> periodoReservaList) {
        this.periodoReservaList = periodoReservaList;
    }

    public Cliente getClientePessoaIdPessoa() {
        return clientePessoaIdPessoa;
    }

    public void setClientePessoaIdPessoa(Cliente clientePessoaIdPessoa) {
        this.clientePessoaIdPessoa = clientePessoaIdPessoa;
    }

   

    @Override
    public String toString() {
        return "Entidades.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
