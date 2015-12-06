package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroClienteFisico;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.dao.complementares.DaoCidade;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Clientes Fisicos no Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   10/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroClienteFisico extends ViewCadastro {
    private JTextField   jTextFieldCpf;
    private JTextField   jTextFieldRg;
    private JTextField   jTextFieldNome;
    private JRadioButton jRadioButtonMasculino;
    private JRadioButton jRadioButtonFeminino;
    private JTextField   jTextFieldEndereco;
    private JComboBox    jComboBoxCidade;
    private JTextField   jTextFieldTelefone;
    private JTextField   jTextFieldCelular;
    private JTextField   jTextFieldEmail;

    public ViewCadastroClienteFisico(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroClienteFisico(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Cliente Físico");
        this.setSize(400, 590);
        this.setLocation(400, 80);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_cliente_fisico.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldCpf  = this.createTextField(9);
        this.jTextFieldCpf.setText("000.000.000-00");
        this.add(new JLabel("    CPF*: "));
        this.add(this.jTextFieldCpf);
        
        this.add(new JLabel("                   "));
        
        this.jTextFieldRg   = this.createTextField(8);
        this.add(new JLabel("RG: "));
        this.add(this.jTextFieldRg);
        
        this.addLinhas(1);
        
        this.jTextFieldNome = this.createTextField(26);
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jRadioButtonMasculino = this.createRadioButton("Masculino");
        this.jRadioButtonMasculino.setSelected(true);
        this.jRadioButtonFeminino  = this.createRadioButton("Feminino");
        this.jRadioButtonFeminino.setSelected(false);
        this.add(new JLabel("Sexo*: "));
        this.add(this.jRadioButtonMasculino);
        this.add(new JLabel("   "));
        this.add(this.jRadioButtonFeminino);
        this.add(new JLabel("                                  "));
        
        this.addLinhas(1);
        
        this.jTextFieldEndereco = this.createTextField(26);
        this.add(new JLabel("Endereco:   "));
        this.add(this.jTextFieldEndereco);
        this.add(new JLabel("    "));
        
        this.addLinhas(1);
        
        String[] sCidades    = new DaoCidade().getCidades();
        this.jComboBoxCidade = new JComboBox(sCidades);
        this.jComboBoxCidade.addKeyListener(this.controller);
        this.jComboBoxCidade.setPreferredSize(new Dimension(290, 20));
        this.add(new JLabel("Cidade: "));
        this.add(this.jComboBoxCidade);
        
        this.addLinhas(1);
        
        this.jTextFieldTelefone = this.createTextField(8);
        this.jTextFieldTelefone.setText("(44)0000-0000");
        this.add(new JLabel("  Fone*: "));
        this.add(this.jTextFieldTelefone);
        
        this.add(new JLabel("           "));
        
        this.jTextFieldCelular  = this.createTextField(9);
        this.jTextFieldCelular.setText("(44)0000-0000");
        this.add(new JLabel("Celular: "));
        this.add(this.jTextFieldCelular);
        
        this.addLinhas(1);
        
        this.jTextFieldEmail = this.createTextField(26);
        this.add(new JLabel("Email:   "));
        this.add(this.jTextFieldEmail);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldCpf.setText("000.000.000-00");
        this.jTextFieldRg.setText("");
        this.jTextFieldNome.setText("");
        this.jRadioButtonMasculino.setSelected(true);
        this.jRadioButtonFeminino.setSelected(false);
        this.jTextFieldEndereco.setText("");
        this.jComboBoxCidade.setSelectedIndex(0);
        this.jTextFieldTelefone.setText("(44)0000-0000");
        this.jTextFieldCelular.setText("(44)0000-0000");
        this.jTextFieldEmail.setText("");
        
        this.jTextFieldCpf.requestFocus();
    }

    public JTextField getTextFieldCpf() {
        return this.jTextFieldCpf;
    }

    public JTextField getTextFieldRg() {
        return this.jTextFieldRg;
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JRadioButton getRadioButtonMasculino() {
        return this.jRadioButtonMasculino;
    }

    public JRadioButton getRadioButtonFeminino() {
        return this.jRadioButtonFeminino;
    }

    public JTextField getTextFieldEndereco() {
        return this.jTextFieldEndereco;
    }

    public JComboBox getComboBoxCidade() {
        return this.jComboBoxCidade;
    }

    public JTextField getTextFieldTelefone() {
        return this.jTextFieldTelefone;
    }

    public JTextField getTextFieldCelular() {
        return this.jTextFieldCelular;
    }

    public JTextField getTextFieldEmail() {
        return this.jTextFieldEmail;
    }
}