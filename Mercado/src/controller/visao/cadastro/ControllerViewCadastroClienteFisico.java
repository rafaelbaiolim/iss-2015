package controller.visao.cadastro;

import controller.modelo.cadastrais.ControllerCliente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.ClienteFisico;
import modelo.complementares.Cidade;
import modelo.dao.cadastrais.DaoCliente;
import modelo.dao.complementares.DaoCidade;
import visao.cadastro.ViewCadastroClienteFisico;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroClienteFisico.
 * @author  Hadyne
 * @version 1.0
 * @since   20/11/2015
 * @see     visao.cadastro.ControllerViewCadastro
 * @see     controller.modelo.cadastrais.ControllerCliente
 */
public class ControllerViewCadastroClienteFisico extends ControllerViewCadastro {
    private final ViewCadastroClienteFisico viewCadastroClienteFisico;
    private final ControllerCliente         controllerCliente;
    private final DaoCliente                daoCliente;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroClienteFisico(ViewCadastroClienteFisico oView) {
        super(oView);
        this.viewCadastroClienteFisico = oView;
        this.controllerCliente         = new ControllerCliente();
        this.daoCliente                = new DaoCliente();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
        if (oActionEvent.getSource().equals(this.viewCadastroClienteFisico.getRadioButtonMasculino())) {
            this.viewCadastroClienteFisico.getRadioButtonFeminino().setSelected(false);
        }else if (oActionEvent.getSource().equals(this.viewCadastroClienteFisico.getRadioButtonFeminino())) {
            this.viewCadastroClienteFisico.getRadioButtonMasculino().setSelected(false);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }
    
    @Override
    public void cadastro() {
        String sCpf      = this.viewCadastroClienteFisico.getTextFieldCpf().getText().toUpperCase().trim();
        String sRg       = this.viewCadastroClienteFisico.getTextFieldRg().getText().toUpperCase().trim();
        String sNome     = this.viewCadastroClienteFisico.getTextFieldNome().getText().toUpperCase().trim();
        char   cSexo     = (this.viewCadastroClienteFisico.getRadioButtonMasculino().isSelected() == true) ? 'M' : 'F';
        String sEndereco = this.viewCadastroClienteFisico.getTextFieldEndereco().getText().toUpperCase().trim();
        String sCidade   = this.viewCadastroClienteFisico.getComboBoxCidade().getSelectedItem().toString();
        String sTelefone = this.viewCadastroClienteFisico.getTextFieldTelefone().getText().toUpperCase().trim();
        String sCelular  = this.viewCadastroClienteFisico.getTextFieldCelular().getText().toUpperCase().trim();
        String sEmail    = this.viewCadastroClienteFisico.getTextFieldEmail().getText().trim();
        if (this.checkParameters(sCpf, sNome, sTelefone) == true) {
            Cidade        oCidade        = new DaoCidade().findCidadeByNome(sCidade);
            ClienteFisico oClienteFisico = new ClienteFisico(sCpf, sNome, sTelefone, sCelular, sEmail, sEndereco, oCidade, sRg, cSexo);
            this.daoCliente.insert(oClienteFisico);
            this.viewCadastroClienteFisico.clear();
            new ViewMensagem(this.viewCadastroClienteFisico, "Cliente Cadastrado com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sCpf, String sNome, String sTelefone) {
        if (this.controllerCliente.checkCpf(sCpf) == false) {
            this.viewCadastroClienteFisico.setErro("CPF Inválido!");
            new ViewErro(this.viewCadastroClienteFisico, "CPF Inválido!").setVisible(true);
            this.viewCadastroClienteFisico.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.controllerCliente.documentoIsAvailable(sCpf) == false) {
            this.viewCadastroClienteFisico.setErro("CPF já Cadastrado!");
            new ViewErro(this.viewCadastroClienteFisico, "CPF já Cadastrado!").setVisible(true);
            this.viewCadastroClienteFisico.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.controllerCliente.checkNome(sNome) == false) {
            this.viewCadastroClienteFisico.setErro("Nome Inválido!");
            new ViewErro(this.viewCadastroClienteFisico, "Nome Inválido!").setVisible(true);
            this.viewCadastroClienteFisico.getTextFieldNome().requestFocus();
            return false;
        }else if (this.viewCadastroClienteFisico.getComboBoxCidade().getSelectedIndex() == 0) {
            this.viewCadastroClienteFisico.setErro("Selecione uma Cidade!");
            new ViewErro(this.viewCadastroClienteFisico, "Selecione uma Cidade!").setVisible(true);
            this.viewCadastroClienteFisico.getComboBoxCidade().requestFocus();
            return false;
        }else if (this.controllerCliente.checkTelefone(sTelefone) == false) {
            this.viewCadastroClienteFisico.setErro("Telefone Inválido!");
            new ViewErro(this.viewCadastroClienteFisico, "Telefone Inválido!").setVisible(true);
            this.viewCadastroClienteFisico.getTextFieldTelefone().requestFocus();
            return false;
        }
        return true;
    }
}