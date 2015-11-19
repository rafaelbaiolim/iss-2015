/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.relacionais.Venda                                           *
 * Coment: Classe de Entidade Venda.                                          *
 *         Classe responsavel por representar a Venda no Sistema.             *
 * ========================================================================== */

package modelo.relacionais;

import modelo.cadastrais.Cliente;
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
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private int        numeroItens;
    private float      valorTotal;
    private float      valorDesconto;
    private float      valorPago;
    private float      valorTroco;
    private String     formaPagamento;
    private boolean    encomenda;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date       dataEntrega;
    private boolean    entrega;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    @ManyToOne
    private Cliente    cliente;
    @ManyToOne
    private Usuario    funcionario;
    
    public Venda() {
        this.id           = null;
        this.encomenda    = false;
        this.entrega      = false;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Venda(int iNumeroItens, float fValorTotal, float fValorPago, String sFormaPagamento, Cliente oCliente, Usuario oFuncionario) {
        this();
        this.numeroItens    = iNumeroItens;
        this.valorTotal     = fValorTotal;
        this.valorPago      = fValorPago;
        this.formaPagamento = sFormaPagamento.toLowerCase().trim();
        this.cliente        = oCliente;
        this.funcionario    = oFuncionario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }
    
    public int getNumeroItens() {
        return this.numeroItens;
    }
    
    public void setNumeroItens(int iNumeroItens) {
        this.numeroItens = iNumeroItens;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public void setValorTotal(float fValorTotal) {
        this.valorTotal = fValorTotal;
    }
    
    public float getValorDesconto() {
        return this.valorDesconto;
    }
    
    public void setValorDesconto(float fValorDesconto) {
        this.valorDesconto = fValorDesconto;
    }
    
    public float getValorPago() {
        return this.valorPago;
    }
    
    public void setValorPago(float fValorPago) {
        this.valorPago = fValorPago;
    }
    
    public float getValorTroco() {
        return this.valorTroco;
    }
    
    public void setValorTroco(float fValorTroco) {
        this.valorTroco = fValorTroco;
    }
    
    public String getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public void setFormaPagamento(String sFormaPagamento) {
        this.formaPagamento = sFormaPagamento.toUpperCase().trim();
    }
    
    public boolean isEncomenda() {
        return this.encomenda;
    }
    
    public void setEncomenda(boolean bEncomenda) {
        this.encomenda = bEncomenda;
    }
    
    public Date getDataEntrega() {
        return this.dataEntrega;
    }
    
    public void setDataEntrega(Date dDataEntrega) {
        this.dataEntrega = dDataEntrega;
    }
    
    public boolean isEntrega() {
        return this.entrega;
    }
    
    public void setEntrega(boolean bEntrega) {
        this.entrega = bEntrega;
    }
    
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente oCliente) {
        this.cliente = oCliente;
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
        if (!(oObjeto instanceof Venda)) {
            return false;
        }
        Venda oVenda = (Venda) oObjeto;
        return Objects.equals(this.id, oVenda.getId());
    }

    @Override
    public String toString() {
        return this.dataCadastro + " - " + this.horaCadastro + " - " + this.cliente;
    }
}