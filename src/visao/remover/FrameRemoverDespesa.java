/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 08/08/2015                                                         *
 * Classe: visao.remover.FrameRemoverDespesa                                  *
 * Coment: Classe responsavel por representar o Frame de Remocao de Despesa.  *
 *         Subclasse da Classe Abstrata FrameRemover.                         *
 * ========================================================================== */

package visao.remover;

import controllers.ControllerDespesa;
import modelo.gerenciais.Despesa;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaDespesa;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverDespesa extends FrameRemover {
    private final FrameConsultaDespesa oFrameConsultaDespesa;
    private final Despesa              despesa;
    private final Usuario              usuario;
            
    public FrameRemoverDespesa(FrameModal oFrame, Despesa oDespesa, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaDespesa = (FrameConsultaDespesa) oFrame;
        this.despesa               = oDespesa;
        this.usuario               = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Despesa");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir a Despesa: " + this.despesa.getDescricao()+ "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerDespesa.remover(this.despesa, this.usuario);
            this.oFrameConsultaDespesa.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}