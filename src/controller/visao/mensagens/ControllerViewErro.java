package controller.visao.mensagens;

import java.awt.event.ActionEvent;
import controller.Controller;
import visao.mensagens.ViewErro;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewErro.
 * @author  Leandro
 * @version 1.0
 * @since   14/10/2015
 * @see     controller.Controller
 */
public class ControllerViewErro extends Controller {
    private final ViewErro viewErro;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewErro(ViewErro oView) {
        this.viewErro = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewErro.getButtonOk())) {
            this.viewErro.dispose();
        }
    }
}