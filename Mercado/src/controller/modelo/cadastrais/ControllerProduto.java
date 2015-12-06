package controller.modelo.cadastrais;

import funct.FunctString;
import modelo.dao.cadastrais.DaoProduto;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Produto.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     modelo.cadastrais.Produto
 * @see     modelo.dao.cadastrais.DaoProduto
 * @see     funct.FunctString
 */
public class ControllerProduto {
    private final DaoProduto  daoProduto;
    private final FunctString functString;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerProduto() {
        this.daoProduto  = new DaoProduto();
        this.functString = new FunctString();
    }
    
    /**
     * Metodo responsavel por verificar se a descricao do Produto e maior que 2 caracteres.
     * @param  sDescricao Descricao do Fornecedor.
     * @return Descricao e valida para cadastro.
     */
    public boolean checkDescricao(String sDescricao) {
        return (sDescricao.trim().length() > 2);
    }
    
    /**
     * Metodo responsavel por verificar se a marca do Produto nao e vazia.
     * @param  sMarca Marca do Fornecedor.
     * @return Marca e valida para cadastro.
     */
    public boolean checkMarca(String sMarca) {
        return (sMarca.trim().length() > 0);
    }
    
    /**
     * Metodo responsavel por verificar se o Produto ja esta cadastrado.
     * @param  sDescricao Descricao do Fornecedor.
     * @param  sMarca     Marca do Fornecedor.
     * @return Produto e valida para cadastro.
     */
    public boolean produtoIsAvailable(String sDescricao, String sMarca) {
        return (this.daoProduto.findProdutoByDescricaoAndMarca(sDescricao, sMarca) == null);
    }
    
    /**
     * Metodo responsavel por verificar se a quantidade do Produto nao e vazia.
     * @param  sQuantidade Quantidade do Produto.
     * @return Quantidade e valida para cadastro.
     */
    public boolean checkQuantidade(String sQuantidade) {
        return ((sQuantidade.length() > 0)
             && (this.functString.checkMask(sQuantidade, "0123456789")));
    }
    
    /**
     * Metodo responsavel por verificar se o preco unitario do Produto nao e vazio.
     * @param  sPrecoUnitario Preco Unitario do Produto.
     * @return Preco Unitario e valido para cadastro.
     */
    public boolean checkPrecoUnitario(String sPrecoUnitario) {
        return ((sPrecoUnitario.length() > 2)
             && (this.functString.checkMask(sPrecoUnitario, "0123456789."))
             && (sPrecoUnitario.charAt(0) != '.')
             && (this.functString.countChar(sPrecoUnitario, '.') == 1));
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao atualize com dados ja cadastrados.
     * @param  sDescricao Nome do Produto.
     * @param  sMarca     Marca do Produto.
     * @param  lId        Id do Produto.
     * @return Atulizacao e valida.
     */
    public boolean checkUpdate(String sDescricao, String sMarca, Long lId) {
        return (this.daoProduto.findProdutoByDescricaoAndMarca(sDescricao, sMarca, lId) == null);
    }
}