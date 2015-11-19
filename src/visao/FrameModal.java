/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.FrameModal                                                   *
 * Coment: Classe de modelo FrameModal para o Sistema.                        *
 *         Classe abstrata, sendo apenas um modelo para suas subclasses.      *
 * ========================================================================== */

package visao;

import funcoes.FunctString;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public abstract class FrameModal extends JDialog implements ActionListener {
    
    public FrameModal(Frame oFrameParent) {
        super(oFrameParent, true);
        this.initComponents();
    }
    
    public FrameModal(FrameModal oFrame, String sTitle) {
        super(oFrame, sTitle, true);
        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("Frame - Frame Modal");
        this.setLocation(220, 120);
        this.setSize(350, 400);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/visao/images/icone.jpg")).getImage());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    
    protected void addLine(int iLines) {
        for (int i = 0; i < iLines; ++i) {
            this.add(new JLabel(FunctString.getEspacos(200)));
        }
    }

     public ImageIcon createImage(String sFile) {
         return new ImageIcon(getClass().getResource("/visao/images/" + sFile));
     }

     public JButton createButton(String sMessage, String sFile) {
         ImageIcon oImage  = this.createImage(sFile);
         JButton   oButton = new JButton(oImage);
         oButton.setText(sMessage);
         oButton.addActionListener(this);
         return oButton;
     }
    
    @Override
    public abstract void actionPerformed(ActionEvent oEvento);
}