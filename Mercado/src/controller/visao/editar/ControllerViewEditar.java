package controller.visao.editar;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.editar.ViewEditar;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditar.
 * @author  Vanessa
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.ControllerViewModal
 */
public abstract class ControllerViewEditar extends ControllerViewModal {
    protected ViewEditar viewEditar;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewEditar(ViewEditar oView) {
        super(oView);
        this.viewEditar = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewEditar.getButtonSave())) {
            this.save();
        }else if (oActionEvent.getSource().equals(this.viewEditar.getButtonCancel())) {
            this.viewEditar.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_F1) {
            this.save();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F2) {
            this.viewEditar.dispose();
        }
    }
    
    protected abstract void save();
}