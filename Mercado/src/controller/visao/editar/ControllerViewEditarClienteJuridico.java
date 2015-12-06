package controller.visao.editar;

import controller.modelo.cadastrais.ControllerCliente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.ClienteJuridico;
import modelo.complementares.Cidade;
import modelo.dao.cadastrais.DaoCliente;
import modelo.dao.complementares.DaoCidade;
import visao.editar.ViewEditarClienteJuridico;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarClienteJuridico.
 * @author  Hadyne
 * @version 1.0
 * @since   20/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 * @see     controller.modelo.cadastrais.ControllerCliente
 */
public class ControllerViewEditarClienteJuridico extends ControllerViewEditar {
    private final ViewEditarClienteJuridico viewEditarClienteJuridico;
    private final ControllerCliente         controllerCliente;
    private final DaoCliente                daoCliente;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewEditarClienteJuridico(ViewEditarClienteJuridico oView) {
        super(oView);
        this.viewEditarClienteJuridico = oView;
        this.controllerCliente         = new ControllerCliente();
        this.daoCliente                = new DaoCliente();
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
    public void save() {
        String sCnpj        = this.viewEditarClienteJuridico.getTextFieldCnpj().getText().toUpperCase().trim();
        String sRazaoSocial = this.viewEditarClienteJuridico.getTextFieldRazaoSocial().getText().toUpperCase().trim();
        String sNome        = this.viewEditarClienteJuridico.getTextFieldNome().getText().toUpperCase().trim();
        String sResponsavel = this.viewEditarClienteJuridico.getTextFieldResponsavel().getText().toUpperCase().trim();
        String sEndereco    = this.viewEditarClienteJuridico.getTextFieldEndereco().getText().toUpperCase().trim();
        String sCidade      = this.viewEditarClienteJuridico.getComboBoxCidade().getSelectedItem().toString();
        String sTelefone    = this.viewEditarClienteJuridico.getTextFieldTelefone().getText().toUpperCase().trim();
        String sCelular     = this.viewEditarClienteJuridico.getTextFieldCelular().getText().toUpperCase().trim();
        String sEmail       = this.viewEditarClienteJuridico.getTextFieldEmail().getText().trim();
        if (this.checkParameters(sCnpj, sNome, sResponsavel, sTelefone) == true) {
            Cidade          oCidade          = new DaoCidade().findCidadeByNome(sCidade);
            ClienteJuridico oClienteJuridico = this.viewEditarClienteJuridico.getClienteJuridico();
                            oClienteJuridico.setDocumento(sCnpj);
                            oClienteJuridico.setRazaoSocial(sRazaoSocial);
                            oClienteJuridico.setNome(sNome);
                            oClienteJuridico.setResponsavel(sResponsavel);
                            oClienteJuridico.setEndereco(sEndereco);
                            oClienteJuridico.setCidade(oCidade);
                            oClienteJuridico.setTelefone(sTelefone);
                            oClienteJuridico.setCelular(sCelular);
                            oClienteJuridico.setEmail(sEmail);
            this.daoCliente.update(oClienteJuridico);
            new ViewMensagem(this.viewEditarClienteJuridico, "Cliente Atualizado com Sucesso!").setVisible(true);
            this.viewEditarClienteJuridico.dispose();
            this.viewEditarClienteJuridico.getViewConsultaCliente().clear();
        }
    }
    
    private boolean checkParameters(String sCnpj, String sNome, String sResponsavel, String sTelefone) {
        if (this.controllerCliente.checkCnpj(sCnpj) == false) {
            new ViewErro(this.viewEditarClienteJuridico, "CNPJ Inválido!").setVisible(true);
            this.viewEditarClienteJuridico.getTextFieldCnpj().requestFocus();
            return false;
        }else if (this.controllerCliente.checkUpdate(sCnpj, this.viewEditarClienteJuridico.getClienteJuridico().getId()) == false) {
            new ViewErro(this.viewEditarClienteJuridico, "CNPJ já Cadastrado!").setVisible(true);
            this.viewEditarClienteJuridico.getTextFieldCnpj().requestFocus();
            return false;
        }else if (this.controllerCliente.checkNome(sNome) == false) {
            new ViewErro(this.viewEditarClienteJuridico, "Nome Inválido!").setVisible(true);
            this.viewEditarClienteJuridico.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerCliente.checkResponsavel(sResponsavel) == false) {
            new ViewErro(this.viewEditarClienteJuridico, "Responsável Inválido!").setVisible(true);
            this.viewEditarClienteJuridico.getTextFieldResponsavel().requestFocus();
            return false;
        }else if (this.viewEditarClienteJuridico.getComboBoxCidade().getSelectedIndex() == 0) {
            new ViewErro(this.viewEditarClienteJuridico, "Selecione uma Cidade!").setVisible(true);
            this.viewEditarClienteJuridico.getComboBoxCidade().requestFocus();
            return false;
        }else if (this.controllerCliente.checkTelefone(sTelefone) == false) {
            new ViewErro(this.viewEditarClienteJuridico, "Telefone Inválido!").setVisible(true);
            this.viewEditarClienteJuridico.getTextFieldTelefone().requestFocus();
            return false;
        }
        return true;
    }
}