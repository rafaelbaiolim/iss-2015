/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 17/06/2015                                                         *
 * Classe: controllers.ControllerProduto                                      *
 * Coment: Classe responsavel pelas regras de negocios da Classe de Entidade  *
 *         Produto.                                                           *
 * ========================================================================== */

package controllers;

import dao.modelo.cadastrais.DaoProduto;
import dao.modelo.internos.DaoAcesso;
import dao.modelo.internos.DaoOperacao;
import dao.modelo.relacionais.DaoItemPedido;
import dao.modelo.relacionais.DaoItemVenda;
import modelo.cadastrais.Produto;
import modelo.internos.Acesso;
import modelo.internos.Usuario;
import java.util.List;

public class ControllerProduto {
    private static DaoProduto oDaoProduto = new DaoProduto();
    
    public static boolean checkDescricao(String sDescricao) {
        return sDescricao.length() > 2;
    }
    
    public static boolean descricaoIsAble(String sDescricao) {
        return oDaoProduto.getProdutoByDescricao(sDescricao.toUpperCase()) == null;
    }
    
    public static boolean checkMarca(String sMarca) {
        return sMarca.length() > 1;
    }
    
    public static List<Produto> getProdutosByDescricao(String sDescricao) {
        return oDaoProduto.getProdutosByDescricao(sDescricao);
    }
    
    public static int getQuantidadeComprada(Produto oProduto) {
        return new DaoItemPedido().getItensPedidoByProduto(oProduto);
    }
    
    public static int getQuantidadeVendida(Produto oProduto) {
        return new DaoItemVenda().getItensVendaByProduto(oProduto);
    }
    
    public static String[][] getProdutos(List<Produto> oProdutos) {
        String[][] sProdutos = new String[oProdutos.size()][2];
        for (int i = 0; i < oProdutos.size(); ++i) {
            sProdutos[i][0] = oProdutos.get(i).getDescricao();
            sProdutos[i][1] = oProdutos.get(i).getMarca();
        }
        return sProdutos;
    }
    
    public static void adicionar(String sDescricao, String sMarca, String sPeso, int iQuantidade, float fPrecoUnitario, Usuario oUsuario) {
        Produto oProduto = new Produto(sDescricao, sMarca, sPeso, iQuantidade, fPrecoUnitario);
        new DaoProduto().insert(oProduto);
        new DaoAcesso().insert(new Acesso("Produto = " + oProduto.toString(), new DaoOperacao().getOperacaoByDescricao("CADASTRO DE PRODUTO"), oUsuario));
    }
    
    public static void remover(Produto oProduto, Usuario oUsuario) {
        oDaoProduto.remove(oProduto.getId());
        new DaoAcesso().insert(new Acesso("Produto = " + oProduto.toString(), new DaoOperacao().getOperacaoByDescricao("REMOCAO DE PRODUTO"), oUsuario));
    }
    
    public static void gravar(Produto oProduto, String sDescricao, String sMarca, String sPeso, int iQuantidade, float fPrecoUnitario, Usuario oUsuario) {
        oProduto.setDescricao(sDescricao);
        oProduto.setMarca(sMarca);
        oProduto.setPeso(sPeso);
        oProduto.setQuantidade(iQuantidade);
        oProduto.setPrecoUnitario(fPrecoUnitario);
        oDaoProduto.update(oProduto);
        new DaoAcesso().insert(new Acesso("Produto = " + oProduto.toString(), new DaoOperacao().getOperacaoByDescricao("ALTERACAO DE PRODUTO"), oUsuario));
    }
}