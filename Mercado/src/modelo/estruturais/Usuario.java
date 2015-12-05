package modelo.estruturais;

import funct.FunctDate;
import funct.FunctString;
import java.io.Serializable;
import java.sql.Time;
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
 * <p>Classe de <b>Modelo</b> Usuario.</p>
 * <p>Classe responsavel por representar um Usuario do Sistema.</p>
 * @author  Rafael
 * @version 1.0
 * @since   29/10/2015
 */
@Entity
@Table (name = "usuario")
@TableGenerator (name = "usuario_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "usuario", allocationSize = 1)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "usuario_generator")
    @Column (name = "id")
    private Long       id;
    @Column (name = "login")
    private String     login;
    @Column (name = "senha")
    private String     senha;
    @Column (name = "fl_ativo")
    private boolean    ativo;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;
    
    public Usuario() {
        this.id           = null;
        this.ativo        = true;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Usuario(String sLogin, String sSenha) {
        this();
        this.login = sLogin.trim();
        this.senha = new FunctString().md5(sSenha);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String sLogin) {
        this.login = sLogin.trim();
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String sSenha) {
        this.senha = new FunctString().md5(sSenha);
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
    
    public String[] getInfo() {
        String[] sUsuario    = new String[3];
                 sUsuario[0] = this.id.toString();
                 sUsuario[1] = this.login;
                 sUsuario[2] = this.ativo == true ? "Sim" : "Não";
        return   sUsuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Usuario)) {
            return false;
        }
        Usuario oUsuario = (Usuario) oObject;
        return (Objects.equals(this.id, oUsuario.getId()));
    }

    @Override
    public String toString() {
        return this.login;
    }
}