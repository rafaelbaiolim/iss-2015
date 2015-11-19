/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerEntrada                                      *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Entrada.                                                           *
 * ========================================================================== */

package controllers;

import dao.modelo.cadastrais.DaoProduto;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.relacionais.DaoEntrada;
import modelo.cadastrais.Produto;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import modelo.relacionais.Entrada;
import modelo.relacionais.ItemPedido;
import modelo.relacionais.Pedido;
import java.util.List;

public class ControllerEntrada {
    private static DaoEntrada oDaoEntrada = new DaoEntrada();
    private static DaoProduto oDaoProduto = new DaoProduto();
    
    public static void adicionar(String sNotaFiscal, Pedido oPedido, Usuario oUsuario) {
        Entrada oEntrada = new Entrada(sNotaFiscal, oPedido, oUsuario);
        oDaoEntrada.insert(oEntrada);
        new DaoAcesso().insert(new Acesso("Pedido = " + oPedido.toString(), new DaoOperacao().getOperacaoByDescricao("CONFIRMACAO DE ENTRADA"), oUsuario));
    }
    
    public static void atualizarEstoque(List<ItemPedido> oItensPedido) {
        if (oItensPedido.isEmpty() == false) {
            for (ItemPedido oCurrentItemPedido : oItensPedido) {
                Produto oProduto = oCurrentItemPedido.getProduto();
                        oProduto.setQuantidade(oCurrentItemPedido.getProduto().getQuantidade() + oCurrentItemPedido.getQuantidade());
                oDaoProduto.update(oProduto);
            }
        }
    }
}
