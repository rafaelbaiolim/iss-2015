package visao.editar;

import controller.visao.editar.ControllerViewEditarUsuario;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.estruturais.Usuario;
import visao.consulta.ViewConsultaUsuario;

/**
 * Classe responsavel por definir a Interface de Edicao de Usuarios no Sistema.
 * @author  Rafael
 * @version 1.0
 * @since   30/10/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarUsuario extends ViewEditar {
    private       JTextField          jTextFieldLogin;
    private       JCheckBox           jCheckBoxAtivo;
    private       JCheckBox           jCheckBoxAdm;
    private final ViewConsultaUsuario viewConsultaUsuario;
    private final Usuario             usuario;

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  30/10/2015
     * @param oView
     * @param oUsuario 
     */
    public ViewEditarUsuario(ViewConsultaUsuario oView, Usuario oUsuario) {
        super(oView);
        this.controller          = new ControllerViewEditarUsuario(this);
        this.viewConsultaUsuario = oView;
        this.usuario             = oUsuario;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Usuário");
        this.setSize(350, 300);
        this.setLocation(420, 220);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_usuario.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldLogin  = this.createTextField(20);
        this.jTextFieldLogin.setText(this.usuario.getLogin());
        this.add(new JLabel("Login*:   "));
        this.add(this.jTextFieldLogin);
        
        this.addLinhas(1);

        this.jCheckBoxAtivo   = new JCheckBox("Ativo?");
        this.jCheckBoxAtivo.addKeyListener(this.controller);
        this.jCheckBoxAtivo.setSelected(this.usuario.isAtivo());
        this.add(this.jCheckBoxAtivo);
        this.jCheckBoxAdm     = new JCheckBox("Administrador?");
        this.jCheckBoxAdm.addKeyListener(this.controller);
        this.jCheckBoxAdm.setSelected(false);
        this.add(this.jCheckBoxAdm);
        
        this.addLinhas(1);
    }

    public JTextField getTextFieldLogin() {
        return this.jTextFieldLogin;
    }

    public JCheckBox getCheckBoxAtivo() {
        return this.jCheckBoxAtivo;
    }

    public JCheckBox getCheckBoxAdm() {
        return this.jCheckBoxAdm;
    }

    public ViewConsultaUsuario getViewConsultaUsuario() {
        return this.viewConsultaUsuario;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
}