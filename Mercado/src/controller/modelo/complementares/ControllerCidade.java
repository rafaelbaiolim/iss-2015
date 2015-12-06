package controller.modelo.complementares;

import modelo.complementares.UF;
import modelo.dao.complementares.DaoCidade;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Cidade.
 * @author  Leandro
 * @version 1.0
 * @since   12/11/2015
 * @see     modelo.complementares.Cidade
 * @see     modelo.complementares.UF
 * @see     modelo.dao.complementares.DaoCidade
 */
public class ControllerCidade {
    private final DaoCidade daoCidade;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerCidade() {
        this.daoCidade = new DaoCidade();
    }
    
    /**
     * Metodo responsavel por verificar se o nome da Cidade e maior que 2 caracteres.
     * @param  sNome Nome da Cidade.
     * @return Nome e valido para cadastro.
     */
    public boolean checkNome(String sNome) {
        return sNome.trim().length() > 2;
    }
    
    /**
     * Metodo responsavel por verificar se uma Cidade ja esta cadastrada.
     * @param  sNome Nome da Cidade.
     * @param  oUF   UF da Cidade.
     * @return Nome e UF sao validos para cadastro.
     */
    public boolean cidadeIsAvailable(String sNome, UF oUF) {
        return (this.daoCidade.findCidadeByNomeAndUF(sNome, oUF) == null);
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao atualize com dados ja cadastrados.
     * @param  sNome Nome da Cidade.
     * @param  oUF   UF da Cidade.
     * @param  lId   Id da Cidade.
     * @return Atulizacao e valida.
     */
    public boolean checkUpdate(String sNome, UF oUF, Long lId) {
        return (this.daoCidade.findCidadeByNomeAndUF(sNome, oUF, lId) == null);
    }
}