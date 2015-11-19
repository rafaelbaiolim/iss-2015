/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 06/08/2015                                                         *
 * Classe: visao.estruturais.FrameLogin                                       *
 * Coment: Classe de Interface com o Usuario.                                 *
 *         Classe responsavel pelo Frame de apresentacao do Sistema.          *
 * ========================================================================== */

package visao.estruturais;

import controllers.ControllerAcesso;
import controllers.ControllerUsuario;
import modelo.internos.Usuario;
import visao.Frame;
import funcoes.FunctString;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class FrameLogin extends Frame {
    private JTextField     oTextFieldLogin;
    
    private JPasswordField oTextFieldSenha;
    
    private JButton        oButtonOk;
    private JButton        oButtonClear;
    private JButton        oButtonExit;
    
    public FrameLogin() {
        super();
        this.initComponents();
    }
    
    @Override
    public void initComponents() {
        this.setTitle("Mercado - Login");
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addLine(3);
        this.add(new JLabel(new ImageIcon(getClass().getResource("/visao/images/logo.jpg"))));
        this.addLine(1);
    }
    
    @Override
    public void addComponents() {
        this.oTextFieldLogin = new JTextField(15);
        this.add(new JLabel("Login:   "));
        this.add(this.oTextFieldLogin);
        
        this.addLine(1);
        
        this.oTextFieldSenha = new JPasswordField(15);
        this.add(new JLabel("Senha: "));
        this.add(this.oTextFieldSenha);
        
        this.addLine(1);
    }
    
    @Override
    public void addButtons() {
        this.oButtonOk    = this.createButton("   Ok   ", "ok.jpg");
        this.oButtonClear = this.createButton(" Limpar ", "clear.jpg");
        this.oButtonExit  = this.createButton("  Sair  ", "exit.jpg");
        
        this.add(this.oButtonOk);
        this.add(new JLabel("  "));
        this.add(this.oButtonClear);
        this.add(new JLabel("  "));
        this.add(this.oButtonExit);
    }
    
    @Override
    public void clear() {
        this.oTextFieldLogin.setText("");
        this.oTextFieldSenha.setText("");
        
        this.oTextFieldLogin.requestFocus();
    }
    
    private boolean checkParameters(String sLogin, String sSenha, Usuario oUsuario) {
        if (oUsuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario Nao Encontrado!");
            this.oTextFieldLogin.requestFocus();
            return false;
        }else if (oUsuario.getSenha().equals(sSenha) == false) {
            JOptionPane.showMessageDialog(null, "Senha Invalida!");
            this.oTextFieldSenha.requestFocus();
            return false;
        }else if (oUsuario.isAtivo() == false) {
            JOptionPane.showMessageDialog(null, "Usuario Bloqueado - Consulte o Gerente!");
            this.oTextFieldLogin.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonOk)) {
            String  sLogin   = this.oTextFieldLogin.getText();
            String  sSenha   = FunctString.md5(this.oTextFieldSenha.getText());
            Usuario oUsuario = ControllerUsuario.getUsuario(sLogin);
            if (this.checkParameters(sLogin, sSenha, oUsuario)) {
                ControllerAcesso.registrarAcesso(oUsuario);
                new FrameMenu(oUsuario).setVisible(true);
                this.dispose();
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonExit)) {
            this.dispose();
        }
    }
    
    public static void main(String[] args) {
        new FrameLogin().setVisible(true);
    }
}