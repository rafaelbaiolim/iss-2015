/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.cadastrais.Cliente                                          *
 * Coment: Classe de Entidade Cliente.                                        *
 *         Superclasse das Classes de Entidade ClienteFisico e                *
 *         ClienteJuridico.                                                   *
 * ========================================================================== */

package modelo.cadastrais;

import modelo.estruturais.Cidade;
import funcoes.FunctDate;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     documento;
    private String     nome;
    private String     endereco;
    private String     cep;
    @ManyToOne
    private Cidade     cidade;
    private String     telefone;
    private String     email;
    private boolean    ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    
    public Cliente() {
        this.id           = null;
        this.ativo        = true;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Cliente(String sDocumento, String sNome) {
        this();
        this.documento = sDocumento;
        this.nome      = sNome.toUpperCase().trim();
    }
    
    public Cliente(String sDocumento, String sNome, String sEndereco, String sTelefone) {
        this(sDocumento, sNome);
        this.endereco = sEndereco;
        this.telefone = sTelefone;
    }
    
    public Cliente(String sDocumento, String sNome, String sEndereco, String sCep, Cidade oCidade, String sTelefone, String sEmail) {
        this(sDocumento, sNome, sEndereco, sTelefone);
        this.cep    = sCep;
        this.cidade = oCidade;
        
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
        this.nome = sNome.toUpperCase().trim();
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String sEndereco) {
        this.endereco = sEndereco;
    }
    
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String sCep) {
        this.cep = sCep;
    }
    
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade oCidade) {
        this.cidade = oCidade;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String sEmail) {
        this.email = sEmail;
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
    
    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Cliente)) {
            return false;
        }
        Cliente oCliente = (Cliente) oObjeto;
        return Objects.equals(this.id, oCliente.getId());
    }

    @Override
    public String toString() {
        return this.documento + " - " + this.nome;
    }
}