package controller.visao.cadastro;

import controller.modelo.gerenciais.ControllerFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoFornecedor;
import modelo.gerenciais.Fornecedor;
import visao.cadastro.ViewCadastroFornecedor;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroFornecedor.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.cadastro.ControllerViewCadastro
 */
public class ControllerViewCadastroFornecedor extends ControllerViewCadastro {
    private final ViewCadastroFornecedor viewCadastroFornecedor;
    private final ControllerFornecedor   controllerFornecedor;
    private final DaoFornecedor          daoFornecedor;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroFornecedor(ViewCadastroFornecedor oView) {
        super(oView);
        this.viewCadastroFornecedor = oView;
        this.controllerFornecedor   = new ControllerFornecedor();
        this.daoFornecedor          = new DaoFornecedor();
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
        String  sNome     = this.viewCadastroFornecedor.getTextFieldNome().getText().trim();
        String  sCnpj     = this.viewCadastroFornecedor.getTextFieldCNPJ().getText().trim();
        String  sTelefone = this.viewCadastroFornecedor.getTextFieldTelefone().getText().trim();
        if (this.checkParameters(sNome, sCnpj) == true) {
            Fornecedor oFornecedor = new Fornecedor(sNome, sCnpj, sTelefone);
            this.daoFornecedor.insert(oFornecedor);
            this.viewCadastroFornecedor.clear();
            new ViewMensagem(this.viewCadastroFornecedor, "Fornecedor Cadastrado com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sNome, String sCnpj) {
        if (this.controllerFornecedor.checkNome(sNome) == false) {
            this.viewCadastroFornecedor.setErro("Nome Invalido!");
            new ViewErro(this.viewCadastroFornecedor, "Nome Invalido!").setVisible(true);
            this.viewCadastroFornecedor.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerFornecedor.nomeIsAvailable(sNome) == false) {
            this.viewCadastroFornecedor.setErro("Nome ja Cadastrado!");
            new ViewErro(this.viewCadastroFornecedor, "Nome ja Cadastrado!").setVisible(true);
            this.viewCadastroFornecedor.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerFornecedor.checkCnpj(sCnpj) == false) {
            this.viewCadastroFornecedor.setErro("CNPJ Invalido!");
            new ViewErro(this.viewCadastroFornecedor, "CNPJ Invalido!").setVisible(true);
            this.viewCadastroFornecedor.getTextFieldCNPJ().requestFocus();
            return false;
        }else if (this.controllerFornecedor.cnpjIsAvailable(sCnpj) == false) {
            this.viewCadastroFornecedor.setErro("CNPJ ja Cadastrado!");
            new ViewErro(this.viewCadastroFornecedor, "CNPJ ja Cadastrado!").setVisible(true);
            this.viewCadastroFornecedor.getTextFieldCNPJ().requestFocus();
            return false;
        }
        return true;
    }
}