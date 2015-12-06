package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroMarca;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Marcas no Sistema.
 * @author  Vanessa
 * @version 1.0
 * @since   10/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroMarca extends ViewCadastro {
    private JTextField jTextFieldNome;
    private JTextField jTextFieldSigla;

    public ViewCadastroMarca(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroMarca(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Marca");
        this.setSize(370, 360);
        this.setLocation(410, 185);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_marca.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldNome     = this.createTextField(27);
        this.add(new JLabel("Nome*:  "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldSigla     = this.createTextField(10);
        this.jTextFieldSigla.setText("");
        this.add(new JLabel("Sigla*: "));
        this.add(this.jTextFieldSigla);
        
        this.add(new JLabel("                              "));
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldNome.setText("");
        this.jTextFieldSigla.setText("");
        
        this.jTextFieldNome.requestFocus();
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JTextField getTextFieldSigla() {
        return this.jTextFieldSigla;
    }
}