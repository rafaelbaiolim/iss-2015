package visao.editar;

import controller.visao.editar.ControllerViewEditarClienteJuridico;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.ClienteJuridico;
import modelo.dao.complementares.DaoCidade;
import visao.consulta.ViewConsultaCliente;

/**
 * Classe responsavel por definir a Interface de Edicao de Clientes Juridicos no Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   18/11/2015
 * @see     visao.editar.ViewEditar
 */
public final class ViewEditarClienteJuridico extends ViewEditar {
    private       JTextField          jTextFieldCnpj;
    private       JTextField          jTextFieldRazaoSocial;
    private       JTextField          jTextFieldNome;
    private       JTextField          jTextFieldResponsavel;
    private       JTextField          jTextFieldEndereco;
    private       JComboBox           jComboBoxCidade;
    private       JTextField          jTextFieldTelefone;
    private       JTextField          jTextFieldCelular;
    private       JTextField          jTextFieldEmail;
    private final ViewConsultaCliente viewConsultaCliente;
    private final ClienteJuridico     clienteJuridico;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oView
     * @param oClienteJuridico 
     */
    public ViewEditarClienteJuridico(ViewConsultaCliente oView, ClienteJuridico oClienteJuridico) {
        super(oView);
        this.controller          = new ControllerViewEditarClienteJuridico(this);
        this.viewConsultaCliente = oView;
        this.clienteJuridico     = oClienteJuridico;
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Editar Cliente Jurídico");
        this.setSize(520, 525);
        this.setLocation(360, 105);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        super.addHeader("editar_cliente_juridico.jpg");
    }
    
    @Override
    public void addComponents() {
        this.jTextFieldCnpj  = this.createTextField(11);
        this.jTextFieldCnpj.setText(this.clienteJuridico.getDocumento());
        this.add(new JLabel("CNPJ*: "));
        this.add(this.jTextFieldCnpj);
        
        this.jTextFieldRazaoSocial   = this.createTextField(13);
        this.jTextFieldRazaoSocial.setText(this.clienteJuridico.getRazaoSocial());
        this.add(new JLabel("  Razao Social: "));
        this.add(this.jTextFieldRazaoSocial);
        
        this.addLinhas(1);
        
        this.jTextFieldNome = this.createTextField(33);
        this.jTextFieldNome.setText(this.clienteJuridico.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.jTextFieldNome);
        
        this.addLinhas(1);
        
        this.jTextFieldResponsavel = this.createTextField(33);
        this.jTextFieldResponsavel.setText(this.clienteJuridico.getResponsavel());
        this.add(new JLabel("Responsavel*: "));
        this.add(this.jTextFieldResponsavel);
        this.add(new JLabel("            "));
        
        this.addLinhas(1);
        
        this.jTextFieldEndereco = this.createTextField(33);
        this.jTextFieldEndereco.setText(this.clienteJuridico.getEndereco());
        this.add(new JLabel("Endereco: "));
        this.add(this.jTextFieldEndereco);
        this.add(new JLabel("     "));
        
        this.addLinhas(1);
        
        String[] sCidades    = new DaoCidade().getCidades();
        this.jComboBoxCidade = new JComboBox(sCidades);
        this.jComboBoxCidade.addKeyListener(this.controller);
        this.jComboBoxCidade.setSelectedItem(this.clienteJuridico.getCidade().toString());
        this.jComboBoxCidade.setPreferredSize(new Dimension(370, 20));
        this.add(new JLabel("Cidade: "));
        this.add(this.jComboBoxCidade);
        
        this.addLinhas(1);
        
        this.jTextFieldTelefone = this.createTextField(8);
        this.jTextFieldTelefone.setText(this.clienteJuridico.getTelefone());
        this.add(new JLabel("  Fone*: "));
        this.add(this.jTextFieldTelefone);
        
        this.add(new JLabel("                                       "));
        
        this.jTextFieldCelular  = this.createTextField(9);
        this.jTextFieldCelular.setText(this.clienteJuridico.getCelular());
        this.add(new JLabel("Celular: "));
        this.add(this.jTextFieldCelular);
        
        this.addLinhas(1);
        
        this.jTextFieldEmail = this.createTextField(34);
        this.jTextFieldEmail.setText(this.clienteJuridico.getEmail());
        this.add(new JLabel("Email:   "));
        this.add(this.jTextFieldEmail);
        
        this.addLinhas(1);
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

    public ViewConsultaCliente getViewConsultaCliente() {
        return this.viewConsultaCliente;
    }

    public ClienteJuridico getClienteJuridico() {
        return this.clienteJuridico;
    }
}