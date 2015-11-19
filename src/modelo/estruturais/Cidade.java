/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.estruturais.Cidade                                          *
 * Coment: Classe de Entidade Cidade.                                         *
 *         Classe responsavel por representar a Cidade no Sistema.            *
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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     nome;
    private boolean    ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @ManyToOne
    private UF         uf;

    public Cidade() {
        this.id           = null;
        this.ativo        = true;
        this.dataCadastro = FunctDate.getCurrentDate();
    }
    
    public Cidade(String sNome, UF oUF) {
        this();
        this.nome = sNome.toUpperCase().trim();
        this.uf   = oUF;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String sNome) {
        this.nome = sNome.toUpperCase().trim();
    }
    
    public boolean isAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(boolean bAtivo) {
        this.ativo = bAtivo;
    }
    
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public UF getUF() {
        return this.uf;
    }
    
    public void setUF(UF oUF) {
        this.uf = oUF;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Cidade)) {
            return false;
        }
        Cidade oCidade = (Cidade) oObjeto;
        return Objects.equals(this.id, oCidade.getId());
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.uf;
    }
}