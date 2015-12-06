package visao.editar;

import controller.visao.editar.ControllerViewEditarClienteFisico;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.cadastrais.ClienteFisico;
import modelo.dao.complementares.DaoCidade;
import visao.consulta.ViewConsultaCliente;

/**
 * Classe responsavel por definir a Interface de Edicao de Clientes Fisicos no Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarClienteFisico extends ViewEditar {
    private       JTextField          jTextFieldCpf;
    private       JTextField          jTextFieldRg;
    private       JTextField          jTextFieldNome;
    private       JRadioButton        jRadioButtonMasculino;
    private       JRadioButton        jRadioButtonFeminino;
    private       JTextField          jTextFieldEndereco;
    private       JComboBox           jComboBoxCidade;
    private       JTextField          jTextFieldTelefone;
    private       JTextField          jTextFieldCelular;
    private       JTextField          jTextFieldEmail;
    private final ViewConsultaCliente viewConsultaCliente;
    private final ClienteFisico       clienteFisico;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oClienteFisico 
     */
    public ViewEditarClienteFisico(ViewConsultaCliente oView, ClienteFisico oClienteFisico) {
        super(oView);
        this.controller          = new ControllerViewEditarClienteFisico(this);
        this.viewConsultaCliente = oView;
        this.clienteFisico       = oClienteFisico;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Cliente Físico");
        this.setSize(400, 530);
        this.setLocation(400, 110);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_cliente_fisico.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldCpf  = this.createTextField(9);
        this.jTextFieldCpf.setText(this.clienteFisico.getDocumento());
        this.add(new JLabel("    CPF*: "));
        this.add(this.jTextFieldCpf);
        
        this.add(new JLabel("                   "));
        
        this.jTextFieldRg   = this.createTextField(8);
        this.jTextFieldRg.setText(this.clienteFisico.getRg());
        this.add(new JLabel("RG: "));
        this.add(this.jTextFieldRg);
        
        this.addLinhas(1);
        
        this.jTextFieldNome = this.createTextField(26);
        this.jTextFieldNome.setText(this.clienteFisico.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jRadioButtonMasculino = this.createRadioButton("Masculino");
        this.jRadioButtonMasculino.setSelected(false);
        if (this.clienteFisico.getSexo() == 'M') this.jRadioButtonMasculino.setSelected(true);
        
        this.jRadioButtonFeminino  = this.createRadioButton("Feminino");
        this.jRadioButtonFeminino.setSelected(false);
        if (this.clienteFisico.getSexo() == 'F') this.jRadioButtonFeminino.setSelected(true);
        
        this.add(new JLabel("Sexo*: "));
        this.add(this.jRadioButtonMasculino);
        this.add(new JLabel("   "));
        this.add(this.jRadioButtonFeminino);
        this.add(new JLabel("                                  "));
        
        this.addLinhas(1);
        
        this.jTextFieldEndereco = this.createTextField(26);
        this.jTextFieldEndereco.setText(this.clienteFisico.getEndereco());
        this.add(new JLabel("Endereco:   "));
        this.add(this.jTextFieldEndereco);
        this.add(new JLabel("    "));
        
        this.addLinhas(1);
        
        String[] sCidades    = new DaoCidade().getCidades();
        this.jComboBoxCidade = new JComboBox(sCidades);
        this.jComboBoxCidade.addKeyListener(this.controller);
        this.jComboBoxCidade.setSelectedItem(this.clienteFisico.getCidade().toString());
        this.jComboBoxCidade.setPreferredSize(new Dimension(290, 20));
        this.add(new JLabel("Cidade: "));
        this.add(this.jComboBoxCidade);
        
        this.addLinhas(1);
        
        this.jTextFieldTelefone = this.createTextField(8);
        this.jTextFieldTelefone.setText(this.clienteFisico.getTelefone());
        this.add(new JLabel("  Fone*: "));
        this.add(this.jTextFieldTelefone);
        
        this.add(new JLabel("           "));
        
        this.jTextFieldCelular  = this.createTextField(9);
        this.jTextFieldCelular.setText(this.clienteFisico.getCelular());
        this.add(new JLabel("Celular: "));
        this.add(this.jTextFieldCelular);
        
        this.addLinhas(1);
        
        this.jTextFieldEmail = this.createTextField(26);
        this.jTextFieldEmail.setText(this.clienteFisico.getEmail());
        this.add(new JLabel("Email:   "));
        this.add(this.jTextFieldEmail);
        
        this.addLinhas(1);
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

    public ViewConsultaCliente getViewConsultaCliente() {
        return this.viewConsultaCliente;
    }
    
    public ClienteFisico getClienteFisico() {
        return this.clienteFisico;
    }
}