/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 06/08/2015                                                         *
 * Classe: visao.remover.FrameRemoverCidade                                   *
 * Coment: Classe responsavel por representar o Frame de Remocao da Cidade.   *
 *         Subclasse da Classe Abstrata FrameRemover.                         *
 * ========================================================================== */

package visao.remover;

import controllers.ControllerCidade;
import modelo.estruturais.Cidade;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaCidade;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverCidade extends FrameRemover {
    private final FrameConsultaCidade oFrameConsultaCidade;    
    private final Cidade              cidade;
    private final Usuario             usuario;
            
    public FrameRemoverCidade(FrameModal oFrame, Cidade oCidade, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaCidade = (FrameConsultaCidade) oFrame;
        this.cidade               = oCidade;
        this.usuario              = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Cidade");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir a Cidade: " + this.cidade + "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerCidade.remover(this.cidade, this.usuario);
            this.oFrameConsultaCidade.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}