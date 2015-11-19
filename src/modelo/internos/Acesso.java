/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.internos.Acesso                                             *
 * Coment: Classe de Entidade Acesso.                                         *
 *         Classe responsavel por representar o Acesso de um Usuario a uma    *
 *         Operacao no Sistema.                                               *
 * ========================================================================== */

package modelo.internos;

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
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     detalhes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dia;
    private final Time hora;
    @ManyToOne
    private Operacao   operacao;
    @ManyToOne
    private Usuario    usuario;

    public Acesso() {
        this.id      = null;
        this.dia     = FunctDate.getCurrentDate();
        this.hora    = FunctDate.getCurrentTime();
    }

    public Acesso(String sDetalhes, Operacao oOperacao, Usuario oUsuario) {
        this();
        this.detalhes = sDetalhes.toUpperCase().trim();
        this.operacao = oOperacao;
        this.usuario  = oUsuario;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public String getDetalhes() {
        return this.detalhes;
    }
    
    public void setDetalhes(String sDetalhes) {
        this.detalhes = sDetalhes.toUpperCase().trim();
    }
    
    public Date getDia() {
        return this.dia;
    }
    
    public Time getHora() {
        return this.hora;
    }
    
    public Operacao getOperacao() {
        return this.operacao;
    }
    
    public void setOperacao(Operacao oOperacao) {
        this.operacao = oOperacao;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario oUsuario) {
        this.usuario = oUsuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Acesso)) {
            return false;
        }
        Acesso oAcesso = (Acesso) oObjeto;
        return Objects.equals(this.id, oAcesso.getId());
    }

    @Override
    public String toString() {
        return this.usuario + " - " + this.operacao + " em " + FunctDate.getFormattedDate(this.dia) + " " + this.hora;
    }
}