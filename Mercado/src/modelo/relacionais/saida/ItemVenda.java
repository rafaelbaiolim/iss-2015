package modelo.relacionais.saida;

import java.io.Serializable;
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
import modelo.cadastrais.Produto;

/**
 * <p>Classe de <b>Modelo</b> ItemVenda.</p>
 * <p>Classe responsavel por representar os Itens das Vendas do Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   09/11/2015
 */
@Entity
@Table (name = "item_venda")
@TableGenerator (name = "item_venda_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "item_venda", allocationSize = 1)
public class ItemVenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "item_venda_generator")
    @Column (name = "id")
    private Long    id;
    @ManyToOne
    @JoinColumn (name = "venda_id")
    private Venda   venda;
    @ManyToOne
    @JoinColumn (name = "produto_id")
    private Produto produto;
    @Column (name = "quantidade")
    private int     quantidade;
    @Column (name = "valor_unitario")
    private float   valorUnitario;
    
    public ItemVenda() {
        this.id = null;
    }
    
    public ItemVenda(Venda oVenda, Produto oProduto, int iQuantidade, float fValorUnitario) {
        this();
        this.venda         = oVenda;
        this.produto       = oProduto;
        this.quantidade    = (iQuantidade >= 0)      ? iQuantidade    : 0;
        this.valorUnitario = (fValorUnitario >= 0.0) ? fValorUnitario : 0.0f;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda oVenda) {
        this.venda = oVenda;
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
        this.quantidade = (iQuantidade >= 0) ? iQuantidade : 0;
    }

    public float getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(float fValorUnitario) {
        this.valorUnitario = (fValorUnitario >= 0.0) ? fValorUnitario : 0.0f;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof ItemVenda)) {
            return false;
        }
        ItemVenda oItemVenda = (ItemVenda) oObject;
        return Objects.equals(this.id, oItemVenda.getId());
    }

    @Override
    public String toString() {
        return this.venda + " - " + this.produto + " = " + this.quantidade;
    }
    public String[] getInfo() {
        String[] sInfo    = new String[3];
                 sInfo[0] = this.produto.getDescricao().trim();
                 sInfo[1] = Integer.toString(this.quantidade);
                 sInfo[2] = Float.toString(this.valorUnitario);
        return   sInfo;
    }


}