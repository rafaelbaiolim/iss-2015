/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerDevolucao                                    *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Devolucao.                                                         *
 * ========================================================================== */

package controllers;

import dao.modelo.cadastrais.DaoProduto;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.relacionais.DaoDevolucao;
import modelo.cadastrais.Produto;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import modelo.relacionais.Devolucao;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import java.util.List;

public class ControllerDevolucao {
    private static DaoDevolucao oDaoDevolucao = new DaoDevolucao();
    private static DaoProduto   oDaoProduto   = new DaoProduto();
    
    public static void adicionar(Venda oVenda, Usuario oUsuario) {
        Devolucao oDevolucao = new Devolucao(oVenda, oUsuario);
        new DaoAcesso().insert(new Acesso("Devolucao = " + oDevolucao.toString(), new DaoOperacao().getOperacaoByDescricao("DEVOLUCAO"), oUsuario));
        oDaoDevolucao.insert(oDevolucao);
    }
    
    public static void atualizarEstoque(List<ItemVenda> itens) {
        if (itens.isEmpty() == false) {
            for (ItemVenda oCurrentItemVenda : itens) {
                Produto oProduto = oCurrentItemVenda.getProduto();
                        oProduto.setQuantidade(oCurrentItemVenda.getProduto().getQuantidade() + oCurrentItemVenda.getQuantidade());
                oDaoProduto.update(oProduto);
            }
        }
    }
}