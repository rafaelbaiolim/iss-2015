package modelo.gerenciais;

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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 * <p>Classe de <b>Modelo</b> Despesa.</p>
 * <p>Classe responsavel por representar as Despesas do Mercado no Sistema.</p>
 * @author  Rafael
 * @version 1.0
 * @since   07/11/2015
 */
@Entity
@Table (name = "despesa")
@TableGenerator (name = "despesa_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "despesa", allocationSize = 1)
public class Despesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "despesa_generator")
    @Column (name = "id")
    private Long   id;
    @Column (name = "descricao")
    private String descricao;
    @Column (name = "observacao")
    private String observacao;
    @Column (name = "data_pagamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   dataPagamento;
    @Column (name = "valor")
    private float  valor;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;
    
    public Despesa() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Despesa(String sDescricao, String sObservacao, Date dDataPagamento, float fValor) {
        this();
        this.descricao     = sDescricao.toUpperCase().trim();
        this.observacao    = sObservacao.toUpperCase().trim();
        this.dataPagamento = dDataPagamento;
        this.valor         = fValor;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String sDescricao) {
        this.descricao = sDescricao.toUpperCase().trim();
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String sObservacao) {
        this.observacao = sObservacao.toUpperCase().trim();
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dDataPagamento) {
        this.dataPagamento = dDataPagamento;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float fValor) {
        this.valor = fValor;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public String[] getInfo() {
        String[] sDespesa    = new String[3];
                 sDespesa[0] = this.id.toString();
                 sDespesa[1] = this.descricao;
                 sDespesa[2] = Float.toString(this.valor);
        return   sDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Despesa)) {
            return false;
        }
        Despesa oDespesa = (Despesa) oObject;
        return Objects.equals(this.id, oDespesa.getId());
    }

    @Override
    public String toString() {
        return this.descricao + " - " + this.valor;
    }
}