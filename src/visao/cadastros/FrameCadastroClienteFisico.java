/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 15/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroClienteFisico                         *
 * Coment: Classe responsavel pela Frame de Cadastro de Cliente Fisico.       *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerCidade;
import controllers.ControllerCliente;
import factory.FactoryCliente;
import modelo.cadastrais.ClienteFisico;
import modelo.internos.Usuario;
import visao.Frame;
import funcoes.FunctDate;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class FrameCadastroClienteFisico extends FrameCadastro {
    private JLabel       oLabelDadosPessoais;
    private JLabel       oLabelContato;
    
    private JTextField   oTextFieldDocumento;
    private JTextField   oTextFieldRg;
    
    private JTextField   oTextFieldNome;
    
    private JRadioButton oRadioButtonMasculino;
    private JRadioButton oRadioButtonFeminino;
    private JTextField   oTextFieldDataNascimento;
    
    private JTextField   oTextFieldEndereco;
    
    private JTextField   oTextFieldCep;
    private JComboBox    oComboBoxCidade;
    
    private JTextField   oTextFieldDDD;
    private JTextField   oTextFieldNumero;
    private JTextField   oTextFieldEmail;
    
    private Usuario      usuario;

    public FrameCadastroClienteFisico(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Cliente Físico");
        this.setLocation(310, 40);
        this.setSize(500, 670);
        this.addHeader("cadastro_clientefisico.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oLabelDadosPessoais = new JLabel("DADOS PESSOAIS");
        this.oLabelDadosPessoais.setFont(new Font("Tahoma", 1, 25));
        this.add(this.oLabelDadosPessoais);
        
        this.addLine(1);
        
        this.oTextFieldDocumento = new JTextField(15);
        this.oTextFieldDocumento.setHorizontalAlignment(JTextField.LEFT);
        this.add(new JLabel("CPF*:    "));
        this.add(this.oTextFieldDocumento);
        
        this.add(new JLabel("               "));
        
        this.oTextFieldRg        = new JTextField(10);
        this.oTextFieldRg.setHorizontalAlignment(JTextField.LEFT);
        this.add(new JLabel("RG: "));
        this.add(this.oTextFieldRg);
        
        this.addLine(1);
        
        this.oTextFieldNome      = new JTextField(33);
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.addLine(1);
        
        this.oRadioButtonMasculino = new JRadioButton("Masculino");
        this.oRadioButtonFeminino  = new JRadioButton("Feminino");
        this.add(new JLabel("Sexo: "));
        this.oRadioButtonMasculino.setSelected(true);
        this.oRadioButtonFeminino.setSelected(false);
        this.oRadioButtonMasculino.addActionListener(this);
        this.oRadioButtonFeminino.addActionListener(this);
        this.add(this.oRadioButtonMasculino);
        this.add(this.oRadioButtonFeminino);
        
        this.add(new JLabel("   "));
        
        this.oTextFieldDataNascimento = new JTextField(7);
        this.add(new JLabel("Data Nascimento: "));
        this.oTextFieldDataNascimento.setText(FunctDate.getFormattedDate(new Date()));
        this.add(this.oTextFieldDataNascimento);
        
        this.addLine(1);
        
        this.oLabelContato            = new JLabel("CONTATO");
        this.oLabelContato.setFont(new Font("Tahoma", 1, 25));
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
        this.oComboBoxCidade.setSelectedItem("MARINGA - PR");
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
        this.oTextFieldRg.setText("");
        
        this.oTextFieldNome.setText("");
        
        this.oRadioButtonMasculino.setSelected(true);
        this.oRadioButtonFeminino.setSelected(false);
        
        this.oTextFieldDataNascimento.setText("");
        
        this.oTextFieldEndereco.setText("");
        
        this.oTextFieldCep.setText("");
        this.oComboBoxCidade.setSelectedIndex(0);
        
        this.oTextFieldDDD.setText("");
        this.oTextFieldNumero.setText("");
        this.oTextFieldEmail.setText("");
        
        this.oTextFieldDocumento.requestFocus();
    }

    private boolean checkParameters(String sCpf, String sNome) {
        if (ControllerCliente.nomeIsAble(sNome) == false) {
            this.oTextFieldNome.requestFocus();
            this.setError("Nome Invalido!");
            return false;
        }else if (ControllerCliente.cpfIsAble(sCpf) == false) {
            this.oTextFieldDocumento.requestFocus();
            this.setError("CPF Invalido! Digite Apenas Numeros!");
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oRadioButtonMasculino)) {
            this.oRadioButtonFeminino.setSelected(false);
        }else if (oEvento.getSource().equals(this.oRadioButtonFeminino)) {
            this.oRadioButtonMasculino.setSelected(false);
        }else if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sCpf            = this.oTextFieldDocumento.getText().trim();
            String sRg             = this.oTextFieldNumero.getText().trim();
            String sNome           = this.oTextFieldNome.getText().toUpperCase().trim();
            char   cSexo           = (this.oRadioButtonMasculino.isSelected() == true) ? 'M' : 'F';
            Date   dDataNascimento = FunctDate.createDate(this.oTextFieldDataNascimento.getText().trim());
            String sEndereco       = this.oTextFieldEndereco.getText().toUpperCase().trim();
            String sCep            = this.oTextFieldCep.getText().trim();
            String sCidade         = this.oComboBoxCidade.getSelectedItem().toString();
            String sTelefone       = this.oTextFieldDDD.getText().trim() + this.oTextFieldNumero.getText().trim();
            String sEmail          = this.oTextFieldEmail.getText().trim();
            if (this.checkParameters(sCpf, sNome)) {
                if (FactoryCliente.getCliente(sCpf) instanceof ClienteFisico) {
                    ControllerCliente.createClienteFisico(sCpf, sRg, sNome, cSexo, dDataNascimento, sEndereco, sCep, sCidade, sTelefone, sEmail, this.usuario);
                    this.clear();
                    this.setMessage("Cliente Cadastrado com Sucesso!");
                }
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}