package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import modelo.dao.relacionais.entrada.DaoPedido;
import modelo.relacionais.entrada.ItemPedido;
import modelo.relacionais.entrada.Pedido;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoChegadaPedido;
import visao.pesquisa.ViewPesquisaPedido;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View da Chegada de Pedido.
 * @author Leandro
 * @since  19/01/2016
 */
public class ControllerViewOperacaoChegadaPedido extends ControllerViewModal {
    private final ViewOperacaoChegadaPedido viewOperacaoChegadaPedido;
    private final DaoPedido                 daoPedido;
    private final DaoProduto                daoProduto;
    
    public ControllerViewOperacaoChegadaPedido(ViewOperacaoChegadaPedido oView) {
        super(oView);
        this.viewOperacaoChegadaPedido = oView;
        this.daoPedido                 = new DaoPedido();
        this.daoProduto                = new DaoProduto();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoChegadaPedido.getButtonSearchPedido())) {
            new ViewPesquisaPedido(this.viewOperacaoChegadaPedido).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoChegadaPedido.getButtonConfirmar())) {
            Pedido oPedido = this.viewOperacaoChegadaPedido.getPedido();
            if (oPedido != null) {
                List<ItemPedido> oItensPedido = this.daoPedido.getItensPedido(oPedido);
                for (int i = 0; i < oItensPedido.size(); ++i) {
                    Produto oProduto = oItensPedido.get(i).getProduto();
                            oProduto.setQuantidade(oProduto.getQuantidade() + oItensPedido.get(i).getQuantidade());
                    this.daoProduto.update(oProduto);
                }
                oPedido.setRecebido(true);
                this.daoPedido.update(oPedido);
            }
            new ViewMensagem(this.viewOperacaoChegadaPedido, "Chegada do Pedido registrada com Sucesso!").setVisible(true);
            this.viewOperacaoChegadaPedido.clear();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoChegadaPedido.getButtonVoltar())) {
            this.viewOperacaoChegadaPedido.dispose();
        }
    }
}