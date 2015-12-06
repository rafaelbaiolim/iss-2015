package controller.modelo.complementares;

import modelo.dao.complementares.DaoUF;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Entidade UF.
 * @author  Hadyne
 * @version 1.0
 * @since   09/11/2015
 * @see     modelo.complementares.UF
 */
public class ControllerUF {
    private final DaoUF daoUF;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerUF() {
        this.daoUF = new DaoUF();
    }
    
    /**
     * Metodo responsavel por retornar uma Array de String com as siglas cadastradas no Banco de Dados.
     * @return Array de Siglas.
     */
    public Object[] getSiglas() {
        return this.daoUF.getSiglas().toArray();
    }
}