package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoFornecedor;
import modelo.gerenciais.Fornecedor;
import visao.consulta.ViewConsultaFornecedor;
import visao.editar.ViewEditarFornecedor;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverFornecedor;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaFornecedor.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaFornecedor extends ControllerViewConsulta {
    private final ViewConsultaFornecedor viewConsultaFornecedor;
    private final DaoFornecedor          daoFornecedor;
    private       List<Fornecedor>       fornecedores;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaFornecedor(ViewConsultaFornecedor oView) {
        super(oView);
        this.viewConsultaFornecedor = oView;
        this.daoFornecedor          = new DaoFornecedor();
        this.fornecedores           = this.daoFornecedor.list();
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
        String sFornecedor = this.viewConsultaFornecedor.getTextFieldPesquisa().getText();
        this.fornecedores  = this.daoFornecedor.findFornecedores(sFornecedor);
        this.viewConsultaFornecedor.addRows(this.daoFornecedor.getFornecedores(this.fornecedores));
    }

    @Override
    protected void edit() {
        int iIndex        = this.viewConsultaFornecedor.getTable().getSelectedRow();
        int iFornecedores = this.fornecedores.size();
        if ((iIndex >= 0) 
         && (iIndex < iFornecedores)) {
            new ViewEditarFornecedor(this.viewConsultaFornecedor, this.fornecedores.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaFornecedor, "Selecione um Fornecedor!").setVisible(true);
            this.viewConsultaFornecedor.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex        = this.viewConsultaFornecedor.getTable().getSelectedRow();
        int iFornecedores = this.fornecedores.size();
        if ((iIndex >= 0) 
         && (iIndex < iFornecedores)) {
            new ViewRemoverFornecedor(this.viewConsultaFornecedor, this.fornecedores.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaFornecedor, "Selecione um Fornecedor!").setVisible(true);
            this.viewConsultaFornecedor.getTextFieldPesquisa().requestFocus();
        }
    }
}