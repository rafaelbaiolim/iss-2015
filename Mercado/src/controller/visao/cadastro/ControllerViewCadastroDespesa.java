package controller.visao.cadastro;

import controller.modelo.gerenciais.ControllerDespesa;
import funct.FunctDate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import modelo.dao.gerenciais.DaoDespesa;
import modelo.gerenciais.Despesa;
import visao.cadastro.ViewCadastroDespesa;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroDespesa.
 * @author  Rafael
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.cadastro.ControllerViewCadastro
 * @see     controller.modelo.gerenciais.ControllerDespesa
 */
public class ControllerViewCadastroDespesa extends ControllerViewCadastro {
    private final ViewCadastroDespesa viewCadastroDespesa;
    private final ControllerDespesa   controllerDespesa;
    private final DaoDespesa          daoDespesa;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroDespesa(ViewCadastroDespesa oView) {
        super(oView);
        this.viewCadastroDespesa = oView;
        this.controllerDespesa   = new ControllerDespesa();
        this.daoDespesa          = new DaoDespesa();
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
        String sDescricao     = this.viewCadastroDespesa.getTextFieldDescricao().getText().toUpperCase().trim();
        String sValor         = this.viewCadastroDespesa.getTextFieldValor().getText().toUpperCase().trim();
        String sDataPagamento = this.viewCadastroDespesa.getTextFieldDataPagamento().getText().toUpperCase().trim();
        String sObservacao    = this.viewCadastroDespesa.getTextAreaObservacao().getText().toUpperCase().trim();
        if (this.checkParameters(sDescricao, sValor) == true) {
            float   fValor    = Float.parseFloat(sValor);
            Date    dData     = new FunctDate().createDate(sDataPagamento);
            Despesa oDespesa  = new Despesa(sDescricao, sObservacao, dData, fValor);
            this.daoDespesa.insert(oDespesa);
            this.viewCadastroDespesa.clear();
            new ViewMensagem(this.viewCadastroDespesa, "Despesa Cadastrada com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sDescricao, String sValor) {
        if (this.controllerDespesa.checkDescricao(sDescricao) == false) {
            this.viewCadastroDespesa.setErro("Descricao Inválida!");
            new ViewErro(this.viewCadastroDespesa, "Descricao Inválida!").setVisible(true);
            this.viewCadastroDespesa.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerDespesa.checkValor(sValor) == false) {
            this.viewCadastroDespesa.setErro("Valor Inválido!");
            new ViewErro(this.viewCadastroDespesa, "Valor Inválido!").setVisible(true);
            this.viewCadastroDespesa.getTextFieldValor().requestFocus();
            return false;
        }
        return true;
    }
}