/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 08/08/2015                                                         *
 * Classe: visao.remover.FrameRemoverCliente                                  *
 * Coment: Classe responsavel por representar o Frame de Remocao do Cliente.  *
 *         Subclasse da Classe Abstrata FrameRemover.                         *
 * ========================================================================== */

package visao.remover;

import controllers.ControllerCliente;
import modelo.cadastrais.Cliente;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaCliente;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverCliente extends FrameRemover {
    private final FrameConsultaCliente oFrameConsultaCliente;
    private final Cliente              cliente;
    private final Usuario              usuario;
            
    public FrameRemoverCliente(FrameModal oFrame, Cliente oCliente, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaCliente = (FrameConsultaCliente) oFrame;
        this.cliente               = oCliente;
        this.usuario               = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Cliente");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir o Cliente: " + this.cliente.getNome()+ "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerCliente.remove(this.cliente, this.usuario);
            this.oFrameConsultaCliente.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}