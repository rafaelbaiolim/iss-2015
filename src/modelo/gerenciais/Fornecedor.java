/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.gerenciais.Fornecedor                                       *
 * Coment: Classe de Entidade Fornecedor.                                     *
 *         Classe responsavel por representar o Fornecedor no Sistema.        *
 * ========================================================================== */

package modelo.gerenciais;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String nome;
    private String cnpj;
    private String telefone;
    
    public Fornecedor() {
        this.id = null;
    }
    
    public Fornecedor(String sNome, String sCnpj, String sTelefone) {
        this();
        this.nome     = sNome.toUpperCase().trim();
        this.cnpj     = sCnpj;
        this.telefone = sTelefone;
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
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String sCnpj) {
        this.cnpj = sCnpj;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String sTelefone) {
        this.telefone = sTelefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Fornecedor)) {
            return false;
        }
        Fornecedor oFornecedor = (Fornecedor) oObjeto;
        return Objects.equals(this.id, oFornecedor.getId());
    }

    @Override
    public String toString() {
        return this.cnpj + " - " + this.nome;
    }
}