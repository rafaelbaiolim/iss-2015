package modelo.dao.relacionais.entrada;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.Dao;
import modelo.relacionais.entrada.ItemPedido;
import modelo.relacionais.entrada.Pedido;

/**
 * <p>Classe responsavel pelas operacoes entre a classe Pedido e o BD.</p>
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 */
public class DaoPedido extends Dao<Pedido> {

    public DaoPedido() {
        super(Pedido.class);
    }
    
    public List<Pedido> getPedidosNaoEntregues() {
        String sSql = "SELECT e FROM Pedido e WHERE e.recebido = false ORDER BY e.dataCadastro, e.horaCadastro";
        return (List<Pedido>) acesso.createQuery(sSql).getResultList();
    }
    
    public List<ItemPedido> getItensPedido(Pedido oPedido) {
        List<ItemPedido> oItensPedido    = new DaoItemPedido().list();
        List<ItemPedido> oItensPedidoEnc = new ArrayList<>();
        DaoItemPedido    oDaoItemPedido = new DaoItemPedido();
        for (int i = 0; i < oItensPedido.size(); ++i) {
             if (oItensPedido.get(i).getPedido().equals(oPedido)) {
                 oItensPedidoEnc.add(oItensPedido.get(i));
             }
        }
        return oItensPedidoEnc;
    }
    
    public String[][] getPedidos(List<Pedido> oPedidos) {
        String[][] sPedidos = new String[oPedidos.size()][3];
        for (int i = 0; i < oPedidos.size(); ++i) {
            sPedidos[i] = oPedidos.get(i).getInfo();
        }
        return sPedidos;
    }
}