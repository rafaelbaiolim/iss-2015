package visao.cadastro;

import controller.modelo.complementares.ControllerUF;
import controller.visao.cadastro.ControllerViewCadastroCidade;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Cidades no Sistema.
 * @author  Leandro
 * @version 1.0
 * @since   09/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroCidade extends ViewCadastro {
    private JTextField jTextFieldNome;
    private JComboBox  jComboBoxUF;

    public ViewCadastroCidade(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroCidade(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Cidade");
        this.setSize(350, 310);
        this.setLocation(420, 220);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        this.addHeader("cadastro_cidade.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldNome = this.createTextField(15);
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.jComboBoxUF    = new JComboBox(new ControllerUF().getSiglas());
        this.jComboBoxUF.addKeyListener(this.controller);
        this.jComboBoxUF.setPreferredSize(new Dimension(50, 20));
        this.add(new JLabel("UF*: "));
        this.add(this.jComboBoxUF);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldNome.setText("");
        this.jComboBoxUF.setSelectedIndex(0);
        
        this.jTextFieldNome.requestFocus();
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JComboBox getComboBoxUF() {
        return this.jComboBoxUF;
    }
}