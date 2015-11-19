/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/07/2015                                                         *
 * Classe: dao.modelo.relacionais.DaoItemPedido                               *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         ItemPedido e o Banco de Dados.                                     *
 * ========================================================================== */

package dao.modelo.relacionais;

import dao.Dao;
import modelo.cadastrais.Produto;
import modelo.relacionais.ItemPedido;
import modelo.relacionais.Pedido;
import java.util.ArrayList;
import java.util.List;

public class DaoItemPedido extends Dao<ItemPedido> {

    public DaoItemPedido() {
        super(ItemPedido.class);
    }
    
    public List<ItemPedido> getItensPedidoByPedido(Pedido oPedido) {
        List<ItemPedido> oItensPedido = new ArrayList<>();
        if (this.list().isEmpty() == false) {
            for (ItemPedido oCurrentItemPedido : this.list()) {
                if (oCurrentItemPedido.getPedido().equals(oPedido)) {
                    oItensPedido.add(oCurrentItemPedido);
                }
            }
        }
        return oItensPedido;
    }
    
    public int getItensPedidoByProduto(Produto oProduto) {
        int iQuantidade = 0;
        if (this.list().isEmpty() == false) {
            for (ItemPedido oCurrentItemPedido : this.list()) {
                if (oCurrentItemPedido.getProduto().equals(oProduto)) {
                    iQuantidade += oCurrentItemPedido.getQuantidade();
                }
            }
        }
        return iQuantidade;
    }
}