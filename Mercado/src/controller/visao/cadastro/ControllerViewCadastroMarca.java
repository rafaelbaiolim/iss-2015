package controller.visao.cadastro;

import controller.modelo.gerenciais.ControllerMarca;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.gerenciais.DaoMarca;
import modelo.gerenciais.Marca;
import visao.cadastro.ViewCadastroMarca;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroMarca.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.cadastro.ControllerViewCadastro
 */
public class ControllerViewCadastroMarca extends ControllerViewCadastro {
    private final ViewCadastroMarca viewCadastroMarca;
    private final ControllerMarca   controllerMarca;
    private final DaoMarca          daoMarca;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroMarca(ViewCadastroMarca oView) {
        super(oView);
        this.viewCadastroMarca = oView;
        this.controllerMarca   = new ControllerMarca();
        this.daoMarca          = new DaoMarca();
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
        String  sNome  = this.viewCadastroMarca.getTextFieldNome().getText().trim();
        String  sSigla = this.viewCadastroMarca.getTextFieldSigla().getText().trim();
        if (this.checkParameters(sNome, sSigla) == true) {
            Marca oMarca = new Marca(sNome, sSigla);
            this.daoMarca.insert(oMarca);
            this.viewCadastroMarca.clear();
            new ViewMensagem(this.viewCadastroMarca, "Marca Cadastrada com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sNome, String sCnpj) {
        if (this.controllerMarca.checkNome(sNome) == false) {
            this.viewCadastroMarca.setErro("Nome Invalido!");
            new ViewErro(this.viewCadastroMarca, "Nome Invalido!").setVisible(true);
            this.viewCadastroMarca.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerMarca.nomeIsAvailable(sNome) == false) {
            this.viewCadastroMarca.setErro("Nome ja Cadastrado!");
            new ViewErro(this.viewCadastroMarca, "Nome ja Cadastrado!").setVisible(true);
            this.viewCadastroMarca.getTextFieldNome().requestFocus();
            return false;
        }else if (this.controllerMarca.checkSigla(sCnpj) == false) {
            this.viewCadastroMarca.setErro("Sigla Invalida!");
            new ViewErro(this.viewCadastroMarca, "Sigla Invalida!").setVisible(true);
            this.viewCadastroMarca.getTextFieldSigla().requestFocus();
            return false;
        }else if (this.controllerMarca.siglaIsAvailable(sCnpj) == false) {
            this.viewCadastroMarca.setErro("Sigla ja Cadastrada!");
            new ViewErro(this.viewCadastroMarca, "Sigla ja Cadastrada!").setVisible(true);
            this.viewCadastroMarca.getTextFieldSigla().requestFocus();
            return false;
        }
        return true;
    }
}