/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 24/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroFornecedor                            *
 * Coment: Classe responsavel pela Frame de Cadastro de Fornecedor.           *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerFornecedor;
import modelo.internos.Usuario;
import visao.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FrameCadastroFornecedor extends FrameCadastro {
    private JTextField oTextFieldNome;
    
    private JTextField oTextFieldCNPJ;
    private JTextField oTextFieldTelefone;
    
    private Usuario    usuario;

    public FrameCadastroFornecedor(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Fornecedor");
        this.setLocation(390, 160);
        this.setSize(370, 370);
        this.addHeader("cadastro_fornecedor.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oTextFieldNome = new JTextField(25);
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.addLine(1);
        
        this.oTextFieldCNPJ = new JTextField(10);
        this.add(new JLabel("CNPJ*: "));
        this.add(this.oTextFieldCNPJ);
        
        this.oTextFieldTelefone = new JTextField(10);
        this.add(new JLabel("  Fone: "));
        this.add(this.oTextFieldTelefone);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldNome.setText("");
        this.oTextFieldCNPJ.setText("");
        this.oTextFieldTelefone.setText("");
        
        this.oTextFieldNome.requestFocus();
    }

    public boolean checkParameters(String sNome, String sCnpj, String sTelefone) {
        if (ControllerFornecedor.nomeIsAble(sNome) == false) {
            this.setError("Nome deve ter no minimo 4 caracteres!");
            this.oTextFieldNome.requestFocus();
            return false;
        }else if (ControllerFornecedor.checkNome(sNome) == false) {
            this.setError("Nome de Fornecedor ja Cadastrado!");
            this.oTextFieldNome.requestFocus();
            return false;
        }else if (ControllerFornecedor.cnpjIsAble(sCnpj) == false) {
            this.setError("CNPJ Invalido! Digite apenas numeros");
            this.oTextFieldCNPJ.requestFocus();
            return false;
        }else if (ControllerFornecedor.checkCnpj(sCnpj) == false) {
            this.setError("CNPJ de Fornecedor ja Cadastrado!");
            this.oTextFieldCNPJ.requestFocus();
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sNome     = this.oTextFieldNome.getText().toUpperCase().trim();
            String sCnpj     = this.oTextFieldCNPJ.getText().toUpperCase().trim();
            String sTelefone = this.oTextFieldTelefone.getText().toUpperCase().trim();
            if (this.checkParameters(sNome, sCnpj, sTelefone)) {
                ControllerFornecedor.adicionar(sNome, sCnpj, sTelefone, this.usuario);
                this.setMessage("Fornecedor Cadastrado com Sucesso!");
                this.clear();
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}