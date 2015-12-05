package modelo.estruturais;

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
 * <p>Classe de <b>Modelo</b> Acao.</p>
 * <p>Classe responsavel por representar as Acoes Internas do Sistema.</p>
 * @author  Rafael
 * @version 1.0
 * @since   08/11/2015
 */
@Entity
@Table (name = "acao")
@TableGenerator (name = "acao_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "acao", allocationSize = 1)
public class Acao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "acao_generator")
    @Column (name = "id")
    private Long   id;
    @Column (name = "descricao")
    private String descricao;

    public Acao() {
        this.id = null;
    }
    
    public Acao(String sDescricao) {
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
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Acao)) {
            return false;
        }
        Acao oAcao = (Acao) oObject;
        return Objects.equals(this.id, oAcao.getId());
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}