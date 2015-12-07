package controller.visao.editar;

import controller.modelo.complementares.ControllerCidade;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.complementares.Cidade;
import modelo.complementares.UF;
import modelo.dao.complementares.DaoCidade;
import modelo.dao.complementares.DaoUF;
import visao.editar.ViewEditarCidade;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarCidade.
 * @author  Leandro
 * @version 1.0
 * @since   19/11/2015
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarCidade extends ControllerViewEditar {
    private final ViewEditarCidade viewEditarCidade;
    private final ControllerCidade controllerCidade;
    private final DaoCidade        daoCidade;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarCidade(ViewEditarCidade oView) {
        super(oView);
        this.viewEditarCidade = oView;
        this.controllerCidade = new ControllerCidade();
        this.daoCidade        = new DaoCidade();
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
        String sNome = this.viewEditarCidade.getTextFieldNome().getText().toUpperCase().trim();
        String sUF   = this.viewEditarCidade.getComboBoxUF().getSelectedItem().toString();
        UF     oUF   = new DaoUF().findUFBySigla(sUF);
        if (this.checkParameters(sNome, oUF) == true) {
            Cidade oCidade = this.viewEditarCidade.getCidade();
                   oCidade.setNome(sNome);
                   oCidade.setUf(oUF);
            this.daoCidade.update(oCidade);
            new ViewMensagem(this.viewEditarCidade, "Cidade Atualizada com Sucesso!").setVisible(true);
            this.viewEditarCidade.dispose();
            this.viewEditarCidade.getViewConsultaCidade().clear();
        }
    }
    
    private boolean checkParameters(String sNome, UF oUF) {
        if (this.controllerCidade.checkNome(sNome) == false) {
            new ViewErro(this.viewEditarCidade, "Nome Inválido!").setVisible(true);
            this.viewEditarCidade.getTextFieldNome().requestFocus();
            return false;
        }else if (oUF == null) {
            new ViewErro(this.viewEditarCidade, "UF Inválida!").setVisible(true);
            this.viewEditarCidade.getComboBoxUF().requestFocus();
            return false;
        }else if (this.controllerCidade.checkUpdate(sNome, oUF, this.viewEditarCidade.getCidade().getId()) == false) {
            new ViewErro(this.viewEditarCidade, "Cidade já Cadastrada!").setVisible(true);
            this.viewEditarCidade.getTextFieldNome().requestFocus();
            return false;
        }
        return true;
    }
}