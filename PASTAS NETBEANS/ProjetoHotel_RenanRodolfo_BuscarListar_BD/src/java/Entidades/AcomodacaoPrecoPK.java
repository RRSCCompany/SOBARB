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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Renan
 */
@Embeddable
public class AcomodacaoPrecoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "data_")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "tipo_acomodacao_id_tipo")
    private int tipoAcomodacaoIdTipo;

    public AcomodacaoPrecoPK() {
    }

    public AcomodacaoPrecoPK(Date data, int tipoAcomodacaoIdTipo) {
        this.data = data;
        this.tipoAcomodacaoIdTipo = tipoAcomodacaoIdTipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTipoAcomodacaoIdTipo() {
        return tipoAcomodacaoIdTipo;
    }

    public void setTipoAcomodacaoIdTipo(int tipoAcomodacaoIdTipo) {
        this.tipoAcomodacaoIdTipo = tipoAcomodacaoIdTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (data != null ? data.hashCode() : 0);
        hash += (int) tipoAcomodacaoIdTipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcomodacaoPrecoPK)) {
            return false;
        }
        AcomodacaoPrecoPK other = (AcomodacaoPrecoPK) object;
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        if (this.tipoAcomodacaoIdTipo != other.tipoAcomodacaoIdTipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AcomodacaoPrecoPK[ data=" + data + ", tipoAcomodacaoIdTipo=" + tipoAcomodacaoIdTipo + " ]";
    }
    
}
