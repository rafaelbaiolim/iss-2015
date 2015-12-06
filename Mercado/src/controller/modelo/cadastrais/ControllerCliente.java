package controller.modelo.cadastrais;

import funct.FunctString;
import modelo.dao.cadastrais.DaoCliente;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Cliente.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 * @see     modelo.cadastrais.Cliente
 * @see     modelo.dao.cadastrais.DaoCliente
 */
public class ControllerCliente {
    private final DaoCliente  daoCliente;
    private final FunctString functString;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerCliente() {
        this.daoCliente  = new DaoCliente();
        this.functString = new FunctString();
    }
    
    /**
     * Metodo responsavel por verificar se o cpf do Cliente e valido.
     * @param  sCpf Cpf do Cliente.
     * @return Cpf e valido para cadastro.
     */
    public boolean checkCpf(String sCpf) {
        return ((this.functString.checkMask(sCpf, "0123456789.-"))
             && (sCpf.replace(".", "").replace("-", "").length() == 11));
    }
    
    /**
     * Metodo responsavel por verificar se o cnpj do Cliente e valido.
     * @param  sCnpj Cnpj do Cliente.
     * @return Cnpj e valido para cadastro.
     */
    public boolean checkCnpj(String sCnpj) {
        return ((this.functString.checkMask(sCnpj, "0123456789.-/"))
             && (sCnpj.replace(".", "").replace("-", "").replace("/", "").length() == 14));
    }
    
    /**
     * Metodo responsavel por verificar se um Cliente ja esta cadastrado.
     * @param  sDocumento Documento do Cliente.
     * @return Documento ja foi cadastrado.
     */
    public boolean documentoIsAvailable(String sDocumento) {
        return (this.daoCliente.findClienteByDocumento(sDocumento) == null);
    }
    
    /**
     * Metodo responsavel por verificar se o nome do Cliente nao e vazio.
     * @param  sNome Nome do Cliente.
     * @return Nome e valido para cadastro.
     */
    public boolean checkNome(String sNome) {
        return (sNome.trim().length() > 0);
    }
    
    /**
     * Metodo responsavel por verificar se o responsavel do Cliente Juridico nao e vazio.
     * @param  sResponsavel Responsavel do Cliente Juridico.
     * @return Responsavel e valido para cadastro.
     */
    public boolean checkResponsavel(String sResponsavel) {
        return (sResponsavel.trim().length() > 0);
    }
    
    /**
     * Metodo responsavel por verificar se o telefone do Cliente e valido.
     * @param  sTelefone Telefone do Cliente.
     * @return Telefone e valido para cadastro.
     */
    public boolean checkTelefone(String sTelefone) {
        return ((this.functString.checkMask(sTelefone, "0123456789()-"))
             && (sTelefone.replace("(", "").replace(")", "").replace("-", "").length() == 10));
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao atualize com dados ja cadastrados.
     * @param  sDocumento Documento do Cliente.
     * @param  lId Id do Cliente.
     * @return Atulizacao e valida.
     */
    public boolean checkUpdate(String sDocumento, Long lId) {
        return (this.daoCliente.findClienteByDocumento(sDocumento, lId) == null);
    }
}