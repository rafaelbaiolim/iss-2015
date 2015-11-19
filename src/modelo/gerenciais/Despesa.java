/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.gerenciais.Despesa                                          *
 * Coment: Classe de Entidade Despesa.                                        *
 *         Classe responsavel por representar alguma Despesa da Empresa no    *
 *         Sistema.                                                           *
 * ========================================================================== */

package modelo.gerenciais;

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
public class Despesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     descricao;
    private String     observacao;
    private float      valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date       dataPagamento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    @ManyToOne
    private Usuario    funcionario;
    
    public Despesa() {
        this.id           = null;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Despesa(String sDescricao, String sObservacao, float fValor, Date dDataPagamento, Usuario oFuncionario) {
        this();
        this.descricao     = sDescricao.toUpperCase().trim();
        this.observacao    = sObservacao.toUpperCase().trim();
        this.valor         = fValor;
        this.dataPagamento = dDataPagamento;
        this.funcionario   = oFuncionario;
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
    
    public float getValor() {
        return this.valor;
    }
    
    public void setValor(float fValor) {
        this.valor = fValor;
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
        if (!(oObjeto instanceof Despesa)) {
            return false;
        }
        Despesa oDespesa = (Despesa) oObjeto;
        return Objects.equals(this.id, oDespesa.getId());
    }

    @Override
    public String toString() {
        return this.descricao + " - " + FunctDate.getFormattedDate(this.dataPagamento) + " " + this.valor;
    }
}