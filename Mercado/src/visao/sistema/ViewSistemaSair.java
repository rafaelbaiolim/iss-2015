package visao.sistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.View;
import visao.ViewModal;
import controller.visao.sistema.ControllerViewSistemaSair;

/**
 * <p>Classe responsavel por definir a Interface de Saida do Sistema.</p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * @author  Vanessa
 * @version 1.0
 * @since   09/11/2015
 */
public class ViewSistemaSair extends ViewModal {
    private       JButton buttonYes;
    private       JButton buttonNo;
    private final View    view;

    public ViewSistemaSair(View oView) {
        super(oView);
        this.view = oView;
        this.controller = new ControllerViewSistemaSair(this);
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Sair");
        this.setSize(300, 225);
        this.setLocation(450, 270);
        this.addComponents();
    }
    
    private void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel(new ImageIcon(getClass().getResource("/images/sistema/sair.jpg"))));
        this.addLinhas(1);
        this.add(new JLabel("Deseja realmente Sair do Sistema?"));
        this.addLinhas(1);
        this.buttonYes = this.createButton("  Sim  ", "yes.jpg");
        this.buttonNo  = this.createButton("  Não  ", "no.jpg");
        this.add(this.buttonYes);
        this.add(new JLabel("  "));
        this.add(this.buttonNo);
    }
    
    public JButton getButtonYes() {
        return this.buttonYes;
    }

    public JButton getButtonNo() {
        return this.buttonNo;
    }
    
    public View getView() {
        return this.view;
    }
}