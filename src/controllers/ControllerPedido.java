/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerPedido                                       *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Pedido.                                                            *
 * ========================================================================== */

package controllers;

import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.relacionais.DaoItemPedido;
import dao.modelo.relacionais.DaoPedido;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import modelo.relacionais.ItemPedido;
import modelo.relacionais.Pedido;
import java.util.List;

public class ControllerPedido {
    private static DaoPedido     oDaoPedido     = new DaoPedido();
    private static DaoItemPedido oDaoItemPedido = new DaoItemPedido();
    
    public static void adicionar(Pedido oPedido, Usuario oUsuario) {
        oDaoPedido.insert(oPedido);
        new DaoAcesso().insert(new Acesso("Pedido = " + oPedido.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE PEDIDO"), oUsuario));
    }
    
    public static void adicionarItens(List<ItemPedido> oItensPedido) {
        for (ItemPedido oCurrentItemPedido : oItensPedido) {
            oDaoItemPedido.insert(oCurrentItemPedido);
        }
    }
    
    public static float valorTotalPedidos() {
        float fValorTotal = 0.0f;
        if (oDaoPedido.list().isEmpty() == false) {
            for (Pedido oCurrentPedido : oDaoPedido.list()) {
                fValorTotal += oCurrentPedido.getValorTotal();
            }
        }
        return fValorTotal;
    }
    
    public static int totalPedidos() {
        return oDaoPedido.size();
    }
    
    public static List<ItemPedido> getItensPedido(Pedido oPedido) {
        return oDaoItemPedido.getItensPedidoByPedido(oPedido);
    }
    
    public static void desativaPedido(Pedido oPedido) {
        oPedido.setAtivo('N');
        oDaoPedido.update(oPedido);
    }
    
    public static List<Pedido> getPedidos() {
        return oDaoPedido.getPedidosAtivos();
    }
    
    public static List<Pedido> getPedidos(String sFornecedor) {
        return oDaoPedido.getPedidosByFornecedor(sFornecedor);
    }
}