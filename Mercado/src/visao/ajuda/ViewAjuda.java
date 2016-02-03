package visao.ajuda;

import controller.visao.ajuda.ControllerViewAjuda;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda no Sistema.</p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 */
public abstract class ViewAjuda extends ViewModal {
    private JButton buttonOk;

    public ViewAjuda(ViewModal oView) {
        super(oView);
        this.controller = new ControllerViewAjuda(this);
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Ajuda");
        this.setSize(320, 360);
        this.setLocation(450, 190);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    private void addHeader() {
        this.addLinhas(1);
        this.add(new JLabel(new ImageIcon(getClass().getResource("/images/ajuda/ajuda.jpg"))));
        this.addLinhas(1);
    }
    
    protected abstract void addComponents();

    private void addButtons() {
        this.addLinhas(1);
        this.buttonOk = this.createButton("   Ok   ", "ok.jpg");
        this.add(this.buttonOk);
    }
    
    public JButton getButtonOk() {
        return this.buttonOk;
    }
}