package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoFuncionario;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverFuncionario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverFuncionario.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverFuncionario extends ControllerViewRemover {
    private final ViewRemoverFuncionario viewRemoverFuncionario;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverFuncionario(ViewRemoverFuncionario oView) {
        super(oView);
        this.viewRemoverFuncionario = oView;
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
        new DaoFuncionario().remove(this.viewRemoverFuncionario.getFuncionario().getId());
        new ViewMensagem(this.viewRemoverFuncionario.getViewConsulta(), "Funcionario Removido com Sucesso!").setVisible(true);
        this.viewRemoverFuncionario.getViewConsulta().clear();
        this.viewRemoverFuncionario.dispose();
    }
}