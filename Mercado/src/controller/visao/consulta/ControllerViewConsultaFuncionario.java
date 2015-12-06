package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoFuncionario;
import modelo.gerenciais.Funcionario;
import visao.consulta.ViewConsultaFuncionario;
import visao.editar.ViewEditarFuncionario;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverFuncionario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaFuncionario.
 * @author  Leandro
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaFuncionario extends ControllerViewConsulta {
    private final ViewConsultaFuncionario viewConsultaFuncionario;
    private final DaoFuncionario          daoFuncionario;
    private       List<Funcionario>       funcionarios;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaFuncionario(ViewConsultaFuncionario oView) {
        super(oView);
        this.viewConsultaFuncionario = oView;
        this.daoFuncionario          = new DaoFuncionario();
        this.funcionarios            = this.daoFuncionario.list();
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
    protected void pesquisar() {
        String sFuncionario = this.viewConsultaFuncionario.getTextFieldPesquisa().getText();
        this.funcionarios   = this.daoFuncionario.findFuncionarios(sFuncionario);
        this.viewConsultaFuncionario.addRows(this.daoFuncionario.getFuncionarios(this.funcionarios));
    }

    @Override
    protected void edit() {
        int iIndex       = this.viewConsultaFuncionario.getTable().getSelectedRow();
        int iFuncinarios = this.funcionarios.size();
        if ((iIndex >= 0) 
         && (iIndex < iFuncinarios)) {
            new ViewEditarFuncionario(this.viewConsultaFuncionario, this.funcionarios.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaFuncionario, "Selecione um Funcionario!").setVisible(true);
            this.viewConsultaFuncionario.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex        = this.viewConsultaFuncionario.getTable().getSelectedRow();
        int iFuncionarios = this.funcionarios.size();
        if ((iIndex >= 0) 
         && (iIndex < iFuncionarios)) {
            new ViewRemoverFuncionario(this.viewConsultaFuncionario, this.funcionarios.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaFuncionario, "Selecione um Funcionario!").setVisible(true);
            this.viewConsultaFuncionario.getTextFieldPesquisa().requestFocus();
        }
    }
}