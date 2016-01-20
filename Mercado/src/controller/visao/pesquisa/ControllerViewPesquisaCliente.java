package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;
import visao.mensagens.ViewErro;
import visao.operacoes.ViewOperacaoEfetuarVenda;
import visao.operacoes.ViewOperacaoRealizarNotificacao;
import visao.pesquisa.ViewPesquisaCliente;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Clientes.
 * @author  Leandro
 * @version 1.0
 * @since   15/01/2016
 */
public class ControllerViewPesquisaCliente extends ControllerViewModal {
    private final ViewPesquisaCliente viewPesquisaCliente;
    private final DaoCliente          daoCliente;
    private       List<Cliente>       clientes;

    public ControllerViewPesquisaCliente(ViewPesquisaCliente oView) {
        super(oView);
        this.viewPesquisaCliente = oView;
        this.daoCliente          = new DaoCliente();
        this.clientes            = this.daoCliente.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaCliente.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaCliente.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaCliente.getButtonBack())) {
            this.viewPesquisaCliente.dispose();
        }
    }

    public void pesquisar() {
        String sCliente = this.viewPesquisaCliente.getTextFieldPesquisa().getText();
        this.clientes   = this.daoCliente.findClientes(sCliente);
        this.viewPesquisaCliente.addRows(this.daoCliente.getClientes(this.clientes));
    }
    
    protected void select() {
        int iIndex        = this.viewPesquisaCliente.getTable().getSelectedRow();
        int iFornecedores = this.clientes.size();
        if ((iIndex >= 0) 
            && (iIndex < iFornecedores)) {
            if (this.viewPesquisaCliente.getViewParent() instanceof ViewOperacaoEfetuarVenda) {
                ((ViewOperacaoEfetuarVenda) this.viewPesquisaCliente.getViewParent()).setCliente(this.clientes.get(iIndex));
            }else if (this.viewPesquisaCliente.getViewParent() instanceof ViewOperacaoRealizarNotificacao) {
                ((ViewOperacaoRealizarNotificacao) this.viewPesquisaCliente.getViewParent()).addCliente(this.clientes.get(iIndex));
            }
            this.viewPesquisaCliente.dispose();
        }else {
            new ViewErro(this.viewPesquisaCliente, "Selecione um Cliente!").setVisible(true);
            this.viewPesquisaCliente.getTextFieldPesquisa().requestFocus();
        }
    }
}