package controller.visao.sistema;

import funct.FunctString;
import java.awt.event.ActionEvent;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Usuario;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import visao.sistema.ViewSistemaTrocarSenha;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewSistemaTrocarSenha.
 * @author  Leandro
 * @version 1.0
 * @since   03/11/2015
 * @see     controller.visao.ControllerViewModal
 */
public class ControllerViewSistemaTrocarSenha extends ControllerViewModal {
    private final ViewSistemaTrocarSenha viewSistemaTrocarSenha;
    private final FunctString            functString;

    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewSistemaTrocarSenha(ViewSistemaTrocarSenha oView) {
        super(oView);
        this.viewSistemaTrocarSenha = oView;
        this.functString            = new FunctString();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewSistemaTrocarSenha.getButtonYes())) {
            this.trocarSenha();
        }else if (oActionEvent.getSource().equals(this.viewSistemaTrocarSenha.getButtonNo())) {
            this.viewSistemaTrocarSenha.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if ((oKeyEvent.getKeyCode() == KeyEvent.VK_F1)
         || (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER)) {
            this.trocarSenha();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F2) {
            this.viewSistemaTrocarSenha.dispose();
        }
    }
    
    private void trocarSenha() {
        String sSenhaAtual = this.viewSistemaTrocarSenha.getTextFieldSenhaAtual().getText();
        String sNovaSenha1 = this.viewSistemaTrocarSenha.getTextFieldNovaSenha1().getText();
        String sNovaSenha2 = this.viewSistemaTrocarSenha.getTextFieldNovaSenha2().getText();
        if (this.functString.md5(sSenhaAtual).equals(this.viewSistemaTrocarSenha.getUsuario().getSenha())) {
            if (sNovaSenha1.equals(sNovaSenha2)) {
                Usuario oUsuario = this.viewSistemaTrocarSenha.getUsuario();
                        oUsuario.setSenha(sNovaSenha1);
                new DaoUsuario().update(oUsuario);
                new ViewMensagem(this.viewSistemaTrocarSenha, "Senha Atualizada com Sucesso!").setVisible(true);
                this.viewSistemaTrocarSenha.dispose();
            }else {
                new ViewErro(this.viewSistemaTrocarSenha, "Senhas Não Correspondem!").setVisible(true);
                this.viewSistemaTrocarSenha.getTextFieldNovaSenha1().requestFocus();
            }
        }else {
            new ViewErro(this.viewSistemaTrocarSenha, "Senha Atual Incorreta!").setVisible(true);
            this.viewSistemaTrocarSenha.getTextFieldSenhaAtual().requestFocus();
        }
    }
}