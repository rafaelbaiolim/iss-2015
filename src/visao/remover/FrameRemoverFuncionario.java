/* ========================================================================== /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                   *
 * Data..: 09/08/2015                                                          *
 * Classe: visao.remover.FrameRemoverFuncionario                               *
 * Coment: Classe responsavel por representar o Frame de Remocao do Funcionario*
 *         Subclasse da Classe Abstrata FrameRemover.                          *
 * =========================================================================== */

package visao.remover;

import controllers.ControllerFuncionario;
import modelo.gerenciais.Funcionario;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaFuncionario;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverFuncionario extends FrameRemover {
    private final FrameConsultaFuncionario oFrameConsultaFuncionario;
    private final Funcionario              funcionario;
    private final Usuario                  usuario;
            
    public FrameRemoverFuncionario(FrameModal oFrame, Funcionario oFuncionario, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaFuncionario = (FrameConsultaFuncionario) oFrame;
        this.funcionario               = oFuncionario;
        this.usuario                   = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Funcionario");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir o Funcionario: " + this.funcionario.getNome() + "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerFuncionario.remover(this.funcionario, this.usuario);
            this.oFrameConsultaFuncionario.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}