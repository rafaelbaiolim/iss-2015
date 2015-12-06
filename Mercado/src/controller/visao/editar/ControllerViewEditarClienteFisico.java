package controller.visao.editar;

import controller.modelo.cadastrais.ControllerCliente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.ClienteFisico;
import modelo.complementares.Cidade;
import modelo.dao.cadastrais.DaoCliente;
import modelo.dao.complementares.DaoCidade;
import visao.editar.ViewEditarClienteFisico;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarFisico.
 * @author  Hadyne
 * @version 1.0
 * @since   20/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 * @see     controller.modelo.cadastrais.ControllerCliente
 */
public class ControllerViewEditarClienteFisico extends ControllerViewEditar {
    private final ViewEditarClienteFisico viewEditarClienteFisico;
    private final ControllerCliente       controllerCliente;
    private final DaoCliente              daoCliente;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewEditarClienteFisico(ViewEditarClienteFisico oView) {
        super(oView);
        this.viewEditarClienteFisico = oView;
        this.controllerCliente       = new ControllerCliente();
        this.daoCliente              = new DaoCliente();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
        if (oActionEvent.getSource().equals(this.viewEditarClienteFisico.getRadioButtonMasculino())) {
            this.viewEditarClienteFisico.getRadioButtonFeminino().setSelected(false);
        }else if (oActionEvent.getSource().equals(this.viewEditarClienteFisico.getRadioButtonFeminino())) {
            this.viewEditarClienteFisico.getRadioButtonMasculino().setSelected(false);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }
    
    @Override
    protected void save() {
        String sCpf      = this.viewEditarClienteFisico.getTextFieldCpf().getText().toUpperCase().trim();
        String sRg       = this.viewEditarClienteFisico.getTextFieldRg().getText().toUpperCase().trim();
        String sNome     = this.viewEditarClienteFisico.getTextFieldNome().getText().toUpperCase().trim();
        char   cSexo     = (this.viewEditarClienteFisico.getRadioButtonMasculino().isSelected() == true) ? 'M' : 'F';
        String sEndereco = this.viewEditarClienteFisico.getTextFieldEndereco().getText().toUpperCase().trim();
        String sCidade   = this.viewEditarClienteFisico.getComboBoxCidade().getSelectedItem().toString();
        String sTelefone = this.viewEditarClienteFisico.getTextFieldTelefone().getText().toUpperCase().trim();
        String sCelular  = this.viewEditarClienteFisico.getTextFieldCelular().getText().toUpperCase().trim();
        String sEmail    = this.viewEditarClienteFisico.getTextFieldEmail().getText().trim();
        if (this.checkParameters(sCpf, sNome, sTelefone) == true) {
            Cidade        oCidade        = new DaoCidade().findCidadeByNome(sCidade);
            ClienteFisico oClienteFisico = this.viewEditarClienteFisico.getClienteFisico();
                          oClienteFisico.setDocumento(sCpf);
                          oClienteFisico.setRg(sRg);
                          oClienteFisico.setNome(sNome);
                          oClienteFisico.setSexo(cSexo);
                          oClienteFisico.setEndereco(sEndereco);
                          oClienteFisico.setCidade(oCidade);
                          oClienteFisico.setTelefone(sTelefone);
                          oClienteFisico.setCelular(sCelular);
                          oClienteFisico.setEmail(sEmail);
            this.daoCliente.update(oClienteFisico);
            new ViewMensagem(this.viewEditarClienteFisico, "Cliente Atualizado com Sucesso!").setVisible(true);
            this.viewEditarClienteFisico.dispose();
            this.viewEditarClienteFisico.getViewConsultaCliente().clear();
        }
    }
    
    private boolean checkParameters(String sCpf, String sNome, String sTelefone) {
        if (this.controllerCliente.checkCpf(sCpf) == false) {
            new ViewErro(this.viewEditarClienteFisico, "CPF Inválido!").setVisible(true);
            this.viewEditarClienteFisico.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.controllerCliente.checkUpdate(sCpf, this.viewEditarClienteFisico.getClienteFisico().getId()) == false) {
            new ViewErro(this.viewEditarClienteFisico, "CPF já Cadastrado!").setVisible(true);
            this.viewEditarClienteFisico.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.controllerCliente.checkNome(sNome) == false) {
            new ViewErro(this.viewEditarClienteFisico, "Nome Inválido!").setVisible(true);
            this.viewEditarClienteFisico.getTextFieldNome().requestFocus();
            return false;
        }else if (this.viewEditarClienteFisico.getComboBoxCidade().getSelectedIndex() == 0) {
            new ViewErro(this.viewEditarClienteFisico, "Selecione uma Cidade!").setVisible(true);
            this.viewEditarClienteFisico.getComboBoxCidade().requestFocus();
            return false;
        }else if (this.controllerCliente.checkTelefone(sTelefone) == false) {
            new ViewErro(this.viewEditarClienteFisico, "Telefone Inválido!").setVisible(true);
            this.viewEditarClienteFisico.getTextFieldTelefone().requestFocus();
            return false;
        }
        return true;
    }
}