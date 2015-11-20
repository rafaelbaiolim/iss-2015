package controller.visao.mensagens;

import java.awt.event.ActionEvent;
import controller.Controller;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewMensagem.
 * @author  Leandro
 * @version 1.0
 * @since   14/10/2015
 * @see     controller.Controller
 */
public class ControllerViewMensagem extends Controller {
    private final ViewMensagem viewMensagem;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewMensagem(ViewMensagem oView) {
        this.viewMensagem = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewMensagem.getButtonOk())) {
            this.viewMensagem.dispose();
        }
    }
}