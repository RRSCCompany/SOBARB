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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "tipo_apartamento")
@NamedQueries({
    @NamedQuery(name = "TipoApartamento.findAll", query = "SELECT t FROM TipoApartamento t")})
public class TipoApartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_apartamento")
    private Integer idTipoApartamento;
    @Basic(optional = false)
    @Column(name = "nome_tipo_apartamento")
    private String nomeTipoApartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoApartamentoIdTipoApartamento")
    private List<Apartamento> apartamentoList;

    public TipoApartamento() {
    }

    public TipoApartamento(Integer idTipoApartamento) {
        this.idTipoApartamento = idTipoApartamento;
    }

    public TipoApartamento(Integer idTipoApartamento, String nomeTipoApartamento) {
        this.idTipoApartamento = idTipoApartamento;
        this.nomeTipoApartamento = nomeTipoApartamento;
    }

    public Integer getIdTipoApartamento() {
        return idTipoApartamento;
    }

    public void setIdTipoApartamento(Integer idTipoApartamento) {
        this.idTipoApartamento = idTipoApartamento;
    }

    public String getNomeTipoApartamento() {
        return nomeTipoApartamento;
    }

    public void setNomeTipoApartamento(String nomeTipoApartamento) {
        this.nomeTipoApartamento = nomeTipoApartamento;
    }

    public List<Apartamento> getApartamentoList() {
        return apartamentoList;
    }

    public void setApartamentoList(List<Apartamento> apartamentoList) {
        this.apartamentoList = apartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoApartamento != null ? idTipoApartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoApartamento)) {
            return false;
        }
        TipoApartamento other = (TipoApartamento) object;
        if ((this.idTipoApartamento == null && other.idTipoApartamento != null) || (this.idTipoApartamento != null && !this.idTipoApartamento.equals(other.idTipoApartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoApartamento[ idTipoApartamento=" + idTipoApartamento + " ]";
    }
    
}
