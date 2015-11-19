/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 15/07/2015                                                         *
 * Classe: dao.modelo.gerenciais.DaoFornecedor                                *
 * Coment: Classe responsavel pelas operacoes entre a Classe de Entidade      *
 *         Fornecedor e o Banco de Dados.                                     *
 * ========================================================================== */

package dao.modelo.gerenciais;

import dao.Dao;
import modelo.gerenciais.Fornecedor;
import java.util.List;

public class DaoFornecedor extends Dao<Fornecedor> {

    public DaoFornecedor() {
        super(Fornecedor.class);
    }

    public Fornecedor getFornecedorByNome(String sNome) {
        List<Fornecedor> oFornecedores = this.list();
        if (oFornecedores.isEmpty() == false) {
            for (Fornecedor oCurrentFornecedor : oFornecedores) {
                if (oCurrentFornecedor.getNome().equals(sNome.toUpperCase().trim())) {
                    return oCurrentFornecedor;
                }
            }
        }
        return null;
    }
    
    public List<Fornecedor> getFornecedoresByNome(String sNome) {
        return acesso.createQuery("SELECT e FROM Fornecedor e WHERE e.nome LIKE '%" + sNome.toUpperCase() + "%'").getResultList();
    }
    
    public Fornecedor getFornecedoByNome(String sNome) {
        List<Fornecedor> oFornecedoresEnc = acesso.createQuery("SELECT e FROM Fornecedor e WHERE e.nome = '" + sNome.toUpperCase() + "'").getResultList();
        return (oFornecedoresEnc.isEmpty() == false) ? oFornecedoresEnc.get(0) : null;
    }
    
    public Fornecedor getFornecedorByCNPJ(String sCnpj) {
        List<Fornecedor> oFornecedores = this.list();
        if (oFornecedores.isEmpty() == false) {
            for (Fornecedor oCurrentFornecedor : oFornecedores) {
                if (oCurrentFornecedor.getCnpj().equals(sCnpj)) {
                    return oCurrentFornecedor;
                }
            }
        }
        return null;
    }
}