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
@Table(name = "acomodacao")
@NamedQueries({
    @NamedQuery(name = "Acomodacao.findAll", query = "SELECT a FROM Acomodacao a")})
public class Acomodacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_acomodacao")
    private Integer idAcomodacao;
    @Basic(optional = false)
    @Column(name = "nome_acomodacao")
    private String nomeAcomodacao;
    @JoinTable(name = "acomodacao_has_equipamento", joinColumns = {
        @JoinColumn(name = "acomodacao_id_acomodacao", referencedColumnName = "id_acomodacao")}, inverseJoinColumns = {
        @JoinColumn(name = "equipamento_id_equipamento", referencedColumnName = "id_equipamento")})
    @ManyToMany
    private List<Equipamento> equipamentoList;
    @JoinColumn(name = "tipo_acomodacao_id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoAcomodacao tipoAcomodacaoIdTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acomodacao")
    private List<PeriodoReserva> periodoReservaList;

    public Acomodacao() {
    }

    public Acomodacao(Integer idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public Acomodacao(Integer idAcomodacao, String nomeAcomodacao) {
        this.idAcomodacao = idAcomodacao;
        this.nomeAcomodacao = nomeAcomodacao;
    }

    public Integer getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(Integer idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public String getNomeAcomodacao() {
        return nomeAcomodacao;
    }

    public void setNomeAcomodacao(String nomeAcomodacao) {
        this.nomeAcomodacao = nomeAcomodacao;
    }

    public List<Equipamento> getEquipamentoList() {
        return equipamentoList;
    }

    public void setEquipamentoList(List<Equipamento> equipamentoList) {
        this.equipamentoList = equipamentoList;
    }

    public TipoAcomodacao getTipoAcomodacaoIdTipo() {
        return tipoAcomodacaoIdTipo;
    }

    public void setTipoAcomodacaoIdTipo(TipoAcomodacao tipoAcomodacaoIdTipo) {
        this.tipoAcomodacaoIdTipo = tipoAcomodacaoIdTipo;
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
        hash += (idAcomodacao != null ? idAcomodacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acomodacao)) {
            return false;
        }
        Acomodacao other = (Acomodacao) object;
        if ((this.idAcomodacao == null && other.idAcomodacao != null) || (this.idAcomodacao != null && !this.idAcomodacao.equals(other.idAcomodacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Acomodacao[ idAcomodacao=" + idAcomodacao + " ]";
    }
    
}
