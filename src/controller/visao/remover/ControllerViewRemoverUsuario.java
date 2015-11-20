package controller.visao.remover;

import java.awt.event.ActionEvent;
import modelo.dao.estruturais.DaoUsuario;
import controller.Controller;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverUsuario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverUsuario.
 * @author  Leandro
 * @version 1.0
 * @since   03/11/2015
 * @see     controller.Controller
 */
public class ControllerViewRemoverUsuario extends Controller {
    private final ViewRemoverUsuario viewRemoverUsuario;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverUsuario(ViewRemoverUsuario oView) {
        this.viewRemoverUsuario = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewRemoverUsuario.getButtonYes())) {
            new DaoUsuario().remove(this.viewRemoverUsuario.getUsuario().getId());
            new ViewMensagem(this.viewRemoverUsuario.getViewConsulta(), "Usuário Removido com Sucesso!").setVisible(true);
            this.viewRemoverUsuario.getViewConsulta().clear();
            this.viewRemoverUsuario.dispose();
        }else if (oActionEvent.getSource().equals(this.viewRemoverUsuario.getButtonNo())) {
            this.viewRemoverUsuario.dispose();
        }
    }
}