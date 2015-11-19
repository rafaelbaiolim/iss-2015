/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.estruturais.UF                                              *
 * Coment: Classe de Entidade UF.                                             *
 *         Classe responsavel por representar a UF no Sistema.                *
 * ========================================================================== */

package modelo.estruturais;

import funcoes.FunctDate;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class UF implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     sigla;
    private String     nome;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    
    public UF() {
        this.id           = null;
        this.dataCadastro = FunctDate.getCurrentDate();
    }
    
    public UF(String sNome, String sSigla) {
        this();
        this.nome  = sNome.toUpperCase().trim();
        this.sigla = sSigla.toUpperCase().trim();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String sNome) {
        this.nome = sNome.toUpperCase().trim();
    }
    
    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sSigla) {
        this.sigla = sSigla.toUpperCase().trim();
    }
    
    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof UF)) {
            return false;
        }
        UF oUF = (UF) oObjeto;
        return Objects.equals(this.id, oUF.getId());
    }

    @Override
    public String toString() {
        return this.sigla;
    }
}