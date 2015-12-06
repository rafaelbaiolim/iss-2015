package modelo.gerenciais;

import funct.FunctDate;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 * <p>Classe de <b>Modelo</b> Fornecedor.</p>
 * <p>Classe responsavel por representar os Fornecedores do Sistema.</p>
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   07/11/2015
 */
@Entity
@Table (name = "fornecedor")
@TableGenerator (name = "fornecedor_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "fornecedor", allocationSize = 1)
public class Fornecedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "fornecedor_generator")
    @Column (name = "id")
    private Long   id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "cnpj")
    private String cnpj;
    @Column (name = "telefone")
    private String telefone;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    
    public Fornecedor() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
    }

    public Fornecedor(String sNome, String sCnpj) {
        this();
        this.nome = sNome.toUpperCase().trim();
        this.cnpj = sCnpj;
    }
    
    public Fornecedor(String sNome, String sCnpj, String sTelefone) {
        this(sNome, sCnpj);
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

    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public String[] getInfo() {
        String[] sFornecedor    = new String[3];
                 sFornecedor[0] = this.id.toString();
                 sFornecedor[1] = this.nome;
                 sFornecedor[2] = this.cnpj;
        return   sFornecedor;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Fornecedor)) {
            return false;
        }
        Fornecedor oFornecedor = (Fornecedor) oObject;
        return Objects.equals(this.id, oFornecedor.getId());
    }

    @Override
    public String toString() {
        return this.cnpj + " - " + this.nome;
    }
}