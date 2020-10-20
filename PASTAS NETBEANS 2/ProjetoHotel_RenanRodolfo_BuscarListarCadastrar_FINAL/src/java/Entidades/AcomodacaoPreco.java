/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "acomodacao_preco")
@NamedQueries({
    @NamedQuery(name = "AcomodacaoPreco.findAll", query = "SELECT a FROM AcomodacaoPreco a")})
public class AcomodacaoPreco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcomodacaoPrecoPK acomodacaoPrecoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;
    @JoinColumn(name = "tipo_acomodacao_id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoAcomodacao tipoAcomodacao;

    public AcomodacaoPreco() {
    }

    public AcomodacaoPreco(AcomodacaoPrecoPK acomodacaoPrecoPK) {
        this.acomodacaoPrecoPK = acomodacaoPrecoPK;
    }

    public AcomodacaoPreco(Date data, int tipoAcomodacaoIdTipo) {
        this.acomodacaoPrecoPK = new AcomodacaoPrecoPK(data, tipoAcomodacaoIdTipo);
    }

    public AcomodacaoPrecoPK getAcomodacaoPrecoPK() {
        return acomodacaoPrecoPK;
    }

    public void setAcomodacaoPrecoPK(AcomodacaoPrecoPK acomodacaoPrecoPK) {
        this.acomodacaoPrecoPK = acomodacaoPrecoPK;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TipoAcomodacao getTipoAcomodacao() {
        return tipoAcomodacao;
    }

    public void setTipoAcomodacao(TipoAcomodacao tipoAcomodacao) {
        this.tipoAcomodacao = tipoAcomodacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acomodacaoPrecoPK != null ? acomodacaoPrecoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcomodacaoPreco)) {
            return false;
        }
        AcomodacaoPreco other = (AcomodacaoPreco) object;
        if ((this.acomodacaoPrecoPK == null && other.acomodacaoPrecoPK != null) || (this.acomodacaoPrecoPK != null && !this.acomodacaoPrecoPK.equals(other.acomodacaoPrecoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AcomodacaoPreco[ acomodacaoPrecoPK=" + acomodacaoPrecoPK + " ]";
    }
    
}
