package controller.modelo.gerenciais;

import funct.FunctString;
import modelo.dao.gerenciais.DaoDespesa;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Despesa.
 * @author  Rafael
 * @version 1.0
 * @since   18/11/2015
 * @see     modelo.gerenciais.Despesa
 * @see     modelo.dao.gerenciais.DaoDespesa
 * @see     funct.FunctString
 */
public class ControllerDespesa {
    private final DaoDespesa  daoDespesa;
    private final FunctString functString;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerDespesa() {
        this.daoDespesa  = new DaoDespesa();
        this.functString = new FunctString();
    }
    
    /**
     * Metodo responsavel por verificar se a descricao da Despesa nao e vazia.
     * @param  sDescricao Descrica da Despesa.
     * @return Descricao e valida para cadastro.
     */
    public boolean checkDescricao(String sDescricao) {
        return (sDescricao.trim().length() > 0);
    }
    
    /**
     * Metodo responsavel por verificar se o valor da Despesa e valida.
     * @param  sValor Valor da Despesa.
     * @return Valor e valido para cadastro.
     */
    public boolean checkValor(String sValor) {
        return ((sValor.length() > 2)
             && (this.functString.checkMask(sValor, "0123456789."))
             && (sValor.charAt(0) != '.')
             && (this.functString.countChar(sValor, '.') == 1));
    }
}