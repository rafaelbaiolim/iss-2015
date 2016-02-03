package controller.visao.cadastro;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.ajuda.ViewAjudaCadastro;
import visao.cadastro.ViewCadastro;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastro.
 * @author  Leandro
 * @version 1.0
 * @since   04/11/2015
 * @see     controller.visao.ControllerViewModal
 */
public abstract class ControllerViewCadastro extends ControllerViewModal {
    protected ViewCadastro viewCadastro;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewCadastro(ViewCadastro oView) {
        super(oView);
        this.viewCadastro = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewCadastro.getButtonInserir())) {
            this.cadastro();
        }else if (oActionEvent.getSource().equals(this.viewCadastro.getButtonClear())) {
            this.viewCadastro.clear();
        }else if (oActionEvent.getSource().equals(this.viewCadastro.getButtonBack())) {
            this.viewCadastro.dispose();
        }else if (oActionEvent.getSource().equals(this.viewCadastro.getButtonAjuda())) {
            new ViewAjudaCadastro(this.viewCadastro).setVisible(true);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_F1) {
            this.cadastro();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F2) {
            this.viewCadastro.clear();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F3) {
            this.viewCadastro.dispose();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F4) {
            new ViewAjudaCadastro(this.viewCadastro).setVisible(true);
        }
    }
    
    protected abstract void cadastro();
}