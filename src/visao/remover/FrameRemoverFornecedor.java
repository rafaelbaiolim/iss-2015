/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.remover.FrameRemoverFornecedor                               *
 * Coment: Classe responsavel por representar o Frame de Remocao de Fornecedor*
 *         Subclasse da Classe Abstrata FrameRemover.                         *
 * ========================================================================== */

package visao.remover;

import controllers.ControllerFornecedor;
import modelo.gerenciais.Fornecedor;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaFornecedor;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverFornecedor extends FrameRemover {
    private final FrameConsultaFornecedor oFrameConsultaFornecedor;
    private final Fornecedor              fornecedor;
    private final Usuario                 usuario;
            
    public FrameRemoverFornecedor(FrameModal oFrame, Fornecedor oFornecedor, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaFornecedor = (FrameConsultaFornecedor) oFrame;
        this.fornecedor               = oFornecedor;
        this.usuario                  = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Fornecedor");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir o Fornecedor: " + this.fornecedor.getNome() + "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerFornecedor.remover(this.fornecedor, this.usuario);
            this.oFrameConsultaFornecedor.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}