/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.relacionais.ItemVenda                                       *
 * Coment: Classe de Entidade ItemVenda.                                      *
 *         Classe responsavel por representar os Itens de uma Venda no        *
 *         Sistema.                                                           *
 * ========================================================================== */

package modelo.relacionais;

import modelo.cadastrais.Produto;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    @ManyToOne
    private Produto produto;
    private int     quantidade;
    private float   valorUnitario;
    @ManyToOne
    private Venda   venda;

    public ItemVenda() {
        this.id = null;
    }
    
    public ItemVenda(Produto oProduto, int iQuantidade, float fValorUnitario, Venda oVenda) {
        this();
        this.produto       = oProduto;
        this.quantidade    = iQuantidade;
        this.valorUnitario = fValorUnitario;
        this.venda         = oVenda;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }
    
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto oProduto) {
        this.produto = oProduto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int iQuantidade) {
        this.quantidade = iQuantidade;
    }
    
    public float getValorUnitario() {
        return this.valorUnitario;
    }
    
    public void setValorUnitario(float fValorUnitario) {
        this.valorUnitario = fValorUnitario;
    }
    
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda oVenda) {
        this.venda = oVenda;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof ItemVenda)) {
            return false;
        }
        ItemVenda oItemVenda = (ItemVenda) oObjeto;
        return Objects.equals(this.id, oItemVenda.getId());
    }

    @Override
    public String toString() {
        return this.produto + " - " + this.quantidade;
    }
}