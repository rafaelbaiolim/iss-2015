package controller.visao.cadastro;

import controller.modelo.complementares.ControllerCidade;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.complementares.Cidade;
import modelo.complementares.UF;
import modelo.dao.complementares.DaoCidade;
import modelo.dao.complementares.DaoUF;
import visao.cadastro.ViewCadastroCidade;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroCidade.
 * @author  Leandro
 * @version 1.0
 * @since   20/10/2015
 * @see     visao.cadastro.ControllerViewCadastro
 * @see     controller.modelo.complementares.ControllerCidade
 */
public class ControllerViewCadastroCidade extends ControllerViewCadastro {
    private final ViewCadastroCidade viewCadastroCidade;
    private final ControllerCidade   controllerCidade;
    private final DaoCidade          daoCidade;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroCidade(ViewCadastroCidade oView) {
        super(oView);
        this.viewCadastroCidade = oView;
        this.controllerCidade   = new ControllerCidade();
        this.daoCidade          = new DaoCidade();
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
        String sNome = this.viewCadastroCidade.getTextFieldNome().getText().toUpperCase().trim();
        String sUF   = this.viewCadastroCidade.getComboBoxUF().getSelectedItem().toString();
        UF     oUF   = new DaoUF().findUFBySigla(sUF);
        if (this.checkParameters(sNome, oUF) == true) {
            Cidade oCidade = new Cidade(sNome, oUF);
            this.daoCidade.insert(oCidade);
            this.viewCadastroCidade.clear();
            new ViewMensagem(this.viewCadastroCidade, "Cidade Cadastrada com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sNome, UF oUF) {
        if (this.controllerCidade.checkNome(sNome) == false) {
            this.viewCadastroCidade.setErro("Nome Inválido!");
            new ViewErro(this.viewCadastroCidade, "Nome Inválido!").setVisible(true);
            this.viewCadastroCidade.getTextFieldNome().requestFocus();
            return false;
        }else if (oUF == null) {
            this.viewCadastroCidade.setErro("UF Inválida!");
            new ViewErro(this.viewCadastroCidade, "UF Inválida!").setVisible(true);
            this.viewCadastroCidade.getComboBoxUF().requestFocus();
            return false;
        }else if (this.controllerCidade.cidadeIsAvailable(sNome, oUF) == false) {
            this.viewCadastroCidade.setErro("Cidade já Cadastrada!");
            new ViewErro(this.viewCadastroCidade, "Cidade já Cadastrada!").setVisible(true);
            this.viewCadastroCidade.getTextFieldNome().requestFocus();
            return false;
        }
        return true;
    }
}