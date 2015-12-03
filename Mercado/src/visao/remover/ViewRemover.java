package visao.remover;

import funct.FunctFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import visao.ViewModal;
import visao.consulta.ViewConsulta;

/**
 * Classe responsavel por definir a Interface de Remocao do Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   30/10/2015
 */
public abstract class ViewRemover extends ViewModal {
    private final ViewConsulta viewConsulta;
    private       JButton      buttonYes;
    private       JButton      buttonNo;

    public ViewRemover(ViewConsulta oView) {
        super(oView);
        this.viewConsulta = oView;
        this.setSettings();
    }
    
    private void setSettings() {
        this.setSize(400, 150);
        this.setLocation(395, 290);
    }
    
    protected void addComponents(String sMensagem) {
        this.addLinhas(1);
        
        this.add(new JLabel(new FunctFrame().createImage("buttons/erro.jpg")));
        this.add(new JLabel("Confirma exclusão: " +  sMensagem + "?"));
        
        this.addLinhas(1);
        
        this.buttonYes = this.createButton("   Sim   ", "yes.jpg");
        this.buttonNo  = this.createButton("   Não   ", "no.jpg");
        
        this.add(this.buttonYes);
        this.add(this.buttonNo);
    }

    public JButton getButtonYes() {
        return this.buttonYes;
    }

    public JButton getButtonNo() {
        return this.buttonNo;
    }
    
    public ViewConsulta getViewConsulta() {
        return this.viewConsulta;
    }
}