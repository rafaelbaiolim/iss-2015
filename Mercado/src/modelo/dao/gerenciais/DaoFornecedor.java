package modelo.dao.gerenciais;

import java.util.List;
import modelo.dao.Dao;
import modelo.gerenciais.Fornecedor;

/**
 * <p>Classe Dao da Classe de Modelo <b>Fornecedor</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Fornecedor e o BD.</p>
 * @author  Vanessa
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.dao.Dao
 * @see     modelo.gerenciais.Fornecedor
 */
public class DaoFornecedor extends Dao<Fornecedor> {

    /**
     * <p>Metodo construtor padrão.</p>
     * <p>Define a Classe do Modelo <b>Fornecedor</b> como Entidade da superclasse Dao.</p>
     */
    public DaoFornecedor() {
        super(Fornecedor.class);
    }
    
    /**
     * Metodo responsavel por retornar o Fornecedor pelo nome.
     * @param  sNome Nome do Fornecedor.
     * @return Fornecedor encontrado.
     */
    public Fornecedor findFornecedorByNome(String sNome) {
        String           sSql           = "SELECT e FROM Fornecedor e WHERE e.nome LIKE '" + sNome + "'";
        List<Fornecedor> oFornecedores  = (List<Fornecedor>) acesso.createQuery(sSql).getResultList();
        return (oFornecedores.isEmpty() == true) ? null : oFornecedores.get(0);
    }
    
    /**
     * Metodo responsavel por retornar o Fornecedor pelo CNPJ.
     * @param  sCnpj CNPJ do Fornecedor.
     * @return Fornecedor encontrado.
     */
    public Fornecedor findFornecedorByCnpj(String sCnpj) {
        String           sSql           = "SELECT e FROM Fornecedor e WHERE e.cnpj LIKE '" + sCnpj + "'";
        List<Fornecedor> oFornecedores  = (List<Fornecedor>) acesso.createQuery(sSql).getResultList();
        return (oFornecedores.isEmpty() == true) ? null : oFornecedores.get(0);
    }
    
    /**
     * Metodo responsavel por retornar um Fornecedor pelo seu Nome e CNPJ e com um Id diferente.
     * @param  sNome Nome do Fornecedor.
     * @param  sCnpj CNPJ do Fornecedor.
     * @param  lId   Id do Fornecedor.
     * @return Fornecedor encontrado.
     */
    public Fornecedor findFornecedorByNomeAndCNPJ(String sNome, String sCnpj, Long lId) {
        String           sSql           = "SELECT e FROM Fornecedor e WHERE (e.nome LIKE '" + sNome + "' ";
                         sSql          += "OR e.cnpj LIKE '" + sCnpj + "') AND e.id <> " + lId;
        List<Fornecedor> oFornecedores  = (List<Fornecedor>) acesso.createQuery(sSql).getResultList();
        return (oFornecedores.isEmpty() == true) ? null : oFornecedores.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Fornecedores pelo Nome/CNPJ.
     * @param  sFornecedor Nome/CNPJ dos Fornecedores.
     * @return Lista de Fornecedores encontrados.
     */
    public List<Fornecedor> findFornecedores(String sFornecedor) {
        String           sSql           = "SELECT e FROM Fornecedor e WHERE e.nome LIKE '%" + sFornecedor + "%' ";
                         sSql          += "OR e.cnpj LIKE '%" + sFornecedor + "%'";
        List<Fornecedor> oFornecedores  = (List<Fornecedor>) acesso.createQuery(sSql).getResultList();
        return oFornecedores;
    }
    
    /**
     * Metodo responsavel por retornar uma Matriz com os elementos principais dos Fornecedores.
     * @param  oFornecedores Lista de Fornecedores a serem listados.
     * @return Matriz com os dados dos Fornecedores.
     */
    public String[][] getFornecedores(List<Fornecedor> oFornecedores) {
        String[][] sFornecedores = new String[oFornecedores.size()][3];
        for (int i = 0; i < oFornecedores.size(); ++i) {
            sFornecedores[i] = oFornecedores.get(i).getInfo();
        }
        return sFornecedores;
    }
}