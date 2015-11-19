/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 05/08/2015                                                         *
 * Classe: visao.Frame                                                        *
 * Coment: Classe de modelo Frame para o Sistema.                             *
 *         Classe abstrata, que deve ser especificada para suas subclasses.   *
 * ========================================================================== */

package visao;

import funcoes.FunctString;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public abstract class Frame extends JFrame implements ActionListener, OperacoesFrame {
    
    public Frame() {
        this.setSettings();
    }

    private void setSettings() {
        this.setTitle("Mercado - Frame");
        this.setSize(750, 500);
        this.setLocation(200, 100);
        this.setIconImage(new ImageIcon(getClass().getResource("/visao/images/icone.jpg")).getImage());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    protected void addLine(int iLines) {
        for (int i = 0; i < iLines; ++i) {
            this.add(new JLabel(FunctString.getEspacos(300)));
            
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
    
     public JMenuItem createMenuItem(String sTitle, String sFile) {
         ImageIcon oImage    = this.createImage("extras/" + sFile);
         JMenuItem oMenuItem = new JMenuItem(sTitle, oImage);
         oMenuItem.addActionListener(this);
         return oMenuItem;
     }
     
    @Override
    public abstract void actionPerformed(ActionEvent oEvento);

    @Override
    public abstract void initComponents();

    @Override
    public abstract void addHeader();

    @Override
    public abstract void addComponents();

    @Override
    public abstract void addButtons();

    @Override
    public abstract void clear();
}