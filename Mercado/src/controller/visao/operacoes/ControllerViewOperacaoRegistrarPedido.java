package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import funct.FunctDate;
import funct.FunctString;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.cadastrais.DaoProduto;
import modelo.dao.relacionais.entrada.DaoItemPedido;
import modelo.dao.relacionais.entrada.DaoPedido;
import modelo.gerenciais.Fornecedor;
import modelo.relacionais.entrada.ItemPedido;
import modelo.relacionais.entrada.Pedido;
import visao.extra.ViewAdicionarProdutoPedido;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoRegistrarPedido;
import visao.pesquisa.ViewPesquisaFornecedor;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View da Chegada de Pedido.
 * @author Vanessa Nakahara
 * @since  18/01/2016
 */
public class ControllerViewOperacaoRegistrarPedido extends ControllerViewModal {
    private final ViewOperacaoRegistrarPedido viewOperacaoRegistrarPedido;
    private final DaoPedido                   daoPedido;
    private final DaoItemPedido               daoItemPedido;
    private final DaoProduto                  daoProduto;

    public ControllerViewOperacaoRegistrarPedido(ViewOperacaoRegistrarPedido oView) {
        super(oView);
        this.viewOperacaoRegistrarPedido = oView;
        this.daoPedido                   = new DaoPedido();
        this.daoItemPedido               = new DaoItemPedido();
        this.daoProduto                  = new DaoProduto();
    }

    private boolean checkParameters(Fornecedor oFornecedor, List<ItemPedido> oItensPedido, String sData) {
        if (oFornecedor == null) {
            new ViewErro(this.viewOperacaoRegistrarPedido, "Selecione um Fornecedor!").setVisible(true);
            return false;
        }else if (oItensPedido.isEmpty()) {
            new ViewErro(this.viewOperacaoRegistrarPedido, "Adicione pelo menos um Item ao Pedido!").setVisible(true);
            return false;
        }else if ((sData.length() != 10) || (new FunctString().checkMask(sData, "0123456789/") == false) || (new FunctString().countChar(sData, '/') != 2)) {
            new ViewErro(this.viewOperacaoRegistrarPedido, "Data Invalida! Digite no formato XX/XX/XXXX!").setVisible(true);
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoRegistrarPedido.getButtonSearchFornecedor())) {
            new ViewPesquisaFornecedor(this.viewOperacaoRegistrarPedido).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoRegistrarPedido.getButtonAdicionarItem())) {
            new ViewAdicionarProdutoPedido(this.viewOperacaoRegistrarPedido).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoRegistrarPedido.getButtonRemoverItem())) {
            int iIndex = this.viewOperacaoRegistrarPedido.getTable().getSelectedRow();
            if (iIndex >= 0) {
                this.viewOperacaoRegistrarPedido.removeItemPedido(iIndex);
            }
        }else if (oActionEvent.getSource().equals(this.viewOperacaoRegistrarPedido.getButtonSave())) {
            Fornecedor       oFornecedor    = this.viewOperacaoRegistrarPedido.getFornecedor();
            List<ItemPedido> oItensPedido   = this.viewOperacaoRegistrarPedido.getItens();
            String           sDataPagamento = this.viewOperacaoRegistrarPedido.getTextFieldDataPagamento().getText().trim();
            if (this.checkParameters(oFornecedor, oItensPedido, sDataPagamento) == true) {
                Pedido oPedido = new Pedido(oFornecedor, null);
                       oPedido.setTotalItens(this.viewOperacaoRegistrarPedido.getQuantidade());
                       oPedido.setValorTotal(this.viewOperacaoRegistrarPedido.getValorTotal());
                       oPedido.setDataPagamento(new FunctDate().createDate(sDataPagamento));
                       this.daoPedido.insert(oPedido);
                       
                for (int i = 0; i < oItensPedido.size(); ++i) {
                    oItensPedido.get(i).setPedido(oPedido);
                    this.daoItemPedido.insert(oItensPedido.get(i));
                }
                new ViewMensagem(this.viewOperacaoRegistrarPedido, "Pedido Registrado com Sucesso!").setVisible(true);
                this.viewOperacaoRegistrarPedido.clear();
            }
        }
    }
    
}