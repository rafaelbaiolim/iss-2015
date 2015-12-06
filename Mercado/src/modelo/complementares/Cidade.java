package modelo.complementares;

import funct.FunctDate;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 * <p>Classe de <b>Modelo</b> Cidade.</p>
 * <p>Classe responsavel por representar as Cidades do Sistema.</p>
 * @author  Leandro
 * @version 1.0
 * @since   07/11/2015
 */
@Entity
@Table (name = "cidade")
@TableGenerator (name = "cidade_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "cidade", allocationSize = 1)
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cidade_generator")
    @Column (name = "id")
    private Long       id;
    @Column (name = "nome")
    private String     nome;
    @ManyToOne
    @JoinColumn (name = "uf_id")
    private UF         uf;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;

    public Cidade() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
    }
    
    public Cidade(String sNome, UF oUF) {
        this();
        this.nome = sNome.toUpperCase().trim();
        this.uf   = oUF;
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

    public UF getUf() {
        return this.uf;
    }

    public void setUf(UF oUF) {
        this.uf = oUF;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public String[] getInfo() {
        String[] sCidade    = new String[3];
                 sCidade[0] = this.id.toString();
                 sCidade[1] = this.nome;
                 sCidade[2] = this.uf.toString();
        return   sCidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Cidade)) {
            return false;
        }
        Cidade oCidade = (Cidade) oObject;
        return Objects.equals(this.id, oCidade.getId());
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.uf;
    }
}