/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.edicao.FrameEditar                                           *
 * Coment: Classe responsavel por representar o Frame de Edicao do Sistema.   *
 *         Subclasse da Classe Abstrata FrameModal.                           *
 * ========================================================================== */

package visao.edicao;

import visao.FrameModal;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class FrameEditar extends FrameModal {
    private   JLabel  oLabelLogo;
    
    protected JButton oButtonSave;
    protected JButton oButtonBack;
    
    public FrameEditar(FrameModal oFrame, String sTitle) {
        super(oFrame, sTitle);
        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("Mercado - Editar");
        this.setSize(200, 200);
        this.setLocation(400, 130);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    protected void addHeader(String sFile) {
        this.addLine(1);
        this.oLabelLogo = new JLabel(this.createImage("edicoes/" + sFile));
        this.add(this.oLabelLogo);
        this.addLine(1);
    }
    
    protected void addButtons() {
        this.oButtonSave = this.createButton(" Salvar ", "save.jpg");
        this.oButtonBack = this.createButton("Cancelar", "exit.jpg");
        
        this.add(this.oButtonSave);
        this.add(this.oButtonBack);
    }

    @Override
    public abstract void actionPerformed(ActionEvent oEvento);
}