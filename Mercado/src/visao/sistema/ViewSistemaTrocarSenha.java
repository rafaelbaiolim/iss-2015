package visao.sistema;

import controller.visao.sistema.ControllerViewSistemaTrocarSenha;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import modelo.estruturais.Usuario;
import visao.InterfaceView;
import visao.View;
import visao.ViewModal;
import visao.estruturais.ViewMenu;

/**
 * <p>Classe responsavel por definir a Interface da Troca de Senha do Sistema.</p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * @author  Leandro
 * @version 1.0
 * @since   03/11/2015
 */
public final class ViewSistemaTrocarSenha extends ViewModal implements InterfaceView {
    private       JPasswordField jTextFieldSenhaAtual;
    private       JPasswordField jTextFieldNovaSenha1;
    private       JPasswordField jTextFieldNovaSenha2;
    private       JButton buttonYes;
    private       JButton buttonNo;
    private final View    view;
    private final Usuario usuario;

    /**
     * <p>Metodo construtor da classe.</p>
     * <p>Recebe como parametro a ViewMenu.</p>
     * @param oView View Menu.
     */
    public ViewSistemaTrocarSenha(ViewMenu oView) {
        super(oView);
        this.view       = oView;
        this.usuario    = oView.getUsuario();
        this.controller = new ControllerViewSistemaTrocarSenha(this);
        this.initComponents();
    }
    
    @Override
    public void initComponents() {
        this.setTitle("Mercado - Trocar Senha");
        this.setSize(320, 325);
        this.setLocation(440, 220);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addLinhas(1);
        this.add(new JLabel(new ImageIcon(getClass().getResource("/images/sistema/password.jpg"))));
        this.addLinhas(1);
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldSenhaAtual = this.createPasswordField(15);
        this.add(new JLabel("Senha Atual: "));
        this.add(this.jTextFieldSenhaAtual);
        
        this.addLinhas(1);
        
        this.jTextFieldNovaSenha1 = this.createPasswordField(15);
        this.add(new JLabel("Nova Senha:  "));
        this.add(this.jTextFieldNovaSenha1);
        
        this.addLinhas(1);
        
        this.jTextFieldNovaSenha2 = this.createPasswordField(15);
        this.add(new JLabel("Nova Senha:  "));
        this.add(this.jTextFieldNovaSenha2);
        
        this.addLinhas(1);
    }

    @Override
    public void addButtons() {
        this.buttonYes = this.createButton("  Sim  ", "yes.jpg");
        this.buttonNo  = this.createButton("  Não  ", "no.jpg");
        this.add(this.buttonYes);
        this.add(new JLabel("  "));
        this.add(this.buttonNo);
    }

    public JPasswordField getTextFieldSenhaAtual() {
        return this.jTextFieldSenhaAtual;
    }

    public JPasswordField getTextFieldNovaSenha1() {
        return this.jTextFieldNovaSenha1;
    }

    public JPasswordField getTextFieldNovaSenha2() {
        return this.jTextFieldNovaSenha2;
    }
    
    public JButton getButtonYes() {
        return this.buttonYes;
    }

    public JButton getButtonNo() {
        return this.buttonNo;
    }
    
    public View getView() {
        return this.view;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}