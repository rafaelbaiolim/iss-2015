package controller.visao.mensagens;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.mensagens.ViewErro;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewErro.
 * @author  Vanessa
 * @version 1.0
 * @since   14/10/2015
 * @see     controller.visao.ControllerViewModal
 */
public class ControllerViewErro extends ControllerViewModal {
    private final ViewErro viewErro;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewErro(ViewErro oView) {
        super(oView);
        this.viewErro = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewErro.getButtonOk())) {
            this.viewErro.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if ((oKeyEvent.getKeyCode() == KeyEvent.VK_F1) || 
            (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER)) {
            this.viewErro.dispose();
        }
    }
}