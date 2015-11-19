/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 25/07/2015                                                         *
 * Classe: dao.modelo.relacionais.DaoPedido                                   *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Pedido e o Banco de Dados.                                         *
 * ========================================================================== */

package dao.modelo.relacionais;

import dao.Dao;
import modelo.relacionais.Pedido;
import java.util.ArrayList;
import java.util.List;

public class DaoPedido extends Dao<Pedido> {

    public DaoPedido() {
        super(Pedido.class);
    }
    
    public List<Pedido> getPedidosAtivos() {
        return acesso.createQuery("SELECT e FROM Pedido e WHERE e.ativo = 'S'").getResultList();
    }

    public List<Pedido> getPedidosByFornecedor(String sFornecedor) {
        List<Pedido> oPedidosEnc = new ArrayList<>();
        if (this.getPedidosAtivos().isEmpty() == false) {
            for (Pedido oCurrentPedido : this.getPedidosAtivos()) {
                if (oCurrentPedido.getFornecedor().getNome().contains(sFornecedor.toUpperCase())) {
                    oPedidosEnc.add(oCurrentPedido);
                }
            }
        }
        return oPedidosEnc;
    }
}