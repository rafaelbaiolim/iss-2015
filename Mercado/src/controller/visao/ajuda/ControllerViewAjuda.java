package controller.visao.ajuda;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.ajuda.ViewAjuda;

/**
 * <p></p>
 */
public class ControllerViewAjuda extends ControllerViewModal {
    private final ViewAjuda viewAjuda;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewAjuda(ViewAjuda oView) {
        super(oView);
        this.viewAjuda = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewAjuda.getButtonOk())) {
            this.viewAjuda.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.viewAjuda.getFocusOwner().equals(this.viewAjuda.getButtonOk())) {
                this.viewAjuda.dispose();
            }
        }
    }
}