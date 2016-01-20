package controller.visao.editar;

import controller.modelo.gerenciais.ControllerFuncionario;
import funct.FunctDate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import modelo.dao.gerenciais.DaoFuncionario;
import modelo.gerenciais.Funcionario;
import visao.consulta.ViewConsultaFuncionario;
import visao.editar.ViewEditarFuncionario;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoOrganizarHorarios;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarFuncionario.
 * @author  Leandro
 * @version 1.0
 * @since   19/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarFuncionario extends ControllerViewEditar {
    private final ViewEditarFuncionario viewEditarFuncionario;
    private final ControllerFuncionario controllerFuncionario;
    private final DaoFuncionario        daoFuncionario;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarFuncionario(ViewEditarFuncionario oView) {
        super(oView);
        this.viewEditarFuncionario = oView;
        this.controllerFuncionario = new ControllerFuncionario();
        this.daoFuncionario        = new DaoFuncionario();
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
        String sNome         = this.viewEditarFuncionario.getTextFieldNome().getText().toUpperCase().trim();
        String sCpf          = this.viewEditarFuncionario.getTextFieldCpf().getText().toUpperCase().trim();
        String sTurno        = this.viewEditarFuncionario.getComboBoxTurno().getSelectedItem().toString().toUpperCase().trim();
        String sCargo        = this.viewEditarFuncionario.getTextFieldCargo().getText().toUpperCase().trim();
        String sSetor        = this.viewEditarFuncionario.getComboBoxSetor().getSelectedItem().toString().toUpperCase().trim();
        String sCargaHoraria = this.viewEditarFuncionario.getTextFieldCargaHoraria().getText().toUpperCase().trim();
        String sSalario      = this.viewEditarFuncionario.getTextFieldSalario().getText().toUpperCase().trim();
        Date   dDataAdmissao = new FunctDate().createDate(this.viewEditarFuncionario.getTextFieldDataAdmissao().getText().trim());
        if (this.checkParameters(sNome, sCpf, sCargo, sCargaHoraria, sSalario) == true) {
            int    iCargaHoraria     = Integer.parseInt(sCargaHoraria);
            float  fSalario          = Float.parseFloat(sSalario);
            Funcionario oFuncionario = this.viewEditarFuncionario.getFuncionario();
                        oFuncionario.setNome(sNome);
                        oFuncionario.setCpf(sCpf);
                        oFuncionario.setTurno(sTurno);
                        oFuncionario.setCargo(sCargo);
                        oFuncionario.setSetor(sSetor);
                        oFuncionario.setCargaHoraria(iCargaHoraria);
                        oFuncionario.setSalario(fSalario);
                        oFuncionario.setDataAdmissao(dDataAdmissao);
            this.daoFuncionario.update(oFuncionario);
            new ViewMensagem(this.viewEditarFuncionario, "Funcionário Atualizado com Sucesso!").setVisible(true);
            this.viewEditarFuncionario.dispose();
            
            if (this.viewEditarFuncionario.getViewParent() instanceof ViewConsultaFuncionario) {
                ((ViewConsultaFuncionario) this.viewEditarFuncionario.getViewParent()).clear();
            }else if (this.viewEditarFuncionario.getViewParent() instanceof ViewOperacaoOrganizarHorarios) {
                ((ViewOperacaoOrganizarHorarios) this.viewEditarFuncionario.getViewParent()).clear();
            }
        }
    }
    
    private boolean checkParameters(String sNome, String sCpf, String sCargo, String sCargaHoraria, String sSalario) {
        if (this.controllerFuncionario.checkNome(sNome) == false) {
            new ViewErro(this.viewEditarFuncionario, "Nome Inválido!").setVisible(true);
            this.viewEditarFuncionario.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkCpf(sCpf) == false) {
            new ViewErro(this.viewEditarFuncionario, "CPF Inválido - Digite no formato XXX.XXX.XXX-XX!").setVisible(true);
            this.viewEditarFuncionario.getTextFieldCpf().requestFocus();
            return false;
        }else if (this.viewEditarFuncionario.getComboBoxTurno().getSelectedIndex() == 0) {
            new ViewErro(this.viewEditarFuncionario, "Selecione um Turno!").setVisible(true);
            this.viewEditarFuncionario.getComboBoxTurno().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkCargo(sCargo) == false) {
            new ViewErro(this.viewEditarFuncionario, "Cargo Inválido!").setVisible(true);
            this.viewEditarFuncionario.getTextFieldCargo().requestFocus();
            return false;
        }else if (this.viewEditarFuncionario.getComboBoxSetor().getSelectedIndex() == 0) {
            new ViewErro(this.viewEditarFuncionario, "Selecione um Setor!").setVisible(true);
            this.viewEditarFuncionario.getComboBoxSetor().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkCargaHoraria(sCargaHoraria) == false) {
            new ViewErro(this.viewEditarFuncionario, "Carga Horária Inválida - Digite apenas Números!").setVisible(true);
            this.viewEditarFuncionario.getTextFieldCargaHoraria().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkSalario(sSalario) == false) {
            new ViewErro(this.viewEditarFuncionario, "Salário Inválido!").setVisible(true);
            this.viewEditarFuncionario.getTextFieldSalario().requestFocus();
            return false;
        }else if (this.controllerFuncionario.checkUpdate(sCpf, this.viewEditarFuncionario.getFuncionario().getId()) == false) {
            new ViewErro(this.viewEditarFuncionario, "Funcionário já Cadastrado!").setVisible(true);
            this.viewEditarFuncionario.getTextFieldNome().requestFocus();
            return false;
        }
        return true;
    }
}