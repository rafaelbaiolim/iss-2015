package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import visao.consulta.ViewConsultaProduto;
import visao.editar.ViewEditarProduto;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverProduto;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaProduto.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaProduto extends ControllerViewConsulta {
    private final ViewConsultaProduto viewConsultaProduto;
    private final DaoProduto          daoProduto;
    private       List<Produto>       produtos;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaProduto(ViewConsultaProduto oView) {
        super(oView);
        this.viewConsultaProduto = oView;
        this.daoProduto          = new DaoProduto();
        this.produtos            = this.daoProduto.list();
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
    protected void pesquisar() {
        String sProduto = this.viewConsultaProduto.getTextFieldPesquisa().getText();
        this.produtos   = this.daoProduto.findProdutos(sProduto);
        this.viewConsultaProduto.addRows(this.daoProduto.getProdutos(this.produtos));
    }

    @Override
    protected void edit() {
        int iIndex    = this.viewConsultaProduto.getTable().getSelectedRow();
        int iProdutos = this.produtos.size();
        if ((iIndex >= 0) 
         && (iIndex < iProdutos)) {
            new ViewEditarProduto(this.viewConsultaProduto, this.produtos.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaProduto, "Selecione um Produto!").setVisible(true);
            this.viewConsultaProduto.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex    = this.viewConsultaProduto.getTable().getSelectedRow();
        int iProdutos = this.produtos.size();
        if ((iIndex >= 0) 
         && (iIndex < iProdutos)) {
            new ViewRemoverProduto(this.viewConsultaProduto, this.produtos.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaProduto, "Selecione um Produto!").setVisible(true);
            this.viewConsultaProduto.getTextFieldPesquisa().requestFocus();
        }
    }
}