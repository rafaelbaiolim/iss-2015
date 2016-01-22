package controller.visao.extra;

import controller.Controller;
import funct.FunctString;
import java.awt.event.ActionEvent;
import modelo.cadastrais.Produto;
import modelo.relacionais.entrada.ItemPedido;
import visao.extra.ViewAdicionarProdutoPedido;
import visao.mensagens.ViewErro;
import visao.pesquisa.ViewPesquisaProduto;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewAdicionarProduto.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   13/01/2015
 * @see     controller.Controller
 */
public class ControllerViewAdicionarProdutoPedido extends Controller {
    private final ViewAdicionarProdutoPedido viewAdicionarProdutoPedido;
    private final FunctString                functString;
    
    public ControllerViewAdicionarProdutoPedido(ViewAdicionarProdutoPedido oView) {
        this.viewAdicionarProdutoPedido = oView;
        this.functString                = new FunctString();
    }
    
    private boolean checkParameters(String sQuantidade, String sPrecoUnitario) {
        if (this.viewAdicionarProdutoPedido.getProduto() == null) {
            new ViewErro(this.viewAdicionarProdutoPedido, "Selecione um Produto!").setVisible(true);
            return false;
        }else if ((sQuantidade.length() == 0) || (this.functString.checkMask(sQuantidade, "0123456789") == false)) {
            new ViewErro(this.viewAdicionarProdutoPedido, "Quantidade Invalida!").setVisible(true);
            this.viewAdicionarProdutoPedido.getTextFieldQuantidade().requestFocus();
            return false;
        }else if (sQuantidade.equals("0") == true) {
            new ViewErro(this.viewAdicionarProdutoPedido, "Digite uma Quantidade Valida!").setVisible(true);
            this.viewAdicionarProdutoPedido.getTextFieldQuantidade().requestFocus();
            return false;
        }else if ((sPrecoUnitario.length() == 0) || (this.functString.checkMask(sPrecoUnitario, "0123456789.") == false)) {
            new ViewErro(this.viewAdicionarProdutoPedido, "Preco Invalido! Digite X.XX").setVisible(true);
            this.viewAdicionarProdutoPedido.getTextFieldPrecoUnitarioProduto().requestFocus();
            return false;
        }else if (sPrecoUnitario.equals("0.00") == true) {
            new ViewErro(this.viewAdicionarProdutoPedido, "Preco Invalido!").setVisible(true);
            this.viewAdicionarProdutoPedido.getTextFieldPrecoUnitarioProduto().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewAdicionarProdutoPedido.getButtonSearchProduto()) == true) {
            new ViewPesquisaProduto(this.viewAdicionarProdutoPedido).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewAdicionarProdutoPedido.getButtonAdicionar()) == true) {
            Produto oProduto       = this.viewAdicionarProdutoPedido.getProduto();
            String  sQuantidade    = this.viewAdicionarProdutoPedido.getTextFieldQuantidade().getText().trim();
            String  sPrecoUnitario = this.viewAdicionarProdutoPedido.getTextFieldPrecoUnitarioProduto().getText().trim();
            if (this.checkParameters(sQuantidade, sPrecoUnitario)) {
                int   iQuantidade      = Integer.parseInt(sQuantidade);
                float fPrecoUnitario   = Float.parseFloat(sPrecoUnitario);
                ItemPedido oItemPedido = new ItemPedido(null, oProduto, iQuantidade, fPrecoUnitario);
                this.viewAdicionarProdutoPedido.getViewParent().addItemPedido(oItemPedido);
                this.viewAdicionarProdutoPedido.dispose();
            }
        }else if (oActionEvent.getSource().equals(this.viewAdicionarProdutoPedido.getButtonBack()) == true) {
            this.viewAdicionarProdutoPedido.dispose();
        }
    }    
}