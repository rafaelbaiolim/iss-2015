/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/07/2015                                                         *
 * Classe: dao.modelo.cadastrais.DaoProduto                                   *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Produto e o Banco de Dados.                                        *
 * ========================================================================== */

package dao.modelo.cadastrais;

import dao.Dao;
import modelo.cadastrais.Produto;
import java.util.List;

public class DaoProduto extends Dao<Produto> {

    public DaoProduto() {
        super(Produto.class);
    }
    
    public Produto getProdutoByDescricao(String sDescricao) {
        List<Produto> oProdutosEnc = acesso.createQuery("SELECT e FROM Produto e WHERE e.descricao LIKE '" + sDescricao.toUpperCase() + "'").getResultList();
        return (oProdutosEnc.isEmpty() == false) ? oProdutosEnc.get(0) : null;
    }
    
    public List<Produto> getProdutosByDescricao(String sDescricao) {
        return acesso.createQuery("SELECT e FROM Produto e WHERE e.descricao LIKE '%" + sDescricao.toUpperCase() + "%'").getResultList();
    }
}