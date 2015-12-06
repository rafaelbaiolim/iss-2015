package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroClienteJuridico;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.dao.complementares.DaoCidade;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Clientes Juridicos no Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   10/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroClienteJuridico extends ViewCadastro {
    private JTextField jTextFieldCnpj;
    private JTextField jTextFieldRazaoSocial;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldResponsavel;
    private JTextField jTextFieldEndereco;
    private JComboBox  jComboBoxCidade;
    private JTextField jTextFieldTelefone;
    private JTextField jTextFieldCelular;
    private JTextField jTextFieldEmail;

    public ViewCadastroClienteJuridico(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroClienteJuridico(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Cliente Jurídico");
        this.setSize(520, 585);
        this.setLocation(360, 80);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_cliente_juridico.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldCnpj        = this.createTextField(11);
        this.jTextFieldCnpj.setText("00.000.000/0000-00");
        this.add(new JLabel("CNPJ*: "));
        this.add(this.jTextFieldCnpj);
        
        this.jTextFieldRazaoSocial = this.createTextField(13);
        this.add(new JLabel("  Razao Social: "));
        this.add(this.jTextFieldRazaoSocial);
        
        this.addLinhas(1);
        
        this.jTextFieldNome        = this.createTextField(33);
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldResponsavel = this.createTextField(33);
        this.add(new JLabel("Responsavel*: "));
        this.add(this.jTextFieldResponsavel);
        this.add(new JLabel("            "));
        
        this.addLinhas(1);
        
        this.jTextFieldEndereco    = this.createTextField(33);
        this.add(new JLabel("Endereco: "));
        this.add(this.jTextFieldEndereco);
        this.add(new JLabel("     "));
        
        this.addLinhas(1);
        
        String[] sCidades          = new DaoCidade().getCidades();
        this.jComboBoxCidade       = new JComboBox(sCidades);
        this.jComboBoxCidade.addKeyListener(this.controller);
        this.jComboBoxCidade.setPreferredSize(new Dimension(370, 20));
        this.add(new JLabel("Cidade: "));
        this.add(this.jComboBoxCidade);
        
        this.addLinhas(1);
        
        this.jTextFieldTelefone    = this.createTextField(8);
        this.jTextFieldTelefone.setText("(44)0000-0000");
        this.add(new JLabel("  Fone*: "));
        this.add(this.jTextFieldTelefone);
        
        this.add(new JLabel("                                       "));
        
        this.jTextFieldCelular     = this.createTextField(9);
        this.jTextFieldCelular.setText("(44)0000-0000");
        this.add(new JLabel("Celular: "));
        this.add(this.jTextFieldCelular);
        
        this.addLinhas(1);
        
        this.jTextFieldEmail       = this.createTextField(34);
        this.add(new JLabel("Email:   "));
        this.add(this.jTextFieldEmail);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldCnpj.setText("00.000.000/0000-00");
        this.jTextFieldRazaoSocial.setText("");
        this.jTextFieldNome.setText("");
        this.jTextFieldResponsavel.setText("");
        this.jTextFieldEndereco.setText("");
        this.jComboBoxCidade.setSelectedIndex(0);
        this.jTextFieldTelefone.setText("(44)0000-0000");
        this.jTextFieldCelular.setText("(44)0000-0000");
        this.jTextFieldEmail.setText("");
        
        this.jTextFieldCnpj.requestFocus();
    }

    public JTextField getTextFieldCnpj() {
        return this.jTextFieldCnpj;
    }

    public JTextField getTextFieldRazaoSocial() {
        return this.jTextFieldRazaoSocial;
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JTextField getTextFieldResponsavel() {
        return this.jTextFieldResponsavel;
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