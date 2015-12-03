package modelo.cadastrais;

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
 * <p>Classe de <b>Modelo</b> Produto.</p>
 * <p>Classe responsavel por representar os Produtos do Mercado no Sistema.</p>
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   08/11/2015
 */
@Entity
@Table (name = "produto")
@TableGenerator (name = "produto_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "produto", allocationSize = 1)
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "produto_generator")
    @Column (name = "id")
    private Long    id;
    @Column (name = "descricao")
    private String  descricao;
    @Column (name = "marca")
    private String  marca;
    @Column (name = "peso")
    private String  peso;
    @Column (name = "quantidade")
    private int     quantidade;
    @Column (name = "preco_unitario")
    private float   precoUnitario;
    @Column (name = "fl_ativo")
    private boolean ativo;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;

    public Produto() {
        this.id           = null;
        this.ativo        = true;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Produto(String sDescricao, int iQuantidade, float fPrecoUnitario) {
        this();
        this.descricao     = sDescricao.toUpperCase().trim();
        this.quantidade    = (iQuantidade >= 0)    ? iQuantidade    : 0;
        this.precoUnitario = (fPrecoUnitario >= 0) ? fPrecoUnitario : 0.0f;
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
        this.peso = sPeso;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int iQuantidade) {
        this.quantidade = (iQuantidade >= 0) ?  iQuantidade : 0;
    }

    public float getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(float fPrecoUnitario) {
        this.precoUnitario = (fPrecoUnitario >= 0) ? fPrecoUnitario : 0.0f;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean bAtivo) {
        this.ativo = bAtivo;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public Time getHoraCadastro() {
        return this.horaCadastro;
    }
    
    public String[] getInfo() {
        String[] sProduto    = new String[3];
                 sProduto[0] = this.id.toString();
                 sProduto[1] = this.descricao;
                 sProduto[2] = this.marca;
        return   sProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Produto)) {
            return false;
        }
        Produto oProduto = (Produto) oObject;
        return Objects.equals(this.id, oProduto.getId());
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}