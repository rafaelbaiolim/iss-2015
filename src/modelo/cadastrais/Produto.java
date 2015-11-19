/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.cadastrais.Produto                                          *
 * Coment: Classe de Entidade Produto.                                        *
 *         Classe responsavel por representar o Produto no Sistema.           *
 * ========================================================================== */

package modelo.cadastrais;

import funcoes.FunctDate;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
    private String descricao;
    private String marca;
    private String peso;
    private int    quantidade;
    private float  precoUnitario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    private final Time horaCadastro;
    
    public Produto() {
        this.id           = null;
        this.dataCadastro = FunctDate.getCurrentDate();
        this.horaCadastro = FunctDate.getCurrentTime();
    }
    
    public Produto(String sDescricao, int iQuantidade, float fPrecoUnitario) {
        this();
        this.descricao     = sDescricao.toUpperCase().trim();
        this.quantidade    = iQuantidade;
        this.precoUnitario = fPrecoUnitario;
    }
    
    public Produto(String sDescricao, String sMarca, String sPeso, int iQuantidade, float fPrecoUnitario) {
        this(sDescricao, iQuantidade, fPrecoUnitario);
        this.marca = sMarca.toUpperCase().trim();
        this.peso  = sPeso;
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

    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String sMarca) {
        this.marca = sMarca.toUpperCase().trim();
    }
    
    public String getPeso() {
        return this.peso;
    }
    
    public void setPeso(String sPeso) {
        this.peso = sPeso.trim();
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int iQuantidade) {
        this.quantidade = iQuantidade;
    }
    
    public float getPrecoUnitario() {
        return this.precoUnitario;
    }
    
    public void setPrecoUnitario(float fPrecoUnitario) {
        this.precoUnitario = fPrecoUnitario;
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
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof Produto)) {
            return false;
        }
        Produto oProduto = (Produto) oObjeto;
        return Objects.equals(this.id, oProduto.getId());
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}