package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoFornecedor;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverFornecedor;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverFornecedor.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverFornecedor extends ControllerViewRemover {
    private final ViewRemoverFornecedor viewRemoverFornecedor;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverFornecedor(ViewRemoverFornecedor oView) {
        super(oView);
        this.viewRemoverFornecedor = oView;
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
        new DaoFornecedor().remove(this.viewRemoverFornecedor.getFornecedor().getId());
        new ViewMensagem(this.viewRemoverFornecedor.getViewConsulta(), "Fornecedor Removido com Sucesso!").setVisible(true);
        this.viewRemoverFornecedor.getViewConsulta().clear();
        this.viewRemoverFornecedor.dispose();
    }
}