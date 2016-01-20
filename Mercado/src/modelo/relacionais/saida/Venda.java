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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import modelo.cadastrais.Cliente;
import modelo.estruturais.Usuario;

/**
 * <p>Classe de <b>Modelo</b> Venda.</p>
 * <p>Classe responsavel por representar as Vendas do Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   09/11/2015
 */
@Entity
@Table (name = "venda")
@TableGenerator (name = "venda_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "venda", allocationSize = 1)
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "venda_generator")
    @Column (name = "id")
    private Long    id;
    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;
    @Column (name = "forma_pagamento")
    private String  formaPagamento;
    @Column (name = "numero_itens")
    private int     numeroItens;
    @Column (name = "valor_desconto")
    private float   valorDesconto;
    @Column (name = "valor_total")
    private float   valorTotal;
    @Column (name = "valor_pago")
    private float   valorPago;
    @Column (name = "valor_troco")
    private float   valorTroco;
    @Column (name = "fl_encomenda")
    private boolean  encomenda;
    @Column (name = "data_entrega")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date     dataEntrega;
    @Column (name = "fl_entrega")
    private boolean  entrega;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;

    public Venda() {
        this.id           = null;
        this.encomenda    = false;
        this.dataEntrega  = null;
        this.entrega      = false;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Venda(Cliente oCliente, Usuario oUsuario, String sFormaPagamento, int iNumeroItens, float fValorDesconto, float fValorTotal, float fValorPago, float fValorTroco) {
        this();
        this.cliente        = oCliente;
        this.usuario        = oUsuario;
        this.formaPagamento = sFormaPagamento.toUpperCase().trim();
        this.numeroItens    = (iNumeroItens >= 0)     ? iNumeroItens   : 0;
        this.valorDesconto  = (fValorDesconto >= 0.0) ? fValorDesconto : 0.0f;
        this.valorTotal     = (fValorTotal >= 0.0)    ? fValorTotal    : 0.0f;
        this.valorPago      = (fValorPago >= 0.0)     ? fValorPago     : 0.0f;
        this.valorTroco     = (fValorTroco >= 0.0)    ? fValorTroco    : 0.0f;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente oCliente) {
        this.cliente = oCliente;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario oUsuario) {
        this.usuario = oUsuario;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String sFormaPagamento) {
        this.formaPagamento = sFormaPagamento.toUpperCase().trim();
    }

    public int getNumeroItens() {
        return this.numeroItens;
    }

    public void setNumeroItens(int iNumeroItens) {
        this.numeroItens = (iNumeroItens >= 0) ? iNumeroItens : 0;
    }

    public float getValorDesconto() {
        return this.valorDesconto;
    }

    public void setValorDesconto(float fValorDesconto) {
        this.valorDesconto = (fValorDesconto >= 0.0) ? fValorDesconto : 0.0f;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(float fValorTotal) {
        this.valorTotal = (fValorTotal >= 0.0) ? fValorTotal : 0.0f;
    }

    public float getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(float fValorPago) {
        this.valorPago = (fValorPago >= 0) ? fValorPago : 0.0f;
    }

    public float getValorTroco() {
        return this.valorTroco;
    }

    public void setValorTroco(float fValorTroco) {
        this.valorTroco = (fValorTroco >= 0.0) ? fValorTroco : 0.0f;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Venda)) {
            return false;
        }
        Venda oVenda = (Venda) oObject;
        return Objects.equals(this.id, oVenda.getId());
    }

    @Override
    public String toString() {
        return new FunctDate().getFormattedDate(this.dataCadastro) + " - " + this.horaCadastro + " - " + this.cliente;
    }
    public String[] getInfo() {
        String[] sVenda    = new String[3];
                 sVenda[0] = this.cliente.toString();
                 sVenda[1] = new FunctDate().getFormattedDate(this.dataCadastro);
                 sVenda[2] = Float.toString(this.valorTotal);
        return   sVenda;
    }


}