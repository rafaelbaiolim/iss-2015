/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 12/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastroCidade                                *
 * Coment: Classe responsavel pela Frame de Cadastro de Cidade.               *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.cadastros;

import controllers.ControllerCidade;
import controllers.ControllerUF;
import modelo.internos.Usuario;
import visao.Frame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class FrameCadastroCidade extends FrameCadastro {
    private JTextField oTextFieldNome;
    
    private JComboBox  oComboBoxUF;
    
    private Usuario    usuario;

    public FrameCadastroCidade(Frame oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.usuario = oUsuario;
        this.initComponents();
    }

    @Override
    protected void initComponents() {
        this.setTitle("Mercado - Cadastro de Cidade");
        this.setLocation(400, 200);
        this.setSize(350, 310);
        this.addHeader("cadastro_cidade.jpg");
        this.setInitialMessage("Os Campos (*) sao Obrigatorios");
        this.addComponents();
        this.addButtons();
    }

    @Override
    protected void addComponents() {
        this.oTextFieldNome = new JTextField(15);
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.oComboBoxUF    = new JComboBox(ControllerUF.getSiglas());
        this.oComboBoxUF.setPreferredSize(new Dimension(50, 20));
        this.add(new JLabel("UF*: "));
        this.add(this.oComboBoxUF);
        
        this.addLine(1);
    }

    @Override
    protected void clear() {
        this.oTextFieldNome.setText("");
        
        this.oComboBoxUF.setSelectedIndex(0);
        
        this.oTextFieldNome.requestFocus();
    }
    
    private boolean checkParameters(String sNome, String sUF) {
        if (ControllerCidade.nomeIsAble(sNome) == false) {
            this.setError("Nome Inválido!");
            return false;
        }else if (ControllerCidade.checkCidade(sNome, sUF) == false) {
            this.setError("Cidade ja Cadastrada!");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonAdd)) {
            String sNome = this.oTextFieldNome.getText().toUpperCase().trim();
            String sUF   = this.oComboBoxUF.getSelectedItem().toString();
            if (this.checkParameters(sNome, sUF)) {
                ControllerCidade.adicionar(sNome, sUF, this.usuario);
                this.setMessage("Cidade Cadastrada com Sucesso!");
                this.clear();
            }
        }else if (oEvento.getSource().equals(this.oButtonClear)) {
            this.clear();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}