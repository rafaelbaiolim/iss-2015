package modelo.complementares;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * <p>Classe de <b>Modelo</b> UF.</p>
 * <p>Classe responsavel por representar as UFs do Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   07/11/2015
 */

@Entity
@Table (name = "uf")
@TableGenerator (name = "uf_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "uf", allocationSize = 1)
public class UF implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "uf_generator")
    @Column (name = "id")
    private Long   id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "sigla")
    private String sigla;

    public UF() {
        this.id = null;
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

    public void setNome(String nome) {
        this.nome = nome.toUpperCase().trim();
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sSigla) {
        this.sigla = sSigla.toUpperCase().trim();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof UF)) {
            return false;
        }
        UF oUF = (UF) oObject;
        return Objects.equals(this.id, oUF.getId());
    }

    @Override
    public String toString() {
        return this.sigla;
    }
}