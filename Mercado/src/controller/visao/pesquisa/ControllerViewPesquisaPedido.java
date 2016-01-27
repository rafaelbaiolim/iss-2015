package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.relacionais.entrada.DaoPedido;
import modelo.relacionais.entrada.Pedido;
import visao.mensagens.ViewErro;
import visao.operacoes.ViewOperacaoChegadaPedido;
import visao.pesquisa.ViewPesquisaPedido;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Pedidos.
 * @author  Vanessa
 * @version 1.0
 * @since   15/01/2016
 */
public class ControllerViewPesquisaPedido extends ControllerViewModal {
    private final ViewPesquisaPedido viewPesquisaPedido;
    private final DaoPedido          daoPedido;
    private       List<Pedido>       pedidos;

    public ControllerViewPesquisaPedido(ViewPesquisaPedido oView) {
        super(oView);
        this.viewPesquisaPedido = oView;
        this.daoPedido          = new DaoPedido();
        this.pedidos            = this.daoPedido.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaPedido.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaPedido.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaPedido.getButtonBack())) {
            this.viewPesquisaPedido.dispose();
        }
    }

    public void pesquisar() {
        String sProduto = this.viewPesquisaPedido.getTextFieldPesquisa().getText();
        this.pedidos    = this.daoPedido.getPedidosNaoEntregues();
        this.viewPesquisaPedido.addRows(this.daoPedido.getPedidos(this.pedidos));
    }
    
    protected void select() {
        int iIndex        = this.viewPesquisaPedido.getTable().getSelectedRow();
        int iFornecedores = this.pedidos.size();
        if ((iIndex >= 0) 
            && (iIndex < iFornecedores)) {
            if (this.viewPesquisaPedido.getParent() instanceof ViewOperacaoChegadaPedido) {
                ((ViewOperacaoChegadaPedido) this.viewPesquisaPedido.getViewParent()).setPedido(this.pedidos.get(iIndex));
            }
            this.viewPesquisaPedido.dispose();
        }else {
            new ViewErro(this.viewPesquisaPedido, "Selecione um Fornecedor!").setVisible(true);
            this.viewPesquisaPedido.getTextFieldPesquisa().requestFocus();
        }
    }
}