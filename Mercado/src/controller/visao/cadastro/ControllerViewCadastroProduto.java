package controller.visao.cadastro;

import controller.modelo.cadastrais.ControllerProduto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import visao.cadastro.ViewCadastroProduto;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroProduto.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   20/10/2015
 * @see     visao.cadastro.ControllerViewCadastro
 */
public class ControllerViewCadastroProduto extends ControllerViewCadastro {
    private final ViewCadastroProduto viewCadastroProduto;
    private final ControllerProduto   controllerProduto;
    private final DaoProduto          daoProduto;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroProduto(ViewCadastroProduto oView) {
        super(oView);
        this.viewCadastroProduto = oView;
        this.controllerProduto   = new ControllerProduto();
        this.daoProduto          = new DaoProduto();
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
    public void cadastro() {
        String sDescricao     = this.viewCadastroProduto.getTextFieldDescricao().getText().toUpperCase().trim();
        String sMarca         = this.viewCadastroProduto.getTextFieldMarca().getText().toUpperCase().trim();
        String sPeso          = this.viewCadastroProduto.getTextFieldPeso().getText().trim();
        String sQuantidade    = this.viewCadastroProduto.getTextFieldQuantidade().getText().toUpperCase().trim();
        String sPrecoUnitario = this.viewCadastroProduto.getTextFieldPrecoUnitario().getText().toUpperCase().trim();
        if (this.checkParameters(sDescricao, sMarca, sQuantidade, sPrecoUnitario)== true) {
            int     iQuantidade    = Integer.parseInt(sQuantidade);
            float   fPrecoUnitario = Float.parseFloat(sPrecoUnitario);
            Produto oProduto       = new Produto(sDescricao, sMarca, sPeso, iQuantidade, fPrecoUnitario);
            this.daoProduto.insert(oProduto);
            this.viewCadastroProduto.clear();
            new ViewMensagem(this.viewCadastroProduto, "Produto Cadastrado com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sDescricao, String sMarca, String sQuantidade, String sPrecoUnitario) {
        if (this.controllerProduto.checkDescricao(sDescricao) == false) {
            this.viewCadastroProduto.setErro("Descricao Inválida!");
            new ViewErro(this.viewCadastroProduto, "Descricao Inválida!").setVisible(true);
            this.viewCadastroProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerProduto.checkMarca(sMarca) == false) {
            this.viewCadastroProduto.setErro("Marca Inválida!");
            new ViewErro(this.viewCadastroProduto, "Marca Inválida!").setVisible(true);
            this.viewCadastroProduto.getTextFieldMarca().requestFocus();
            return false;
        }else if (this.controllerProduto.produtoIsAvailable(sDescricao, sMarca) == false) {
            this.viewCadastroProduto.setErro("Produto já Cadastrado!");
            new ViewErro(this.viewCadastroProduto, "Produto já Cadastrado!").setVisible(true);
            this.viewCadastroProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerProduto.checkQuantidade(sQuantidade) == false) {
            this.viewCadastroProduto.setErro("Quantidade Inválida!");
            new ViewErro(this.viewCadastroProduto, "Quantidade Inválida!").setVisible(true);
            this.viewCadastroProduto.getTextFieldQuantidade().requestFocus();
            return false;
        }else if (this.controllerProduto.checkPrecoUnitario(sPrecoUnitario) == false) {
            this.viewCadastroProduto.setErro("Preco Unitario Inválido!");
            new ViewErro(this.viewCadastroProduto, "Preco Unitario Inválido!").setVisible(true);
            this.viewCadastroProduto.getTextFieldPrecoUnitario().requestFocus();
            return false;
        }
        return true;
    }
}