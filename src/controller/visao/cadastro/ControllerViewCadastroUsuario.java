package controller.visao.cadastro;

import controller.modelo.cadastrais.ControllerUsuario;
import modelo.dao.estruturais.DaoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.estruturais.Usuario;
import visao.cadastro.ViewCadastroUsuario;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroUsuario.
 * @author  Leandro
 * @version 1.0
 * @since   20/10/2015
 * @see     visao.cadastro.ControllerViewCadastro
 */
public class ControllerViewCadastroUsuario extends ControllerViewCadastro {
    private final ViewCadastroUsuario viewCadastroUsuario;
    private final ControllerUsuario   controllerUsuario;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroUsuario(ViewCadastroUsuario oView) {
        super(oView);
        this.viewCadastroUsuario = oView;
        this.controllerUsuario   = new ControllerUsuario();
    }

    private boolean checkParameters(String sLogin, String sSenha1, String sSenha2) {
        if (this.controllerUsuario.checkLogin(sLogin) == false) {
            this.viewCadastroUsuario.setErro("Login Invalido!");
            new ViewErro(this.viewCadastroUsuario, "Login Invalido!").setVisible(true);
            this.viewCadastroUsuario.getTextFieldLogin().requestFocus();
            return false;
        }else if (this.controllerUsuario.loginIsAvailable(sLogin) == false) {
            this.viewCadastroUsuario.setErro("Login ja Cadastrado!");
            new ViewErro(this.viewCadastroUsuario, "Login ja Cadastrado!").setVisible(true);
            this.viewCadastroUsuario.getTextFieldLogin().requestFocus();
            return false;
        }else if (sSenha1.length() == 0) {
            this.viewCadastroUsuario.setErro("Senha Invalida!");
            new ViewErro(this.viewCadastroUsuario, "Senha Invalida!").setVisible(true);
            this.viewCadastroUsuario.getTextFieldSenha1().requestFocus();
            return false;
        }else if (sSenha1.equals(sSenha2) == false) {
            this.viewCadastroUsuario.setErro("Senhas nao Correspondentes!");
            new ViewErro(this.viewCadastroUsuario, "Senhas nao Correspondentes!").setVisible(true);
            this.viewCadastroUsuario.getTextFieldSenha1().requestFocus();
            return false;
        }
        return true;
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
        String  sLogin  = this.viewCadastroUsuario.getTextFieldLogin().getText().trim();
        String  sSenha1 = this.viewCadastroUsuario.getTextFieldSenha1().getText();
        String  sSenha2 = this.viewCadastroUsuario.getTextFieldSenha2().getText();
        boolean bAtivo  = this.viewCadastroUsuario.getCheckBoxAtivo().isSelected();
        boolean bAdm    = this.viewCadastroUsuario.getCheckBoxAdm().isSelected();
        if (this.checkParameters(sLogin, sSenha1, sSenha2) == true) {
            Usuario oUsuario = new Usuario(sLogin, sSenha1);
            new DaoUsuario().insert(oUsuario);
            this.viewCadastroUsuario.clear();
            new ViewMensagem(this.viewCadastroUsuario, "Usuario Cadastrado com Sucesso!").setVisible(true);
        }
    }
}