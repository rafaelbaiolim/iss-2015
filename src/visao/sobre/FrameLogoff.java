/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.sobre.FrameLogoff                                            *
 * Coment: Classe responsavel por confirmar o Logoff do Sistema.              *
 *         Subclasse da Classe FrameModal.                                    *
 * ========================================================================== */

package visao.sobre;

import controllers.ControllerAcesso;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.estruturais.FrameLogin;
import visao.estruturais.FrameMenu;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameLogoff extends FrameModal {
    private JButton   oButtonYes;
    private JButton   oButtonNo;
    private final FrameMenu oFrameMenu;
    private final Usuario   usuario;
    
    public FrameLogoff(FrameMenu oFrameParent, Usuario oUsuario) {
        super(oFrameParent);
        this.oFrameMenu = oFrameParent;
        this.usuario   = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Logoff");
        this.setSize(280, 220);
        this.setLocation(400, 200);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel(this.createImage("logoff.jpg")));
        this.add(new JLabel("Deseja realmente fazer logoff do Sistema?"));
        
        this.addLine(1);
        
        this.oButtonYes = this.createButton("Sim", "yes.jpg");
        this.oButtonNo  = this.createButton("Nao", "no.jpg");
        this.add(this.oButtonYes);
        this.add(new JLabel("   "));
        this.add(this.oButtonNo);
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.oButtonYes)) {
            ControllerAcesso.registrarLogoff(usuario);
            this.dispose();
            this.oFrameMenu.dispose();
            new FrameLogin().setVisible(true);
        }else if (oEvento.getSource().equals(this.oButtonNo)) {
            this.dispose();
        }
    }
}