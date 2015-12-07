package visao.sistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.InterfaceView;
import visao.View;
import visao.ViewModal;
import controller.visao.sistema.ControllerViewSistemaLogoff;
import visao.estruturais.ViewMenu;

/**
 * <p>Classe responsavel por definir a Interface do Logoff do Sistema.</p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * @author  Rafael
 * @version 1.0
 * @since   14/10/2015
 */
public final class ViewSistemaLogoff extends ViewModal implements InterfaceView {
    private       JButton buttonYes;
    private       JButton buttonNo;
    private final View    view;

    /**
     * <p>Metodo construtor da classe.</p>
     * <p>Recebe como parametro a ViewMenu.</p>
     * @param oView View Menu.
     */
    public ViewSistemaLogoff(ViewMenu oView) {
        super(oView);
        this.view = oView;
        this.controller = new ControllerViewSistemaLogoff(this);
        this.initComponents();
    }
    
    @Override
    public void initComponents() {
        this.setTitle("Mercado - Logoff");
        this.setSize(300, 225);
        this.setLocation(450, 270);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addLinhas(1);
        this.add(new JLabel(new ImageIcon(getClass().getResource("/images/sistema/logoff.jpg"))));
        this.addLinhas(1);
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Deseja realmente fazer Logoff?"));
        this.addLinhas(1);
    }

    @Override
    public void addButtons() {
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