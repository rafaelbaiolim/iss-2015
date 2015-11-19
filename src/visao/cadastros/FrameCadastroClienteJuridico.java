/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroClienteJuridico                       *
 * Coment: Classe responsavel pela Frame de Cadastro de Cliente Juridico.     *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerCidade;
import controllers.ControllerCliente;
import factory.FactoryCliente;
import modelo.cadastrais.ClienteJuridico;
import modelo.internos.Usuario;
import visao.Frame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FrameCadastroClienteJuridico extends FrameCadastro {
    private JLabel     oLabelDadosEmpresariais;
    private JLabel     oLabelContato;
    
    private JTextField oTextFieldDocumento;
    private JTextField oTextFieldRazaoSocial;
    
    private JTextField oTextFieldNome;
    
    private JTextField oTextFieldResponsavel;
    
    private JTextField oTextFieldEndereco;
    
    private JTextField oTextFieldCep;
    private JComboBox  oComboBoxCidade;
    
    private JTextField oTextFieldDDD;
    private JTextField oTextFieldNumero;
    private JTextField oTextFieldEmail;
    
    private Usuario    usuario;

    public FrameCadastroClienteJuridico(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Cliente Físico");
        this.setLocation(310, 40);
        this.setSize(500, 670);
        this.addHeader("cadastro_clientejuridico.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oLabelDadosEmpresariais = new JLabel("Dados da Empresa");
        this.oLabelDadosEmpresariais.setFont(new Font("Helvetica", 1, 25));
        this.add(this.oLabelDadosEmpresariais);
        
        this.addLine(1);
        
        this.oTextFieldDocumento         = new JTextField(12);
        this.add(new JLabel("CNPJ*: "));
        this.add(this.oTextFieldDocumento);
        
        this.add(new JLabel("   "));
        
        this.oTextFieldRazaoSocial = new JTextField(15);
        this.add(new JLabel("Razão Social: "));
        this.add(this.oTextFieldRazaoSocial);
        
        this.addLine(1);
        
        this.oTextFieldNome        = new JTextField(37);
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.addLine(1);
        
        this.oTextFieldResponsavel = new JTextField(33);
        this.add(new JLabel("Responsável: "));
        this.add(this.oTextFieldResponsavel);
        
        this.addLine(1);
        
        this.oLabelContato         = new JLabel("Contato");
        this.oLabelContato.setFont(new Font("Helvetica", 1, 25));
        this.add(this.oLabelContato);
        
        this.addLine(1);
        
        this.oTextFieldEndereco       = new JTextField(33);
        this.add(new JLabel("Endereco: "));
        this.add(this.oTextFieldEndereco);
        
        this.addLine(1);
        
        this.oTextFieldCep            = new JTextField(9);
        this.add(new JLabel("      CEP: "));
        this.add(this.oTextFieldCep);
        
        this.add(new JLabel("      "));
        
        String[] sCidades             = ControllerCidade.getCidades();
        this.oComboBoxCidade          = new JComboBox<>(sCidades);
        this.oComboBoxCidade.setPreferredSize(new Dimension(170, 20));
        this.add(new JLabel("Cidade: "));
        this.add(this.oComboBoxCidade);
        
        this.addLine(1);
        
        this.oTextFieldDDD            = new JTextField(2);
        this.oTextFieldNumero         = new JTextField(9);
        this.add(new JLabel("Telefone: "));
        this.add(this.oTextFieldDDD);
        this.add(this.oTextFieldNumero);
        
        this.add(new JLabel("   "));
        
        this.oTextFieldEmail          = new JTextField(15);
        this.add(new JLabel("Email: "));
        this.add(this.oTextFieldEmail);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldDocumento.setText("");
        this.oTextFieldRazaoSocial.setText("");
        
        this.oTextFieldNome.setText("");
        
        this.oTextFieldResponsavel.setText("");
        
        this.oTextFieldEndereco.setText("");
        
        this.oTextFieldCep.setText("");
        this.oComboBoxCidade.setSelectedIndex(0);
        
        this.oTextFieldDDD.setText("");
        this.oTextFieldNumero.setText("");
        this.oTextFieldEmail.setText("");
        
        this.oTextFieldDocumento.requestFocus();
    }

    private boolean checkParameters(String sCnpj, String sNome) {
        if (ControllerCliente.nomeIsAble(sNome) == false) {
            this.oTextFieldNome.requestFocus();
            this.setError("Nome Invalido!");
            return false;
        }else if (ControllerCliente.cnpjIsAble(sCnpj) == false) {
            this.oTextFieldDocumento.requestFocus();
            this.setError("CNPJ Invalido! Digite Apenas Numeros!");
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sCnpj        = this.oTextFieldDocumento.getText().trim();
            String sRazaoSocial = this.oTextFieldRazaoSocial.getText().toUpperCase().trim();
            String sNome        = this.oTextFieldNome.getText().toUpperCase().trim();
            String sResponsavel = this.oTextFieldResponsavel.getText().toUpperCase().trim();
            String sEndereco       = this.oTextFieldEndereco.getText().toUpperCase().trim();
            String sCep            = this.oTextFieldCep.getText().trim();
            String sCidade         = this.oComboBoxCidade.getSelectedItem().toString();
            String sTelefone       = this.oTextFieldDDD.getText().trim() + this.oTextFieldNumero.getText().trim();
            String sEmail          = this.oTextFieldEmail.getText().trim();
            if (this.checkParameters(sCnpj, sNome) == true) {
                if (FactoryCliente.getCliente(sCnpj) instanceof ClienteJuridico) {
                    ControllerCliente.createClienteJuridico(sCnpj, sRazaoSocial, sNome, sResponsavel, sEndereco, sCep, sCidade, sTelefone, sEmail, this.usuario);
                    this.setMessage("Cliente Cadastrado com Sucesso!");
                    this.clear();
                }
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}