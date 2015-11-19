/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.internos.Usuario                                            *
 * Coment: Classe de Entidade Usuario.                                        *
 *         Classe responsavel por representar um Usuario do Sistema.          *
 * ========================================================================== */

package modelo.internos;

import modelo.gerenciais.Funcionario;
import funcoes.FunctDate;
import funcoes.FunctString;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long        id;
    private String      login;
    private String      senha;
    private boolean     adm;
    private boolean     ativo;
    @OneToOne
    private Funcionario funcionario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date  dataCadastro;
    private final Time  horaCadastro;
    
    public Usuario() {
        this.id           = null;
        this.adm          = false;
        this.ativo        = true;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Usuario(String sLogin, String sSenha) {
        this();
        this.login = sLogin.toLowerCase().trim();
        this.senha = FunctString.md5(sSenha);
    }
    
    public Usuario(String sLogin, String sSenha, boolean bAdm, Funcionario oFuncionario) {
        this(sLogin, sSenha);
        this.adm         = bAdm;
        this.funcionario = oFuncionario;
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
        this.login = sLogin.toLowerCase().trim();
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String sSenha) {
        this.senha = FunctString.md5(sSenha);
    }
    
    public boolean isAdm() {
        return this.adm;
    }
    
    public void setAdm(boolean bAdm) {
        this.adm = bAdm;
    }
    
    public boolean isAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(boolean bAtivo) {
        this.ativo = bAtivo;
    }
    
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario oFuncionario) {
        this.funcionario = oFuncionario;
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
        if (!(oObjeto instanceof Usuario)) {
            return false;
        }
        Usuario oUsuario = (Usuario) oObjeto;
        return Objects.equals(this.id, oUsuario.getId());
    }

    @Override
    public String toString() {
        return this.login;
    }
}