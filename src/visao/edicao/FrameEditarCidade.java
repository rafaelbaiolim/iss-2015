/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 06/08/2015                                                         *
 * Classe: visao.edicao.FrameEditarCidade                                     *
 * Coment: Classe responsavel por representar o Frame de Edicao de Cidades.   *
 *         Subclasse da Classe Abstrata FrameEditar.                          *
 * ========================================================================== */

package visao.edicao;

import controllers.ControllerCidade;
import controllers.ControllerUF;
import modelo.estruturais.Cidade;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaCidade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameEditarCidade extends FrameEditar {
    private JTextField          oTextFieldNome;
    private JComboBox           oComboBoxUF;
    private FrameConsultaCidade oFrameConsultaCidade;
    private Cidade              cidade;
    private Usuario             usuario;

    public FrameEditarCidade(FrameModal oFrame, Cidade oCidade, Usuario oUsuario) {
        super(oFrame, "");
        this.oFrameConsultaCidade = (FrameConsultaCidade) oFrame;
        this.cidade               = oCidade;
        this.usuario              = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Editar Cidade");
        this.setLocation(410, 180);
        this.setSize(350, 320);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        this.addHeader("editar_cidade.jpg");
        this.addLine(1);
        this.addBody();
        this.addLine(1);
        this.addButtons();
    }
    
    private void addBody() {
        this.oTextFieldNome = new JTextField(15);
        this.oTextFieldNome.setText(this.cidade.getNome());
        this.add(new JLabel("Nome*: "));
        this.add(this.oTextFieldNome);
        
        this.oComboBoxUF    = new JComboBox(ControllerUF.getSiglas());
        this.oComboBoxUF.setSelectedItem(this.cidade.getUF().getSigla());
        this.oComboBoxUF.setPreferredSize(new Dimension(50, 20));
        this.add(new JLabel("UF*: "));
        this.add(this.oComboBoxUF);
        
        this.addLine(1);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonSave)) {
            String sNome = this.oTextFieldNome.getText().toUpperCase().trim();
            String sUF   = this.oComboBoxUF.getSelectedItem().toString();
            ControllerCidade.gravar(this.cidade, sNome, sUF, this.usuario);
            this.oFrameConsultaCidade.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonBack)) {
            this.dispose();
        }
    }
}