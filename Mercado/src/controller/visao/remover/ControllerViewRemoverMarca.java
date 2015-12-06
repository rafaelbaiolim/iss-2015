package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoMarca;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverMarca;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverMarca.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverMarca extends ControllerViewRemover {
    private final ViewRemoverMarca viewRemoverMarca;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverMarca(ViewRemoverMarca oView) {
        super(oView);
        this.viewRemoverMarca = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }

    @Override
    protected void remover() {
        new DaoMarca().remove(this.viewRemoverMarca.getMarca().getId());
        new ViewMensagem(this.viewRemoverMarca.getViewConsulta(), "Marca Removida com Sucesso!").setVisible(true);
        this.viewRemoverMarca.getViewConsulta().clear();
        this.viewRemoverMarca.dispose();
    }
}