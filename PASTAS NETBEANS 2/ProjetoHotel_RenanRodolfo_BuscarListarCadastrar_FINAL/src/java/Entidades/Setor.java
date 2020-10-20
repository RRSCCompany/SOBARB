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
@Table(name = "setor")
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s")})
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_setor")
    private Integer idSetor;
    @Basic(optional = false)
    @Column(name = "nome_setor")
    private String nomeSetor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setorIdSetor")
    private List<Funcionario> funcionarioList;

    public Setor() {
    }

    public Setor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Setor(Integer idSetor, String nomeSetor) {
        this.idSetor = idSetor;
        this.nomeSetor = nomeSetor;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSetor != null ? idSetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.idSetor == null && other.idSetor != null) || (this.idSetor != null && !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idSetor;
    }
    
}
