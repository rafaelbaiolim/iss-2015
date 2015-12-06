package controller.visao.editar;

import controller.modelo.gerenciais.ControllerFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoFornecedor;
import modelo.gerenciais.Fornecedor;
import visao.editar.ViewEditarFornecedor;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarFornecedor.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   19/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarFornecedor extends ControllerViewEditar {
    private final ViewEditarFornecedor viewEditarFornecedor;
    private final ControllerFornecedor controllerFornecedor;
    private final DaoFornecedor        daoFornecedor;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarFornecedor(ViewEditarFornecedor oView) {
        super(oView);
        this.viewEditarFornecedor = oView;
        this.controllerFornecedor = new ControllerFornecedor();
        this.daoFornecedor        = new DaoFornecedor();
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
        String  sNome     = this.viewEditarFornecedor.getTextFieldNome().getText().trim();
        String  sCnpj     = this.viewEditarFornecedor.getTextFieldCNPJ().getText().trim();
        String  sTelefone = this.viewEditarFornecedor.getTextFieldTelefone().getText().trim();
        if (this.checkParameters(sNome, sCnpj) == true) {
            Fornecedor oFornecedor = this.viewEditarFornecedor.getFornecedor();
                       oFornecedor.setNome(sNome);
                       oFornecedor.setCnpj(sCnpj);
                       oFornecedor.setTelefone(sTelefone);
            this.daoFornecedor.update(oFornecedor);
            new ViewMensagem(this.viewEditarFornecedor, "Fornecedor Atualizado com Sucesso!").setVisible(true);
            this.viewEditarFornecedor.dispose();
            this.viewEditarFornecedor.getViewConsultaFornecedor().clear();
        }
    }
    
    private boolean checkParameters(String sNome, String sCnpj) {
        if (this.controllerFornecedor.checkNome(sNome) == false) {
            new ViewErro(this.viewEditarFornecedor, "Nome Inválido!").setVisible(true);
            this.viewEditarFornecedor.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerFornecedor.checkCnpj(sCnpj) == false) {
            new ViewErro(this.viewEditarFornecedor, "CNPJ Inválido!").setVisible(true);
            this.viewEditarFornecedor.getTextFieldCNPJ().requestFocus();
            return false;
        }else if (this.controllerFornecedor.checkUpdate(sCnpj, sNome, this.viewEditarFornecedor.getFornecedor().getId()) == false) {
            new ViewErro(this.viewEditarFornecedor, "Fornecedor já Cadastrado!").setVisible(true);
            this.viewEditarFornecedor.getTextFieldNome().requestFocus();
            return false;
        }
        return true;
    }
}