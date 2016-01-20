package modelo.dao.relacionais.saida;

import java.util.ArrayList;
import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.Dao;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;

/**
 * <p>Classe responsavel pelas operacoes entre a classe Venda e o BD.</p>
 * @author Hadyne
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 */
public class DaoItemVenda extends Dao<ItemVenda> {

    public DaoItemVenda() {
        super(ItemVenda.class);
    }
    
    public List<ItemVenda> getItens(Venda oVenda) {
        List<ItemVenda> oItensVenda    = this.list();
        List<ItemVenda> oItensVendaEnc = new ArrayList<>();
        for (int i = 0; i < oItensVenda.size(); ++i) {
            if (oItensVenda.get(i).getVenda().equals(oVenda) == true) {
                oItensVendaEnc.add(oItensVenda.get(i));
            }
        }
        return oItensVendaEnc;       
    }
    
    /**
     * Metodo responsavel por retornar a quantidade vendida de um Produto.
     * @param  oProduto Produto.
     * @return Quantidade Vendida do Produto.
     */
    public int getQuantidadeVendida(Produto oProduto) {
        List<ItemVenda> oItensVenda = this.list();
        int             iQuantidade = 0;
        for (int i = 0; i < oItensVenda.size(); ++i) {
            if (oItensVenda.get(i).getProduto().equals(oProduto) == true) {
                iQuantidade += oItensVenda.get(i).getQuantidade();
            }
        }
        return iQuantidade;
    }
    
    public String[][] getItensVenda(List<ItemVenda> oItensVenda) {
        String[][] sItens = new String[oItensVenda.size()][3];
        for (int i = 0; i < oItensVenda.size(); ++i) {
            sItens[i] = oItensVenda.get(i).getInfo();
        }
        return sItens;
    }
}