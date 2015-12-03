package controller.modelo.gerenciais;

import funct.FunctString;
import modelo.dao.gerenciais.DaoFuncionario;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Funcionario.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     modelo.gerenciais.Funcionario
 * @see     modelo.dao.gerenciais.DaoFuncionario
 */
public class ControllerFuncionario {
    private final DaoFuncionario daoFuncionario;
    private final FunctString    functString;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerFuncionario() {
        this.daoFuncionario = new DaoFuncionario();
        this.functString    = new FunctString();
    }
    
    /**
     * Metodo responsavel por verificar se o nome do Funcionario e maior que 2 caracteres.
     * @param  sNome Nome do Funcionario.
     * @return Nome e valido para cadastro.
     */
    public boolean checkNome(String sNome) {
        return (sNome.trim().length() > 2);
    }
    
    /**
     * Metodo responsavel por verificar se o cpf do Funcionario e valido.
     * @param  sCpf Cpf do Funcionario.
     * @return Cpf e valido para cadastro.
     */
    public boolean checkCpf(String sCpf) {
        return ((this.functString.checkMask(sCpf, "0123456789.-"))
             && (sCpf.replace(".", "").replace("-", "").length() == 11));
    }
    
    /**
     * Metodo responsavel por verificar se um Funcionario ja esta cadastrado.
     * @param  sCpf do Funcionario
     * @return CPF ja foi cadastrado.
     */
    public boolean cpfIsAvailable(String sCpf) {
        return (this.daoFuncionario.findFuncionarioByCpf(sCpf) == null);
    }
    
    /**
     * Metodo responsavel por verificar se o cargo do Funcionario nao e vazio.
     * @param  sCargo Cargo do Funcionario.
     * @return Cargo e valido para cadastro.
     */
    public boolean checkCargo(String sCargo) {
        return (sCargo.trim().length() > 0);
    }
    
    /**
     * Metodo responsavel por verificar se a carga horaria do Funcionario nao e vazia.
     * @param  sCargaHoraria Carga Horaria do Funcionario.
     * @return Carga Horaria e valida para cadastro.
     */
    public boolean checkCargaHoraria(String sCargaHoraria) {
        return ((sCargaHoraria.length() > 0)
             && (this.functString.checkMask(sCargaHoraria, "0123456789")));
    }
    
    /**
     * Metodo responsavel por verificar se o salario do Funcionario nao e vazio.
     * @param  sSalario Salario do Funcionario.
     * @return Salario e valido para cadastro.
     */
    public boolean checkSalario(String sSalario) {
        return ((sSalario.length() > 2)
             && (this.functString.checkMask(sSalario, "0123456789."))
             && (sSalario.charAt(0) != '.')
             && (this.functString.countChar(sSalario, '.') == 1));
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao atualize com dados ja cadastrados.
     * @param  sCpf Nome da Cidade.
     * @param  lId   Id da Cidade.
     * @return Atulizacao e valida.
     */
    public boolean checkUpdate(String sCpf, Long lId) {
        return (this.daoFuncionario.findFuncionarioByCpf(sCpf, lId) == null);
    }
}