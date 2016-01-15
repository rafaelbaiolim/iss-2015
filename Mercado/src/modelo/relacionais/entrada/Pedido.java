package modelo.relacionais.entrada;

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
import modelo.estruturais.Usuario;
import modelo.gerenciais.Fornecedor;

/**
 * <p>Classe de <b>Modelo</b> Pedidos.</p>
 * <p>Classe responsavel por representar os Pedidos do Sistema.</p>
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   09/11/2015
 */
@Entity
@Table (name = "pedido")
@TableGenerator (name = "pedido_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "pedido", allocationSize = 1)
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pedido_generator")
    @Column (name = "id")
    private Long       id;
    @ManyToOne
    @JoinColumn (name = "fornecedor_id")
    private Fornecedor fornecedor;
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario    usuario;
    @Column (name = "total_itens")
    private int        totalItens;
    @Column (name = "valor_total")
    private float      valorTotal;
    @Column (name = "fl_recebido")
    private boolean    recebido;
    @Column (name = "data_pagamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date       dataPagamento;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;

    public Pedido() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Pedido(Fornecedor oFornecedor, Usuario oUsuario) {
        this();
        this.fornecedor = oFornecedor;
        this.usuario    = oUsuario;
        this.recebido   = false;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(Fornecedor oFornecedor) {
        this.fornecedor = oFornecedor;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario oUsuario) {
        this.usuario = oUsuario;
    }

    public int getTotalItens() {
        return this.totalItens;
    }

    public void setTotalItens(int iTotalItens) {
        this.totalItens = (iTotalItens >= 0) ? iTotalItens : 0;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(float fValorTotal) {
        this.valorTotal = (fValorTotal >= 0.0) ? fValorTotal : 0.0f;
    }

    public boolean isRecebido() {
        return this.recebido;
    }

    public void setRecebido(boolean bRecebido) {
        this.recebido = bRecebido;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dDataPagamento) {
        this.dataPagamento = dDataPagamento;
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
        if (!(oObject instanceof Pedido)) {
            return false;
        }
        Pedido oPedido = (Pedido) oObject;
        return Objects.equals(this.id, oPedido.getId());
    }

    @Override
    public String toString() {
        return new FunctDate().getFormattedDate(this.dataCadastro) + " - " + this.horaCadastro + " - " + this.usuario;
    }
}