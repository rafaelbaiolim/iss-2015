package controller.visao.extra;

import controller.Controller;
import funct.FunctDate;
import funct.FunctString;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import modelo.dao.relacionais.saida.DaoItemVenda;
import modelo.dao.relacionais.saida.DaoVenda;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;
import visao.extra.ViewFinalizarVenda;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewFinalizarVenda.
 * @author  Hadyne
 * @version 1.0
 * @since   18/01/2015
 * @see     controller.Controller
 */
public class ControllerViewFinalizarVenda extends Controller {
    private final ViewFinalizarVenda viewFinalizarVenda;
    private final FunctString        functString;
    private final DaoVenda           daoVenda;
    private final DaoItemVenda       daoItemVenda;
    private final DaoProduto         daoProduto;
    
    public ControllerViewFinalizarVenda(ViewFinalizarVenda oView) {
        this.viewFinalizarVenda = oView;
        this.functString        = new FunctString();
        this.daoVenda           = new DaoVenda();
        this.daoItemVenda       = new DaoItemVenda();
        this.daoProduto         = new DaoProduto();
    }
    
    private boolean checkParameters(String sPrecoPago, String sPrecoDesconto, String sDataEncomenda) {
        if (this.viewFinalizarVenda.getComboBoxFormaPagamento().getSelectedIndex() == 0) {
            new ViewErro(this.viewFinalizarVenda, "Selecione uma Forma de Pagamento!").setVisible(true);
            return false;
        }else if ((sPrecoPago.length() == 0) || (this.functString.checkMask(sPrecoPago, "0123456789.") == false)) {
            new ViewErro(this.viewFinalizarVenda, "Valor Invalido - Digite no Formato X.XX!").setVisible(true);
            this.viewFinalizarVenda.getTextFieldValorPago().requestFocus();
            return false;
        }else if (sPrecoPago.equals("0") == true) {
            new ViewErro(this.viewFinalizarVenda, "Digite um Valor Valido!").setVisible(true);
            this.viewFinalizarVenda.getTextFieldValorPago().requestFocus();
            return false;
        }else if ((sPrecoDesconto.length() == 0) || (this.functString.checkMask(sPrecoDesconto, "0123456789.") == false)) {
            new ViewErro(this.viewFinalizarVenda, "Valor Invalido - Digite no Formato X.XX!").setVisible(true);
            this.viewFinalizarVenda.getTextFieldValorDesconto().requestFocus();
            return false;
        }else if ((this.viewFinalizarVenda.getCheckBoxEncomenda().isSelected()) 
                && (sDataEncomenda.length() == 10)
                && (this.functString.checkMask(sDataEncomenda, "0123456789/") == false)) {
            new ViewErro(this.viewFinalizarVenda, "Data Encomenda Invalida").setVisible(true);
            this.viewFinalizarVenda.getTextFieldDataEncomenda().requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkValores(float fValorTotal, float fValorPago, float fValorDesconto) {
        float fValorFinal = fValorTotal - fValorDesconto;
        if (fValorDesconto > fValorTotal) {
            new ViewErro(this.viewFinalizarVenda, "Valor Desconto maior que Valor Total").setVisible(true);
            this.viewFinalizarVenda.getTextFieldValorDesconto().requestFocus();
            return false;
        }else if (fValorFinal > fValorPago) {
            new ViewErro(this.viewFinalizarVenda, "Valor Total maior que Valor Pago").setVisible(true);
            this.viewFinalizarVenda.getTextFieldValorPago().requestFocus();
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewFinalizarVenda.getButtonFinalizar()) == true) {
            Venda           oVenda          = this.viewFinalizarVenda.getVenda();
            List<ItemVenda> oItens          = this.viewFinalizarVenda.getItensVenda();
            String          sFormaPagamento = this.viewFinalizarVenda.getComboBoxFormaPagamento().getSelectedItem().toString();
            String          sValorPago      = this.viewFinalizarVenda.getTextFieldValorPago().getText().trim();
            String          sValorDesconto  = this.viewFinalizarVenda.getTextFieldValorDesconto().getText().trim();
            String          sDataEncomenda  = this.viewFinalizarVenda.getTextFieldDataEncomenda().getText().trim();
            boolean         bEncomenda      = this.viewFinalizarVenda.getCheckBoxEncomenda().isSelected();
            Date            dEncomenda      = new FunctDate().createDate(sDataEncomenda);
            if (this.checkParameters(sValorPago, sValorDesconto, sDataEncomenda) == true) {
                float fValorPago     = Float.parseFloat(sValorPago);
                float fValorDesconto = Float.parseFloat(sValorDesconto);
                float fValorFinal    = oVenda.getValorTotal() - fValorDesconto;
                float fValorTroco    = fValorPago - fValorFinal;
                if (this.checkValores(oVenda.getValorTotal(), fValorPago, fValorDesconto) == true) {
                    this.viewFinalizarVenda.getTextFieldValorDesconto().setText(Float.toString(fValorTroco));
                    oVenda.setFormaPagamento(sFormaPagamento);
                    oVenda.setValorPago(fValorPago);
                    oVenda.setValorDesconto(fValorDesconto);
                    oVenda.setValorTroco(fValorTroco);
                    oVenda.setEncomenda(bEncomenda);
                    oVenda.setDataEntrega(dEncomenda);
                    oVenda.setEntrega(false);
                    this.daoVenda.insert(oVenda);
                    
                    for (int i = 0; i < oItens.size(); ++i) {
                        oItens.get(i).setVenda(oVenda);
                        this.daoItemVenda.insert(oItens.get(i));
                        Produto oProduto = oItens.get(i).getProduto();
                                oProduto.setQuantidade(oProduto.getQuantidade() - oItens.get(i).getQuantidade());
                        this.daoProduto.update(oProduto);
                    }
                    
                    new ViewMensagem(this.viewFinalizarVenda, "Venda realizada com Sucesso!").setVisible(true);
                    this.viewFinalizarVenda.dispose();
                    this.viewFinalizarVenda.getViewParent().clear();
                }
            }
        }else if (oActionEvent.getSource().equals(this.viewFinalizarVenda.getButtonCancelar()) == true) {
            this.viewFinalizarVenda.dispose();
        }
    }
}