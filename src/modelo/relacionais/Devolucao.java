/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
* Classe: modelo.relacionais.Devolucao                                        *
 * Coment: Classe de Entidade Devolucao.                                      *
 *         Classe responsavel por representar a Devolucao de uma Venda no     *
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
public class Devolucao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    @ManyToOne
    private Venda      venda;
    @ManyToOne
    private Usuario    funcionario;

    public Devolucao() {
        this.id           = null;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Devolucao(Venda oVenda, Usuario oUsuario) {
        this();
        this.venda       = oVenda;
        this.funcionario = oUsuario;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda oVenda) {
        this.venda = oVenda;
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
        if (!(oObjeto instanceof Devolucao)) {
            return false;
        }
        Devolucao oDevolucao = (Devolucao) oObjeto;
        return Objects.equals(this.id, oDevolucao.getId());
    }

    @Override
    public String toString() {
        return this.funcionario + " - " + this.venda;
    }
}