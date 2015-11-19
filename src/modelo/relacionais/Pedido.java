/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.relacionais.Pedido                                          *
 * Coment: Classe de Entidade Pedido.                                         *
 *         Classe responsavel por representar o Pedido de Produtos no Sistema.*
 * ========================================================================== */

package modelo.relacionais;

import modelo.gerenciais.Fornecedor;
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
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private int        totalItens;
    private float      valorTotal;
    private char       ativo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date       dataPagamento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    @ManyToOne
    private Fornecedor fornecedor;
    @ManyToOne
    private Usuario    funcionario;

    public Pedido() {
        this.id           = null;
        this.ativo        = 'S';
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Pedido(Fornecedor oFornecedor, Usuario oFuncionario) {
        this();
        this.fornecedor  = oFornecedor;
        this.funcionario = oFuncionario;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }
    
    public int getTotalItens() {
        return this.totalItens;
    }
    
    public void setTotalItens(int iTotalItens) {
        this.totalItens = iTotalItens;
    }
    
    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public void setValorTotal(float fValorTotal) {
        this.valorTotal = fValorTotal;
    }
    
    public char getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(char cAtivo) {
        this.ativo = cAtivo;
    }
    
    public Date getDataPagamento() {
        return this.dataPagamento;
    }
    
    public void setDataPagamento(Date oDataPagamento) {
        this.dataPagamento = oDataPagamento;
    }
    
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor oFornecedor) {
        this.fornecedor = oFornecedor;
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
        if (!(oObjeto instanceof Pedido)) {
            return false;
        }
        Pedido oPedido = (Pedido) oObjeto;
        return Objects.equals(this.id, oPedido.getId());
    }

    @Override
    public String toString() {
        return FunctDate.getFormattedDate(this.dataCadastro) + " - " + this.horaCadastro + " - " + this.funcionario.getFuncionario();
    }
}