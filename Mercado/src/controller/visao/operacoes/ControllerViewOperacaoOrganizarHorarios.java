package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.gerenciais.DaoFuncionario;
import modelo.gerenciais.Funcionario;
import visao.editar.ViewEditarFuncionario;
import visao.mensagens.ViewErro;
import visao.operacoes.ViewOperacaoOrganizarHorarios;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Organizar Horarios.
 * @author Leandro
 * @since  16/01/2016
 */
public class ControllerViewOperacaoOrganizarHorarios extends ControllerViewModal {
    private final ViewOperacaoOrganizarHorarios viewOperacaoOrganizarHorarios;
    private final DaoFuncionario                daoFuncionario;
    private       List<Funcionario>             funcionarios;
   
    public ControllerViewOperacaoOrganizarHorarios(ViewOperacaoOrganizarHorarios oView) {
        super(oView);
        this.viewOperacaoOrganizarHorarios = oView;
        this.daoFuncionario                = new DaoFuncionario();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoOrganizarHorarios.getButtonSearch())) {
            String sNome      = this.viewOperacaoOrganizarHorarios.getTextFieldNomeFuncionario().getText();
            String sTurno     = (this.viewOperacaoOrganizarHorarios.getComboBoxTurno().getSelectedItem().toString().equals("Selecione") == true) ? "" : this.viewOperacaoOrganizarHorarios.getComboBoxTurno().getSelectedItem().toString();
            String sSetor     = (this.viewOperacaoOrganizarHorarios.getComboBoxSetor().getSelectedItem().toString().equals("Selecione") == true) ? "" : this.viewOperacaoOrganizarHorarios.getComboBoxSetor().getSelectedItem().toString();
            this.funcionarios = this.daoFuncionario.findFuncionarios(sNome, sTurno, sSetor);
            this.viewOperacaoOrganizarHorarios.setFuncionarios(this.funcionarios);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoOrganizarHorarios.getButtonEditar())) {
            this.funcionarios = this.viewOperacaoOrganizarHorarios.getFuncionarios();
            int iIndex        = this.viewOperacaoOrganizarHorarios.getTable().getSelectedRow();
            int iFuncionarios = this.funcionarios.size();
            if ((iIndex >= 0) 
                && (iIndex < iFuncionarios)) {
                new ViewEditarFuncionario(this.viewOperacaoOrganizarHorarios, this.funcionarios.get(iIndex)).setVisible(true);
            }else {
                new ViewErro(this.viewOperacaoOrganizarHorarios, "Selecione um Funcionario!").setVisible(true);
                this.viewOperacaoOrganizarHorarios.getTextFieldNomeFuncionario().requestFocus();
            }
        }else if (oActionEvent.getSource().equals(this.viewOperacaoOrganizarHorarios.getButtonOk())) {
            this.viewOperacaoOrganizarHorarios.dispose();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoOrganizarHorarios.getButtonVoltar())) {
            this.viewOperacaoOrganizarHorarios.dispose();
        }
    }
    
}