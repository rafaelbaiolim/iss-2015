package controller.visao.cadastro;

import controller.modelo.gerenciais.ControllerFuncionario;
import funct.FunctDate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import modelo.dao.gerenciais.DaoFuncionario;
import modelo.gerenciais.Funcionario;
import visao.cadastro.ViewCadastroFuncionario;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroFuncionario.
 * @author  Leandro
 * @version 1.0
 * @since   20/10/2015
 * @see     visao.cadastro.ControllerViewCadastro
 */
public class ControllerViewCadastroFuncionario extends ControllerViewCadastro {
    private final ViewCadastroFuncionario viewCadastroFuncionario;
    private final ControllerFuncionario   controllerFuncionario;
    private final DaoFuncionario          daoFuncionario;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroFuncionario(ViewCadastroFuncionario oView) {
        super(oView);
        this.viewCadastroFuncionario = oView;
        this.controllerFuncionario   = new ControllerFuncionario();
        this.daoFuncionario          = new DaoFuncionario();
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
        String sNome         = this.viewCadastroFuncionario.getTextFieldNome().getText().toUpperCase().trim();
        String sCpf          = this.viewCadastroFuncionario.getTextFieldCpf().getText().toUpperCase().trim();
        String sTurno        = this.viewCadastroFuncionario.getComboBoxTurno().getSelectedItem().toString().toUpperCase().trim();
        String sCargo        = this.viewCadastroFuncionario.getTextFieldCargo().getText().toUpperCase().trim();
        String sSetor        = this.viewCadastroFuncionario.getComboBoxSetor().getSelectedItem().toString().toUpperCase().trim();
        String sCargaHoraria = this.viewCadastroFuncionario.getTextFieldCargaHoraria().getText().toUpperCase().trim();
        String sSalario      = this.viewCadastroFuncionario.getTextFieldSalario().getText().toUpperCase().trim();
        Date   dDataAdmissao = new FunctDate().createDate(this.viewCadastroFuncionario.getTextFieldDataAdmissao().getText().trim());
        if (this.checkParameters(sNome, sCpf, sCargo, sCargaHoraria, sSalario) == true) {
            int    iCargaHoraria = Integer.parseInt(sCargaHoraria);
            float  fSalario      = Float.parseFloat(sSalario);
            Funcionario oFuncionario = new Funcionario(sCpf, sNome, sTurno, sCargo, sSetor, iCargaHoraria, fSalario, dDataAdmissao);
            this.daoFuncionario.insert(oFuncionario);
            this.viewCadastroFuncionario.clear();
            new ViewMensagem(this.viewCadastroFuncionario, "Funcionário Cadastrado com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sNome, String sCpf, String sCargo, String sCargaHoraria, String sSalario) {
        if (this.controllerFuncionario.checkNome(sNome) == false) {
            this.viewCadastroFuncionario.setErro("Nome Inválido!");
            new ViewErro(this.viewCadastroFuncionario, "Nome Inválido!").setVisible(true);
            this.viewCadastroFuncionario.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkCpf(sCpf) == false) {
            this.viewCadastroFuncionario.setErro("CPF Inválido - Digite no formato XXX.XXX.XXX-XX!");
            new ViewErro(this.viewCadastroFuncionario, "CPF Inválido - Digite no formato XXX.XXX.XXX-XX!").setVisible(true);
            this.viewCadastroFuncionario.getTextFieldCpf().setText("111.111.111-11");
            this.viewCadastroFuncionario.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.controllerFuncionario.cpfIsAvailable(sCpf) == false) {
            this.viewCadastroFuncionario.setErro("CPF já Cadastrado!");
            new ViewErro(this.viewCadastroFuncionario, "CPF já Cadastrado!").setVisible(true);
            this.viewCadastroFuncionario.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.viewCadastroFuncionario.getComboBoxTurno().getSelectedIndex() == 0) {
            this.viewCadastroFuncionario.setErro("Selecione um Turno!");
            new ViewErro(this.viewCadastroFuncionario, "Selecione um Turno!").setVisible(true);
            this.viewCadastroFuncionario.getComboBoxTurno().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkCargo(sCargo) == false) {
            this.viewCadastroFuncionario.setErro("Cargo Inválido!");
            new ViewErro(this.viewCadastroFuncionario, "Cargo Inválido!").setVisible(true);
            this.viewCadastroFuncionario.getTextFieldCargo().requestFocus();
            return false;
        }else if (this.viewCadastroFuncionario.getComboBoxSetor().getSelectedIndex() == 0) {
            this.viewCadastroFuncionario.setErro("Selecione um Setor!");
            new ViewErro(this.viewCadastroFuncionario, "Selecione um Setor!").setVisible(true);
            this.viewCadastroFuncionario.getComboBoxSetor().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkCargaHoraria(sCargaHoraria) == false) {
            this.viewCadastroFuncionario.setErro("Carga Horária Inválida - Digite apenas Números!");
            new ViewErro(this.viewCadastroFuncionario, "Carga Horária Inválida - Digite apenas Números!").setVisible(true);
            this.viewCadastroFuncionario.getTextFieldCargaHoraria().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkSalario(sSalario) == false) {
            this.viewCadastroFuncionario.setErro("Salário Inválido!");
            new ViewErro(this.viewCadastroFuncionario, "Salário Inválido!").setVisible(true);
            this.viewCadastroFuncionario.getTextFieldSalario().requestFocus();
            return false;
        }
        return true;
    }
}