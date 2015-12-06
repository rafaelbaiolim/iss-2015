package modelo.cadastrais;

import modelo.complementares.Cidade;
import funct.FunctDate;
import java.io.Serializable;
import java.sql.Time;
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
 * <p>Classe de <b>Modelo</b> Cliente.</p>
 * <p>Classe responsavel por representar os Clientes do Mercado no Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   08/11/2015
 */
@Entity
@Table (name = "cliente")
@TableGenerator (name = "cliente_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "cliente", allocationSize = 1)
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cliente_generator")
    @Column (name = "id")
    private Long   id;
    @Column (name = "documento")
    private String documento;
    @Column (name = "nome")
    private String nome;
    @Column (name = "telefone")
    private String telefone;
    @Column (name = "celular")
    private String celular;
    @Column (name = "email")
    private String email;
    @Column (name = "endereco")
    private String endereco;
    @ManyToOne
    @JoinColumn (name = "cidade_id")
    private Cidade cidade;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;

    public Cliente() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Cliente(String sDocumento, String sNome) {
        this();
        this.documento = sDocumento;
        this.nome      = sNome.toUpperCase().trim();
    }
    
    public Cliente(String sDocumento, String sNome, String sTelefone, String sCelular, String sEmail, String sEndereco, Cidade oCidade) {
        this(sDocumento, sNome);
        this.telefone = sTelefone;
        this.celular  = sCelular;
        this.email    = sEmail;
        this.endereco = sEndereco.toUpperCase().trim();
        this.cidade   = oCidade;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String sDocumento) {
        this.documento = sDocumento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String sNome) {
        this.nome = sNome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String sTelefone) {
        this.telefone = sTelefone;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String sCelular) {
        this.celular = sCelular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String sEmail) {
        this.email = sEmail;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String sEndereco) {
        this.endereco = sEndereco.toUpperCase().trim();
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade oCidade) {
        this.cidade = oCidade;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public String[] getInfo() {
        String[] sCliente    = new String[3];
                 sCliente[0] = this.id.toString();
                 sCliente[1] = this.documento;
                 sCliente[2] = this.nome;
        return   sCliente;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Cliente)) {
            return false;
        }
        Cliente oCliente = (Cliente) oObject;
        return Objects.equals(this.id, oCliente.getId());
    }

    @Override
    public String toString() {
        return this.documento + " - " + this.nome;
    }    
}