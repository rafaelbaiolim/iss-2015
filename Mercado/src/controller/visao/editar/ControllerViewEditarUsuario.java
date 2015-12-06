package controller.visao.editar;

import controller.modelo.estruturais.ControllerUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;
import visao.editar.ViewEditarUsuario;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarUsuario.
 * @author  Rafael
 * @version 1.0
 * @since   30/10/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarUsuario extends ControllerViewEditar {
    private final ViewEditarUsuario viewEditarUsuario;
    private final ControllerUsuario controllerUsuario;
    private final DaoUsuario        daoUsuario;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarUsuario(ViewEditarUsuario oView) {
        super(oView);
        this.viewEditarUsuario = oView;
        this.controllerUsuario = new ControllerUsuario();
        this.daoUsuario        = new DaoUsuario();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }

    @Override
    protected void save() {
        String  sLogin  = this.viewEditarUsuario.getTextFieldLogin().getText().trim();
        boolean bAtivo  = this.viewEditarUsuario.getCheckBoxAtivo().isSelected();
        boolean bAdm    = this.viewEditarUsuario.getCheckBoxAdm().isSelected();
        if (this.checkParameters(sLogin) == true) {
            Usuario oUsuario = this.viewEditarUsuario.getUsuario();
                    oUsuario.setLogin(sLogin);
                    oUsuario.setAtivo(bAtivo);
            this.daoUsuario.update(oUsuario);
            new ViewMensagem(this.viewEditarUsuario, "Usuário Atualizado com Sucesso!").setVisible(true);
            this.viewEditarUsuario.dispose();
            this.viewEditarUsuario.getViewConsultaUsuario().clear();
        }
    }
    
    private boolean checkParameters(String sLogin) {
        if (this.controllerUsuario.checkLogin(sLogin) == false) {
            new ViewErro(this.viewEditarUsuario, "Login Invalido!").setVisible(true);
            this.viewEditarUsuario.getTextFieldLogin().requestFocus();
            return false;
        }else if (this.controllerUsuario.checkUpdate(sLogin, this.viewEditarUsuario.getUsuario().getId()) == false) {
            new ViewErro(this.viewEditarUsuario, "Login já Cadastrado!").setVisible(true);
            this.viewEditarUsuario.getTextFieldLogin().requestFocus();
            return false;
        }
        return true;
    }
}