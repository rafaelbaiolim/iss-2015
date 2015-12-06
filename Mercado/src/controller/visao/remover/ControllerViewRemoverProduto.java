package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.cadastrais.DaoProduto;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverProduto;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverProduto.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverProduto extends ControllerViewRemover {
    private final ViewRemoverProduto viewRemoverProduto;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverProduto(ViewRemoverProduto oView) {
        super(oView);
        this.viewRemoverProduto = oView;
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
        new DaoProduto().remove(this.viewRemoverProduto.getProduto().getId());
        new ViewMensagem(this.viewRemoverProduto.getViewConsulta(), "Produto Removido com Sucesso!").setVisible(true);
        this.viewRemoverProduto.getViewConsulta().clear();
        this.viewRemoverProduto.dispose();
    }
}