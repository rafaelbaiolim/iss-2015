/* ======================================================================== /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                 *
 * Data..: 10/08/2015                                                        *
 * Classe: visao.remover.FrameRemoverProduto                                 *
 * Coment: Classe responsavel por representar o Frame de Remocao de Produto. *
 *         Subclasse da Classe Abstrata FrameRemover.                        *
 * ========================================================================= */

package visao.remover;

import controllers.ControllerProduto;
import modelo.cadastrais.Produto;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.consultas.FrameConsultaProduto;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrameRemoverProduto extends FrameRemover {
    private final FrameConsultaProduto oFrameConsultaProduto;
    private final Produto              produto;
    private final Usuario              usuario;
            
    public FrameRemoverProduto(FrameModal oFrame, Produto oProduto, Usuario oUsuario) {
        super(oFrame);
        this.oFrameConsultaProduto = (FrameConsultaProduto) oFrame;
        this.produto               = oProduto;
        this.usuario               = oUsuario;
        this.addComponents();
    }

    private void addComponents() {
        this.setTitle("Mercado - Remover Produto");
        this.addLine(1);
        this.add(new JLabel("Deseja excluir o Produto: " + this.produto.getDescricao() + "?"));
        this.addLine(1);
        this.addButtons();
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerProduto.remover(this.produto, this.usuario);
            this.oFrameConsultaProduto.clear();
            this.dispose();
        }else if (oEvento.getSource().equals(this.oButtonNot)) {
            this.dispose();
        }
    }
}