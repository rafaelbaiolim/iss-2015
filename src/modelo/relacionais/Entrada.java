/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.relacionais.Entrada                                         *
 * Coment: Classe de Entidade Entrada.                                        *
 *         Classe responsavel por representar a Entrada de Produtos no        *
 *         Sistema.                                                           *
 * ========================================================================== */

package modelo.relacionais;

import modelo.internos.Usuario;
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
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     notaFiscal;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    @ManyToOne
    private Pedido     pedido;
    @ManyToOne
    private Usuario    funcionario;
    
    public Entrada() {
        this.id           = null;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Entrada(String sNotaFiscal, Pedido oPedido, Usuario oFuncionario) {
        this();
        this.notaFiscal  = sNotaFiscal;
        this.pedido      = oPedido;
        this.funcionario = oFuncionario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public String getNotaFiscal() {
        return this.notaFiscal;
    }
    
    public void setNotaFiscal(String sNotaFiscal) {
        this.notaFiscal = sNotaFiscal;
    }
    
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido oPedido) {
        this.pedido = oPedido;
    }
     
    public Usuario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Usuario oFuncionario) {
        this.funcionario = oFuncionario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Entrada)) {
            return false;
        }
        Entrada oEntrada = (Entrada) oObjeto;
        return Objects.equals(this.id, oEntrada.getId());
    }

    @Override
    public String toString() {
        return this.pedido + " - " + this.funcionario;
    }
}