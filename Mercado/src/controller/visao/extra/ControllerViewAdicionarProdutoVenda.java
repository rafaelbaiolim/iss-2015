package controller.visao.extra;

import controller.Controller;
import funct.FunctString;
import java.awt.event.ActionEvent;
import modelo.cadastrais.Produto;
import modelo.relacionais.saida.ItemVenda;
import visao.extra.ViewAdicionarProdutoVenda;
import visao.mensagens.ViewErro;
import visao.pesquisa.ViewPesquisaProduto;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewAdicionarProdutoVenda.
 * @author  Hadyne
 * @version 1.0
 * @since   13/01/2015
 * @see     controller.Controller
 */
public class ControllerViewAdicionarProdutoVenda extends Controller {
    private final ViewAdicionarProdutoVenda viewAdicionarProdutoVenda;
    private final FunctString               functString;
    
    public ControllerViewAdicionarProdutoVenda(ViewAdicionarProdutoVenda oView) {
        this.viewAdicionarProdutoVenda = oView;
        this.functString               = new FunctString();
    }
    
    private boolean checkParameters(String sQuantidade, String sPrecoUnitario) {
        if (this.viewAdicionarProdutoVenda.getProduto() == null) {
            new ViewErro(this.viewAdicionarProdutoVenda, "Selecione um Produto!").setVisible(true);
            return false;
        }else if ((sQuantidade.length() == 0) || (this.functString.checkMask(sQuantidade, "0123456789") == false)) {
            new ViewErro(this.viewAdicionarProdutoVenda, "Quantidade Invalida!").setVisible(true);
            this.viewAdicionarProdutoVenda.getTextFieldQuantidade().requestFocus();
            return false;
        }else if (sQuantidade.equals("0") == true) {
            new ViewErro(this.viewAdicionarProdutoVenda, "Digite uma Quantidade Valida!").setVisible(true);
            this.viewAdicionarProdutoVenda.getTextFieldQuantidade().requestFocus();
            return false;
        }else if ((sPrecoUnitario.length() == 0) || (this.functString.checkMask(sPrecoUnitario, "0123456789.") == false)) {
            new ViewErro(this.viewAdicionarProdutoVenda, "Preco Invalido! Digite X.XX").setVisible(true);
            this.viewAdicionarProdutoVenda.getTextFieldPrecoUnitarioProduto().requestFocus();
            return false;
        }else if (sPrecoUnitario.equals("0.00") == true) {
            new ViewErro(this.viewAdicionarProdutoVenda, "Preco Invalido!").setVisible(true);
            this.viewAdicionarProdutoVenda.getTextFieldPrecoUnitarioProduto().requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewAdicionarProdutoVenda.getButtonSearchProduto()) == true) {
            new ViewPesquisaProduto(this.viewAdicionarProdutoVenda).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewAdicionarProdutoVenda.getButtonAdicionar()) == true) {
            Produto oProduto       = this.viewAdicionarProdutoVenda.getProduto();
            String  sQuantidade    = this.viewAdicionarProdutoVenda.getTextFieldQuantidade().getText().trim();
            String  sPrecoUnitario = this.viewAdicionarProdutoVenda.getTextFieldPrecoUnitarioProduto().getText().trim();
            if (this.checkParameters(sQuantidade, sPrecoUnitario)) {
                int   iQuantidade    = Integer.parseInt(sQuantidade);
                float fPrecoUnitario = Float.parseFloat(sPrecoUnitario);
                ItemVenda oItemVenda = new ItemVenda(null, oProduto, iQuantidade, fPrecoUnitario);
                if ((oProduto.getQuantidade() >= iQuantidade) 
                        && (this.viewAdicionarProdutoVenda.getViewParent().checkQuantidade(oItemVenda))) {
                    this.viewAdicionarProdutoVenda.getViewParent().addItemVenda(oItemVenda);
                    this.viewAdicionarProdutoVenda.dispose();
                }else {
                    new ViewErro(this.viewAdicionarProdutoVenda, "Quantidade Solicitada Maior que o Estoque!").setVisible(true);
                    this.viewAdicionarProdutoVenda.getTextFieldQuantidade().requestFocus();
                }
            }
        }else if (oActionEvent.getSource().equals(this.viewAdicionarProdutoVenda.getButtonBack()) == true) {
            this.viewAdicionarProdutoVenda.dispose();
        }
    }    
}