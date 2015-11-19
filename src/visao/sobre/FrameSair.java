/* ========================================================================= /*
 * Grupo.: Hadyne, Leandro, Rafael e Vanessa                                  *
 * Data..: 10/08/2015                                                         *
 * Classe: visao.sobre.FrameSair                                              *
 * Coment: Classe responsavel por confirmar Saida do Sistema.                 *
 *         Subclasse da Classe FrameModal.                                    *
 * ========================================================================== */

package visao.sobre;

import controllers.ControllerAcesso;
import modelo.internos.Usuario;
import visao.FrameModal;
import visao.estruturais.FrameMenu;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameSair extends FrameModal {
    private JButton oButtonYes;
    private JButton oButtonNo;
    private final Usuario usuario;
    
    public FrameSair(FrameMenu oFrameMenu, Usuario oUsuario) {
        super(oFrameMenu);
        this.usuario = oUsuario;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Sair");
        this.setSize(250, 200);
        this.setLocation(400, 200);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLine(1);
        
        this.add(new JLabel(this.createImage("info.jpg")));
        this.add(new JLabel("Deseja realmente sair do Sistema?"));
        
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
            ControllerAcesso.registrarSaida(usuario);
            System.exit(0);
        }else if (oEvento.getSource().equals(this.oButtonNo)) {
            this.dispose();
        }
    }
}