package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.cadastrais.DaoCliente;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverCliente;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverCliente.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverCliente extends ControllerViewRemover {
    private final ViewRemoverCliente viewRemoverCliente;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverCliente(ViewRemoverCliente oView) {
        super(oView);
        this.viewRemoverCliente = oView;
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
        new DaoCliente().remove(this.viewRemoverCliente.getCliente().getId());
        new ViewMensagem(this.viewRemoverCliente.getViewConsulta(), "Cliente Removido com Sucesso!").setVisible(true);
        this.viewRemoverCliente.getViewConsulta().clear();
        this.viewRemoverCliente.dispose();
    }
}