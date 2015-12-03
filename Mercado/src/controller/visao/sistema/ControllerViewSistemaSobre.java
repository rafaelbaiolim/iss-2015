package controller.visao.sistema;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.sistema.ViewSistemaSobre;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewSistemaSobre.
 * @author  Hadyne
 * @version 1.0
 * @since   14/10/2015
 * @see     controller.visao.ControllerViewModal
 */
public class ControllerViewSistemaSobre extends ControllerViewModal {
    private final ViewSistemaSobre viewSistemaSobre;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewSistemaSobre(ViewSistemaSobre oView) {
        super(oView);
        this.viewSistemaSobre = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewSistemaSobre.getButtonOk())) {
            this.viewSistemaSobre.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.viewSistemaSobre.getFocusOwner().equals(this.viewSistemaSobre.getButtonOk())) {
                this.viewSistemaSobre.dispose();
            }
        }
    }
}