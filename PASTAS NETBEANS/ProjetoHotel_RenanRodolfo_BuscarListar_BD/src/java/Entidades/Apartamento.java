/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "apartamento")
@NamedQueries({
    @NamedQuery(name = "Apartamento.findAll", query = "SELECT a FROM Apartamento a")})
public class Apartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_apartamento")
    private Integer idApartamento;
    @Basic(optional = false)
    @Column(name = "nome_apartamento")
    private String nomeApartamento;
    @JoinTable(name = "apartamento_has_equipamento", joinColumns = {
        @JoinColumn(name = "apartamento_id_apartamento", referencedColumnName = "id_apartamento")}, inverseJoinColumns = {
        @JoinColumn(name = "equipamento_id_equipamento", referencedColumnName = "id_equipamento")})
    @ManyToMany
    private List<Equipamento> equipamentoList;
    @JoinColumn(name = "tipo_apartamento_id_tipo_apartamento", referencedColumnName = "id_tipo_apartamento")
    @ManyToOne(optional = false)
    private TipoApartamento tipoApartamentoIdTipoApartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apartamento")
    private List<PeriodoReserva> periodoReservaList;

    public Apartamento() {
    }

    public Apartamento(Integer idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Apartamento(Integer idApartamento, String nomeApartamento) {
        this.idApartamento = idApartamento;
        this.nomeApartamento = nomeApartamento;
    }

    public Integer getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Integer idApartamento) {
        this.idApartamento = idApartamento;
    }

    public String getNomeApartamento() {
        return nomeApartamento;
    }

    public void setNomeApartamento(String nomeApartamento) {
        this.nomeApartamento = nomeApartamento;
    }

    public List<Equipamento> getEquipamentoList() {
        return equipamentoList;
    }

    public void setEquipamentoList(List<Equipamento> equipamentoList) {
        this.equipamentoList = equipamentoList;
    }

    public TipoApartamento getTipoApartamentoIdTipoApartamento() {
        return tipoApartamentoIdTipoApartamento;
    }

    public void setTipoApartamentoIdTipoApartamento(TipoApartamento tipoApartamentoIdTipoApartamento) {
        this.tipoApartamentoIdTipoApartamento = tipoApartamentoIdTipoApartamento;
    }

    public List<PeriodoReserva> getPeriodoReservaList() {
        return periodoReservaList;
    }

    public void setPeriodoReservaList(List<PeriodoReserva> periodoReservaList) {
        this.periodoReservaList = periodoReservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApartamento != null ? idApartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apartamento)) {
            return false;
        }
        Apartamento other = (Apartamento) object;
        if ((this.idApartamento == null && other.idApartamento != null) || (this.idApartamento != null && !this.idApartamento.equals(other.idApartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Apartamento[ idApartamento=" + idApartamento + " ]";
    }
    
}
