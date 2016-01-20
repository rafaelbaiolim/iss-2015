package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.cadastrais.Cliente;
import modelo.dao.gerenciais.DaoFuncionario;
import modelo.gerenciais.Funcionario;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;
import visao.extra.ViewAdicionarProdutoVenda;
import visao.extra.ViewFinalizarVenda;
import visao.mensagens.ViewErro;
import visao.operacoes.ViewOperacaoEfetuarVenda;
import visao.pesquisa.ViewPesquisaCliente;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Efetuar Venda.
 * @author Hadyne
 * @since  17/01/2016
 */
public class ControllerViewOperacaoEfetuarVenda extends ControllerViewModal {
    private final ViewOperacaoEfetuarVenda viewOperacaoEfetuarVenda;
    private final DaoFuncionario           daoFuncionario;
    private       List<Funcionario>        funcionarios;
   
    public ControllerViewOperacaoEfetuarVenda(ViewOperacaoEfetuarVenda oView) {
        super(oView);
        this.viewOperacaoEfetuarVenda = oView;
        this.daoFuncionario           = new DaoFuncionario();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonSearchCliente())) {
            new ViewPesquisaCliente(this.viewOperacaoEfetuarVenda).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonAdicionarItem())) {
            new ViewAdicionarProdutoVenda(this.viewOperacaoEfetuarVenda).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonRemoverItem())) {
            int iIndex = this.viewOperacaoEfetuarVenda.getTable().getSelectedRow();
            if (iIndex >= 0) {
                this.viewOperacaoEfetuarVenda.removeItemVenda(iIndex);
            }
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonSave())) {
            List<ItemVenda> oItens = this.viewOperacaoEfetuarVenda.getItens();
            Cliente oCliente       = this.viewOperacaoEfetuarVenda.getCliente();
            if (this.checkParameters(oCliente, oItens) == true) {
                int     iNumeroItens   = this.viewOperacaoEfetuarVenda.getQuantidade();
                float   fValorTotal    = this.viewOperacaoEfetuarVenda.getValorTotal();
                Venda   oVenda         = new Venda(oCliente, null, "", iNumeroItens, 0.00f, fValorTotal, 0.00f, 0.00f);
                new ViewFinalizarVenda(this.viewOperacaoEfetuarVenda, oVenda, oItens).setVisible(true);
            }
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonBack())) {
            this.viewOperacaoEfetuarVenda.dispose();
        }
    }
    
    private boolean checkParameters(Cliente oCliente, List<ItemVenda> oItens) {
        if (oCliente == null) {
            new ViewErro(this.viewOperacaoEfetuarVenda, "Selecione um Cliente!").setVisible(true);
            return false;
        }else if (oItens.isEmpty()) {
            new ViewErro(this.viewOperacaoEfetuarVenda, "Adicione pelo menos um Item!").setVisible(true);
            return false;
        }
        return true;
    }
}