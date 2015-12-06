package controller.modelo.gerenciais;

import funct.FunctString;
import modelo.dao.gerenciais.DaoFornecedor;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Fornecedor.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     modelo.gerenciais.Fornecedor
 * @see     modelo.dao.gerenciais.DaoFornecedor
 */
public class ControllerFornecedor {
    private final DaoFornecedor daoFornecedor;
    private final FunctString   functString;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerFornecedor() {
        this.daoFornecedor = new DaoFornecedor();
        this.functString   = new FunctString();
    }
    
    /**
     * Metodo responsavel por verificar se o nome do Fornecedor e maior que 2 caracteres.
     * @param  sNome Nome do Fornecedor.
     * @return Nome e valido para cadastro.
     */
    public boolean checkNome(String sNome) {
        return (sNome.trim().length() > 2);
    }
    
    /**
     * Metodo responsavel por verificar se o nome do Fornecedor ja esta cadastrado.
     * @param  sNome Nome do Fornecedor.
     * @return Nome ja foi cadastrado.
     */
    public boolean nomeIsAvailable(String sNome) {
        return (this.daoFornecedor.findFornecedorByNome(sNome) == null);
    }
    
    /**
     * Metodo responsavel por verificar se o cnpj do Fornecedor e valido.
     * @param  sCnpj Cnpj do Fornecedor.
     * @return Cnpj e valido para cadastro.
     */
    public boolean checkCnpj(String sCnpj) {
        return ((this.functString.checkMask(sCnpj, "0123456789.-/"))
             && (sCnpj.replace(".", "").replace("-", "").replace("/", "").length() == 14));
    }
    
    /**
     * Metodo responsavel por verificar se o cnpj do Fornecedor ja esta cadastrado.
     * @param  sCnpj do Fornecedor.
     * @return CNPJ ja foi cadastrado.
     */
    public boolean cnpjIsAvailable(String sCnpj) {
        return (this.daoFornecedor.findFornecedorByCnpj(sCnpj) == null);
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao atualize com dados ja cadastrados.
     * @param  sCnpj CNPJ do Fornecedor.
     * @param  sNome Nome do Fornecedor.
     * @param  lId   Id do Fornecedor.
     * @return Atulizacao e valida.
     */
    public boolean checkUpdate(String sCnpj, String sNome, Long lId) {
        return (this.daoFornecedor.findFornecedorByNomeAndCNPJ(sNome, sCnpj, lId) == null);
    }
}