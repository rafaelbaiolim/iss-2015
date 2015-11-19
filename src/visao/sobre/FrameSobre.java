/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.sobre.FrameSobre                                             *
 * Coment: Classe responsavel por apresentar o Frame com informacoes sobre o  *
 *         Sistema.                                                           *
 *         Subclasse da Classe FrameModal.                                    *
 * ========================================================================== */

package visao.sobre;

import visao.FrameModal;
import visao.estruturais.FrameMenu;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameSobre extends FrameModal {
    private JButton oButtonOk;
    
    public FrameSobre(FrameMenu oFrameMenu) {
        super(oFrameMenu);
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Sobre");
        this.setSize(300, 500);
        this.setLocation(400, 100);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.addHeader();
        this.addComponents();
    }
    
    private void addHeader() {
        this.addLine(1);
        this.add(new JLabel(this.createImage("/utilitarios/sobre.jpg")));
        this.addLine(1);
    }
    
    private void addComponents() {
        this.add(new JLabel("Sistema de Mercado"));
        this.addLine(1);
        this.add(new JLabel("Alunos:"));
        this.addLine(1);
        this.add(new JLabel("Hadyne Biazoto"));
        this.addLine(1);
        this.add(new JLabel("Leandro Flores"));
        this.addLine(1);
        this.add(new JLabel("Rafael Altar"));
        this.addLine(1);
        this.add(new JLabel("Vanessa Nakahara"));
        this.addLine(1);
        this.add(new JLabel("Versao: 1.0"));
        this.addLine(1);
        this.oButtonOk = this.createButton("  Ok  ", "ok.jpg");
        this.add(this.oButtonOk);
    }
    
    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonOk)) {
            this.dispose();
        }
    }
}