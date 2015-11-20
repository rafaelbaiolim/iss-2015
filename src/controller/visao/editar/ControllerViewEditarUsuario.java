package controller.visao.editar;

import java.awt.event.ActionEvent;
import controller.Controller;
import visao.editar.ViewEditarUsuario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarUsuario.
 * @author  Leandro
 * @version 1.0
 * @since   30/10/2015
 * @see     controller.Controller
 */
public class ControllerViewEditarUsuario extends Controller {
    private final ViewEditarUsuario viewEditarUsuario;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarUsuario(ViewEditarUsuario oView) {
        this.viewEditarUsuario = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewEditarUsuario.getButtonSave())) {
            
        }else if (oActionEvent.getSource().equals(this.viewEditarUsuario.getButtonCancel())) {
            this.viewEditarUsuario.dispose();
        }
    }
}