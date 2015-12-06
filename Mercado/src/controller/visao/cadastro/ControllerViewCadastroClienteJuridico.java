package controller.visao.cadastro;

import controller.modelo.cadastrais.ControllerCliente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.ClienteJuridico;
import modelo.complementares.Cidade;
import modelo.dao.cadastrais.DaoCliente;
import modelo.dao.complementares.DaoCidade;
import visao.cadastro.ViewCadastroClienteJuridico;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroClienteJuridico.
 * @author  Hadyne
 * @version 1.0
 * @since   20/11/2015
 * @see     visao.cadastro.ControllerViewCadastro
 * @see     controller.modelo.cadastrais.ControllerCliente
 */
public class ControllerViewCadastroClienteJuridico extends ControllerViewCadastro {
    private final ViewCadastroClienteJuridico viewCadastroClienteJuridico;
    private final ControllerCliente           controllerCliente;
    private final DaoCliente                  daoCliente;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroClienteJuridico(ViewCadastroClienteJuridico oView) {
        super(oView);
        this.viewCadastroClienteJuridico = oView;
        this.controllerCliente           = new ControllerCliente();
        this.daoCliente                  = new DaoCliente();
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
        String sCnpj        = this.viewCadastroClienteJuridico.getTextFieldCnpj().getText().toUpperCase().trim();
        String sRazaoSocial = this.viewCadastroClienteJuridico.getTextFieldRazaoSocial().getText().toUpperCase().trim();
        String sNome        = this.viewCadastroClienteJuridico.getTextFieldNome().getText().toUpperCase().trim();
        String sResponsavel = this.viewCadastroClienteJuridico.getTextFieldResponsavel().getText().toUpperCase().trim();
        String sEndereco    = this.viewCadastroClienteJuridico.getTextFieldEndereco().getText().toUpperCase().trim();
        String sCidade      = this.viewCadastroClienteJuridico.getComboBoxCidade().getSelectedItem().toString();
        String sTelefone    = this.viewCadastroClienteJuridico.getTextFieldTelefone().getText().toUpperCase().trim();
        String sCelular     = this.viewCadastroClienteJuridico.getTextFieldCelular().getText().toUpperCase().trim();
        String sEmail       = this.viewCadastroClienteJuridico.getTextFieldEmail().getText().trim();
        if (this.checkParameters(sCnpj, sNome, sResponsavel, sTelefone) == true) {
            Cidade          oCidade        = new DaoCidade().findCidadeByNome(sCidade);
            ClienteJuridico oClienteJuridico = new ClienteJuridico(sCnpj, sNome, sTelefone, sCelular, sEmail, sEndereco, oCidade, sRazaoSocial, sResponsavel);
            this.daoCliente.insert(oClienteJuridico);
            this.viewCadastroClienteJuridico.clear();
            new ViewMensagem(this.viewCadastroClienteJuridico, "Cliente Cadastrado com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sCnpj, String sNome, String sResponsavel, String sTelefone) {
        if (this.controllerCliente.checkCnpj(sCnpj) == false) {
            this.viewCadastroClienteJuridico.setErro("CNPJ Inválido!");
            new ViewErro(this.viewCadastroClienteJuridico, "CNPJ Inválido!").setVisible(true);
            this.viewCadastroClienteJuridico.getTextFieldCnpj().requestFocus();
            return false;
        }else if (this.controllerCliente.documentoIsAvailable(sCnpj) == false) {
            this.viewCadastroClienteJuridico.setErro("CNPJ já Cadastrado!");
            new ViewErro(this.viewCadastroClienteJuridico, "CNPJ já Cadastrado!").setVisible(true);
            this.viewCadastroClienteJuridico.getTextFieldCnpj().requestFocus();
            return false;
        }else if (this.controllerCliente.checkNome(sNome) == false) {
            this.viewCadastroClienteJuridico.setErro("Nome Inválido!");
            new ViewErro(this.viewCadastroClienteJuridico, "Nome Inválido!").setVisible(true);
            this.viewCadastroClienteJuridico.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerCliente.checkResponsavel(sResponsavel) == false) {
            this.viewCadastroClienteJuridico.setErro("Responsável Inválido!");
            new ViewErro(this.viewCadastroClienteJuridico, "Responsável Inválido!").setVisible(true);
            this.viewCadastroClienteJuridico.getTextFieldResponsavel().requestFocus();
            return false;
        }else if (this.viewCadastroClienteJuridico.getComboBoxCidade().getSelectedIndex() == 0) {
            this.viewCadastroClienteJuridico.setErro("Selecione uma Cidade!");
            new ViewErro(this.viewCadastroClienteJuridico, "Selecione uma Cidade!").setVisible(true);
            this.viewCadastroClienteJuridico.getComboBoxCidade().requestFocus();
            return false;
        }else if (this.controllerCliente.checkTelefone(sTelefone) == false) {
            this.viewCadastroClienteJuridico.setErro("Telefone Inválido!");
            new ViewErro(this.viewCadastroClienteJuridico, "Telefone Inválido!").setVisible(true);
            this.viewCadastroClienteJuridico.getTextFieldTelefone().requestFocus();
            return false;
        }
        return true;
    }
}