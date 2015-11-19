/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.internos.Operacao                                           *
 * Coment: Classe de Entidade Operacao.                                       *
 *         Classe responsavel por representar uma Operacao de um Usuario no   *
 *         Sistema.                                                           *
 * ========================================================================== */

package modelo.internos;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String descricao;
    
    public Operacao() {
        this.id = null;
    }
    
    public Operacao(String sDescricao) {
        this();
        this.descricao = sDescricao.toUpperCase().trim();
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String sDescricao) {
        this.descricao = sDescricao.toUpperCase().trim();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Operacao)) {
            return false;
        }
        Operacao oOperacao = (Operacao) oObjeto;
        return Objects.equals(this.id, oOperacao.getId());
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}