package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.gerenciais.DaoFornecedor;
import modelo.gerenciais.Fornecedor;
import visao.mensagens.ViewErro;
import visao.pesquisa.ViewPesquisaFornecedor;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Fornecedores.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   15/01/2016
 */
public class ControllerViewPesquisaFornecedor extends ControllerViewModal {
    private final ViewPesquisaFornecedor viewPesquisaFornecedor;
    private final DaoFornecedor          daoFornecedor;
    private       List<Fornecedor>       fornecedores;

    public ControllerViewPesquisaFornecedor(ViewPesquisaFornecedor oView) {
        super(oView);
        this.viewPesquisaFornecedor = oView;
        this.daoFornecedor          = new DaoFornecedor();
        this.fornecedores           = this.daoFornecedor.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaFornecedor.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaFornecedor.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaFornecedor.getButtonBack())) {
            this.viewPesquisaFornecedor.dispose();
        }
    }

    public void pesquisar() {
        String sFornecedor = this.viewPesquisaFornecedor.getTextFieldPesquisa().getText();
        this.fornecedores  = this.daoFornecedor.findFornecedores(sFornecedor);
        this.viewPesquisaFornecedor.addRows(this.daoFornecedor.getFornecedores(this.fornecedores));
    }
    
    protected void select() {
        int iIndex        = this.viewPesquisaFornecedor.getTable().getSelectedRow();
        int iFornecedores = this.fornecedores.size();
        if ((iIndex >= 0) 
            && (iIndex < iFornecedores)) {
            this.viewPesquisaFornecedor.getViewParent().setFornecedor(this.fornecedores.get(iIndex));
            this.viewPesquisaFornecedor.dispose();
        }else {
            new ViewErro(this.viewPesquisaFornecedor, "Selecione um Fornecedor!").setVisible(true);
            this.viewPesquisaFornecedor.getTextFieldPesquisa().requestFocus();
        }
    }
}