package controller.modelo.estruturais;

import modelo.dao.estruturais.DaoUsuario;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Entidade Usuario.
 * @author  Rafael
 * @version 1.0
 * @since   06/11/2015
 * @see     modelo.estruturais.Usuario
 */
public class ControllerUsuario {
    private final DaoUsuario daoUsuario;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerUsuario() {
        this.daoUsuario = new DaoUsuario();
    }
    
    /**
     * Metodo responsavel por verificar se o login do Usuario e maior que 2 caracteres.
     * @param  sLogin Login do novo Usuario.
     * @return Login e valido para cadastro.
     */
    public boolean checkLogin(String sLogin) {
        return (sLogin.length() > 2);
    }
    
    /**
     * Metodo responsavel por verificar se o login do Usuario ainda nao foi cadastrado.
     * @param  sLogin Login do Usuario.
     * @return Login esta disponivel para cadastro.
     */
    public boolean loginIsAvailable(String sLogin) {
        return (this.daoUsuario.findUsuarioByLogin(sLogin) == null);
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao existe dados ja cadastrados.
     * @param  sLogin Login do Usuario.
     * @param  lId    Id do Usuario.
     * @return 
     */
    public boolean checkUpdate(String sLogin, Long lId) {
        return (this.daoUsuario.findUsuarioByLogin(sLogin, lId) == null);
    }
}