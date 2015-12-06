package visao.estruturais;

import funct.FunctFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import visao.InterfaceView;
import visao.View;
import controller.visao.estruturais.ControllerViewLogin;

/**
 * <p>Classe de Visao <b>ViewLogin</b>.</p>
 * <p>Subclasse da classe abstrata <b>View</b>.</p>
 * <p>Classe responsavel por definir a Interface de Login do Sistema.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   14/10/2015
 */
public final class ViewLogin extends View implements InterfaceView {
    private JTextField     textFieldLogin;
    private JPasswordField textFieldSenha;
    private JButton        buttonOk;
    private JButton        buttonClear;
    private JButton        buttonExit;
    
    /**
     * Metodo construtor padrão da classe.
     */
    public ViewLogin() {
        super();
        this.controller = new ControllerViewLogin(this);
        this.initComponents();
    }
    
    @Override
    public void initComponents() {
        this.setTitle("Mercado - Sistema de Gestão");
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addLinhas(4);
        this.add(new JLabel(new FunctFrame().createImage("logo.jpg")));
        this.addLinhas(3);
    }
    
    @Override
    public void addComponents() {
        this.textFieldLogin = this.createTextField(15);
        this.add(new JLabel("Login:   "));
        this.add(this.textFieldLogin);
        
        this.addLinhas(1);
        
        this.textFieldSenha = this.createPasswordField(15);
        this.add(new JLabel("Senha: "));
        this.add(this.textFieldSenha);
        
        this.addLinhas(1);
    }
    
    @Override
    public void addButtons() {
        this.buttonOk    = this.createButton("   Ok   ", "ok.jpg");
        this.buttonClear = this.createButton(" Limpar ", "clear.jpg");
        this.buttonExit  = this.createButton("  Sair  ", "exit.jpg");
        
        this.add(this.buttonOk);
        this.add(new JLabel("  "));
        this.add(this.buttonClear);
        this.add(new JLabel("  "));
        this.add(this.buttonExit);
    }
    
    /**
     * Metodo responsavel por limpar os campos da View.
     * @since 14/10/2015
     */
    public void clear() {
        this.textFieldLogin.setText("");
        this.textFieldSenha.setText("");
        this.textFieldLogin.requestFocus();
    }

    /**
     * Metodo responsavel por retornar o TextField Login.
     * @return JTextField
     */
    public JTextField getTextFieldLogin() {
        return this.textFieldLogin;
    }

    /**
     * Metodo responsavel por retornar o TextField Senha.
     * @return JPasswordTextField
     */
    public JPasswordField getTextFieldSenha() {
        return this.textFieldSenha;
    }

    /**
     * Metodo responsavel por retornar o Botao Ok.
     * @return JButton
     */
    public JButton getButtonOk() {
        return this.buttonOk;
    }

    /**
     * Metodo responsavel por retornar o Botao Clear.
     * @return JButton
     */
    public JButton getButtonClear() {
        return this.buttonClear;
    }

    /**
     * Metodo responsavel por retornar o Botao Exit.
     * @return JButton
     */
    public JButton getButtonExit() {
        return this.buttonExit;
    }
    
    /**
     * Metodo principal do Projeto.
     * @param args 
     */
    public static void main(String[] args) {
        new ViewLogin().setVisible(true);
    }
}