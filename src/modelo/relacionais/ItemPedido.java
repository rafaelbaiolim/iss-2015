/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 01/05/2015                                                         *
 * Classe: modelo.relacionais.ItemPedido                                      *
 * Coment: Classe de Entidade ItemPedido                                      *
 *         Classe responsavel por representar os Itens de um Pedido no        *
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
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    @ManyToOne
    private Pedido  pedido;
    @ManyToOne
    private Produto produto;
    private int     quantidade;
    private float   precoUnitario;
    
    public ItemPedido() {
        this.id = null;
    }

    public ItemPedido(Pedido oPedido, Produto oProduto, int iQuantidade, float fPrecoUnitario) {
        this();
        this.pedido        = oPedido;
        this.produto       = oProduto;
        this.quantidade    = iQuantidade;
        this.precoUnitario = fPrecoUnitario;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido oPedido) {
        this.pedido = oPedido;
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
    
    public float getPrecoUnitario() {
        return this.precoUnitario;
    }
    
    public void setPrecoUnitario(float fPrecoUnitario) {
        this.precoUnitario = fPrecoUnitario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObjeto) {
        if (!(oObjeto instanceof ItemPedido)) {
            return false;
        }
        ItemPedido oItemPedido = (ItemPedido) oObjeto;
        return Objects.equals(this.id, oItemPedido.getId());
    }

    @Override
    public String toString() {
        return this.pedido + " - " + this.produto + " - " + this.quantidade + " - " + this.precoUnitario;
    }
}