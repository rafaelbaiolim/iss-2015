/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.cadastros.FrameCadastro                                      *
 * Coment: Classe Abstrata FrameCadastro.                                     *
 *         Classe usada como modelo para os Frames de Cadastro do Sistema.    *
 *         Subaclasse da Classe Abstrata FrameModal.                          *
 * ========================================================================== */

package visao.cadastros;

import visao.Frame;
import visao.FrameModal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class FrameCadastro extends FrameModal {
    protected JLabel oLabelLogo;
    protected JLabel oLabelMessage;
    
    protected JButton oButtonAdd;
    protected JButton oButtonClear;
    protected JButton oButtonBack;
    
    public FrameCadastro(Frame oFrameParent) {
        super(oFrameParent);
    }
    
    protected void addHeader(String sFile) {
        this.addLine(1);
        this.oLabelLogo = new JLabel(this.createImage("headers/" + sFile));
        this.add(this.oLabelLogo);
        this.addLine(1);
        this.oLabelMessage = new JLabel();
        this.add(this.oLabelMessage);
        this.addLine(1);
    }
    
    protected void setError(String sMessage) {
        this.oLabelMessage.setText(sMessage);
        this.oLabelMessage.setForeground(Color.red);
    }

    protected void setMessage(String sMessage) {
        this.oLabelMessage.setText(sMessage);
        this.oLabelMessage.setForeground(Color.blue);
    }
    
    protected void setInitialMessage(String sMessage) {
        this.oLabelMessage.setText(sMessage);
        this.oLabelMessage.setForeground(Color.black);
    }

    protected void addButtons() {
        this.oButtonAdd   = this.createButton(" Inserir ", "add.jpg");
        this.oButtonClear = this.createButton("  Limpar ", "clear.jpg");
        this.oButtonBack  = this.createButton("  Voltar ", "back.jpg");
        
        this.add(this.oButtonAdd);
        this.add(this.oButtonClear);
        this.add(this.oButtonBack);
    }
    
    protected abstract void initComponents();
    
    protected abstract void addComponents();
    
    protected abstract void clear();
    
    @Override
    public abstract void actionPerformed(ActionEvent oEvento);
}