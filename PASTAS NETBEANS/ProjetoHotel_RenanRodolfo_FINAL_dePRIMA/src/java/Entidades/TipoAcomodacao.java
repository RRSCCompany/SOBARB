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
@Table(name = "tipo_acomodacao")
@NamedQueries({
    @NamedQuery(name = "TipoAcomodacao.findAll", query = "SELECT t FROM TipoAcomodacao t")})
public class TipoAcomodacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Column(name = "nome_tipo")
    private String nomeTipo;
    @OneToMany(mappedBy = "tipoAcomodacaoIdTipo")
    private List<Acomodacao> acomodacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAcomodacao")
    private List<AcomodacaoPreco> acomodacaoPrecoList;

    public TipoAcomodacao() {
    }

    public TipoAcomodacao(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public List<Acomodacao> getAcomodacaoList() {
        return acomodacaoList;
    }

    public void setAcomodacaoList(List<Acomodacao> acomodacaoList) {
        this.acomodacaoList = acomodacaoList;
    }

    public List<AcomodacaoPreco> getAcomodacaoPrecoList() {
        return acomodacaoPrecoList;
    }

    public void setAcomodacaoPrecoList(List<AcomodacaoPreco> acomodacaoPrecoList) {
        this.acomodacaoPrecoList = acomodacaoPrecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAcomodacao)) {
            return false;
        }
        TipoAcomodacao other = (TipoAcomodacao) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+idTipo;
    }
    
}
