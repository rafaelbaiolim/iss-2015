package modelo.dao.cadastrais;

import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.Dao;

/**
 * <p>Classe Dao da Classe de Modelo <b>Produto</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Produto e o BD.</p>
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.cadastrais.Produto
 */
public class DaoProduto extends Dao<Produto> {

    /**
     * Metodo construtor padrão.
     * Define a Classe do Modelo Produto como Entidade da superclasse Dao.
     */
    public DaoProduto() {
        super(Produto.class);
    }
    
    /**
     * Metodo responsavel por retornar o Produto pela sua descricao.
     * @param  sDescricao Descricao do Produto.
     * @return Produto encontrado.
     */
    public Produto findProdutoByDescricao(String sDescricao) {
        String        sSql      = "SELECT e FROM Produto e WHERE e.descricao LIKE '" + sDescricao.toUpperCase() + "'";
        List<Produto> oProdutos = (List<Produto>) acesso.createQuery(sSql).getResultList();
        return (oProdutos.isEmpty() == true) ? null : oProdutos.get(0);
    }
    
    /**
     * Metodo responsavel por retornar o Produto pela sua Descricao e Marca.
     * @param  sDescricao Descricao do Produto.
     * @param  sMarca     Marca do Produto.
     * @return Produto encontrado.
     */
    public Produto findProdutoByDescricaoAndMarca(String sDescricao, String sMarca) {
        String        sSql      = "SELECT e FROM Produto e WHERE e.descricao LIKE '" + sDescricao.toUpperCase() + "' ";
                      sSql     += "AND e.marca LIKE '" + sMarca.toUpperCase() + "'";
        List<Produto> oProdutos = (List<Produto>) acesso.createQuery(sSql).getResultList();
        return (oProdutos.isEmpty() == true) ? null : oProdutos.get(0);
    }
    
    /**
     * Metodo responsavel por retornar um Produto pelo sua Descricao e Marca e com um Id diferente.
     * @param  sDescricao Descricao do Produto.
     * @param  sMarca     Marca do Produto.
     * @param  lId        Id do Produto.
     * @return Produto encontrado.
     */
    public Produto findProdutoByDescricaoAndMarca(String sDescricao, String sMarca, Long lId) {
        String        sSql      = "SELECT e FROM Produto e WHERE e.descricao LIKE '" + sDescricao.toUpperCase() + "' ";
                      sSql     += "AND e.marca LIKE '" + sMarca.toUpperCase() + "' ";
                      sSql     += "AND e.id    <>   "  + lId                  + " ";
        List<Produto> oProdutos = (List<Produto>) acesso.createQuery(sSql).getResultList();
        return (oProdutos.isEmpty() == true) ? null : oProdutos.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Produtos pela sua Descricao/Marca.
     * @param  sProduto Descricao/Marca do Produto.
     * @return Lista de Produtos encontrados.
     */
    public List<Produto> findProdutos(String sProduto) {
        String        sSql      = "SELECT e FROM Produto e WHERE e.descricao LIKE '%" + sProduto.toUpperCase() + "%' ";
                      sSql     += "OR e.marca LIKE '%" + sProduto.toUpperCase() + "%'";
        List<Produto> oProdutos = (List<Produto>) acesso.createQuery(sSql).getResultList();
        return oProdutos;
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais dos Produtos.
     * @param  oProdutos Lista de Produtos a serem listados.
     * @return Matriz com os dados dos Produtos.
     */
    public String[][] getProdutos(List<Produto> oProdutos) {
        String[][] sProdutos = new String[oProdutos.size()][3];
        for (int i = 0; i < oProdutos.size(); ++i) {
            sProdutos[i] = oProdutos.get(i).getInfo();
        }
        return sProdutos;
    }
}