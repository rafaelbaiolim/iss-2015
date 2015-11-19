/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 18/08/2015                                                         *
 * Classe: visao.mensagens.FrameMensagem                        *
 * Coment: Classe responsavel por representar o Frame de Confirmacao de Pedido*
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.mensagens;

import visao.FrameModal;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameMensagem extends FrameModal {
    private JLabel  oLabelImagem;
    private String  mensagem;
    private JButton oButtonOk;

    public FrameMensagem(FrameModal oFrame, String sMensagem) {
        super(oFrame, "Mercado");
        this.mensagem = sMensagem;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Mensagem");
        this.setSize(300, 150);
        this.setLocation(390, 220);
        this.addComponents();
    }
    
    private void addComponents() {
        this.oLabelImagem = new JLabel(this.createImage("yes.jpg"));
        this.oButtonOk    = this.createButton(" Ok ", "ok.jpg");
        this.addLine(1);
        this.add(this.oLabelImagem);
        this.add(new JLabel(this.mensagem));
        this.addLine(1);
        this.add(this.oButtonOk);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonOk)) {
            this.dispose();
        }
    }
}