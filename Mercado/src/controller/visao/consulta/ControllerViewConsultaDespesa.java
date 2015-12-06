package controller.visao.consulta;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoDespesa;
import modelo.gerenciais.Despesa;
import visao.consulta.ViewConsultaDespesa;
import visao.editar.ViewEditarDespesa;
import visao.mensagens.ViewErro;
import visao.remover.ViewRemoverDespesa;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewConsultaDespesa.
 * @author  Rafael
 * @version 1.0
 * @since   18/11/2015
 * @see     controller.visao.consulta.ControllerViewConsulta
 */
public class ControllerViewConsultaDespesa extends ControllerViewConsulta {
    private final ViewConsultaDespesa viewConsultaDespesa;
    private final DaoDespesa          daoDespesa;
    private       List<Despesa>       despesas;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewConsultaDespesa(ViewConsultaDespesa oView) {
        super(oView);
        this.viewConsultaDespesa = oView;
        this.daoDespesa          = new DaoDespesa();
        this.despesas            = this.daoDespesa.list();
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
        String sDespesa = this.viewConsultaDespesa.getTextFieldPesquisa().getText();
        this.despesas   = this.daoDespesa.findDespesas(sDespesa);
        this.viewConsultaDespesa.addRows(this.daoDespesa.getDespesas(this.despesas));
    }

    @Override
    protected void edit() {
        int iIndex    = this.viewConsultaDespesa.getTable().getSelectedRow();
        int iDespesas = this.despesas.size();
        if ((iIndex >= 0) 
         && (iIndex < iDespesas)) {
            new ViewEditarDespesa(this.viewConsultaDespesa, this.despesas.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaDespesa, "Selecione uma Despesa!").setVisible(true);
            this.viewConsultaDespesa.getTextFieldPesquisa().requestFocus();
        }
    }

    @Override
    protected void remove() {
        int iIndex    = this.viewConsultaDespesa.getTable().getSelectedRow();
        int iDespesas = this.despesas.size();
        if ((iIndex >= 0) 
         && (iIndex < iDespesas)) {
            new ViewRemoverDespesa(this.viewConsultaDespesa, this.despesas.get(iIndex)).setVisible(true);
        }else {
            new ViewErro(this.viewConsultaDespesa, "Selecione uma Despesa!").setVisible(true);
            this.viewConsultaDespesa.getTextFieldPesquisa().requestFocus();
        }
    }
}