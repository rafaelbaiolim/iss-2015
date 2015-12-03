package visao.sistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.View;
import visao.ViewModal;
import controller.visao.sistema.ControllerViewSistemaSobre;

/**
 * <p>Classe responsavel por definir a Interface de Informacoes sobre o Sistema.</p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * @author  Hadyne
 * @version 1.0
 * @since   09/11/2015
 */
public class ViewSistemaSobre extends ViewModal {
    private JButton buttonOk;

    public ViewSistemaSobre(View oView) {
        super(oView);
        this.controller = new ControllerViewSistemaSobre(this);
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Sobre");
        this.setSize(300, 300);
        this.setLocation(450, 230);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel(new ImageIcon(getClass().getResource("/images/sistema/sobre.jpg"))));
        this.addLinhas(1);
        this.add(new JLabel("Universidade Estadual de Maringá"));
        this.addLinhas(1);
        this.add(new JLabel("Grupo C"));
        this.addLinhas(1);
        this.add(new JLabel("Sistema de Supermercado"));
        this.addLinhas(1);
        this.buttonOk = this.createButton("   Ok   ", "ok.jpg");
        this.add(this.buttonOk);
    }

    public JButton getButtonOk() {
        return this.buttonOk;
    }
}