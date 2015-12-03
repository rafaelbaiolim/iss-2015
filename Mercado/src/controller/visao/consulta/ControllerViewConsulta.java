package controller.visao.consulta;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.consulta.ViewConsulta;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsulta.
 * @author  Rafael
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.ControllerViewModal
 */
public abstract class ControllerViewConsulta extends ControllerViewModal {
    protected ViewConsulta viewConsulta;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsulta(ViewConsulta oView) {
        super(oView);
        this.viewConsulta = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewConsulta.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewConsulta.getButtonEdit())) {
            this.edit();
        }else if (oActionEvent.getSource().equals(this.viewConsulta.getButtonRemove())) {
            this.remove();
        }else if (oActionEvent.getSource().equals(this.viewConsulta.getButtonBack())) {
            this.viewConsulta.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if ((oKeyEvent.getKeyCode() == KeyEvent.VK_F5)
          ||(oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER)) {
            this.pesquisar();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F1) {
            this.edit();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F2) {
            this.remove();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F3) {
            this.viewConsulta.dispose();
        }
    }
    
    protected abstract void pesquisar();
    
    protected abstract void edit();
    
    protected abstract void remove();
}