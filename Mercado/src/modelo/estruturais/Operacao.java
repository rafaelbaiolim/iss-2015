package modelo.estruturais;

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
 * <p>Classe de <b>Modelo</b> Operacao.</p>
 * <p>Classe responsavel por representar as Operacoes Internas do Sistema.</p>
 * @author  Leandro
 * @version 1.0
 * @since   08/11/2015
 */
@Entity
@Table (name = "operacao")
@TableGenerator (name = "operacao_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "operacao", allocationSize = 1)
public class Operacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "operacao_generator")
    @Column (name = "id")
    private Long       id;
    @Column (name = "detalhes")
    private String     detalhes;
    @Column (name = "dia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dia;
    @Column (name = "hora")
    private final Time hora;
    @ManyToOne
    @JoinColumn (name = "acao_id")
    private Acao       acao;
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario    usuario;

    public Operacao() {
        this.id   = null;
        this.dia  = new FunctDate().getCurrentDate();
        this.hora = new FunctDate().getCurrentTime();
    }
    
    public Operacao(String sDetalhes, Acao oAcao, Usuario oUsuario) {
        this();
        this.detalhes = sDetalhes.toUpperCase().trim();
        this.acao     = oAcao;
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

    public Acao getAcao() {
        return this.acao;
    }

    public void setAcao(Acao oAcao) {
        this.acao = oAcao;
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
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Operacao)) {
            return false;
        }
        Operacao oOperacao = (Operacao) oObject;
        return Objects.equals(this.id, oOperacao.getId());
    }

    @Override
    public String toString() {
        return this.usuario + " " + this.acao + " - " + this.detalhes;
    }
    
     public String[] getInfo() {
        String[] sUsuario    = new String[3];
                 sUsuario[0] = new FunctDate().getFormattedDate(this.dia);
                 sUsuario[1] = this.hora.toString();
                 sUsuario[2] = this.acao.getDescricao();
        return   sUsuario;
    }
    
    
}