/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 20/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroUsuario                               *
 * Coment: Classe responsavel pela Frame de Cadastro de Usuario.              *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerUsuario;
import modelo.gerenciais.Funcionario;
import modelo.internos.Usuario;
import visao.Frame;
import visao.pesquisa.FramePesquisarFuncionario;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class FrameCadastroUsuario extends FrameCadastro {
    private JTextField     oTextFieldLogin;
    
    private JPasswordField oTextFieldSenha1;
    private JPasswordField oTextFieldSenha2;
    
    private JCheckBox      oCheckBoxAtivo;
    private JCheckBox      oCheckBoxAdm;
    
    private JTextField     oTextFieldFuncionario;
    private JButton        oButtonSearchFuncionario;
    
    private Funcionario    funcionario;
    private Usuario        usuario;

    public FrameCadastroUsuario(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario     = oUsuario;
        this.funcionario = null;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Usuário");
        this.setLocation(400, 100);
        this.setSize(350, 500);
        this.addHeader("cadastro_usuario.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oTextFieldLogin = new JTextField(20);
        this.add(new JLabel("Login*:   "));
        this.add(this.oTextFieldLogin);
        
        this.addLine(1);
        
        this.oTextFieldSenha1 = new JPasswordField(20);
        this.add(new JLabel("Senha*: "));
        this.add(this.oTextFieldSenha1);
        
        this.addLine(1);
        
        this.oTextFieldSenha2 = new JPasswordField(20);
        this.add(new JLabel("Senha*: "));
        this.add(this.oTextFieldSenha2);
        
        this.addLine(1);
        
        this.oTextFieldFuncionario    = new JTextField(19);
        this.oTextFieldFuncionario.setEditable(false);
        this.add(new JLabel("Funcionário: "));
        this.add(this.oTextFieldFuncionario);
        this.oButtonSearchFuncionario = this.createButton("", "search.jpg");
        this.oButtonSearchFuncionario.setPreferredSize(new Dimension(30, 20));
        this.add(this.oButtonSearchFuncionario);
        
        this.addLine(1);
        
        this.oCheckBoxAdm   = new JCheckBox("Administrador?");
        this.oCheckBoxAtivo = new JCheckBox("Ativo?");
        this.oCheckBoxAtivo.setSelected(true);
        this.add(this.oCheckBoxAdm);
        this.add(new JLabel("     "));
        this.add(this.oCheckBoxAtivo);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldLogin.setText("");
        
        this.oTextFieldSenha1.setText("");
        this.oTextFieldSenha2.setText("");
        
        this.oTextFieldFuncionario.setText("");
        
        this.oCheckBoxAdm.setSelected(false);
        this.oCheckBoxAtivo.setSelected(true);
        
        this.oTextFieldLogin.requestFocus();
    }
    
    public void setFuncionario(Funcionario oFuncionario) {
        this.funcionario = oFuncionario;
        this.oTextFieldFuncionario.setText(this.funcionario.toString());
    }

    private boolean checkParameters(String sLogin, String sSenha1, String sSenha2) {
        if (ControllerUsuario.checkLogin(sLogin) == false) {
            this.setError("Login Invalido!");
            this.oTextFieldLogin.requestFocus();
            return false;
        }else if (ControllerUsuario.loginIsAble(sLogin) == false) {
            this.setError("Login ja Cadastrado!");
            this.oTextFieldLogin.requestFocus();
            return false;
        }else if (sSenha1.equals("") == true) {
            this.setError("Senha Invalida!");
            this.oTextFieldSenha1.requestFocus();
            return false;
        }else if (sSenha1.equals(sSenha2) == false) {
            this.setError("Senhas Nao Correspondem!");
            this.oTextFieldSenha1.requestFocus();
            return false;
        }else if (this.funcionario == null) {
            this.setError("Selecione um Funcionario!");
            this.oTextFieldFuncionario.requestFocus();
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSearchFuncionario)) {
            new FramePesquisarFuncionario(this).setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonAdd)) {
            String  sLogin  = this.oTextFieldLogin.getText().toLowerCase().trim();
            String  sSenha1 = this.oTextFieldSenha1.getText();
            String  sSenha2 = this.oTextFieldSenha2.getText();
            boolean bAtivo  = this.oCheckBoxAtivo.isSelected();
            boolean bAdm    = this.oCheckBoxAdm.isSelected();
            if (this.checkParameters(sLogin, sSenha1, sSenha2) == true) {
                ControllerUsuario.adicionar(sLogin, sSenha1, bAdm, this.funcionario, this.usuario);
                this.setMessage("Usuario Cadastrado com Sucesso!");
                this.clear();
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}