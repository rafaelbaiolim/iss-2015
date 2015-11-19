/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.remover.FrameRemover                                         *
 * Coment: Classe responsavel por representar o Frame de Remocao do Sistema.  *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.remover;

import visao.FrameModal;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public abstract class FrameRemover extends FrameModal {
    protected JButton   oButtonYes;
    protected JButton   oButtonNot;

    public FrameRemover(FrameModal oFrame) {
        super(oFrame, "Mercado - Excluir");
        this.initComponents();
    }
    
    private void initComponents() {
        this.setSize(350, 150);
        this.setLocation(410, 220);
    }
    
    protected void addButtons() {
        this.oButtonYes = this.createButton(" Sim ", "yes.jpg");
        this.oButtonNot = this.createButton(" Nao ", "no.jpg");
        
        this.add(this.oButtonYes);
        this.add(this.oButtonNot);
    }

    @Override
    public abstract void actionPerformed(ActionEvent oEvento);
}