package controller.visao.editar;

import controller.modelo.cadastrais.ControllerProduto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import visao.editar.ViewEditarProduto;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarProduto.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   19/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarProduto extends ControllerViewEditar {
    private final ViewEditarProduto viewEditarProduto;
    private final ControllerProduto controllerProduto;
    private final DaoProduto        daoProduto;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarProduto(ViewEditarProduto oView) {
        super(oView);
        this.viewEditarProduto = oView;
        this.controllerProduto = new ControllerProduto();
        this.daoProduto        = new DaoProduto();
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
    protected void save() {
        String sDescricao     = this.viewEditarProduto.getTextFieldDescricao().getText().toUpperCase().trim();
        String sMarca         = this.viewEditarProduto.getTextFieldMarca().getText().toUpperCase().trim();
        String sPeso          = this.viewEditarProduto.getTextFieldPeso().getText().trim();
        String sQuantidade    = this.viewEditarProduto.getTextFieldQuantidade().getText().toUpperCase().trim();
        String sPrecoUnitario = this.viewEditarProduto.getTextFieldPrecoUnitario().getText().toUpperCase().trim();
        if (this.checkParameters(sDescricao, sMarca, sQuantidade, sPrecoUnitario)== true) {
            int     iQuantidade    = Integer.parseInt(sQuantidade);
            float   fPrecoUnitario = Float.parseFloat(sPrecoUnitario);
            Produto oProduto       = this.viewEditarProduto.getProduto();
                    oProduto.setDescricao(sDescricao);
                    oProduto.setMarca(sMarca);
                    oProduto.setPeso(sPeso);
                    oProduto.setQuantidade(iQuantidade);
                    oProduto.setPrecoUnitario(fPrecoUnitario);
            this.daoProduto.update(oProduto);
            new ViewMensagem(this.viewEditarProduto, "Produto Atualizado com Sucesso!").setVisible(true);
            this.viewEditarProduto.dispose();
            this.viewEditarProduto.getViewConsultaProduto().clear();
        }
    }
    
    private boolean checkParameters(String sDescricao, String sMarca, String sQuantidade, String sPrecoUnitario) {
        if (this.controllerProduto.checkDescricao(sDescricao) == false) {
            new ViewErro(this.viewEditarProduto, "Descricao Inválida!").setVisible(true);
            this.viewEditarProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerProduto.checkMarca(sMarca) == false) {
            new ViewErro(this.viewEditarProduto, "Marca Inválida!").setVisible(true);
            this.viewEditarProduto.getTextFieldMarca().requestFocus();
            return false;
        }else if (this.controllerProduto.checkQuantidade(sQuantidade) == false) {
            new ViewErro(this.viewEditarProduto, "Quantidade Inválida!").setVisible(true);
            this.viewEditarProduto.getTextFieldQuantidade().requestFocus();
            return false;
        }else if (this.controllerProduto.checkPrecoUnitario(sPrecoUnitario) == false) {
            new ViewErro(this.viewEditarProduto, "Preco Unitario Inválido!").setVisible(true);
            this.viewEditarProduto.getTextFieldPrecoUnitario().requestFocus();
            return false;
        }else if (this.controllerProduto.checkUpdate(sDescricao, sMarca, this.viewEditarProduto.getProduto().getId()) == false) {
            new ViewErro(this.viewEditarProduto, "Produto já Cadastrado!").setVisible(true);
            this.viewEditarProduto.getTextFieldDescricao().requestFocus();
            return false;
        }
        return true;
    }
}