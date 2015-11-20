package visao.cadastro;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import visao.View;
import controller.visao.cadastro.ControllerViewCadastroUsuario;

/**
 * Classe responsavel por definir a Interface de Cadastro de Usuarios no Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   20/10/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroUsuario extends ViewCadastro {
    private JTextField     jTextFieldLogin;
    private JPasswordField jTextFieldSenha1;
    private JPasswordField jTextFieldSenha2;
    private JCheckBox      jCheckBoxAtivo;
    private JCheckBox      jCheckBoxAdm;

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  20/10/2015
     * @param  oView View Parent
     */
    public ViewCadastroUsuario(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroUsuario(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Usuario");
        this.setSize(350, 455);
        this.setLocation(420, 150);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        this.addHeader("cadastro_usuario.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldLogin  = new JTextField(20);
        this.add(new JLabel("Login*:   "));
        this.add(this.jTextFieldLogin);
        
        this.addLinhas(1);
        
        this.jTextFieldSenha1 = new JPasswordField(20);
        this.add(new JLabel("Senha*: "));
        this.add(this.jTextFieldSenha1);
        
        this.addLinhas(1);
        
        this.jTextFieldSenha2 = new JPasswordField(20);
        this.add(new JLabel("Senha*: "));
        this.add(this.jTextFieldSenha2);
        
        this.addLinhas(1);
        
        this.jCheckBoxAtivo   = new JCheckBox("Ativo?");
        this.jCheckBoxAtivo.setSelected(true);
        this.add(this.jCheckBoxAtivo);
        this.jCheckBoxAdm     = new JCheckBox("Administrador?");
        this.add(this.jCheckBoxAdm);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldLogin.setText("");
        this.jTextFieldSenha1.setText("");
        this.jTextFieldSenha2.setText("");
        this.jCheckBoxAtivo.setSelected(true);
        this.jCheckBoxAdm.setSelected(false);
        
        this.jTextFieldLogin.requestFocus();
        this.setMessage("Os campos com (*) sao obrigatorios!");
    }

    public JTextField getTextFieldLogin() {
        return this.jTextFieldLogin;
    }

    public JPasswordField getTextFieldSenha1() {
        return this.jTextFieldSenha1;
    }

    public JPasswordField getTextFieldSenha2() {
        return this.jTextFieldSenha2;
    }

    public JCheckBox getCheckBoxAtivo() {
        return this.jCheckBoxAtivo;
    }

    public JCheckBox getCheckBoxAdm() {
        return this.jCheckBoxAdm;
    }
}