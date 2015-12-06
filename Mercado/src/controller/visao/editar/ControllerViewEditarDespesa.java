package controller.visao.editar;

import controller.modelo.gerenciais.ControllerDespesa;
import funct.FunctDate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import modelo.dao.gerenciais.DaoDespesa;
import modelo.gerenciais.Despesa;
import visao.editar.ViewEditarDespesa;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarDespesa.
 * @author  Rafael
 * @version 1.0
 * @since   19/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarDespesa extends ControllerViewEditar {
    private final ViewEditarDespesa viewEditarDespesa;
    private final ControllerDespesa controllerDespesa;
    private final DaoDespesa        daoDespesa;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarDespesa(ViewEditarDespesa oView) {
        super(oView);
        this.viewEditarDespesa = oView;
        this.controllerDespesa = new ControllerDespesa();
        this.daoDespesa        = new DaoDespesa();
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
        String sDescricao     = this.viewEditarDespesa.getTextFieldDescricao().getText().toUpperCase().trim();
        String sValor         = this.viewEditarDespesa.getTextFieldValor().getText().toUpperCase().trim();
        String sDataPagamento = this.viewEditarDespesa.getTextFieldDataPagamento().getText().toUpperCase().trim();
        String sObservacao    = this.viewEditarDespesa.getTextAreaObservacao().getText().toUpperCase().trim();
        if (this.checkParameters(sDescricao, sValor) == true) {
            float   fValor    = Float.parseFloat(sValor);
            Date    dData     = new FunctDate().createDate(sDataPagamento);
            Despesa oDespesa  = this.viewEditarDespesa.getDespesa();
                    oDespesa.setDescricao(sDescricao);
                    oDespesa.setValor(fValor);
                    oDespesa.setDataPagamento(dData);
                    oDespesa.setObservacao(sObservacao);
            this.daoDespesa.update(oDespesa);
            new ViewMensagem(this.viewEditarDespesa, "Despesa Cadastrada com Sucesso!").setVisible(true);
            this.viewEditarDespesa.dispose();
            this.viewEditarDespesa.getViewConsultaDespesa().clear();
        }
    }
    
    private boolean checkParameters(String sDescricao, String sValor) {
        if (this.controllerDespesa.checkDescricao(sDescricao) == false) {
            new ViewErro(this.viewEditarDespesa, "Descricao Inválida!").setVisible(true);
            this.viewEditarDespesa.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerDespesa.checkValor(sValor) == false) {
            new ViewErro(this.viewEditarDespesa, "Valor Inválido!").setVisible(true);
            this.viewEditarDespesa.getTextFieldValor().requestFocus();
            return false;
        }
        return true;
    }
}