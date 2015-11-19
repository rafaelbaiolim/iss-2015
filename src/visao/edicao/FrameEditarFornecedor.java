/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 08/08/2015                                                         *
 * Classe: visao.edicao.FrameEditarFornecedor                                 *
 * Coment: Classe responsavel por representar o Frame de Edicao de Fornecedor.*
 *         Subclasse da Classe Abstrata FrameEditar.                          *
 * ========================================================================== */

package visao.edicao;

import controllers.ControllerFornecedor;
import modelo.gerenciais.Fornecedor;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaFornecedor;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameEditarFornecedor extends FrameEditar {
    private JTextField              oTextFieldNome;
    private JTextField              oTextFieldCNPJ;
    private JTextField              oTextFieldTelefone;
    private FrameConsultaFornecedor oFrameConsultaFornecedor;
    private Fornecedor              fornecedor;
    private Usuario                 usuario;
    

    public FrameEditarFornecedor(FrameModal oFrame, Fornecedor oFornecedor, Usuario oUsuario) {
        super(oFrame, "");
        this.oFrameConsultaFornecedor = (FrameConsultaFornecedor) oFrame;
        this.fornecedor               = oFornecedor;
        this.usuario                  = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Editar Fornecedor");
        this.setLocation(390, 150);
        this.setSize(370, 370);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("editar_fornecedor.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }
    
    private void addBody() {
        this.oTextFieldNome = new JTextField(25);
        this.oTextFieldNome.setText(this.fornecedor.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.addLine(1);
        
        this.oTextFieldCNPJ = new JTextField(10);
        this.oTextFieldCNPJ.setText(this.fornecedor.getCnpj());
        this.add(new JLabel("CNPJ*: "));
        this.add(this.oTextFieldCNPJ);
        
        this.oTextFieldTelefone = new JTextField(10);
        this.oTextFieldTelefone.setText(this.fornecedor.getTelefone());
        this.add(new JLabel("  Fone: "));
        this.add(this.oTextFieldTelefone);
        
        this.addLine(1);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSave)) {
            String sNome     = this.oTextFieldNome.getText().toUpperCase().trim();
            String sCnpj     = this.oTextFieldCNPJ.getText().trim();
            String sTelefone = this.oTextFieldTelefone.getText().trim();
            ControllerFornecedor.gravar(this.fornecedor, sNome, sCnpj, sTelefone, this.usuario);
            this.oFrameConsultaFornecedor.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}