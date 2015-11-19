/* ======================================================================== /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                 *
 * Data..: 10/08/2015                                                        *
 * Classe: visao.remover.FrameRemoverUsuario                                 *
 * Coment: Classe responsavel por representar o Frame de Remocao de Usuario. *
 *         Subclasse da Classe Abstrata FrameRemover.                        *
 * ========================================================================= */

package visao.remover;

import controllers.ControllerUsuario;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaUsuario;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverUsuario extends FrameRemover {
    private final FrameConsultaUsuario oFrameConsultaUsuario;
    private final Usuario              usuarioRemove;
    private final Usuario              usuario;
            
    public FrameRemoverUsuario(FrameModal oFrame, Usuario oUsuarioRemove, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaUsuario = (FrameConsultaUsuario) oFrame;
        this.usuarioRemove         = oUsuarioRemove;
        this.usuario               = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Usuario");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir o Usuario: " + this.usuarioRemove.getLogin() + "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerUsuario.remover(this.usuarioRemove, this.usuario);
            this.oFrameConsultaUsuario.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}