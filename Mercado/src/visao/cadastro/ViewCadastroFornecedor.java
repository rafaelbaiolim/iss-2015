package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroFornecedor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Fornecedores no Sistema.
 * @author  Vanessa Nakahara
 * @version 1.0
 * @since   10/11/2015
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroFornecedor extends ViewCadastro {
    private JTextField jTextFieldNome;
    private JTextField jTextFieldCNPJ;
    private JTextField jTextFieldTelefone;

    public ViewCadastroFornecedor(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroFornecedor(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Fornecedor");
        this.setSize(370, 360);
        this.setLocation(410, 185);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_fornecedor.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldNome     = this.createTextField(27);
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldCNPJ     = this.createTextField(10);
        this.jTextFieldCNPJ.setText("00.000.000/0000-00");
        this.add(new JLabel("CNPJ*: "));
        this.add(this.jTextFieldCNPJ);
        
        this.jTextFieldTelefone = this.createTextField(10);
        this.add(new JLabel("  Telefone: "));
        this.add(this.jTextFieldTelefone);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldNome.setText("");
        this.jTextFieldCNPJ.setText("");
        this.jTextFieldTelefone.setText("");
        
        this.jTextFieldNome.requestFocus();
    }

    public JTextField getTextFieldNome() {
        return this.jTextFieldNome;
    }

    public JTextField getTextFieldCNPJ() {
        return this.jTextFieldCNPJ;
    }

    public JTextField getTextFieldTelefone() {
        return this.jTextFieldTelefone;
    }
}