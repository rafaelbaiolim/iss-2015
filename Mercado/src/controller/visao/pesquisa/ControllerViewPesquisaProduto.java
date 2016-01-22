package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import visao.extra.ViewAdicionarProdutoPedido;
import visao.extra.ViewAdicionarProdutoVenda;
import visao.mensagens.ViewErro;
import visao.pesquisa.ViewPesquisaProduto;

/**
 * Classe responsavel por definir o controlador de Pesquisa de Produtos.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   16/01/2016
 */
public class ControllerViewPesquisaProduto extends ControllerViewModal {
    private final ViewPesquisaProduto viewPesquisaProduto;
    private final DaoProduto          daoProduto;
    private       List<Produto>       produtos;

    public ControllerViewPesquisaProduto(ViewPesquisaProduto oView) {
        super(oView);
        this.viewPesquisaProduto = oView;
        this.daoProduto          = new DaoProduto();
        this.produtos            = this.daoProduto.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaProduto.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaProduto.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaProduto.getButtonBack())) {
            this.viewPesquisaProduto.dispose();
        }
    }

    public void pesquisar() {
        String sProduto = this.viewPesquisaProduto.getTextFieldPesquisa().getText();
        this.produtos  = this.daoProduto.findProdutos(sProduto);
        this.viewPesquisaProduto.addRows(this.daoProduto.getProdutos(this.produtos));
    }
    
    protected void select() {
        int iIndex        = this.viewPesquisaProduto.getTable().getSelectedRow();
        int iFornecedores = this.produtos.size();
        if ((iIndex >= 0) 
            && (iIndex < iFornecedores)) {
            if (this.viewPesquisaProduto.getParent() instanceof ViewAdicionarProdutoPedido) {
                ((ViewAdicionarProdutoPedido) this.viewPesquisaProduto.getViewParent()).setProduto(this.produtos.get(iIndex));
            }else if (this.viewPesquisaProduto.getParent() instanceof ViewAdicionarProdutoVenda) {
                ((ViewAdicionarProdutoVenda) this.viewPesquisaProduto.getViewParent()).setProduto(this.produtos.get(iIndex));
            }
            this.viewPesquisaProduto.dispose();
        }else {
            new ViewErro(this.viewPesquisaProduto, "Selecione um Fornecedor!").setVisible(true);
            this.viewPesquisaProduto.getTextFieldPesquisa().requestFocus();
        }
    }
}