/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerVenda                                        *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Venda.                                                             *
 * ========================================================================== */

package controllers;

import dao.modelo.cadastrais.DaoProduto;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.relacionais.DaoItemVenda;
import dao.modelo.relacionais.DaoVenda;
import modelo.cadastrais.Produto;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import modelo.relacionais.ItemVenda;
import modelo.relacionais.Venda;
import java.util.ArrayList;
import java.util.List;

public class ControllerVenda {
    private static DaoVenda     oDaoVenda     = new DaoVenda();
    private static DaoItemVenda oDaoItemVenda = new DaoItemVenda();
    private static DaoProduto   oDaoProduto   = new DaoProduto();

    public static List<ItemVenda> getItensVenda(Venda oVenda) {
        return oDaoItemVenda.getItensVendaByVenda(oVenda);
    }
    
    public static float valorTotalVendas() {
        float fValorTotal = 0.0f;
        if (oDaoVenda.list().isEmpty() == false) {
            for (Venda oCurrentVenda : oDaoVenda.list()) {
                fValorTotal += oCurrentVenda.getValorTotal();
            }
        }
        return fValorTotal;
    }
    
    public static int totalVendas() {
        return oDaoVenda.size();
    }
    
    public static void adicionar(Venda oVenda, Usuario oUsuario) {
        oDaoVenda.insert(oVenda);
        new DaoAcesso().insert(new Acesso("Venda = " + oVenda.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE VENDA"), oUsuario));
    }
    
    public static void adicionarItens(List<ItemVenda> oItensVenda) {
        for (ItemVenda oCurrentItemVenda : oItensVenda) {
            oDaoItemVenda.insert(oCurrentItemVenda);
            Produto oProduto = oCurrentItemVenda.getProduto();
                    oProduto.setQuantidade(oProduto.getQuantidade() - oCurrentItemVenda.getQuantidade());
            oDaoProduto.update(oProduto);
        }
    }

    public static List<Venda> getEncomendas(String sCliente) {
        List<Venda> oVendasEnc = new ArrayList<>();
        if (oDaoVenda.getEncomendas().isEmpty() == false) {
            for (Venda oCurrentVenda : oDaoVenda.getEncomendas()) {
                if (oCurrentVenda.getCliente().getNome().contains(sCliente.toUpperCase())) {
                    oVendasEnc.add(oCurrentVenda);
                }
            }
        }
        return oVendasEnc;
    }
    
    public static List<Venda> getVendas(String sCliente) {
        List<Venda> oVendasEnc = new ArrayList<>();
        if (oDaoVenda.list().isEmpty() == false) {
            for (Venda oCurrentVenda : oDaoVenda.list()) {
                if (oCurrentVenda.getCliente().getNome().contains(sCliente.toUpperCase())) {
                    oVendasEnc.add(oCurrentVenda);
                }
            }
        }
        return oVendasEnc;
    }
    
    public static void entregarEncomenda(Venda oVenda) {
        oVenda.setEntrega(true);
        oDaoVenda.update(oVenda);
    }
}