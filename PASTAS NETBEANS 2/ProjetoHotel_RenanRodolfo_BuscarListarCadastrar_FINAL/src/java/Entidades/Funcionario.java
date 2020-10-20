/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_id_pessoa")
    private Integer pessoaIdPessoa;
    @Column(name = "data_contratacao")
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;
    @Column(name = "contato")
    private String contato;
    @JoinColumn(name = "pessoa_id_pessoa", referencedColumnName = "id_pessoa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "setor_id_setor", referencedColumnName = "id_setor")
    @ManyToOne(optional = false)
    private Setor setorIdSetor;

    public Funcionario() {
    }

    public Funcionario(Integer pessoaIdPessoa) {
        this.pessoaIdPessoa = pessoaIdPessoa;
    }

    public Integer getPessoaIdPessoa() {
        return pessoaIdPessoa;
    }

    public void setPessoaIdPessoa(Integer pessoaIdPessoa) {
        this.pessoaIdPessoa = pessoaIdPessoa;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Setor getSetorIdSetor() {
        return setorIdSetor;
    }

    public void setSetorIdSetor(Setor setorIdSetor) {
        this.setorIdSetor = setorIdSetor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaIdPessoa != null ? pessoaIdPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.pessoaIdPessoa == null && other.pessoaIdPessoa != null) || (this.pessoaIdPessoa != null && !this.pessoaIdPessoa.equals(other.pessoaIdPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Funcionario[ pessoaIdPessoa=" + pessoaIdPessoa + " ]";
    }
    
}
