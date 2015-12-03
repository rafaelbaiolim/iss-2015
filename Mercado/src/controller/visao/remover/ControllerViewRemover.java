package controller.visao.remover;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.remover.ViewRemover;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemover.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.ControllerViewModal
 */
public abstract class ControllerViewRemover extends ControllerViewModal {
    protected ViewRemover viewRemover;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemover(ViewRemover oView) {
        super(oView);
        this.viewRemover = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewRemover.getButtonYes())) {
            this.remover();
        }else if (oActionEvent.getSource().equals(this.viewRemover.getButtonNo())) {
            this.viewRemover.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.viewRemover.getFocusOwner().equals(this.viewRemover.getButtonYes())) {
                this.remover();
            }else if (this.viewRemover.getFocusOwner().equals(this.viewRemover.getButtonNo())) {
                this.viewRemover.dispose();
            }
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F1) {
            this.remover();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F2) {
            this.viewRemover.dispose();
        }
    }
    
    protected abstract void remover();
}