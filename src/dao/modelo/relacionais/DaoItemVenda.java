/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/07/2015                                                         *
 * Classe: dao.modelo.relacionais.DaoItemVenda                                *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         ItemVenda e o Banco de Dados.                                      *
 * ========================================================================== */

package dao.modelo.relacionais;

import dao.Dao;
import modelo.cadastrais.Produto;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import java.util.ArrayList;
import java.util.List;

public class DaoItemVenda extends Dao<ItemVenda> {

    public DaoItemVenda() {
        super(ItemVenda.class);
    }
    
    public List<ItemVenda> getItensVendaByVenda(Venda oVenda) {
        List<ItemVenda> oItensVenda = new ArrayList<>();
        if (this.list().isEmpty() == false) {
            for (ItemVenda oCurrentItemVenda : this.list()) {
                if (oCurrentItemVenda.getVenda().equals(oVenda)) {
                    oItensVenda.add(oCurrentItemVenda);
                }
            }
        }
        return oItensVenda;
    }
    
    public int getItensVendaByProduto(Produto oProduto) {
        int iQuantidade = 0;
        if (this.list().isEmpty() == false) {
            for (ItemVenda oCurrentItemVenda : this.list()) {
                if (oCurrentItemVenda.getProduto().equals(oProduto)) {
                    iQuantidade += oCurrentItemVenda.getQuantidade();
                }
            }
        }
        return iQuantidade;
    }
}