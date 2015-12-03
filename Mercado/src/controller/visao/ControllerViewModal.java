package controller.visao;

import controller.Controller;
import java.awt.event.KeyEvent;
import visao.ViewModal;

/**
 * <p>Classe responsavel por ser o <b>controlador</b> das classes ViewModal.</p>
 * @author  Rafael e Vanessa
 * @version 1.0
 * @since   14/11/2015
 * @see     controller.Controller
 * @see     visao.ViewModal
 */
public abstract class ControllerViewModal extends Controller {
    private final ViewModal viewModal;
    
    public ControllerViewModal(ViewModal oView) {
        super();
        this.viewModal = oView;
    }

    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.viewModal.dispose();
        }
    }
}