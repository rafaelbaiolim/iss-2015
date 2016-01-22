package modelo.dao.relacionais.entrada;

import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.Dao;
import modelo.relacionais.entrada.ItemPedido;

/**
 * <p>Classe responsavel pelas operacoes entre a classe ItemPedido e o BD.</p>
 *@author Vanessa Nakahara
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 */
public class DaoItemPedido extends Dao<ItemPedido> {

    public DaoItemPedido() {
        super(ItemPedido.class);
    }
    
    /**
     * Metodo responsavel por retornar a quantidade comprada de um Produto.
     * @param  oProduto Produto.
     * @return Quantidade comprada do Produto.
     */
    public int getQuantidadeComprada(Produto oProduto) {
        int              iQuantidade  = 0;
        List<ItemPedido> oItensPedido = this.list();
        for (int i = 0; i < oItensPedido.size(); ++i) {
            if (oItensPedido.get(i).getProduto().equals(oProduto) == true) {
                iQuantidade += oItensPedido.get(i).getQuantidade();
            }
        }
        return iQuantidade;
    }
    
    public String[][] getItensPedido(List<ItemPedido> oItensPedido) {
        String[][] sItens = new String[oItensPedido.size()][3];
        for (int i = 0; i < oItensPedido.size(); ++i) {
            sItens[i] = oItensPedido.get(i).getInfo();
        }
        return sItens;
    }
}