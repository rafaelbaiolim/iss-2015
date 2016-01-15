package modelo.relacionais.saida;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import modelo.estruturais.Usuario;

/**
 * <p>Classe de <b>Modelo</b> Devolucao.</p>
 * <p>Classe responsavel por representar as Devolucoes de Vendas do Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   09/11/2015
 */
@Entity
@Table (name = "devolucao")
@TableGenerator (name = "devolucao_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "devolucao", allocationSize = 1)
public class Devolucao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "devolucao_generator")
    @Column (name = "id")
    private Long    id;
    @OneToOne
    @JoinColumn (name = "venda_id")
    private Venda   venda;
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;
    @Column (name = "motivo")
    private String  motivo;
    @Column (name = "data_cadastro")    
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;
    
    public Devolucao() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Devolucao(Venda oVenda, Usuario oUsuario, String sMotivo) {
        this();
        this.venda   = oVenda;
        this.usuario = oUsuario;
        this.motivo  = sMotivo.toUpperCase().trim();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda oVenda) {
        this.venda = oVenda;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario oUsuario) {
        this.usuario = oUsuario;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String sMotivo) {
        this.motivo = sMotivo.toUpperCase().trim();
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
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Devolucao)) {
            return false;
        }
        Devolucao oDevolucao = (Devolucao) oObject;
        return Objects.equals(this.id, oDevolucao.getId());
    }

    @Override
    public String toString() {
        return this.venda + " - " + this.motivo;
    }
}