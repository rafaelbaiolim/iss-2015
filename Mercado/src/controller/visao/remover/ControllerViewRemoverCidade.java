package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.complementares.DaoCidade;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverCidade;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverCidade.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverCidade extends ControllerViewRemover {
    private final ViewRemoverCidade viewRemoverCidade;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverCidade(ViewRemoverCidade oView) {
        super(oView);
        this.viewRemoverCidade = oView;
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
        new DaoCidade().remove(this.viewRemoverCidade.getCidade().getId());
        new ViewMensagem(this.viewRemoverCidade.getViewConsulta(), "Cidade Removida com Sucesso!").setVisible(true);
        this.viewRemoverCidade.getViewConsulta().clear();
        this.viewRemoverCidade.dispose();
    }
}